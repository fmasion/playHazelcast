package playHazelcastClient.api


import play.api.Plugin
import com.hazelcast.client.{ClientConfig, HazelcastClient}
import play.api.Play
import java.util.ArrayList
import play.api.Logger

class HazelcastClientPlugin extends Plugin {
  
  private var instance: Option[HazelcastClient] = None
  
  override def onStart() {
    val log = Logger("HazelcastClientPlugin")
    val config = getConfig   
    instance = Option(HazelcastClient.newHazelcastClient(config))
    
    import scala.collection.JavaConversions._
    instance foreach{hz =>
       val mems = hz.getCluster().getMembers()
       mems.foreach(mem => log.info("" + mem))
    }
  }
  
  override def onStop() {
	 instance foreach(_.getLifecycleService().shutdown())
  }
  
  
  def getClient() = instance
  
  
  def getConfig:ClientConfig = {
    val config = new ClientConfig
    val address = Play.current.configuration.getString("hz.address") getOrElse "127.0.0.1:5701"
    config.addAddress(address)
    config
  }
  

}

