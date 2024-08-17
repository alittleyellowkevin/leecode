package dynamic;

public class 编辑距离_leecode_72 {
    public int minDistance(String word1, String word2) {
        
        if(word2.length() > word1.length()){
            int max = 0;
            for (int i = 0; i < word2.length()-word1.length(); i++) {
                int number = 0;
                for (int j = 0; j < word1.length(); j++) {
                    if(word2.charAt(i+j) == word1.charAt(j)){
                        number++;
                    }
                }
                max = Math.max(max, number);
            }
            return word2.length() - max;
        }else {
            int max = 0;
            for (int i = 0; i < word1.length()-word2.length(); i++) {
                int number = 0;
                for (int j = 0; j < word2.length(); j++) {
                    if(word1.charAt(i+j) == word2.charAt(j)){
                        number++;
                    }
                }
                max = Math.max(max, number);
            }
            return word1.length()-max;
        }
    }
}
