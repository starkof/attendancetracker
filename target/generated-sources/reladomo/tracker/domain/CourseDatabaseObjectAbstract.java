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
public abstract class CourseDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "TIME_SLOT,SEMESTER,START_DATE,END_DATE,LECTURE_HALL_ID";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.TIME_SLOT,t0.SEMESTER,t0.START_DATE,t0.END_DATE,t0.LECTURE_HALL_ID";
	private static final String PK_WITH_ALIAS = "t0.COURSE_ID = ?";
	private static final String PK_INDEX_COLS = "COURSE_ID";
	protected CourseDatabaseObjectAbstract()
	{
		super("Course", "tracker.domain.CourseFinder",
			6, 6,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return CourseFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return CourseFinder.getFinderInstance();
	}

	public static CourseData allocateOnHeapData()
	{
		return new CourseData();
	}

	public static CourseData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new CourseData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		CourseData data = new CourseData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(CourseFinder.getPrimaryKeyAttributes(), this, CourseFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(CourseFinder.getPrimaryKeyAttributes(), this, CourseFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(CourseFinder.getPrimaryKeyAttributes(), this, CourseFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(CourseFinder.getPrimaryKeyAttributes(), this, CourseFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			CourseFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			CourseFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			Course.zConfigFullTx();
		}
		else
		{
			Course.zConfigNonTx();
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
		return inflateCourseData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkCourseData(1, (CourseData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateCoursePkData(rs, dt);
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
		return getCourseTableName();
	}

	public String getCourseTableName() throws MithraDatabaseException
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
		CourseData data = (CourseData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getCourseId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "COURSE_ID = ?";
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
			return "t0.COURSE_ID,t0.TIME_SLOT,t0.SEMESTER,t0.START_DATE,t0.END_DATE,t0.LECTURE_HALL_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*6);
		result.append(databaseAlias).append(".").append("COURSE_ID");
		result.append(",").append(databaseAlias).append(".").append("TIME_SLOT");
		result.append(",").append(databaseAlias).append(".").append("SEMESTER");
		result.append(",").append(databaseAlias).append(".").append("START_DATE");
		result.append(",").append(databaseAlias).append(".").append("END_DATE");
		result.append(",").append(databaseAlias).append(".").append("LECTURE_HALL_ID");
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

	public CourseData inflateCourseData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		CourseData data = inflateCoursePkData(rs, dt);
		inflateNonPkCourseData(2, data, rs, dt);
		return data;
	}

	public CourseData inflateCoursePkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		CourseData _data = new CourseData();
		int _pos = 1;
		_data.setCourseId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "courseId");
		return _data;
	}

	public void inflateNonPkCourseData(int _pos, CourseData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			CourseData _data = _datax;
			_data.setTimeSlotId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setTimeSlotIdNull();
			}

			_data.setSemester(trimString(_rs.getString(_pos++)));
			_data.setStartDate(_rs.getDate(_pos++));
			_data.setEndDate(_rs.getDate(_pos++));
			_data.setLectureHallId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setLectureHallIdNull();
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
		return "COURSES";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		CourseData data = (CourseData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getCourseId());
		if (data.isTimeSlotIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getTimeSlotId());
		}

		if (data.isSemesterNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getSemester());
		}

		if (data.isStartDateNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getStartDate());
		}

		if (data.isEndDateNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getEndDate());
		}

		if (data.isLectureHallIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getLectureHallId());
		}
	}

	public String getInsertFields()
	{
		return "COURSE_ID,TIME_SLOT,SEMESTER,START_DATE,END_DATE,LECTURE_HALL_ID";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		Course newObject = new Course();
		newObject.zSetFromCourseData((CourseData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.COURSE_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*6);
		result.append(databaseAlias);
		result.append(".");
		result.append("COURSE_ID");
		return result.toString();
	}
}
