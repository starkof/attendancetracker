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
public abstract class LectureHallAbstract extends com.gs.fw.common.mithra.superclassimpl.MithraTransactionalObjectImpl
{
	private static byte MEMORY_STATE = PersistenceState.IN_MEMORY;
	private static byte PERSISTED_STATE = PersistenceState.PERSISTED;
	private static final Logger logger = LoggerFactory.getLogger(LectureHall.class.getName());
	public LectureHallAbstract()
	{
		this.persistenceState = MEMORY_STATE;
	}

	public LectureHall getDetachedCopy() throws MithraBusinessException
	{
		return (LectureHall) super.getDetachedCopy();
	}

	public LectureHall getNonPersistentCopy() throws MithraBusinessException
	{
		LectureHall result = (LectureHall) super.getNonPersistentCopy();
		result.persistenceState = MEMORY_STATE;
		return result;
	}

	public LectureHall copyDetachedValuesToOriginalOrInsertIfNew()
	{
		return (LectureHall) this.zCopyDetachedValuesToOriginalOrInsertIfNew();
	}

	public LectureHall zFindOriginal()
	{
		LectureHallData data = (LectureHallData) this.currentData;
		Operation op;
		op = LectureHallFinder.lectureHallId().eq(data.getLectureHallId());
		return LectureHallFinder.findOne(op);
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
		return new LectureHallData();
	}

	protected void zSetFromLectureHallData( LectureHallData data )
	{
		super.zSetData(data);
		this.persistenceState = PERSISTED_STATE;
	}

	public void setFromLectureHallData( LectureHallData data )
	{
		super.zSetData(data);
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public boolean isCapacityNull()
	{
		return ((LectureHallData) this.zSynchronizedGetData()).isCapacityNull();
	}

	public int getCapacity()
	{
		LectureHallData data = (LectureHallData) this.zSynchronizedGetData();
		if (data.isCapacityNull()) MithraNullPrimitiveException.throwNew("capacity", data);
		return data.getCapacity();
	}

	public void setCapacity(int newValue)
	{
		zSetInteger(LectureHallFinder.capacity(), newValue, false, false ,true);
	}

	public boolean isHallNameNull()
	{
		return ((LectureHallData) this.zSynchronizedGetData()).isHallNameNull();
	}

	public String getHallName()
	{
		LectureHallData data = (LectureHallData) this.zSynchronizedGetData();
		return data.getHallName();
	}

	public void setHallName(String newValue)
	{
		if (newValue != null) newValue = newValue.trim();
		zSetString(LectureHallFinder.hallName(), newValue, false, false );
	}

	public boolean isLectureHallIdNull()
	{
		return ((LectureHallData) this.zSynchronizedGetData()).isLectureHallIdNull();
	}

	public int getLectureHallId()
	{
		LectureHallData data = (LectureHallData) this.zSynchronizedGetData();
		return data.getLectureHallId();
	}

	public void setLectureHallId(int newValue)
	{
		zSetInteger(LectureHallFinder.lectureHallId(), newValue, true, false ,false);
	}

	protected void issuePrimitiveNullSetters(TransactionalBehavior behavior, MithraDataObject data)
	{
		zNullify(behavior, data, LectureHallFinder.capacity(), false);
	}

	public void setCapacityNull()
	{
		zNullify(LectureHallFinder.capacity(), false);
	}

	public void zPersistDetachedRelationships(MithraDataObject _data)
	{
		LectureHallData _newData = (LectureHallData) _data;
	}

	public void zSetTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		if (_behavior.isDetached() && _behavior.isDeleted()) return;
		LectureHallData _newData = (LectureHallData) _behavior.getCurrentDataForRead(this);
		this.zSetTxPersistenceState(PersistenceState.DETACHED_DELETED);
	}

	public void zSetNonTxDetachedDeleted()
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		LectureHallData _newData = (LectureHallData) _behavior.getCurrentDataForRead(this);
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
	public LectureHall zCascadeCopyThenInsert() throws MithraBusinessException
	{
		TransactionalBehavior _behavior = zGetTransactionalBehaviorForWriteWithWaitIfNecessary();
		LectureHall original = (LectureHall) _behavior.copyThenInsert(this);
		return original;
	}

	protected void cascadeDeleteImpl() throws MithraBusinessException
	{
		this.delete();
	}

	public Cache zGetCache()
	{
		return LectureHallFinder.getMithraObjectPortal().getCache();
	}

	public MithraObjectPortal zGetPortal()
	{
		return LectureHallFinder.getMithraObjectPortal();
	}

	public LectureHall getOriginalPersistentObject()
	{
		return this.zFindOriginal();
	}

	protected boolean issueUpdatesForNonPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, LectureHallFinder.capacity(), false);
		changed |= zUpdateString(behavior, data, newData, LectureHallFinder.hallName(), false);
		return changed;
	}

	protected boolean issueUpdatesForPrimaryKeys(TransactionalBehavior behavior, MithraDataObject data, MithraDataObject newData)
	{
		boolean changed = false;
		changed |= zUpdateInteger(behavior, data, newData, LectureHallFinder.lectureHallId(), false);
		return changed;
	}

	public Object readResolve() throws ObjectStreamException
	{
		LectureHallAbstract result = (LectureHallAbstract) super.readResolve();
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
