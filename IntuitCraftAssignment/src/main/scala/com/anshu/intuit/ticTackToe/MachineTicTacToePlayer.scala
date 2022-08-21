package com.anshu.intuit.ticTackToe

import scala.util.{Failure, Random, Success, Try}

/**
 * Player as Machine
 * Randomly selecting the Position from the available set of Positions
 */
class MachineTicTacToePlayer extends MoveOnBoard[TicTacToeGameState] {
  import Utility._

  override def move(s: TicTacToeGameState): TicTacToeGameState = {
    val all = s.availablePositions
    // TODO: Optimize the approach to select better position
    val pos = Random.shuffle(all).head
    Try(s.makeMove(pos)) match {
      case Success(value) => value
      case Failure(_ : Throwable) =>
        println(invalidMove)
        move(s)
    }
  }
}
