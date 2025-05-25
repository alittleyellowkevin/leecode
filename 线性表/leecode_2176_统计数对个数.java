package 线性表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class leecode_2176_统计数对个数 {
    public static void main(String[] args) {
        // 创建测试数据
        int[] smallArray = generateTestArray(1000);
        int[] mediumArray = generateTestArray(10000);
        int[] largeArray = generateTestArray(100000);
        int k = 5;

        // 测试小规模数据
        System.out.println("测试数组大小: 1000");
        runTest(smallArray, k);

        // 测试中等规模数据
        System.out.println("\n测试数组大小: 10000");
        runTest(mediumArray, k);

        // 测试大规模数据
        System.out.println("\n测试数组大小: 100000");
        runTest(largeArray, k);
    }

    // 使用HashMap的方法
    public static int countPairsWithHashMap(int[] nums, int k) {
        HashMap<Integer, List<Integer>> numberPositions = new HashMap<>();
        int resultCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int presentNumber = nums[i];
            if (numberPositions.containsKey(presentNumber)) {
                List<Integer> positions = numberPositions.get(presentNumber);
                for (int position : positions) {
                    if ((position * i) % k == 0)
                        resultCount++;
                }
                positions.add(i);
            } else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                numberPositions.put(presentNumber, positions);
            }
        }
        return resultCount;
    }

    // 使用双重循环的方法
    public static int countPairsWithDoubleLoop(int[] nums, int k) {
        int resultCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    resultCount++;
                }
            }
        }
        return resultCount;
    }

    // 生成测试数据
    private static int[] generateTestArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size / 10); // 控制数字范围，确保有重复数字
        }
        return array;
    }

    // 运行测试并输出结果
    private static void runTest(int[] array, int k) {
        // 测试HashMap方法
        long startTime = System.nanoTime();
        int result1 = countPairsWithHashMap(array, k);
        long endTime = System.nanoTime();
        long hashMapTime = endTime - startTime;

        // 测试双重循环方法
        startTime = System.nanoTime();
        int result2 = countPairsWithDoubleLoop(array, k);
        endTime = System.nanoTime();
        long doubleLoopTime = endTime - startTime;

        // 输出结果
        System.out.println("HashMap方法用时: " + hashMapTime / 1_000_000.0 + " 毫秒");
        System.out.println("双重循环方法用时: " + doubleLoopTime / 1_000_000.0 + " 毫秒");
        System.out.println("结果验证: " + (result1 == result2 ? "两种方法结果相同" : "结果不同！"));
        System.out.println("数对个数: " + result1);
    }
}