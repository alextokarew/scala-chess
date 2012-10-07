package ru.sanchous_i.chess

object Game extends App {
  val board = new Board
  var player = White

  //TODO: refactor to tests
  board.move(Field('e',2),Field('e',4),White)
  println("e4 "+board.fields.get(Field('e',4)))
  board.move(Field('d',7),Field('d',5),White)
  println("d5 "+board.fields.get(Field('d',5)))
  board.move(Field('d',7),Field('d',5),Black)
  println("d5 "+board.fields.get(Field('d',5)))
  board.move(Field('d',8),Field('d',6),Black)
  println("d6 "+board.fields.get(Field('d',6)))
  board.move(Field('d',6),Field('d',5),Black)
  println("d5 "+board.fields.get(Field('d',5)))
  board.move(Field('e',4),Field('d',5),White)
  println("d5 "+board.fields.get(Field('d',5)))
}
