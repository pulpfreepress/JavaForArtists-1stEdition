/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

package chap16.race;

public final class LongSetter {
  private long x;

  public boolean set(long xval) {
    x = xval;
    return (x == xval);
  }
}