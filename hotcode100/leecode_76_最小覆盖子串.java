package hotcode100;

public class leecode_76_最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('a'));
    }
    public String minWindow(String s, String t) {
        int start=0;
        int end=0;
        int resultStart = 0;
        int resultEnd = 0;
        int result = Integer.MAX_VALUE;
        int[] sMap = new int[60];
        int[] tMap = new int[60];

        // 初始化
        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i) - 'A']++;
        }

        // 循环
        for(; end<s.length(); end++){
            sMap[s.charAt(end) - 'A']++;
            while (isContain(sMap, tMap)){
                if(result < (end - start + 1)){
                    resultStart = start;
                    resultEnd = end;
                }
                result = Math.min(result, end - start);
                sMap[s.charAt(start)-'A']--;
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(resultStart, resultEnd+1);
    }

    private boolean isContain(int[] sMap, int[] tMap) {
        for(int i=0; i< sMap.length; i++){
            if(sMap[i] >= tMap[i]){
                return false;
            }
        }
        return true;
    }
}
