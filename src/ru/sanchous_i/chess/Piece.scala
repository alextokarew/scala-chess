package ru.sanchous_i.chess

/**
 * Created with IntelliJ IDEA.
 * User: Sanchous_I
 * Date: 23.09.12
 * Time: 12:10
 * To change this template use File | Settings | File Templates.
 */
sealed abstract class Piece(val color: Color) {

}

case class Pawn(override val color: Color) extends Piece(color)
case class Rook(override val color: Color) extends Piece(color)
case class Knight(override val color: Color) extends Piece(color)
case class Bishop(override val color: Color) extends Piece(color)
case class Queen(override val color: Color) extends Piece(color)
case class King(override val color: Color) extends Piece(color)