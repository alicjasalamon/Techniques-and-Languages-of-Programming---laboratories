
public class nfwed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int i=0; i<5; i++)
		{
			System.out.println(Math.sin(6.28*i/5)+ " " + Math.cos(6.28*i/5) + " 0");
		}
		System.out.println();
		for(int i=0; i<5; i++)
		{
			System.out.println (0.5*Math.sin(6.28*i/5 + 2*0.314)+ " " +  (0.5*Math.cos(6.28*i/5 + 2*0.314))+ " " +" 0");
		}

	}

}
