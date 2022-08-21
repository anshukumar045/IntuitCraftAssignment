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

  private var players = Seq(playerOne, playerTwo)
  private var game: TicTacToeGameState = TicTacToeGameState()

  /**
   * Method to play the game till
   * either of the player win or match is Draw
   */
  def play: Unit = {
    var moveNumber = 0
    println(display(game))
    while(!game.isGameOver) {
      println(s"Player ${moveNumber % 2 + 1} makes move")
      val player = players.head
      game = player.move(game)
      println(display(game))
      players = players.tail :+ player
      moveNumber += 1
    }
    if(game.playerOneWin) println(PlayerOneWins)
    else if(game.playerTwoWin) println(PlayerTwoWins)
    else println(Draw)
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
