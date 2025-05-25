package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class HJ89_24点运算 {
    private static final Map<String, Integer> cardValues = new HashMap<>();

    static {
        // 初始化牌值
        for (int i = 2; i <= 10; i++) {
            cardValues.put(String.valueOf(i), i);
        }
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 1);
        cardValues.put("joker", 0); // joker 无法参与计算
        cardValues.put("JOKER", 0); // JOKER 无法参与计算
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            String result = calculate24(input);
            System.out.println(result);
        }
    }

    /**
     * 计算24点
     * 
     * @param input 输入的牌
     * @return 计算结果表达式或提示信息
     */
    private static String calculate24(String input) {
        String[] cards = input.split(" ");

        // 检查是否包含大小王
        for (String card : cards) {
            if ("joker".equals(card) || "JOKER".equals(card)) {
                return "ERROR";
            }
        }

        // 获取牌的数值
        List<Double> numbers = new ArrayList<>();
        for (String card : cards) {
            numbers.add((double) cardValues.get(card));
        }

        // 记录原始牌，用于输出表达式
        List<String> originalCards = new ArrayList<>();
        for (String card : cards) {
            originalCards.add(card);
        }

        // 尝试计算24点
        StringBuilder expression = new StringBuilder();
        if (solve24(numbers, originalCards, expression)) {
            return expression.toString();
        } else {
            return "NONE";
        }
    }

    /**
     * 递归计算24点
     * 
     * @param numbers    当前可用的数字
     * @param cards      当前可用的牌
     * @param expression 表达式结果
     * @return 是否可以计算出24点
     */
    private static boolean solve24(List<Double> numbers, List<String> cards, StringBuilder expression) {
        if (numbers.size() == 1) {
            if (Math.abs(numbers.get(0) - 24) < 0.001) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                double num1 = numbers.get(i);
                double num2 = numbers.get(j);
                String card1 = cards.get(i);
                String card2 = cards.get(j);

                // 创建新的数字列表和牌列表，移除已经使用的两个数
                List<Double> newNumbers = new ArrayList<>();
                List<String> newCards = new ArrayList<>();

                for (int k = 0; k < numbers.size(); k++) {
                    if (k != i && k != j) {
                        newNumbers.add(numbers.get(k));
                        newCards.add(cards.get(k));
                    }
                }

                // 尝试加法
                newNumbers.add(num1 + num2);
                newCards.add("(" + card1 + "+" + card2 + ")");
                if (solve24(newNumbers, newCards, expression)) {
                    if (numbers.size() == 4) {
                        expression.append(newCards.get(newCards.size() - 1));
                    }
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);
                newCards.remove(newCards.size() - 1);

                // 尝试减法 (num1 - num2)
                newNumbers.add(num1 - num2);
                newCards.add("(" + card1 + "-" + card2 + ")");
                if (solve24(newNumbers, newCards, expression)) {
                    if (numbers.size() == 4) {
                        expression.append(newCards.get(newCards.size() - 1));
                    }
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);
                newCards.remove(newCards.size() - 1);

                // 尝试减法 (num2 - num1)
                newNumbers.add(num2 - num1);
                newCards.add("(" + card2 + "-" + card1 + ")");
                if (solve24(newNumbers, newCards, expression)) {
                    if (numbers.size() == 4) {
                        expression.append(newCards.get(newCards.size() - 1));
                    }
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);
                newCards.remove(newCards.size() - 1);

                // 尝试乘法
                newNumbers.add(num1 * num2);
                newCards.add("(" + card1 + "*" + card2 + ")");
                if (solve24(newNumbers, newCards, expression)) {
                    if (numbers.size() == 4) {
                        expression.append(newCards.get(newCards.size() - 1));
                    }
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);
                newCards.remove(newCards.size() - 1);

                // 尝试除法 (num1 / num2)
                if (num2 != 0) {
                    newNumbers.add(num1 / num2);
                    newCards.add("(" + card1 + "/" + card2 + ")");
                    if (solve24(newNumbers, newCards, expression)) {
                        if (numbers.size() == 4) {
                            expression.append(newCards.get(newCards.size() - 1));
                        }
                        return true;
                    }
                    newNumbers.remove(newNumbers.size() - 1);
                    newCards.remove(newCards.size() - 1);
                }

                // 尝试除法 (num2 / num1)
                if (num1 != 0) {
                    newNumbers.add(num2 / num1);
                    newCards.add("(" + card2 + "/" + card1 + ")");
                    if (solve24(newNumbers, newCards, expression)) {
                        if (numbers.size() == 4) {
                            expression.append(newCards.get(newCards.size() - 1));
                        }
                        return true;
                    }
                    newNumbers.remove(newNumbers.size() - 1);
                    newCards.remove(newCards.size() - 1);
                }
            }
        }

        return false;
    }
}