
/**
 * Concatenates 4 words on the commandline
 *
 * @author PC
 */
public class StringAdd {

    public static void main(String[] args) {
        String sum = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " ";
        String sum2 = sum + sum + sum + sum;
        System.out.println(sum2);
    } // StringAdd
} // StringAdd
