import wikipedia.WikipediaRanking

val sc = WikipediaRanking.sc

val data = WikipediaRanking.wikiRdd

val langs = List("Python", "C", "Scala", "C++")



def time[R](block: => R): R = {
  val t0 = System.nanoTime()
  val result = block    // call-by-name
  val t1 = System.nanoTime()
  println("Elapsed time: " + (t1 - t0) + "ns")
  result
}

WikipediaRanking.main(Array())

println(WikipediaRanking.timing)
