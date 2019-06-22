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
public class GenderData
implements MithraDataObject
{
	private Object[] _relationships;
	private int genderId;
	private String genderName;
	public boolean isGenderIdNull()
	{
		return false;
	}

	public boolean isGenderNameNull()
	{
		return this.getGenderName() == null;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.genderId);
		out.writeObject(this.genderName);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
	}

	public int getGenderId()
	{
		return this.genderId;
	}

	public void setGenderId(int value)
	{
		this.genderId = value;
	}

	public void setGenderIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getGenderName()
	{
		return this.genderName;
	}

	public int zGetGenderNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(genderName);
	}

	public void setGenderName(String value)
	{
		this.genderName = StringPool.getInstance().getOrAddToCache(value, GenderFinder.isFullCache());
	}

	public void setGenderNameNull()
	{
		this.setGenderName(null);
	}

	protected void copyInto(GenderData copy, boolean withRelationships)
	{
		copy.genderId = this.genderId;
		copy.genderName = this.genderName;
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
		this.genderId = in.readInt();
		this.genderName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), GenderFinder.isFullCache());
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final GenderData otherData = (GenderData) other;
		if (getGenderId() != otherData.getGenderId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.genderId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.genderId = in.readInt();
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
		final GenderData genderData = (GenderData) newData;
		this.setGenderName(genderData.getGenderName());
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
		final GenderData other = (GenderData) newData;
		if (!isGenderNameNull() ? !getGenderName().equals(other.getGenderName()) : !other.isGenderNameNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		GenderData copy = new GenderData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		GenderData copy = new GenderData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "genderId: "+(""+getGenderId())+ " / ";
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
		return "com.mithraobjects.GenderData";
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
		return GenderFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return GenderFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.GenderData";
	}
}
