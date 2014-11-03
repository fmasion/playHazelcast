package playHazelcast.api

import play.api.Plugin
import com.hazelcast.core.{HazelcastInstance, Hazelcast, MembershipEvent, MembershipListener}
import com.hazelcast.config._
import play.api.Play
import play.api.Logger

class HazelcastPlugin(app: play.api.Application) extends Plugin {
  val log = Logger("playHazelcast.api.HazelcastPlugin")

  override def onStart() {
    log.info("Starting Hazelcast")
    val config = getConfig
    
    //Configure port
    app.configuration.getInt("hz.port").map{port =>
      log.info("Configured Port : "+ port)
      config.getNetworkConfig().setPort(port)
    }.orElse{
      log.info("Using default Port : "+ config.getNetworkConfig().getPort)
      None
    }
    
    //Configure licence key
    app.configuration.getString("hz.licenceKey").map{ key =>
      log.info("Using Licence Key : " + key )
      config.setLicenseKey(key)
    }
    
    val group = app.configuration.getString("hz.groupname").getOrElse("dev")
    val pass  = app.configuration.getString("hz.grouppassword").getOrElse("dev-pass")
    config.getGroupConfig().setName(group).setPassword(pass)
    
    //configApp1.getGroupConfig().setName("app1");
    //More configuration option ? wait'n see
    
	PlayHz.start(config)
  }
  
  override def onStop() {
	PlayHz.stop
	log.info("Hazelcast Stopped")
  }
  
  private[this] def getConfig:Config = {
    import java.io._
    val configString = app.configuration.getString("hz.configfile") getOrElse "conf/config.xml"
    val configPath = app.getExistingFile(configString)
    log.info("Using config file : " + configPath)
    configPath match {
      case Some(file) if (file.exists() && file.canRead()) => {
        val fis =new FileInputStream(file)
        new XmlConfigBuilder(fis).build() 
      }
      case _	=> new XmlConfigBuilder().build()
    }
  }

}


object PlayHz {
  
  private[this] var instance: Option[HazelcastInstance] = None
  
  private[api] def stop = instance foreach(_.getLifecycleService().shutdown())

  private[api] def start(config:Config) = {
	  instance = Option(Hazelcast.newHazelcastInstance(config))
  }
  
  def getInstance() = instance
  
}


