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
public class ClassTimeSlotFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "com/mithraobjects/ClassTimeSlot";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "com.mithraobjects.ClassTimeSlot";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("com.mithraobjects.ClassTimeSlot");
	private static final ClassTimeSlotSingleFinder<ClassTimeSlot, Object, ClassTimeSlot> finder = new ClassTimeSlotSingleFinder<ClassTimeSlot, Object, ClassTimeSlot>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(ClassTimeSlotFinder.ClassTimeSlotRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("timeSlotId");
		finderMethodMap.addNormalAttributeName("startTime");
		finderMethodMap.addNormalAttributeName("endTime");
		finderMethodMap.addNormalAttributeName("day");
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

	public static ClassTimeSlot findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static ClassTimeSlot findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static ClassTimeSlotList findMany(com.gs.fw.finder.Operation operation)
	{
		return (ClassTimeSlotList) finder.findMany(operation);
	}

	public static ClassTimeSlotList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (ClassTimeSlotList) finder.findManyBypassCache(operation);
	}

	private static ClassTimeSlot findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (ClassTimeSlot) FinderUtils.findOne(found);
	}

	public static ClassTimeSlot findByPrimaryKey(int timeSlotId)
	{
		return finder.findByPrimaryKey(timeSlotId);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			ClassTimeSlotData _castedTargetData = (ClassTimeSlotData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getTimeSlotId())
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

	public static ClassTimeSlot zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (ClassTimeSlot) FinderUtils.findOne(found);
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

	public static class ClassTimeSlotRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<ClassTimeSlot, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> timeSlotId;
		private DateAttribute<ParentOwnerType> startTime;
		private DateAttribute<ParentOwnerType> endTime;
		private StringAttribute<ParentOwnerType> day;
		public ClassTimeSlotRelatedFinder()
		{
			super();
		}

		public ClassTimeSlotRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "com.mithraobjects.ClassTimeSlotFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return ClassTimeSlotFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return ClassTimeSlotFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.fw.common.mithra.extractor.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return ClassTimeSlotFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[4];
			attributes[0] = this.timeSlotId();
			attributes[1] = this.startTime();
			attributes[2] = this.endTime();
			attributes[3] = this.day();
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

		public ClassTimeSlot findOne(com.gs.fw.finder.Operation operation)
		{
			return ClassTimeSlotFinder.findOne(operation, false);
		}

		public ClassTimeSlot findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return ClassTimeSlotFinder.findOne(operation, true);
		}

		public MithraList<? extends ClassTimeSlot> findMany(com.gs.fw.finder.Operation operation)
		{
			return new ClassTimeSlotList((Operation) operation);
		}

		public MithraList<? extends ClassTimeSlot> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			ClassTimeSlotList result = (ClassTimeSlotList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends ClassTimeSlot> constructEmptyList()
		{
			return new ClassTimeSlotList();
		}

		public int getSerialVersionId()
		{
			return -1074105382;
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

		public IntegerAttribute<ParentOwnerType> timeSlotId()
		{
			IntegerAttribute<ParentOwnerType> result = this.timeSlotId;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("TIME_SLOT_ID","","timeSlotId",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(ClassTimeSlotFinder.timeSlotId(), this.mapper, this.zGetValueSelector());
				this.timeSlotId = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> startTime()
		{
			DateAttribute<ParentOwnerType> result = this.startTime;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("START_TIME","","startTime",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(ClassTimeSlotFinder.startTime(), this.mapper, this.zGetValueSelector());
				this.startTime = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> endTime()
		{
			DateAttribute<ParentOwnerType> result = this.endTime;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("END_TIME","","endTime",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(ClassTimeSlotFinder.endTime(), this.mapper, this.zGetValueSelector());
				this.endTime = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> day()
		{
			StringAttribute<ParentOwnerType> result = this.day;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("DAY","","day",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE,true, false) :
					new MappedStringAttribute(ClassTimeSlotFinder.day(), this.mapper, this.zGetValueSelector());
				this.day = result;
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
			return ClassTimeSlotFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return ClassTimeSlotFinder.getMithraObjectPortal();
		}
	}

	public static class ClassTimeSlotCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends ClassTimeSlotRelatedFinder<ParentOwnerType, ReturnType, ClassTimeSlotList, OwnerType>
	{
		public ClassTimeSlotCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class ClassTimeSlotCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends ClassTimeSlotCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public ClassTimeSlotCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class ClassTimeSlotSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends ClassTimeSlotRelatedFinder<ParentOwnerType, ReturnType, ClassTimeSlotList, OwnerType>
	implements ToOneFinder
	{
		public ClassTimeSlotSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public ClassTimeSlotSingleFinder()
		{
			super(null);
		}

		public Operation eq(ClassTimeSlot other)
		{
			return this.timeSlotId().eq(other.getTimeSlotId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public ClassTimeSlot findByPrimaryKey(int timeSlotId)
		{
			ClassTimeSlot _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(timeSlotId);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (ClassTimeSlot) _related;
			if (_related == null)
			{
				_op = this.timeSlotId().eq(timeSlotId);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class ClassTimeSlotSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends ClassTimeSlotSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public ClassTimeSlotSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to CLASS_TIME_SLOTS.TIME_SLOT_ID **/
	public static IntegerAttribute<ClassTimeSlot> timeSlotId()
	{
		return finder.timeSlotId();
	}

	/** maps to CLASS_TIME_SLOTS.START_TIME **/
	public static DateAttribute<ClassTimeSlot> startTime()
	{
		return finder.startTime();
	}

	/** maps to CLASS_TIME_SLOTS.END_TIME **/
	public static DateAttribute<ClassTimeSlot> endTime()
	{
		return finder.endTime();
	}

	/** maps to CLASS_TIME_SLOTS.DAY **/
	public static StringAttribute<ClassTimeSlot> day()
	{
		return finder.day();
	}

	public static Operation eq(ClassTimeSlot other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(timeSlotId());
	}

	public static ClassTimeSlotSingleFinder<ClassTimeSlot, Object, ClassTimeSlot> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			timeSlotId()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			timeSlotId()
			, timeSlotId()
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
		objectPortal = new UninitializedPortal("com.mithraobjects.ClassTimeSlot");
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
