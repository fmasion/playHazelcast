package controllers

import play.api._
import play.api.mvc._
import playHazelcast.api.PlayHz
import playHazelcastClient.api.PlayHzClient

object Application extends Controller {
  
  def index = Action {
    val instance = PlayHz.getInstance
    val client   = PlayHzClient.getClient
    val opt = for(i <-instance;c <-client) yield (i,c) 
    
    opt.map(p => {
       Ok("instances : " + p._1.getCluster().getMembers() + "\n" + "client : " + p._2.getCluster().getMembers())
    }).getOrElse(Ok("pas d'instance ou de client d'Hazelcast"))
  }
}