
import java.io.*;
import java.util.*;

public class M07_BinaryTreeLeftView {

    static class Node {

        int v;
        Node l, r;

        Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        Node root = buildFromLevel(arr);
        List<Integer> left = leftView(root);
        StringBuilder sb = new StringBuilder();
        sb.append("LeftView:");
        for (int i = 0; i < left.size(); i++) {
            sb.append(i == 0 ? " " : " ").append(left.get(i));
        }
        System.out.println(sb.toString());
    }

    static Node buildFromLevel(int[] a) {
        int n = a.length;
        if (n == 0 || a[0] == -1) {
            return null;
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) {
                nodes[i] = new Node(a[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int L = 2 * i + 1, R = 2 * i + 2;
                if (L < n) {
                    nodes[i].l = nodes[L];
                
                }if (R < n) {
                    nodes[i].r = nodes[R];
                }
            }
        }
        return nodes[0];
    }

    static List<Integer> leftView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (i == 0) {
                    res.add(cur.v);
                }
                if (cur.l != null) {
                    q.add(cur.l);
                }
                if (cur.r != null) {
                    q.add(cur.r);
                }
            }
        }
        return res;
    }

    static class FastScanner {

        BufferedInputStream in;
        byte[] buf = new byte[1 << 16];
        int p = 0, l = 0;

        FastScanner(InputStream is) {
            in = new BufferedInputStream(is);
        }

        int read() {
            if (p >= l) {
                try {
                    l = in.read(buf);
                    p = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (l <= 0) {
                    return -1;
            
                }}
            return buf[p++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= 32 && c != -1);
            while (c > 32 && c != -1) {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
