package ACM;
import java.util.*;

public class xiaomi_2024_2_排队选人 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int studentNumber = in.nextInt();
        int selectNumber = in.nextInt();
        int lowTalent = in.nextInt();
        int lowCollective = in.nextInt();

        Set<Integer> failSet = new HashSet<>();
        for(int i=0; i<studentNumber; i++){
            if(in.nextInt() < lowTalent){
                failSet.add(i);
            }
        }
        for(int i=0; i<studentNumber; i++){
            if(in.nextInt() < lowCollective){
                failSet.add(i);
            }
        }
        List<Integer> list = new ArrayList<>(failSet);
        Collections.sort(list);
        int count = 0;
        for(int i=0; i<list.size(); i++){
            if(i == 0){
                int firstMan = list.get(i);
                count += (firstMan - selectNumber + 1)<0?0:(firstMan - selectNumber + 1);
            }
            if(i == list.size()-1){
                int lastMan = list.get(i);
                count += (studentNumber - lastMan - selectNumber)<0?0:(studentNumber - lastMan - selectNumber);
            }
            if(i > 0 && i <= list.size()-1){
                int pre = list.get(i-1);
                int current = list.get(i);
                count += (current - pre - selectNumber)<0?0:(current - pre - selectNumber);
            }
        }
        System.out.println(count);
    }
}
