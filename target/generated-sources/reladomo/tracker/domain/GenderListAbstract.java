package tracker.domain;
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
public class GenderListAbstract extends DelegatingList<Gender> implements MithraTransactionalList<Gender>
{
	public GenderListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public GenderListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public GenderListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public GenderListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Gender[] elements()
	{
		Gender[] result = new Gender[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public GenderList intersection(GenderList another)
	{
		return (GenderList)super.intersection(another);
	}

	public Gender getGenderAt(int index)
	{
		return (Gender)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	this.genderId = Person.genderId</pre>
	* @see Person#getGender() reverse relationship Person.getGender()
	* @return people
	*/
	public PersonList getPeople()
	{
		return (PersonList) this.getDelegated().resolveRelationship(this, GenderFinder.people());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return GenderFinder.getMithraObjectPortal();
	}

	public GenderList getNonPersistentCopy()
	{
		GenderList result = new GenderList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public GenderList asAdhoc()
	{
		return (GenderList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Gender> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public GenderList merge(MithraTransactionalList<Gender> incoming, TopLevelMergeOptions<Gender> mergeOptions)
	{
		return (GenderList) super.merge(incoming, mergeOptions);
	}

	public GenderList getDetachedCopy()
	{
		GenderList result = new GenderList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setGenderId(int newValue)
	{
		zSetInteger(GenderFinder.genderId(), newValue);
	}

	public void setGenderName(String newValue)
	{
		zSetString(GenderFinder.genderName(), newValue);
	}
}
