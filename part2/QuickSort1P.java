import java.util.Arrays;

public class QuickSort1P extends QuickSort {
  public int[] sort(int[] arr, int left, int right) {
    // if( left < 0) {System.out.println("Error");
    // }
    // if( right > arr.length) {System.out.println("Error");
    // }
    if (right - left >= 1) {
      int pivot = arr[right];
      int i = left - 1;
      int j = right;

      do {
        do {
          i = i + 1; // executes this statement and then checks the conditions and of the conditions are satisfied it does it again - goes into infinite loop
        } while ((i < right) && (arr[i] < pivot)); // we added i < right
        do {
          j = j - 1;
        } while ((j > 0) && (arr[j] > pivot)); // we added i > left

        if (j > i) {
          swap(arr, i, j);
          // break;
        }
      } while (j > i);
      swap(arr, i, right);
      sort(arr, left, i - 1);
      sort(arr, i + 1, right);
    }
    return arr;
  }

  public String toString() {
    return "QuickSort1P";
  }

  public static void main(String[] args) {
    // QuickSort1P test = new QuickSort1P();
    // var g = new ArrayGenerator();
    // int[] arr = g.increasingOrder(20000);
    // int n = arr.length - 1;
    // System.out.println(n);
    // System.out.println(Arrays.toString(test.sort(arr, 0, n)));
    int[] arr = { 0, 1, 2, 3, 4 };
    int piv = arr[4];
    int left = 0 - 1;
    System.out.println("piv="+piv);
    arr[4] = 2;
    System.out.println("piv="+piv);
    System.out.println(arr[left]);
    // System.out.println(Arrays.toString(test.quickSortGeneral(arr)));
  }
}
