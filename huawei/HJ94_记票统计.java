package huawei;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HJ94_记票统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取候选人数量
        int n = in.nextInt();
        in.nextLine(); // 消费换行符

        // 读取候选人姓名
        String[] candidates = in.nextLine().split(" ");

        // 读取投票人数
        int m = in.nextInt();
        in.nextLine(); // 消费换行符

        // 读取投票
        String[] votes = in.nextLine().split(" ");

        // 统计票数
        Map<String, Integer> voteCount = new HashMap<>();
        int invalidVotes = 0;

        // 初始化候选人票数为0
        for (String candidate : candidates) {
            voteCount.put(candidate, 0);
        }

        // 统计票数
        for (String vote : votes) {
            if (voteCount.containsKey(vote)) {
                voteCount.put(vote, voteCount.get(vote) + 1);
            } else {
                invalidVotes++;
            }
        }

        // 输出结果
        for (String candidate : candidates) {
            System.out.println(candidate + " : " + voteCount.get(candidate));
        }
        System.out.println("Invalid : " + invalidVotes);
    }
}