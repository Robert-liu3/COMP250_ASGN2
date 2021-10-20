
import java.util.ArrayList;
import java.util.List;

public class TaxCollector {

	private List<FoodPlace> foodPlaces = new ArrayList<>();

	private double incomeTaxCollected;
	private double salesTaxCollected;

	public TaxCollector(List<FoodPlace> foodPlaces) {
		this.foodPlaces = foodPlaces; //this gives a warning due to it being redundant
	}

	public List<FoodPlace> getFoodPlaces() {
		return foodPlaces;
	}

	public double getIncomeTaxCollected() {
		return incomeTaxCollected;
	}

	public double getSalesTaxCollected() {
		return salesTaxCollected;
	}

	public void collectTax() {
		double totalIncomeTax = 0;
		double totalSalesTax = 0;
		//for each loops to loop through each foodplace and their employees
		for (FoodPlace a: foodPlaces) {
			totalSalesTax += a.getTotalSalesTax();
			for (IncomeTaxPayer b: a.getIncomeTaxPayers()) {
				totalIncomeTax += b.calculateIncomeTax();
			}
		}
		//adding the tax values to their respective fields
		incomeTaxCollected = totalIncomeTax;
		salesTaxCollected = totalSalesTax;
	}
	
	public String toString() {
		return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
	}
	
}
