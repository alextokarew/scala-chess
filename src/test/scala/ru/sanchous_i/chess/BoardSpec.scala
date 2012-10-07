package ru.sanchous_i.chess

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class BoardSpec extends FlatSpec with ShouldMatchers {

  "A board" should "have 64 fields" in {
    val board = new Board
    board.fields.size should be (64)
  }

}
