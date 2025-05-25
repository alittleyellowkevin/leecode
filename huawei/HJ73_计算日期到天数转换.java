package huawei;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ73_计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();

            // 计算这是一年中的第几天
            int days = 0;

            // 每个月的天数(非闰年)
            int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            // 判断是否为闰年
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                monthDays[1] = 29;
            }

            // 累加前几个月的天数
            for (int i = 0; i < month - 1; i++) {
                days += monthDays[i];
            }

            // 加上当月的天数
            days += day;

            System.out.println(days);
        }
    }
}