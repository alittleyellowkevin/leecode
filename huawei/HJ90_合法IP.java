package huawei;

import java.util.Scanner;

public class HJ90_合法IP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String ip = in.nextLine();
            String[] ips = ip.split("\\.");
            if (ips.length != 4) {
                System.out.println("NO");
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (!(ips[i].matches("^[0]$|^[1-9][0-9]*$") && Integer.valueOf(ips[i]) >= 0
                        && Integer.valueOf(ips[i]) <= 255)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

}