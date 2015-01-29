object Example3 {
  def main(args: Array[String]): Unit = {

    println("VARIABLE DEFINITION")
    val myList = List(123, "abc")
    val List(number, string) = myList
    println(number)
    println(string)
    println

    val head :: tail = myList
    println(head)
    println(tail.toString)
    println

    case class User(name: String, age: Int)
    val user =  User("michael", 29)
    val User(name, age) = user
    println(name)
    println(age)
    println

    println("FOR EXPRESSION")
    for((value, index) <- myList.zipWithIndex) {
      println("myList(" + index + ") with value " + value)
    }

    println
    println("HANDLING EXCEPTIONS")

    try {
      throw new NullPointerException
    } catch {
      case e: NullPointerException => println("null pointer")
      case e: IllegalArgumentException => println("match error")
      case e: Throwable => println("other exception")
    }

  }
}
