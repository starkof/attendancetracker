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
public class StudentFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/mithraobjects/Student";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.mithraobjects.Student";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.mithraobjects.Student");
	private static final StudentSingleFinder<Student, Object, Student> finder = new StudentSingleFinder<Student, Object, Student>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(StudentFinder.StudentRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("studentId");
		finderMethodMap.addNormalAttributeName("majorId");
		finderMethodMap.addNormalAttributeName("gpa");
		finderMethodMap.addNormalAttributeName("admissionDate");
		finderMethodMap.addNormalAttributeName("expectedGraduation");
		finderMethodMap.addNormalAttributeName("personId");
		finderMethodMap.addNormalAttributeName("courseId");
		finderMethodMap.addRelationshipName("major");
		finderMethodMap.addRelationshipName("person");
		finderMethodMap.addRelationshipName("courses");
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
			result[0] = StudentFinder.majorId().constructEqualityMapper(MajorFinder.majorId());
			result[1] = MajorFinder.majorId().constructEqualityMapper(StudentFinder.majorId());
			result[2] = StudentFinder.personId().constructEqualityMapper(PersonFinder.personId());
			result[3] = PersonFinder.personId().constructEqualityMapper(StudentFinder.personId());
			result[4] = StudentFinder.courseId().constructEqualityMapper(CourseFinder.courseId());
			result[5] = CourseFinder.courseId().constructEqualityMapper(StudentFinder.courseId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Student findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Student findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static StudentList findMany(com.gs.fw.finder.Operation operation)
	{
		return (StudentList) finder.findMany(operation);
	}

	public static StudentList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (StudentList) finder.findManyBypassCache(operation);
	}

	private static Student findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Student) FinderUtils.findOne(found);
	}

	public static Student findByPrimaryKey(int studentId)
	{
		return finder.findByPrimaryKey(studentId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			StudentData _castedTargetData = (StudentData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getStudentId())
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

	public static Student zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Student) FinderUtils.findOne(found);
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

	public static class StudentRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Student, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> studentId;
		private IntegerAttribute<ParentOwnerType> majorId;
		private IntegerAttribute<ParentOwnerType> gpa;
		private DateAttribute<ParentOwnerType> admissionDate;
		private DateAttribute<ParentOwnerType> expectedGraduation;
		private IntegerAttribute<ParentOwnerType> personId;
		private IntegerAttribute<ParentOwnerType> courseId;
		private StudentMajorFinderSubclass<ParentOwnerType> major;
		private StudentPersonFinderSubclass<ParentOwnerType> person;
		private StudentCoursesFinderSubclass<ParentOwnerType> courses;
		public StudentRelatedFinder()
		{
			super();
		}

		public StudentRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.mithraobjects.StudentFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return StudentFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return StudentFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return StudentFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[7];
			attributes[0] = this.studentId();
			attributes[1] = this.majorId();
			attributes[2] = this.gpa();
			attributes[3] = this.admissionDate();
			attributes[4] = this.expectedGraduation();
			attributes[5] = this.personId();
			attributes[6] = this.courseId();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(3);
				relatedFinders.add(this.major());
				relatedFinders.add(this.person());
				relatedFinders.add(this.courses());
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

		public Student findOne(com.gs.fw.finder.Operation operation)
		{
			return StudentFinder.findOne(operation, false);
		}

		public Student findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return StudentFinder.findOne(operation, true);
		}

		public MithraList<? extends Student> findMany(com.gs.fw.finder.Operation operation)
		{
			return new StudentList((Operation) operation);
		}

		public MithraList<? extends Student> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			StudentList result = (StudentList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Student> constructEmptyList()
		{
			return new StudentList();
		}

		public int getSerialVersionId()
		{
			return -253154942;
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

		public IntegerAttribute<ParentOwnerType> studentId()
		{
			IntegerAttribute<ParentOwnerType> result = this.studentId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("STUDENT_ID","","studentId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(StudentFinder.studentId(), this.mapper, this.zGetValueSelector());
				this.studentId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> majorId()
		{
			IntegerAttribute<ParentOwnerType> result = this.majorId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("MAJOR_ID","","majorId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(StudentFinder.majorId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("major");
				result.zSetOwningReverseRelationship("com.mithraobjects", "Major", "students");
				this.majorId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> gpa()
		{
			IntegerAttribute<ParentOwnerType> result = this.gpa;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("GPA","","gpa",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(StudentFinder.gpa(), this.mapper, this.zGetValueSelector());
				this.gpa = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> admissionDate()
		{
			DateAttribute<ParentOwnerType> result = this.admissionDate;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("ADMISSION_DATE","","admissionDate",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(StudentFinder.admissionDate(), this.mapper, this.zGetValueSelector());
				this.admissionDate = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> expectedGraduation()
		{
			DateAttribute<ParentOwnerType> result = this.expectedGraduation;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("EXPECTED_GRADUATION","","expectedGraduation",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(StudentFinder.expectedGraduation(), this.mapper, this.zGetValueSelector());
				this.expectedGraduation = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> personId()
		{
			IntegerAttribute<ParentOwnerType> result = this.personId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("PERSON_ID","","personId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(StudentFinder.personId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("person");
				result.zSetOwningReverseRelationship("com.mithraobjects", "Person", "student");
				this.personId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> courseId()
		{
			IntegerAttribute<ParentOwnerType> result = this.courseId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("COURSE_ID","","courseId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(StudentFinder.courseId(), this.mapper, this.zGetValueSelector());
				this.courseId = result;
			}

			return result;
		}

		public MajorFinder.MajorSingleFinderForRelatedClasses<ParentOwnerType, Major, Student> major()
		{
			StudentMajorFinderSubclass<ParentOwnerType> result = this.major;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentMajorReverseMapper());
				newMapper.setToMany(false);
				result = new StudentMajorFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.major = result;
			}

			return result;
		}

		public PersonFinder.PersonSingleFinderForRelatedClasses<ParentOwnerType, Person, Student> person()
		{
			StudentPersonFinderSubclass<ParentOwnerType> result = this.person;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentPersonReverseMapper());
				newMapper.setToMany(false);
				result = new StudentPersonFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.person = result;
			}

			return result;
		}

		public CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Student> courses()
		{
			StudentCoursesFinderSubclass<ParentOwnerType> result = this.courses;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentCoursesReverseMapper());
				newMapper.setToMany(true);
				result = new StudentCoursesFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.courses = result;
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
			return StudentFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return StudentFinder.getMithraObjectPortal();
		}
	}

	public static class StudentCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends StudentRelatedFinder<ParentOwnerType, ReturnType, StudentList, OwnerType>
	{
		public StudentCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class StudentCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends StudentCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public StudentCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class StudentSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends StudentRelatedFinder<ParentOwnerType, ReturnType, StudentList, OwnerType>
	implements ToOneFinder
	{
		public StudentSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public StudentSingleFinder()
		{
			super(null);
		}

		public Operation eq(Student other)
		{
			return this.studentId().eq(other.getStudentId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Student findByPrimaryKey(int studentId)
		{
			Student _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(studentId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Student) _related;
			if (_related == null)
			{
				_op = this.studentId().eq(studentId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class StudentSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends StudentSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public StudentSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper majorReverseMapper = null;
	public static Mapper zGetStudentMajorReverseMapper()
	{
		if (majorReverseMapper == null)
		{
			majorReverseMapper = zConstructStudentMajorReverseMapper();
		}

		return majorReverseMapper;
	}

	private static Mapper majorMapper = null;
	public static Mapper zGetStudentMajorMapper()
	{
		if (majorMapper == null)
		{
			majorMapper = zConstructStudentMajorMapper();
		}

		return majorMapper;
	}

	private static Mapper majorPureReverseMapper = null;
	public static Mapper zGetStudentMajorPureReverseMapper()
	{
		if (majorPureReverseMapper == null)
		{
			majorPureReverseMapper = zConstructStudentMajorPureReverseMapper();
		}

		return majorPureReverseMapper;
	}

	private static Mapper zConstructStudentMajorPureReverseMapper()
	{
		Mapper majorMapper = StudentFinder.zGetConstantJoin(0);
		majorMapper.setName("major");
		return majorMapper;
	}

	private static Mapper zConstructStudentMajorReverseMapper()
	{
		Mapper majorMapper = StudentFinder.zGetConstantJoin(0);
		majorMapper.setName("major");
		return majorMapper;
	}

	private static Mapper zConstructStudentMajorMapper()
	{
		Mapper majorMapper = StudentFinder.zGetConstantJoin(1);
		majorMapper.setName("students");
		return majorMapper;
	}

	private static Mapper personReverseMapper = null;
	public static Mapper zGetStudentPersonReverseMapper()
	{
		if (personReverseMapper == null)
		{
			personReverseMapper = zConstructStudentPersonReverseMapper();
		}

		return personReverseMapper;
	}

	private static Mapper personMapper = null;
	public static Mapper zGetStudentPersonMapper()
	{
		if (personMapper == null)
		{
			personMapper = zConstructStudentPersonMapper();
		}

		return personMapper;
	}

	private static Mapper personPureReverseMapper = null;
	public static Mapper zGetStudentPersonPureReverseMapper()
	{
		if (personPureReverseMapper == null)
		{
			personPureReverseMapper = zConstructStudentPersonPureReverseMapper();
		}

		return personPureReverseMapper;
	}

	private static Mapper zConstructStudentPersonPureReverseMapper()
	{
		Mapper personMapper = StudentFinder.zGetConstantJoin(2);
		personMapper.setName("person");
		return personMapper;
	}

	private static Mapper zConstructStudentPersonReverseMapper()
	{
		Mapper personMapper = StudentFinder.zGetConstantJoin(2);
		personMapper.setName("person");
		return personMapper;
	}

	private static Mapper zConstructStudentPersonMapper()
	{
		Mapper personMapper = StudentFinder.zGetConstantJoin(3);
		personMapper.setName("student");
		return personMapper;
	}

	private static Mapper coursesReverseMapper = null;
	public static Mapper zGetStudentCoursesReverseMapper()
	{
		if (coursesReverseMapper == null)
		{
			coursesReverseMapper = zConstructStudentCoursesReverseMapper();
		}

		return coursesReverseMapper;
	}

	private static Mapper coursesMapper = null;
	public static Mapper zGetStudentCoursesMapper()
	{
		if (coursesMapper == null)
		{
			coursesMapper = zConstructStudentCoursesMapper();
		}

		return coursesMapper;
	}

	private static Mapper coursesPureReverseMapper = null;
	public static Mapper zGetStudentCoursesPureReverseMapper()
	{
		if (coursesPureReverseMapper == null)
		{
			coursesPureReverseMapper = zConstructStudentCoursesPureReverseMapper();
		}

		return coursesPureReverseMapper;
	}

	private static Mapper zConstructStudentCoursesPureReverseMapper()
	{
		Mapper coursesMapper = StudentFinder.zGetConstantJoin(4);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructStudentCoursesReverseMapper()
	{
		Mapper coursesMapper = StudentFinder.zGetConstantJoin(4);
		coursesMapper.setName("courses");
		return coursesMapper;
	}

	private static Mapper zConstructStudentCoursesMapper()
	{
		Mapper coursesMapper = StudentFinder.zGetConstantJoin(5);
		coursesMapper.setName("students");
		return coursesMapper;
	}

	/** maps to STUDENTS.STUDENT_ID **/
	public static IntegerAttribute<Student> studentId()
	{
		return finder.studentId();
	}

	/** maps to STUDENTS.MAJOR_ID **/
	public static IntegerAttribute<Student> majorId()
	{
		return finder.majorId();
	}

	/** maps to STUDENTS.GPA **/
	public static IntegerAttribute<Student> gpa()
	{
		return finder.gpa();
	}

	/** maps to STUDENTS.ADMISSION_DATE **/
	public static DateAttribute<Student> admissionDate()
	{
		return finder.admissionDate();
	}

	/** maps to STUDENTS.EXPECTED_GRADUATION **/
	public static DateAttribute<Student> expectedGraduation()
	{
		return finder.expectedGraduation();
	}

	/** maps to STUDENTS.PERSON_ID **/
	public static IntegerAttribute<Student> personId()
	{
		return finder.personId();
	}

	/** maps to STUDENTS.COURSE_ID **/
	public static IntegerAttribute<Student> courseId()
	{
		return finder.courseId();
	}

	public static MajorFinder.MajorSingleFinderForRelatedClasses<Student, Major, Student> major()
	{
		return finder.major();
	}

	public static class StudentMajorFinderSubclass<ParentOwnerType> extends MajorFinder.MajorSingleFinderForRelatedClasses<ParentOwnerType, Major, Student>
	{
		public StudentMajorFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "major";
		}

		public DeepRelationshipAttribute copy()
		{
			return new StudentMajorFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Major plainValueOf(Student _obj)
		{
			return _obj.getMajor();
		}

		protected MajorList plainListValueOf(Object _obj)
		{
			return ((StudentList)_obj).getMajors();
		}
	}

	public static PersonFinder.PersonSingleFinderForRelatedClasses<Student, Person, Student> person()
	{
		return finder.person();
	}

	public static class StudentPersonFinderSubclass<ParentOwnerType> extends PersonFinder.PersonSingleFinderForRelatedClasses<ParentOwnerType, Person, Student>
	{
		public StudentPersonFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "person";
		}

		public DeepRelationshipAttribute copy()
		{
			return new StudentPersonFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Person plainValueOf(Student _obj)
		{
			return _obj.getPerson();
		}

		protected PersonList plainListValueOf(Object _obj)
		{
			return ((StudentList)_obj).getPersons();
		}
	}

	public static CourseFinder.CourseCollectionFinderForRelatedClasses<Student, CourseList, Student> courses()
	{
		return finder.courses();
	}

	public static class StudentCoursesFinderSubclass<ParentOwnerType> extends CourseFinder.CourseCollectionFinderForRelatedClasses<ParentOwnerType, CourseList, Student>
	{
		public StudentCoursesFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "courses";
		}

		public DeepRelationshipAttribute copy()
		{
			return new StudentCoursesFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected CourseList plainValueOf(Student _obj)
		{
			return _obj.getCourses();
		}

		protected CourseList plainListValueOf(Object _obj)
		{
			return ((StudentList)_obj).getCourses();
		}
	}

	public static Operation eq(Student other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(studentId());
	}

	public static StudentSingleFinder<Student, Object, Student> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			studentId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			studentId()
			, studentId()
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
			majorId()
		}

		);
		cache.addIndex("1 Index", new Attribute[] 
		{
			personId()
		}

		);
		cache.addIndex("2 Index", new Attribute[] 
		{
			courseId()
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
			MajorFinder.getFinderInstance(),
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
			MajorFinder.getFinderInstance(),
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
		objectPortal = new UninitializedPortal("com.mithraobjects.Student");
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
