package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HJ66_配置文件恢复 {
    // 存储命令和对应的完整命令
    private static final Map<String, String> commandMap = new HashMap<>();

    static {
        // 初始化命令映射
        commandMap.put("reset", "reset what");
        commandMap.put("reset board", "board fault");
        commandMap.put("board add", "where to add");
        commandMap.put("board delete", "no board at all");
        commandMap.put("reboot backplane", "impossible");
        commandMap.put("backplane abort", "install first");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String command = in.nextLine().trim();
            String result = processCommand(command);
            System.out.println(result);
        }
    }

    public static String processCommand(String command) {
        String[] commands = command.split("\\s");
        int len = commands.length;

        ArrayList<String> res = new ArrayList<>();
        for (String key : commandMap.keySet()) {
            String[] keys = key.split("\\s");
            if (keys.length != len) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < keys.length; i++) {
                if (!beginwith(keys[i], commands[i])) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(key);
            }
        }
        if (res.size() == 1) {
            return commandMap.get(res.get(0));
        } else {
            return "unknown command";
        }
    }

    public static boolean beginwith(String key, String command) {
        for (int i = 0; i < command.length(); i++) {
            if (!(key.charAt(i) == command.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}