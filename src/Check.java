
public class Check {
	private double menuPrice;
	private double salesTax;
	private double tip;

	public Check(double menuPrice) {
		double tax = menuPrice*0.15;
		this.menuPrice = menuPrice;
		this.salesTax = tax;
		//TODO tip

	}

	public void setTipByPct(int percentage) {
		double decimalPercent = percentage*0.01;
		tip = decimalPercent * menuPrice;
	}

	public double getMenuPrice() {
		return this.menuPrice;
	}

	public double getSalesTax() {
		return this.salesTax;
	}

	public double getTip() {
		return this.tip;
	}

	public void setTipByPct(double tipPct ) {
		/* TODO: Add your code here */
	}
}
