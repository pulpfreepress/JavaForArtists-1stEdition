/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.pi;

import java.math.BigInteger;

public class PiSpigot {
  private static final BigInteger zero = BigInteger.ZERO;
  private static final BigInteger one = BigInteger.ONE;
  private static final BigInteger two = BigInteger.valueOf(2);
  private static final BigInteger three = BigInteger.valueOf(3);
  private static final BigInteger four = BigInteger.valueOf(4);
  private static final BigInteger ten = BigInteger.valueOf(10);

  private BigInteger q = one;
  private BigInteger r = zero;
  private BigInteger t = one;
  private BigInteger k = one;
  private BigInteger n = zero;

  public int nextDigit() {
    while (true) {
      n = three.multiply(q).add(r).divide(t);
      if (four.multiply(q).add(r).divide(t).equals(n)) {
        q = ten.multiply(q);
        r = ten.multiply(r.subtract(n.multiply(t)));
        return n.intValue();
      } else {
        BigInteger temp_q = q.multiply(k);
        BigInteger temp_2k_plus_1 = two.multiply(k).add(one);
        BigInteger temp_r = two.multiply(q).add(r).multiply(temp_2k_plus_1);
        BigInteger temp_t = t.multiply(temp_2k_plus_1);
        BigInteger temp_k = k.add(one);
        q = temp_q;
        r = temp_r;
        t = temp_t;
        k = temp_k;
      }
    }
  }
}