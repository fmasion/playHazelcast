package controllers

import play.api._
import play.api.mvc._
import playHazelcast.api.PlayHz

object Application extends Controller {
  
  def index = Action {
    val instance = PlayHz.getInstance
    instance.map(i=> {
       Ok("instances : " + i.getCluster().getMembers())
    }).getOrElse(Ok("pas d'instance d'Hazelcast"))
  }
}