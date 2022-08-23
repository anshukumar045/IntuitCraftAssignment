package com.anshu.intuit.ticTackToe

import scala.util.Random

/**
 * Player as Machine
 * Randomly selecting the Position from the available set of Positions
 */
class MachineTicTacToePlayer extends MoveOnBoard[TicTacToeGameState] {

  override def move(s: TicTacToeGameState): TicTacToeGameState = {
    val all = s.availablePositions
    // TODO: Optimize the approach to select better position
    val pos = Random.shuffle(all).head
    s.makeMove(pos)
  }
}
