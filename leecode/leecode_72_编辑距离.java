package leecode;

public class leecode_72_编辑距离 {
    public int minDistance(String word1, String word2) {
        int[][] mauCount = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < mauCount.length; i++) {
            mauCount[i][0] = i;
        }
        for (int i = 0; i < mauCount[0].length; i++) {
            mauCount[0][i] = i;
        }
        for (int i = 1; i < mauCount.length; i++) {
            for (int j = 1; j < mauCount[0].length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    mauCount[i][j] = mauCount[i-1][j-1];
                }else {
                    mauCount[i][j] = Math.min(Math.min(mauCount[i-1][j], mauCount[i][j-1]), mauCount[i-1][j-1])+1;
                }
            }
        }
        return mauCount[word1.length()][word2.length()];
    }
}
