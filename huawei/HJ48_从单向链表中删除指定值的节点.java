package huawei;

import java.awt.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HJ48_从单向链表中删除指定值的节点 {
    // 定义链表节点
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int total = in.nextInt(); // 总节点数
            int head = in.nextInt(); // 头结点值

            // 构建链表
            LinkedList<Integer> list = new LinkedList<>();
            list.add(head);
            for (int i = 0; i < total - 1; i++) {
                int val = in.nextInt();
                int insertAfter = in.nextInt();
                insertNode(list, val, insertAfter);
            }

            // 读取要删除的节点值
            int toDelete = in.nextInt();

            // 删除节点并打印结果
            remove(list, toDelete);
            printList(list);
        }
    }

    private static void remove(LinkedList<Integer> list, int val) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int a = iterator.next();
            if (a == val) {
                iterator.remove();
            }
        }
    }

    private static void insertNode(LinkedList<Integer> list, int val, int insertAfter) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == insertAfter) {
                list.add(i, val);
                return;
            }
        }
    }

    private static void printList(LinkedList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}