package huawei;

import java.util.Scanner;

public class HJ54_不要三 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] numbers = line.split(",");

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals("...")) {
                    System.out.println(Long.valueOf(numbers[i + 1]) - Long.valueOf(numbers[i - 1]) - 1);
                }
            }
        }
    }
}