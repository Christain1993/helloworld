package _Double;

public class DoubleTest {
	/**
	 * 讲传入的金额进行取整操作
	 * 
	 * @param 金额
	 * @param 金额的取整方式
	 *            （0：四舍五入 1：向上取整到元 2向下取整到元 3 半取整（ 不够0.5元按0.5元算，超过0.5元按1元算））
	 * @return 取整后的金额
	 */
	public static double roundamount(double amount, int roundmode) {
		double aa = 0;
		switch (roundmode) {
		case 1:
			aa = new Double(Math.ceil(amount));
			break;
		case 2:
			aa = new Double(Math.floor(amount));
			break;
		case 3:
			aa = new Double(String.format("%.0f", amount));
			String d = String.valueOf(amount);
			Double x = new Double(d.substring(d.indexOf("."), d.length()));
			if (x == 0.5){
				return amount;
			}else if (aa < amount) {
				aa += 0.5;
			}
			break;

		default:
			aa = new Double(String.format("%.0f", amount));
			break;
		}
		return aa;
	}
	public static void main(String[] args) {
//		Double d = 20D;
//		double roundamount = roundamount(d*0.1, 3);
//		System.out.println(roundamount);
		final Double d ;
		d = new Double(100);
		System.out.println(d);
		
		
	}
}
