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
public class StudentData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private Date admissionDate;
	private int courseId;
	private Date expectedGraduation;
	private int gpa;
	private int majorId;
	private int personId;
	private int studentId;
	public boolean isAdmissionDateNull()
	{
		return this.getAdmissionDate() == null;
	}

	public boolean isExpectedGraduationNull()
	{
		return this.getExpectedGraduation() == null;
	}

	public boolean isStudentIdNull()
	{
		return false;
	}

	public boolean isMajorIdNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isGpaNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public boolean isPersonIdNull()
	{
		return (isNullBits0 & 1 << 2) != 0 ;
	}

	public boolean isCourseIdNull()
	{
		return (isNullBits0 & 1 << 3) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.admissionDate);
		out.writeInt(this.courseId);
		MithraTimestamp.writeTimezoneInsensitiveDate(out, this.expectedGraduation);
		out.writeInt(this.gpa);
		out.writeInt(this.majorId);
		out.writeInt(this.personId);
		out.writeInt(this.studentId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public Date getAdmissionDate()
	{
		return this.admissionDate;
	}

	public void setAdmissionDate(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.admissionDate = (java.sql.Date) value;
		}
		else
		{
			this.admissionDate = new java.sql.Date(value.getTime());
		}
	}

	public void setAdmissionDateNull()
	{
		this.setAdmissionDate(null);
	}

	public int getCourseId()
	{
		return this.courseId;
	}

	public void setCourseId(int value)
	{
		this.courseId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 3));
	}

	public Date getExpectedGraduation()
	{
		return this.expectedGraduation;
	}

	public void setExpectedGraduation(java.util.Date value)
	{
		if (value == null || value instanceof java.sql.Date)
		{
			this.expectedGraduation = (java.sql.Date) value;
		}
		else
		{
			this.expectedGraduation = new java.sql.Date(value.getTime());
		}
	}

	public void setExpectedGraduationNull()
	{
		this.setExpectedGraduation(null);
	}

	public int getGpa()
	{
		return this.gpa;
	}

	public void setGpa(int value)
	{
		this.gpa = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public int getMajorId()
	{
		return this.majorId;
	}

	public void setMajorId(int value)
	{
		this.majorId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
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

	public int getStudentId()
	{
		return this.studentId;
	}

	public void setStudentId(int value)
	{
		this.studentId = value;
	}

	public void setStudentIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public void setMajorIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setGpaNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public void setPersonIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 2);
	}

	public void setCourseIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 3);
	}

	public byte zGetIsNullBits0()
	{
		return this.isNullBits0;
	}

	public void zSetIsNullBits0(byte newValue)
	{
		this.isNullBits0 = newValue;
	}

	protected void copyInto(StudentData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.admissionDate = this.admissionDate;
		copy.courseId = this.courseId;
		copy.expectedGraduation = this.expectedGraduation;
		copy.gpa = this.gpa;
		copy.majorId = this.majorId;
		copy.personId = this.personId;
		copy.studentId = this.studentId;
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
		this.admissionDate = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.courseId = in.readInt();
		this.expectedGraduation = (Date)MithraTimestamp.readTimezoneInsensitiveDate(in);
		this.gpa = in.readInt();
		this.majorId = in.readInt();
		this.personId = in.readInt();
		this.studentId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final StudentData otherData = (StudentData) other;
		if (getStudentId() != otherData.getStudentId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.studentId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.studentId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getMajor()
	{
		if (_relationships != null)
		{
			return _relationships[1];
		}

		return null;
	}

	public void setMajor(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[3];
		}

		_relationships[1] = related;
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
		final StudentData studentData = (StudentData) newData;
		this.setAdmissionDate(studentData.getAdmissionDate());
		this.setCourseId(studentData.getCourseId());
		if (studentData.isCourseIdNull()) this.setCourseIdNull();
		this.setExpectedGraduation(studentData.getExpectedGraduation());
		this.setGpa(studentData.getGpa());
		if (studentData.isGpaNull()) this.setGpaNull();
		this.setMajorId(studentData.getMajorId());
		if (studentData.isMajorIdNull()) this.setMajorIdNull();
		this.setPersonId(studentData.getPersonId());
		if (studentData.isPersonIdNull()) this.setPersonIdNull();
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
		final StudentData other = (StudentData) newData;
		if (!isAdmissionDateNull() ? !getAdmissionDate().equals(other.getAdmissionDate()) : !other.isAdmissionDateNull())
		{
			return true;
		}

		if ( isCourseIdNull() != other.isCourseIdNull() || getCourseId() != other.getCourseId())
		{
			return true;
		}

		if (!isExpectedGraduationNull() ? !getExpectedGraduation().equals(other.getExpectedGraduation()) : !other.isExpectedGraduationNull())
		{
			return true;
		}

		if ( isGpaNull() != other.isGpaNull() || getGpa() != other.getGpa())
		{
			return true;
		}

		if ( isMajorIdNull() != other.isMajorIdNull() || getMajorId() != other.getMajorId())
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
		StudentData copy = new StudentData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		StudentData copy = new StudentData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "studentId: "+(""+getStudentId())+ " / ";
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
		return "com.mithraobjects.StudentData";
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
		return StudentFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return StudentFinder.getMithraObjectPortal();
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
		return "com.mithraobjects.StudentData";
	}
}
