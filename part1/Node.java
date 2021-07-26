public class Node {
    private int left;
    private int right;

    public Node(int S) {
        this.left = 0;
        this.right = S - 1;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
