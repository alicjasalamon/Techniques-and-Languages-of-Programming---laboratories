import java.util.*;


public class Manager extends Employee
{
	String departmentName;
	
	public Manager(String name, double salary, Date birthDate, String departmentName)
	{
		super(name, salary, birthDate);
		this.departmentName = departmentName;
	}
	
	public void setDepartmentName(String departmentName)
	{
		this.departmentName=departmentName;
	}
	
	public String getDepartmentName()
	{
		return departmentName;
	}
	
	public String getDetails()
	{
		String pom=super.getDetails();
		return pom + departmentName;
	}
	
}
	

