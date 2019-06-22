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
public class PersonFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/Person";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.Person";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.Person");
	private static final PersonSingleFinder<Person, Object, Person> finder = new PersonSingleFinder<Person, Object, Person>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(PersonFinder.PersonRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("personId");
		finderMethodMap.addNormalAttributeName("firstName");
		finderMethodMap.addNormalAttributeName("lastName");
		finderMethodMap.addNormalAttributeName("otherNames");
		finderMethodMap.addNormalAttributeName("age");
		finderMethodMap.addNormalAttributeName("genderId");
		finderMethodMap.addNormalAttributeName("maritalStatusId");
		finderMethodMap.addNormalAttributeName("nationalityId");
		finderMethodMap.addRelationshipName("gender");
		finderMethodMap.addRelationshipName("maritalStatus");
		finderMethodMap.addRelationshipName("nationality");
		finderMethodMap.addRelationshipName("faculty");
		finderMethodMap.addRelationshipName("student");
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
			result[0] = PersonFinder.genderId().constructEqualityMapper(GenderFinder.genderId());
			result[1] = GenderFinder.genderId().constructEqualityMapper(PersonFinder.genderId());
			result[2] = PersonFinder.maritalStatusId().constructEqualityMapper(MaritalStatusFinder.maritalStatusId());
			result[3] = MaritalStatusFinder.maritalStatusId().constructEqualityMapper(PersonFinder.maritalStatusId());
			result[4] = PersonFinder.nationalityId().constructEqualityMapper(NationalityFinder.nationalityId());
			result[5] = NationalityFinder.nationalityId().constructEqualityMapper(PersonFinder.nationalityId());
			constantJoinPool = result;
		}

		return constantJoinPool;
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static Person findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Person findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static PersonList findMany(com.gs.fw.finder.Operation operation)
	{
		return (PersonList) finder.findMany(operation);
	}

	public static PersonList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (PersonList) finder.findManyBypassCache(operation);
	}

	private static Person findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Person) FinderUtils.findOne(found);
	}

	public static Person findByPrimaryKey(int personId)
	{
		return finder.findByPrimaryKey(personId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			PersonData _castedTargetData = (PersonData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getPersonId())
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

	public static Person zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Person) FinderUtils.findOne(found);
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

	public static class PersonRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Person, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> personId;
		private StringAttribute<ParentOwnerType> firstName;
		private StringAttribute<ParentOwnerType> lastName;
		private StringAttribute<ParentOwnerType> otherNames;
		private IntegerAttribute<ParentOwnerType> age;
		private IntegerAttribute<ParentOwnerType> genderId;
		private IntegerAttribute<ParentOwnerType> maritalStatusId;
		private IntegerAttribute<ParentOwnerType> nationalityId;
		private PersonGenderFinderSubclass<ParentOwnerType> gender;
		private PersonMaritalStatusFinderSubclass<ParentOwnerType> maritalStatus;
		private PersonNationalityFinderSubclass<ParentOwnerType> nationality;
		private PersonFacultyFinderSubclass<ParentOwnerType> faculty;
		private PersonStudentFinderSubclass<ParentOwnerType> student;
		public PersonRelatedFinder()
		{
			super();
		}

		public PersonRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.PersonFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return PersonFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return PersonFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return PersonFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[8];
			attributes[0] = this.personId();
			attributes[1] = this.firstName();
			attributes[2] = this.lastName();
			attributes[3] = this.otherNames();
			attributes[4] = this.age();
			attributes[5] = this.genderId();
			attributes[6] = this.maritalStatusId();
			attributes[7] = this.nationalityId();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(5);
				relatedFinders.add(this.gender());
				relatedFinders.add(this.maritalStatus());
				relatedFinders.add(this.nationality());
				relatedFinders.add(this.faculty());
				relatedFinders.add(this.student());
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

		public Person findOne(com.gs.fw.finder.Operation operation)
		{
			return PersonFinder.findOne(operation, false);
		}

		public Person findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return PersonFinder.findOne(operation, true);
		}

		public MithraList<? extends Person> findMany(com.gs.fw.finder.Operation operation)
		{
			return new PersonList((Operation) operation);
		}

		public MithraList<? extends Person> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			PersonList result = (PersonList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Person> constructEmptyList()
		{
			return new PersonList();
		}

		public int getSerialVersionId()
		{
			return -1967658994;
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

		public IntegerAttribute<ParentOwnerType> personId()
		{
			IntegerAttribute<ParentOwnerType> result = this.personId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("PERSON_ID","","personId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(PersonFinder.personId(), this.mapper, this.zGetValueSelector());
				this.personId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> firstName()
		{
			StringAttribute<ParentOwnerType> result = this.firstName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("FIRST_NAME","","firstName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(PersonFinder.firstName(), this.mapper, this.zGetValueSelector());
				this.firstName = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> lastName()
		{
			StringAttribute<ParentOwnerType> result = this.lastName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("LAST_NAME","","lastName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(PersonFinder.lastName(), this.mapper, this.zGetValueSelector());
				this.lastName = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> otherNames()
		{
			StringAttribute<ParentOwnerType> result = this.otherNames;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("OTHER_NAMES","","otherNames",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(PersonFinder.otherNames(), this.mapper, this.zGetValueSelector());
				this.otherNames = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> age()
		{
			IntegerAttribute<ParentOwnerType> result = this.age;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("AGE","","age",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(PersonFinder.age(), this.mapper, this.zGetValueSelector());
				this.age = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> genderId()
		{
			IntegerAttribute<ParentOwnerType> result = this.genderId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("GENDER_ID","","genderId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(PersonFinder.genderId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("gender");
				result.zSetOwningReverseRelationship("tracker.domain", "Gender", "people");
				this.genderId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> maritalStatusId()
		{
			IntegerAttribute<ParentOwnerType> result = this.maritalStatusId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("MARITAL_STATUS_ID","","maritalStatusId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(PersonFinder.maritalStatusId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("maritalStatus");
				result.zSetOwningReverseRelationship("tracker.domain", "MaritalStatus", "people");
				this.maritalStatusId = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> nationalityId()
		{
			IntegerAttribute<ParentOwnerType> result = this.nationalityId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("NATIONALITY_ID","","nationalityId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(PersonFinder.nationalityId(), this.mapper, this.zGetValueSelector());
				result.zSetOwningRelationship("nationality");
				result.zSetOwningReverseRelationship("tracker.domain", "Nationality", "people");
				this.nationalityId = result;
			}

			return result;
		}

		public GenderFinder.GenderSingleFinderForRelatedClasses<ParentOwnerType, Gender, Person> gender()
		{
			PersonGenderFinderSubclass<ParentOwnerType> result = this.gender;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(PersonFinder.zGetPersonGenderReverseMapper());
				newMapper.setToMany(false);
				result = new PersonGenderFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.gender = result;
			}

			return result;
		}

		public MaritalStatusFinder.MaritalStatusSingleFinderForRelatedClasses<ParentOwnerType, MaritalStatus, Person> maritalStatus()
		{
			PersonMaritalStatusFinderSubclass<ParentOwnerType> result = this.maritalStatus;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(PersonFinder.zGetPersonMaritalStatusReverseMapper());
				newMapper.setToMany(false);
				result = new PersonMaritalStatusFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.maritalStatus = result;
			}

			return result;
		}

		public NationalityFinder.NationalitySingleFinderForRelatedClasses<ParentOwnerType, Nationality, Person> nationality()
		{
			PersonNationalityFinderSubclass<ParentOwnerType> result = this.nationality;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(PersonFinder.zGetPersonNationalityReverseMapper());
				newMapper.setToMany(false);
				result = new PersonNationalityFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.nationality = result;
			}

			return result;
		}

		public FacultyFinder.FacultySingleFinderForRelatedClasses<ParentOwnerType, Faculty, Person> faculty()
		{
			PersonFacultyFinderSubclass<ParentOwnerType> result = this.faculty;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(FacultyFinder.zGetFacultyPersonMapper());
				newMapper.setToMany(false);
				result = new PersonFacultyFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.faculty = result;
			}

			return result;
		}

		public StudentFinder.StudentSingleFinderForRelatedClasses<ParentOwnerType, Student, Person> student()
		{
			PersonStudentFinderSubclass<ParentOwnerType> result = this.student;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(StudentFinder.zGetStudentPersonMapper());
				newMapper.setToMany(false);
				result = new PersonStudentFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.student = result;
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
			return PersonFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return PersonFinder.getMithraObjectPortal();
		}
	}

	public static class PersonCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends PersonRelatedFinder<ParentOwnerType, ReturnType, PersonList, OwnerType>
	{
		public PersonCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class PersonCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends PersonCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public PersonCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class PersonSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends PersonRelatedFinder<ParentOwnerType, ReturnType, PersonList, OwnerType>
	implements ToOneFinder
	{
		public PersonSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public PersonSingleFinder()
		{
			super(null);
		}

		public Operation eq(Person other)
		{
			return this.personId().eq(other.getPersonId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Person findByPrimaryKey(int personId)
		{
			Person _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(personId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Person) _related;
			if (_related == null)
			{
				_op = this.personId().eq(personId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class PersonSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends PersonSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public PersonSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	private static Mapper genderReverseMapper = null;
	public static Mapper zGetPersonGenderReverseMapper()
	{
		if (genderReverseMapper == null)
		{
			genderReverseMapper = zConstructPersonGenderReverseMapper();
		}

		return genderReverseMapper;
	}

	private static Mapper genderMapper = null;
	public static Mapper zGetPersonGenderMapper()
	{
		if (genderMapper == null)
		{
			genderMapper = zConstructPersonGenderMapper();
		}

		return genderMapper;
	}

	private static Mapper genderPureReverseMapper = null;
	public static Mapper zGetPersonGenderPureReverseMapper()
	{
		if (genderPureReverseMapper == null)
		{
			genderPureReverseMapper = zConstructPersonGenderPureReverseMapper();
		}

		return genderPureReverseMapper;
	}

	private static Mapper zConstructPersonGenderPureReverseMapper()
	{
		Mapper genderMapper = PersonFinder.zGetConstantJoin(0);
		genderMapper.setName("gender");
		return genderMapper;
	}

	private static Mapper zConstructPersonGenderReverseMapper()
	{
		Mapper genderMapper = PersonFinder.zGetConstantJoin(0);
		genderMapper.setName("gender");
		return genderMapper;
	}

	private static Mapper zConstructPersonGenderMapper()
	{
		Mapper genderMapper = PersonFinder.zGetConstantJoin(1);
		genderMapper.setName("people");
		return genderMapper;
	}

	private static Mapper maritalStatusReverseMapper = null;
	public static Mapper zGetPersonMaritalStatusReverseMapper()
	{
		if (maritalStatusReverseMapper == null)
		{
			maritalStatusReverseMapper = zConstructPersonMaritalStatusReverseMapper();
		}

		return maritalStatusReverseMapper;
	}

	private static Mapper maritalStatusMapper = null;
	public static Mapper zGetPersonMaritalStatusMapper()
	{
		if (maritalStatusMapper == null)
		{
			maritalStatusMapper = zConstructPersonMaritalStatusMapper();
		}

		return maritalStatusMapper;
	}

	private static Mapper maritalStatusPureReverseMapper = null;
	public static Mapper zGetPersonMaritalStatusPureReverseMapper()
	{
		if (maritalStatusPureReverseMapper == null)
		{
			maritalStatusPureReverseMapper = zConstructPersonMaritalStatusPureReverseMapper();
		}

		return maritalStatusPureReverseMapper;
	}

	private static Mapper zConstructPersonMaritalStatusPureReverseMapper()
	{
		Mapper maritalStatusMapper = PersonFinder.zGetConstantJoin(2);
		maritalStatusMapper.setName("maritalStatus");
		return maritalStatusMapper;
	}

	private static Mapper zConstructPersonMaritalStatusReverseMapper()
	{
		Mapper maritalStatusMapper = PersonFinder.zGetConstantJoin(2);
		maritalStatusMapper.setName("maritalStatus");
		return maritalStatusMapper;
	}

	private static Mapper zConstructPersonMaritalStatusMapper()
	{
		Mapper maritalStatusMapper = PersonFinder.zGetConstantJoin(3);
		maritalStatusMapper.setName("people");
		return maritalStatusMapper;
	}

	private static Mapper nationalityReverseMapper = null;
	public static Mapper zGetPersonNationalityReverseMapper()
	{
		if (nationalityReverseMapper == null)
		{
			nationalityReverseMapper = zConstructPersonNationalityReverseMapper();
		}

		return nationalityReverseMapper;
	}

	private static Mapper nationalityMapper = null;
	public static Mapper zGetPersonNationalityMapper()
	{
		if (nationalityMapper == null)
		{
			nationalityMapper = zConstructPersonNationalityMapper();
		}

		return nationalityMapper;
	}

	private static Mapper nationalityPureReverseMapper = null;
	public static Mapper zGetPersonNationalityPureReverseMapper()
	{
		if (nationalityPureReverseMapper == null)
		{
			nationalityPureReverseMapper = zConstructPersonNationalityPureReverseMapper();
		}

		return nationalityPureReverseMapper;
	}

	private static Mapper zConstructPersonNationalityPureReverseMapper()
	{
		Mapper nationalityMapper = PersonFinder.zGetConstantJoin(4);
		nationalityMapper.setName("nationality");
		return nationalityMapper;
	}

	private static Mapper zConstructPersonNationalityReverseMapper()
	{
		Mapper nationalityMapper = PersonFinder.zGetConstantJoin(4);
		nationalityMapper.setName("nationality");
		return nationalityMapper;
	}

	private static Mapper zConstructPersonNationalityMapper()
	{
		Mapper nationalityMapper = PersonFinder.zGetConstantJoin(5);
		nationalityMapper.setName("people");
		return nationalityMapper;
	}

	/** maps to PERSONS.PERSON_ID **/
	public static IntegerAttribute<Person> personId()
	{
		return finder.personId();
	}

	/** maps to PERSONS.FIRST_NAME **/
	public static StringAttribute<Person> firstName()
	{
		return finder.firstName();
	}

	/** maps to PERSONS.LAST_NAME **/
	public static StringAttribute<Person> lastName()
	{
		return finder.lastName();
	}

	/** maps to PERSONS.OTHER_NAMES **/
	public static StringAttribute<Person> otherNames()
	{
		return finder.otherNames();
	}

	/** maps to PERSONS.AGE **/
	public static IntegerAttribute<Person> age()
	{
		return finder.age();
	}

	/** maps to PERSONS.GENDER_ID **/
	public static IntegerAttribute<Person> genderId()
	{
		return finder.genderId();
	}

	/** maps to PERSONS.MARITAL_STATUS_ID **/
	public static IntegerAttribute<Person> maritalStatusId()
	{
		return finder.maritalStatusId();
	}

	/** maps to PERSONS.NATIONALITY_ID **/
	public static IntegerAttribute<Person> nationalityId()
	{
		return finder.nationalityId();
	}

	public static GenderFinder.GenderSingleFinderForRelatedClasses<Person, Gender, Person> gender()
	{
		return finder.gender();
	}

	public static class PersonGenderFinderSubclass<ParentOwnerType> extends GenderFinder.GenderSingleFinderForRelatedClasses<ParentOwnerType, Gender, Person>
	{
		public PersonGenderFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "gender";
		}

		public DeepRelationshipAttribute copy()
		{
			return new PersonGenderFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Gender plainValueOf(Person _obj)
		{
			return _obj.getGender();
		}

		protected GenderList plainListValueOf(Object _obj)
		{
			return ((PersonList)_obj).getGenders();
		}
	}

	public static MaritalStatusFinder.MaritalStatusSingleFinderForRelatedClasses<Person, MaritalStatus, Person> maritalStatus()
	{
		return finder.maritalStatus();
	}

	public static class PersonMaritalStatusFinderSubclass<ParentOwnerType> extends MaritalStatusFinder.MaritalStatusSingleFinderForRelatedClasses<ParentOwnerType, MaritalStatus, Person>
	{
		public PersonMaritalStatusFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "maritalStatus";
		}

		public DeepRelationshipAttribute copy()
		{
			return new PersonMaritalStatusFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected MaritalStatus plainValueOf(Person _obj)
		{
			return _obj.getMaritalStatus();
		}

		protected MaritalStatusList plainListValueOf(Object _obj)
		{
			return ((PersonList)_obj).getMaritalStatus();
		}
	}

	public static NationalityFinder.NationalitySingleFinderForRelatedClasses<Person, Nationality, Person> nationality()
	{
		return finder.nationality();
	}

	public static class PersonNationalityFinderSubclass<ParentOwnerType> extends NationalityFinder.NationalitySingleFinderForRelatedClasses<ParentOwnerType, Nationality, Person>
	{
		public PersonNationalityFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "nationality";
		}

		public DeepRelationshipAttribute copy()
		{
			return new PersonNationalityFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Nationality plainValueOf(Person _obj)
		{
			return _obj.getNationality();
		}

		protected NationalityList plainListValueOf(Object _obj)
		{
			return ((PersonList)_obj).getNationalities();
		}
	}

	public static FacultyFinder.FacultySingleFinderForRelatedClasses<Person, Faculty, Person> faculty()
	{
		return finder.faculty();
	}

	public static class PersonFacultyFinderSubclass<ParentOwnerType> extends FacultyFinder.FacultySingleFinderForRelatedClasses<ParentOwnerType, Faculty, Person>
	{
		public PersonFacultyFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "faculty";
		}

		public DeepRelationshipAttribute copy()
		{
			return new PersonFacultyFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Faculty plainValueOf(Person _obj)
		{
			return _obj.getFaculty();
		}

		protected FacultyList plainListValueOf(Object _obj)
		{
			return ((PersonList)_obj).getFaculties();
		}
	}

	public static StudentFinder.StudentSingleFinderForRelatedClasses<Person, Student, Person> student()
	{
		return finder.student();
	}

	public static class PersonStudentFinderSubclass<ParentOwnerType> extends StudentFinder.StudentSingleFinderForRelatedClasses<ParentOwnerType, Student, Person>
	{
		public PersonStudentFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_ONE;
			this._name = "student";
		}

		public DeepRelationshipAttribute copy()
		{
			return new PersonStudentFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected Student plainValueOf(Person _obj)
		{
			return _obj.getStudent();
		}

		protected StudentList plainListValueOf(Object _obj)
		{
			return ((PersonList)_obj).getStudents();
		}
	}

	public static Operation eq(Person other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(personId());
	}

	public static PersonSingleFinder<Person, Object, Person> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			personId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			personId()
			, personId()
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
			genderId()
		}

		);
		cache.addIndex("1 Index", new Attribute[] 
		{
			maritalStatusId()
		}

		);
		cache.addIndex("2 Index", new Attribute[] 
		{
			nationalityId()
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
			FacultyFinder.getFinderInstance(),GenderFinder.getFinderInstance(),MaritalStatusFinder.getFinderInstance(),NationalityFinder.getFinderInstance(),StudentFinder.getFinderInstance(),
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
			FacultyFinder.getFinderInstance(),GenderFinder.getFinderInstance(),MaritalStatusFinder.getFinderInstance(),NationalityFinder.getFinderInstance(),StudentFinder.getFinderInstance(),
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
		objectPortal = new UninitializedPortal("tracker.domain.Person");
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
