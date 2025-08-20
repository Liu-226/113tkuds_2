
import java.io.*;

public class M09_AVLValidate {

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
        if (!isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }
        if (!isAVL(root).ok) {
            System.out.println("Invalid AVL");
            return;
        }
        System.out.println("Valid");
        /*
* Time Complexity: O(n)
* 說明：各節點剛好都被拜訪一次；BST使用上下遞迴，AVL同時計算高度與檢查。
         */
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

    static boolean isBST(Node x, long lo, long hi) {
        if (x == null) {
            return true;
        }
        if (!(lo < x.v && x.v < hi)) {
            return false;
        }
        return isBST(x.l, lo, x.v) && isBST(x.r, x.v, hi);
    }

    static class AvlInfo {

        boolean ok;
        int h;

        AvlInfo(boolean o, int h) {
            this.ok = o;
            this.h = h;
        }
    }

    static AvlInfo isAVL(Node x) {
        if (x == null) {
            return new AvlInfo(true, 0);
        }
        AvlInfo L = isAVL(x.l);
        if (!L.ok) {
            return new AvlInfo(false, 0);
        }
        AvlInfo R = isAVL(x.r);
        if (!R.ok) {
            return new AvlInfo(false, 0);
        }
        if (Math.abs(L.h - R.h) > 1) {
            return new AvlInfo(false, 0);
        }
        return new AvlInfo(true, Math.max(L.h, R.h) + 1);
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
