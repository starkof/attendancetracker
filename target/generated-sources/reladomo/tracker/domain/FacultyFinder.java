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
public class FacultyFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/Faculty";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.Faculty";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.Faculty");
	private static final FacultySingleFinder<Faculty, Object, Faculty> finder = new FacultySingleFinder<Faculty, Object, Faculty>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(FacultyFinder.FacultyRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("facultyId");
		finderMethodMap.addNormalAttributeName("departmentId");
		finderMethodMap.addNormalAttributeName("courseId");
		finderMethodMap.addNormalAttributeName("personId");
		finderMethodMap.addRelationshipName("department");
		finderMethodMap.addRelationshipName("courses");
		finderMethodMap.addRelationshipName("person");
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
			Mapper[] result = new Mapper[6];
			result[0] = FacultyFinder.departmentId().constructEqualityMapper(DepartmentFinder.departmentId());
			result[1] = DepartmentFinder.departmentId().constructEqualityMapper(FacultyFinder.departmentId());
			result[2] = FacultyFinder.courseId().constructEqualityMapper(CourseFinder.courseId());
			result[3] = CourseFinder.courseId().constructEqualityMapper(FacultyFinder.courseId());
			result[4] = FacultyFinder.personId().constructEqualityMapper(PersonFinder.personId());
			result[5] = PersonFinder.personId().constructEqualityMapper(FacultyFinder.personId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Faculty findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Faculty findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static FacultyList findMany(com.gs.fw.finder.Operation operation)
	{
		return (FacultyList) finder.findMany(operation);
	}

	public static FacultyList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (FacultyList) finder.findManyBypassCache(operation);
	}

	private static Faculty findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Faculty) FinderUtils.findOne(found);
	}

	public static Faculty findByPrimaryKey(int facultyId)
	{
		return finder.findByPrimaryKey(facultyId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			FacultyData _castedTargetData = (FacultyData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getFacultyId())
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

	public static Faculty zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Faculty) FinderUtils.findOne(found);
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

	public static class FacultyRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Faculty, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> facultyId;
		private IntegerAttribute<ParentOwnerType> departmentId;
		private IntegerAttribute<ParentOwnerType> courseId;
		private IntegerAttribute<ParentOwnerType> personId;
		private FacultyDepartmentFinderSubclass<ParentOwnerType> department;
		private FacultyCoursesFinderSubclass<ParentOwnerType> courses;
		private FacultyPersonFinderSubclass<ParentOwnerType> person;
		public FacultyRelatedFinder()
		{
			super();
		}

		public FacultyRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.FacultyFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return FacultyFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return FacultyFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return FacultyFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[4];
			attributes[0] = this.facultyId();
			attributes[1] = this.departmentId();
			attributes[2] = this.courseId();
			attributes[3] = this.personId();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(3);
				relatedFinders.add(this.department());
				relatedFinders.add(this.courses());
				relatedFinders.add(this.person());
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

		public Faculty findOne(com.gs.fw.finder.Operation operation)
		{
			return FacultyFinder.findOne(operation, false);
		}

		public Faculty findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return FacultyFinder.findOne(operation, true);
		}

		public MithraList<? extends Faculty> findMany(com.gs.fw.finder.Operation operation)
		{
			return new FacultyList((Operation) operation);
		}

		public MithraList<? extends Faculty> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			FacultyList result = (FacultyList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Faculty> constructEmptyList()
		{
			return new FacultyList();
		}

		public int getSerialVersionId()
		{
			return 2106174207;
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

		public IntegerAttribute<ParentOwnerType> facultyId()
		{
			IntegerAttribute<ParentOwnerType> result = this.facultyId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("FACULTY_ID","","facultyId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(FacultyFinder.facultyId(), this.mapper, this.zGetValueSelector());
				this.facultyId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> departmentId()
		{
			IntegerAttribute<ParentOwnerType> result = this.departmentId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("DEPARTMENT_ID","","departmentId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(FacultyFinder.departmentId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("department");
				result.zSetOwningReverseRelationship("tracker.domain", "Department", "faculty");
				this.departmentId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> courseId()
		{
			IntegerAttribute<ParentOwnerType> result = this.courseId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("COURSE_ID","","courseId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(FacultyFinder.courseId(), this.mapper, this.zGetValueSelector());
				this.courseId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> personId()
		{
			IntegerAttribute<ParentOwnerType> result = this.personId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("PERSON_ID","","personId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(FacultyFinder.personId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("person");
				result.zSetOwningReverseRelationship("tracker.domain", "Person", "faculty");
				this.personId = result;
			}

			return result;
		}

		public DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Faculty> department()
		{
			FacultyDepartmentFinderSubclass<ParentOwnerType> result = this.department;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyDepartmentReverseMapper());
				newMapper.setToMany(false);
				result = new FacultyDepartmentFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.department = result;
			}

			return result;
		}

		public CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Faculty> courses()
		{
			FacultyCoursesFinderSubclass<ParentOwnerType> result = this.courses;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyCoursesReverseMapper());
				newMapper.setToMany(true);
				result = new FacultyCoursesFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.courses = result;
			}

			return result;
		}

		public PersonFinder.PersonSingleFinderForRelatedClasses<ParentOwnerType, Person, Faculty> person()
		{
			FacultyPersonFinderSubclass<ParentOwnerType> result = this.person;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyPersonReverseMapper());
				newMapper.setToMany(false);
				result = new FacultyPersonFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.person = result;
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
			return FacultyFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return FacultyFinder.getMithraObjectPortal();
		}
	}

	public static class FacultyCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends FacultyRelatedFinder<ParentOwnerType, ReturnType, FacultyList, OwnerType>
	{
		public FacultyCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class FacultyCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends FacultyCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public FacultyCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class FacultySingleFinder<ParentOwnerType, ReturnType, OwnerType> extends FacultyRelatedFinder<ParentOwnerType, ReturnType, FacultyList, OwnerType>
	implements ToOneFinder
	{
		public FacultySingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public FacultySingleFinder()
		{
			super(null);
		}

		public Operation eq(Faculty other)
		{
			return this.facultyId().eq(other.getFacultyId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Faculty findByPrimaryKey(int facultyId)
		{
			Faculty _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(facultyId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Faculty) _related;
			if (_related == null)
			{
				_op = this.facultyId().eq(facultyId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class FacultySingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends FacultySingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public FacultySingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper departmentReverseMapper = null;
	public static Mapper zGetFacultyDepartmentReverseMapper()
	{
		if (departmentReverseMapper == null)
		{
			departmentReverseMapper = zConstructFacultyDepartmentReverseMapper();
		}

		return departmentReverseMapper;
	}

	private static Mapper departmentMapper = null;
	public static Mapper zGetFacultyDepartmentMapper()
	{
		if (departmentMapper == null)
		{
			departmentMapper = zConstructFacultyDepartmentMapper();
		}

		return departmentMapper;
	}

	private static Mapper departmentPureReverseMapper = null;
	public static Mapper zGetFacultyDepartmentPureReverseMapper()
	{
		if (departmentPureReverseMapper == null)
		{
			departmentPureReverseMapper = zConstructFacultyDepartmentPureReverseMapper();
		}

		return departmentPureReverseMapper;
	}

	private static Mapper zConstructFacultyDepartmentPureReverseMapper()
	{
		Mapper departmentMapper = FacultyFinder.zGetConstantJoin(0);
		departmentMapper.setName("department");
		return departmentMapper;
	}

	private static Mapper zConstructFacultyDepartmentReverseMapper()
	{
		Mapper departmentMapper = FacultyFinder.zGetConstantJoin(0);
		departmentMapper.setName("department");
		return departmentMapper;
	}

	private static Mapper zConstructFacultyDepartmentMapper()
	{
		Mapper departmentMapper = FacultyFinder.zGetConstantJoin(1);
		departmentMapper.setName("faculty");
		return departmentMapper;
	}

	private static Mapper coursesReverseMapper = null;
	public static Mapper zGetFacultyCoursesReverseMapper()
	{
		if (coursesReverseMapper == null)
		{
			coursesReverseMapper = zConstructFacultyCoursesReverseMapper();
		}

		return coursesReverseMapper;
	}

	private static Mapper coursesMapper = null;
	public static Mapper zGetFacultyCoursesMapper()
	{
		if (coursesMapper == null)
		{
			coursesMapper = zConstructFacultyCoursesMapper();
		}

		return coursesMapper;
	}

	private static Mapper coursesPureReverseMapper = null;
	public static Mapper zGetFacultyCoursesPureReverseMapper()
	{
		if (coursesPureReverseMapper == null)
		{
			coursesPureReverseMapper = zConstructFacultyCoursesPureReverseMapper();
		}

		return coursesPureReverseMapper;
	}

	private static Mapper zConstructFacultyCoursesPureReverseMapper()
	{
		Mapper coursesMapper = FacultyFinder.zGetConstantJoin(2);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructFacultyCoursesReverseMapper()
	{
		Mapper coursesMapper = FacultyFinder.zGetConstantJoin(2);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructFacultyCoursesMapper()
	{
		Mapper coursesMapper = FacultyFinder.zGetConstantJoin(3);
		coursesMapper.setName("faculty");
		return coursesMapper;
	}

	private static Mapper personReverseMapper = null;
	public static Mapper zGetFacultyPersonReverseMapper()
	{
		if (personReverseMapper == null)
		{
			personReverseMapper = zConstructFacultyPersonReverseMapper();
		}

		return personReverseMapper;
	}

	private static Mapper personMapper = null;
	public static Mapper zGetFacultyPersonMapper()
	{
		if (personMapper == null)
		{
			personMapper = zConstructFacultyPersonMapper();
		}

		return personMapper;
	}

	private static Mapper personPureReverseMapper = null;
	public static Mapper zGetFacultyPersonPureReverseMapper()
	{
		if (personPureReverseMapper == null)
		{
			personPureReverseMapper = zConstructFacultyPersonPureReverseMapper();
		}

		return personPureReverseMapper;
	}

	private static Mapper zConstructFacultyPersonPureReverseMapper()
	{
		Mapper personMapper = FacultyFinder.zGetConstantJoin(4);
		personMapper.setName("person");
		return personMapper;
	}

	private static Mapper zConstructFacultyPersonReverseMapper()
	{
		Mapper personMapper = FacultyFinder.zGetConstantJoin(4);
		personMapper.setName("person");
		return personMapper;
	}

	private static Mapper zConstructFacultyPersonMapper()
	{
		Mapper personMapper = FacultyFinder.zGetConstantJoin(5);
		personMapper.setName("faculty");
		return personMapper;
	}

	/** maps to FACULTY.FACULTY_ID **/
	public static IntegerAttribute<Faculty> facultyId()
	{
		return finder.facultyId();
	}

	/** maps to FACULTY.DEPARTMENT_ID **/
	public static IntegerAttribute<Faculty> departmentId()
	{
		return finder.departmentId();
	}

	/** maps to FACULTY.COURSE_ID **/
	public static IntegerAttribute<Faculty> courseId()
	{
		return finder.courseId();
	}

	/** maps to FACULTY.PERSON_ID **/
	public static IntegerAttribute<Faculty> personId()
	{
		return finder.personId();
	}

	public static DepartmentFinder.DepartmentSingleFinderForRelatedClasses<Faculty, Department, Faculty> department()
	{
		return finder.department();
	}

	public static class FacultyDepartmentFinderSubclass<ParentOwnerType> extends DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Faculty>
	{
		public FacultyDepartmentFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "department";
		}

		public DeepRelationshipAttribute copy()
		{
			return new FacultyDepartmentFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Department plainValueOf(Faculty _obj)
		{
			return _obj.getDepartment();
		}

		protected DepartmentList plainListValueOf(Object _obj)
		{
			return ((FacultyList)_obj).getDepartments();
		}
	}

	public static CourseFinder.CourseCollectionFinderForRelatedClasses<Faculty, CourseList, Faculty> courses()
	{
		return finder.courses();
	}

	public static class FacultyCoursesFinderSubclass<ParentOwnerType> extends CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Faculty>
	{
		public FacultyCoursesFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "courses";
		}

		public DeepRelationshipAttribute copy()
		{
			return new FacultyCoursesFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected CourseList plainValueOf(Faculty _obj)
		{
			return _obj.getCourses();
		}

		protected CourseList plainListValueOf(Object _obj)
		{
			return ((FacultyList)_obj).getCourses();
		}
	}

	public static PersonFinder.PersonSingleFinderForRelatedClasses<Faculty, Person, Faculty> person()
	{
		return finder.person();
	}

	public static class FacultyPersonFinderSubclass<ParentOwnerType> extends PersonFinder.PersonSingleFinderForRelatedClasses<ParentOwnerType, Person, Faculty>
	{
		public FacultyPersonFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "person";
		}

		public DeepRelationshipAttribute copy()
		{
			return new FacultyPersonFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Person plainValueOf(Faculty _obj)
		{
			return _obj.getPerson();
		}

		protected PersonList plainListValueOf(Object _obj)
		{
			return ((FacultyList)_obj).getPersons();
		}
	}

	public static Operation eq(Faculty other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(facultyId());
	}

	public static FacultySingleFinder<Faculty, Object, Faculty> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			facultyId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			facultyId()
			, facultyId()
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
			departmentId()
		}

		);
		cache.addIndex("1 Index", new Attribute[] 
		{
			courseId()
		}

		);
		cache.addIndex("2 Index", new Attribute[] 
		{
			personId()
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
		objectPortal = new UninitializedPortal("tracker.domain.Faculty");
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
