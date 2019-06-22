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
public abstract class MajorAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Major.class.getName());
	public MajorAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Major getDetachedCopy() throws MithraBusinessException
	{
		return (Major) super.getDetachedCopy();
	}

	public Major getNonPersistentCopy() throws MithraBusinessException
	{
		Major result = (Major) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Major copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Major) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Major zFindOriginal()
	{
		MajorData data = (MajorData) this.currentData;
		Operation op;
		op = MajorFinder.majorId().eq(data.getMajorId());
		return MajorFinder.findOne(op);
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
		return new MajorData();
	}

	protected void zSetFromMajorData( MajorData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromMajorData( MajorData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isMajorIdNull()
	{
		return ((MajorData) this.zSynchronizedGetData()).isMajorIdNull();
	}

	public int getMajorId()
	{
		MajorData data = (MajorData) this.zSynchronizedGetData();
		return data.getMajorId();
	}

	public void setMajorId(int newValue)
	{
		zSetInteger(MajorFinder.majorId(), newValue, true, false ,false);
	}

	public boolean isMajorNameNull()
	{
		return ((MajorData) this.zSynchronizedGetData()).isMajorNameNull();
	}

	public String getMajorName()
	{
		MajorData data = (MajorData) this.zSynchronizedGetData();
		return data.getMajorName();
	}

	public void setMajorName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(MajorFinder.majorName(), newValue, false, false );
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		MajorData _newData = (MajorData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		MajorData _newData = (MajorData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		MajorData _newData = (MajorData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	this.majorId = Department.majorId</pre>
	* @see Department#getMajor() reverse relationship Department.getMajor()
	* @return The department
	*/
	public Department getDepartment()
	{
		Department _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		MajorData _data = (MajorData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = DepartmentFinder.majorId().eq(_data.getMajorId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = DepartmentFinder.majorId().eq(_data.getMajorId());
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
					_op = DepartmentFinder.majorId().eq(_data.getMajorId());
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
		MajorData _data = (MajorData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setDepartment(_department);
			if (_department == null)
			{
				this.setMajorId(0);
			}
			else
			{
				this.setMajorId(_department.getMajorId());
			}
		}
		else if (_behavior.isPersisted())
		{
			_behavior.clearTempTransaction(this);
			if (_department == null)
			{
				this.setMajorId(0);
			}
			else
			{
				this.setMajorId(
					_department.getMajorId());
			}
		}
		else throw new RuntimeException("not implemented");
	}

	/**
	* Relationship Expression:<pre>
	this.majorId = Student.majorId</pre>
	* @see Student#getMajor() reverse relationship Student.getMajor()
	* @return students
	*/
	public StudentList getStudents()
	{
		StudentList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		MajorData _data = (MajorData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = StudentFinder.majorId().eq(_data.getMajorId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = StudentFinder.majorId().eq(_data.getMajorId());
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
					_op = StudentFinder.majorId().eq(_data.getMajorId());
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
		MajorData _data = (MajorData) _behavior.getCurrentDataForWrite(this);
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
	public Major zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Major original = (Major) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return MajorFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return MajorFinder.getMithraObjectPortal();
	}

	public Major getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, MajorFinder.majorName(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, MajorFinder.majorId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		MajorAbstract result = (MajorAbstract) super.readResolve();
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
