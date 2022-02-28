/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

import java.io.*;

public class Histogram {
  public static void main(String[] args){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    int letter_frequencies[] = new int[26];
    final int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6,
              H = 7, I = 8, J = 9, K = 10, L = 11, M = 12, N = 13,
              O = 14, P = 15, Q = 16, R = 17, S = 18, T = 19, U = 20,
              V = 21, W = 22, X = 23, Y = 24, Z = 25;
    String input_string = null;

    System.out.print("Enter a line of characters: ");
    try {
        input_string = console.readLine().toUpperCase();
        } catch(IOException ioe) { System.out.println("Problem reading console!"); }

    if(input_string != null){
      for(int i = 0; i < input_string.length(); i++){
        switch(input_string.charAt(i)){
         case 'A': letter_frequencies[A]++;
                   break;
         case 'B': letter_frequencies[B]++;
                   break;
	case 'C': letter_frequencies[C]++;
                   break;
	case 'D': letter_frequencies[D]++;
                   break;
	case 'E': letter_frequencies[E]++;
                   break;
	case 'F': letter_frequencies[F]++;
                   break;
	case 'G': letter_frequencies[G]++;
                   break;
	case 'H': letter_frequencies[H]++;
                   break;
	case 'I': letter_frequencies[I]++;
                   break;
	case 'J': letter_frequencies[J]++;
                   break;
	case 'K': letter_frequencies[K]++;
                   break;
	case 'L': letter_frequencies[L]++;
                   break;
	case 'M': letter_frequencies[M]++;
                   break;
	case 'N': letter_frequencies[N]++;
                   break;
	case 'O': letter_frequencies[O]++;
                   break;
        case 'P': letter_frequencies[P]++;
                   break;
        case 'Q': letter_frequencies[Q]++;
                   break;
        case 'R': letter_frequencies[R]++;
                   break;
        case 'S': letter_frequencies[S]++;
                   break;
        case 'T': letter_frequencies[T]++;
                   break;
        case 'U': letter_frequencies[U]++;
                   break;
        case 'V': letter_frequencies[V]++;
                   break;
        case 'W': letter_frequencies[W]++;
                   break;
        case 'X': letter_frequencies[X]++;
                   break;
        case 'Y': letter_frequencies[Y]++;
                   break;
        case 'Z': letter_frequencies[Z]++;
                   break;
        default : 
        } //end switch
      } //end for

    for(int i = 0; i < letter_frequencies.length; i++){
       System.out.print((char)(i + 65) + ": ");
       for(int j = 0; j < letter_frequencies[i]; j++){
        System.out.print('*');
       } //end for
       System.out.println();
    } //end for

   } //end if
 } // end main
} // end Histogram class definition