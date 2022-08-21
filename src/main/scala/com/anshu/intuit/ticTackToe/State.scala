package com.anshu.intuit.ticTackToe

/**
 * generate all possible states
 * it can be produced from the current
 * state of the game
 */
trait State [S <: State[S]]{
  def isGameOver: Boolean
  def playerOneWin: Boolean
  def playerTwoWin: Boolean
  def isPlayerOneTurn: Boolean
  def generateStats: Seq[S]

}
