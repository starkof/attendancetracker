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
public class ClassTimeSlotData
implements MithraDataObject
{
	private String day;
	private Date endTime;
	private Date startTime;
	private int timeSlotId;
	public boolean isDayNull()
	{
		return this.getDay() == null;
	}

	public boolean isEndTimeNull()
	{
		return this.getEndTime() == null;
	}

	public boolean isStartTimeNull()
	{
		return this.getStartTime() == null;
	}

	public boolean isTimeSlotIdNull()
	{
		return false;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeObject(this.day);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.endTime);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.startTime);
		out.writeInt(this.timeSlotId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
	}

	public String getDay()
	{
		return this.day;
	}

	public int zGetDayAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(day);
	}

	public void setDay(String value)
	{
		this.day = StringPool.getInstance().getOrAddToCache(value, ClassTimeSlotFinder.isFullCache());
	}

	public void setDayNull()
	{
		this.setDay(null);
	}

	public Date getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.endTime = (java.sql.Date) value;
		}
		else
		{
			this.endTime = new java.sql.Date(value.getTime());
		}
	}

	public void setEndTimeNull()
	{
		this.setEndTime(null);
	}

	public Date getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.startTime = (java.sql.Date) value;
		}
		else
		{
			this.startTime = new java.sql.Date(value.getTime());
		}
	}

	public void setStartTimeNull()
	{
		this.setStartTime(null);
	}

	public int getTimeSlotId()
	{
		return this.timeSlotId;
	}

	public void setTimeSlotId(int value)
	{
		this.timeSlotId = value;
	}

	public void setTimeSlotIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	protected void copyInto(ClassTimeSlotData copy, boolean withRelationships)
	{
		copy.day = this.day;
		copy.endTime = this.endTime;
		copy.startTime = this.startTime;
		copy.timeSlotId = this.timeSlotId;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.day = StringPool.getInstance().getOrAddToCache((String)in.readObject(), ClassTimeSlotFinder.isFullCache());
		this.endTime = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.startTime = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.timeSlotId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final ClassTimeSlotData otherData = (ClassTimeSlotData) other;
		if (getTimeSlotId() != otherData.getTimeSlotId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.timeSlotId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.timeSlotId = in.readInt();
	}

	public void clearRelationships()
	{
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public void zSerializeRelationships(ObjectOutputStream out) throws IOException
	{
	}

	public void zDeserializeRelationships(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
	}

	public MithraOffHeapDataObject zCopyOffHeap()
	{
		throw new RuntimeException("off heap no supported");
	}

	public void copyNonPkAttributes(MithraDataObject newData)
	{
		final ClassTimeSlotData classTimeSlotData = (ClassTimeSlotData) newData;
		this.setDay(classTimeSlotData.getDay());
		this.setEndTime(classTimeSlotData.getEndTime());
		this.setStartTime(classTimeSlotData.getStartTime());
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
		final ClassTimeSlotData other = (ClassTimeSlotData) newData;
		if (!isDayNull() ? !getDay().equals(other.getDay()) : !other.isDayNull())
		{
			return true;
		}

		if (!isEndTimeNull() ? !getEndTime().equals(other.getEndTime()) : !other.isEndTimeNull())
		{
			return true;
		}

		if (!isStartTimeNull() ? !getStartTime().equals(other.getStartTime()) : !other.isStartTimeNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		ClassTimeSlotData copy = new ClassTimeSlotData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		ClassTimeSlotData copy = new ClassTimeSlotData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "timeSlotId: "+(""+getTimeSlotId())+ " / ";
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
		return "com.mithraobjects.ClassTimeSlotData";
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
		return ClassTimeSlotFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return ClassTimeSlotFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.ClassTimeSlotData";
	}
}
