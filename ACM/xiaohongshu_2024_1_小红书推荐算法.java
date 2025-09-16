package ACM;

import java.util.*;

public class xiaohongshu_2024_1_小红书推荐算法 {
    public static void main(String[] args) {
        String test =  "dddeddede";
        String[] array = test.split("\\.");
        System.out.println(array);
        Scanner in = new Scanner(System.in);
        int thingNumber = in.nextInt();
        int keyWordsNumber = in.nextInt();
        Set<String> set = new HashSet<>();
        PriorityQueue<Merchandise> priorityQueue = new PriorityQueue<>(thingNumber, new Comparator<Merchandise>() {
            @Override
            public int compare(Merchandise o1, Merchandise o2) {
                if(o2.count == o1.count){
                    return o1.index - o2.index;
                }
                return o2.count - o1.count;
            }
        });
        for(int i=0; i<keyWordsNumber; i++){
            set.add(in.next());
        }

        for(int i=0; i<thingNumber; i++){
            String thingName = in.next();
            int keyNumber = in.nextInt();
            int count = 0;
            for(int j=0; j<keyNumber; j++){
                if(set.contains(in.next())){
                    count++;
                }
            }
            priorityQueue.offer(new Merchandise(count, thingName, i));
        }

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll().name);
        }
    }
}
class Merchandise{
    int count;
    String name;
    int index;
    Merchandise(int count, String name, int index){
        this.index = index;
        this.count = count;
        this.name = name;
    }
}

