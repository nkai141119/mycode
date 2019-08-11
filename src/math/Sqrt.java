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
 * 二分法在本机运行1e-15就需要很长时间了，而牛顿迭代法仍然是瞬间出值
 * 
 * 时间复杂度：对牛顿迭代法来说时间复杂度完全无法表征，因为实际收敛速度比理论n^(2+small number)快很多
 * */
public class Sqrt {
	public static void main(String[] args){
		double a = 555;
		System.out.println(sqrtNewton(a));
		System.out.println(sqrtBinary(a));
		
	}
	/**
	 * 牛顿迭代法求实数平方根
	 * */
	public static double sqrtNewton(double a){
		if(a<0){
			return Double.NaN;//如果小于0返回缺省值
		}
		double e = 1e-15;
		double x = a;
		while(Math.abs(x-a/x)>e*x){
			x = (a/x+x)/2.0;
		}
		return x;
	}
	/**
	 * 二分法求实数平方根
	 * */
	public static double sqrtBinary(double a){
		if(a<0){
			return Double.NaN;//小于0则返回缺省值
		}
		double e = 1e-12;
		double left = 0;
		double right = a;
		double mid = (right + left)/2.0;
		double k = mid*mid;
		//把平方存下来比不存好，省得再算一遍
		while(Math.abs(k-a)>e){
			if(k>a){
				right = mid;
				mid = (right + left)/2.0;
				k = mid*mid;
			}
			else{
				left = mid;
				mid = (right + left)/2.0;
				k = mid*mid; 
			}
		}
		return mid;
		
	}
	
}
