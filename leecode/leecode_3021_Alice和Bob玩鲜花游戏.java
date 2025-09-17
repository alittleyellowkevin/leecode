package leecode;

public class leecode_3021_Alice和Bob玩鲜花游戏 {
    public long flowerGame(int n, int m) {
        long nEvenNumber = n/2;
        long nOddNumber = n%2==1? n/2+1:n/2;
        long mEvenNumber = m/2;
        long mOddNumber = m%2==1? m/2+1:m/2;
        return nEvenNumber * mOddNumber + nOddNumber * mEvenNumber;
    }
}
