package DP백준;

import java.util.Scanner;

//1149 for 문제 (백준 틀렸다고 나옴)
public class rgb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] house = new int[num][3];
        int[][] dp_store = new int[num][3];
        int min = 1001;
        for (int i = 0; i < num; i++) {
            for (int k = 0; k < 3; k++) {
                house[i][k] = scanner.nextInt();
            }
        }
        for (int k = 0; k < 3; k++) {
            dp_store[num - 1][k] = house[num - 1][k];

        }
        for (int i = num - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp_store[i + 1][k] < min && k != j) {
                        min = dp_store[i + 1][k];
                    }
                }
                dp_store[i][j] = min + house[i][j];
                min = 1001;
            }
        }

        min = Math.min(dp_store[0][0],Math.min(dp_store[0][1],dp_store[0][2]));
        System.out.print(min);
    }

}
