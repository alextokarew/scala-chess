package ru.sanchous_i.chess

import collection.immutable.Stream.cons

/**
 * Created with IntelliJ IDEA.
 * User: Sanchous_I
 * Date: 23.09.12
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
class Field (val col:Char, val row:Int) {

  def up(n:Int) = Field(col, row + n)
  def up:Field = this up 1
  def down(n:Int) = Field(col, row - n)
  def down:Field = this down 1
  def left(n:Int) = Field((col - n).toChar, row)
  def left:Field = this left 1
  def right(n:Int) = Field((col + n).toChar, row)
  def right:Field = this right 1

  override def toString = col.toString + row.toString
}

object Field {
  val cols = 'a' to 'h'
  val rows = 1 to 8
  val fieldCache = collection.mutable.Map[String,Field]()

  def apply(col:Char,row:Int) = {
    if ((rows contains row) && (cols contains col)) {
      fieldCache getOrElseUpdate(col.toString + row.toString,create(col,row))
    } else
      InvalidField
  }

  private def create(col:Char,row:Int) = new Field(col,row)
}

object InvalidField extends Field(0,0) {
  override def up(n: Int) = InvalidField
  override def down(n: Int) = InvalidField
  override def left(n: Int) = InvalidField
  override def right(n: Int) = InvalidField

  override def toString = "Invalid field"
}
