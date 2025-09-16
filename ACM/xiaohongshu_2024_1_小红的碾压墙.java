package ACM;
import java.util.*;

public class xiaohongshu_2024_1_小红的碾压墙 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double followerNumber = in.nextDouble();
        double result = 2 / (followerNumber * (followerNumber-1));
        System.out.println(String.format("%.10f", result));
    }
}
