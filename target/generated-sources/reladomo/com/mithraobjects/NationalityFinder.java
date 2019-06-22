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
public class NationalityFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/mithraobjects/Nationality";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.mithraobjects.Nationality";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.mithraobjects.Nationality");
	private static final NationalitySingleFinder<Nationality, Object, Nationality> finder = new NationalitySingleFinder<Nationality, Object, Nationality>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(NationalityFinder.NationalityRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("nationalityId");
		finderMethodMap.addNormalAttributeName("nationalityValue");
		finderMethodMap.addRelationshipName("people");
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

	public static Nationality findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static Nationality findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static NationalityList findMany(com.gs.fw.finder.Operation operation)
	{
		return (NationalityList) finder.findMany(operation);
	}

	public static NationalityList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (NationalityList) finder.findManyBypassCache(operation);
	}

	private static Nationality findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (Nationality) FinderUtils.findOne(found);
	}

	public static Nationality findByPrimaryKey(int nationalityId)
	{
		return finder.findByPrimaryKey(nationalityId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			NationalityData _castedTargetData = (NationalityData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getNationalityId())
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

	public static Nationality zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (Nationality) FinderUtils.findOne(found);
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

	public static class NationalityRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<Nationality, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> nationalityId;
		private StringAttribute<ParentOwnerType> nationalityValue;
		private NationalityPeopleFinderSubclass<ParentOwnerType> people;
		public NationalityRelatedFinder()
		{
			super();
		}

		public NationalityRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.mithraobjects.NationalityFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return NationalityFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return NationalityFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return NationalityFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[2];
			attributes[0] = this.nationalityId();
			attributes[1] = this.nationalityValue();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(1);
				relatedFinders.add(this.people());
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

		public Nationality findOne(com.gs.fw.finder.Operation operation)
		{
			return NationalityFinder.findOne(operation, false);
		}

		public Nationality findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return NationalityFinder.findOne(operation, true);
		}

		public MithraList<? extends Nationality> findMany(com.gs.fw.finder.Operation operation)
		{
			return new NationalityList((Operation) operation);
		}

		public MithraList<? extends Nationality> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			NationalityList result = (NationalityList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends Nationality> constructEmptyList()
		{
			return new NationalityList();
		}

		public int getSerialVersionId()
		{
			return 542827759;
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

		public IntegerAttribute<ParentOwnerType> nationalityId()
		{
			IntegerAttribute<ParentOwnerType> result = this.nationalityId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("NATIONALITY_ID","","nationalityId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(NationalityFinder.nationalityId(), this.mapper, this.zGetValueSelector());
				this.nationalityId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> nationalityValue()
		{
			StringAttribute<ParentOwnerType> result = this.nationalityValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("NATIONALITY_VALUE","","nationalityValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(NationalityFinder.nationalityValue(), this.mapper, this.zGetValueSelector());
				this.nationalityValue = result;
			}

			return result;
		}

		public PersonFinder.PersonCollectionFinderForRelatedClasses<ParentOwnerType, PersonList, Nationality> people()
		{
			NationalityPeopleFinderSubclass<ParentOwnerType> result = this.people;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(PersonFinder.zGetPersonNationalityMapper());
				newMapper.setToMany(true);
				result = new NationalityPeopleFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
				this.people = result;
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
			return NationalityFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return NationalityFinder.getMithraObjectPortal();
		}
	}

	public static class NationalityCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends NationalityRelatedFinder<ParentOwnerType, ReturnType, NationalityList, OwnerType>
	{
		public NationalityCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class NationalityCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends NationalityCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public NationalityCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class NationalitySingleFinder<ParentOwnerType, ReturnType, OwnerType> extends NationalityRelatedFinder<ParentOwnerType, ReturnType, NationalityList, OwnerType>
	implements ToOneFinder
	{
		public NationalitySingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public NationalitySingleFinder()
		{
			super(null);
		}

		public Operation eq(Nationality other)
		{
			return this.nationalityId().eq(other.getNationalityId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public Nationality findByPrimaryKey(int nationalityId)
		{
			Nationality _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(nationalityId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (Nationality) _related;
			if (_related == null)
			{
				_op = this.nationalityId().eq(nationalityId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class NationalitySingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends NationalitySingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public NationalitySingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to NATIONALITIES.NATIONALITY_ID **/
	public static IntegerAttribute<Nationality> nationalityId()
	{
		return finder.nationalityId();
	}

	/** maps to NATIONALITIES.NATIONALITY_VALUE **/
	public static StringAttribute<Nationality> nationalityValue()
	{
		return finder.nationalityValue();
	}

	public static PersonFinder.PersonCollectionFinderForRelatedClasses<Nationality, PersonList, Nationality> people()
	{
		return finder.people();
	}

	public static class NationalityPeopleFinderSubclass<ParentOwnerType> extends PersonFinder.PersonCollectionFinderForRelatedClasses<ParentOwnerType, PersonList, Nationality>
	{
		public NationalityPeopleFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "people";
		}

		public DeepRelationshipAttribute copy()
		{
			return new NationalityPeopleFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected PersonList plainValueOf(Nationality _obj)
		{
			return _obj.getPeople();
		}

		protected PersonList plainListValueOf(Object _obj)
		{
			return ((NationalityList)_obj).getPeople();
		}
	}

	public static Operation eq(Nationality other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(nationalityId());
	}

	public static NationalitySingleFinder<Nationality, Object, Nationality> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			nationalityId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			nationalityId()
			, nationalityId()
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
		objectPortal = new UninitializedPortal("com.mithraobjects.Nationality");
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
