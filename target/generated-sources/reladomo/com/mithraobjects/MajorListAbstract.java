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
public class MajorListAbstract extends DelegatingList<Major> implements MithraTransactionalList<Major>
{
	public MajorListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public MajorListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public MajorListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public MajorListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Major[] elements()
	{
		Major[] result = new Major[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public MajorList intersection(MajorList another)
	{
		return (MajorList)super.intersection(another);
	}

	public Major getMajorAt(int index)
	{
		return (Major)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	this.majorId = Department.majorId</pre>
	* @see Department#getMajor() reverse relationship Department.getMajor()
	* @return The department
	*/
	public DepartmentList getDepartments()
	{
		return (DepartmentList) this.getDelegated().resolveRelationship(this, MajorFinder.department());
	}

	/**
	* Relationship Expression:<pre>
	this.majorId = Student.majorId</pre>
	* @see Student#getMajor() reverse relationship Student.getMajor()
	* @return students
	*/
	public StudentList getStudents()
	{
		return (StudentList) this.getDelegated().resolveRelationship(this, MajorFinder.students());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return MajorFinder.getMithraObjectPortal();
	}

	public MajorList getNonPersistentCopy()
	{
		MajorList result = new MajorList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public MajorList asAdhoc()
	{
		return (MajorList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Major> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public MajorList merge(MithraTransactionalList<Major> incoming, TopLevelMergeOptions<Major> mergeOptions)
	{
		return (MajorList) super.merge(incoming, mergeOptions);
	}

	public MajorList getDetachedCopy()
	{
		MajorList result = new MajorList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(MajorFinder.majorId(), newValue);
	}

	public void setMajorName(String newValue)
	{
		zSetString(MajorFinder.majorName(), newValue);
	}
}
