package ru.sanchous_i.chess

sealed abstract case class Piece(color: Color) {
  def canMove(from: Field, to: Field) = false
}

case class Pawn(override val color: Color) extends Piece(color)
case class Rook(override val color: Color) extends Piece(color)
case class Knight(override val color: Color) extends Piece(color)
case class Bishop(override val color: Color) extends Piece(color)
case class Queen(override val color: Color) extends Piece(color)
case class King(override val color: Color) extends Piece(color)