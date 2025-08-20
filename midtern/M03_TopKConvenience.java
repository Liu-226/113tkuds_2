
import java.io.*;
import java.util.*;

public class M03_TopKConvenience {

    static class Item {

        String name;
        long qty;

        Item(String n, long q) {
            name = n;
            qty = q;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int K = fs.nextInt();
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> {
            if (a.qty != b.qty) {
                return Long.compare(a.qty, b.qty);
            }
            return a.name.compareTo(b.name);
        });
        for (int i = 0; i < n; i++) {
            String name = fs.next();
            long qty = Long.parseLong(fs.next());
            Item it = new Item(name, qty);
            if (pq.size() < K) {
                pq.add(it); 
            }else if (pq.comparator().compare(it, pq.peek()) > 0) {
                pq.poll();
                pq.add(it);
            }
        }
        List<Item> ans = new ArrayList<>(pq);
        ans.sort((a, b) -> {
            if (a.qty != b.qty) {
                return Long.compare(b.qty, a.qty); // high to low

                        }return a.name.compareTo(b.name); // tie-break: lexicographically smaller first
        });
        StringBuilder sb = new StringBuilder();
        for (Item it : ans) {
            sb.append(it.name).append(' ').append(it.qty).append('\n');
        }
        System.out.print(sb.toString());
        /*
* Time Complexity: O(n log K)
* 說明：每筆資料進出大小為 K≪n 時可以節省時間與記憶體。
         */
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
