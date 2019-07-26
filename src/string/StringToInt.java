package string;
/**
 * 将整数字符串转成整数值
 * 给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数(也就是int能表示的范围)的范围，返回str所代表的整数值，否则返回0。
举例：
str=“123”，返回123
str=“023”，因为“023”不符合日常的书写习惯，所以返回0
str=“A13”，返回0
str=“0”，返回0
str=“2147483647”，返回2147483647
str=“2147483648”，因为溢出了，所以返回0
str=“-123”，返回123

int的范围可以表示为
Integer.MAX_VALUE 2147483647
Integer.MIN_VALUE -2147483648
 * */


public class StringToInt {
	public static void main(String[] args){
		
		String[] strarray = new String[8];
		strarray[0] = "123";
		strarray[1] = "023";
		strarray[2]= "A13";
		strarray[3]= "0";
		strarray[4] = "2147483647";
		strarray[5] = "2147483648";
		strarray[6] = "-123";
		strarray[7] = "-0";
		for(String str:strarray){
			System.out.println(str+"\t\t--->>>\t"+convert(str));
		}
	}
	
	public static boolean isValid(char[] chars){
		if(chars.length == 0){
			return false;
		}
		//判断第一位，是不是负号或者0到9
		if(chars[0] != '-'&&(chars[0]<'0'||chars[0]>'9')){
			return false;
		}
		//如果是负号的话，就要对下一位进行首位判断
		if(chars[0] == '-'&&(chars.length == 1||chars[1]==0)){
			return false;
		}
		//只有第一位的话第一位不能为0
		if(chars[0] == '0'&&chars.length > 1){
			return false;
		}
		//判断后面的其他位
		for(int i = 1;i<chars.length;i++){
			if(chars[i]<'0'||chars[i]>'9'){
				return false;
			}
		}
		return true;
	}	
	public static int convert(String str){
		char[] chars = str.toCharArray();
		if(isValid(chars) == false){
			return 0;
		}
		boolean positive = chars[0] == '-'?true:false;
		int minq = Integer.MIN_VALUE/10;
		int minr = Integer.MIN_VALUE%10;
		int res = 0;
		int cur = 0;
		//对于2147483648正数则无法判别，会从for循环成功出来，所以还要筛选
		for(int i = positive?1:0;i<chars.length;i++){
			cur = '0'-chars[i];
			if(res<minq||(res == minq&&cur<minr)){
				return 0;
			}
			res = res*10 + cur;
		}
		//2147483647+1 = -2147483648
		if(positive == true&&res == Integer.MIN_VALUE){
			return 0;
		}
		//注意res本身就已经是负值
		return positive?res:-res;
	}
}
