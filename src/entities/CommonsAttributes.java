package entities;

public abstract class CommonsAttributes {

	protected String name;
	protected float annualIncome; // Income = renda

	public CommonsAttributes() {

	}

	public CommonsAttributes(String name, float annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(float annualIncome) {
		this.annualIncome = annualIncome;
	}

	public abstract float impost();

	public abstract String toString();
}
