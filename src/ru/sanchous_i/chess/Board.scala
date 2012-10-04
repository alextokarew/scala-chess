package ru.sanchous_i.chess

import collection.mutable

class Board {
  val fields = new mutable.HashMap[Field,Piece]

  def move(from:Field, to:Field, color:Color) : Boolean = {
    val piece = fields get from
    val destination = fields get to

    def hasPiece = piece match {
      case Some(Piece(pieceColor)) => pieceColor == color
      case _ => false
    }

    def correctDestination = destination match {
      case None => true
      case Some(Piece(pieceColor)) => pieceColor != color
      case _ => false
    }

    def pieceCanMove = piece.canMove(from,to)

    val checks = List(hasPiece _, correctDestination _, pieceCanMove _)

    def canMove(i : Int) : Boolean =
      if (i >= checks.length) true
      else if (checks(i)()) canMove(i + 1)
      else false

    if (canMove(0)) {
      doMove(from,to,piece)
      true
    }
    false
  }

  private def doMove(from:Field,to:Field,piece:Piece) {
    fields remove from
    fields put (to,piece.get)
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
