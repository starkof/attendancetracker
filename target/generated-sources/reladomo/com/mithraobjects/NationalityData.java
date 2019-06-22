package com.mithraobjects;
import java.util.*;
import java.sql.Timestamp;
import java.sql.Date;
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
import com.gs.fw.common.mithra.finder.PrintablePreparedStatement;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.cache.offheap.MithraOffHeapDataObject;
import com.gs.fw.common.mithra.cache.offheap.OffHeapDataStorage;
/**
* This file was automatically generated using Mithra 17.0.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class NationalityData
implements MithraDataObject
{
	private Object[] _relationships;
	private int nationalityId;
	private String nationalityValue;
	public boolean isNationalityIdNull()
	{
		return false;
	}

	public boolean isNationalityValueNull()
	{
		return this.getNationalityValue() == null;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.nationalityId);
		out.writeObject(this.nationalityValue);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
	}

	public int getNationalityId()
	{
		return this.nationalityId;
	}

	public void setNationalityId(int value)
	{
		this.nationalityId = value;
	}

	public void setNationalityIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getNationalityValue()
	{
		return this.nationalityValue;
	}

	public int zGetNationalityValueAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(nationalityValue);
	}

	public void setNationalityValue(String value)
	{
		this.nationalityValue = StringPool.getInstance().getOrAddToCache(value, NationalityFinder.isFullCache());
	}

	public void setNationalityValueNull()
	{
		this.setNationalityValue(null);
	}

	protected void copyInto(NationalityData copy, boolean withRelationships)
	{
		copy.nationalityId = this.nationalityId;
		copy.nationalityValue = this.nationalityValue;
		if (withRelationships)
		{
			if (_relationships != null)
			{
				copy._relationships = new Object[1];
				System.arraycopy(_relationships, 0, copy._relationships, 0, _relationships.length);
			}
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.nationalityId = in.readInt();
		this.nationalityValue = StringPool.getInstance().getOrAddToCache((String)in.readObject(), NationalityFinder.isFullCache());
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final NationalityData otherData = (NationalityData) other;
		if (getNationalityId() != otherData.getNationalityId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.nationalityId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.nationalityId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getPeople()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setPeople(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[1];
		}

		_relationships[0] = related;
	}

	public void zSerializeRelationships(ObjectOutputStream out) throws IOException
	{
		if (_relationships == null)
		{
			out.writeInt(0);
			return;
		}

		out.writeInt(_relationships.length);
		for(int i=0;i<_relationships.length;i++)
		{
			out.writeObject(_relationships[i]);
		}
	}

	public void zDeserializeRelationships(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		int total = in.readInt();
		if(total > 0)
		{
			_relationships = new Object[total];
			for(int i=0;i<total;i++)
			{
				_relationships[i] = in.readObject();
			}
		}
	}

	public MithraOffHeapDataObject zCopyOffHeap()
	{
		throw new RuntimeException("off heap no supported");
	}

	public void copyNonPkAttributes(MithraDataObject newData)
	{
		final NationalityData nationalityData = (NationalityData) newData;
		this.setNationalityValue(nationalityData.getNationalityValue());
	}

	public byte zGetDataVersion() 
	{
		return (byte)0; 
	}

	public void zSetDataVersion(byte version) 
	{
	}
	// only used by dated objects
	public void zIncrementDataVersion() 
	{
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData)
	{
		return this.zNonPrimaryKeyAttributesChanged(newData, 0.0);
	}

	public boolean zNonPrimaryKeyAttributesChanged(MithraDataObject newData, double toleranceForFloatingPointFields)
	{
		final NationalityData other = (NationalityData) newData;
		if (!isNationalityValueNull() ? !getNationalityValue().equals(other.getNationalityValue()) : !other.isNationalityValueNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		NationalityData copy = new NationalityData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		NationalityData copy = new NationalityData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "nationalityId: "+(""+getNationalityId())+ " / ";
		return result;
	}

	public boolean zAsOfAttributesFromEquals(MithraDataObject other)
	{
		return true;
	}

	public boolean zAsOfAttributesChanged(MithraDataObject other)
	{
		return false;
	}

	public void zWriteDataClassName(ObjectOutput out) throws IOException
	{
	}

	public String zReadDataClassName(ObjectInput in) throws IOException, ClassNotFoundException
	{
		return "com.mithraobjects.NationalityData";
	}

	public boolean changed(MithraDataObject newData)
	{
		if(zNonPrimaryKeyAttributesChanged(newData))
		{
			return true;
		}
		else
		{
			return zAsOfAttributesChanged(newData);
		}
	}

	public boolean zHasSameNullPrimaryKeyAttributes(MithraDataObject newData)
	{
		return true;
	}

	public MithraObjectPortal zGetMithraObjectPortal(int hierarchyDepth)
	{
		return NationalityFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return NationalityFinder.getMithraObjectPortal();
	}

	public Number zGetIdentityValue()
	{
		return null;
	}

	public boolean zHasIdentity()
	{
		return false;
	}

	public void zSetIdentity(Number identityValue)
	{
	}

	public String zGetSerializationClassName()
	{
		return "com.mithraobjects.NationalityData";
	}
}
