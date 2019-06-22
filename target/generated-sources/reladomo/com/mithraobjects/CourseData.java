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
public class CourseData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private int courseId;
	private Date endDate;
	private int lectureHallId;
	private String semester;
	private Date startDate;
	private int timeSlotId;
	public boolean isCourseIdNull()
	{
		return false;
	}

	public boolean isEndDateNull()
	{
		return this.getEndDate() == null;
	}

	public boolean isSemesterNull()
	{
		return this.getSemester() == null;
	}

	public boolean isStartDateNull()
	{
		return this.getStartDate() == null;
	}

	public boolean isTimeSlotIdNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isLectureHallIdNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.courseId);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.endDate);
		out.writeInt(this.lectureHallId);
		out.writeObject(this.semester);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.startDate);
		out.writeInt(this.timeSlotId);
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
	}

	public void setCourseIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public Date getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.endDate = (java.sql.Date) value;
		}
		else
		{
			this.endDate = new java.sql.Date(value.getTime());
		}
	}

	public void setEndDateNull()
	{
		this.setEndDate(null);
	}

	public int getLectureHallId()
	{
		return this.lectureHallId;
	}

	public void setLectureHallId(int value)
	{
		this.lectureHallId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public String getSemester()
	{
		return this.semester;
	}

	public int zGetSemesterAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(semester);
	}

	public void setSemester(String value)
	{
		this.semester = StringPool.getInstance().getOrAddToCache(value, CourseFinder.isFullCache());
	}

	public void setSemesterNull()
	{
		this.setSemester(null);
	}

	public Date getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.startDate = (java.sql.Date) value;
		}
		else
		{
			this.startDate = new java.sql.Date(value.getTime());
		}
	}

	public void setStartDateNull()
	{
		this.setStartDate(null);
	}

	public int getTimeSlotId()
	{
		return this.timeSlotId;
	}

	public void setTimeSlotId(int value)
	{
		this.timeSlotId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public void setTimeSlotIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setLectureHallIdNull()
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

	protected void copyInto(CourseData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.courseId = this.courseId;
		copy.endDate = this.endDate;
		copy.lectureHallId = this.lectureHallId;
		copy.semester = this.semester;
		copy.startDate = this.startDate;
		copy.timeSlotId = this.timeSlotId;
		if (withRelationships)
		{
			if (_relationships != null)
			{
				copy._relationships = new Object[5];
				System.arraycopy(_relationships, 0, copy._relationships, 0, _relationships.length);
			}
		}
	}

	public void zDeserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.isNullBits0 = in.readByte();
		this.courseId = in.readInt();
		this.endDate = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.lectureHallId = in.readInt();
		this.semester = StringPool.getInstance().getOrAddToCache((String)in.readObject(), CourseFinder.isFullCache());
		this.startDate = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.timeSlotId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final CourseData otherData = (CourseData) other;
		if (getCourseId() != otherData.getCourseId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.courseId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.courseId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getTime()
	{
		if (_relationships != null)
		{
			return _relationships[4];
		}

		return null;
	}

	public void setTime(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[4] = related;
	}

	public Object getLectureHall()
	{
		if (_relationships != null)
		{
			return _relationships[2];
		}

		return null;
	}

	public void setLectureHall(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[2] = related;
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
			_relationships = new Object[5];
		}

		_relationships[0] = related;
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
			_relationships = new Object[5];
		}

		_relationships[1] = related;
	}

	public Object getStudents()
	{
		if (_relationships != null)
		{
			return _relationships[3];
		}

		return null;
	}

	public void setStudents(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[3] = related;
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
		final CourseData courseData = (CourseData) newData;
		this.setEndDate(courseData.getEndDate());
		this.setLectureHallId(courseData.getLectureHallId());
		if (courseData.isLectureHallIdNull()) this.setLectureHallIdNull();
		this.setSemester(courseData.getSemester());
		this.setStartDate(courseData.getStartDate());
		this.setTimeSlotId(courseData.getTimeSlotId());
		if (courseData.isTimeSlotIdNull()) this.setTimeSlotIdNull();
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
		final CourseData other = (CourseData) newData;
		if (!isEndDateNull() ? !getEndDate().equals(other.getEndDate()) : !other.isEndDateNull())
		{
			return true;
		}

		if ( isLectureHallIdNull() != other.isLectureHallIdNull() || getLectureHallId() != other.getLectureHallId())
		{
			return true;
		}

		if (!isSemesterNull() ? !getSemester().equals(other.getSemester()) : !other.isSemesterNull())
		{
			return true;
		}

		if (!isStartDateNull() ? !getStartDate().equals(other.getStartDate()) : !other.isStartDateNull())
		{
			return true;
		}

		if ( isTimeSlotIdNull() != other.isTimeSlotIdNull() || getTimeSlotId() != other.getTimeSlotId())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		CourseData copy = new CourseData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		CourseData copy = new CourseData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "courseId: "+(""+getCourseId())+ " / ";
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
		return "com.mithraobjects.CourseData";
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
		return CourseFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return CourseFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.CourseData";
	}
}
