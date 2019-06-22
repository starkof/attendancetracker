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
public class MaritalStatusListAbstract extends DelegatingList<MaritalStatus> implements MithraTransactionalList<MaritalStatus>
{
	public MaritalStatusListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public MaritalStatusListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public MaritalStatusListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public MaritalStatusListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public MaritalStatus[] elements()
	{
		MaritalStatus[] result = new MaritalStatus[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public MaritalStatusList intersection(MaritalStatusList another)
	{
		return (MaritalStatusList)super.intersection(another);
	}

	public MaritalStatus getMaritalStatusAt(int index)
	{
		return (MaritalStatus)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	this.maritalStatusId = Person.maritalStatusId</pre>
	* @see Person#getMaritalStatus() reverse relationship Person.getMaritalStatus()
	* @return people
	*/
	public PersonList getPeople()
	{
		return (PersonList) this.getDelegated().resolveRelationship(this, MaritalStatusFinder.people());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return MaritalStatusFinder.getMithraObjectPortal();
	}

	public MaritalStatusList getNonPersistentCopy()
	{
		MaritalStatusList result = new MaritalStatusList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public MaritalStatusList asAdhoc()
	{
		return (MaritalStatusList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<MaritalStatus> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public MaritalStatusList merge(MithraTransactionalList<MaritalStatus> incoming, TopLevelMergeOptions<MaritalStatus> mergeOptions)
	{
		return (MaritalStatusList) super.merge(incoming, mergeOptions);
	}

	public MaritalStatusList getDetachedCopy()
	{
		MaritalStatusList result = new MaritalStatusList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setMaritalStatusId(int newValue)
	{
		zSetInteger(MaritalStatusFinder.maritalStatusId(), newValue);
	}

	public void setMaritalStatusValue(String newValue)
	{
		zSetString(MaritalStatusFinder.maritalStatusValue(), newValue);
	}
}
