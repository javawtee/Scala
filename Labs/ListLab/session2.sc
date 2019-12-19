/*
*		Thong Le - 011922131
*		Cs152-2- Assignment 4 - List Processing II
*/
object session2 {
  println("Welcome to the Scala List Processing II")
                                                  //> Welcome to the Scala List Processing II
  	
 		import scala.collection.mutable.ListBuffer
 /*
 problem 1: score processing
 */
 		var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0))
                                                  //> cs152  : List[List[Double]] = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 
                                                  //| 68.0), List(88.0, 82.0, 78.0))
 		
 		// avg
 		def avg(scores: List[Double]): Double = scores.reduce(_ + _) / scores.size
                                                  //> avg: (scores: List[Double])Double
 		
 		// avgAvg
 		def avgAvg(scores: List[List[Double]]): List[Double] = scores.map(avg)
                                                  //> avgAvg: (scores: List[List[Double]])List[Double]
 		
 		// passing
 		def passing(scores: List[List[Double]]): List[Int] =	{
 			var newList = ListBuffer[Int]()
 			for(e <- scores)
 				if(avg(e) >= 70.0) {
 					newList += (scores.indexOf(e) +1)
 				}
 			newList.toList
 		}                                 //> passing: (scores: List[List[Double]])List[Int]
 		
 		// sumSums
 		def sums(l: List[Double]):Double = { var sum = 0.0; for(e <- l) sum += e; sum}
                                                  //> sums: (l: List[Double])Double
  	def sumSums(scores: List[List[Double]]):Double = scores.map(sums).reduce(_ + _)
                                                  //> sumSums: (scores: List[List[Double]])Double
  	
  	// test
  	avg(cs152.head)                           //> res0: Double = 90.66666666666667
  	avgAvg(cs152)                             //> res1: List[Double] = List(90.66666666666667, 73.0, 82.66666666666667)
 		passing(cs152)                    //> res2: List[Int] = List(1, 2, 3)
  	sumSums(cs152)                            //> res3: Double = 739.0
  	
 /*
problem 2: spell check
*/
 		val doc = List("abbb", "sadf", "ss", "erew", "asdfasdf")
                                                  //> doc  : List[String] = List(abbb, sadf, ss, erew, asdfasdf)
 		val dict = List("ss", "sfasdf", "qwer", "zzz")
                                                  //> dict  : List[String] = List(ss, sfasdf, qwer, zzz)
 
 		def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
 			var diff = ListBuffer[String]()
 			for(w <- doc) if(!dictionary.contains(w)) diff += w
 			diff.toList
 		}                                 //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
 		
 		//test
 		spellCheck(doc, dict)             //> res4: List[String] = List(abbb, sadf, erew, asdfasdf)
 		
 /*
 problem 3: spell check using map, filter, etc.
 */
 
 		def spellCheck2(doc: List[String], dictionary: List[String]): List[String] =
 			doc.filter(!dictionary.contains(_))
                                                  //> spellCheck2: (doc: List[String], dictionary: List[String])List[String]
 		//test
 		spellCheck2(doc, dict)            //> res5: List[String] = List(abbb, sadf, erew, asdfasdf)
 		
 /*
 problem 4: monomial, polynomial evaluation
 */
 		def evalMono(mono: (Double, Double), x: Double): Double = {
 				def helper(exp: Double):Double = if(exp == 0.0) 1.0 else x * helper(exp - 1)
 				mono._1 * helper(mono._2)
 		}                                 //> evalMono: (mono: (Double, Double), x: Double)Double
 		
 		// or implement using math.power
 		def evalMono2(mono: (Double, Double), x: Double): Double =
 			mono._1 * math.pow(x, mono._2)
                                                  //> evalMono2: (mono: (Double, Double), x: Double)Double
 		
 		def evalPoly(poly: List[(Double, Double)], x: Double): Double = poly.map(evalMono(_, x)).reduce(_ + _)
                                                  //> evalPoly: (poly: List[(Double, Double)], x: Double)Double
 		
 		// or using evalMono2
 		def evalPoly2(poly: List[(Double, Double)], x: Double): Double = poly.map(evalMono2(_, x)).reduce(_ + _)
                                                  //> evalPoly2: (poly: List[(Double, Double)], x: Double)Double
 		
 		//test
 		evalMono((3.0, 2.0), 2.0)         //> res6: Double = 12.0
 		evalMono((5.0, 0.0), 2.0)         //> res7: Double = 5.0
 		evalMono2((3.0, 2.0), 2.0)        //> res8: Double = 12.0
 		evalPoly(List((3.0, 2.0), (5.0, 0.0)), 2.0)
                                                  //> res9: Double = 17.0
		evalPoly2(List((3.0, 2.0), (5.0, 0.0)), 2.0)
                                                  //> res10: Double = 17.0
}