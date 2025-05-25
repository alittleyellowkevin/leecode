package 字符串;

public class leecode_838_推多米洛 {
    public String pushDominoes(String dominoes) {
        int windDirection = 0; // 倒的方向
        int rightStart = -1; // 左然后右第一个的方向
        char[] dominoesArray = dominoes.toCharArray();
        for (int i = 0; i < dominoes.length(); i++) {
            char currentChar = dominoes.charAt(i);

            // 当此位置为'.'且有倒下的方向时，则将当前点设置为 R
            if (currentChar == '.' && windDirection == 1) {
                dominoesArray[i] = 'R';
            }
            // 当此位置为'R'时，设置倒下方向
            else if (currentChar == 'R') {
                rightStart = i;
                windDirection = 1;
                dominoesArray[i] = 'R';
            }
            // 当此位置
            else if (currentChar == 'L') {
                windDirection = 0;
                if (rightStart != -1) {
                    int mid = (i - rightStart) / 2;
                    for (int j = 1; j <= mid; j++) {
                        dominoesArray[rightStart + j] = 'R';
                        dominoesArray[i - j] = 'L';
                    }
                    if ((i - rightStart) % 2 == 0) {
                        dominoesArray[rightStart + mid] = '.';
                    }
                } else {
                    for (int j = i - 1; j >= 0 && dominoesArray[j] == '.'; j--) {
                        dominoesArray[j] = 'L';
                    }
                }
                rightStart = -1;
                dominoesArray[i] = 'L';
            }
        }
        return new String(dominoesArray);
    }
}
