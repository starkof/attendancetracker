package com.mithraobjects;
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
public abstract class StudentAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Student.class.getName());
	private static final RelationshipHashStrategy formajor = new MajorRhs();
	private static final RelationshipHashStrategy forperson = new PersonRhs();
	private static final class MajorRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			StudentData _castedSrcData = (StudentData) _srcData;
			MajorData _castedTargetData = (MajorData) _targetData;
			if (!_castedSrcData.isMajorIdNull() && _castedSrcData.getMajorId() == _castedTargetData.getMajorId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			StudentData _castedSrcData = (StudentData) _srcData;
			return HashUtil.hash(_castedSrcData.getMajorId(), _castedSrcData.isMajorIdNull());
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
			StudentData _castedSrcData = (StudentData) _srcData;
			PersonData _castedTargetData = (PersonData) _targetData;
			if (!_castedSrcData.isPersonIdNull() && _castedSrcData.getPersonId() == _castedTargetData.getPersonId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			StudentData _castedSrcData = (StudentData) _srcData;
			return HashUtil.hash(_castedSrcData.getPersonId(), _castedSrcData.isPersonIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	public StudentAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Student getDetachedCopy() throws MithraBusinessException
	{
		return (Student) super.getDetachedCopy();
	}

	public Student getNonPersistentCopy() throws MithraBusinessException
	{
		Student result = (Student) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Student copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Student) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Student zFindOriginal()
	{
		StudentData data = (StudentData) this.currentData;
		Operation op;
		op = StudentFinder.studentId().eq(data.getStudentId());
		return StudentFinder.findOne(op);
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
		return new StudentData();
	}

	protected void zSetFromStudentData( StudentData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromStudentData( StudentData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isAdmissionDateNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isAdmissionDateNull();
	}

	public Date getAdmissionDate()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		return data.getAdmissionDate();
	}

	public void setAdmissionDate(Date newValue)
	{
		zSetDate(StudentFinder.admissionDate(), newValue, false, false );
	}

	public boolean isCourseIdNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isCourseIdNull();
	}

	public int getCourseId()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		if (data.isCourseIdNull()) MithraNullPrimitiveException.throwNew("courseId", data);
		return data.getCourseId();
	}

	public void setCourseId(int newValue)
	{
		zSetInteger(StudentFinder.courseId(), newValue, false, false ,true);
	}

	public boolean isExpectedGraduationNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isExpectedGraduationNull();
	}

	public Date getExpectedGraduation()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		return data.getExpectedGraduation();
	}

	public void setExpectedGraduation(Date newValue)
	{
		zSetDate(StudentFinder.expectedGraduation(), newValue, false, false );
	}

	public boolean isGpaNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isGpaNull();
	}

	public int getGpa()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		if (data.isGpaNull()) MithraNullPrimitiveException.throwNew("gpa", data);
		return data.getGpa();
	}

	public void setGpa(int newValue)
	{
		zSetInteger(StudentFinder.gpa(), newValue, false, false ,true);
	}

	public boolean isMajorIdNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isMajorIdNull();
	}

	public int getMajorId()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		if (data.isMajorIdNull()) MithraNullPrimitiveException.throwNew("majorId", data);
		return data.getMajorId();
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(StudentFinder.majorId(), newValue, false, false ,true);
	}

	public boolean isPersonIdNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isPersonIdNull();
	}

	public int getPersonId()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		if (data.isPersonIdNull()) MithraNullPrimitiveException.throwNew("personId", data);
		return data.getPersonId();
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(StudentFinder.personId(), newValue, false, false ,true);
	}

	public boolean isStudentIdNull()
	{
		return ((StudentData) this.zSynchronizedGetData()).isStudentIdNull();
	}

	public int getStudentId()
	{
		StudentData data = (StudentData) this.zSynchronizedGetData();
		return data.getStudentId();
	}

	public void setStudentId(int newValue)
	{
		zSetInteger(StudentFinder.studentId(), newValue, true, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, StudentFinder.majorId(), false);
		zNullify(behavior, data, StudentFinder.gpa(), false);
		zNullify(behavior, data, StudentFinder.personId(), false);
		zNullify(behavior, data, StudentFinder.courseId(), false);
	}

	public void setMajorIdNull()
	{
		zNullify(StudentFinder.majorId(), false);
	}

	public void setGpaNull()
	{
		zNullify(StudentFinder.gpa(), false);
	}

	public void setPersonIdNull()
	{
		zNullify(StudentFinder.personId(), false);
	}

	public void setCourseIdNull()
	{
		zNullify(StudentFinder.courseId(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		StudentData _newData = (StudentData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		StudentData _newData = (StudentData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		StudentData _newData = (StudentData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	Major.majorId = this.majorId</pre>
	* @see Major#getStudents() reverse relationship Major.getStudents()
	* @return The major
	*/
	public Major getMajor()
	{
		Major _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		StudentData _data = (StudentData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isMajorIdNull())
			{
				_portal = MajorFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, formajor, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Major) _related;
				if (_related == null)
				{
					_op = MajorFinder.majorId().eq(_data.getMajorId());
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
				if (!_data.isMajorIdNull())
				{
					Operation detachedOp = MajorFinder.majorId().eq(_data.getMajorId());
					_result = MajorFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Major) _data.getMajor();
			if (_result == null)
			{
				if (!_data.isMajorIdNull())
				{
					_op = MajorFinder.majorId().eq(_data.getMajorId());
				}
			}
		}

		if (_op != null)
		{
			_result = MajorFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setMajor(Major major)
	{
		Major _major = (Major) major;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		StudentData _data = (StudentData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setMajor(_major);
			if (_major == null)
			{
				this.setMajorIdNull();
			}
			else
			{
				this.setMajorId(_major.getMajorId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_major == null)
			{
				this.setMajorIdNull();
			}
			else
			{
				this.setMajorId(
					_major.getMajorId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	Person.personId = this.personId</pre>
	* @see Person#getStudent() reverse relationship Person.getStudent()
	* @return The person
	*/
	public Person getPerson()
	{
		Person _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		StudentData _data = (StudentData) _behavior.getCurrentDataForRead(this);
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
		StudentData _data = (StudentData) _behavior.getCurrentDataForWrite(this);
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

	/**
	* Relationship Expression:<pre>
	Course.courseId = this.courseId</pre>
	* @see Course#getStudents() reverse relationship Course.getStudents()
	* @return courses
	*/
	public CourseList getCourses()
	{
		CourseList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		StudentData _data = (StudentData) _behavior.getCurrentDataForRead(this);
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
		StudentData _data = (StudentData) _behavior.getCurrentDataForWrite(this);
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
	public Student zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Student original = (Student) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return StudentFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return StudentFinder.getMithraObjectPortal();
	}

	public Student getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateDate(behavior, data, newData, StudentFinder.admissionDate(), false);
		changed |= zUpdateInteger(behavior, data, newData, StudentFinder.courseId(), false);
		changed |= zUpdateDate(behavior, data, newData, StudentFinder.expectedGraduation(), false);
		changed |= zUpdateInteger(behavior, data, newData, StudentFinder.gpa(), false);
		changed |= zUpdateInteger(behavior, data, newData, StudentFinder.majorId(), false);
		changed |= zUpdateInteger(behavior, data, newData, StudentFinder.personId(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, StudentFinder.studentId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		StudentAbstract result = (StudentAbstract) super.readResolve();
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
