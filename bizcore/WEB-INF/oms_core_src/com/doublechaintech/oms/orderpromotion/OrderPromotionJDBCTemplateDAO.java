
package com.doublechaintech.oms.orderpromotion;

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


import com.doublechaintech.oms.userorder.UserOrder;

import com.doublechaintech.oms.userorder.UserOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class OrderPromotionJDBCTemplateDAO extends OmsNamingServiceDAO implements OrderPromotionDAO{
 
 	
 	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO userOrderDAO){
	 	this.userOrderDAO = userOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
	 	return this.userOrderDAO;
 	}


			
		

	
	/*
	protected OrderPromotion load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOrderPromotion(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OrderPromotion load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOrderPromotion(OrderPromotionTable.withId(id), options);
	}
	
	
	
	public OrderPromotion save(OrderPromotion orderPromotion,Map<String,Object> options){
		
		String methodName="save(OrderPromotion orderPromotion,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(orderPromotion, methodName, "orderPromotion");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOrderPromotion(orderPromotion,options);
	}
	public OrderPromotion clone(String orderPromotionId, Map<String,Object> options) throws Exception{
	
		return clone(OrderPromotionTable.withId(orderPromotionId),options);
	}
	
	protected OrderPromotion clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String orderPromotionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OrderPromotion newOrderPromotion = loadInternalOrderPromotion(accessKey, options);
		newOrderPromotion.setVersion(0);
		
		

		
		saveInternalOrderPromotion(newOrderPromotion,options);
		
		return newOrderPromotion;
	}
	
	
	
	

	protected void throwIfHasException(String orderPromotionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OrderPromotionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OrderPromotionNotFoundException(
					"The " + this.getTableName() + "(" + orderPromotionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String orderPromotionId, int version) throws Exception{
	
		String methodName="delete(String orderPromotionId, int version)";
		assertMethodArgumentNotNull(orderPromotionId, methodName, "orderPromotionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{orderPromotionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(orderPromotionId,version);
		}
		
	
	}
	
	
	
	
	

	public OrderPromotion disconnectFromAll(String orderPromotionId, int version) throws Exception{
	
		
		OrderPromotion orderPromotion = loadInternalOrderPromotion(OrderPromotionTable.withId(orderPromotionId), emptyOptions());
		orderPromotion.clearFromAll();
		this.saveOrderPromotion(orderPromotion);
		return orderPromotion;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OrderPromotionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "order_promotion";
	}
	@Override
	protected String getBeanName() {
		
		return "orderPromotion";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OrderPromotionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderPromotionTokens.USERORDER);
 	}

 	protected boolean isSaveUserOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderPromotionTokens.USERORDER);
 	}
 	

 	
 
		

	

	protected OrderPromotionMapper getOrderPromotionMapper(){
		return new OrderPromotionMapper();
	}

	
	
	protected OrderPromotion extractOrderPromotion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OrderPromotion orderPromotion = loadSingleObject(accessKey, getOrderPromotionMapper());
			return orderPromotion;
		}catch(EmptyResultDataAccessException e){
			throw new OrderPromotionNotFoundException("OrderPromotion("+accessKey+") is not found!");
		}

	}

	
	

	protected OrderPromotion loadInternalOrderPromotion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OrderPromotion orderPromotion = extractOrderPromotion(accessKey, loadOptions);
 	
 		if(isExtractUserOrderEnabled(loadOptions)){
	 		extractUserOrder(orderPromotion, loadOptions);
 		}
 
		
		return orderPromotion;
		
	}

	 

 	protected OrderPromotion extractUserOrder(OrderPromotion orderPromotion, Map<String,Object> options) throws Exception{

		if(orderPromotion.getUserOrder() == null){
			return orderPromotion;
		}
		String userOrderId = orderPromotion.getUserOrder().getId();
		if( userOrderId == null){
			return orderPromotion;
		}
		UserOrder userOrder = getUserOrderDAO().load(userOrderId,options);
		if(userOrder != null){
			orderPromotion.setUserOrder(userOrder);
		}
		
 		
 		return orderPromotion;
 	}
 		
 
		
		
  	
 	public SmartList<OrderPromotion> findOrderPromotionByUserOrder(String userOrderId,Map<String,Object> options){
 	
  		SmartList<OrderPromotion> resultList = queryWith(OrderPromotionTable.COLUMN_USER_ORDER, userOrderId, options, getOrderPromotionMapper());
		// analyzeOrderPromotionByUserOrder(resultList, userOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<OrderPromotion> findOrderPromotionByUserOrder(String userOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<OrderPromotion> resultList =  queryWithRange(OrderPromotionTable.COLUMN_USER_ORDER, userOrderId, options, getOrderPromotionMapper(), start, count);
 		//analyzeOrderPromotionByUserOrder(resultList, userOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeOrderPromotionByUserOrder(SmartList<OrderPromotion> resultList, String userOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countOrderPromotionByUserOrder(String userOrderId,Map<String,Object> options){

 		return countWith(OrderPromotionTable.COLUMN_USER_ORDER, userOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countOrderPromotionByUserOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OrderPromotionTable.COLUMN_USER_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected OrderPromotion saveOrderPromotion(OrderPromotion  orderPromotion){
		
		if(!orderPromotion.isChanged()){
			return orderPromotion;
		}
		
		
		String SQL=this.getSaveOrderPromotionSQL(orderPromotion);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOrderPromotionParameters(orderPromotion);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		orderPromotion.incVersion();
		return orderPromotion;
	
	}
	public SmartList<OrderPromotion> saveOrderPromotionList(SmartList<OrderPromotion> orderPromotionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOrderPromotionList(orderPromotionList);
		
		batchOrderPromotionCreate((List<OrderPromotion>)lists[CREATE_LIST_INDEX]);
		
		batchOrderPromotionUpdate((List<OrderPromotion>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OrderPromotion orderPromotion:orderPromotionList){
			if(orderPromotion.isChanged()){
				orderPromotion.incVersion();
			}
			
		
		}
		
		
		return orderPromotionList;
	}

	public SmartList<OrderPromotion> removeOrderPromotionList(SmartList<OrderPromotion> orderPromotionList,Map<String,Object> options){
		
		
		super.removeList(orderPromotionList, options);
		
		return orderPromotionList;
		
		
	}
	
	protected List<Object[]> prepareOrderPromotionBatchCreateArgs(List<OrderPromotion> orderPromotionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OrderPromotion orderPromotion:orderPromotionList ){
			Object [] parameters = prepareOrderPromotionCreateParameters(orderPromotion);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOrderPromotionBatchUpdateArgs(List<OrderPromotion> orderPromotionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OrderPromotion orderPromotion:orderPromotionList ){
			if(!orderPromotion.isChanged()){
				continue;
			}
			Object [] parameters = prepareOrderPromotionUpdateParameters(orderPromotion);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOrderPromotionCreate(List<OrderPromotion> orderPromotionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOrderPromotionBatchCreateArgs(orderPromotionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOrderPromotionUpdate(List<OrderPromotion> orderPromotionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOrderPromotionBatchUpdateArgs(orderPromotionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOrderPromotionList(List<OrderPromotion> orderPromotionList){
		
		List<OrderPromotion> orderPromotionCreateList=new ArrayList<OrderPromotion>();
		List<OrderPromotion> orderPromotionUpdateList=new ArrayList<OrderPromotion>();
		
		for(OrderPromotion orderPromotion: orderPromotionList){
			if(isUpdateRequest(orderPromotion)){
				orderPromotionUpdateList.add( orderPromotion);
				continue;
			}
			orderPromotionCreateList.add(orderPromotion);
		}
		
		return new Object[]{orderPromotionCreateList,orderPromotionUpdateList};
	}
	
	protected boolean isUpdateRequest(OrderPromotion orderPromotion){
 		return orderPromotion.getVersion() > 0;
 	}
 	protected String getSaveOrderPromotionSQL(OrderPromotion orderPromotion){
 		if(isUpdateRequest(orderPromotion)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOrderPromotionParameters(OrderPromotion orderPromotion){
 		if(isUpdateRequest(orderPromotion) ){
 			return prepareOrderPromotionUpdateParameters(orderPromotion);
 		}
 		return prepareOrderPromotionCreateParameters(orderPromotion);
 	}
 	protected Object[] prepareOrderPromotionUpdateParameters(OrderPromotion orderPromotion){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = orderPromotion.getName();
 		parameters[1] = orderPromotion.getAmount();
 		parameters[2] = orderPromotion.getThreadHold();
 		parameters[3] = orderPromotion.getType(); 	
 		if(orderPromotion.getUserOrder() != null){
 			parameters[4] = orderPromotion.getUserOrder().getId();
 		}
 		
 		parameters[5] = orderPromotion.nextVersion();
 		parameters[6] = orderPromotion.getId();
 		parameters[7] = orderPromotion.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOrderPromotionCreateParameters(OrderPromotion orderPromotion){
		Object[] parameters = new Object[6];
		String newOrderPromotionId=getNextId();
		orderPromotion.setId(newOrderPromotionId);
		parameters[0] =  orderPromotion.getId();
 
 		parameters[1] = orderPromotion.getName();
 		parameters[2] = orderPromotion.getAmount();
 		parameters[3] = orderPromotion.getThreadHold();
 		parameters[4] = orderPromotion.getType(); 	
 		if(orderPromotion.getUserOrder() != null){
 			parameters[5] = orderPromotion.getUserOrder().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected OrderPromotion saveInternalOrderPromotion(OrderPromotion orderPromotion, Map<String,Object> options){
		
		saveOrderPromotion(orderPromotion);
 	
 		if(isSaveUserOrderEnabled(options)){
	 		saveUserOrder(orderPromotion, options);
 		}
 
		
		return orderPromotion;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected OrderPromotion saveUserOrder(OrderPromotion orderPromotion, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(orderPromotion.getUserOrder() == null){
 			return orderPromotion;//do nothing when it is null
 		}
 		
 		getUserOrderDAO().save(orderPromotion.getUserOrder(),options);
 		return orderPromotion;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public OrderPromotion present(OrderPromotion orderPromotion,Map<String, Object> options){
	

		return orderPromotion;
	
	}
		

	

	protected String getTableName(){
		return OrderPromotionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OrderPromotion> orderPromotionList) {		
		this.enhanceListInternal(orderPromotionList, this.getOrderPromotionMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OrderPromotion> orderPromotionList = ownerEntity.collectRefsWithType(OrderPromotion.INTERNAL_TYPE);
		this.enhanceList(orderPromotionList);
		
	}
	
	@Override
	public SmartList<OrderPromotion> findOrderPromotionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOrderPromotionMapper());

	}
	@Override
	public int countOrderPromotionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOrderPromotionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OrderPromotion> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOrderPromotionMapper());
	}
}


