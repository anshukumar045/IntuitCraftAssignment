package com.anshu.intuit.ticTackToe

import scala.util.{Failure, Success, Try}

/**
 * Utility Methods, traits and Objects
 */
object Utility{

  private[ticTackToe] val invalidMove = "Invalid Move"
  private[ticTackToe] val msgForInput = s"Input Row and Column as - row,column"
  private[ticTackToe] val inputMsg = "Please enter the dimension for the game  >= 2"
  private val errorMsg = "Invalid value for Dimension of TicTacToe Game"
  private def successMsg(value: Int): String = {
    s"""
       |The TicTacToe Game is created for $value x $value Dimension
       |Enter the Row in the Range od 1 to $value
       |Enter the Column in the Range od 1 to $value
       |""".stripMargin
  }

  private[ticTackToe] def initializeGame: Int = {
    Try(scala.io.StdIn.readInt()) match {
      case Success(value) =>
        if(value < 2) {
          println(inputMsg)
          initializeGame
        } else {
          println(successMsg(value))
          value
        }
      case Failure(_: Throwable) =>
        println(errorMsg)
        println(inputMsg)
        initializeGame
    }
  }

  sealed trait CellValue
  case object X extends CellValue {
    override def toString: String = "| X |"
  }

  case object O extends CellValue {
    override def toString: String = "| O |"
  }

  case object EmptyCell extends CellValue {
    override def toString: String = "|__|"
  }

  sealed trait Outcome
  case object PlayerOneWins extends Outcome{
    override def toString: String = "Player One Wins!"
  }

  case object PlayerTwoWins extends Outcome{
    override def toString: String = "Player Two Wins!"
  }

  case object Draw extends Outcome{
    override def toString: String = "!!DRAW!!"
  }

}

