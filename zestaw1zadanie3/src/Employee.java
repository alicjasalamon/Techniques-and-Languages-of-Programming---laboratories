import java.util.*;

public class Employee 
{
	String name;
	double salary;
	Date birthDate;
	
	
	/////////////////////////////KONSTRUKTORY////////////////////////////////////////////
	
	public Employee(String name, double salary, Date birthDate)
	{
		this.name=name;
		this.salary=salary;
		this.birthDate=birthDate;
	}
	
	public Employee()
	{
		name="";
		salary=0;
		birthDate= new Date();
	}
	
	//////////////////////////METODY GET/////////////////////////////////////////////////
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getBirhtDate()
	{
		return birthDate;
	}
	
	///////////////////////////METODY SET////////////////////////////////////////////////
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	
	public void setBirthDate(Date BirthDate)
	{
		this.birthDate=BirthDate;
	}
	
	/////////////////////////////////GET DETAILS////////////////////////////////////////
	
	public String getDetails()
	{
		return (name + " ," + salary + " ," + birthDate);
	}
}
