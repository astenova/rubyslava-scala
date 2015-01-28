object Example2 {
  def main(args: Array[String]): Unit = {
    sealed trait User

    case class Admin(
                      name: String,
                      surname: String) extends User

    case class Employee(
                         name: String,
                         surname: String, age: Int) extends User

    case class Customer(
                         name: String,
                         surname: String,
                         isImportant: Boolean) extends User

    def getUserInfo(user: User) = user match {
      case Admin(name, surname) =>
        "admin: " + name + " " + surname

      case Employee(name, surname, age) =>
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
    println(getUserInfo(Admin("Peter","Smith")))
    println(getUserInfo(Employee("Martin","Brown", 35)))
    println(getUserInfo(Customer("John", "Meier", false)))
    println(getUserInfo(Customer("Ann", "Jones", true)))
    println
  }
}
