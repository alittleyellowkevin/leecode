package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_228_汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            String content = String.valueOf(nums[i]);

            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1){
                i++;
            }

            if(Integer.parseInt(content) != nums[i]){
                content += "->" + nums[i];
            }

            res.add(content);

        }
        return res;
    }
}
