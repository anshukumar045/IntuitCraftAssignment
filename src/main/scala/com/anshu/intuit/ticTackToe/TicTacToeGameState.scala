package com.anshu.intuit.ticTackToe

/** Position of the player on the board */
case class Position(row: Int, col: Int)

/**
 *
 * @param playerOnePositions : All the Positions taken by PLayer One. Initially Seq()
 * @param playerTwoPositions : All the Positions taken by PLayer Two. Initially Seq()
 * @param availablePositions : All the available Position
 * @param isPlayerOneTurn : Players Turn
 * @param winLength : Dimension of the Board
 */
class TicTacToeGameState(
  val playerOnePositions: Set[Position],
  val playerTwoPositions: Set[Position],
  val availablePositions: Set[Position],
  val isPlayerOneTurn: Boolean)(implicit winLength: Int) extends State[TicTacToeGameState] {
  import TicTacToeGameState._

  // Check if the game is over
    override def isGameOver: Boolean =
      availablePositions.isEmpty || playerOneWin || playerTwoWin

  // Check if PLayer One Wins
    override def playerOneWin: Boolean = checkWin(playerOnePositions)

  // Check if PLayer Two Wins
    override def playerTwoWin: Boolean = checkWin(playerOnePositions)

  // generate the status of the position
    override def generateStats: Seq[TicTacToeGameState] =
      for(pos <- availablePositions.toSeq) yield makeMove(pos)

  // Check if game is won
    private[ticTackToe] def hasWon(step: StepGenerator)(positions: Set[Position]): Boolean =
    positions exists(position =>
      (0 until winLength) forall( offset =>
        positions contains step(position,offset))
      )

  // Check which player won
    private[ticTackToe] def checkWin(position: Set[Position]): Boolean =
    direction.exists(hasWon(_)(position))

  // players make move
    private[ticTackToe] def makeMove(position: Position): TicTacToeGameState ={
    assert(availablePositions.contains(position))
    if(isPlayerOneTurn)
      new TicTacToeGameState(
        playerOnePositions + position,
        playerTwoPositions ,
        availablePositions - position,
        !isPlayerOneTurn
      )
    else new TicTacToeGameState(
      playerOnePositions,
      playerTwoPositions + position,
      availablePositions - position,
      !isPlayerOneTurn
    )
  }
}

object TicTacToeGameState {
  type StepGenerator = (Position, Int) => Position
  final val direction = Seq(leftDiagonal,rightDiagonal,row,column)

  def apply()(implicit winLength: Int): TicTacToeGameState =
    new TicTacToeGameState(
      Set(), Set(),
      (for{row <- 1 to winLength
           col <- 1 to winLength} yield Position(row,col)).toSet,
      true
    )

  // below methods are used to validate the win
  private def leftDiagonal: StepGenerator =
    (pos, offset) => Position(pos.row + offset, pos.col + offset)

  private def rightDiagonal: StepGenerator =
    (pos,offset) => Position(pos.row - offset, pos.col + offset)

 private  def row: StepGenerator =
    (pos, offset) => Position(pos.row + offset, pos.col)

  private def column : StepGenerator =
    (pos, offset) => Position(pos.row, pos.col + offset)

}
