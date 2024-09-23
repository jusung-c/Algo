import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static Node root;
    static class Node {
        int num;

        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public void insertNode(int n) {
            if (n < this.num) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insertNode(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insertNode(n);
            }
        }
    }

    public static void init() throws IOException {
        root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {

//            System.out.println(Integer.parseInt(input));
            root.insertNode(Integer.parseInt(input));
        }
    }

    private static void pro() throws IOException {
        backDfs(root);
    }

    private static void backDfs(Node node) throws IOException {
        if (node == null) return;

        backDfs(node.left);
        backDfs(node.right);
        bw.write(node.num +" ");
        bw.newLine();
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
