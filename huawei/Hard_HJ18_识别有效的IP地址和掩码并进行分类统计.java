package huawei;

import java.util.Scanner;

public class Hard_HJ18_识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res = new int[7];
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty())
                break;
            String[] strs = line.split("~");
            String ip = strs[0];
            String mask = strs[1];

            String[] ipStrs = ip.split("\\.");
            if (ipStrs[0].equals("0") || ipStrs[0].equals("127")) {
                continue;
            }
            // 如果 IP合法且 Mask 也合法
            if (isValidIP(ip) && isValidMask(mask)) {
                // 如果 IP 是 A,B,C,D,E类
                if (isAIP(ip)) {
                    res[0]++;
                } else if (isBIP(ip)) {
                    res[1]++;
                } else if (isCIP(ip)) {
                    res[2]++;
                } else if (isDIP(ip)) {
                    res[3]++;
                } else if (isEIP(ip)) {
                    res[4]++;
                }
                // 如果 IP 是私网 IP
                if (isPrivateIP(ip)) {
                    res[6]++;
                }
            }
            // 如果 IP 不合法或 Mask 不合法
            else {
                res[5]++;
            }
        }
        System.out.println(res[0] + " " + res[1] + " " + res[2] + " " + res[3] + " " + res[4] + " " + res[5] + " "
                + res[6]);
    }

    // 判断 IP 是否合法
    public static boolean isValidIP(String ip) {
        String[] strs = ip.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            try {
                int num = Integer.parseInt(str);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // 判断掩码是否合法
    public static boolean isValidMask(String mask) {
        if (!isValidIP(mask))
            return false;
        String[] strs = mask.split("\\.");
        StringBuilder binary = new StringBuilder();
        for (String str : strs) {
            String binaryStr = Integer.toBinaryString(Integer.parseInt(str));
            while (binaryStr.length() < 8) {
                binaryStr = "0" + binaryStr;
            }
            binary.append(binaryStr);
        }
        String binaryMask = binary.toString();
        // 全0或全1的掩码不合法
        if (binaryMask.equals("00000000000000000000000000000000") ||
                binaryMask.equals("11111111111111111111111111111111")) {
            return false;
        }
        // 检查是否由连续的1后跟连续的0组成
        return binaryMask.matches("1+0+");
    }

    // 判断是否是A类IP
    public static boolean isAIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        return first >= 1 && first <= 126;
    }

    // 判断是否是B类IP
    public static boolean isBIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        return first >= 128 && first <= 191;
    }

    // 判断是否是C类IP
    public static boolean isCIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        return first >= 192 && first <= 223;
    }

    // 判断是否是D类IP
    public static boolean isDIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        return first >= 224 && first <= 239;
    }

    // 判断是否是E类IP
    public static boolean isEIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        return first >= 240 && first <= 255;
    }

    // 判断是否是私有IP
    public static boolean isPrivateIP(String ip) {
        String[] strs = ip.split("\\.");
        int first = Integer.parseInt(strs[0]);
        int second = Integer.parseInt(strs[1]);

        if (first == 10)
            return true;
        if (first == 172 && second >= 16 && second <= 31)
            return true;
        if (first == 192 && second == 168)
            return true;
        return false;
    }
}