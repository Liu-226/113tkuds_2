
import java.io.*;
import java.util.*;

public class M01_BuildHeap {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        String type = fs.next(); // "max" or "min"
        int n = fs.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }
        boolean isMax = type.equalsIgnoreCase("max");
// bottom-up heapify
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(a, n, i, isMax);
        }
// output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
        /*
* Time Complexity: O(n)
* 說明：自底向上建堆，每個地方的下沉總花費和為 O(n)。
         */
    }

    static void heapifyDown(long[] a, int n, int i, boolean isMax) {
        while (true) {
            int l = i * 2 + 1, r = i * 2 + 2, best = i;
            if (l < n && better(a[l], a[best], isMax)) {
                best = l;
            }
            if (r < n && better(a[r], a[best], isMax)) {
                best = r;
            }
            if (best == i) {
                break;
            }
            long tmp = a[i];
            a[i] = a[best];
            a[best] = tmp;
            i = best;
        }
    }

    static boolean better(long x, long y, boolean isMax) {
        return isMax ? x > y : x < y;
    }

    static class FastScanner {

        BufferedInputStream in;
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = new BufferedInputStream(is);
        }

        int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) {
                    return -1;
            
                }}
            return buffer[ptr++];
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

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
