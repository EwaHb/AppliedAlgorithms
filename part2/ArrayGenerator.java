import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    public int[] generateRandomArray(int max) {
        Random rd = new Random();
        int[] arr = new int[max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public int[] smallNumbers(int s) {
        Random rand = new Random();
        int[] arr = new int[s];
        int max = 10000;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

    public int[] bigNumbers(int s) {
        Random rand = new Random();
        int[] arr = new int[s];
        int max = 7000000;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

    public int[] increasingOrder(int max) {
        int[] arr = generateRandomArray(max);
        Arrays.sort(arr);
        return arr;
    }

    // helper function
    static int[] reverseArray(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

    public int[] decreasingOrder(int max) {
        int[] arr = generateRandomArray(max);
        Arrays.sort(arr);
        return reverseArray(arr);
    }

    // generate n equal integers
    public int[] sameElements(int n, int max) {
        Random rand = new Random();
        int[] arr = new int[max];
        for (int i = 0; i <= max - 1; i += n) {
            int next = rand.nextInt();
            for (int j = i; j < (i + n) && j < max; j++) {
                arr[j] = next;
            }
        }
        return arr;
    }

    public ArrayList<int[]> getArrays(int s) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(smallNumbers(s));
        list.add(bigNumbers(s));
        list.add(increasingOrder(s));
        list.add(decreasingOrder(s));
        list.add(sameElements(25, s));
        return list;
    }

    // generates and returns different kinds of input
    public int[] getInput(int i, int s) {
        switch (i) {
            case 0:
                return bigNumbers(s);
            case 1:
                return smallNumbers(s);
            case 2:
                return increasingOrder(s);
            case 3:
                return decreasingOrder(s);
            case 4:
                return generateRandomArray(s);
            case 5:
                return sameElements(5, s);
            default:
                return generateRandomArray(s);
        }
    }

}