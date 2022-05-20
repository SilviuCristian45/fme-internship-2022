/*______________________________________________________________________________________________________
 * 
 * Write a Java program that reads arguments from the command line 
 * and checks whether all numeric positive non-zero values appear in ascending order.
 * _____________________________________________________________________________________________________
 * 
 * 
 * Example:
 * 
 *______________________________________________________________________________________________________
 *
 *  Input:
 *      java Test1 1 0 -2 3 5 -7 -9 7 8 
 *  Output:
 *      YES
 *______________________________________________________________________________________________________
 *      
 *______________________________________________________________________________________________________
 *  
 *  Input:
 *      java Test1 1 0 -2 3 5 -7 -9 4 7 8 
 *  Output:
 *      NO
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________ 
 */

package fme.internship;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * 
 * @author Dinca Silviu-Cristian
 * @email silviudinca412@gmail.com
 * 
 */
public class Test1 {

    public static void main(String[] args) {
        boolean ok = true;
        int lastPositive = -999;
        System.out.println();
        for(int i = 0; i < args.length; i++) {
            //System.out.println( i + " " + args[i]);
            String arg = args[i];
            int element = -2;
            if(arg != null)
                element = parseInt(arg);
            if(element > 0 && lastPositive == -999)
                lastPositive = element;
            if (element < lastPositive && element > 0){
                ok = false;
                break;
            }
            else if(element > 0) lastPositive = element;
        }
        if (ok) System.out.println("YES"); else System.out.println("NO");
    }

}