
import java.io.*;

public class M08_BSTRangedSum {

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
        int L = fs.nextInt();
        int R = fs.nextInt();
        Node root = buildFromLevel(arr);
        long sum = dfs(root, L, R);
        System.out.println("Sum: " + sum);
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

    static long dfs(Node x, int L, int R) {
        if (x == null) {
            return 0;
        }
        if (x.v < L) {
            return dfs(x.r, L, R);
        }
        if (x.v > R) {
            return dfs(x.l, L, R);
        }
        return x.v + dfs(x.l, L, R) + dfs(x.r, L, R);
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
