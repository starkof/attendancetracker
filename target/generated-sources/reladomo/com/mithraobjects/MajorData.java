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
public class MajorData
implements MithraDataObject
{
	private Object[] _relationships;
	private int majorId;
	private String majorName;
	public boolean isMajorIdNull()
	{
		return false;
	}

	public boolean isMajorNameNull()
	{
		return this.getMajorName() == null;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.majorId);
		out.writeObject(this.majorName);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
	}

	public int getMajorId()
	{
		return this.majorId;
	}

	public void setMajorId(int value)
	{
		this.majorId = value;
	}

	public void setMajorIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getMajorName()
	{
		return this.majorName;
	}

	public int zGetMajorNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(majorName);
	}

	public void setMajorName(String value)
	{
		this.majorName = StringPool.getInstance().getOrAddToCache(value, MajorFinder.isFullCache());
	}

	public void setMajorNameNull()
	{
		this.setMajorName(null);
	}

	protected void copyInto(MajorData copy, boolean withRelationships)
	{
		copy.majorId = this.majorId;
		copy.majorName = this.majorName;
		if (withRelationships)
		{
			if (_relationships != null)
			{
				copy._relationships = new Object[2];
				System.arraycopy(_relationships, 0, copy._relationships, 0, _relationships.length);
			}
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.majorId = in.readInt();
		this.majorName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), MajorFinder.isFullCache());
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final MajorData otherData = (MajorData) other;
		if (getMajorId() != otherData.getMajorId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.majorId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.majorId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getDepartment()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setDepartment(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[2];
		}

		_relationships[0] = related;
	}

	public Object getStudents()
	{
		if (_relationships != null)
		{
			return _relationships[1];
		}

		return null;
	}

	public void setStudents(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[2];
		}

		_relationships[1] = related;
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
		final MajorData majorData = (MajorData) newData;
		this.setMajorName(majorData.getMajorName());
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
		final MajorData other = (MajorData) newData;
		if (!isMajorNameNull() ? !getMajorName().equals(other.getMajorName()) : !other.isMajorNameNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		MajorData copy = new MajorData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		MajorData copy = new MajorData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "majorId: "+(""+getMajorId())+ " / ";
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
		return "com.mithraobjects.MajorData";
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
		return MajorFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return MajorFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.MajorData";
	}
}
