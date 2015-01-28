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
  }
}