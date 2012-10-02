package ru.sanchous_i.chess

/**
 * Created with IntelliJ IDEA.
 * User: Sanchous_I
 * Date: 22.09.12
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
class Board {
  val fields = new Array[Array[(Field,Option[Piece])]](8)

  def endGame = false

  def possibleMoves(player:Color) = {
    Nil
  }

  private def figure(col:Int, color:Color) = col match {
    case 0|7 => Rook(color)
    case 1|6 => Knight(color)
    case 2|5 => Bishop(color)
    case 3 => Queen(color)
    case 4 => King(color)
  }

  private def initialPiece(col:Int,row:Int) = row match {
    case 0 => Some(figure(col,White))
    case 1 => Some(Pawn(White))
    case 6 => Some(Pawn(Black))
    case 7 => Some(figure(col,Black))
    case _ => None
  }

  for (row <- 0 to 7) {
    fields(row) = new Array[(Field,Option[Piece])](8)
    for (col <- 0 to 7) {
      fields(row)(col) = (Field(('a'+col).toChar,row+1),initialPiece(col,row))
    }
  }

  override def toString =
    (for (col <- fields)
      yield (for (field <- col)
        yield field._1.toString()+field._2.toString()).reduceLeft(_ + " " + _)).reduceLeft(_ + "\r\n" + _)
}
