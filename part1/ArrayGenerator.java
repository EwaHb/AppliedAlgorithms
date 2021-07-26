import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

public class ArrayGenerator {
    private static Random rand;

    private static Random getRandom(int seed) {
        if (rand == null) {
            rand = new Random(seed);
            return rand;
        } else {
            return rand;
        }
    }

    public static void generateArray(int n, int seed) {
        HashSet<Integer> A = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        var random = getRandom(seed);

        while (A.size() < n) {
            // generate positive values from 0 to max int
            A.add(random.nextInt(Integer.MAX_VALUE) + 1);
        }
        for (Integer x : A) {
            sb.append(x + " ");
        }
        System.out.println(sb.toString());

        /*
         * try { PrintWriter out = new PrintWriter(new FileWriter("generated.in",
         * true)); out.println(sb); out.close(); } catch (Exception e) {
         * System.out.println("..."); }
         */

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int seed = Integer.parseInt(args[2]);
        generateArray(n, seed);
        generateArray(q, seed);
    }

}
