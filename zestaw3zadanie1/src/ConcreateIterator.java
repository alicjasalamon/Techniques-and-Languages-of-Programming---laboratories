import java.util.List;

public class ConcreateIterator implements IteratorIF
{
	private List list;
	private int index = 0;
	
	public ConcreateIterator(List list)
	{
		this.list=list;
		index = 0;
	}
	
	public Object next()
	{
		return list.get(index++);
	}
	
	public boolean hasNext()
	{
		return index < list.size();
	}
}
