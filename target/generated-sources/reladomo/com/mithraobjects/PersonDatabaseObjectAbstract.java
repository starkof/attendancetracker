package com.mithraobjects;
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
import java.util.*;
import java.sql.*;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.update.AttributeUpdateWrapper;
import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.cache.*;
import com.gs.fw.common.mithra.cache.offheap.*;
import com.gs.fw.common.mithra.connectionmanager.*;
import com.gs.fw.common.mithra.database.*;
import com.gs.fw.common.mithra.databasetype.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.integer.IntegerResultSetParser;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.remote.RemoteMithraService;
import com.gs.fw.common.mithra.transaction.BatchUpdateOperation;
import com.gs.fw.common.mithra.transaction.UpdateOperation;
/**
* This file was automatically generated using Mithra 17.0.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public abstract class PersonDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "FIRST_NAME,LAST_NAME,OTHER_NAMES,AGE,GENDER_ID,MARITAL_STATUS_ID,NATIONALITY_ID";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.FIRST_NAME,t0.LAST_NAME,t0.OTHER_NAMES,t0.AGE,t0.GENDER_ID,t0.MARITAL_STATUS_ID,t0.NATIONALITY_ID";
	private static final String PK_WITH_ALIAS = "t0.PERSON_ID = ?";
	private static final String PK_INDEX_COLS = "PERSON_ID";
	protected PersonDatabaseObjectAbstract()
	{
		super("Person", "com.mithraobjects.PersonFinder",
			8, 8,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return PersonFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return PersonFinder.getFinderInstance();
	}

	public static PersonData allocateOnHeapData()
	{
		return new PersonData();
	}

	public static PersonData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new PersonData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		PersonData data = new PersonData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(PersonFinder.getPrimaryKeyAttributes(), this, PersonFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(PersonFinder.getPrimaryKeyAttributes(), this, PersonFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(PersonFinder.getPrimaryKeyAttributes(), this, PersonFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(PersonFinder.getPrimaryKeyAttributes(), this, PersonFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			PersonFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			PersonFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			Person.zConfigFullTx();
		}
		else
		{
			Person.zConfigNonTx();
		}
	}

	public List getSimulatedSequenceInitValues()
	{
		return null;
	}

	public Object getSourceAttributeValueForSelectedObjectGeneric(SqlQuery query, int queryNumber)
	{
		return null;
	}

	public Object getSourceAttributeValueFromObjectGeneric(MithraDataObject object)
	{
		return null;
	}

	public Object getSourceAttributeValueGeneric(SqlQuery query, MapperStackImpl mapperStack, int queryNumber)
	{
		return null;
	}

	public String getDatabaseIdentifierGenericSource (Object source)
	{
		return connectionManager.getDatabaseIdentifier();
	}

	public DatabaseType getDatabaseTypeGenericSource(Object source)
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZoneGenericSource(Object source)
	{
		return getDatabaseTimeZone();
	}

	public Connection getConnectionGenericSource(Object source)
	{
		return connectionManagerWrapper.getConnection();
	}

	public BulkLoader createBulkLoaderGenericSource(Object source) throws BulkLoaderException 
	{
		return connectionManager.createBulkLoader();
	}

	public MithraDataObject inflateDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflatePersonData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkPersonData(1, (PersonData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflatePersonPkData(rs, dt);
	}

	public String getSchemaGenericSource(Object source)
	{
		if (this.schemaManager != null)
		{
			return this.schemaManager.getSchema(this.getDefaultSchema());
		}

		return this.getDefaultSchema();
	}

	public String getTableNameGenericSource(Object source) throws MithraDatabaseException
	{
		return getPersonTableName();
	}

	public String getPersonTableName() throws MithraDatabaseException
	{
		if (this.tablePartitionManager != null)
		{
			return this.tablePartitionManager.getTableName(this.getDefaultTableName());
		}

		return this.getDefaultTableName();
	}

	public void setPrimaryKeyAttributes(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		PersonData data = (PersonData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getPersonId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "PERSON_ID = ?";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttribute(MithraDataObject dataObj)
	{
		return "";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttributeWithDefaultAlias(MithraDataObject dataObj)
	{
		return "";
	}

	public String getColumnListWithPk(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.PERSON_ID,t0.FIRST_NAME,t0.LAST_NAME,t0.OTHER_NAMES,t0.AGE,t0.GENDER_ID,t0.MARITAL_STATUS_ID,t0.NATIONALITY_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*8);
		result.append(databaseAlias).append(".").append("PERSON_ID");
		result.append(",").append(databaseAlias).append(".").append("FIRST_NAME");
		result.append(",").append(databaseAlias).append(".").append("LAST_NAME");
		result.append(",").append(databaseAlias).append(".").append("OTHER_NAMES");
		result.append(",").append(databaseAlias).append(".").append("AGE");
		result.append(",").append(databaseAlias).append(".").append("GENDER_ID");
		result.append(",").append(databaseAlias).append(".").append("MARITAL_STATUS_ID");
		result.append(",").append(databaseAlias).append(".").append("NATIONALITY_ID");
		return result.toString();
	}

	public Object getConnectionManager()
	{
		return connectionManager;
	}

	public void setConnectionManager(Object connectionManager, ConnectionManagerWrapper wrapper)
	{
		this.connectionManager = (SourcelessConnectionManager)connectionManager;
		this.connectionManagerWrapper = wrapper;
	}

	public PersonData inflatePersonData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		PersonData data = inflatePersonPkData(rs, dt);
		inflateNonPkPersonData(2, data, rs, dt);
		return data;
	}

	public PersonData inflatePersonPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		PersonData _data = new PersonData();
		int _pos = 1;
		_data.setPersonId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "personId");
		return _data;
	}

	public void inflateNonPkPersonData(int _pos, PersonData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			PersonData _data = _datax;
			_data.setFirstName(trimString(_rs.getString(_pos++)));
			_data.setLastName(trimString(_rs.getString(_pos++)));
			_data.setOtherNames(trimString(_rs.getString(_pos++)));
			_data.setAge(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setAgeNull();
			}

			_data.setGenderId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setGenderIdNull();
			}

			_data.setMaritalStatusId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setMaritalStatusIdNull();
			}

			_data.setNationalityId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setNationalityIdNull();
			}
		}
	}

	public DatabaseType getDatabaseType()
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZone()
	{
		return connectionManager.getDatabaseTimeZone();
	}

	protected String getSchema()
	{
		return this.getSchemaGenericSource(null);
	}

	public void setSchemaManager(Object schemaManager)
	{
		if( schemaManager instanceof SchemaManager )
		{
			this.schemaManager = (SchemaManager) schemaManager;
		}
		else
		{
			throw new IllegalArgumentException( "Schema manager class " + schemaManager.getClass().getName()
			+ " does not implement SchemaManager.class" );
		}
	}

	public void setTablePartitionManager(Object tablePartitionManager)
	{
		if( tablePartitionManager instanceof TablePartitionManager )
		{
			this.tablePartitionManager = (TablePartitionManager) tablePartitionManager;
		}
		else
		{
			throw new IllegalArgumentException( "Table partition manager class " + tablePartitionManager.getClass().getName()
			+ " does not implement TablePartitionManager.class" );
		}
	}

	public String getTableName()
	{
		return this.getDefaultTableName();
	}

	public String getDefaultTableName()
	{
		return "PERSONS";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		PersonData data = (PersonData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getPersonId());
		if (data.isFirstNameNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getFirstName());
		}

		if (data.isLastNameNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getLastName());
		}

		if (data.isOtherNamesNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getOtherNames());
		}

		if (data.isAgeNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getAge());
		}

		if (data.isGenderIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getGenderId());
		}

		if (data.isMaritalStatusIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getMaritalStatusId());
		}

		if (data.isNationalityIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getNationalityId());
		}
	}

	public String getInsertFields()
	{
		return "PERSON_ID,FIRST_NAME,LAST_NAME,OTHER_NAMES,AGE,GENDER_ID,MARITAL_STATUS_ID,NATIONALITY_ID";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		Person newObject = new Person();
		newObject.zSetFromPersonData((PersonData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.PERSON_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*8);
		result.append(databaseAlias);
		result.append(".");
		result.append("PERSON_ID");
		return result.toString();
	}
}
