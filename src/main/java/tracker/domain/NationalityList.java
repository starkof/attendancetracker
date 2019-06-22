package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class NationalityList extends NationalityListAbstract
{
	public NationalityList()
	{
		super();
	}

	public NationalityList(int initialSize)
	{
		super(initialSize);
	}

	public NationalityList(Collection c)
	{
		super(c);
	}

	public NationalityList(Operation operation)
	{
		super(operation);
	}
}
