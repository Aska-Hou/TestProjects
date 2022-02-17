package algorithm;

import java.util.Scanner;

public class MinimumInsert {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int numberOfLeft = 0;
        int totalCount = 0;
        for (int i = 0; i < str.length(); i++){
            char par = str.charAt(i);
            if ('(' == par)
                numberOfLeft++;
            else {
                // 如果没有左括号了，需要插一个
                if (numberOfLeft == 0){
                    totalCount++;
                    numberOfLeft++;
                }

                // 还有左括号的话，需要判断右括号是否连续
                // 如果连续的话，消掉1个左，指针右移动
                if (i != str.length() - 1 && ')' == str.charAt(i + 1)){
                    i++;
                    numberOfLeft--;
                }
                // 不连续或者是最后一个元素的话，插一个右，指针不移动
                else {
                    totalCount++;
                    numberOfLeft--;
                }
            }
        }
        // 最后给空闲的左括号插入右括号
        totalCount += numberOfLeft * 2;
        System.out.println(totalCount);

    }
}
