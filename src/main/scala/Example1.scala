object Example1 {
  def main(args: Array[String]): Unit = {

    // CONSTANTS
    def describe(x: Any) = x match {
      case 5 => "five"
      case true => "truth"
      case "hello" => "hi!"
      case Nil => "the empty list"
      case _ => "something else"
    }

    println
    println("CONSTANTS")
    println
    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(false))
    println

    def isZero(expr: Any) = expr match {
      case 0 => "zero"
      case somethingElse => "not zero: "+ somethingElse
    }

    println("VARIABLES")
    println
    println(isZero(0))
    println(isZero(1))
    println(isZero(0.0))            // Double conversion
    println(isZero(BigDecimal(0)))  // BigDecimal conversion
    println(isZero(false))
    println

    def listFun(list: Any) = list match {
      case List(0, _, _) =>
        list + " starts with 0 and has 3 elements"

      case List(_, a: String) =>
        list + " ends with string: " + a + " and has 2 elements"

      case List(0, _*) =>
        list + " starts with 0"

      case _ : List[Any] =>
        list + " is random list"

      case x =>
        x + " is not a list"
    }

    println("LISTS")
    println
    println(listFun(List(1, 2, 3)))
    println(listFun(List(0, 2, 3)))
    println(listFun(List(1, "hello")))
    println(listFun(List(0, 2)))
    println(listFun(1))
    println

    def recursion(list: List[Int]) : Unit = list match {      // need result type
      case head :: tail => {
        println(head)
        recursion(tail)
      }
      case Nil => println("end")
    }

    recursion(List(1, 2, 3))
    println
    recursion(List())
    println
    recursion(List(1, 2, 3, 4, 5))
    println

  }
}
