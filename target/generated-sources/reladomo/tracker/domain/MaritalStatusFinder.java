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
public class MaritalStatusFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "tracker/domain/MaritalStatus";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "tracker.domain.MaritalStatus";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("tracker.domain.MaritalStatus");
	private static final MaritalStatusSingleFinder<MaritalStatus, Object, MaritalStatus> finder = new MaritalStatusSingleFinder<MaritalStatus, Object, MaritalStatus>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(MaritalStatusFinder.MaritalStatusRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("maritalStatusId");
		finderMethodMap.addNormalAttributeName("maritalStatusValue");
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

	public static MaritalStatus findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static MaritalStatus findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static MaritalStatusList findMany(com.gs.fw.finder.Operation operation)
	{
		return (MaritalStatusList) finder.findMany(operation);
	}

	public static MaritalStatusList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (MaritalStatusList) finder.findManyBypassCache(operation);
	}

	private static MaritalStatus findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (MaritalStatus) FinderUtils.findOne(found);
	}

	public static MaritalStatus findByPrimaryKey(int maritalStatusId)
	{
		return finder.findByPrimaryKey(maritalStatusId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			MaritalStatusData _castedTargetData = (MaritalStatusData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getMaritalStatusId())
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

	public static MaritalStatus zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (MaritalStatus) FinderUtils.findOne(found);
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

	public static class MaritalStatusRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<MaritalStatus, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> maritalStatusId;
		private StringAttribute<ParentOwnerType> maritalStatusValue;
		private MaritalStatusPeopleFinderSubclass<ParentOwnerType> people;
		public MaritalStatusRelatedFinder()
		{
			super();
		}

		public MaritalStatusRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "tracker.domain.MaritalStatusFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return MaritalStatusFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return MaritalStatusFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return MaritalStatusFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[2];
			attributes[0] = this.maritalStatusId();
			attributes[1] = this.maritalStatusValue();
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

		public MaritalStatus findOne(com.gs.fw.finder.Operation operation)
		{
			return MaritalStatusFinder.findOne(operation, false);
		}

		public MaritalStatus findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return MaritalStatusFinder.findOne(operation, true);
		}

		public MithraList<? extends MaritalStatus> findMany(com.gs.fw.finder.Operation operation)
		{
			return new MaritalStatusList((Operation) operation);
		}

		public MithraList<? extends MaritalStatus> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			MaritalStatusList result = (MaritalStatusList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends MaritalStatus> constructEmptyList()
		{
			return new MaritalStatusList();
		}

		public int getSerialVersionId()
		{
			return 744008998;
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

		public IntegerAttribute<ParentOwnerType> maritalStatusId()
		{
			IntegerAttribute<ParentOwnerType> result = this.maritalStatusId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("MARITAL_STATUS_ID","","maritalStatusId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(MaritalStatusFinder.maritalStatusId(), this.mapper, this.zGetValueSelector());
				this.maritalStatusId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> maritalStatusValue()
		{
			StringAttribute<ParentOwnerType> result = this.maritalStatusValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("MARITAL_STATUS_VALUE","","maritalStatusValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(MaritalStatusFinder.maritalStatusValue(), this.mapper, this.zGetValueSelector());
				this.maritalStatusValue = result;
			}

			return result;
		}

		public PersonFinder.PersonCollectionFinderForRelatedClasses<ParentOwnerType, PersonList, MaritalStatus> people()
		{
			MaritalStatusPeopleFinderSubclass<ParentOwnerType> result = this.people;
			if (result == null)
			{
				Mapper newMapper = combineWithMapperIfExists(PersonFinder.zGetPersonMaritalStatusMapper());
				newMapper.setToMany(true);
				result = new MaritalStatusPeopleFinderSubclass<ParentOwnerType>(newMapper , this.zGetValueSelector() );
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
			return MaritalStatusFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return MaritalStatusFinder.getMithraObjectPortal();
		}
	}

	public static class MaritalStatusCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends MaritalStatusRelatedFinder<ParentOwnerType, ReturnType, MaritalStatusList, OwnerType>
	{
		public MaritalStatusCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class MaritalStatusCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends MaritalStatusCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public MaritalStatusCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class MaritalStatusSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends MaritalStatusRelatedFinder<ParentOwnerType, ReturnType, MaritalStatusList, OwnerType>
	implements ToOneFinder
	{
		public MaritalStatusSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public MaritalStatusSingleFinder()
		{
			super(null);
		}

		public Operation eq(MaritalStatus other)
		{
			return this.maritalStatusId().eq(other.getMaritalStatusId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public MaritalStatus findByPrimaryKey(int maritalStatusId)
		{
			MaritalStatus _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(maritalStatusId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (MaritalStatus) _related;
			if (_related == null)
			{
				_op = this.maritalStatusId().eq(maritalStatusId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class MaritalStatusSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends MaritalStatusSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public MaritalStatusSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to MARITAL_STATUS.MARITAL_STATUS_ID **/
	public static IntegerAttribute<MaritalStatus> maritalStatusId()
	{
		return finder.maritalStatusId();
	}

	/** maps to MARITAL_STATUS.MARITAL_STATUS_VALUE **/
	public static StringAttribute<MaritalStatus> maritalStatusValue()
	{
		return finder.maritalStatusValue();
	}

	public static PersonFinder.PersonCollectionFinderForRelatedClasses<MaritalStatus, PersonList, MaritalStatus> people()
	{
		return finder.people();
	}

	public static class MaritalStatusPeopleFinderSubclass<ParentOwnerType> extends PersonFinder.PersonCollectionFinderForRelatedClasses<ParentOwnerType, PersonList, MaritalStatus>
	{
		public MaritalStatusPeopleFinderSubclass(Mapper mapper, NormalAndListValueSelector parentSelector )
		{
			super(mapper);
			this._parentSelector = (AbstractRelatedFinder) parentSelector;
			this._orderBy = null;
			this._type = SIMPLE_TO_MANY;
			this._name = "people";
		}

		public DeepRelationshipAttribute copy()
		{
			return new MaritalStatusPeopleFinderSubclass(zGetMapper(), (NormalAndListValueSelector) this._parentSelector
			);
		}

		protected PersonList plainValueOf(MaritalStatus _obj)
		{
			return _obj.getPeople();
		}

		protected PersonList plainListValueOf(Object _obj)
		{
			return ((MaritalStatusList)_obj).getPeople();
		}
	}

	public static Operation eq(MaritalStatus other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(maritalStatusId());
	}

	public static MaritalStatusSingleFinder<MaritalStatus, Object, MaritalStatus> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			maritalStatusId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			maritalStatusId()
			, maritalStatusId()
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
		objectPortal = new UninitializedPortal("tracker.domain.MaritalStatus");
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
