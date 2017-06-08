import scala.collection.JavaConverters._

import org.apache.flink.api.java.ClosureCleaner

object MWE extends App {

  val m4j: java.util.Map[String,String] = new java.util.HashMap
  m4j.put("key1", "value1")
  val m: java.util.Map[String,String] = Map(
    "key1" -> "value1"
  ).asJava

  println("Cleaning native Java map")
  ClosureCleaner.clean(m4j, true)

  println("Cleaning map converted by JavaConverters")
  ClosureCleaner.clean(m, true)
}
