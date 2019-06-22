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
public class PersonData
implements MithraDataObject
{
	private Object[] _relationships;
	private byte isNullBits0 = 0;
	private int age;
	private String firstName;
	private int genderId;
	private String lastName;
	private int maritalStatusId;
	private int nationalityId;
	private String otherNames;
	private int personId;
	public boolean isFirstNameNull()
	{
		return this.getFirstName() == null;
	}

	public boolean isLastNameNull()
	{
		return this.getLastName() == null;
	}

	public boolean isOtherNamesNull()
	{
		return this.getOtherNames() == null;
	}

	public boolean isPersonIdNull()
	{
		return false;
	}

	public boolean isAgeNull()
	{
		return (isNullBits0 & 1) != 0 ;
	}

	public boolean isGenderIdNull()
	{
		return (isNullBits0 & 1 << 1) != 0 ;
	}

	public boolean isMaritalStatusIdNull()
	{
		return (isNullBits0 & 1 << 2) != 0 ;
	}

	public boolean isNationalityIdNull()
	{
		return (isNullBits0 & 1 << 3) != 0 ;
	}

	public void zSerializeFullData(ObjectOutput out) throws IOException
	{
		zWriteNullBits(out);
		out.writeInt(this.age);
		out.writeObject(this.firstName);
		out.writeInt(this.genderId);
		out.writeObject(this.lastName);
		out.writeInt(this.maritalStatusId);
		out.writeInt(this.nationalityId);
		out.writeObject(this.otherNames);
		out.writeInt(this.personId);
	}

	private void zWriteNullBits(ObjectOutput out) throws IOException
	{
		out.writeByte(this.isNullBits0);
	}

	public int getAge()
	{
		return this.age;
	}

	public void setAge(int value)
	{
		this.age = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1));
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public int zGetFirstNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(firstName);
	}

	public void setFirstName(String value)
	{
		this.firstName = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
	}

	public void setFirstNameNull()
	{
		this.setFirstName(null);
	}

	public int getGenderId()
	{
		return this.genderId;
	}

	public void setGenderId(int value)
	{
		this.genderId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 1));
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public int zGetLastNameAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(lastName);
	}

	public void setLastName(String value)
	{
		this.lastName = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
	}

	public void setLastNameNull()
	{
		this.setLastName(null);
	}

	public int getMaritalStatusId()
	{
		return this.maritalStatusId;
	}

	public void setMaritalStatusId(int value)
	{
		this.maritalStatusId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 2));
	}

	public int getNationalityId()
	{
		return this.nationalityId;
	}

	public void setNationalityId(int value)
	{
		this.nationalityId = value;
		isNullBits0 = (byte)((int)isNullBits0 & ~( 1 << 3));
	}

	public String getOtherNames()
	{
		return this.otherNames;
	}

	public int zGetOtherNamesAsInt()
	{
		return StringPool.getInstance().getOffHeapAddressWithoutAdding(otherNames);
	}

	public void setOtherNames(String value)
	{
		this.otherNames = StringPool.getInstance().getOrAddToCache(value, PersonFinder.isFullCache());
	}

	public void setOtherNamesNull()
	{
		this.setOtherNames(null);
	}

	public int getPersonId()
	{
		return this.personId;
	}

	public void setPersonId(int value)
	{
		this.personId = value;
	}

	public void setPersonIdNull()
	{
		throw new RuntimeException("should never be called");
	}

	public void setAgeNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1);
	}

	public void setGenderIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 1);
	}

	public void setMaritalStatusIdNull()
	{
		isNullBits0 = (byte)((int)isNullBits0 | 1 << 2);
	}

	public void setNationalityIdNull()
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

	protected void copyInto(PersonData copy, boolean withRelationships)
	{
		copy.isNullBits0 = this.isNullBits0;
		copy.age = this.age;
		copy.firstName = this.firstName;
		copy.genderId = this.genderId;
		copy.lastName = this.lastName;
		copy.maritalStatusId = this.maritalStatusId;
		copy.nationalityId = this.nationalityId;
		copy.otherNames = this.otherNames;
		copy.personId = this.personId;
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
		this.age = in.readInt();
		this.firstName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.genderId = in.readInt();
		this.lastName = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.maritalStatusId = in.readInt();
		this.nationalityId = in.readInt();
		this.otherNames = StringPool.getInstance().getOrAddToCache((String)in.readObject(), PersonFinder.isFullCache());
		this.personId = in.readInt();
	}

	public boolean hasSamePrimaryKeyIgnoringAsOfAttributes(MithraDataObject other)
	{
		if (this == other) return true;
		final PersonData otherData = (PersonData) other;
		if (getPersonId() != otherData.getPersonId())
		{
			return false;
		}

		return true;
	}

	public void zSerializePrimaryKey(ObjectOutput out) throws IOException
	{
		out.writeInt(this.personId);
	}

	public void zDeserializePrimaryKey(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.personId = in.readInt();
	}

	public void clearRelationships()
	{
		_relationships = null;
		clearAllDirectRefs();
	}

	public void clearAllDirectRefs()
	{
	}

	public Object getGender()
	{
		if (_relationships != null)
		{
			return _relationships[1];
		}

		return null;
	}

	public void setGender(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[1] = related;
	}

	public Object getMaritalStatus()
	{
		if (_relationships != null)
		{
			return _relationships[2];
		}

		return null;
	}

	public void setMaritalStatus(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[2] = related;
	}

	public Object getNationality()
	{
		if (_relationships != null)
		{
			return _relationships[3];
		}

		return null;
	}

	public void setNationality(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[3] = related;
	}

	public Object getFaculty()
	{
		if (_relationships != null)
		{
			return _relationships[0];
		}

		return null;
	}

	public void setFaculty(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[0] = related;
	}

	public Object getStudent()
	{
		if (_relationships != null)
		{
			return _relationships[4];
		}

		return null;
	}

	public void setStudent(Object related)
	{
		if (_relationships == null)
		{
			_relationships = new Object[5];
		}

		_relationships[4] = related;
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
		final PersonData personData = (PersonData) newData;
		this.setAge(personData.getAge());
		if (personData.isAgeNull()) this.setAgeNull();
		this.setFirstName(personData.getFirstName());
		this.setGenderId(personData.getGenderId());
		if (personData.isGenderIdNull()) this.setGenderIdNull();
		this.setLastName(personData.getLastName());
		this.setMaritalStatusId(personData.getMaritalStatusId());
		if (personData.isMaritalStatusIdNull()) this.setMaritalStatusIdNull();
		this.setNationalityId(personData.getNationalityId());
		if (personData.isNationalityIdNull()) this.setNationalityIdNull();
		this.setOtherNames(personData.getOtherNames());
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
		final PersonData other = (PersonData) newData;
		if ( isAgeNull() != other.isAgeNull() || getAge() != other.getAge())
		{
			return true;
		}

		if (!isFirstNameNull() ? !getFirstName().equals(other.getFirstName()) : !other.isFirstNameNull())
		{
			return true;
		}

		if ( isGenderIdNull() != other.isGenderIdNull() || getGenderId() != other.getGenderId())
		{
			return true;
		}

		if (!isLastNameNull() ? !getLastName().equals(other.getLastName()) : !other.isLastNameNull())
		{
			return true;
		}

		if ( isMaritalStatusIdNull() != other.isMaritalStatusIdNull() || getMaritalStatusId() != other.getMaritalStatusId())
		{
			return true;
		}

		if ( isNationalityIdNull() != other.isNationalityIdNull() || getNationalityId() != other.getNationalityId())
		{
			return true;
		}

		if (!isOtherNamesNull() ? !getOtherNames().equals(other.getOtherNames()) : !other.isOtherNamesNull())
		{
			return true;
		}

		return false;
	}

	public MithraDataObject copy()
	{
		PersonData copy = new PersonData();
		this.copyInto(copy, true);
		return copy;
	}

	public MithraDataObject copy(boolean withRelationships)
	{
		PersonData copy = new PersonData();
		this.copyInto(copy, withRelationships);
		return copy;
	}

	public String zGetPrintablePrimaryKey()
	{
		String result = "";
		result += "personId: "+(""+getPersonId())+ " / ";
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
		return "tracker.domain.PersonData";
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
		return PersonFinder.getMithraObjectPortal();
	}

	public MithraObjectPortal zGetMithraObjectPortal()
	{
		return PersonFinder.getMithraObjectPortal();
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
		return "tracker.domain.PersonData";
	}
}
