package leecode;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));    // 返回 3
        System.out.println(lruCache.get(4));    // 返回 4
    }
    public class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    HashMap<Integer, Node> map = new HashMap<>();
    Node tail;
    Node head;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        this.size = 0;
        this.head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        //从map中获得key，如果存在的则直接返回，并将其节点移到链表最前面
        if(map.containsKey(key)){
            moveToFirst(key);
            return map.get(key).value;
        }
        return -1;
    }

    private void moveToFirst(int key) {
        Node now = map.get(key);
        now.pre.next = now.next;
        now.next.pre = now.pre;
        now.next = this.head.next;
        this.head.next = now;
        now.next.pre = now;
        now.pre = this.head;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //当map中存在当前节点直接修改value将其转到链表最前面
            map.get(key).value = value;
            moveToFirst(key);
        }else {
            if(size >= this.capacity){
                //如果size超过容量则将链表最后的节点删除，加入新节点放入链表最前面
                moveLast();
                Node node = new Node(key, value);
                map.put(key, node);
                node.next = this.head.next;
                this.head.next = node;
                node.next.pre = node;
                node.pre = this.head;
            }else {
                //如果map中不包含当前节点，且当前节点数低于容量，则将其加入map，并将放在链表最前面
                Node node = new Node(key, value);
                map.put(key, node);
                node.next = this.head.next;
                this.head.next = node;
                node.next.pre = node;
                node.pre = this.head;
                size++;
            }
        }
    }

    private void moveLast() {
        map.remove(tail.pre.key);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }
}
