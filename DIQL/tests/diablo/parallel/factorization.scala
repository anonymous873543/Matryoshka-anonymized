import edu.uta.diql._
import scala.io.Source
import scala.collection.parallel.ParIterable
import Math._

object Test {

  def main ( args: Array[String] ) {

    explain(true)

    val n = args(1).toLong
    val m = args(2).toLong
    val l = args(3).toLong

    var R = Source.fromFile(args(0)).getLines
              .map( line => { val a = line.split(",")
                              ((a(0).toLong,a(1).toLong),a(2).toDouble) } ).toIterable.par

    v("""

      var P: matrix[Double] = matrix();
      var Q: matrix[Double] = matrix();
      var pq: matrix[Double] = matrix();
      var E: matrix[Double] = matrix();

      var a: Double = 0.002;
      var b: Double = 0.02;

      for i = 0, n-1 do
          for k = 0, l-1 do
              P[i,k] := random();

      for k = 0, l-1 do
          for j = 0, m-1 do
              Q[k,j] := random();

      var steps: Int = 0;
      while ( steps < 10 ) {
        steps += 1;
        for i = 0, n-1 do
            for j = 0, m-1 do {
                pq[i,j] := 0.0;
                for k = 0, l-1 do
                    pq[i,j] += P[i,k]*Q[k,j];
                E[i,j] := R[i,j]-pq[i,j];
                for k = 0, l-1 do {
                    P[i,k] += a*(2*E[i,j]*Q[k,j]-b*P[i,k]);
                    Q[k,j] += a*(2*E[i,j]*P[i,k]-b*Q[k,j]);
                };
            };
      };

      P.take(30).foreach(println);
      Q.take(30).foreach(println);
    """)

  }
}
