package com.anshu.intuit.ticTackToe

/**
 * Moves on the Board
 * This trait can be used to add features to board
 * This trait is used as create the Players
 */
trait MoveOnBoard [S <: State[S]]{
  def move(s: S): S
}
