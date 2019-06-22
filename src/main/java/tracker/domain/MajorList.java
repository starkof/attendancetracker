package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class MajorList extends MajorListAbstract
{
	public MajorList()
	{
		super();
	}

	public MajorList(int initialSize)
	{
		super(initialSize);
	}

	public MajorList(Collection c)
	{
		super(c);
	}

	public MajorList(Operation operation)
	{
		super(operation);
	}
}
