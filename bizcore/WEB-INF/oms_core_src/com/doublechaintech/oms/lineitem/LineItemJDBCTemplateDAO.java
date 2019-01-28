
package com.doublechaintech.oms.lineitem;

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

public class LineItemJDBCTemplateDAO extends OmsNamingServiceDAO implements LineItemDAO{
 
 	
 	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO userOrderDAO){
	 	this.userOrderDAO = userOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
	 	return this.userOrderDAO;
 	}


			
		

	
	/*
	protected LineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLineItem(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LineItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLineItem(LineItemTable.withId(id), options);
	}
	
	
	
	public LineItem save(LineItem lineItem,Map<String,Object> options){
		
		String methodName="save(LineItem lineItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(lineItem, methodName, "lineItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLineItem(lineItem,options);
	}
	public LineItem clone(String lineItemId, Map<String,Object> options) throws Exception{
	
		return clone(LineItemTable.withId(lineItemId),options);
	}
	
	protected LineItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String lineItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LineItem newLineItem = loadInternalLineItem(accessKey, options);
		newLineItem.setVersion(0);
		
		

		
		saveInternalLineItem(newLineItem,options);
		
		return newLineItem;
	}
	
	
	
	

	protected void throwIfHasException(String lineItemId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LineItemNotFoundException(
					"The " + this.getTableName() + "(" + lineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String lineItemId, int version) throws Exception{
	
		String methodName="delete(String lineItemId, int version)";
		assertMethodArgumentNotNull(lineItemId, methodName, "lineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{lineItemId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(lineItemId,version);
		}
		
	
	}
	
	
	
	
	

	public LineItem disconnectFromAll(String lineItemId, int version) throws Exception{
	
		
		LineItem lineItem = loadInternalLineItem(LineItemTable.withId(lineItemId), emptyOptions());
		lineItem.clearFromAll();
		this.saveLineItem(lineItem);
		return lineItem;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LineItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "line_item";
	}
	@Override
	protected String getBeanName() {
		
		return "lineItem";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LineItemTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LineItemTokens.USERORDER);
 	}

 	protected boolean isSaveUserOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LineItemTokens.USERORDER);
 	}
 	

 	
 
		

	

	protected LineItemMapper getLineItemMapper(){
		return new LineItemMapper();
	}

	
	
	protected LineItem extractLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LineItem lineItem = loadSingleObject(accessKey, getLineItemMapper());
			return lineItem;
		}catch(EmptyResultDataAccessException e){
			throw new LineItemNotFoundException("LineItem("+accessKey+") is not found!");
		}

	}

	
	

	protected LineItem loadInternalLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LineItem lineItem = extractLineItem(accessKey, loadOptions);
 	
 		if(isExtractUserOrderEnabled(loadOptions)){
	 		extractUserOrder(lineItem, loadOptions);
 		}
 
		
		return lineItem;
		
	}

	 

 	protected LineItem extractUserOrder(LineItem lineItem, Map<String,Object> options) throws Exception{

		if(lineItem.getUserOrder() == null){
			return lineItem;
		}
		String userOrderId = lineItem.getUserOrder().getId();
		if( userOrderId == null){
			return lineItem;
		}
		UserOrder userOrder = getUserOrderDAO().load(userOrderId,options);
		if(userOrder != null){
			lineItem.setUserOrder(userOrder);
		}
		
 		
 		return lineItem;
 	}
 		
 
		
		
  	
 	public SmartList<LineItem> findLineItemByUserOrder(String userOrderId,Map<String,Object> options){
 	
  		SmartList<LineItem> resultList = queryWith(LineItemTable.COLUMN_USER_ORDER, userOrderId, options, getLineItemMapper());
		// analyzeLineItemByUserOrder(resultList, userOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LineItem> findLineItemByUserOrder(String userOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LineItem> resultList =  queryWithRange(LineItemTable.COLUMN_USER_ORDER, userOrderId, options, getLineItemMapper(), start, count);
 		//analyzeLineItemByUserOrder(resultList, userOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeLineItemByUserOrder(SmartList<LineItem> resultList, String userOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLineItemByUserOrder(String userOrderId,Map<String,Object> options){

 		return countWith(LineItemTable.COLUMN_USER_ORDER, userOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countLineItemByUserOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LineItemTable.COLUMN_USER_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected LineItem saveLineItem(LineItem  lineItem){
		
		if(!lineItem.isChanged()){
			return lineItem;
		}
		
		
		String SQL=this.getSaveLineItemSQL(lineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLineItemParameters(lineItem);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		lineItem.incVersion();
		return lineItem;
	
	}
	public SmartList<LineItem> saveLineItemList(SmartList<LineItem> lineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLineItemList(lineItemList);
		
		batchLineItemCreate((List<LineItem>)lists[CREATE_LIST_INDEX]);
		
		batchLineItemUpdate((List<LineItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LineItem lineItem:lineItemList){
			if(lineItem.isChanged()){
				lineItem.incVersion();
			}
			
		
		}
		
		
		return lineItemList;
	}

	public SmartList<LineItem> removeLineItemList(SmartList<LineItem> lineItemList,Map<String,Object> options){
		
		
		super.removeList(lineItemList, options);
		
		return lineItemList;
		
		
	}
	
	protected List<Object[]> prepareLineItemBatchCreateArgs(List<LineItem> lineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LineItem lineItem:lineItemList ){
			Object [] parameters = prepareLineItemCreateParameters(lineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLineItemBatchUpdateArgs(List<LineItem> lineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LineItem lineItem:lineItemList ){
			if(!lineItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareLineItemUpdateParameters(lineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLineItemCreate(List<LineItem> lineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLineItemBatchCreateArgs(lineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLineItemUpdate(List<LineItem> lineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLineItemBatchUpdateArgs(lineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLineItemList(List<LineItem> lineItemList){
		
		List<LineItem> lineItemCreateList=new ArrayList<LineItem>();
		List<LineItem> lineItemUpdateList=new ArrayList<LineItem>();
		
		for(LineItem lineItem: lineItemList){
			if(isUpdateRequest(lineItem)){
				lineItemUpdateList.add( lineItem);
				continue;
			}
			lineItemCreateList.add(lineItem);
		}
		
		return new Object[]{lineItemCreateList,lineItemUpdateList};
	}
	
	protected boolean isUpdateRequest(LineItem lineItem){
 		return lineItem.getVersion() > 0;
 	}
 	protected String getSaveLineItemSQL(LineItem lineItem){
 		if(isUpdateRequest(lineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLineItemParameters(LineItem lineItem){
 		if(isUpdateRequest(lineItem) ){
 			return prepareLineItemUpdateParameters(lineItem);
 		}
 		return prepareLineItemCreateParameters(lineItem);
 	}
 	protected Object[] prepareLineItemUpdateParameters(LineItem lineItem){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = lineItem.getName();
 		parameters[1] = lineItem.getQuantity();
 		parameters[2] = lineItem.getPrice();
 		parameters[3] = lineItem.getDiscountPrice(); 	
 		if(lineItem.getUserOrder() != null){
 			parameters[4] = lineItem.getUserOrder().getId();
 		}
 		
 		parameters[5] = lineItem.nextVersion();
 		parameters[6] = lineItem.getId();
 		parameters[7] = lineItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLineItemCreateParameters(LineItem lineItem){
		Object[] parameters = new Object[6];
		String newLineItemId=getNextId();
		lineItem.setId(newLineItemId);
		parameters[0] =  lineItem.getId();
 
 		parameters[1] = lineItem.getName();
 		parameters[2] = lineItem.getQuantity();
 		parameters[3] = lineItem.getPrice();
 		parameters[4] = lineItem.getDiscountPrice(); 	
 		if(lineItem.getUserOrder() != null){
 			parameters[5] = lineItem.getUserOrder().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected LineItem saveInternalLineItem(LineItem lineItem, Map<String,Object> options){
		
		saveLineItem(lineItem);
 	
 		if(isSaveUserOrderEnabled(options)){
	 		saveUserOrder(lineItem, options);
 		}
 
		
		return lineItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LineItem saveUserOrder(LineItem lineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(lineItem.getUserOrder() == null){
 			return lineItem;//do nothing when it is null
 		}
 		
 		getUserOrderDAO().save(lineItem.getUserOrder(),options);
 		return lineItem;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public LineItem present(LineItem lineItem,Map<String, Object> options){
	

		return lineItem;
	
	}
		

	

	protected String getTableName(){
		return LineItemTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LineItem> lineItemList) {		
		this.enhanceListInternal(lineItemList, this.getLineItemMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LineItem> lineItemList = ownerEntity.collectRefsWithType(LineItem.INTERNAL_TYPE);
		this.enhanceList(lineItemList);
		
	}
	
	@Override
	public SmartList<LineItem> findLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLineItemMapper());

	}
	@Override
	public int countLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LineItem> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLineItemMapper());
	}
}


