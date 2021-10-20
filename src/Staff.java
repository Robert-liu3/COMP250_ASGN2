
public class Staff extends IncomeTaxPayer {

	private int salaryPerHour;
	final private int incomeTaxPercentage = 25;

	public Staff(String name, boolean isCook) {
		super(name);
		int cookSalaryPerHour = 20;
		int otherSalaryPerHour = 10;
		if (isCook) {
			salaryPerHour = cookSalaryPerHour;
		}
		else { salaryPerHour = otherSalaryPerHour;}
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public int getIncomeTaxPercentage() {
		return incomeTaxPercentage;
	}

	public double workHours(int numHours) {
		double moneyEarned;
		moneyEarned = this.getSalaryPerHour()*numHours; //money earned within that hour
		this.setIncome(this.getIncome()+moneyEarned); //increments the income by the amount of money earned
		return moneyEarned;
	}

	@Override
	public double calculateIncomeTax() {
		//double incomeAfterTax;
		double tax;
		tax = this.getIncome()*incomeTaxPercentage*0.01; //get the income tax needed to pay
		//incomeAfterTax = this.getIncome()-tax;
		return tax;
	}

}
