package string;

import org.omg.CORBA.INTERNAL;
//剑指offer46题，把数字翻译成字符串
public class IntToString {
    public static void main(String[] args){
        int[] input = {0,0,0,1,0,0};
        System.out.println(count(input));
    }
    public static int count(int[] input) {
        if (input == null || input.length <= 1) {
            return 1;
        }
        //int count = 0;
        int[] map = new int[input.length];
        map[0] = 1;
        map[1] = map[0] + g(input,1);
        for(int i = 2;i<input.length;i++){
            map[i] = map[i-1] + map[i-2]*g(input,i);
        }
        return map[map.length-1];

    }
    public static int g(int[] input,int index){
        if(index == 0){
            return 1;
        }
        if(input[index-1] == 0)
            return 0;
        int coop = input[index-1]*10+input[index];
        if(coop>0&&coop<=25){
            return 1;
        }
        else if(coop<=0||coop>25){
            return 0;
        }
        return 0;
    }


}
