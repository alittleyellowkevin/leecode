package greedy;

public class 分发糖果 {
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }else {
                candies[i] = 1;
            }
        }
        for (int i = ratings.length-2; i >=0 ; i--) {
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] +1);
            }
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
