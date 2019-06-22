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
public abstract class FacultyAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Faculty.class.getName());
	private static final RelationshipHashStrategy fordepartment = new DepartmentRhs();
	private static final RelationshipHashStrategy forperson = new PersonRhs();
	private static final class DepartmentRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			FacultyData _castedSrcData = (FacultyData) _srcData;
			DepartmentData _castedTargetData = (DepartmentData) _targetData;
			if (!_castedSrcData.isDepartmentIdNull() && _castedSrcData.getDepartmentId() == _castedTargetData.getDepartmentId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			FacultyData _castedSrcData = (FacultyData) _srcData;
			return HashUtil.hash(_castedSrcData.getDepartmentId(), _castedSrcData.isDepartmentIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	private static final class PersonRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			FacultyData _castedSrcData = (FacultyData) _srcData;
			PersonData _castedTargetData = (PersonData) _targetData;
			if (!_castedSrcData.isPersonIdNull() && _castedSrcData.getPersonId() == _castedTargetData.getPersonId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			FacultyData _castedSrcData = (FacultyData) _srcData;
			return HashUtil.hash(_castedSrcData.getPersonId(), _castedSrcData.isPersonIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	public FacultyAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Faculty getDetachedCopy() throws MithraBusinessException
	{
		return (Faculty) super.getDetachedCopy();
	}

	public Faculty getNonPersistentCopy() throws MithraBusinessException
	{
		Faculty result = (Faculty) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Faculty copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Faculty) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Faculty zFindOriginal()
	{
		FacultyData data = (FacultyData) this.currentData;
		Operation op;
		op = FacultyFinder.facultyId().eq(data.getFacultyId());
		return FacultyFinder.findOne(op);
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
		return new FacultyData();
	}

	protected void zSetFromFacultyData( FacultyData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromFacultyData( FacultyData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCourseIdNull()
	{
		return ((FacultyData) this.zSynchronizedGetData()).isCourseIdNull();
	}

	public int getCourseId()
	{
		FacultyData data = (FacultyData) this.zSynchronizedGetData();
		if (data.isCourseIdNull()) MithraNullPrimitiveException.throwNew("courseId", data);
		return data.getCourseId();
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(FacultyFinder.courseId(), newValue, false, false ,true);
	}

	public boolean isDepartmentIdNull()
	{
		return ((FacultyData) this.zSynchronizedGetData()).isDepartmentIdNull();
	}

	public int getDepartmentId()
	{
		FacultyData data = (FacultyData) this.zSynchronizedGetData();
		if (data.isDepartmentIdNull()) MithraNullPrimitiveException.throwNew("departmentId", data);
		return data.getDepartmentId();
	}

	public void setDepartmentId(int newValue)
	{
		zSetInteger(FacultyFinder.departmentId(), newValue, false, false ,true);
	}

	public boolean isFacultyIdNull()
	{
		return ((FacultyData) this.zSynchronizedGetData()).isFacultyIdNull();
	}

	public int getFacultyId()
	{
		FacultyData data = (FacultyData) this.zSynchronizedGetData();
		return data.getFacultyId();
	}

	public void setFacultyId(int newValue)
	{
		zSetInteger(FacultyFinder.facultyId(), newValue, true, false ,false);
	}

	public boolean isPersonIdNull()
	{
		return ((FacultyData) this.zSynchronizedGetData()).isPersonIdNull();
	}

	public int getPersonId()
	{
		FacultyData data = (FacultyData) this.zSynchronizedGetData();
		if (data.isPersonIdNull()) MithraNullPrimitiveException.throwNew("personId", data);
		return data.getPersonId();
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(FacultyFinder.personId(), newValue, false, false ,true);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, FacultyFinder.departmentId(), false);
		zNullify(behavior, data, FacultyFinder.courseId(), false);
		zNullify(behavior, data, FacultyFinder.personId(), false);
	}

	public void setDepartmentIdNull()
	{
		zNullify(FacultyFinder.departmentId(), false);
	}

	public void setCourseIdNull()
	{
		zNullify(FacultyFinder.courseId(), false);
	}

	public void setPersonIdNull()
	{
		zNullify(FacultyFinder.personId(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		FacultyData _newData = (FacultyData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		FacultyData _newData = (FacultyData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		FacultyData _newData = (FacultyData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	Department.departmentId = this.departmentId</pre>
	* @see Department#getFaculty() reverse relationship Department.getFaculty()
	* @return The department
	*/
	public Department getDepartment()
	{
		Department _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isDepartmentIdNull())
			{
				_portal = DepartmentFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, fordepartment, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Department) _related;
				if (_related == null)
				{
					_op = DepartmentFinder.departmentId().eq(_data.getDepartmentId());
				}
			}
			else 
			{
				return null;
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isDepartmentIdNull())
				{
					Operation detachedOp = DepartmentFinder.departmentId().eq(_data.getDepartmentId());
					_result = DepartmentFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Department) _data.getDepartment();
			if (_result == null)
			{
				if (!_data.isDepartmentIdNull())
				{
					_op = DepartmentFinder.departmentId().eq(_data.getDepartmentId());
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
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setDepartment(_department);
			if (_department == null)
			{
				this.setDepartmentIdNull();
			}
			else
			{
				this.setDepartmentId(_department.getDepartmentId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_department == null)
			{
				this.setDepartmentIdNull();
			}
			else
			{
				this.setDepartmentId(
					_department.getDepartmentId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getFaculty() reverse relationship Course.getFaculty()
	* @return courses
	*/
	public CourseList getCourses()
	{
		CourseList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForRead(this);
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
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForWrite(this);
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
	Person.personId = this.personId</pre>
	* @see Person#getFaculty() reverse relationship Person.getFaculty()
	* @return The person
	*/
	public Person getPerson()
	{
		Person _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isPersonIdNull())
			{
				_portal = PersonFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, forperson, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Person) _related;
				if (_related == null)
				{
					_op = PersonFinder.personId().eq(_data.getPersonId());
				}
			}
			else 
			{
				return null;
			}
		}
		else if (_behavior.isDetached())
		{
			{
				if (!_data.isPersonIdNull())
				{
					Operation detachedOp = PersonFinder.personId().eq(_data.getPersonId());
					_result = PersonFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Person) _data.getPerson();
			if (_result == null)
			{
				if (!_data.isPersonIdNull())
				{
					_op = PersonFinder.personId().eq(_data.getPersonId());
				}
			}
		}

		if (_op != null)
		{
			_result = PersonFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setPerson(Person person)
	{
		Person _person = (Person) person;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		FacultyData _data = (FacultyData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setPerson(_person);
			if (_person == null)
			{
				this.setPersonIdNull();
			}
			else
			{
				this.setPersonId(_person.getPersonId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_person == null)
			{
				this.setPersonIdNull();
			}
			else
			{
				this.setPersonId(
					_person.getPersonId());
			}
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
	public Faculty zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Faculty original = (Faculty) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return FacultyFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return FacultyFinder.getMithraObjectPortal();
	}

	public Faculty getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, FacultyFinder.courseId(), false);
		changed |= zUpdateInteger(behavior, data, newData, FacultyFinder.departmentId(), false);
		changed |= zUpdateInteger(behavior, data, newData, FacultyFinder.personId(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, FacultyFinder.facultyId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		FacultyAbstract result = (FacultyAbstract) super.readResolve();
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
