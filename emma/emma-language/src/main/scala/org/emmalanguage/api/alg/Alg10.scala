/*
 * Copyright © 2014 TU Berlin (emma@dima.tu-berlin.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.emmalanguage
package api.alg

// !!! DO NOT MODIFY - SOURCE FILE GENERATED BY `tools/generate_alg_products.py` !!!

//@formatter:off

case class Alg10[A,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10]
(
  alg1: Alg[A,B1],
  alg2: Alg[A,B2],
  alg3: Alg[A,B3],
  alg4: Alg[A,B4],
  alg5: Alg[A,B5],
  alg6: Alg[A,B6],
  alg7: Alg[A,B7],
  alg8: Alg[A,B8],
  alg9: Alg[A,B9],
  alg10: Alg[A,B10]
) extends Alg[A,(B1,B2,B3,B4,B5,B6,B7,B8,B9,B10)] {
  type B = (B1,B2,B3,B4,B5,B6,B7,B8,B9,B10)
  val zero: B = (
    alg1.zero,
    alg2.zero,
    alg3.zero,
    alg4.zero,
    alg5.zero,
    alg6.zero,
    alg7.zero,
    alg8.zero,
    alg9.zero,
    alg10.zero
  )
  val init: A => B = (x: A) => (
    alg1.init(x),
    alg2.init(x),
    alg3.init(x),
    alg4.init(x),
    alg5.init(x),
    alg6.init(x),
    alg7.init(x),
    alg8.init(x),
    alg9.init(x),
    alg10.init(x)
  )
  val plus: (B,B) => B = (x: B, y: B) => (
    alg1.plus(x._1, y._1),
    alg2.plus(x._2, y._2),
    alg3.plus(x._3, y._3),
    alg4.plus(x._4, y._4),
    alg5.plus(x._5, y._5),
    alg6.plus(x._6, y._6),
    alg7.plus(x._7, y._7),
    alg8.plus(x._8, y._8),
    alg9.plus(x._9, y._9),
    alg10.plus(x._10, y._10)
  )
}

//@formatter:on
