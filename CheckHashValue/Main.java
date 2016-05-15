package CheckHashValue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by fupinyou on 2016/5/14.
 */
public class Main {

    public static int getHashValue(String string, int begin, int end) {
        begin = begin - 1;
        end = end - 1;
        char[] chars = string.toCharArray();
        int result=1;
        for (int i = begin; i <= end; i++) {
            int k = chars[i] - 28;
            result = result*k;
            result = result % 9973;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        String str;
        String[] line;
        Queue<Integer> queue = new LinkedList<Integer>();
        int last=1;
        while (scanner.hasNextLine()) {
            count = scanner.nextInt();
            scanner.nextLine();
            str = scanner.nextLine();
            line = new String[count];
            for (int i = 0; i < count; i++) {
                line[i] = scanner.nextLine();
            }
            for (int j = 0; j < count; j++) {
                String[] interval;
                int begin;
                int end;
                if (!line[j].equals("")){
                   interval = line[j].split(" ");
                    begin = Integer.parseInt(interval[0]);
                    end = Integer.parseInt(interval[1]);
                }
                else {
                    queue.offer(last);
                    continue;
                }

                if(begin>end){
                    int temp=begin;
                    begin=end;
                    end=temp;
                }

                if(begin<0 || end<0 || begin>str.length() || end>str.length())
                    queue.offer(last);
                else{
                    queue.offer(getHashValue(str, begin, end));
                    last=getHashValue(str, begin, end);
                }
            }
        }
        int rst;
        while (!queue.isEmpty()) {
            rst = queue.poll();
            System.out.print(rst + "\n");
        }
    }
}
