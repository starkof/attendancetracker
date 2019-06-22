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
public class NationalityListAbstract extends DelegatingList<Nationality> implements MithraTransactionalList<Nationality>
{
	public NationalityListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public NationalityListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public NationalityListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public NationalityListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Nationality[] elements()
	{
		Nationality[] result = new Nationality[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public NationalityList intersection(NationalityList another)
	{
		return (NationalityList)super.intersection(another);
	}

	public Nationality getNationalityAt(int index)
	{
		return (Nationality)this.get(index);
	}

	/**
	* Relationship Expression:<pre>
	this.nationalityId = Person.nationalityId</pre>
	* @see Person#getNationality() reverse relationship Person.getNationality()
	* @return people
	*/
	public PersonList getPeople()
	{
		return (PersonList) this.getDelegated().resolveRelationship(this, NationalityFinder.people());
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return NationalityFinder.getMithraObjectPortal();
	}

	public NationalityList getNonPersistentCopy()
	{
		NationalityList result = new NationalityList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public NationalityList asAdhoc()
	{
		return (NationalityList) super.asAdhoc();
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
	public org.eclipse.collections.api.list.MutableList<Nationality> asEcList()
	{
		return org.eclipse.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public NationalityList merge(MithraTransactionalList<Nationality> incoming, TopLevelMergeOptions<Nationality> mergeOptions)
	{
		return (NationalityList) super.merge(incoming, mergeOptions);
	}

	public NationalityList getDetachedCopy()
	{
		NationalityList result = new NationalityList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	public void setNationalityId(int newValue)
	{
		zSetInteger(NationalityFinder.nationalityId(), newValue);
	}

	public void setNationalityValue(String newValue)
	{
		zSetString(NationalityFinder.nationalityValue(), newValue);
	}
}
