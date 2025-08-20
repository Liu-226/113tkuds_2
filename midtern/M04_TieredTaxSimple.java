
import java.io.*;
import java.util.*;

public class M04_TieredTaxSimple {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long sumTax = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long income = Long.parseLong(fs.next());
            long tax = calcTax(income);
            sumTax += tax;
            out.append("Tax: ").append(tax).append('\n');
        }
        long avg = Math.round(sumTax * 1.0 / n);
        out.append("Average: ").append(avg).append('\n');
        System.out.print(out.toString());
        /*
* Time Complexity: O(n)
* 說明：每筆收入在固定 4 段稅率中逐漸增加；總體線性於輸入。
         */
    }

    static long calcTax(long x) {
        long tax = 0;
        long[] bound = {120_000, 500_000, 1_000_000};
        double[] rate = {0.05, 0.12, 0.20, 0.30};
        long prev = 0;
        for (int i = 0; i < bound.length; i++) {
            if (x > bound[i]) {
                tax += Math.round((bound[i] - prev) * rate[i]);
                prev = bound[i];
            } else {
                tax += Math.round((x - prev) * rate[i]);
                return tax;
            }
        }
        tax += Math.round((x - prev) * rate[3]);

    }
