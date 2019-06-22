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
public class DepartmentData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private int courseId;
	private int departmentId;
	private String departmentName;
	private int majorId;
	public boolean isDepartmentIdNull()
	{
		return false;
	}

	public boolean isDepartmentNameNull()
	{
		return this.getDepartmentName() == null;
	}

	public boolean isCourseIdNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isMajorIdNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.courseId);
		out.writeInt(this.departmentId);
		out.writeObject(this.departmentName);
		out.writeInt(this.majorId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public int getCourseId()
	{
		return this.courseId;
	}

	public void setCourseId(int value)
	{
		this.courseId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public int getDepartmentId()
	{
		return this.departmentId;
	}

	public void setDepartmentId(int value)
	{
		this.departmentId = value;
	}

	public void setDepartmentIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public String getDepartmentName()
	{
		return this.departmentName;
	}

	public int zGetDepartmentNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(departmentName);
	}

	public void setDepartmentName(String value)
	{
		this.departmentName = StringPool.getInstance().getOrAddToCache(value, DepartmentFinder.isFullCache());
	}

	public void setDepartmentNameNull()
	{
		this.setDepartmentName(null);
	}

	public int getMajorId()
	{
		return this.majorId;
	}

	public void setMajorId(int value)
	{
		this.majorId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public void setCourseIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setMajorIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(DepartmentData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.courseId = this.courseId;
		copy.departmentId = this.departmentId;
		copy.departmentName = this.departmentName;
		copy.majorId = this.majorId;
		if (withRelationships)
		{
			if (_relationships != null)
			{
				copy._relationships = new Object[3];
				System.arraycopy(_relationships, 0, copy._relationships, 0, _relationships.length);
			}
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.courseId = in.readInt();
		this.departmentId = in.readInt();
		this.departmentName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), DepartmentFinder.isFullCache());
		this.majorId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final DepartmentData otherData = (DepartmentData) other;
		if (getDepartmentId() != otherData.getDepartmentId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.departmentId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.departmentId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getCourses()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setCourses(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
		}

		_relationships[0] = related;
	}

	public Object getMajor()
	{
		if (_relationships != null)
		{
			return _relationships[2];
		}

		return null;
	}

	public void setMajor(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
		}

		_relationships[2] = related;
	}

	public Object getFaculty()
	{
		if (_relationships != null)
		{
			return _relationships[1];
		}

		return null;
	}

	public void setFaculty(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
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
		final DepartmentData departmentData = (DepartmentData) newData;
		this.setCourseId(departmentData.getCourseId());
		if (departmentData.isCourseIdNull()) this.setCourseIdNull();
		this.setDepartmentName(departmentData.getDepartmentName());
		this.setMajorId(departmentData.getMajorId());
		if (departmentData.isMajorIdNull()) this.setMajorIdNull();
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
		final DepartmentData other = (DepartmentData) newData;
		if ( isCourseIdNull() != other.isCourseIdNull() || getCourseId() != other.getCourseId())
		{
			return true;
		}

		if (!isDepartmentNameNull() ? !getDepartmentName().equals(other.getDepartmentName()) : !other.isDepartmentNameNull())
		{
			return true;
		}

		if ( isMajorIdNull() != other.isMajorIdNull() || getMajorId() != other.getMajorId())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		DepartmentData copy = new DepartmentData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		DepartmentData copy = new DepartmentData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "departmentId: "+(""+getDepartmentId())+ " / ";
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
		return "com.mithraobjects.DepartmentData";
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
		return DepartmentFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return DepartmentFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.DepartmentData";
	}
}
