import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Circus {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] people = new int[n][3];
        for (int i = 0; i < n; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
            people[i][2] = sc.nextInt();
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1] && o1[2] < o2[2]) {
                    return -1;
                } else if (o1[1] == o2[1] && o1[2] > o2[2]) {
                    return 1;
                } else
                    return 0;
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(people[i][0]);
            System.out.print(' ');
            System.out.print(people[i][1]);
            System.out.print(' ');
            System.out.print(people[i][2]);
            System.out.print('\n');
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (people[i][2] >= people[j][2] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
