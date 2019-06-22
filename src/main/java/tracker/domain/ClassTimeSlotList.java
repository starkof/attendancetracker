package tracker.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class ClassTimeSlotList extends ClassTimeSlotListAbstract
{
	public ClassTimeSlotList()
	{
		super();
	}

	public ClassTimeSlotList(int initialSize)
	{
		super(initialSize);
	}

	public ClassTimeSlotList(Collection c)
	{
		super(c);
	}

	public ClassTimeSlotList(Operation operation)
	{
		super(operation);
	}
}
