package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class GenderList extends GenderListAbstract
{
	public GenderList()
	{
		super();
	}

	public GenderList(int initialSize)
	{
		super(initialSize);
	}

	public GenderList(Collection c)
	{
		super(c);
	}

	public GenderList(Operation operation)
	{
		super(operation);
	}
}
