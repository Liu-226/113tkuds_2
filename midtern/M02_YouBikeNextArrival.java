
import java.io.*;

public class M02_YouBikeNextArrival {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = parseHM(fs.next());
        }
        int q = parseHM(fs.next());
        int idx = upperBound(times, q); // first > q
        if (idx < n) {
            System.out.println(formatHM(times[idx])); 
        }else {
            System.out.println("No bike");
        }
    }

    static int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    static int parseHM(String s) {
        String[] p = s.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    static String formatHM(int m) {
        int h = m / 60;
        int mm = m % 60;
        return String.format("%02d:%02d", h, mm);
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
