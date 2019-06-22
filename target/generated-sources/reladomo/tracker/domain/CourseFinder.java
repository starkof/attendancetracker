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
public class CourseFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/Course";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.Course";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.Course");
	private static final CourseSingleFinder<Course, Object, Course> finder = new CourseSingleFinder<Course, Object, Course>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(CourseFinder.CourseRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("courseId");
		finderMethodMap.addNormalAttributeName("timeSlotId");
		finderMethodMap.addNormalAttributeName("semester");
		finderMethodMap.addNormalAttributeName("startDate");
		finderMethodMap.addNormalAttributeName("endDate");
		finderMethodMap.addNormalAttributeName("lectureHallId");
		finderMethodMap.addRelationshipName("time");
		finderMethodMap.addRelationshipName("lectureHall");
		finderMethodMap.addRelationshipName("department");
		finderMethodMap.addRelationshipName("faculty");
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
			result[0] = CourseFinder.timeSlotId().constructEqualityMapper(ClassTimeSlotFinder.timeSlotId());
			result[1] = ClassTimeSlotFinder.timeSlotId().constructEqualityMapper(CourseFinder.timeSlotId());
			result[2] = CourseFinder.lectureHallId().constructEqualityMapper(LectureHallFinder.lectureHallId());
			result[3] = LectureHallFinder.lectureHallId().constructEqualityMapper(CourseFinder.lectureHallId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Course findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Course findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static CourseList findMany(com.gs.fw.finder.Operation operation)
	{
		return (CourseList) finder.findMany(operation);
	}

	public static CourseList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (CourseList) finder.findManyBypassCache(operation);
	}

	private static Course findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Course) FinderUtils.findOne(found);
	}

	public static Course findByPrimaryKey(int courseId)
	{
		return finder.findByPrimaryKey(courseId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			CourseData _castedTargetData = (CourseData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getCourseId())
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

	public static Course zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Course) FinderUtils.findOne(found);
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

	public static class CourseRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Course, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> courseId;
		private IntegerAttribute<ParentOwnerType> timeSlotId;
		private StringAttribute<ParentOwnerType> semester;
		private DateAttribute<ParentOwnerType> startDate;
		private DateAttribute<ParentOwnerType> endDate;
		private IntegerAttribute<ParentOwnerType> lectureHallId;
		private CourseTimeFinderSubclass<ParentOwnerType> time;
		private CourseLectureHallFinderSubclass<ParentOwnerType> lectureHall;
		private CourseDepartmentFinderSubclass<ParentOwnerType> department;
		private CourseFacultyFinderSubclass<ParentOwnerType> faculty;
		private CourseStudentsFinderSubclass<ParentOwnerType> students;
		public CourseRelatedFinder()
		{
			super();
		}

		public CourseRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.CourseFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return CourseFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return CourseFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return CourseFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[6];
			attributes[0] = this.courseId();
			attributes[1] = this.timeSlotId();
			attributes[2] = this.semester();
			attributes[3] = this.startDate();
			attributes[4] = this.endDate();
			attributes[5] = this.lectureHallId();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(5);
				relatedFinders.add(this.time());
				relatedFinders.add(this.lectureHall());
				relatedFinders.add(this.department());
				relatedFinders.add(this.faculty());
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

		public Course findOne(com.gs.fw.finder.Operation operation)
		{
			return CourseFinder.findOne(operation, false);
		}

		public Course findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return CourseFinder.findOne(operation, true);
		}

		public MithraList<? extends Course> findMany(com.gs.fw.finder.Operation operation)
		{
			return new CourseList((Operation) operation);
		}

		public MithraList<? extends Course> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			CourseList result = (CourseList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Course> constructEmptyList()
		{
			return new CourseList();
		}

		public int getSerialVersionId()
		{
			return 503083112;
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

		public IntegerAttribute<ParentOwnerType> courseId()
		{
			IntegerAttribute<ParentOwnerType> result = this.courseId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("COURSE_ID","","courseId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CourseFinder.courseId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("department");
				result.zSetOwningReverseRelationship("tracker.domain", "Department", "courses");
				this.courseId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> timeSlotId()
		{
			IntegerAttribute<ParentOwnerType> result = this.timeSlotId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("TIME_SLOT","","timeSlotId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CourseFinder.timeSlotId(), this.mapper, this.zGetValueSelector());
				this.timeSlotId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> semester()
		{
			StringAttribute<ParentOwnerType> result = this.semester;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("SEMESTER","","semester",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(CourseFinder.semester(), this.mapper, this.zGetValueSelector());
				this.semester = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> startDate()
		{
			DateAttribute<ParentOwnerType> result = this.startDate;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("START_DATE","","startDate",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(CourseFinder.startDate(), this.mapper, this.zGetValueSelector());
				this.startDate = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> endDate()
		{
			DateAttribute<ParentOwnerType> result = this.endDate;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("END_DATE","","endDate",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(CourseFinder.endDate(), this.mapper, this.zGetValueSelector());
				this.endDate = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> lectureHallId()
		{
			IntegerAttribute<ParentOwnerType> result = this.lectureHallId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("LECTURE_HALL_ID","","lectureHallId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(CourseFinder.lectureHallId(), this.mapper, this.zGetValueSelector());
				this.lectureHallId = result;
			}

			return result;
		}

		public ClassTimeSlotFinder.ClassTimeSlotCollectionFinderForRelatedClasses<ParentOwnerType, ClassTimeSlotList, Course> time()
		{
			CourseTimeFinderSubclass<ParentOwnerType> result = this.time;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(CourseFinder.zGetCourseTimeReverseMapper());
				newMapper.setToMany(true);
				result = new CourseTimeFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.time = result;
			}

			return result;
		}

		public LectureHallFinder.LectureHallCollectionFinderForRelatedClasses<ParentOwnerType, LectureHallList, Course> lectureHall()
		{
			CourseLectureHallFinderSubclass<ParentOwnerType> result = this.lectureHall;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(CourseFinder.zGetCourseLectureHallReverseMapper());
				newMapper.setToMany(true);
				result = new CourseLectureHallFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.lectureHall = result;
			}

			return result;
		}

		public DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Course> department()
		{
			CourseDepartmentFinderSubclass<ParentOwnerType> result = this.department;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(DepartmentFinder.zGetDepartmentCoursesMapper());
				newMapper.setToMany(false);
				result = new CourseDepartmentFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.department = result;
			}

			return result;
		}

		public FacultyFinder.FacultyCollectionFinderForRelatedClasses<ParentOwnerType, FacultyList, Course> faculty()
		{
			CourseFacultyFinderSubclass<ParentOwnerType> result = this.faculty;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyCoursesMapper());
				newMapper.setToMany(true);
				result = new CourseFacultyFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.faculty = result;
			}

			return result;
		}

		public StudentFinder.StudentCollectionFinderForRelatedClasses<ParentOwnerType, StudentList, Course> students()
		{
			CourseStudentsFinderSubclass<ParentOwnerType> result = this.students;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentCoursesMapper());
				newMapper.setToMany(true);
				result = new CourseStudentsFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
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
			return CourseFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return CourseFinder.getMithraObjectPortal();
		}
	}

	public static class CourseCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends CourseRelatedFinder<ParentOwnerType, ReturnType, CourseList, OwnerType>
	{
		public CourseCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class CourseCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends CourseCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CourseCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class CourseSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends CourseRelatedFinder<ParentOwnerType, ReturnType, CourseList, OwnerType>
	implements ToOneFinder
	{
		public CourseSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public CourseSingleFinder()
		{
			super(null);
		}

		public Operation eq(Course other)
		{
			return this.courseId().eq(other.getCourseId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Course findByPrimaryKey(int courseId)
		{
			Course _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(courseId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Course) _related;
			if (_related == null)
			{
				_op = this.courseId().eq(courseId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class CourseSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends CourseSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public CourseSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper timeReverseMapper = null;
	public static Mapper zGetCourseTimeReverseMapper()
	{
		if (timeReverseMapper == null)
		{
			timeReverseMapper = zConstructCourseTimeReverseMapper();
		}

		return timeReverseMapper;
	}

	private static Mapper timeMapper = null;
	public static Mapper zGetCourseTimeMapper()
	{
		if (timeMapper == null)
		{
			timeMapper = zConstructCourseTimeMapper();
		}

		return timeMapper;
	}

	private static Mapper timePureReverseMapper = null;
	public static Mapper zGetCourseTimePureReverseMapper()
	{
		if (timePureReverseMapper == null)
		{
			timePureReverseMapper = zConstructCourseTimePureReverseMapper();
		}

		return timePureReverseMapper;
	}

	private static Mapper zConstructCourseTimePureReverseMapper()
	{
		Mapper timeMapper = CourseFinder.zGetConstantJoin(0);
		timeMapper.setName("time");
		return timeMapper;
	}

	private static Mapper zConstructCourseTimeReverseMapper()
	{
		Mapper timeMapper = CourseFinder.zGetConstantJoin(0);
		timeMapper.setName("time");
		return timeMapper;
	}

	private static Mapper zConstructCourseTimeMapper()
	{
		Mapper timeMapper = CourseFinder.zGetConstantJoin(1);
		timeMapper.setName("time_Reverse");
		return timeMapper;
	}

	private static Mapper lectureHallReverseMapper = null;
	public static Mapper zGetCourseLectureHallReverseMapper()
	{
		if (lectureHallReverseMapper == null)
		{
			lectureHallReverseMapper = zConstructCourseLectureHallReverseMapper();
		}

		return lectureHallReverseMapper;
	}

	private static Mapper lectureHallMapper = null;
	public static Mapper zGetCourseLectureHallMapper()
	{
		if (lectureHallMapper == null)
		{
			lectureHallMapper = zConstructCourseLectureHallMapper();
		}

		return lectureHallMapper;
	}

	private static Mapper lectureHallPureReverseMapper = null;
	public static Mapper zGetCourseLectureHallPureReverseMapper()
	{
		if (lectureHallPureReverseMapper == null)
		{
			lectureHallPureReverseMapper = zConstructCourseLectureHallPureReverseMapper();
		}

		return lectureHallPureReverseMapper;
	}

	private static Mapper zConstructCourseLectureHallPureReverseMapper()
	{
		Mapper lectureHallMapper = CourseFinder.zGetConstantJoin(2);
		lectureHallMapper.setName("lectureHall");
		return lectureHallMapper;
	}

	private static Mapper zConstructCourseLectureHallReverseMapper()
	{
		Mapper lectureHallMapper = CourseFinder.zGetConstantJoin(2);
		lectureHallMapper.setName("lectureHall");
		return lectureHallMapper;
	}

	private static Mapper zConstructCourseLectureHallMapper()
	{
		Mapper lectureHallMapper = CourseFinder.zGetConstantJoin(3);
		lectureHallMapper.setName("lectureHall_Reverse");
		return lectureHallMapper;
	}

	/** maps to COURSES.COURSE_ID **/
	public static IntegerAttribute<Course> courseId()
	{
		return finder.courseId();
	}

	/** maps to COURSES.TIME_SLOT **/
	public static IntegerAttribute<Course> timeSlotId()
	{
		return finder.timeSlotId();
	}

	/** maps to COURSES.SEMESTER **/
	public static StringAttribute<Course> semester()
	{
		return finder.semester();
	}

	/** maps to COURSES.START_DATE **/
	public static DateAttribute<Course> startDate()
	{
		return finder.startDate();
	}

	/** maps to COURSES.END_DATE **/
	public static DateAttribute<Course> endDate()
	{
		return finder.endDate();
	}

	/** maps to COURSES.LECTURE_HALL_ID **/
	public static IntegerAttribute<Course> lectureHallId()
	{
		return finder.lectureHallId();
	}

	public static ClassTimeSlotFinder.ClassTimeSlotCollectionFinderForRelatedClasses<Course, ClassTimeSlotList, Course> time()
	{
		return finder.time();
	}

	public static class CourseTimeFinderSubclass<ParentOwnerType> extends ClassTimeSlotFinder.ClassTimeSlotCollectionFinderForRelatedClasses<ParentOwnerType, ClassTimeSlotList, Course>
	{
		public CourseTimeFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "time";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CourseTimeFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected ClassTimeSlotList plainValueOf(Course _obj)
		{
			return _obj.getTime();
		}

		protected ClassTimeSlotList plainListValueOf(Object _obj)
		{
			return ((CourseList)_obj).getTime();
		}
	}

	public static LectureHallFinder.LectureHallCollectionFinderForRelatedClasses<Course, LectureHallList, Course> lectureHall()
	{
		return finder.lectureHall();
	}

	public static class CourseLectureHallFinderSubclass<ParentOwnerType> extends LectureHallFinder.LectureHallCollectionFinderForRelatedClasses<ParentOwnerType, LectureHallList, Course>
	{
		public CourseLectureHallFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "lectureHall";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CourseLectureHallFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected LectureHallList plainValueOf(Course _obj)
		{
			return _obj.getLectureHall();
		}

		protected LectureHallList plainListValueOf(Object _obj)
		{
			return ((CourseList)_obj).getLectureHall();
		}
	}

	public static DepartmentFinder.DepartmentSingleFinderForRelatedClasses<Course, Department, Course> department()
	{
		return finder.department();
	}

	public static class CourseDepartmentFinderSubclass<ParentOwnerType> extends DepartmentFinder.DepartmentSingleFinderForRelatedClasses<ParentOwnerType, Department, Course>
	{
		public CourseDepartmentFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "department";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CourseDepartmentFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Department plainValueOf(Course _obj)
		{
			return _obj.getDepartment();
		}

		protected DepartmentList plainListValueOf(Object _obj)
		{
			return ((CourseList)_obj).getDepartments();
		}
	}

	public static FacultyFinder.FacultyCollectionFinderForRelatedClasses<Course, FacultyList, Course> faculty()
	{
		return finder.faculty();
	}

	public static class CourseFacultyFinderSubclass<ParentOwnerType> extends FacultyFinder.FacultyCollectionFinderForRelatedClasses<ParentOwnerType, FacultyList, Course>
	{
		public CourseFacultyFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "faculty";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CourseFacultyFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected FacultyList plainValueOf(Course _obj)
		{
			return _obj.getFaculty();
		}

		protected FacultyList plainListValueOf(Object _obj)
		{
			return ((CourseList)_obj).getFaculty();
		}
	}

	public static StudentFinder.StudentCollectionFinderForRelatedClasses<Course, StudentList, Course> students()
	{
		return finder.students();
	}

	public static class CourseStudentsFinderSubclass<ParentOwnerType> extends StudentFinder.StudentCollectionFinderForRelatedClasses<ParentOwnerType, StudentList, Course>
	{
		public CourseStudentsFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "students";
		}

		public DeepRelationshipAttribute copy()
		{
			return new CourseStudentsFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected StudentList plainValueOf(Course _obj)
		{
			return _obj.getStudents();
		}

		protected StudentList plainListValueOf(Object _obj)
		{
			return ((CourseList)_obj).getStudents();
		}
	}

	public static Operation eq(Course other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(courseId());
	}

	public static CourseSingleFinder<Course, Object, Course> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			courseId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			courseId()
			, courseId()
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
			timeSlotId()
		}

		);
		cache.addIndex("1 Index", new Attribute[] 
		{
			lectureHallId()
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
		objectPortal = new UninitializedPortal("tracker.domain.Course");
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
