package 백준.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//틀린코드임..
public class 최소회의실개수_19598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];
        PriorityQueue<Integer> mtpq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();

        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        /**
          5
          3 4
          1 4
          2 4
          1 3
          0 2
         */
        mtpq.offer(meetings[0][1]);
        for (int i = 1; i < n; i++) {

            System.out.println("===========================");
            System.out.println("meetings[0] = " + meetings[i][0]);
            System.out.println("meetings[1] = " + meetings[i][1]);
            System.out.println("mtpq = " + mtpq.peek());
            if (meetings[i][0] >= mtpq.peek()) {
                System.out.println("poll!!!");
                mtpq.poll();
            }
            mtpq.offer(meetings[i][1]);
        }

        System.out.println(mtpq.size());
    }
}


