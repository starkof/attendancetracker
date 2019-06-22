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
public class DepartmentFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/Department";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.Department";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.Department");
	private static final DepartmentSingleFinder<Department, Object, Department> finder = new DepartmentSingleFinder<Department, Object, Department>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(DepartmentFinder.DepartmentRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("departmentId");
		finderMethodMap.addNormalAttributeName("departmentName");
		finderMethodMap.addNormalAttributeName("courseId");
		finderMethodMap.addNormalAttributeName("majorId");
		finderMethodMap.addRelationshipName("courses");
		finderMethodMap.addRelationshipName("major");
		finderMethodMap.addRelationshipName("faculty");
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

	public static Mapper zGetConstantJoin(int index)
	{
		return getConstantJoinPool()[index];
	}

	private static Mapper[] constantJoinPool;
	private static Mapper[] getConstantJoinPool()
	{
		if (constantJoinPool == null)
		{
			Mapper[] result = new Mapper[4];
			result[0] = DepartmentFinder.courseId().constructEqualityMapper(CourseFinder.courseId());
			result[1] = CourseFinder.courseId().constructEqualityMapper(DepartmentFinder.courseId());
			result[2] = DepartmentFinder.majorId().constructEqualityMapper(MajorFinder.majorId());
			result[3] = MajorFinder.majorId().constructEqualityMapper(DepartmentFinder.majorId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Department findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Department findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static DepartmentList findMany(com.gs.fw.finder.Operation operation)
	{
		return (DepartmentList) finder.findMany(operation);
	}

	public static DepartmentList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (DepartmentList) finder.findManyBypassCache(operation);
	}

	private static Department findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Department) FinderUtils.findOne(found);
	}

	public static Department findByPrimaryKey(int departmentId)
	{
		return finder.findByPrimaryKey(departmentId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			DepartmentData _castedTargetData = (DepartmentData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getDepartmentId())
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

	public static Department zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Department) FinderUtils.findOne(found);
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

	public static class DepartmentRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Department, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> departmentId;
		private StringAttribute<ParentOwnerType> departmentName;
		private IntegerAttribute<ParentOwnerType> courseId;
		private IntegerAttribute<ParentOwnerType> majorId;
		private DepartmentCoursesFinderSubclass<ParentOwnerType> courses;
		private DepartmentMajorFinderSubclass<ParentOwnerType> major;
		private DepartmentFacultyFinderSubclass<ParentOwnerType> faculty;
		public DepartmentRelatedFinder()
		{
			super();
		}

		public DepartmentRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.DepartmentFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return DepartmentFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return DepartmentFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return DepartmentFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[4];
			attributes[0] = this.departmentId();
			attributes[1] = this.departmentName();
			attributes[2] = this.courseId();
			attributes[3] = this.majorId();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(3);
				relatedFinders.add(this.courses());
				relatedFinders.add(this.major());
				relatedFinders.add(this.faculty());
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

		public Department findOne(com.gs.fw.finder.Operation operation)
		{
			return DepartmentFinder.findOne(operation, false);
		}

		public Department findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return DepartmentFinder.findOne(operation, true);
		}

		public MithraList<? extends Department> findMany(com.gs.fw.finder.Operation operation)
		{
			return new DepartmentList((Operation) operation);
		}

		public MithraList<? extends Department> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			DepartmentList result = (DepartmentList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Department> constructEmptyList()
		{
			return new DepartmentList();
		}

		public int getSerialVersionId()
		{
			return -37166143;
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

		public IntegerAttribute<ParentOwnerType> departmentId()
		{
			IntegerAttribute<ParentOwnerType> result = this.departmentId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("DEPARTMENT_ID","","departmentId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(DepartmentFinder.departmentId(), this.mapper, this.zGetValueSelector());
				this.departmentId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> departmentName()
		{
			StringAttribute<ParentOwnerType> result = this.departmentName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("DEPARTMENT_NAME","","departmentName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(DepartmentFinder.departmentName(), this.mapper, this.zGetValueSelector());
				this.departmentName = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> courseId()
		{
			IntegerAttribute<ParentOwnerType> result = this.courseId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("COURSE_ID","","courseId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(DepartmentFinder.courseId(), this.mapper, this.zGetValueSelector());
				this.courseId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> majorId()
		{
			IntegerAttribute<ParentOwnerType> result = this.majorId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("MAJOR_ID","","majorId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(DepartmentFinder.majorId(), this.mapper, this.zGetValueSelector());
				this.majorId = result;
			}

			return result;
		}

		public CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Department> courses()
		{
			DepartmentCoursesFinderSubclass<ParentOwnerType> result = this.courses;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(DepartmentFinder.zGetDepartmentCoursesReverseMapper());
				newMapper.setToMany(true);
				result = new DepartmentCoursesFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.courses = result;
			}

			return result;
		}

		public MajorFinder.MajorCollectionFinderForRelatedClasses<ParentOwnerType, MajorList, Department> major()
		{
			DepartmentMajorFinderSubclass<ParentOwnerType> result = this.major;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(DepartmentFinder.zGetDepartmentMajorReverseMapper());
				newMapper.setToMany(true);
				result = new DepartmentMajorFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.major = result;
			}

			return result;
		}

		public FacultyFinder.FacultyCollectionFinderForRelatedClasses<ParentOwnerType, FacultyList, Department> faculty()
		{
			DepartmentFacultyFinderSubclass<ParentOwnerType> result = this.faculty;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyDepartmentMapper());
				newMapper.setToMany(true);
				result = new DepartmentFacultyFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.faculty = result;
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
			return DepartmentFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return DepartmentFinder.getMithraObjectPortal();
		}
	}

	public static class DepartmentCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends DepartmentRelatedFinder<ParentOwnerType, ReturnType, DepartmentList, OwnerType>
	{
		public DepartmentCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class DepartmentCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends DepartmentCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public DepartmentCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class DepartmentSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends DepartmentRelatedFinder<ParentOwnerType, ReturnType, DepartmentList, OwnerType>
	implements ToOneFinder
	{
		public DepartmentSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public DepartmentSingleFinder()
		{
			super(null);
		}

		public Operation eq(Department other)
		{
			return this.departmentId().eq(other.getDepartmentId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Department findByPrimaryKey(int departmentId)
		{
			Department _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(departmentId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Department) _related;
			if (_related == null)
			{
				_op = this.departmentId().eq(departmentId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class DepartmentSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends DepartmentSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public DepartmentSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper coursesReverseMapper = null;
	public static Mapper zGetDepartmentCoursesReverseMapper()
	{
		if (coursesReverseMapper == null)
		{
			coursesReverseMapper = zConstructDepartmentCoursesReverseMapper();
		}

		return coursesReverseMapper;
	}

	private static Mapper coursesMapper = null;
	public static Mapper zGetDepartmentCoursesMapper()
	{
		if (coursesMapper == null)
		{
			coursesMapper = zConstructDepartmentCoursesMapper();
		}

		return coursesMapper;
	}

	private static Mapper coursesPureReverseMapper = null;
	public static Mapper zGetDepartmentCoursesPureReverseMapper()
	{
		if (coursesPureReverseMapper == null)
		{
			coursesPureReverseMapper = zConstructDepartmentCoursesPureReverseMapper();
		}

		return coursesPureReverseMapper;
	}

	private static Mapper zConstructDepartmentCoursesPureReverseMapper()
	{
		Mapper coursesMapper = DepartmentFinder.zGetConstantJoin(0);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructDepartmentCoursesReverseMapper()
	{
		Mapper coursesMapper = DepartmentFinder.zGetConstantJoin(0);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructDepartmentCoursesMapper()
	{
		Mapper coursesMapper = DepartmentFinder.zGetConstantJoin(1);
		coursesMapper.setName("department");
		return coursesMapper;
	}

	private static Mapper majorReverseMapper = null;
	public static Mapper zGetDepartmentMajorReverseMapper()
	{
		if (majorReverseMapper == null)
		{
			majorReverseMapper = zConstructDepartmentMajorReverseMapper();
		}

		return majorReverseMapper;
	}

	private static Mapper majorMapper = null;
	public static Mapper zGetDepartmentMajorMapper()
	{
		if (majorMapper == null)
		{
			majorMapper = zConstructDepartmentMajorMapper();
		}

		return majorMapper;
	}

	private static Mapper majorPureReverseMapper = null;
	public static Mapper zGetDepartmentMajorPureReverseMapper()
	{
		if (majorPureReverseMapper == null)
		{
			majorPureReverseMapper = zConstructDepartmentMajorPureReverseMapper();
		}

		return majorPureReverseMapper;
	}

	private static Mapper zConstructDepartmentMajorPureReverseMapper()
	{
		Mapper majorMapper = DepartmentFinder.zGetConstantJoin(2);
		majorMapper.setName("major");
		return majorMapper;
	}

	private static Mapper zConstructDepartmentMajorReverseMapper()
	{
		Mapper majorMapper = DepartmentFinder.zGetConstantJoin(2);
		majorMapper.setName("major");
		return majorMapper;
	}

	private static Mapper zConstructDepartmentMajorMapper()
	{
		Mapper majorMapper = DepartmentFinder.zGetConstantJoin(3);
		majorMapper.setName("department");
		return majorMapper;
	}

	/** maps to DEPARTMENTS.DEPARTMENT_ID **/
	public static IntegerAttribute<Department> departmentId()
	{
		return finder.departmentId();
	}

	/** maps to DEPARTMENTS.DEPARTMENT_NAME **/
	public static StringAttribute<Department> departmentName()
	{
		return finder.departmentName();
	}

	/** maps to DEPARTMENTS.COURSE_ID **/
	public static IntegerAttribute<Department> courseId()
	{
		return finder.courseId();
	}

	/** maps to DEPARTMENTS.MAJOR_ID **/
	public static IntegerAttribute<Department> majorId()
	{
		return finder.majorId();
	}

	public static CourseFinder.CourseCollectionFinderForRelatedClasses<Department, CourseList, Department> courses()
	{
		return finder.courses();
	}

	public static class DepartmentCoursesFinderSubclass<ParentOwnerType> extends CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Department>
	{
		public DepartmentCoursesFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "courses";
		}

		public DeepRelationshipAttribute copy()
		{
			return new DepartmentCoursesFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected CourseList plainValueOf(Department _obj)
		{
			return _obj.getCourses();
		}

		protected CourseList plainListValueOf(Object _obj)
		{
			return ((DepartmentList)_obj).getCourses();
		}
	}

	public static MajorFinder.MajorCollectionFinderForRelatedClasses<Department, MajorList, Department> major()
	{
		return finder.major();
	}

	public static class DepartmentMajorFinderSubclass<ParentOwnerType> extends MajorFinder.MajorCollectionFinderForRelatedClasses<ParentOwnerType, MajorList, Department>
	{
		public DepartmentMajorFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "major";
		}

		public DeepRelationshipAttribute copy()
		{
			return new DepartmentMajorFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected MajorList plainValueOf(Department _obj)
		{
			return _obj.getMajor();
		}

		protected MajorList plainListValueOf(Object _obj)
		{
			return ((DepartmentList)_obj).getMajor();
		}
	}

	public static FacultyFinder.FacultyCollectionFinderForRelatedClasses<Department, FacultyList, Department> faculty()
	{
		return finder.faculty();
	}

	public static class DepartmentFacultyFinderSubclass<ParentOwnerType> extends FacultyFinder.FacultyCollectionFinderForRelatedClasses<ParentOwnerType, FacultyList, Department>
	{
		public DepartmentFacultyFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "faculty";
		}

		public DeepRelationshipAttribute copy()
		{
			return new DepartmentFacultyFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected FacultyList plainValueOf(Department _obj)
		{
			return _obj.getFaculty();
		}

		protected FacultyList plainListValueOf(Object _obj)
		{
			return ((DepartmentList)_obj).getFaculty();
		}
	}

	public static Operation eq(Department other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(departmentId());
	}

	public static DepartmentSingleFinder<Department, Object, Department> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			departmentId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			departmentId()
			, departmentId()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return null;
	}

	protected static void initializeIndicies(Cache cache)
	{
		cache.addIndex("0 Index", new Attribute[] 
		{
			courseId()
		}

		);
		cache.addIndex("1 Index", new Attribute[] 
		{
			majorId()
		}

		);
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
		objectPortal = new UninitializedPortal("tracker.domain.Department");
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
