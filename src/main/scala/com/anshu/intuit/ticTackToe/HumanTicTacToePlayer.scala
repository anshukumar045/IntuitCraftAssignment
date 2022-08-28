package com.anshu.intuit.ticTackToe

import scala.util.{Failure, Success, Try}

/**
 * PLayer as Human
 * Player is prompted to enter move
 */

class HumanTicTacToePlayer  extends MoveOnBoard[TicTacToeGameState] {
  import HumanTicTacToePlayer._
  import Utility._

  override def move(s: TicTacToeGameState): TicTacToeGameState = {
    val vertex = readInputVertex
    val position = Position(vertex(0), vertex(1))
    Try(s.makeMove(position)) match {
      case Success(value) => value
      case Failure(_: Throwable) =>
        println(invalidMove)
        move(s)
    }
  }
}

object HumanTicTacToePlayer {
  import Utility._
  private def readInputVertex: Array[Int] = {
    println(msgForInput)
    Try(scala.io.StdIn.readLine().split(",").map(_.toInt)) match {
      case Success(value) if value.length == 2 => value
      case Success(_) =>
        println(invalidMove)
        readInputVertex
      case Failure(_: Throwable) =>
        println(invalidMove)
        readInputVertex
    }
  }
}
