import java.util.List;

public class ConcreateIterator<T> implements IteratorIF
{
	private List<T> list;
	private int index = 0;
	
	public ConcreateIterator(List<T> list)
	{
		this.list=list;
		index = 0;
	}
	
	public T next()
	{
		return list.get(index++);
	}
	
	public boolean hasNext()
	{
		return index < list.size();
	}
}
