
import java.io.*;

public class M05_GCD_LCM_Recursive {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        long a = Long.parseLong(fs.next());
        long b = Long.parseLong(fs.next());
        long g = gcd(a, b);
        long l = (a / g) * b;
        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
        /*
* Time Complexity: O(log(min(a,b)))
* 說明：歐基里德演算法每一步餘數會嚴格遞減，次數為對數級。
         */
    }

    static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
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
    }
}
