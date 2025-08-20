
import java.io.*;
import java.util.*;

public class M12_MergeKTimeTables {

    static class Node {

        int time, li, idx;

        Node(int t, int l, int i) {
            time = t;
            li = l;
            idx = i;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int K = fs.nextInt();
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = fs.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = fs.nextInt();
            }
            lists.add(arr);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        for (int i = 0; i < K; i++) {
            if (lists.get(i).length > 0) {
                pq.add(new Node(lists.get(i)[0], i, 0));
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!first) {
                sb.append(' ');
            
            }first = false;
            sb.append(cur.time);
            int ni = cur.idx + 1;
            int[] arr = lists.get(cur.li);
            if (ni < arr.length) {
                pq.add(new Node(arr[ni], cur.li, ni));
            }
        }
        System.out.println(sb.toString());
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
