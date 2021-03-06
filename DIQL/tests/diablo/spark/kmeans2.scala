import edu.uta.diql._
import org.apache.spark._
import org.apache.spark.rdd._
import Math._

object Test {

  def main ( args: Array[String] ) {
    val conf = new SparkConf().setAppName("Test")
    val sc = new SparkContext(conf)

    explain(true)

    var P = sc.textFile(args(0))
              .zipWithIndex.map{ case (line,i)
                                   => { val a = line.split(",")
                                        (i.toLong,(a(0).toDouble,a(1).toDouble)) } }

    var C = sc.textFile(args(1))
              .zipWithIndex.map{ case (line,i)
                                   => { val a = line.split(",")
                                        (i.toLong,(a(0).toDouble,a(1).toDouble)) } }.collect()

    def distance ( x: (Double,Double), y: (Double,Double) ): Double
      = pow(x._1-y._1,2)+pow(x._2-y._2,2)

    case class ArgMin ( index: Long, distance: Double ) {
      def ^ ( x: ArgMin ): ArgMin
        = if (distance <= x.distance) this else x
    }

    case class Avg ( sum: (Double,Double), count: Long ) {
      def ^^ ( x: Avg ): Avg
        = Avg((sum._1+x.sum._1,sum._2+x.sum._2),count+x.count)
      def value(): (Double,Double)
        = (sum._1/count,sum._2/count)
    }

    val K = C.length
    val N = P.count()

    var avg = (1 to K).map{ i => (i.toLong-1,Avg((0.0,0.0),0)) }.toArray

    v(sc,"""
     var closest: vector[ArgMin] = vector();

     var steps: Int = 0;
     while (steps < 10) {
        steps += 1;
        for i = 0, N-1 do {
            closest[i] := ArgMin(0,10000.0);
            for j = 0, K-1 do
                closest[i] := closest[i] ^ ArgMin(j,distance(P[i],C[j]));
            avg[closest[i].index] := avg[closest[i].index] ^^ Avg(P[i],1);
        };
        for i = 0, K-1 do
            C[i] := avg[i].value();
     };

     C.foreach(println);

     """)

  }
}
