package playHazelcastClient.api


import play.api.Plugin
import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig
import play.api.Play
import play.api.Logger
import com.hazelcast.core.HazelcastInstance

class HazelcastClientPlugin(app: play.api.Application) extends Plugin {
  val log = Logger("HazelcastClientPlugin")
  val DEFAULT_HOST = List("127.0.0.1:5701")
  
  override def onStart() {
    val config = getConfig   
    PlayHzClient.start(config)
  }
  
  override def onStop() {
	PlayHzClient.stop
	log.error("Hazelcast Client Stopped")
  }
  
  
  def getConfig:ClientConfig = {
    val config = new ClientConfig
    
    val group = app.configuration.getString("hz.groupname").getOrElse("dev")
    val pass  = app.configuration.getString("hz.grouppassword").getOrElse("dev-pass")
    config.getGroupConfig().setName(group).setPassword(pass)
    
    val adresses = app.configuration.getStringList("hz.addresses") match {
      case Some(list) => scala.collection.JavaConversions.collectionAsScalaIterable(list).toList
      case None       => DEFAULT_HOST
    }

    adresses.foreach(config.addAddress(_))
    config
  }
 
}

object PlayHzClient {
  
  private[this] var instance: Option[HazelcastInstance] = None
  
  private[api] def stop = instance foreach(_.getLifecycleService().shutdown())

  private[api] def start(config: ClientConfig) = {
	  instance = Option(HazelcastClient.newHazelcastClient(config))
  }
  
  def getClient() = instance
  
}
