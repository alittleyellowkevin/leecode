package utils;

public class utils {
    public static void main(String[] args) {
//        String sql = "CREATE TABLE test.test_sortkey4 (k1 INT) PROPERTIES("replication_num" = "1");"
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 随机长度
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    private String escapeSqlForJson(String sql) {
        if (sql == null) {
            return "";
        }
        // 将双引号替换为JSON转义符\"，避免破坏JSON结构
        return sql.replace("\"", "\\\"");
    }
}
