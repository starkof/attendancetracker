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
public abstract class DepartmentAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Department.class.getName());
	public DepartmentAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Department getDetachedCopy() throws MithraBusinessException
	{
		return (Department) super.getDetachedCopy();
	}

	public Department getNonPersistentCopy() throws MithraBusinessException
	{
		Department result = (Department) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Department copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Department) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Department zFindOriginal()
	{
		DepartmentData data = (DepartmentData) this.currentData;
		Operation op;
		op = DepartmentFinder.departmentId().eq(data.getDepartmentId());
		return DepartmentFinder.findOne(op);
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
		return new DepartmentData();
	}

	protected void zSetFromDepartmentData( DepartmentData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromDepartmentData( DepartmentData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCourseIdNull()
	{
		return ((DepartmentData) this.zSynchronizedGetData()).isCourseIdNull();
	}

	public int getCourseId()
	{
		DepartmentData data = (DepartmentData) this.zSynchronizedGetData();
		if (data.isCourseIdNull()) MithraNullPrimitiveException.throwNew("courseId", data);
		return data.getCourseId();
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(DepartmentFinder.courseId(), newValue, false, false ,true);
	}

	public boolean isDepartmentIdNull()
	{
		return ((DepartmentData) this.zSynchronizedGetData()).isDepartmentIdNull();
	}

	public int getDepartmentId()
	{
		DepartmentData data = (DepartmentData) this.zSynchronizedGetData();
		return data.getDepartmentId();
	}

	public void setDepartmentId(int newValue)
	{
		zSetInteger(DepartmentFinder.departmentId(), newValue, true, false ,false);
	}

	public boolean isDepartmentNameNull()
	{
		return ((DepartmentData) this.zSynchronizedGetData()).isDepartmentNameNull();
	}

	public String getDepartmentName()
	{
		DepartmentData data = (DepartmentData) this.zSynchronizedGetData();
		return data.getDepartmentName();
	}

	public void setDepartmentName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(DepartmentFinder.departmentName(), newValue, false, false );
	}

	public boolean isMajorIdNull()
	{
		return ((DepartmentData) this.zSynchronizedGetData()).isMajorIdNull();
	}

	public int getMajorId()
	{
		DepartmentData data = (DepartmentData) this.zSynchronizedGetData();
		if (data.isMajorIdNull()) MithraNullPrimitiveException.throwNew("majorId", data);
		return data.getMajorId();
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(DepartmentFinder.majorId(), newValue, false, false ,true);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, DepartmentFinder.courseId(), false);
		zNullify(behavior, data, DepartmentFinder.majorId(), false);
	}

	public void setCourseIdNull()
	{
		zNullify(DepartmentFinder.courseId(), false);
	}

	public void setMajorIdNull()
	{
		zNullify(DepartmentFinder.majorId(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		DepartmentData _newData = (DepartmentData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		DepartmentData _newData = (DepartmentData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		DepartmentData _newData = (DepartmentData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getDepartment() reverse relationship Course.getDepartment()
	* @return courses
	*/
	public CourseList getCourses()
	{
		CourseList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			if (!_data.isCourseIdNull())
			{
				{
					_op = CourseFinder.courseId().eq(_data.getCourseId());
				}
			}
			else 
			{
				_result = new CourseList( new None (
					CourseFinder.courseId()));
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isCourseIdNull())
				{
					Operation detachedOp = CourseFinder.courseId().eq(_data.getCourseId());
					_result = new CourseList(detachedOp);
					_result.zSetForRelationship();
				}
				else 
				{
					_result = new CourseList( new None (
						CourseFinder.courseId()));
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (CourseList) _data.getCourses();
			if (_result == null)
			{
				if (!_data.isCourseIdNull())
				{
					_op = CourseFinder.courseId().eq(_data.getCourseId());
				}
				else 
				{
					_result = new CourseList( new None (
						CourseFinder.courseId()));
				}
			}
		}

		if (_op != null)
		{
			_result = new CourseList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setCourses(CourseList courses)
	{
		CourseList _courses = (CourseList) courses;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setCourses(_courses);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	Major.majorId = this.majorId</pre>
	* @see Major#getDepartment() reverse relationship Major.getDepartment()
	* @return major
	*/
	public MajorList getMajor()
	{
		MajorList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			if (!_data.isMajorIdNull())
			{
				{
					_op = MajorFinder.majorId().eq(_data.getMajorId());
				}
			}
			else 
			{
				_result = new MajorList( new None (
					MajorFinder.majorId()));
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isMajorIdNull())
				{
					Operation detachedOp = MajorFinder.majorId().eq(_data.getMajorId());
					_result = new MajorList(detachedOp);
					_result.zSetForRelationship();
				}
				else 
				{
					_result = new MajorList( new None (
						MajorFinder.majorId()));
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (MajorList) _data.getMajor();
			if (_result == null)
			{
				if (!_data.isMajorIdNull())
				{
					_op = MajorFinder.majorId().eq(_data.getMajorId());
				}
				else 
				{
					_result = new MajorList( new None (
						MajorFinder.majorId()));
				}
			}
		}

		if (_op != null)
		{
			_result = new MajorList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setMajor(MajorList major)
	{
		MajorList _major = (MajorList) major;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setMajor(_major);
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.departmentId = Faculty.departmentId</pre>
	* @see Faculty#getDepartment() reverse relationship Faculty.getDepartment()
	* @return faculty
	*/
	public FacultyList getFaculty()
	{
		FacultyList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = FacultyFinder.departmentId().eq(_data.getDepartmentId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = FacultyFinder.departmentId().eq(_data.getDepartmentId());
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
					_op = FacultyFinder.departmentId().eq(_data.getDepartmentId());
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
		DepartmentData _data = (DepartmentData) _behavior.getCurrentDataForWrite(this);
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
	public Department zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Department original = (Department) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return DepartmentFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return DepartmentFinder.getMithraObjectPortal();
	}

	public Department getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, DepartmentFinder.courseId(), false);
		changed |= zUpdateString(behavior, data, newData, DepartmentFinder.departmentName(), false);
		changed |= zUpdateInteger(behavior, data, newData, DepartmentFinder.majorId(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, DepartmentFinder.departmentId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		DepartmentAbstract result = (DepartmentAbstract) super.readResolve();
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
