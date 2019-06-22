package tracker.domain;
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
public abstract class ClassTimeSlotDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "START_TIME,END_TIME,DAY";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.START_TIME,t0.END_TIME,t0.DAY";
	private static final String PK_WITH_ALIAS = "t0.TIME_SLOT_ID = ?";
	private static final String PK_INDEX_COLS = "TIME_SLOT_ID";
	protected ClassTimeSlotDatabaseObjectAbstract()
	{
		super("ClassTimeSlot", "tracker.domain.ClassTimeSlotFinder",
			4, 4,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return ClassTimeSlotFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return ClassTimeSlotFinder.getFinderInstance();
	}

	public static ClassTimeSlotData allocateOnHeapData()
	{
		return new ClassTimeSlotData();
	}

	public static ClassTimeSlotData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new ClassTimeSlotData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		ClassTimeSlotData data = new ClassTimeSlotData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(ClassTimeSlotFinder.getPrimaryKeyAttributes(), this, ClassTimeSlotFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(ClassTimeSlotFinder.getPrimaryKeyAttributes(), this, ClassTimeSlotFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(ClassTimeSlotFinder.getPrimaryKeyAttributes(), this, ClassTimeSlotFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(ClassTimeSlotFinder.getPrimaryKeyAttributes(), this, ClassTimeSlotFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			ClassTimeSlotFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			ClassTimeSlotFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			ClassTimeSlot.zConfigFullTx();
		}
		else
		{
			ClassTimeSlot.zConfigNonTx();
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
		return inflateClassTimeSlotData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkClassTimeSlotData(1, (ClassTimeSlotData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateClassTimeSlotPkData(rs, dt);
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
		return getClassTimeSlotTableName();
	}

	public String getClassTimeSlotTableName() throws MithraDatabaseException
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
		ClassTimeSlotData data = (ClassTimeSlotData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getTimeSlotId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "TIME_SLOT_ID = ?";
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
			return "t0.TIME_SLOT_ID,t0.START_TIME,t0.END_TIME,t0.DAY";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*4);
		result.append(databaseAlias).append(".").append("TIME_SLOT_ID");
		result.append(",").append(databaseAlias).append(".").append("START_TIME");
		result.append(",").append(databaseAlias).append(".").append("END_TIME");
		result.append(",").append(databaseAlias).append(".").append("DAY");
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

	public ClassTimeSlotData inflateClassTimeSlotData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		ClassTimeSlotData data = inflateClassTimeSlotPkData(rs, dt);
		inflateNonPkClassTimeSlotData(2, data, rs, dt);
		return data;
	}

	public ClassTimeSlotData inflateClassTimeSlotPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		ClassTimeSlotData _data = new ClassTimeSlotData();
		int _pos = 1;
		_data.setTimeSlotId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "timeSlotId");
		return _data;
	}

	public void inflateNonPkClassTimeSlotData(int _pos, ClassTimeSlotData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			ClassTimeSlotData _data = _datax;
			_data.setStartTime(_rs.getDate(_pos++));
			_data.setEndTime(_rs.getDate(_pos++));
			_data.setDay(trimString(_rs.getString(_pos++)));
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
		return "CLASS_TIME_SLOTS";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		ClassTimeSlotData data = (ClassTimeSlotData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getTimeSlotId());
		if (data.isStartTimeNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getStartTime());
		}

		if (data.isEndTimeNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getEndTime());
		}

		if (data.isDayNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getDay());
		}
	}

	public String getInsertFields()
	{
		return "TIME_SLOT_ID,START_TIME,END_TIME,DAY";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		ClassTimeSlot newObject = new ClassTimeSlot();
		newObject.zSetFromClassTimeSlotData((ClassTimeSlotData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.TIME_SLOT_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*4);
		result.append(databaseAlias);
		result.append(".");
		result.append("TIME_SLOT_ID");
		return result.toString();
	}
}
