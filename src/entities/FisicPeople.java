package entities;

public class FisicPeople extends CommonsAttributes {

	private float healthSpending; // Gastos com saúde Spending = gastos

	public FisicPeople() {

	}

	public FisicPeople(String name, float annualIncome, float healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public float getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(float healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public float impost() {
		float impost = 0;
		if (annualIncome < 20000) {
			impost += annualIncome * 15 / 100;
		} else if (annualIncome >= 20000) {
			impost += annualIncome * 25 / 100;
		}
		if (healthSpending > 0) {
			impost -= healthSpending / 2;
		}
		return impost;
	}

	@Override
	public String toString() {
		return name + ": R$ " + String.format("%.2f", impost());
	}
}
