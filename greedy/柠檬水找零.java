package greedy;

import java.util.ArrayList;
import java.util.List;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        List<Integer> fives = new ArrayList<>();
        List<Integer> tens = new ArrayList<>();
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                fives.add(5);
            } else if (bills[i] == 10) {
                if(fives.size()>0){
                    tens.add(10);
                    fives.remove(fives.size()-1);
                }else{
                    return false;
                }
            }else {
                if(!tens.isEmpty()){
                    tens.remove(tens.size()-1);
                    if(fives.size()>0){
                        fives.remove(fives.size()-1);
                    }else {
                        return false;
                    }
                }else {
                    if(fives.size()>=3){
                        fives.remove(fives.size()-1);
                        fives.remove(fives.size()-1);
                        fives.remove(fives.size()-1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
