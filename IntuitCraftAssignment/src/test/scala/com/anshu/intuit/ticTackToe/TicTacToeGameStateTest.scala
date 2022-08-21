package com.anshu.intuit.ticTackToe

import org.scalatest.funsuite.AnyFunSuite

class TicTacToeGameStateTest extends AnyFunSuite {
import TicTacToeGameStateTest._

  test("TicTacToeGameState.playerOneWin") {
    assert( game.playerOneWin == false)
  }

  test("TicTacToeGameState.playerTwoWin") {
    assert( game.playerTwoWin == false)

  }

  test("TicTacToeGameState.availablePositions") {
    val expected = Set(Position(1,1),Position(1,2),Position(2,1),Position(2,2))
    assert( game.availablePositions == expected)
  }

  test("TicTacToeGameState.isGameOver") {
    assert( game.isGameOver == false)
  }

  test("TicTacToeGameState.generateStats") {
    assert( game.generateStats.length == 4)
  }

  test("TicTacToeGameState.isPlayerOneTurn") {
    assert( game.isPlayerOneTurn == true)
  }

  test("TicTacToeGameState.makeMove()") {
    val expected = Set(Position(1,2),Position(2,1),Position(2,2))
    assert( game.makeMove(Position(1,1)).availablePositions == expected)
  }

  test("TicTacToeGameState.checkWin is after taking position on board") {
    assert( game.checkWin(Set(Position(1,1))) == false)
  }

  test("TicTacToeGameState.checkWin() returns true if the game is won left diagonally") {
    implicit val winLength =3
    val game = TicTacToeGameState()
    assert(game.checkWin(Set(Position(1,1), Position(2,2), Position(3,3))) == true)
  }

  test("TicTacToeGameState.checkWin() returns true if the game is won right diagonally") {
    implicit val winLength =3
    val game = TicTacToeGameState()
    assert(game.checkWin(Set(Position(1,3), Position(2,2), Position(3,1))) == true)
  }

  test("TicTacToeGameState.checkWin() returns true if the game is won column") {
    implicit val winLength =3
    val game = TicTacToeGameState()
    assert(game.checkWin(Set(Position(1,1), Position(1,2), Position(1,3))) == true)
  }

  test("checkWin() returns true if the game is won row") {
    implicit val winLength =3
    val game = TicTacToeGameState()
    assert(game.checkWin(Set(Position(1,1), Position(2,1), Position(3,1))) == true)
  }

  test("checkWin() returns true if the game is won column") {
    implicit val winLength =3
    val game = TicTacToeGameState()
    assert(game.checkWin(Set(Position(1,1), Position(1,2), Position(1,3))) == true)
  }

}

object TicTacToeGameStateTest{
  implicit val winLength = 2
  val game = TicTacToeGameState()
}
