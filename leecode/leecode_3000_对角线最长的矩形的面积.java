package leecode;

public class leecode_3000_对角线最长的矩形的面积 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxLen = 0;
        for(int i=0; i<dimensions.length; i++){
            int len = dimensions[i][0];
            int wid = dimensions[i][1];
            if((len*len+wid*wid) == maxLen){
                maxLen = len*len+wid*wid;
                maxArea = Math.max(len * wid, maxArea);
            }else if((len*len+wid*wid) > maxLen){
                maxLen = len*len+wid*wid;
                maxArea = len * wid;
            }
        }
        return maxArea;
    }
}
