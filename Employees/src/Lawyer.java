
public class Lawyer extends Employee {
	
	
	
	public Lawyer(int years) {
		super(years);
	}
	
	@Override
	public double getSalary() {
		return super.getSalary() + 5000 * getYears();
	}

	@Override
	public String getVacationForm() {
		return "pink";
	}
	
	@Override
	public int getVacationDays() {
		return super.getVacationDays() + 5;
	}
	
	public void sue() {
		System.out.println("I'll see you in court!");
	}
}
