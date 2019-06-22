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
public abstract class NationalityAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(Nationality.class.getName());
	public NationalityAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public Nationality getDetachedCopy() throws MithraBusinessException
	{
		return (Nationality) super.getDetachedCopy();
	}

	public Nationality getNonPersistentCopy() throws MithraBusinessException
	{
		Nationality result = (Nationality) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public Nationality copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (Nationality) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public Nationality zFindOriginal()
	{
		NationalityData data = (NationalityData) this.currentData;
		Operation op;
		op = NationalityFinder.nationalityId().eq(data.getNationalityId());
		return NationalityFinder.findOne(op);
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
		return new NationalityData();
	}

	protected void zSetFromNationalityData( NationalityData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromNationalityData( NationalityData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isNationalityIdNull()
	{
		return ((NationalityData) this.zSynchronizedGetData()).isNationalityIdNull();
	}

	public int getNationalityId()
	{
		NationalityData data = (NationalityData) this.zSynchronizedGetData();
		return data.getNationalityId();
	}

	public void setNationalityId(int newValue)
	{
		zSetInteger(NationalityFinder.nationalityId(), newValue, true, false ,false);
	}

	public boolean isNationalityValueNull()
	{
		return ((NationalityData) this.zSynchronizedGetData()).isNationalityValueNull();
	}

	public String getNationalityValue()
	{
		NationalityData data = (NationalityData) this.zSynchronizedGetData();
		return data.getNationalityValue();
	}

	public void setNationalityValue(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(NationalityFinder.nationalityValue(), newValue, false, false );
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		NationalityData _newData = (NationalityData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		NationalityData _newData = (NationalityData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		NationalityData _newData = (NationalityData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	/**
	* Relationship Expression:<pre>
	this.nationalityId = Person.nationalityId</pre>
	* @see Person#getNationality() reverse relationship Person.getNationality()
	* @return people
	*/
	public PersonList getPeople()
	{
		PersonList _result = null;
		Operation _op = null;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForReadWithWaitIfNecessary();
		NationalityData _data = (NationalityData) _behavior.getCurrentDataForRead(this);
		if (_behavior.isPersisted())
		{
			{
				{
					_op = PersonFinder.nationalityId().eq(_data.getNationalityId());
				}
			}
		}
		else if (_behavior.isDetached())
		{
			{
				{
					Operation detachedOp = PersonFinder.nationalityId().eq(_data.getNationalityId());
					_result = new PersonList(detachedOp);
					_result.zSetForRelationship();
				}
			}
		}
		else if (_behavior.isInMemory())
		{
			_result = (PersonList) _data.getPeople();
			if (_result == null)
			{
				{
					_op = PersonFinder.nationalityId().eq(_data.getNationalityId());
				}
			}
		}

		if (_op != null)
		{
			_result = new PersonList(_op);
			_result.zSetForRelationship();
		}

		return _result;
	}

	public void setPeople(PersonList people)
	{
		PersonList _people = (PersonList) people;
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		NationalityData _data = (NationalityData) _behavior.getCurrentDataForWrite(this);
		if (_behavior.isInMemory())
		{
			_data.setPeople(_people);
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
	public Nationality zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		Nationality original = (Nationality) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return NationalityFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return NationalityFinder.getMithraObjectPortal();
	}

	public Nationality getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, NationalityFinder.nationalityValue(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, NationalityFinder.nationalityId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		NationalityAbstract result = (NationalityAbstract) super.readResolve();
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
