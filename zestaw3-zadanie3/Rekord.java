public class Rekord {
    
    private static final String NAME_KEY = "imie";

    private Map<String,String> entries = new HashMap<String,String>;

    public Rekord(String[] entries) {
	setImie(entries[0]);
	setLastname(entries[1]);
	setBirthyear(entries[2])
    }

    public void setEntry(String attrName, String value)
	this.entries.put(attrName, value);

    public String getEntry(String attrName)
	return entries.get(attrName);

    public void setImie(String value)
	setEntry(NAME_KEY, value);

    public String getImie()
	return getEntry(NAME_KEY);

    public static Rekord parse(String line) {
	String[] entries = line.split(",");

	return new Rekord(entries);
    }
}