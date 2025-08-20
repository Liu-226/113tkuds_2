
import java.io.*;

public class M11_HeapSortWithTie {

    static class P {

        int s, idx;

        P(int s, int i) {
            this.s = s;
            this.idx = i;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        P[] a = new P[n];
        for (int i = 0; i < n; i++) {
            a[i] = new P(fs.nextInt(), i);
        }
        heapSort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(a[i].s);
        }
        System.out.println(sb.toString());
        /*
* Time Complexity: O(n log n)
* 說明：建立O(n)，每次取最大並下沉 O(log n)，共 n 次。
         */
    }

    static void heapSort(P[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(a, n, i);
        }
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);
            siftDown(a, end, 0);
        }
    }

    static void siftDown(P[] a, int n, int i) {
        while (true) {
            int l = i * 2 + 1, r = i * 2 + 2, best = i;
            if (l < n && greater(a[l], a[best])) {
                best = l;
            }
            if (r < n && greater(a[r], a[best])) {
                best = r;
            }
            if (best == i) {
                break;
            }
            swap(a, i, best);
            i = best;
        }
    }

    static boolean greater(P x, P y) {
        if (x.s != y.s) {
            return x.s > y.s;
        }
        return x.idx > y.idx;
    }

    static void swap(P[] a, int i, int j) {
        P t = a[i];
        a[i] = a[j];
        a[j] = t;
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
