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
public class LectureHallFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/mithraobjects/LectureHall";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.mithraobjects.LectureHall";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.mithraobjects.LectureHall");
	private static final LectureHallSingleFinder<LectureHall, Object, LectureHall> finder = new LectureHallSingleFinder<LectureHall, Object, LectureHall>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(LectureHallFinder.LectureHallRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("lectureHallId");
		finderMethodMap.addNormalAttributeName("hallName");
		finderMethodMap.addNormalAttributeName("capacity");
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

	public static LectureHall findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static LectureHall findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static LectureHallList findMany(com.gs.fw.finder.Operation operation)
	{
		return (LectureHallList) finder.findMany(operation);
	}

	public static LectureHallList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (LectureHallList) finder.findManyBypassCache(operation);
	}

	private static LectureHall findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (LectureHall) FinderUtils.findOne(found);
	}

	public static LectureHall findByPrimaryKey(int lectureHallId)
	{
		return finder.findByPrimaryKey(lectureHallId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			LectureHallData _castedTargetData = (LectureHallData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getLectureHallId())
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

	public static LectureHall zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (LectureHall) FinderUtils.findOne(found);
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

	public static class LectureHallRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<LectureHall, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> lectureHallId;
		private StringAttribute<ParentOwnerType> hallName;
		private IntegerAttribute<ParentOwnerType> capacity;
		public LectureHallRelatedFinder()
		{
			super();
		}

		public LectureHallRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.mithraobjects.LectureHallFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return LectureHallFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return LectureHallFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return LectureHallFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[3];
			attributes[0] = this.lectureHallId();
			attributes[1] = this.hallName();
			attributes[2] = this.capacity();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(0);
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

		public LectureHall findOne(com.gs.fw.finder.Operation operation)
		{
			return LectureHallFinder.findOne(operation, false);
		}

		public LectureHall findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return LectureHallFinder.findOne(operation, true);
		}

		public MithraList<? extends LectureHall> findMany(com.gs.fw.finder.Operation operation)
		{
			return new LectureHallList((Operation) operation);
		}

		public MithraList<? extends LectureHall> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			LectureHallList result = (LectureHallList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends LectureHall> constructEmptyList()
		{
			return new LectureHallList();
		}

		public int getSerialVersionId()
		{
			return -726763231;
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

		public IntegerAttribute<ParentOwnerType> lectureHallId()
		{
			IntegerAttribute<ParentOwnerType> result = this.lectureHallId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("HALL_ID","","lectureHallId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(LectureHallFinder.lectureHallId(), this.mapper, this.zGetValueSelector());
				this.lectureHallId = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> hallName()
		{
			StringAttribute<ParentOwnerType> result = this.hallName;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("HALL_NAME","","hallName",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(LectureHallFinder.hallName(), this.mapper, this.zGetValueSelector());
				this.hallName = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> capacity()
		{
			IntegerAttribute<ParentOwnerType> result = this.capacity;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("CAPACITY","","capacity",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(LectureHallFinder.capacity(), this.mapper, this.zGetValueSelector());
				this.capacity = result;
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
			return LectureHallFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return LectureHallFinder.getMithraObjectPortal();
		}
	}

	public static class LectureHallCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends LectureHallRelatedFinder<ParentOwnerType, ReturnType, LectureHallList, OwnerType>
	{
		public LectureHallCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class LectureHallCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends LectureHallCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public LectureHallCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class LectureHallSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends LectureHallRelatedFinder<ParentOwnerType, ReturnType, LectureHallList, OwnerType>
	implements ToOneFinder
	{
		public LectureHallSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public LectureHallSingleFinder()
		{
			super(null);
		}

		public Operation eq(LectureHall other)
		{
			return this.lectureHallId().eq(other.getLectureHallId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public LectureHall findByPrimaryKey(int lectureHallId)
		{
			LectureHall _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(lectureHallId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (LectureHall) _related;
			if (_related == null)
			{
				_op = this.lectureHallId().eq(lectureHallId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class LectureHallSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends LectureHallSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public LectureHallSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to LECTURE_HALLS.HALL_ID **/
	public static IntegerAttribute<LectureHall> lectureHallId()
	{
		return finder.lectureHallId();
	}

	/** maps to LECTURE_HALLS.HALL_NAME **/
	public static StringAttribute<LectureHall> hallName()
	{
		return finder.hallName();
	}

	/** maps to LECTURE_HALLS.CAPACITY **/
	public static IntegerAttribute<LectureHall> capacity()
	{
		return finder.capacity();
	}

	public static Operation eq(LectureHall other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(lectureHallId());
	}

	public static LectureHallSingleFinder<LectureHall, Object, LectureHall> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			lectureHallId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			lectureHallId()
			, lectureHallId()
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

		portal.setIndependent(true);
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

		portal.setIndependent(true);
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
		objectPortal = new UninitializedPortal("com.mithraobjects.LectureHall");
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
