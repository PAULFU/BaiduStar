package ColumnDispacement;

import java.util.Scanner;
/**
 * Created by fupinyou on 2016/5/13.
 */

public class Solution{
    public static String decryption(int key, String string) {
        int length = string.length();
        char[] ch = string.toCharArray();
        char[] result = new char[length];
        int mark = 0;
        for (int i = 0; i < length; i++) {
            result[mark] = ch[i];
            mark = mark + key;
            if (mark >= length) {        //大于时，说明这一列已经读完了，此时需要换一列
                mark = mark % key + 1;   //每列的余数是相同的，加1表示向右移动一列
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] st=new String[count];
        int[] k=new int[count];
        for (int i = 0; i < count; i++) {
            st[i] = sc.next();
            k[i] = sc.nextInt();
        }

        for (int j=0;j<count;j++){
            System.out.println("Case #" + (j + 1));
            System.out.println(decryption(k[j], st[j]));
        }
    }
}
