package com.mithraobjects;
import com.gs.fw.finder.Operation;
import java.util.*;
public class CourseList extends CourseListAbstract
{
	public CourseList()
	{
		super();
	}

	public CourseList(int initialSize)
	{
		super(initialSize);
	}

	public CourseList(Collection c)
	{
		super(c);
	}

	public CourseList(Operation operation)
	{
		super(operation);
	}
}
