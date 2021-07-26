import java.io.*;
import java.util.*;

class BinarySearch {

    static int getFloor(int[] A, int y) {
        int left = 0, right = A.length - 1;

        int floor = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == y) {
                return A[mid];
            } else if (y < A[mid]) {
                right = mid - 1;
            } else {
                floor = A[mid];
                left = mid + 1;
            }
        }
        return floor;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int S = Integer.parseInt(args[0]);

        int[] A = new int[S];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            int neytInt = Integer.parseInt(input[i]);
            A[i] = neytInt;
        }
        Arrays.sort(A);
        // int[] firstLine = {93, 1094, 11, 13};
        // int[] secondLine = {93, 12, 9999, 1, 18};
        String[] query = br.readLine().split(" ");
        for (int j = 0; j < query.length; j++) {
            int indey = getFloor(A, Integer.parseInt(query[j]));
            if (indey == -1)
                System.out.print("None ");
            else
                System.out.print(indey + " ");
        }
    }
}
