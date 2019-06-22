package tracker.domain;
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
public class LectureHallData
implements MithraDataObject
{
	private byte isNullBits0 = 0;
	private int capacity;
	private String hallName;
	private int lectureHallId;
	public boolean isHallNameNull()
	{
		return this.getHallName() == null;
	}

	public boolean isLectureHallIdNull()
	{
		return false;
	}

	public boolean isCapacityNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.capacity);
		out.writeObject(this.hallName);
		out.writeInt(this.lectureHallId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public int getCapacity()
	{
		return this.capacity;
	}

	public void setCapacity(int value)
	{
		this.capacity = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public String getHallName()
	{
		return this.hallName;
	}

	public int zGetHallNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(hallName);
	}

	public void setHallName(String value)
	{
		this.hallName = StringPool.getInstance().getOrAddToCache(value, LectureHallFinder.isFullCache());
	}

	public void setHallNameNull()
	{
		this.setHallName(null);
	}

	public int getLectureHallId()
	{
		return this.lectureHallId;
	}

	public void setLectureHallId(int value)
	{
		this.lectureHallId = value;
	}

	public void setLectureHallIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public void setCapacityNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(LectureHallData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.capacity = this.capacity;
		copy.hallName = this.hallName;
		copy.lectureHallId = this.lectureHallId;
		if (withRelationships)
		{
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.capacity = in.readInt();
		this.hallName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), LectureHallFinder.isFullCache());
		this.lectureHallId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final LectureHallData otherData = (LectureHallData) other;
		if (getLectureHallId() != otherData.getLectureHallId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.lectureHallId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.lectureHallId = in.readInt();
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
		final LectureHallData lectureHallData = (LectureHallData) newData;
		this.setCapacity(lectureHallData.getCapacity());
		if (lectureHallData.isCapacityNull()) this.setCapacityNull();
		this.setHallName(lectureHallData.getHallName());
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
		final LectureHallData other = (LectureHallData) newData;
		if ( isCapacityNull() != other.isCapacityNull() || getCapacity() != other.getCapacity())
		{
			return true;
		}

		if (!isHallNameNull() ? !getHallName().equals(other.getHallName()) : !other.isHallNameNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		LectureHallData copy = new LectureHallData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		LectureHallData copy = new LectureHallData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "lectureHallId: "+(""+getLectureHallId())+ " / ";
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
		return "tracker.domain.LectureHallData";
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
		return LectureHallFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return LectureHallFinder.getMithraObjectPortal();
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
		return "tracker.domain.LectureHallData";
	}
}
