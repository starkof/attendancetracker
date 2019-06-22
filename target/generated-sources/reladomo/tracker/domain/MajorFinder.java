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
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.attribute.calculator.procedure.ObjectProcedure;
import com.gs.fw.common.mithra.behavior.txparticipation.*;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.cache.bean.*;
import com.gs.fw.common.mithra.extractor.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.booleanop.*;
import com.gs.fw.common.mithra.finder.integer.*;
import com.gs.fw.common.mithra.finder.longop.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.string.*;
import com.gs.fw.common.mithra.extractor.NormalAndListValueSelector;
import com.gs.fw.common.mithra.list.NulledRelation;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.querycache.QueryCache;
import com.gs.fw.common.mithra.portal.*;
import com.gs.fw.common.mithra.remote.*;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import com.gs.fw.common.mithra.util.TimestampPool;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import java.io.Serializable;
/**
* This file was automatically generated using Mithra 17.0.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class MajorFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/Major";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.Major";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.Major");
	private static final MajorSingleFinder<Major, Object, Major> finder = new MajorSingleFinder<Major, Object, Major>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(MajorFinder.MajorRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("majorId");
		finderMethodMap.addNormalAttributeName("majorName");
		finderMethodMap.addRelationshipName("department");
		finderMethodMap.addRelationshipName("students");
	}

	public static Attribute[] allPersistentAttributes()
	{
		return finder.getPersistentAttributes();
	}

	public static List<RelatedFinder> allRelatedFinders()
	{
		return finder.getRelationshipFinders();
	}

	public static List<RelatedFinder> allDependentRelatedFinders()
	{
		return finder.getDependentRelationshipFinders();
	}

	public static ConstantStringSet zGetConstantStringSet(int index)
	{
		return constantStringSets[index];
	}

	public static ConstantIntSet zGetConstantIntSet(int index)
	{
		return constantIntSets[index];
	}

	public static ConstantShortSet zGetConstantShortSet(int index)
	{
		return constantShortSets[index];
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Major findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Major findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static MajorList findMany(com.gs.fw.finder.Operation operation)
	{
		return (MajorList) finder.findMany(operation);
	}

	public static MajorList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (MajorList) finder.findManyBypassCache(operation);
	}

	private static Major findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Major) FinderUtils.findOne(found);
	}

	public static Major findByPrimaryKey(int majorId)
	{
		return finder.findByPrimaryKey(majorId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			MajorData _castedTargetData = (MajorData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getMajorId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}
	}

	public static Major zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Major) FinderUtils.findOne(found);
	}

	public static MithraObjectPortal getMithraObjectPortal()
	{
		return objectPortal.getInitializedPortal();
	}

	public static void clearQueryCache()
	{
		objectPortal.clearQueryCache();
	}

	public static void reloadCache()
	{
		objectPortal.reloadCache();
	}

	public static class MajorRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Major, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> majorId;
		private StringAttribute<ParentOwnerType> majorName;
		private MajorDepartmentFinderSubclass<ParentOwnerType> department;
		private MajorStudentsFinderSubclass<ParentOwnerType> students;
		public MajorRelatedFinder()
		{
			super();
		}

		public MajorRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.MajorFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return MajorFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return MajorFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return MajorFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[2];
			attributes[0] = this.majorId();
			attributes[1] = this.majorName();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(2);
				relatedFinders.add(this.department());
				relatedFinders.add(this.students());
				relationshipFinders = Collections.unmodifiableList(relatedFinders);
			}

			return relationshipFinders;
		}

		public List<RelatedFinder> getDependentRelationshipFinders()
		{
			if (dependentRelationshipFinders == null)
			{
				List<RelatedFinder> dependentRelatedFinders = new ArrayList<RelatedFinder>(0);
				dependentRelationshipFinders = Collections.unmodifiableList(dependentRelatedFinders);
			}

			return dependentRelationshipFinders;
		}

		public Major findOne(com.gs.fw.finder.Operation operation)
		{
			return MajorFinder.findOne(operation, false);
		}

		public Major findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return MajorFinder.findOne(operation, true);
		}

		public MithraList<? extends Major> findMany(com.gs.fw.finder.Operation operation)
		{
			return new MajorList((Operation) operation);
		}

		public MithraList<? extends Major> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			MajorList result = (MajorList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Major> constructEmptyList()
		{
			return new MajorList();
		}

		public int getSerialVersionId()
		{
			return -1174468344;
		}

		public boolean isPure()
		{
			return false;
		}

		public boolean isTemporary()
		{
			return false;
		}

		public int getHierarchyDepth()
		{
			return 0;
		}

		public IntegerAttribute<ParentOwnerType> majorId()
		{
			IntegerAttribute<ParentOwnerType> result = this.majorId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("'MAJOR_ID","","majorId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(MajorFinder.majorId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("department");
				result.zSetOwningReverseRelationship("tracker.domain", "Department", "major");
				this.majorId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> majorName()
		{
			StringAttribute<ParentOwnerType> result = this.majorName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("MAJOR_NAME","","majorName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(MajorFinder.majorName(), this.mapper, this.zGetValueSelector());
				this.majorName = result;
			}

			return result;
		}

		public DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Major> department()
		{
			MajorDepartmentFinderSubclass<ParentOwnerType> result = this.department;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(DepartmentFinder.zGetDepartmentMajorMapper());
				newMapper.setToMany(false);
				result = new MajorDepartmentFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.department = result;
			}

			return result;
		}

		public StudentFinder.StudentCollectionFinderForRelatedClasses<ParentOwnerType, StudentList, Major> students()
		{
			MajorStudentsFinderSubclass<ParentOwnerType> result = this.students;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentMajorMapper());
				newMapper.setToMany(true);
				result = new MajorStudentsFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.students = result;
			}

			return result;
		}

		public Attribute getSourceAttribute()
		{
			return null;
		}

		private Mapper combineWithMapperIfExists(Mapper newMapper)
		{
			if (this.mapper != null)
			{
				return new LinkedMapper(this.mapper, newMapper);
			}

			return newMapper;
		}

		public Attribute[] getPrimaryKeyAttributes()
		{
			return MajorFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return MajorFinder.getMithraObjectPortal();
		}
	}

	public static class MajorCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends MajorRelatedFinder<ParentOwnerType, ReturnType, MajorList, OwnerType>
	{
		public MajorCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class MajorCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends MajorCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public MajorCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class MajorSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends MajorRelatedFinder<ParentOwnerType, ReturnType, MajorList, OwnerType>
	implements ToOneFinder
	{
		public MajorSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public MajorSingleFinder()
		{
			super(null);
		}

		public Operation eq(Major other)
		{
			return this.majorId().eq(other.getMajorId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Major findByPrimaryKey(int majorId)
		{
			Major _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(majorId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Major) _related;
			if (_related == null)
			{
				_op = this.majorId().eq(majorId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class MajorSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends MajorSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public MajorSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to MAJORS.'MAJOR_ID **/
	public static IntegerAttribute<Major> majorId()
	{
		return finder.majorId();
	}

	/** maps to MAJORS.MAJOR_NAME **/
	public static StringAttribute<Major> majorName()
	{
		return finder.majorName();
	}

	public static DepartmentFinder.DepartmentSingleFinderForRelatedClasses<Major, Department, Major> department()
	{
		return finder.department();
	}

	public static class MajorDepartmentFinderSubclass<ParentOwnerType> extends DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Major>
	{
		public MajorDepartmentFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "department";
		}

		public DeepRelationshipAttribute copy()
		{
			return new MajorDepartmentFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Department plainValueOf(Major _obj)
		{
			return _obj.getDepartment();
		}

		protected DepartmentList plainListValueOf(Object _obj)
		{
			return ((MajorList)_obj).getDepartments();
		}
	}

	public static StudentFinder.StudentCollectionFinderForRelatedClasses<Major, StudentList, Major> students()
	{
		return finder.students();
	}

	public static class MajorStudentsFinderSubclass<ParentOwnerType> extends StudentFinder.StudentCollectionFinderForRelatedClasses<ParentOwnerType, StudentList, Major>
	{
		public MajorStudentsFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "students";
		}

		public DeepRelationshipAttribute copy()
		{
			return new MajorStudentsFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected StudentList plainValueOf(Major _obj)
		{
			return _obj.getStudents();
		}

		protected StudentList plainListValueOf(Object _obj)
		{
			return ((MajorList)_obj).getStudents();
		}
	}

	public static Operation eq(Major other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(majorId());
	}

	public static MajorSingleFinder<Major, Object, Major> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			majorId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			majorId()
			, majorId()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return null;
	}

	protected static void initializeIndicies(Cache cache)
	{
	}

	protected static void initializePortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}

		portal.setParentFinders(new RelatedFinder[] 
		{
			DepartmentFinder.getFinderInstance(),
		}

		);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	protected static void initializeClientPortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
		}

		portal.setParentFinders(new RelatedFinder[] 
		{
			DepartmentFinder.getFinderInstance(),
		}

		);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	public static boolean isFullCache()
	{
		return isFullCache;
	}

	public static boolean isOffHeap()
	{
		return isOffHeap;
	}

	public static Attribute getAttributeByName(String attributeName)
	{
		return finder.getAttributeByName(attributeName);
	}

	public static com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
	{
		return finder.getAttributeOrRelationshipSelector(attributeName);
	}

	public static RelatedFinder getRelatedFinderByName(String relationshipName)
	{
		return finder.getRelationshipFinderByName(relationshipName);
	}

	public static DoubleAttribute[] zGetDoubleAttributes()
	{
		DoubleAttribute[] result = new DoubleAttribute[0];
		return result;
	}

	public static BigDecimalAttribute[] zGetBigDecimalAttributes()
	{
		BigDecimalAttribute[] result = new BigDecimalAttribute[0];
		return result;
	}

	public static void zResetPortal()
	{
		objectPortal.destroy();
		objectPortal = new UninitializedPortal("tracker.domain.Major");
		isFullCache = false;
		isOffHeap = false;
	}

	public static void setTransactionModeFullTransactionParticipation(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, FullTransactionalParticipationMode.getInstance());
	}

	public static void setTransactionModeReadCacheUpdateCausesRefreshAndLock(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, ReadCacheUpdateCausesRefreshAndLockTxParticipationMode.getInstance());
	}

	public static void registerForNotification(MithraApplicationClassLevelNotificationListener listener)
	{
		getMithraObjectPortal().registerForApplicationClassLevelNotification(listener);
	}
}
