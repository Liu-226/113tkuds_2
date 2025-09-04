
import java.util.*;

class Solution {

    public double findMedianSortedArrays(double[] A, double[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }

        int n = A.length, m = B.length;
        int totalLeft = (n + m + 1) / 2;

        int left = 0, right = n;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = totalLeft - i;

            double Aleft = (i == 0) ? Double.NEGATIVE_INFINITY : A[i - 1];
            double Aright = (i == n) ? Double.POSITIVE_INFINITY : A[i];

            double Bleft = (j == 0) ? Double.NEGATIVE_INFINITY : B[j - 1];
            double Bright = (j == m) ? Double.POSITIVE_INFINITY : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((n + m) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays not valid.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        double[] A = new double[n];
        double[] B = new double[m];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextDouble();
        }

        Solution sol = new Solution();
        double ans = sol.findMedianSortedArrays(A, B);

        System.out.printf("%.1f\n", ans);
    }
}
