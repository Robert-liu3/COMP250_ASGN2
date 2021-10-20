
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
		super(name,fixedCosts,owner);
		this.cook = cook;
		this.server = server;
	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	@Override
	public void workShift(int hours) {
		double cookSalaryPerHour = this.getCook().getSalaryPerHour();
		double serverSalaryPerHour = this.getServer().getSalaryPerHour();

		double cookAddedIncome = cookSalaryPerHour*hours;
		double serverAddedIncome = serverSalaryPerHour*hours;
		double salaryExpenses = cookAddedIncome + serverAddedIncome;

		//adding the income of cook and server
		this.getCook().setIncome(this.getCook().getIncome()+cookAddedIncome);
		this.getServer().setIncome(this.getServer().getIncome()+serverAddedIncome);

		//adding salary expenses
		this.getOwner().setSalaryExpenses(this.getOwner().getSalaryExpenses()+salaryExpenses);
	}

	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {
		ArrayList<IncomeTaxPayer> incomeTaxPayerArrayList = new ArrayList<IncomeTaxPayer>();
		incomeTaxPayerArrayList.add(this.getCook());
		incomeTaxPayerArrayList.add(this.getServer());
		incomeTaxPayerArrayList.add(this.getOwner());
		return incomeTaxPayerArrayList;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {
		//variables
		double menuPrice = check.getMenuPrice();

		double cookTip = check.getTip()*0.2;
		double serverTip = check.getTip()*0.8;

		//increasing income
		this.getCook().setIncome(this.getCook().getIncome()+cookTip);
		this.getServer().setIncome(this.getServer().getIncome()+serverTip);
		this.getOwner().setIncome(this.getOwner().getIncome()+menuPrice);

		//increasing sales task
		this.setTotalSalesTax(this.getTotalSalesTax()+check.getSalesTax());
	}

	@Override
	public double getTipPercentage() {
		double targetTipPct = this.getServer().getTargetTipPct();
		return targetTipPct;
	}

}
