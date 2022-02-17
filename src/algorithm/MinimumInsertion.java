package algorithm;

import java.util.Scanner;

public class MinimumInsertion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        // '(' 开口朝右括号
        int[] rightPars = new int[str.length()];
        // ’)‘ 开口朝左括号
        int[] leftPars = new int[str.length()];

        // 第一次遍历 根据给定括号在对应数组记录
        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i))
                rightPars[i] = 1;
            else if (')' == str.charAt(i))
                leftPars[i] = 1;
        }

        // 第二次遍历 从‘(’ 开始查 分别找对应的位置后面有没有 ‘)’
        // 用于记录最靠前、未被消费的’)‘的下标
        int leftParsPoint = -1;
        for (int i = 0; i < str.length(); i++) {
            if (rightPars[i] == 1) {
                boolean stop = true;
                for (int j = i + 1; j < str.length() - 1; j++) {
                    if (leftPars[j] == 1 && leftPars[j + 1] == 1) {
                        leftPars[j] = 0;
                        leftPars[j + 1] = 0;
                        rightPars[i] = 0;
                        stop = false;
                        break;
                    }
                }
                if (stop){
                    leftParsPoint = i;
                    break;
                }
            }
        }

        if (leftParsPoint == -1){
            System.out.println(0);
        }
        else {
            int totalNumber = 0;
            for (int i = leftParsPoint; i < str.length() && rightPars[i] == 1; i++) {
                boolean exist = false;
                for (int j = i + 1; j < str.length(); j++) {
                    if (leftPars[j] == 1) {
                        totalNumber++;
                        exist = true;
                        break;
                    }
                }

                // 一旦不存在，证明所有后面的'('都没有单个')'了，只能插两个')'
                if (!exist) {
                    for (int j = i; j < str.length(); j++) {
                        if (rightPars[j] == 1)
                            totalNumber += 2;
                    }
                    break;
                }

            }


            System.out.println(totalNumber);
        }




    }
}
