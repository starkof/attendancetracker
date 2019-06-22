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
public class FacultyListAbstract extends DelegatingList<Faculty> implements MithraTransactionalList<Faculty>
{
	public FacultyListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public FacultyListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public FacultyListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public FacultyListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Faculty[] elements()
	{
		Faculty[] result = new Faculty[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public FacultyList intersection(FacultyList another)
	{
		return (FacultyList)super.intersection(another);
	}

	public Faculty getFacultyAt(int index)
	{
		return (Faculty)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	Department.departmentId = this.departmentId</pre>
	* @see Department#getFaculty() reverse relationship Department.getFaculty()
	* @return The department
	*/
	public DepartmentList getDepartments()
	{
		return (DepartmentList) this.getDelegated().resolveRelationship(this, FacultyFinder.department());
	}

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getFaculty() reverse relationship Course.getFaculty()
	* @return courses
	*/
	public CourseList getCourses()
	{
		return (CourseList) this.getDelegated().resolveRelationship(this, FacultyFinder.courses());
	}

	/**
	* Relationship Expression:<pre>
	Person.personId = this.personId</pre>
	* @see Person#getFaculty() reverse relationship Person.getFaculty()
	* @return The person
	*/
	public PersonList getPersons()
	{
		return (PersonList) this.getDelegated().resolveRelationship(this, FacultyFinder.person());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return FacultyFinder.getMithraObjectPortal();
	}

	public FacultyList getNonPersistentCopy()
	{
		FacultyList result = new FacultyList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public FacultyList asAdhoc()
	{
		return (FacultyList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Faculty> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public FacultyList merge(MithraTransactionalList<Faculty> incoming, TopLevelMergeOptions<Faculty> mergeOptions)
	{
		return (FacultyList) super.merge(incoming, mergeOptions);
	}

	public FacultyList getDetachedCopy()
	{
		FacultyList result = new FacultyList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(FacultyFinder.courseId(), newValue);
	}

	public void setDepartmentId(int newValue)
	{
		zSetInteger(FacultyFinder.departmentId(), newValue);
	}

	public void setFacultyId(int newValue)
	{
		zSetInteger(FacultyFinder.facultyId(), newValue);
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(FacultyFinder.personId(), newValue);
	}

	public void setDepartmentIdNull()
	{
		zSetAttributeNull(FacultyFinder.departmentId());
	}

	public void setCourseIdNull()
	{
		zSetAttributeNull(FacultyFinder.courseId());
	}

	public void setPersonIdNull()
	{
		zSetAttributeNull(FacultyFinder.personId());
	}
}
