import java.util.Arrays;

// superclass
class QuickSort {
  public void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public int[] sort(int[] arr, int i, int n) {
    Arrays.sort(arr);
    return arr;
  }

  public String toString() {
    return "QuickSort";
  }
}

class Main {
  public static void main(String[] args) {
    QuickSort oneP = new QuickSort1P();
    int[] arr = { 3, 8, 5, 9, 209, 14, 13, 7, 4, 1, 12, 6, 103, 92, 50, 5000 };
    int n = arr.length - 1;
    System.out.println(Arrays.toString(oneP.sort(arr, 0, n)));
  }
}