import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task5 {

    private QuickSort qs;
    private QuickSort oneP;
    private QuickSort twoP;
    private QuickSort threeP;
    private ArrayGenerator ag;

    public Task5() {
        qs = new QuickSort();
        oneP = new QuickSort1P();
        twoP = new QuickSort2P();
        threeP = new QuickSort3P();
        ag = new ArrayGenerator();
    }

    public QuickSort[] getAlgorithms() {
        QuickSort[] algos = { qs, oneP, twoP, threeP };
        return algos;
    }

    public long measureTime(int[] temp, QuickSort param) {
        int[] arr = temp;
        System.out.println("Sorting array of size: " + arr.length + " for algorithm: " + param.toString());
        long start = System.nanoTime();
        param.sort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        return end - start;
    }

    public void singleBenchmark(QuickSort qs) throws IOException {

        // array0 = bigNumbers, array1 = smallNumbers, array2 = ...
        for (int i = 0; i <= 5; i++) {

            File tmp = new File("part2/plots" + i + "/" + i + qs.toString() + ".csv");
            tmp.getParentFile().mkdirs();
            tmp.createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter(tmp));

            for (int j = 1; j < 30; j++) {

                int N = (int) (220 * (Math.pow(Math.sqrt(2), j)));
                System.out.println("i : " + i + " Current N: " + N);
                int[] array = ag.getInput(i, N);
                try {
                    out.println(N + "," + measureTime(array, qs));
                } catch (StackOverflowError e) {
                    System.out.println(e + " for i = " + i);
                    break;
                }
            }
            out.close();
        }
    }

    public void completeBenchmark() throws IOException {
        QuickSort[] algs = getAlgorithms();
        for (int i = 0; i < algs.length; i++) {
            singleBenchmark(algs[i]);
        }
    }

}
