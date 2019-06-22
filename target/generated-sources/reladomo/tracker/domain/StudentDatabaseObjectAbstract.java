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
public abstract class StudentDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "MAJOR_ID,GPA,ADMISSION_DATE,EXPECTED_GRADUATION,PERSON_ID,COURSE_ID";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.MAJOR_ID,t0.GPA,t0.ADMISSION_DATE,t0.EXPECTED_GRADUATION,t0.PERSON_ID,t0.COURSE_ID";
	private static final String PK_WITH_ALIAS = "t0.STUDENT_ID = ?";
	private static final String PK_INDEX_COLS = "STUDENT_ID";
	protected StudentDatabaseObjectAbstract()
	{
		super("Student", "tracker.domain.StudentFinder",
			7, 7,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return StudentFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return StudentFinder.getFinderInstance();
	}

	public static StudentData allocateOnHeapData()
	{
		return new StudentData();
	}

	public static StudentData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new StudentData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		StudentData data = new StudentData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(StudentFinder.getPrimaryKeyAttributes(), this, StudentFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(StudentFinder.getPrimaryKeyAttributes(), this, StudentFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(StudentFinder.getPrimaryKeyAttributes(), this, StudentFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(StudentFinder.getPrimaryKeyAttributes(), this, StudentFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			StudentFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			StudentFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			Student.zConfigFullTx();
		}
		else
		{
			Student.zConfigNonTx();
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
		return inflateStudentData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkStudentData(1, (StudentData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateStudentPkData(rs, dt);
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
		return getStudentTableName();
	}

	public String getStudentTableName() throws MithraDatabaseException
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
		StudentData data = (StudentData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getStudentId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "STUDENT_ID = ?";
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
			return "t0.STUDENT_ID,t0.MAJOR_ID,t0.GPA,t0.ADMISSION_DATE,t0.EXPECTED_GRADUATION,t0.PERSON_ID,t0.COURSE_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*7);
		result.append(databaseAlias).append(".").append("STUDENT_ID");
		result.append(",").append(databaseAlias).append(".").append("MAJOR_ID");
		result.append(",").append(databaseAlias).append(".").append("GPA");
		result.append(",").append(databaseAlias).append(".").append("ADMISSION_DATE");
		result.append(",").append(databaseAlias).append(".").append("EXPECTED_GRADUATION");
		result.append(",").append(databaseAlias).append(".").append("PERSON_ID");
		result.append(",").append(databaseAlias).append(".").append("COURSE_ID");
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

	public StudentData inflateStudentData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		StudentData data = inflateStudentPkData(rs, dt);
		inflateNonPkStudentData(2, data, rs, dt);
		return data;
	}

	public StudentData inflateStudentPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		StudentData _data = new StudentData();
		int _pos = 1;
		_data.setStudentId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "studentId");
		return _data;
	}

	public void inflateNonPkStudentData(int _pos, StudentData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			StudentData _data = _datax;
			_data.setMajorId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setMajorIdNull();
			}

			_data.setGpa(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setGpaNull();
			}

			_data.setAdmissionDate(_rs.getDate(_pos++));
			_data.setExpectedGraduation(_rs.getDate(_pos++));
			_data.setPersonId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setPersonIdNull();
			}

			_data.setCourseId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setCourseIdNull();
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
		return "STUDENTS";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		StudentData data = (StudentData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getStudentId());
		if (data.isMajorIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getMajorId());
		}

		if (data.isGpaNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getGpa());
		}

		if (data.isAdmissionDateNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getAdmissionDate());
		}

		if (data.isExpectedGraduationNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getExpectedGraduation());
		}

		if (data.isPersonIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getPersonId());
		}

		if (data.isCourseIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getCourseId());
		}
	}

	public String getInsertFields()
	{
		return "STUDENT_ID,MAJOR_ID,GPA,ADMISSION_DATE,EXPECTED_GRADUATION,PERSON_ID,COURSE_ID";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		Student newObject = new Student();
		newObject.zSetFromStudentData((StudentData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.STUDENT_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*7);
		result.append(databaseAlias);
		result.append(".");
		result.append("STUDENT_ID");
		return result.toString();
	}
}
