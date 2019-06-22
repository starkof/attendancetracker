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
public abstract class PersonAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Person.class.getName());
	private static final RelationshipHashStrategy forgender = new GenderRhs();
	private static final RelationshipHashStrategy formaritalStatus = new MaritalStatusRhs();
	private static final RelationshipHashStrategy fornationality = new NationalityRhs();
	private static final class GenderRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			GenderData _castedTargetData = (GenderData) _targetData;
			if (!_castedSrcData.isGenderIdNull() && _castedSrcData.getGenderId() == _castedTargetData.getGenderId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			return HashUtil.hash(_castedSrcData.getGenderId(), _castedSrcData.isGenderIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	private static final class MaritalStatusRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			MaritalStatusData _castedTargetData = (MaritalStatusData) _targetData;
			if (!_castedSrcData.isMaritalStatusIdNull() && _castedSrcData.getMaritalStatusId() == _castedTargetData.getMaritalStatusId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			return HashUtil.hash(_castedSrcData.getMaritalStatusId(), _castedSrcData.isMaritalStatusIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	private static final class NationalityRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			NationalityData _castedTargetData = (NationalityData) _targetData;
			if (!_castedSrcData.isNationalityIdNull() && _castedSrcData.getNationalityId() == _castedTargetData.getNationalityId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			PersonData _castedSrcData = (PersonData) _srcData;
			return HashUtil.hash(_castedSrcData.getNationalityId(), _castedSrcData.isNationalityIdNull());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			return computeHashCodeFromRelated(_srcObject, _srcData);
		}
	}

	public PersonAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Person getDetachedCopy() throws MithraBusinessException
	{
		return (Person) super.getDetachedCopy();
	}

	public Person getNonPersistentCopy() throws MithraBusinessException
	{
		Person result = (Person) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Person copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Person) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Person zFindOriginal()
	{
		PersonData data = (PersonData) this.currentData;
		Operation op;
		op = PersonFinder.personId().eq(data.getPersonId());
		return PersonFinder.findOne(op);
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
		return new PersonData();
	}

	protected void zSetFromPersonData( PersonData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromPersonData( PersonData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isAgeNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isAgeNull();
	}

	public int getAge()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		if (data.isAgeNull()) MithraNullPrimitiveException.throwNew("age", data);
		return data.getAge();
	}

	public void setAge(int newValue)
	{
		zSetInteger(PersonFinder.age(), newValue, false, false ,true);
	}

	public boolean isFirstNameNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isFirstNameNull();
	}

	public String getFirstName()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getFirstName();
	}

	public void setFirstName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(PersonFinder.firstName(), newValue, false, false );
	}

	public boolean isGenderIdNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isGenderIdNull();
	}

	public int getGenderId()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		if (data.isGenderIdNull()) MithraNullPrimitiveException.throwNew("genderId", data);
		return data.getGenderId();
	}

	public void setGenderId(int newValue)
	{
		zSetInteger(PersonFinder.genderId(), newValue, false, false ,true);
	}

	public boolean isLastNameNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isLastNameNull();
	}

	public String getLastName()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getLastName();
	}

	public void setLastName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(PersonFinder.lastName(), newValue, false, false );
	}

	public boolean isMaritalStatusIdNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isMaritalStatusIdNull();
	}

	public int getMaritalStatusId()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		if (data.isMaritalStatusIdNull()) MithraNullPrimitiveException.throwNew("maritalStatusId", data);
		return data.getMaritalStatusId();
	}

	public void setMaritalStatusId(int newValue)
	{
		zSetInteger(PersonFinder.maritalStatusId(), newValue, false, false ,true);
	}

	public boolean isNationalityIdNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isNationalityIdNull();
	}

	public int getNationalityId()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		if (data.isNationalityIdNull()) MithraNullPrimitiveException.throwNew("nationalityId", data);
		return data.getNationalityId();
	}

	public void setNationalityId(int newValue)
	{
		zSetInteger(PersonFinder.nationalityId(), newValue, false, false ,true);
	}

	public boolean isOtherNamesNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isOtherNamesNull();
	}

	public String getOtherNames()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getOtherNames();
	}

	public void setOtherNames(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(PersonFinder.otherNames(), newValue, false, false );
	}

	public boolean isPersonIdNull()
	{
		return ((PersonData) this.zSynchronizedGetData()).isPersonIdNull();
	}

	public int getPersonId()
	{
		PersonData data = (PersonData) this.zSynchronizedGetData();
		return data.getPersonId();
	}

	public void setPersonId(int newValue)
	{
		zSetInteger(PersonFinder.personId(), newValue, true, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, PersonFinder.age(), false);
		zNullify(behavior, data, PersonFinder.genderId(), false);
		zNullify(behavior, data, PersonFinder.maritalStatusId(), false);
		zNullify(behavior, data, PersonFinder.nationalityId(), false);
	}

	public void setAgeNull()
	{
		zNullify(PersonFinder.age(), false);
	}

	public void setGenderIdNull()
	{
		zNullify(PersonFinder.genderId(), false);
	}

	public void setMaritalStatusIdNull()
	{
		zNullify(PersonFinder.maritalStatusId(), false);
	}

	public void setNationalityIdNull()
	{
		zNullify(PersonFinder.nationalityId(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		PersonData _newData = (PersonData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		PersonData _newData = (PersonData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _newData = (PersonData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	Gender.genderId = this.genderId</pre>
	* @see Gender#getPeople() reverse relationship Gender.getPeople()
	* @return The gender
	*/
	public Gender getGender()
	{
		Gender _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isGenderIdNull())
			{
				_portal = GenderFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, forgender, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Gender) _related;
				if (_related == null)
				{
					_op = GenderFinder.genderId().eq(_data.getGenderId());
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
				if (!_data.isGenderIdNull())
				{
					Operation detachedOp = GenderFinder.genderId().eq(_data.getGenderId());
					_result = GenderFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Gender) _data.getGender();
			if (_result == null)
			{
				if (!_data.isGenderIdNull())
				{
					_op = GenderFinder.genderId().eq(_data.getGenderId());
				}
			}
		}

		if (_op != null)
		{
			_result = GenderFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setGender(Gender gender)
	{
		Gender _gender = (Gender) gender;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setGender(_gender);
			if (_gender == null)
			{
				this.setGenderIdNull();
			}
			else
			{
				this.setGenderId(_gender.getGenderId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_gender == null)
			{
				this.setGenderIdNull();
			}
			else
			{
				this.setGenderId(
					_gender.getGenderId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	MaritalStatus.maritalStatusId = this.maritalStatusId</pre>
	* @see MaritalStatus#getPeople() reverse relationship MaritalStatus.getPeople()
	* @return The marital status
	*/
	public MaritalStatus getMaritalStatus()
	{
		MaritalStatus _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isMaritalStatusIdNull())
			{
				_portal = MaritalStatusFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, formaritalStatus, null, null);
				if (!(_related instanceof NulledRelation)) _result = (MaritalStatus) _related;
				if (_related == null)
				{
					_op = MaritalStatusFinder.maritalStatusId().eq(_data.getMaritalStatusId());
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
				if (!_data.isMaritalStatusIdNull())
				{
					Operation detachedOp = MaritalStatusFinder.maritalStatusId().eq(_data.getMaritalStatusId());
					_result = MaritalStatusFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (MaritalStatus) _data.getMaritalStatus();
			if (_result == null)
			{
				if (!_data.isMaritalStatusIdNull())
				{
					_op = MaritalStatusFinder.maritalStatusId().eq(_data.getMaritalStatusId());
				}
			}
		}

		if (_op != null)
		{
			_result = MaritalStatusFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus)
	{
		MaritalStatus _maritalStatus = (MaritalStatus) maritalStatus;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setMaritalStatus(_maritalStatus);
			if (_maritalStatus == null)
			{
				this.setMaritalStatusIdNull();
			}
			else
			{
				this.setMaritalStatusId(_maritalStatus.getMaritalStatusId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_maritalStatus == null)
			{
				this.setMaritalStatusIdNull();
			}
			else
			{
				this.setMaritalStatusId(
					_maritalStatus.getMaritalStatusId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	Nationality.nationalityId = this.nationalityId</pre>
	* @see Nationality#getPeople() reverse relationship Nationality.getPeople()
	* @return The nationality
	*/
	public Nationality getNationality()
	{
		Nationality _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForRead(this);
		MithraObjectPortal _portal = null;
		if (_behavior.isPersisted())
		{
			if (!_data.isNationalityIdNull())
			{
				_portal = NationalityFinder.getMithraObjectPortal();
				Object _related = _portal.getAsOneFromCache(this, _data, fornationality, null, null);
				if (!(_related instanceof NulledRelation)) _result = (Nationality) _related;
				if (_related == null)
				{
					_op = NationalityFinder.nationalityId().eq(_data.getNationalityId());
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
				if (!_data.isNationalityIdNull())
				{
					Operation detachedOp = NationalityFinder.nationalityId().eq(_data.getNationalityId());
					_result = NationalityFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Nationality) _data.getNationality();
			if (_result == null)
			{
				if (!_data.isNationalityIdNull())
				{
					_op = NationalityFinder.nationalityId().eq(_data.getNationalityId());
				}
			}
		}

		if (_op != null)
		{
			_result = NationalityFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setNationality(Nationality nationality)
	{
		Nationality _nationality = (Nationality) nationality;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setNationality(_nationality);
			if (_nationality == null)
			{
				this.setNationalityIdNull();
			}
			else
			{
				this.setNationalityId(_nationality.getNationalityId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_nationality == null)
			{
				this.setNationalityIdNull();
			}
			else
			{
				this.setNationalityId(
					_nationality.getNationalityId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.personId = Faculty.personId</pre>
	* @see Faculty#getPerson() reverse relationship Faculty.getPerson()
	* @return The faculty
	*/
	public Faculty getFaculty()
	{
		Faculty _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = FacultyFinder.personId().eq(_data.getPersonId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = FacultyFinder.personId().eq(_data.getPersonId());
					_result = FacultyFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Faculty) _data.getFaculty();
			if (_result == null)
			{
				{
					_op = FacultyFinder.personId().eq(_data.getPersonId());
				}
			}
		}

		if (_op != null)
		{
			_result = FacultyFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setFaculty(Faculty faculty)
	{
		Faculty _faculty = (Faculty) faculty;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setFaculty(_faculty);
			if (_faculty == null)
			{
				this.setPersonId(0);
			}
			else
			{
				this.setPersonId(_faculty.getPersonId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_faculty == null)
			{
				this.setPersonId(0);
			}
			else
			{
				this.setPersonId(
					_faculty.getPersonId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.personId = Student.personId</pre>
	* @see Student#getPerson() reverse relationship Student.getPerson()
	* @return The student
	*/
	public Student getStudent()
	{
		Student _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = StudentFinder.personId().eq(_data.getPersonId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = StudentFinder.personId().eq(_data.getPersonId());
					_result = StudentFinder.zFindOneForRelationship(detachedOp);
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (Student) _data.getStudent();
			if (_result == null)
			{
				{
					_op = StudentFinder.personId().eq(_data.getPersonId());
				}
			}
		}

		if (_op != null)
		{
			_result = StudentFinder.zFindOneForRelationship(_op);
		}

		return _result;
	}

	public void setStudent(Student student)
	{
		Student _student = (Student) student;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		PersonData _data = (PersonData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setStudent(_student);
			if (_student == null)
			{
				this.setPersonId(0);
			}
			else
			{
				this.setPersonId(_student.getPersonId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_student == null)
			{
				this.setPersonId(0);
			}
			else
			{
				this.setPersonId(
					_student.getPersonId());
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
	public Person zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Person original = (Person) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return PersonFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return PersonFinder.getMithraObjectPortal();
	}

	public Person getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.age(), false);
		changed |= zUpdateString(behavior, data, newData, PersonFinder.firstName(), false);
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.genderId(), false);
		changed |= zUpdateString(behavior, data, newData, PersonFinder.lastName(), false);
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.maritalStatusId(), false);
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.nationalityId(), false);
		changed |= zUpdateString(behavior, data, newData, PersonFinder.otherNames(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, PersonFinder.personId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		PersonAbstract result = (PersonAbstract) super.readResolve();
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
