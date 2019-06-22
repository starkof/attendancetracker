package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class FacultyList extends FacultyListAbstract
{
	public FacultyList()
	{
		super();
	}

	public FacultyList(int initialSize)
	{
		super(initialSize);
	}

	public FacultyList(Collection c)
	{
		super(c);
	}

	public FacultyList(Operation operation)
	{
		super(operation);
	}
}
