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
public class CourseListAbstract extends DelegatingList<Course> implements MithraTransactionalList<Course>
{
	public CourseListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public CourseListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public CourseListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public CourseListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Course[] elements()
	{
		Course[] result = new Course[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public CourseList intersection(CourseList another)
	{
		return (CourseList)super.intersection(another);
	}

	public Course getCourseAt(int index)
	{
		return (Course)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	ClassTimeSlot.timeSlotId = this.timeSlotId</pre>
	* @return time
	*/
	public ClassTimeSlotList getTime()
	{
		return (ClassTimeSlotList) this.getDelegated().resolveRelationship(this, CourseFinder.time());
	}

	/**
	* Relationship Expression:<pre>
	LectureHall.lectureHallId = this.lectureHallId</pre>
	* @return lecture hall
	*/
	public LectureHallList getLectureHall()
	{
		return (LectureHallList) this.getDelegated().resolveRelationship(this, CourseFinder.lectureHall());
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Department.courseId</pre>
	* @see Department#getCourses() reverse relationship Department.getCourses()
	* @return The department
	*/
	public DepartmentList getDepartments()
	{
		return (DepartmentList) this.getDelegated().resolveRelationship(this, CourseFinder.department());
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Faculty.courseId</pre>
	* @see Faculty#getCourses() reverse relationship Faculty.getCourses()
	* @return faculty
	*/
	public FacultyList getFaculty()
	{
		return (FacultyList) this.getDelegated().resolveRelationship(this, CourseFinder.faculty());
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Student.courseId</pre>
	* @see Student#getCourses() reverse relationship Student.getCourses()
	* @return students
	*/
	public StudentList getStudents()
	{
		return (StudentList) this.getDelegated().resolveRelationship(this, CourseFinder.students());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return CourseFinder.getMithraObjectPortal();
	}

	public CourseList getNonPersistentCopy()
	{
		CourseList result = new CourseList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public CourseList asAdhoc()
	{
		return (CourseList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Course> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public CourseList merge(MithraTransactionalList<Course> incoming, TopLevelMergeOptions<Course> mergeOptions)
	{
		return (CourseList) super.merge(incoming, mergeOptions);
	}

	public CourseList getDetachedCopy()
	{
		CourseList result = new CourseList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(CourseFinder.courseId(), newValue);
	}

	public void setEndDate(Date newValue)
	{
		zSetDate(CourseFinder.endDate(), newValue);
	}

	public void setLectureHallId(int newValue)
	{
		zSetInteger(CourseFinder.lectureHallId(), newValue);
	}

	public void setSemester(String newValue)
	{
		zSetString(CourseFinder.semester(), newValue);
	}

	public void setStartDate(Date newValue)
	{
		zSetDate(CourseFinder.startDate(), newValue);
	}

	public void setTimeSlotId(int newValue)
	{
		zSetInteger(CourseFinder.timeSlotId(), newValue);
	}

	public void setTimeSlotIdNull()
	{
		zSetAttributeNull(CourseFinder.timeSlotId());
	}

	public void setLectureHallIdNull()
	{
		zSetAttributeNull(CourseFinder.lectureHallId());
	}
}
