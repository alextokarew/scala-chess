package ru.sanchous_i.chess

import collection.mutable

class Board {
  val fields = new mutable.HashMap[Field,Piece]

  def endGame = false

  def possibleMoves(player:Color) = {
    Nil
  }


  private def initialPiece(col:Char,row:Int) = {
    def figure(col:Char, color:Color) = col match {
      case 'a'|'h' => Rook(color)
      case 'b'|'g' => Knight(color)
      case 'c'|'f' => Bishop(color)
      case 'd' => Queen(color)
      case 'e' => King(color)
    }

    row match {
      case 1 => figure(col,White)
      case 2 => Pawn(White)
      case 7 => Pawn(Black)
      case 8 => figure(col,Black)
    }
  }

  for (row <- List(1,2,7,8))
    for (col <- Field.cols)
      fields put (Field(col,row),initialPiece(col,row))

  override def toString = fields.toString()
}
