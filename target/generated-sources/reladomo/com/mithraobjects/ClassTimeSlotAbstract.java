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
public abstract class ClassTimeSlotAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(ClassTimeSlot.class.getName());
	public ClassTimeSlotAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public ClassTimeSlot getDetachedCopy() throws MithraBusinessException
	{
		return (ClassTimeSlot) super.getDetachedCopy();
	}

	public ClassTimeSlot getNonPersistentCopy() throws MithraBusinessException
	{
		ClassTimeSlot result = (ClassTimeSlot) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public ClassTimeSlot copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (ClassTimeSlot) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public ClassTimeSlot zFindOriginal()
	{
		ClassTimeSlotData data = (ClassTimeSlotData) this.currentData;
		Operation op;
		op = ClassTimeSlotFinder.timeSlotId().eq(data.getTimeSlotId());
		return ClassTimeSlotFinder.findOne(op);
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
		return new ClassTimeSlotData();
	}

	protected void zSetFromClassTimeSlotData( ClassTimeSlotData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromClassTimeSlotData( ClassTimeSlotData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isDayNull()
	{
		return ((ClassTimeSlotData) this.zSynchronizedGetData()).isDayNull();
	}

	public String getDay()
	{
		ClassTimeSlotData data = (ClassTimeSlotData) this.zSynchronizedGetData();
		return data.getDay();
	}

	public void setDay(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(ClassTimeSlotFinder.day(), newValue, false, false );
	}

	public boolean isEndTimeNull()
	{
		return ((ClassTimeSlotData) this.zSynchronizedGetData()).isEndTimeNull();
	}

	public Date getEndTime()
	{
		ClassTimeSlotData data = (ClassTimeSlotData) this.zSynchronizedGetData();
		return data.getEndTime();
	}

	public void setEndTime(Date newValue)
	{
		zSetDate(ClassTimeSlotFinder.endTime(), newValue, false, false );
	}

	public boolean isStartTimeNull()
	{
		return ((ClassTimeSlotData) this.zSynchronizedGetData()).isStartTimeNull();
	}

	public Date getStartTime()
	{
		ClassTimeSlotData data = (ClassTimeSlotData) this.zSynchronizedGetData();
		return data.getStartTime();
	}

	public void setStartTime(Date newValue)
	{
		zSetDate(ClassTimeSlotFinder.startTime(), newValue, false, false );
	}

	public boolean isTimeSlotIdNull()
	{
		return ((ClassTimeSlotData) this.zSynchronizedGetData()).isTimeSlotIdNull();
	}

	public int getTimeSlotId()
	{
		ClassTimeSlotData data = (ClassTimeSlotData) this.zSynchronizedGetData();
		return data.getTimeSlotId();
	}

	public void setTimeSlotId(int newValue)
	{
		zSetInteger(ClassTimeSlotFinder.timeSlotId(), newValue, true, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		ClassTimeSlotData _newData = (ClassTimeSlotData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		ClassTimeSlotData _newData = (ClassTimeSlotData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		ClassTimeSlotData _newData = (ClassTimeSlotData) _behavior.getCurrentDataForRead(this);
		this.zSetNonTxPersistenceState(PersistenceState.DETACHED_DELETED);
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
	public ClassTimeSlot zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		ClassTimeSlot original = (ClassTimeSlot) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return ClassTimeSlotFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return ClassTimeSlotFinder.getMithraObjectPortal();
	}

	public ClassTimeSlot getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateString(behavior, data, newData, ClassTimeSlotFinder.day(), false);
		changed |= zUpdateDate(behavior, data, newData, ClassTimeSlotFinder.endTime(), false);
		changed |= zUpdateDate(behavior, data, newData, ClassTimeSlotFinder.startTime(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, ClassTimeSlotFinder.timeSlotId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		ClassTimeSlotAbstract result = (ClassTimeSlotAbstract) super.readResolve();
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
