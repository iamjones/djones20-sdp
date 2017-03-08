package me.rerun.akkanotes.messaging.logtest2

import scala.util.Random

import akka.actor.Actor
import akka.actor.ActorLogging
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.QuoteRequest
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.QuoteResponse

/*
 * Teacher with Logging
 * 
 */

class TeacherLogActor extends Actor with ActorLogging {

   val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case QuoteRequest => {

      import util.Random

      //get a random element (for now)
      val quoteResponse=QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString())

      //log.info("Quote printed") //This message is just to assert from the testcase      

    }

  }
      
  def quoteList=quotes

}