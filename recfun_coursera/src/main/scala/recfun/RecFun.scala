package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if ((c == 0) || (r == c)) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def iter(opened: Integer, chars: List[Char]): Boolean = {
      if (chars.isEmpty) opened == 0
      else chars.head match {
        case '(' => iter(opened + 1, chars.tail)
        case ')' => if (opened == 0) false else iter(opened - 1, chars.tail)
        case _ => iter(opened, chars.tail)
      }
    }
    iter(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def iter(acc: Int, money: Int, coins: List[Int]): Int = {
      if (acc == money) 1
      else if (coins.isEmpty) 0
      else if (acc > money) 0
      else iter(acc + coins.head, money, coins) + iter(acc, money, coins.tail)
    }

    iter(0, money, coins)
  }
}
