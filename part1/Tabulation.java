import java.io.*;
import java.util.*;

class Tabulation {
    int S;
    static int k;
    static int[] A;
    static Node[] table;

    public Tabulation(int k, int S) {
        this.k = k;
        this.S = S;
        A = new int[S];
        table = new Node[(int) Math.pow(2, k)];
    }

    static int getFloor(int x, int l, int r) {
        int left = l, right = r;

        int floor = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (A[mid] == x) {
                return A[mid];
            }

            else if (x < A[mid]) {
                right = mid - 1;
            }

            else {
                floor = A[mid];
                left = mid + 1;
            }
        }

        return floor;
    }

    public void precompute() {
        int bits0 = getKBits(A[0]);
        createEntry(bits0);
        setLeft(bits0, 0);
        for (int i = 0; i < getS() - 1; i++) {
            int bits1 = getKBits(A[i]);
            int bits2 = getKBits(A[i + 1]);
            if (bits1 != bits2) {
                setRight(bits1, i);
                createEntry(bits2);
                setLeft(bits2, i);
            }
        }
    }

    public void addToArray(int i, int v) {
        A[i] = v;
    }

    public int getS() {
        return S;
    }

    public void sort() {
        Arrays.sort(A);
    }

    public void createEntry(int index) {
        Node nd = new Node(S);
        table[index] = nd;
    }

    public void setLeft(int index, int left) {
        Node nd = table[index];
        nd.setLeft(left);
    }

    public void setRight(int index, int right) {
        Node nd = table[index];
        nd.setRight(right);
    }

    public Node getBucket(int kBits) {
        if (table[kBits] == null) {
            return findPreceedingBucket(kBits);
        }
        return table[kBits];
    }

    private Node findPreceedingBucket(int kBits) {
        Node result = null;
        for (int i = kBits - 1; i > 0; i--) {
            if (table[i] != null) {
                result = table[i];
                break;
            }
        }
        return result;
    }

    public static int getKBits(int number) {
        return number >>> 32 - k;
    }

    public static void main(String[] args) throws IOException {
        int S = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        // int S = Integer.parseInt(br.readLine());
        Tabulation cj = new Tabulation(k, S);
        try {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                int nextInt = Integer.parseInt(input[i]);
                cj.addToArray(i, nextInt);
            }

            cj.sort();
            cj.precompute();

            String[] query = br.readLine().split(" ");
            for (int j = 0; j < query.length; j++) {
                int y = Integer.parseInt(query[j]);
                int kBits = getKBits(y);
                Node bucket = cj.getBucket(kBits);

                int val = -1;
                if (bucket != null) {
                    val = getFloor(y, bucket.getLeft(), bucket.getRight());
                }

                if (val == -1)
                    System.out.print("None ");
                else
                    System.out.print(val + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
    }
}
