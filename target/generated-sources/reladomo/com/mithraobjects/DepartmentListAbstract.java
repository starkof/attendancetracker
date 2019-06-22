package com.mithraobjects;
import java.util.*;
import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;
import com.gs.fw.finder.OrderBy;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.util.*;
import com.gs.fw.common.mithra.notification.*;
import com.gs.fw.common.mithra.notification.listener.*;
import com.gs.fw.common.mithra.list.cursor.Cursor;
import com.gs.fw.common.mithra.bulkloader.*;
/**
* This file was automatically generated using Mithra 17.0.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class DepartmentListAbstract extends DelegatingList<Department> implements MithraTransactionalList<Department>
{
	public DepartmentListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public DepartmentListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public DepartmentListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public DepartmentListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Department[] elements()
	{
		Department[] result = new Department[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public DepartmentList intersection(DepartmentList another)
	{
		return (DepartmentList)super.intersection(another);
	}

	public Department getDepartmentAt(int index)
	{
		return (Department)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getDepartment() reverse relationship Course.getDepartment()
	* @return courses
	*/
	public CourseList getCourses()
	{
		return (CourseList) this.getDelegated().resolveRelationship(this, DepartmentFinder.courses());
	}

	/**
	* Relationship Expression:<pre>
	Major.majorId = this.majorId</pre>
	* @see Major#getDepartment() reverse relationship Major.getDepartment()
	* @return major
	*/
	public MajorList getMajor()
	{
		return (MajorList) this.getDelegated().resolveRelationship(this, DepartmentFinder.major());
	}

	/**
	* Relationship Expression:<pre>
	this.departmentId = Faculty.departmentId</pre>
	* @see Faculty#getDepartment() reverse relationship Faculty.getDepartment()
	* @return faculty
	*/
	public FacultyList getFaculty()
	{
		return (FacultyList) this.getDelegated().resolveRelationship(this, DepartmentFinder.faculty());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return DepartmentFinder.getMithraObjectPortal();
	}

	public DepartmentList getNonPersistentCopy()
	{
		DepartmentList result = new DepartmentList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public DepartmentList asAdhoc()
	{
		return (DepartmentList) super.asAdhoc();
	}

	public MithraTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	/**
	* Return a view of this list that implements Eclipse Collections MutableList API.
	* Since the returned list will be operation-based, it is effectively read-only,
	* so mutating methods will throw a RuntimeException.
	* (Implemented by a light-weight adapter, not a copy)
	*/
	public org.eclipse.collections.api.list.MutableList<Department> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public DepartmentList merge(MithraTransactionalList<Department> incoming, TopLevelMergeOptions<Department> mergeOptions)
	{
		return (DepartmentList) super.merge(incoming, mergeOptions);
	}

	public DepartmentList getDetachedCopy()
	{
		DepartmentList result = new DepartmentList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(DepartmentFinder.courseId(), newValue);
	}

	public void setDepartmentId(int newValue)
	{
		zSetInteger(DepartmentFinder.departmentId(), newValue);
	}

	public void setDepartmentName(String newValue)
	{
		zSetString(DepartmentFinder.departmentName(), newValue);
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(DepartmentFinder.majorId(), newValue);
	}

	public void setCourseIdNull()
	{
		zSetAttributeNull(DepartmentFinder.courseId());
	}

	public void setMajorIdNull()
	{
		zSetAttributeNull(DepartmentFinder.majorId());
	}
}
