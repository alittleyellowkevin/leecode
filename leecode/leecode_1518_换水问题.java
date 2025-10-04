package leecode;

public class leecode_1518_换水问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int fullBottle = numBottles;
        int emptyBottle = 0;
        int drinkBottleNumber = 0;
        while(fullBottle > 0 || emptyBottle >= numExchange){
            drinkBottleNumber += fullBottle;
            emptyBottle += fullBottle;
            fullBottle = 0;
            if(emptyBottle >= numExchange){
                emptyBottle -= numExchange;
                fullBottle++;
            }
        }
        return drinkBottleNumber;
    }
}
