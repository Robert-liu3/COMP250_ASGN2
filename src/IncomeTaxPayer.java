
public abstract class IncomeTaxPayer {

	private static int currentMaxTaxID;
	private int  taxID;
	private String  name;
	private double  income;

	public IncomeTaxPayer(String name){
		this.name = name;
		taxID = currentMaxTaxID++;
	}


	public static int getCurrentMaxTaxID() {
		return currentMaxTaxID;
	}

	public int getTaxID() {
		return taxID;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome( double income) {
		this.income = income;
	}

	public String toString() {
		return "  " + taxID + " " + name + " income " + income ;
	}

	public boolean equals(Object obj) {
		boolean theyEqual = false;
		if (obj instanceof IncomeTaxPayer) {
			if (this.getTaxID() == ((IncomeTaxPayer) obj).getTaxID()) {
				theyEqual = true;
			}
		}
		return theyEqual;
	}

	public abstract double calculateIncomeTax();
}
