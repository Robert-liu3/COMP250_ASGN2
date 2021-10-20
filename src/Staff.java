
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
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		return -1;
	}

	@Override
	public double calculateIncomeTax() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		return -1;
	}

}
