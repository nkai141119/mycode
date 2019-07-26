package math;
/**
 * 求一个数a的平方根，给定精度
 * 两种方法：二分法、牛顿迭代法
 * 
 * 牛顿迭代法是最终推导出迭代公式 x(K+1) = (a/xk + xk)/2.0;忘了就搜一下
 * 退出条件为 |1-a/x2|<err,也就是|x-a/x|<err
 * 
 * 效率比较：在精度要求不高的时候二者计算次数差不多
 * 但是在高精度要求下牛顿迭代法计算次数远小于二分法
 * 
 * */
public class Sqrt {
	public static void main(String[] args){
		double a = 555;
		System.out.println(sqrtNewton(a));
		
	}
	
	/**
	 * 牛顿迭代法求实数平方根
	 * */
	public static double sqrtNewton(double a){
		if(a<0){
			return Double.NaN;//如果小于0返回缺省值
		}
		double e = 1e-64;
		double x = a;
		while(Math.abs(x-a/x)>e*x){
			x = (a/x+x)/2.0;
		}
		return x;
	}
}
