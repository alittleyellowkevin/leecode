package huawei;

import java.util.Scanner;

public class HJ39_判断两个IP是否属于同一子网 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String mask = in.nextLine(); // 子网掩码
            String ip1 = in.nextLine(); // 第一个IP
            String ip2 = in.nextLine(); // 第二个IP

            if (isValidInput(mask, ip1, ip2)) {
                System.out.println(isSameSubnet(mask, ip1, ip2) ? "1" : "2");
            } else {
                System.out.println("1");
            }
        }
    }

    private static boolean isValidInput(String mask, String ip1, String ip2) {
        // TODO: 实现输入验证逻辑
        return false;
    }

    private static boolean isSameSubnet(String mask, String ip1, String ip2) {
        // TODO: 实现子网判断逻辑
        return false;
    }
}