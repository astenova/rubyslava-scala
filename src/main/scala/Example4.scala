object Example4 {
  def main(args: Array[String]): Unit = {

    object Email {
      def apply(user: String, domain: String) = user +"@"+ domain

      def unapply(str: String): Option[(String, String)] = {
        val parts = str split "@"
        if (parts.length == 2) Some(parts(0), parts(1)) else None
      }
    }

    def getEmailAddress(address: String) = address match {
      case Email(user, domain) => user + " AT " + domain
      case _ => "no email address"
    }

    println("EMAIL ADDRESS EXTRACTOR")
    println(getEmailAddress("andrea.stenova@garwan.sk"))
    println(getEmailAddress("andrea.stenova"))


    case class Person(name: String, residence: Seq[Residence])
    case class Residence(city: String, country: String)

    object LivesIn {
      def unapply(p: Person): Option[Seq[String]] =
        Some(
          for(r <- p.residence)
          yield r.city
        )
    }

    class StringSeqContains(value: String) {
      def unapply(in: Seq[String]): Boolean =
        in contains value
    }

    val brezno = "Brezno"
    val bratislava = "Bratislava"
    val london = "London"

      val people =
        List(Person("Andrea",  List(Residence(bratislava, "SK"), Residence(brezno, "SK"))),
          Person("Martin",  List(Residence(bratislava, "SK"))),
          Person("John", List(Residence(brezno, "SK"),
            Residence(london, "UK"))),
          Person("Mary", List(Residence(london, "UK"))))

      val Bratislava = new StringSeqContains(bratislava)
      val Brezno = new StringSeqContains(brezno)
      val London = new StringSeqContains(london)

      def findPeople(people: List[Person], city: String, seqExtractor: StringSeqContains) : List[String] =
        people collect {
          case person @ LivesIn(seqExtractor()) => person.name + " lives in " + city
      }

      println
      println("OTHER EXTRACTORS")
      println(findPeople(people, bratislava, Bratislava).mkString(", "))
      println(findPeople(people, brezno, Brezno).mkString(", "))
      println(findPeople(people, london, London).mkString(", "))
  }
}