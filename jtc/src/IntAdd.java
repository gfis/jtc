/**
 * Adds 4 numbers on the commandline 4 times
 * @author Georg Fischer
 */
public class IntAdd { 
    
    public static void main(String[] args) {
        int sum = Integer.parseInt(args[0]) 
                + Integer.parseInt(args[1])
                + Integer.parseInt(args[2])
                + Integer.parseInt(args[3])
                ;
        int sum2 = sum + sum + sum + sum;
        System.out.println(sum2);
    } // main
    
} // IntAdd
