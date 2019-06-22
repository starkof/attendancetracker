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
public class StudentListAbstract extends DelegatingList<Student> implements MithraTransactionalList<Student>
{
	public StudentListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public StudentListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public StudentListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public StudentListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Student[] elements()
	{
		Student[] result = new Student[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public StudentList intersection(StudentList another)
	{
		return (StudentList)super.intersection(another);
	}

	public Student getStudentAt(int index)
	{
		return (Student)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	Major.majorId = this.majorId</pre>
	* @see Major#getStudents() reverse relationship Major.getStudents()
	* @return The major
	*/
	public MajorList getMajors()
	{
		return (MajorList) this.getDelegated().resolveRelationship(this, StudentFinder.major());
	}

	/**
	* Relationship Expression:<pre>
	Person.personId = this.personId</pre>
	* @see Person#getStudent() reverse relationship Person.getStudent()
	* @return The person
	*/
	public PersonList getPersons()
	{
		return (PersonList) this.getDelegated().resolveRelationship(this, StudentFinder.person());
	}

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getStudents() reverse relationship Course.getStudents()
	* @return courses
	*/
	public CourseList getCourses()
	{
		return (CourseList) this.getDelegated().resolveRelationship(this, StudentFinder.courses());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return StudentFinder.getMithraObjectPortal();
	}

	public StudentList getNonPersistentCopy()
	{
		StudentList result = new StudentList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public StudentList asAdhoc()
	{
		return (StudentList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Student> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public StudentList merge(MithraTransactionalList<Student> incoming, TopLevelMergeOptions<Student> mergeOptions)
	{
		return (StudentList) super.merge(incoming, mergeOptions);
	}

	public StudentList getDetachedCopy()
	{
		StudentList result = new StudentList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setAdmissionDate(Date newValue)
	{
		zSetDate(StudentFinder.admissionDate(), newValue);
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(StudentFinder.courseId(), newValue);
	}

	public void setExpectedGraduation(Date newValue)
	{
		zSetDate(StudentFinder.expectedGraduation(), newValue);
	}

	public void setGpa(int newValue)
	{
		zSetInteger(StudentFinder.gpa(), newValue);
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(StudentFinder.majorId(), newValue);
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(StudentFinder.personId(), newValue);
	}

	public void setStudentId(int newValue)
	{
		zSetInteger(StudentFinder.studentId(), newValue);
	}

	public void setMajorIdNull()
	{
		zSetAttributeNull(StudentFinder.majorId());
	}

	public void setGpaNull()
	{
		zSetAttributeNull(StudentFinder.gpa());
	}

	public void setPersonIdNull()
	{
		zSetAttributeNull(StudentFinder.personId());
	}

	public void setCourseIdNull()
	{
		zSetAttributeNull(StudentFinder.courseId());
	}
}
