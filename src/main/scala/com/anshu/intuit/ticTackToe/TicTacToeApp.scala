package com.anshu.intuit.ticTackToe

import scala.util.Try

/**
 * The Tic Tac Toe game can be played as
 * Human vs Human
 * Machine vs Human
 * Human vs Machine
 * Game stops on either the PLayer has Won or Match Draw
 */
object TicTacToeApp extends App{
  import Utility._

  println(inputMsg)
  implicit var dimension = initializeGame
  val game = new TicTacToeGame(
    new HumanTicTacToePlayer(),
    new MachineTicTacToePlayer()
  )

  game.play

}
