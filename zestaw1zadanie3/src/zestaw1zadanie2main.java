import java.util.*;

public class zestaw1zadanie2main 
{

	public static void main(String[] args) 
	{
		
		System.out.println("Dzialaj!");
		Date data1=new Date(1992,11,11);
		Date data2=new Date(1991,11,11);
		
		Employee prac1 = new Employee("Ala", 2000, data1);
		Manager prac2 =new Manager("Salcio", 3000, data2, "IT");
		
		
		
		String aaa=prac1.getName();
		System.out.println(aaa);
		aaa=prac2.getDetails();
		System.out.println(aaa);
	}

}
