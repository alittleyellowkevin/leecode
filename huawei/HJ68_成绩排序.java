package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class HJ68_成绩排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt(); // 学生人数
            int order = in.nextInt(); // 排序方式：0表示降序，1表示升序

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = in.next();
                int score = in.nextInt();
                students.add(new Student(name, score));
            }

            // 根据排序方式排序
            if (order == 0) {
                // 降序排序
                students.sort((s1, s2) -> s2.score - s1.score);
            } else {
                // 升序排序
                students.sort((s1, s2) -> s1.score - s2.score);
            }

            // 输出结果
            for (Student student : students) {
                System.out.println(student.name + " " + student.score);
            }
        }
    }

    // 学生类
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}