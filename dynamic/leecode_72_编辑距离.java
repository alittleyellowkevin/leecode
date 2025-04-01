package dynamic;

public class leecode_72_编辑距离 {
    public int minDistance(String word1, String word2) {
        // 1.res[i][j] 表示 word1[0,i] 和 word2[0,j] 的最小编辑距离

        int[][] res = new int[word1.length()+1][word2.length()+1];
        // 2. 初始化 首先word1[0,i] 和 word2[0,0] 的编辑距离为i
        for (int i = 0; i < word1.length()+1; i++) {
            res[i][0] = i;
        }
        // 2. 初始化 首先word1[0,0] 和 word2[0,j] 的编辑距离为j
        for (int i = 0; i < word2.length()+1; i++) {
            res[0][i] = i;
        }

        // 3. 递推
        // 如果当前 word 字母相同 则 两个词的编辑距离为 res[i-1][j-1] 
        // 如果当前 word 字母不同 则 两个词的编辑距离为 res[i-1][j-1] + 1--替换
        // 如果当前 word 字母不同 则 两个词的编辑距离为 res[i][j-1] + 1--插入
        // 如果当前 word 字母不同 则 两个词的编辑距离为 res[i-1][j] + 1--删除
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1];
                }else {
                    res[i][j] = Math.min(Math.min(res[i-1][j-1],res[i][j-1]), Math.min(res[i][j-1], res[i-1][j])) + 1;
                }
            }
        }
        return res[word1.length()][word2.length()];
    }
}
