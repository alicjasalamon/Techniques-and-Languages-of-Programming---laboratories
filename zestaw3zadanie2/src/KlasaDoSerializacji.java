import java.io.Serializable;

public class KlasaDoSerializacji implements Serializable
{
	private String name = null;
	
	public KlasaDoSerializacji(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
}
