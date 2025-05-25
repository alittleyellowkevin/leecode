package 字符串;

public class 比较版本号_leecode_165 {
    public static void main(String[] args) {
        String s1 = "1.2";
        String s = "1.10";
        compareVersion2(s1, s);
    }
    public static int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int i = 0;
        while (i<strings1.length || i<strings2.length){
            String one = i<strings1.length? strings1[i]:"0";
            String two = i<strings2.length? strings2[i]:"0";
            if(toNumber(one)<toNumber(two)){
                return -1;
            } else if (toNumber(one) > toNumber(two)) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    private static int toNumber(String one) {
        int i = 0;
        while (i<one.length() && one.charAt(i) == '0'){
            i++;
        }
        int sum = 0;
        for (int j = i; j < one.length(); j++) {
            sum = sum*10 + one.charAt(j) - '0';
        }
        return sum;
    }

    public static int compareVersion2(String version1, String version2) {
        int i=0;
        int j=0;
        while (i<version1.length() || j<version2.length()){
            int x = 0;
            for (;  i< version1.length(); i++) {
                if(version1.charAt(i) == '.'){
                    i++;
                    break;
                }
                else {
                    x = x*10 + (version1.charAt(i) - '0');
                }
            }
            int y = 0;
            for (;  j< version2.length(); j++) {
                if(version2.charAt(j) == '.'){
                    j++;
                    break;
                }else {
                    y = y*10 + (version2.charAt(j) - '0');
                }
            }
            if(x > y){
                return 1;
            } else if (y > x) {
                return -1;
            }
        }
        return 0;
    }
}
