
public class GradeStatisticsSystem {

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 82, 90};

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int s : scores) {
            sum += s;
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }

            if (s >= 90) {
                countA++; 
            }else if (s >= 80) {
                countB++; 
            }else if (s >= 70) {
                countC++; 
            }else if (s >= 60) {
                countD++; 
            }else {
                countF++;
            }
        }

        double average = (double) sum / scores.length;

        int aboveAvgCount = 0;
        for (int s : scores) {
            if (s > average) {
                aboveAvgCount++;
            }
        }

        // 印出成績報表
        System.out.println("---- Grade Statistics Report ----");
        System.out.println("Scores: ");
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println("\n------------------------------");
        System.out.printf("Average score: %.2f\n", average);
        System.out.println("Highest score: " + max);
        System.out.println("Lowest score: " + min);
        System.out.println("\nGrade distribution:");
        System.out.println("A (>=90): " + countA);
        System.out.println("B (80–89): " + countB);
        System.out.println("C (70–79): " + countC);
        System.out.println("D (60–69): " + countD);
        System.out.println("F (<60): " + countF);
        System.out.println("\nNumber of students above average: " + aboveAvgCount);
        System.out.println("--------------------------------");
    }
}
