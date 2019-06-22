package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class StudentList extends StudentListAbstract
{
	public StudentList()
	{
		super();
	}

	public StudentList(int initialSize)
	{
		super(initialSize);
	}

	public StudentList(Collection c)
	{
		super(c);
	}

	public StudentList(Operation operation)
	{
		super(operation);
	}
}
