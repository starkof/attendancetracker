package tracker.domain;
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
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.behavior.*;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.extractor.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.behavior.state.PersistenceState;
import com.gs.fw.common.mithra.attribute.update.*;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import java.util.Arrays;
import java.util.HashSet;
/**
* This file was automatically generated using Mithra 17.0.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/Abstract.jsp
public abstract class CourseAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Course.class.getName());
	public CourseAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Course getDetachedCopy() throws MithraBusinessException
	{
		return (Course) super.getDetachedCopy();
	}

	public Course getNonPersistentCopy() throws MithraBusinessException
	{
		Course result = (Course) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Course copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Course) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Course zFindOriginal()
	{
		CourseData data = (CourseData) this.currentData;
		Operation op;
		op = CourseFinder.courseId().eq(data.getCourseId());
		return CourseFinder.findOne(op);
	}

	public boolean isModifiedSinceDetachmentByDependentRelationships()
	{
		if(this.isModifiedSinceDetachment()) return true;
		return false;
	}

	private Logger getLogger()
	{
		return logger;
	}

	public MithraDataObject zAllocateData()
	{
		return new CourseData();
	}

	protected void zSetFromCourseData( CourseData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromCourseData( CourseData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCourseIdNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isCourseIdNull();
	}

	public int getCourseId()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		return data.getCourseId();
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(CourseFinder.courseId(), newValue, true, false ,false);
	}

	public boolean isEndDateNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isEndDateNull();
	}

	public Date getEndDate()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		return data.getEndDate();
	}

	public void setEndDate(Date newValue)
	{
		zSetDate(CourseFinder.endDate(), newValue, false, false );
	}

	public boolean isLectureHallIdNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isLectureHallIdNull();
	}

	public int getLectureHallId()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		if (data.isLectureHallIdNull()) MithraNullPrimitiveException.throwNew("lectureHallId", data);
		return data.getLectureHallId();
	}

	public void setLectureHallId(int newValue)
	{
		zSetInteger(CourseFinder.lectureHallId(), newValue, false, false ,true);
	}

	public boolean isSemesterNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isSemesterNull();
	}

	public String getSemester()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		return data.getSemester();
	}

	public void setSemester(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(CourseFinder.semester(), newValue, false, false );
	}

	public boolean isStartDateNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isStartDateNull();
	}

	public Date getStartDate()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		return data.getStartDate();
	}

	public void setStartDate(Date newValue)
	{
		zSetDate(CourseFinder.startDate(), newValue, false, false );
	}

	public boolean isTimeSlotIdNull()
	{
		return ((CourseData) this.zSynchronizedGetData()).isTimeSlotIdNull();
	}

	public int getTimeSlotId()
	{
		CourseData data = (CourseData) this.zSynchronizedGetData();
		if (data.isTimeSlotIdNull()) MithraNullPrimitiveException.throwNew("timeSlotId", data);
		return data.getTimeSlotId();
	}

	public void setTimeSlotId(int newValue)
	{
		zSetInteger(CourseFinder.timeSlotId(), newValue, false, false ,true);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, CourseFinder.timeSlotId(), false);
		zNullify(behavior, data, CourseFinder.lectureHallId(), false);
	}

	public void setTimeSlotIdNull()
	{
		zNullify(CourseFinder.timeSlotId(), false);
	}

	public void setLectureHallIdNull()
	{
		zNullify(CourseFinder.lectureHallId(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		CourseData _newData = (CourseData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		CourseData _newData = (CourseData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _newData = (CourseData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	ClassTimeSlot.timeSlotId = this.timeSlotId</pre>
	* @return time
	*/
	public ClassTimeSlotList getTime()
	{
		ClassTimeSlotList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			if (!_data.isTimeSlotIdNull())
			{
				{
					_op = ClassTimeSlotFinder.timeSlotId().eq(_data.getTimeSlotId());
				}
			}
			else 
			{
				_result = new ClassTimeSlotList( new None (
					ClassTimeSlotFinder.timeSlotId()));
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isTimeSlotIdNull())
				{
					Operation detachedOp = ClassTimeSlotFinder.timeSlotId().eq(_data.getTimeSlotId());
					_result = new ClassTimeSlotList(detachedOp);
					_result.zSetForRelationship();
				}
				else 
				{
					_result = new ClassTimeSlotList( new None (
						ClassTimeSlotFinder.timeSlotId()));
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (ClassTimeSlotList) _data.getTime();
			if (_result == null)
			{
				if (!_data.isTimeSlotIdNull())
				{
					_op = ClassTimeSlotFinder.timeSlotId().eq(_data.getTimeSlotId());
				}
				else 
				{
					_result = new ClassTimeSlotList( new None (
						ClassTimeSlotFinder.timeSlotId()));
				}
			}
		}

		if (_op != null)
		{
			_result = new ClassTimeSlotList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setTime(ClassTimeSlotList time)
	{
		ClassTimeSlotList _time = (ClassTimeSlotList) time;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setTime(_time);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	LectureHall.lectureHallId = this.lectureHallId</pre>
	* @return lecture hall
	*/
	public LectureHallList getLectureHall()
	{
		LectureHallList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			if (!_data.isLectureHallIdNull())
			{
				{
					_op = LectureHallFinder.lectureHallId().eq(_data.getLectureHallId());
				}
			}
			else 
			{
				_result = new LectureHallList( new None (
					LectureHallFinder.lectureHallId()));
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isLectureHallIdNull())
				{
					Operation detachedOp = LectureHallFinder.lectureHallId().eq(_data.getLectureHallId());
					_result = new LectureHallList(detachedOp);
					_result.zSetForRelationship();
				}
				else 
				{
					_result = new LectureHallList( new None (
						LectureHallFinder.lectureHallId()));
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (LectureHallList) _data.getLectureHall();
			if (_result == null)
			{
				if (!_data.isLectureHallIdNull())
				{
					_op = LectureHallFinder.lectureHallId().eq(_data.getLectureHallId());
				}
				else 
				{
					_result = new LectureHallList( new None (
						LectureHallFinder.lectureHallId()));
				}
			}
		}

		if (_op != null)
		{
			_result = new LectureHallList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setLectureHall(LectureHallList lectureHall)
	{
		LectureHallList _lectureHall = (LectureHallList) lectureHall;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setLectureHall(_lectureHall);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Department.courseId</pre>
	* @see Department#getCourses() reverse relationship Department.getCourses()
	* @return The department
	*/
	public Department getDepartment()
	{
		Department _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = DepartmentFinder.courseId().eq(_data.getCourseId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = DepartmentFinder.courseId().eq(_data.getCourseId());
					_result = DepartmentFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Department) _data.getDepartment();
			if (_result == null)
			{
				{
					_op = DepartmentFinder.courseId().eq(_data.getCourseId());
				}
			}
		}

		if (_op != null)
		{
			_result = DepartmentFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setDepartment(Department department)
	{
		Department _department = (Department) department;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setDepartment(_department);
			if (_department == null)
			{
				this.setCourseId(0);
			}
			else
			{
				this.setCourseId(_department.getCourseId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_department == null)
			{
				this.setCourseId(0);
			}
			else
			{
				this.setCourseId(
					_department.getCourseId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Faculty.courseId</pre>
	* @see Faculty#getCourses() reverse relationship Faculty.getCourses()
	* @return faculty
	*/
	public FacultyList getFaculty()
	{
		FacultyList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = FacultyFinder.courseId().eq(_data.getCourseId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = FacultyFinder.courseId().eq(_data.getCourseId());
					_result = new FacultyList(detachedOp);
					_result.zSetForRelationship();
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (FacultyList) _data.getFaculty();
			if (_result == null)
			{
				{
					_op = FacultyFinder.courseId().eq(_data.getCourseId());
				}
			}
		}

		if (_op != null)
		{
			_result = new FacultyList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setFaculty(FacultyList faculty)
	{
		FacultyList _faculty = (FacultyList) faculty;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setFaculty(_faculty);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.courseId = Student.courseId</pre>
	* @see Student#getCourses() reverse relationship Student.getCourses()
	* @return students
	*/
	public StudentList getStudents()
	{
		StudentList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = StudentFinder.courseId().eq(_data.getCourseId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = StudentFinder.courseId().eq(_data.getCourseId());
					_result = new StudentList(detachedOp);
					_result.zSetForRelationship();
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (StudentList) _data.getStudents();
			if (_result == null)
			{
				{
					_op = StudentFinder.courseId().eq(_data.getCourseId());
				}
			}
		}

		if (_op != null)
		{
			_result = new StudentList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setStudents(StudentList students)
	{
		StudentList _students = (StudentList) students;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		CourseData _data = (CourseData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setStudents(_students);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	protected void cascadeInsertImpl() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		_behavior.insert(this);
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStats(RelatedFinder finder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		_behavior.addNavigatedRelationshipsStats(this, finder, navigationStats);
		return navigationStats;
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStatsForUpdate(RelatedFinder parentFinderGeneric, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		return navigationStats;
	}

	@Override
	public Map< RelatedFinder, StatisticCounter > zAddNavigatedRelationshipsStatsForDelete(RelatedFinder parentFinder, Map< RelatedFinder, StatisticCounter > navigationStats)
	{
		return navigationStats;
	}

	@Override
	public Course zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Course original = (Course) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return CourseFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return CourseFinder.getMithraObjectPortal();
	}

	public Course getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateDate(behavior, data, newData, CourseFinder.endDate(), false);
		changed |= zUpdateInteger(behavior, data, newData, CourseFinder.lectureHallId(), false);
		changed |= zUpdateString(behavior, data, newData, CourseFinder.semester(), false);
		changed |= zUpdateDate(behavior, data, newData, CourseFinder.startDate(), false);
		changed |= zUpdateInteger(behavior, data, newData, CourseFinder.timeSlotId(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, CourseFinder.courseId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		CourseAbstract result = (CourseAbstract) super.readResolve();
		if (result.persistenceState == PersistenceState.PERSISTED)
		{
			result.persistenceState = PERSISTED_STATE;
		}
		else if (result.persistenceState == PersistenceState.IN_MEMORY)
		{
			result.persistenceState = MEMORY_STATE;
		}

		return result;
	}

	protected static void zConfigNonTx()
	{
		MEMORY_STATE = PersistenceState.IN_MEMORY_NON_TRANSACTIONAL;
		PERSISTED_STATE = PersistenceState.PERSISTED_NON_TRANSACTIONAL;
	}

	protected static void zConfigFullTx()
	{
		MEMORY_STATE = PersistenceState.IN_MEMORY;
		PERSISTED_STATE = PersistenceState.PERSISTED;
	}
}
