package leecode;

public class leecode_3516_找到最近的人 {
    public int findClosest(int x, int y, int z) {
        int acLength = Math.abs(x - z);
        int bcLength = Math.abs(y - z);
        if(acLength > bcLength){
            return 2;
        } else if (bcLength > acLength) {
            return 1;
        }
        return 0;
    }
}
