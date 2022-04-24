package entities;

public class LegalPeople extends CommonsAttributes {

	private int numberOfEmployee;

	public LegalPeople() {

	}

	public LegalPeople(String name, float annualIncome, int numberOfEmployee) {
		super(name, annualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public float impost() {
		float impost = 0;
		if (numberOfEmployee > 10) {
			impost += annualIncome * 14 / 100;
		} else {
			impost += annualIncome * 16 / 100;
		}
		return impost;
	}

	@Override
	public String toString() {
		return name + ": R$ " + String.format("%.2f", impost());
	}
}
