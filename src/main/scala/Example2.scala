object Example2 {
  def main(args: Array[String]): Unit = {

    trait User {
      def name: String
      def surname: String
    }

    case class Admin(name: String, surname: String) extends User

    case class Employee(name: String, surname: String, age: Int, child: Option[User]) extends User

    case class Customer(name: String, surname: String, isImportant: Boolean) extends User

    def getUserInfo(user: User) = user match {
      case Admin(name, surname) =>
        "admin: " + name + " " + surname

      case Employee(name, surname, age, _) =>
        "employee: " + name + " " + surname + " with age " + age

      //case Customer(name, surname, importance) =>
      //  "customer: " + name + " " + surname

      case Customer(name, surname, true) =>
        "important customer: " + name + " " + surname

      case Customer(name, surname, false) =>
        "regular customer: " + name + " " + surname
    }

    println("CLASSES")
    println
    val admin = Admin("Peter","Smith")
    val employee = Employee("Martin","Brown", 18, None)
    val customer1 = Customer("John", "Meier", false)
    val customer2 = Customer("Ann", "Jones", true)
    println(getUserInfo(admin))
    println(getUserInfo(employee))
    println(getUserInfo(customer1))
    println(getUserInfo(customer2))
    println

    def getOptionUserInfo(userOpt: Option[User]) = userOpt match {
      case Some(user) => getUserInfo(user)
      case None => "no user"
    }

    println("OPTION")
    println
    val parent1 = Employee("Jane", "Jones", 58, Some(admin))
    val parent2 = Employee("Adam", "White", 25, None)
    println(getOptionUserInfo(parent1.child))
    println(getOptionUserInfo(parent2.child))
    println

    def checkChild(user: User) = user match {
      case Employee(name, surname, age, None) if age <= 18 => "too young to have child"
      case Employee(name, surname, age, Some(a @ Admin(_, _))) => "employee with child admin: " + a
      case Employee(name, surname, age, None) => "childless employee"
      case _ => "other user"
    }

    println("DEEP MATCHES, PATTERN GUARDS")
    println
    println(checkChild(employee))
    println(checkChild(parent1))
    println(checkChild(parent2))
    println(checkChild(admin))
    println
  }
}
