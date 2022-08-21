package com.anshu.intuit.ticTackToe

import scala.util.{Failure, Success, Try}

/**
 * PLayer as Human
 * Player is prompted to enter move
 */
class HumanTicTacToePlayer  extends MoveOnBoard[TicTacToeGameState] {
  import Utility._

  override def move(s: TicTacToeGameState): TicTacToeGameState = {
    println(msgForInput)
    val vertex = scala.io.StdIn.readLine().split(",")
    val position = Position(vertex(0).toInt, vertex(1).toInt)
    Try(s.makeMove(position)) match {
      case Success(value) => value
      case Failure(_: Throwable) =>
        println(invalidMove)
        move(s)
    }
  }
}
