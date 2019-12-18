
package com.doublechaintech.oms.userorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.oms.OmsNamingServiceDAO;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.AccessKey;
import com.doublechaintech.oms.DateKey;
import com.doublechaintech.oms.StatsInfo;
import com.doublechaintech.oms.StatsItem;

import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;


import com.doublechaintech.oms.paymentgroup.PaymentGroup;
import com.doublechaintech.oms.lineitem.LineItem;
import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.orderpromotion.OrderPromotion;
import com.doublechaintech.oms.manualadjustment.ManualAdjustment;
import com.doublechaintech.oms.shippinggroup.ShippingGroup;
import com.doublechaintech.oms.platform.Platform;

import com.doublechaintech.oms.paymentgroup.PaymentGroupDAO;
import com.doublechaintech.oms.platform.PlatformDAO;
import com.doublechaintech.oms.orderpromotion.OrderPromotionDAO;
import com.doublechaintech.oms.manualadjustment.ManualAdjustmentDAO;
import com.doublechaintech.oms.shippinggroup.ShippingGroupDAO;
import com.doublechaintech.oms.profile.ProfileDAO;
import com.doublechaintech.oms.lineitem.LineItemDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class UserOrderJDBCTemplateDAO extends OmsNamingServiceDAO implements UserOrderDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  LineItemDAO  lineItemDAO;
 	public void setLineItemDAO(LineItemDAO pLineItemDAO){
 	
 		if(pLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set lineItemDAO to null.");
 		}
	 	this.lineItemDAO = pLineItemDAO;
 	}
 	public LineItemDAO getLineItemDAO(){
 		if(this.lineItemDAO == null){
 			throw new IllegalStateException("The lineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.lineItemDAO;
 	}	
 	
			
		
	
  	private  OrderPromotionDAO  orderPromotionDAO;
 	public void setOrderPromotionDAO(OrderPromotionDAO pOrderPromotionDAO){
 	
 		if(pOrderPromotionDAO == null){
 			throw new IllegalStateException("Do not try to set orderPromotionDAO to null.");
 		}
	 	this.orderPromotionDAO = pOrderPromotionDAO;
 	}
 	public OrderPromotionDAO getOrderPromotionDAO(){
 		if(this.orderPromotionDAO == null){
 			throw new IllegalStateException("The orderPromotionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderPromotionDAO;
 	}	
 	
			
		
	
  	private  ManualAdjustmentDAO  manualAdjustmentDAO;
 	public void setManualAdjustmentDAO(ManualAdjustmentDAO pManualAdjustmentDAO){
 	
 		if(pManualAdjustmentDAO == null){
 			throw new IllegalStateException("Do not try to set manualAdjustmentDAO to null.");
 		}
	 	this.manualAdjustmentDAO = pManualAdjustmentDAO;
 	}
 	public ManualAdjustmentDAO getManualAdjustmentDAO(){
 		if(this.manualAdjustmentDAO == null){
 			throw new IllegalStateException("The manualAdjustmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.manualAdjustmentDAO;
 	}	
 	
			
		
	
  	private  ShippingGroupDAO  shippingGroupDAO;
 	public void setShippingGroupDAO(ShippingGroupDAO pShippingGroupDAO){
 	
 		if(pShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set shippingGroupDAO to null.");
 		}
	 	this.shippingGroupDAO = pShippingGroupDAO;
 	}
 	public ShippingGroupDAO getShippingGroupDAO(){
 		if(this.shippingGroupDAO == null){
 			throw new IllegalStateException("The shippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingGroupDAO;
 	}	
 	
			
		
	
  	private  PaymentGroupDAO  paymentGroupDAO;
 	public void setPaymentGroupDAO(PaymentGroupDAO pPaymentGroupDAO){
 	
 		if(pPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set paymentGroupDAO to null.");
 		}
	 	this.paymentGroupDAO = pPaymentGroupDAO;
 	}
 	public PaymentGroupDAO getPaymentGroupDAO(){
 		if(this.paymentGroupDAO == null){
 			throw new IllegalStateException("The paymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.paymentGroupDAO;
 	}	
 	
			
		

	
	/*
	protected UserOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserOrder(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserOrder(UserOrderTable.withId(id), options);
	}
	
	
	
	public UserOrder save(UserOrder userOrder,Map<String,Object> options){
		
		String methodName="save(UserOrder userOrder,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userOrder, methodName, "userOrder");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserOrder(userOrder,options);
	}
	public UserOrder clone(String userOrderId, Map<String,Object> options) throws Exception{
	
		return clone(UserOrderTable.withId(userOrderId),options);
	}
	
	protected UserOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userOrderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserOrder newUserOrder = loadInternalUserOrder(accessKey, options);
		newUserOrder.setVersion(0);
		
		
 		
 		if(isSaveLineItemListEnabled(options)){
 			for(LineItem item: newUserOrder.getLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveOrderPromotionListEnabled(options)){
 			for(OrderPromotion item: newUserOrder.getOrderPromotionList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveManualAdjustmentListEnabled(options)){
 			for(ManualAdjustment item: newUserOrder.getManualAdjustmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveShippingGroupListEnabled(options)){
 			for(ShippingGroup item: newUserOrder.getShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePaymentGroupListEnabled(options)){
 			for(PaymentGroup item: newUserOrder.getPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserOrder(newUserOrder,options);
		
		return newUserOrder;
	}
	
	
	
	

	protected void throwIfHasException(String userOrderId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserOrderNotFoundException(
					"The " + this.getTableName() + "(" + userOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userOrderId, int version) throws Exception{
	
		String methodName="delete(String userOrderId, int version)";
		assertMethodArgumentNotNull(userOrderId, methodName, "userOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userOrderId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userOrderId,version);
		}
		
	
	}
	
	
	
	
	

	public UserOrder disconnectFromAll(String userOrderId, int version) throws Exception{
	
		
		UserOrder userOrder = loadInternalUserOrder(UserOrderTable.withId(userOrderId), emptyOptions());
		userOrder.clearFromAll();
		this.saveUserOrder(userOrder);
		return userOrder;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_order";
	}
	@Override
	protected String getBeanName() {
		
		return "userOrder";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserOrderTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserOrderTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserOrderTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserOrderTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserOrderTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractLineItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserOrderTokens.LINE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeLineItemListEnabled(Map<String,Object> options){		 		
 		return UserOrderTokens.of(options).analyzeLineItemListEnabled();
 	}
	
	protected boolean isSaveLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, UserOrderTokens.LINE_ITEM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractOrderPromotionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserOrderTokens.ORDER_PROMOTION_LIST);
 	}
 	protected boolean isAnalyzeOrderPromotionListEnabled(Map<String,Object> options){		 		
 		return UserOrderTokens.of(options).analyzeOrderPromotionListEnabled();
 	}
	
	protected boolean isSaveOrderPromotionListEnabled(Map<String,Object> options){
		return checkOptions(options, UserOrderTokens.ORDER_PROMOTION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractManualAdjustmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserOrderTokens.MANUAL_ADJUSTMENT_LIST);
 	}
 	protected boolean isAnalyzeManualAdjustmentListEnabled(Map<String,Object> options){		 		
 		return UserOrderTokens.of(options).analyzeManualAdjustmentListEnabled();
 	}
	
	protected boolean isSaveManualAdjustmentListEnabled(Map<String,Object> options){
		return checkOptions(options, UserOrderTokens.MANUAL_ADJUSTMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractShippingGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserOrderTokens.SHIPPING_GROUP_LIST);
 	}
 	protected boolean isAnalyzeShippingGroupListEnabled(Map<String,Object> options){		 		
 		return UserOrderTokens.of(options).analyzeShippingGroupListEnabled();
 	}
	
	protected boolean isSaveShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, UserOrderTokens.SHIPPING_GROUP_LIST);
		
 	}
 	
		
	
	protected boolean isExtractPaymentGroupListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserOrderTokens.PAYMENT_GROUP_LIST);
 	}
 	protected boolean isAnalyzePaymentGroupListEnabled(Map<String,Object> options){		 		
 		return UserOrderTokens.of(options).analyzePaymentGroupListEnabled();
 	}
	
	protected boolean isSavePaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, UserOrderTokens.PAYMENT_GROUP_LIST);
		
 	}
 	
		

	

	protected UserOrderMapper getUserOrderMapper(){
		return new UserOrderMapper();
	}

	
	
	protected UserOrder extractUserOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserOrder userOrder = loadSingleObject(accessKey, getUserOrderMapper());
			return userOrder;
		}catch(EmptyResultDataAccessException e){
			throw new UserOrderNotFoundException("UserOrder("+accessKey+") is not found!");
		}

	}

	
	

	protected UserOrder loadInternalUserOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserOrder userOrder = extractUserOrder(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(userOrder, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(userOrder, loadOptions);
 		}
 
		
		if(isExtractLineItemListEnabled(loadOptions)){
	 		extractLineItemList(userOrder, loadOptions);
 		}	
 		if(isAnalyzeLineItemListEnabled(loadOptions)){
	 		analyzeLineItemList(userOrder, loadOptions);
 		}
 		
		
		if(isExtractOrderPromotionListEnabled(loadOptions)){
	 		extractOrderPromotionList(userOrder, loadOptions);
 		}	
 		if(isAnalyzeOrderPromotionListEnabled(loadOptions)){
	 		analyzeOrderPromotionList(userOrder, loadOptions);
 		}
 		
		
		if(isExtractManualAdjustmentListEnabled(loadOptions)){
	 		extractManualAdjustmentList(userOrder, loadOptions);
 		}	
 		if(isAnalyzeManualAdjustmentListEnabled(loadOptions)){
	 		analyzeManualAdjustmentList(userOrder, loadOptions);
 		}
 		
		
		if(isExtractShippingGroupListEnabled(loadOptions)){
	 		extractShippingGroupList(userOrder, loadOptions);
 		}	
 		if(isAnalyzeShippingGroupListEnabled(loadOptions)){
	 		analyzeShippingGroupList(userOrder, loadOptions);
 		}
 		
		
		if(isExtractPaymentGroupListEnabled(loadOptions)){
	 		extractPaymentGroupList(userOrder, loadOptions);
 		}	
 		if(isAnalyzePaymentGroupListEnabled(loadOptions)){
	 		analyzePaymentGroupList(userOrder, loadOptions);
 		}
 		
		
		return userOrder;
		
	}

	 

 	protected UserOrder extractUser(UserOrder userOrder, Map<String,Object> options) throws Exception{

		if(userOrder.getUser() == null){
			return userOrder;
		}
		String userId = userOrder.getUser().getId();
		if( userId == null){
			return userOrder;
		}
		Profile user = getProfileDAO().load(userId,options);
		if(user != null){
			userOrder.setUser(user);
		}
		
 		
 		return userOrder;
 	}
 		
  

 	protected UserOrder extractPlatform(UserOrder userOrder, Map<String,Object> options) throws Exception{

		if(userOrder.getPlatform() == null){
			return userOrder;
		}
		String platformId = userOrder.getPlatform().getId();
		if( platformId == null){
			return userOrder;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			userOrder.setPlatform(platform);
		}
		
 		
 		return userOrder;
 	}
 		
 
		
	protected void enhanceLineItemList(SmartList<LineItem> lineItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserOrder extractLineItemList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<LineItem> lineItemList = getLineItemDAO().findLineItemByUserOrder(userOrder.getId(),options);
		if(lineItemList != null){
			enhanceLineItemList(lineItemList,options);
			userOrder.setLineItemList(lineItemList);
		}
		
		return userOrder;
	
	}	
	
	protected UserOrder analyzeLineItemList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<LineItem> lineItemList = userOrder.getLineItemList();
		if(lineItemList != null){
			getLineItemDAO().analyzeLineItemByUserOrder(lineItemList, userOrder.getId(), options);
			
		}
		
		return userOrder;
	
	}	
	
		
	protected void enhanceOrderPromotionList(SmartList<OrderPromotion> orderPromotionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserOrder extractOrderPromotionList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<OrderPromotion> orderPromotionList = getOrderPromotionDAO().findOrderPromotionByUserOrder(userOrder.getId(),options);
		if(orderPromotionList != null){
			enhanceOrderPromotionList(orderPromotionList,options);
			userOrder.setOrderPromotionList(orderPromotionList);
		}
		
		return userOrder;
	
	}	
	
	protected UserOrder analyzeOrderPromotionList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<OrderPromotion> orderPromotionList = userOrder.getOrderPromotionList();
		if(orderPromotionList != null){
			getOrderPromotionDAO().analyzeOrderPromotionByUserOrder(orderPromotionList, userOrder.getId(), options);
			
		}
		
		return userOrder;
	
	}	
	
		
	protected void enhanceManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserOrder extractManualAdjustmentList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<ManualAdjustment> manualAdjustmentList = getManualAdjustmentDAO().findManualAdjustmentByUserOrder(userOrder.getId(),options);
		if(manualAdjustmentList != null){
			enhanceManualAdjustmentList(manualAdjustmentList,options);
			userOrder.setManualAdjustmentList(manualAdjustmentList);
		}
		
		return userOrder;
	
	}	
	
	protected UserOrder analyzeManualAdjustmentList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<ManualAdjustment> manualAdjustmentList = userOrder.getManualAdjustmentList();
		if(manualAdjustmentList != null){
			getManualAdjustmentDAO().analyzeManualAdjustmentByUserOrder(manualAdjustmentList, userOrder.getId(), options);
			
		}
		
		return userOrder;
	
	}	
	
		
	protected void enhanceShippingGroupList(SmartList<ShippingGroup> shippingGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserOrder extractShippingGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<ShippingGroup> shippingGroupList = getShippingGroupDAO().findShippingGroupByUserOrder(userOrder.getId(),options);
		if(shippingGroupList != null){
			enhanceShippingGroupList(shippingGroupList,options);
			userOrder.setShippingGroupList(shippingGroupList);
		}
		
		return userOrder;
	
	}	
	
	protected UserOrder analyzeShippingGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<ShippingGroup> shippingGroupList = userOrder.getShippingGroupList();
		if(shippingGroupList != null){
			getShippingGroupDAO().analyzeShippingGroupByUserOrder(shippingGroupList, userOrder.getId(), options);
			
		}
		
		return userOrder;
	
	}	
	
		
	protected void enhancePaymentGroupList(SmartList<PaymentGroup> paymentGroupList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserOrder extractPaymentGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<PaymentGroup> paymentGroupList = getPaymentGroupDAO().findPaymentGroupByUserOrder(userOrder.getId(),options);
		if(paymentGroupList != null){
			enhancePaymentGroupList(paymentGroupList,options);
			userOrder.setPaymentGroupList(paymentGroupList);
		}
		
		return userOrder;
	
	}	
	
	protected UserOrder analyzePaymentGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		if(userOrder == null){
			return null;
		}
		if(userOrder.getId() == null){
			return userOrder;
		}

		
		
		SmartList<PaymentGroup> paymentGroupList = userOrder.getPaymentGroupList();
		if(paymentGroupList != null){
			getPaymentGroupDAO().analyzePaymentGroupByUserOrder(paymentGroupList, userOrder.getId(), options);
			
		}
		
		return userOrder;
	
	}	
	
		
		
  	
 	public SmartList<UserOrder> findUserOrderByUser(String profileId,Map<String,Object> options){
 	
  		SmartList<UserOrder> resultList = queryWith(UserOrderTable.COLUMN_USER, profileId, options, getUserOrderMapper());
		// analyzeUserOrderByUser(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserOrder> findUserOrderByUser(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserOrder> resultList =  queryWithRange(UserOrderTable.COLUMN_USER, profileId, options, getUserOrderMapper(), start, count);
 		//analyzeUserOrderByUser(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserOrderByUser(SmartList<UserOrder> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserOrder.USER_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//UserOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("User Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(UserOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(UserOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserOrderByUser(String profileId,Map<String,Object> options){

 		return countWith(UserOrderTable.COLUMN_USER, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countUserOrderByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserOrderTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<UserOrder> resultList = queryWith(UserOrderTable.COLUMN_PLATFORM, platformId, options, getUserOrderMapper());
		// analyzeUserOrderByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserOrder> resultList =  queryWithRange(UserOrderTable.COLUMN_PLATFORM, platformId, options, getUserOrderMapper(), start, count);
 		//analyzeUserOrderByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserOrderByPlatform(SmartList<UserOrder> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserOrder.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//UserOrder.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("User Order");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(UserOrder.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(UserOrder.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserOrderByPlatform(String platformId,Map<String,Object> options){

 		return countWith(UserOrderTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countUserOrderByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserOrderTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected UserOrder saveUserOrder(UserOrder  userOrder){
		
		if(!userOrder.isChanged()){
			return userOrder;
		}
		
		
		String SQL=this.getSaveUserOrderSQL(userOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserOrderParameters(userOrder);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userOrder.incVersion();
		return userOrder;
	
	}
	public SmartList<UserOrder> saveUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserOrderList(userOrderList);
		
		batchUserOrderCreate((List<UserOrder>)lists[CREATE_LIST_INDEX]);
		
		batchUserOrderUpdate((List<UserOrder>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserOrder userOrder:userOrderList){
			if(userOrder.isChanged()){
				userOrder.incVersion();
			}
			
		
		}
		
		
		return userOrderList;
	}

	public SmartList<UserOrder> removeUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options){
		
		
		super.removeList(userOrderList, options);
		
		return userOrderList;
		
		
	}
	
	protected List<Object[]> prepareUserOrderBatchCreateArgs(List<UserOrder> userOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserOrder userOrder:userOrderList ){
			Object [] parameters = prepareUserOrderCreateParameters(userOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserOrderBatchUpdateArgs(List<UserOrder> userOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserOrder userOrder:userOrderList ){
			if(!userOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserOrderUpdateParameters(userOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserOrderCreate(List<UserOrder> userOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserOrderBatchCreateArgs(userOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserOrderUpdate(List<UserOrder> userOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserOrderBatchUpdateArgs(userOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserOrderList(List<UserOrder> userOrderList){
		
		List<UserOrder> userOrderCreateList=new ArrayList<UserOrder>();
		List<UserOrder> userOrderUpdateList=new ArrayList<UserOrder>();
		
		for(UserOrder userOrder: userOrderList){
			if(isUpdateRequest(userOrder)){
				userOrderUpdateList.add( userOrder);
				continue;
			}
			userOrderCreateList.add(userOrder);
		}
		
		return new Object[]{userOrderCreateList,userOrderUpdateList};
	}
	
	protected boolean isUpdateRequest(UserOrder userOrder){
 		return userOrder.getVersion() > 0;
 	}
 	protected String getSaveUserOrderSQL(UserOrder userOrder){
 		if(isUpdateRequest(userOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserOrderParameters(UserOrder userOrder){
 		if(isUpdateRequest(userOrder) ){
 			return prepareUserOrderUpdateParameters(userOrder);
 		}
 		return prepareUserOrderCreateParameters(userOrder);
 	}
 	protected Object[] prepareUserOrderUpdateParameters(UserOrder userOrder){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = userOrder.getTitle();
 		parameters[1] = userOrder.getTotalAdjustment();
 		parameters[2] = userOrder.getTotalAmount(); 	
 		if(userOrder.getUser() != null){
 			parameters[3] = userOrder.getUser().getId();
 		}
  	
 		if(userOrder.getPlatform() != null){
 			parameters[4] = userOrder.getPlatform().getId();
 		}
 
 		parameters[5] = userOrder.getLastUpdateTime();		
 		parameters[6] = userOrder.nextVersion();
 		parameters[7] = userOrder.getId();
 		parameters[8] = userOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserOrderCreateParameters(UserOrder userOrder){
		Object[] parameters = new Object[7];
		String newUserOrderId=getNextId();
		userOrder.setId(newUserOrderId);
		parameters[0] =  userOrder.getId();
 
 		parameters[1] = userOrder.getTitle();
 		parameters[2] = userOrder.getTotalAdjustment();
 		parameters[3] = userOrder.getTotalAmount(); 	
 		if(userOrder.getUser() != null){
 			parameters[4] = userOrder.getUser().getId();
 		
 		}
 		 	
 		if(userOrder.getPlatform() != null){
 			parameters[5] = userOrder.getPlatform().getId();
 		
 		}
 		
 		parameters[6] = userOrder.getLastUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected UserOrder saveInternalUserOrder(UserOrder userOrder, Map<String,Object> options){
		
		saveUserOrder(userOrder);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(userOrder, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(userOrder, options);
 		}
 
		
		if(isSaveLineItemListEnabled(options)){
	 		saveLineItemList(userOrder, options);
	 		//removeLineItemList(userOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveOrderPromotionListEnabled(options)){
	 		saveOrderPromotionList(userOrder, options);
	 		//removeOrderPromotionList(userOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveManualAdjustmentListEnabled(options)){
	 		saveManualAdjustmentList(userOrder, options);
	 		//removeManualAdjustmentList(userOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveShippingGroupListEnabled(options)){
	 		saveShippingGroupList(userOrder, options);
	 		//removeShippingGroupList(userOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSavePaymentGroupListEnabled(options)){
	 		savePaymentGroupList(userOrder, options);
	 		//removePaymentGroupList(userOrder, options);
	 		//Not delete the record
	 		
 		}		
		
		return userOrder;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserOrder saveUser(UserOrder userOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userOrder.getUser() == null){
 			return userOrder;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(userOrder.getUser(),options);
 		return userOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected UserOrder savePlatform(UserOrder userOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userOrder.getPlatform() == null){
 			return userOrder;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(userOrder.getPlatform(),options);
 		return userOrder;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public UserOrder planToRemoveLineItemList(UserOrder userOrder, String lineItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LineItem.USER_ORDER_PROPERTY, userOrder.getId());
		key.put(LineItem.ID_PROPERTY, lineItemIds);
		
		SmartList<LineItem> externalLineItemList = getLineItemDAO().
				findLineItemWithKey(key, options);
		if(externalLineItemList == null){
			return userOrder;
		}
		if(externalLineItemList.isEmpty()){
			return userOrder;
		}
		
		for(LineItem lineItem: externalLineItemList){

			lineItem.clearFromAll();
		}
		
		
		SmartList<LineItem> lineItemList = userOrder.getLineItemList();		
		lineItemList.addAllToRemoveList(externalLineItemList);
		return userOrder;	
	
	}


	public UserOrder planToRemoveOrderPromotionList(UserOrder userOrder, String orderPromotionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OrderPromotion.USER_ORDER_PROPERTY, userOrder.getId());
		key.put(OrderPromotion.ID_PROPERTY, orderPromotionIds);
		
		SmartList<OrderPromotion> externalOrderPromotionList = getOrderPromotionDAO().
				findOrderPromotionWithKey(key, options);
		if(externalOrderPromotionList == null){
			return userOrder;
		}
		if(externalOrderPromotionList.isEmpty()){
			return userOrder;
		}
		
		for(OrderPromotion orderPromotion: externalOrderPromotionList){

			orderPromotion.clearFromAll();
		}
		
		
		SmartList<OrderPromotion> orderPromotionList = userOrder.getOrderPromotionList();		
		orderPromotionList.addAllToRemoveList(externalOrderPromotionList);
		return userOrder;	
	
	}


	public UserOrder planToRemoveManualAdjustmentList(UserOrder userOrder, String manualAdjustmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ManualAdjustment.USER_ORDER_PROPERTY, userOrder.getId());
		key.put(ManualAdjustment.ID_PROPERTY, manualAdjustmentIds);
		
		SmartList<ManualAdjustment> externalManualAdjustmentList = getManualAdjustmentDAO().
				findManualAdjustmentWithKey(key, options);
		if(externalManualAdjustmentList == null){
			return userOrder;
		}
		if(externalManualAdjustmentList.isEmpty()){
			return userOrder;
		}
		
		for(ManualAdjustment manualAdjustment: externalManualAdjustmentList){

			manualAdjustment.clearFromAll();
		}
		
		
		SmartList<ManualAdjustment> manualAdjustmentList = userOrder.getManualAdjustmentList();		
		manualAdjustmentList.addAllToRemoveList(externalManualAdjustmentList);
		return userOrder;	
	
	}


	public UserOrder planToRemoveShippingGroupList(UserOrder userOrder, String shippingGroupIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ShippingGroup.USER_ORDER_PROPERTY, userOrder.getId());
		key.put(ShippingGroup.ID_PROPERTY, shippingGroupIds);
		
		SmartList<ShippingGroup> externalShippingGroupList = getShippingGroupDAO().
				findShippingGroupWithKey(key, options);
		if(externalShippingGroupList == null){
			return userOrder;
		}
		if(externalShippingGroupList.isEmpty()){
			return userOrder;
		}
		
		for(ShippingGroup shippingGroup: externalShippingGroupList){

			shippingGroup.clearFromAll();
		}
		
		
		SmartList<ShippingGroup> shippingGroupList = userOrder.getShippingGroupList();		
		shippingGroupList.addAllToRemoveList(externalShippingGroupList);
		return userOrder;	
	
	}


	public UserOrder planToRemovePaymentGroupList(UserOrder userOrder, String paymentGroupIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PaymentGroup.USER_ORDER_PROPERTY, userOrder.getId());
		key.put(PaymentGroup.ID_PROPERTY, paymentGroupIds);
		
		SmartList<PaymentGroup> externalPaymentGroupList = getPaymentGroupDAO().
				findPaymentGroupWithKey(key, options);
		if(externalPaymentGroupList == null){
			return userOrder;
		}
		if(externalPaymentGroupList.isEmpty()){
			return userOrder;
		}
		
		for(PaymentGroup paymentGroup: externalPaymentGroupList){

			paymentGroup.clearFromAll();
		}
		
		
		SmartList<PaymentGroup> paymentGroupList = userOrder.getPaymentGroupList();		
		paymentGroupList.addAllToRemoveList(externalPaymentGroupList);
		return userOrder;	
	
	}



		
	protected UserOrder saveLineItemList(UserOrder userOrder, Map<String,Object> options){
		
		
		
		
		SmartList<LineItem> lineItemList = userOrder.getLineItemList();
		if(lineItemList == null){
			//null list means nothing
			return userOrder;
		}
		SmartList<LineItem> mergedUpdateLineItemList = new SmartList<LineItem>();
		
		
		mergedUpdateLineItemList.addAll(lineItemList); 
		if(lineItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLineItemList.addAll(lineItemList.getToRemoveList());
			lineItemList.removeAll(lineItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLineItemDAO().saveLineItemList(mergedUpdateLineItemList,options);
		
		if(lineItemList.getToRemoveList() != null){
			lineItemList.removeAll(lineItemList.getToRemoveList());
		}
		
		
		return userOrder;
	
	}
	
	protected UserOrder removeLineItemList(UserOrder userOrder, Map<String,Object> options){
	
	
		SmartList<LineItem> lineItemList = userOrder.getLineItemList();
		if(lineItemList == null){
			return userOrder;
		}	
	
		SmartList<LineItem> toRemoveLineItemList = lineItemList.getToRemoveList();
		
		if(toRemoveLineItemList == null){
			return userOrder;
		}
		if(toRemoveLineItemList.isEmpty()){
			return userOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLineItemDAO().removeLineItemList(toRemoveLineItemList,options);
		
		return userOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserOrder saveOrderPromotionList(UserOrder userOrder, Map<String,Object> options){
		
		
		
		
		SmartList<OrderPromotion> orderPromotionList = userOrder.getOrderPromotionList();
		if(orderPromotionList == null){
			//null list means nothing
			return userOrder;
		}
		SmartList<OrderPromotion> mergedUpdateOrderPromotionList = new SmartList<OrderPromotion>();
		
		
		mergedUpdateOrderPromotionList.addAll(orderPromotionList); 
		if(orderPromotionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateOrderPromotionList.addAll(orderPromotionList.getToRemoveList());
			orderPromotionList.removeAll(orderPromotionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getOrderPromotionDAO().saveOrderPromotionList(mergedUpdateOrderPromotionList,options);
		
		if(orderPromotionList.getToRemoveList() != null){
			orderPromotionList.removeAll(orderPromotionList.getToRemoveList());
		}
		
		
		return userOrder;
	
	}
	
	protected UserOrder removeOrderPromotionList(UserOrder userOrder, Map<String,Object> options){
	
	
		SmartList<OrderPromotion> orderPromotionList = userOrder.getOrderPromotionList();
		if(orderPromotionList == null){
			return userOrder;
		}	
	
		SmartList<OrderPromotion> toRemoveOrderPromotionList = orderPromotionList.getToRemoveList();
		
		if(toRemoveOrderPromotionList == null){
			return userOrder;
		}
		if(toRemoveOrderPromotionList.isEmpty()){
			return userOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOrderPromotionDAO().removeOrderPromotionList(toRemoveOrderPromotionList,options);
		
		return userOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserOrder saveManualAdjustmentList(UserOrder userOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ManualAdjustment> manualAdjustmentList = userOrder.getManualAdjustmentList();
		if(manualAdjustmentList == null){
			//null list means nothing
			return userOrder;
		}
		SmartList<ManualAdjustment> mergedUpdateManualAdjustmentList = new SmartList<ManualAdjustment>();
		
		
		mergedUpdateManualAdjustmentList.addAll(manualAdjustmentList); 
		if(manualAdjustmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateManualAdjustmentList.addAll(manualAdjustmentList.getToRemoveList());
			manualAdjustmentList.removeAll(manualAdjustmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getManualAdjustmentDAO().saveManualAdjustmentList(mergedUpdateManualAdjustmentList,options);
		
		if(manualAdjustmentList.getToRemoveList() != null){
			manualAdjustmentList.removeAll(manualAdjustmentList.getToRemoveList());
		}
		
		
		return userOrder;
	
	}
	
	protected UserOrder removeManualAdjustmentList(UserOrder userOrder, Map<String,Object> options){
	
	
		SmartList<ManualAdjustment> manualAdjustmentList = userOrder.getManualAdjustmentList();
		if(manualAdjustmentList == null){
			return userOrder;
		}	
	
		SmartList<ManualAdjustment> toRemoveManualAdjustmentList = manualAdjustmentList.getToRemoveList();
		
		if(toRemoveManualAdjustmentList == null){
			return userOrder;
		}
		if(toRemoveManualAdjustmentList.isEmpty()){
			return userOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getManualAdjustmentDAO().removeManualAdjustmentList(toRemoveManualAdjustmentList,options);
		
		return userOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserOrder saveShippingGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		
		
		SmartList<ShippingGroup> shippingGroupList = userOrder.getShippingGroupList();
		if(shippingGroupList == null){
			//null list means nothing
			return userOrder;
		}
		SmartList<ShippingGroup> mergedUpdateShippingGroupList = new SmartList<ShippingGroup>();
		
		
		mergedUpdateShippingGroupList.addAll(shippingGroupList); 
		if(shippingGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateShippingGroupList.addAll(shippingGroupList.getToRemoveList());
			shippingGroupList.removeAll(shippingGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getShippingGroupDAO().saveShippingGroupList(mergedUpdateShippingGroupList,options);
		
		if(shippingGroupList.getToRemoveList() != null){
			shippingGroupList.removeAll(shippingGroupList.getToRemoveList());
		}
		
		
		return userOrder;
	
	}
	
	protected UserOrder removeShippingGroupList(UserOrder userOrder, Map<String,Object> options){
	
	
		SmartList<ShippingGroup> shippingGroupList = userOrder.getShippingGroupList();
		if(shippingGroupList == null){
			return userOrder;
		}	
	
		SmartList<ShippingGroup> toRemoveShippingGroupList = shippingGroupList.getToRemoveList();
		
		if(toRemoveShippingGroupList == null){
			return userOrder;
		}
		if(toRemoveShippingGroupList.isEmpty()){
			return userOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getShippingGroupDAO().removeShippingGroupList(toRemoveShippingGroupList,options);
		
		return userOrder;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserOrder savePaymentGroupList(UserOrder userOrder, Map<String,Object> options){
		
		
		
		
		SmartList<PaymentGroup> paymentGroupList = userOrder.getPaymentGroupList();
		if(paymentGroupList == null){
			//null list means nothing
			return userOrder;
		}
		SmartList<PaymentGroup> mergedUpdatePaymentGroupList = new SmartList<PaymentGroup>();
		
		
		mergedUpdatePaymentGroupList.addAll(paymentGroupList); 
		if(paymentGroupList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePaymentGroupList.addAll(paymentGroupList.getToRemoveList());
			paymentGroupList.removeAll(paymentGroupList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getPaymentGroupDAO().savePaymentGroupList(mergedUpdatePaymentGroupList,options);
		
		if(paymentGroupList.getToRemoveList() != null){
			paymentGroupList.removeAll(paymentGroupList.getToRemoveList());
		}
		
		
		return userOrder;
	
	}
	
	protected UserOrder removePaymentGroupList(UserOrder userOrder, Map<String,Object> options){
	
	
		SmartList<PaymentGroup> paymentGroupList = userOrder.getPaymentGroupList();
		if(paymentGroupList == null){
			return userOrder;
		}	
	
		SmartList<PaymentGroup> toRemovePaymentGroupList = paymentGroupList.getToRemoveList();
		
		if(toRemovePaymentGroupList == null){
			return userOrder;
		}
		if(toRemovePaymentGroupList.isEmpty()){
			return userOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPaymentGroupDAO().removePaymentGroupList(toRemovePaymentGroupList,options);
		
		return userOrder;
	
	}
	
	

 	
 	
	
	
	
		

	public UserOrder present(UserOrder userOrder,Map<String, Object> options){
	
		presentLineItemList(userOrder,options);
		presentOrderPromotionList(userOrder,options);
		presentManualAdjustmentList(userOrder,options);
		presentShippingGroupList(userOrder,options);
		presentPaymentGroupList(userOrder,options);

		return userOrder;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected UserOrder presentLineItemList(
			UserOrder userOrder,
			Map<String, Object> options) {

		SmartList<LineItem> lineItemList = userOrder.getLineItemList();		
				SmartList<LineItem> newList= presentSubList(userOrder.getId(),
				lineItemList,
				options,
				getLineItemDAO()::countLineItemByUserOrder,
				getLineItemDAO()::findLineItemByUserOrder
				);

		
		userOrder.setLineItemList(newList);
		

		return userOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserOrder presentOrderPromotionList(
			UserOrder userOrder,
			Map<String, Object> options) {

		SmartList<OrderPromotion> orderPromotionList = userOrder.getOrderPromotionList();		
				SmartList<OrderPromotion> newList= presentSubList(userOrder.getId(),
				orderPromotionList,
				options,
				getOrderPromotionDAO()::countOrderPromotionByUserOrder,
				getOrderPromotionDAO()::findOrderPromotionByUserOrder
				);

		
		userOrder.setOrderPromotionList(newList);
		

		return userOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserOrder presentManualAdjustmentList(
			UserOrder userOrder,
			Map<String, Object> options) {

		SmartList<ManualAdjustment> manualAdjustmentList = userOrder.getManualAdjustmentList();		
				SmartList<ManualAdjustment> newList= presentSubList(userOrder.getId(),
				manualAdjustmentList,
				options,
				getManualAdjustmentDAO()::countManualAdjustmentByUserOrder,
				getManualAdjustmentDAO()::findManualAdjustmentByUserOrder
				);

		
		userOrder.setManualAdjustmentList(newList);
		

		return userOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserOrder presentShippingGroupList(
			UserOrder userOrder,
			Map<String, Object> options) {

		SmartList<ShippingGroup> shippingGroupList = userOrder.getShippingGroupList();		
				SmartList<ShippingGroup> newList= presentSubList(userOrder.getId(),
				shippingGroupList,
				options,
				getShippingGroupDAO()::countShippingGroupByUserOrder,
				getShippingGroupDAO()::findShippingGroupByUserOrder
				);

		
		userOrder.setShippingGroupList(newList);
		

		return userOrder;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserOrder presentPaymentGroupList(
			UserOrder userOrder,
			Map<String, Object> options) {

		SmartList<PaymentGroup> paymentGroupList = userOrder.getPaymentGroupList();		
				SmartList<PaymentGroup> newList= presentSubList(userOrder.getId(),
				paymentGroupList,
				options,
				getPaymentGroupDAO()::countPaymentGroupByUserOrder,
				getPaymentGroupDAO()::findPaymentGroupByUserOrder
				);

		
		userOrder.setPaymentGroupList(newList);
		

		return userOrder;
	}			
		

	
    public SmartList<UserOrder> requestCandidateUserOrderForLineItem(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserOrderMapper());
    }
		
    public SmartList<UserOrder> requestCandidateUserOrderForOrderPromotion(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserOrderMapper());
    }
		
    public SmartList<UserOrder> requestCandidateUserOrderForManualAdjustment(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserOrderMapper());
    }
		
    public SmartList<UserOrder> requestCandidateUserOrderForShippingGroup(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserOrderMapper());
    }
		
    public SmartList<UserOrder> requestCandidateUserOrderForPaymentGroup(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserOrderTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserOrderMapper());
    }
		

	protected String getTableName(){
		return UserOrderTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserOrder> userOrderList) {		
		this.enhanceListInternal(userOrderList, this.getUserOrderMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<UserOrder> userOrderList = ownerEntity.collectRefsWithType(UserOrder.INTERNAL_TYPE);
		this.enhanceList(userOrderList);
		
	}
	
	@Override
	public SmartList<UserOrder> findUserOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserOrderMapper());

	}
	@Override
	public int countUserOrderWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserOrder> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserOrderMapper());
	}
}


