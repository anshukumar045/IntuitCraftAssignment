package com.anshu.intuit.ticTackToe

/**
 * The Game is to be played by two players
 * @param playerOne : Human/ Computer
 * @param playerTwo : Human/ Computer
 * @param winLength : Dimension of the board
 */
class TicTacToeGame (
      playerOne: MoveOnBoard[TicTacToeGameState],
      playerTwo: MoveOnBoard[TicTacToeGameState])(implicit winLength: Int){

  import Utility._

  /**
   * Method to play the game till
   * either of the player win or match is Draw
   */
 def play: Unit = {
    def helper(moveNumber: Int,players: Seq[MoveOnBoard[TicTacToeGameState]], game: TicTacToeGameState): TicTacToeGameState  = {
      game match {
        case g if g.isGameOver => g
        case g =>
          println(s"Player ${moveNumber % 2 + 1} makes move")
          println(display(game))
          helper(moveNumber+1, players.tail :+ players.head, players.head.move(g))
      }
    }
    helper(0, Seq(playerOne, playerTwo), TicTacToeGameState()) match {
      case g if g.playerOneWin =>  println(PlayerOneWins)
      case g if g.playerTwoWin =>  println(PlayerTwoWins)
      case _ => println(Draw)
    }
  }

  /**
   *
   * @param game : The current running game
   * @return current status of the Board
   */
  def display(game: TicTacToeGameState): String =
    (1 to winLength).map(row =>
      (1 to winLength).map(col => {
        val position = Position(row, col)
        if(game.playerOnePositions contains position) X
        else if(game.playerTwoPositions contains position) O
        else EmptyCell
      }).mkString).mkString("\n") + "\n"

}
