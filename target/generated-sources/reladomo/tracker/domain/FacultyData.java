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
public class FacultyData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private int courseId;
	private int departmentId;
	private int facultyId;
	private int personId;
	public boolean isFacultyIdNull()
	{
		return false;
	}

	public boolean isDepartmentIdNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isCourseIdNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public boolean isPersonIdNull()
	{
		return (isNullBits0 & 1 << 2) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.courseId);
		out.writeInt(this.departmentId);
		out.writeInt(this.facultyId);
		out.writeInt(this.personId);
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
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public int getDepartmentId()
	{
		return this.departmentId;
	}

	public void setDepartmentId(int value)
	{
		this.departmentId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public int getFacultyId()
	{
		return this.facultyId;
	}

	public void setFacultyId(int value)
	{
		this.facultyId = value;
	}

	public void setFacultyIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public int getPersonId()
	{
		return this.personId;
	}

	public void setPersonId(int value)
	{
		this.personId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 2));
	}

	public void setDepartmentIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setCourseIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public void setPersonIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 2);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(FacultyData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.courseId = this.courseId;
		copy.departmentId = this.departmentId;
		copy.facultyId = this.facultyId;
		copy.personId = this.personId;
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
		this.facultyId = in.readInt();
		this.personId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final FacultyData otherData = (FacultyData) other;
		if (getFacultyId() != otherData.getFacultyId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.facultyId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.facultyId = in.readInt();
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
			return _relationships[1];
		}

		return null;
	}

	public void setDepartment(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
		}

		_relationships[1] = related;
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

	public Object getPerson()
	{
		if (_relationships != null)
		{
			return _relationships[2];
		}

		return null;
	}

	public void setPerson(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
		}

		_relationships[2] = related;
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
		final FacultyData facultyData = (FacultyData) newData;
		this.setCourseId(facultyData.getCourseId());
		if (facultyData.isCourseIdNull()) this.setCourseIdNull();
		this.setDepartmentId(facultyData.getDepartmentId());
		if (facultyData.isDepartmentIdNull()) this.setDepartmentIdNull();
		this.setPersonId(facultyData.getPersonId());
		if (facultyData.isPersonIdNull()) this.setPersonIdNull();
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
		final FacultyData other = (FacultyData) newData;
		if ( isCourseIdNull() != other.isCourseIdNull() || getCourseId() != other.getCourseId())
		{
			return true;
		}

		if ( isDepartmentIdNull() != other.isDepartmentIdNull() || getDepartmentId() != other.getDepartmentId())
		{
			return true;
		}

		if ( isPersonIdNull() != other.isPersonIdNull() || getPersonId() != other.getPersonId())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		FacultyData copy = new FacultyData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		FacultyData copy = new FacultyData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "facultyId: "+(""+getFacultyId())+ " / ";
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
		return "tracker.domain.FacultyData";
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
		return FacultyFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return FacultyFinder.getMithraObjectPortal();
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
		return "tracker.domain.FacultyData";
	}
}
