import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {

    private static QuickSort qs;
    private static QuickSort oneP;
    private QuickSort twoP;
    private QuickSort threeP;
    private ArrayGenerator ag;

    public Task4() {
        qs = new QuickSort();
        oneP = new QuickSort1P();
        twoP = new QuickSort2P();
        threeP = new QuickSort3P();
        ag = new ArrayGenerator();
    }

    public ArrayList<int[]> getArrays(int s) {
        return ag.getArrays(s);
    }

    public QuickSort[] getAlgorithms() {
        QuickSort[] algos = { oneP, twoP, threeP };
        return algos;
    }

    public boolean isEqual(int[] qs, int[] arr) {
        return Arrays.equals(qs, arr);
    }

    public boolean singleCorrectnessTest(int s, QuickSort param) {

        boolean result = true;
        ArrayList<int[]> inputs = getArrays(s);
        ArrayList<int[]> copies = inputs;

        for (int i = 0; i < inputs.size(); i++) {
            result = isEqual(qs.sort(inputs.get(i), 0, s - 1), param.sort(copies.get(i), 0, s - 1));
            if (!result) {
                return false;
            }
        }
        return result;
    }

    public boolean runCorrectnessTest(int s) {
        boolean result = true;
        QuickSort[] algs = getAlgorithms();
        for (int i = 0; i < algs.length; i++) {
            result = singleCorrectnessTest(s, algs[i]);
            System.out.println(
                    algs[i].toString() + ": " + result + ", algorithm sorted the arrays for the array size: " + s);
        }
        return result;
    }
}
