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
public class LectureHallListAbstract extends DelegatingList<LectureHall> implements MithraTransactionalList<LectureHall>
{
	public LectureHallListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public LectureHallListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public LectureHallListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public LectureHallListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public LectureHall[] elements()
	{
		LectureHall[] result = new LectureHall[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public LectureHallList intersection(LectureHallList another)
	{
		return (LectureHallList)super.intersection(another);
	}

	public LectureHall getLectureHallAt(int index)
	{
		return (LectureHall)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return LectureHallFinder.getMithraObjectPortal();
	}

	public LectureHallList getNonPersistentCopy()
	{
		LectureHallList result = new LectureHallList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public LectureHallList asAdhoc()
	{
		return (LectureHallList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<LectureHall> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public LectureHallList merge(MithraTransactionalList<LectureHall> incoming, TopLevelMergeOptions<LectureHall> mergeOptions)
	{
		return (LectureHallList) super.merge(incoming, mergeOptions);
	}

	public LectureHallList getDetachedCopy()
	{
		LectureHallList result = new LectureHallList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setCapacity(int newValue)
	{
		zSetInteger(LectureHallFinder.capacity(), newValue);
	}

	public void setHallName(String newValue)
	{
		zSetString(LectureHallFinder.hallName(), newValue);
	}

	public void setLectureHallId(int newValue)
	{
		zSetInteger(LectureHallFinder.lectureHallId(), newValue);
	}

	public void setCapacityNull()
	{
		zSetAttributeNull(LectureHallFinder.capacity());
	}
}
