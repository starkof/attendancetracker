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
public class ClassTimeSlotListAbstract extends DelegatingList<ClassTimeSlot> implements MithraTransactionalList<ClassTimeSlot>
{
	public ClassTimeSlotListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public ClassTimeSlotListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public ClassTimeSlotListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public ClassTimeSlotListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public ClassTimeSlot[] elements()
	{
		ClassTimeSlot[] result = new ClassTimeSlot[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public ClassTimeSlotList intersection(ClassTimeSlotList another)
	{
		return (ClassTimeSlotList)super.intersection(another);
	}

	public ClassTimeSlot getClassTimeSlotAt(int index)
	{
		return (ClassTimeSlot)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return ClassTimeSlotFinder.getMithraObjectPortal();
	}

	public ClassTimeSlotList getNonPersistentCopy()
	{
		ClassTimeSlotList result = new ClassTimeSlotList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public ClassTimeSlotList asAdhoc()
	{
		return (ClassTimeSlotList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<ClassTimeSlot> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public ClassTimeSlotList merge(MithraTransactionalList<ClassTimeSlot> incoming, TopLevelMergeOptions<ClassTimeSlot> mergeOptions)
	{
		return (ClassTimeSlotList) super.merge(incoming, mergeOptions);
	}

	public ClassTimeSlotList getDetachedCopy()
	{
		ClassTimeSlotList result = new ClassTimeSlotList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setDay(String newValue)
	{
		zSetString(ClassTimeSlotFinder.day(), newValue);
	}

	public void setEndTime(Date newValue)
	{
		zSetDate(ClassTimeSlotFinder.endTime(), newValue);
	}

	public void setStartTime(Date newValue)
	{
		zSetDate(ClassTimeSlotFinder.startTime(), newValue);
	}

	public void setTimeSlotId(int newValue)
	{
		zSetInteger(ClassTimeSlotFinder.timeSlotId(), newValue);
	}
}
