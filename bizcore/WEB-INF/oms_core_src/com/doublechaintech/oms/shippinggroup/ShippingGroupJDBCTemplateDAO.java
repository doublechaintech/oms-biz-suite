
package com.doublechaintech.oms.shippinggroup;

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

public class ShippingGroupJDBCTemplateDAO extends OmsNamingServiceDAO implements ShippingGroupDAO{
 
 	
 	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO userOrderDAO){
	 	this.userOrderDAO = userOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
	 	return this.userOrderDAO;
 	}


			
		

	
	/*
	protected ShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalShippingGroup(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalShippingGroup(ShippingGroupTable.withId(id), options);
	}
	
	
	
	public ShippingGroup save(ShippingGroup shippingGroup,Map<String,Object> options){
		
		String methodName="save(ShippingGroup shippingGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingGroup, methodName, "shippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShippingGroup(shippingGroup,options);
	}
	public ShippingGroup clone(String shippingGroupId, Map<String,Object> options) throws Exception{
	
		return clone(ShippingGroupTable.withId(shippingGroupId),options);
	}
	
	protected ShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shippingGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ShippingGroup newShippingGroup = loadInternalShippingGroup(accessKey, options);
		newShippingGroup.setVersion(0);
		
		

		
		saveInternalShippingGroup(newShippingGroup,options);
		
		return newShippingGroup;
	}
	
	
	
	

	protected void throwIfHasException(String shippingGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + shippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String shippingGroupId, int version) throws Exception{
	
		String methodName="delete(String shippingGroupId, int version)";
		assertMethodArgumentNotNull(shippingGroupId, methodName, "shippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingGroupId,version);
		}
		
	
	}
	
	
	
	
	

	public ShippingGroup disconnectFromAll(String shippingGroupId, int version) throws Exception{
	
		
		ShippingGroup shippingGroup = loadInternalShippingGroup(ShippingGroupTable.withId(shippingGroupId), emptyOptions());
		shippingGroup.clearFromAll();
		this.saveShippingGroup(shippingGroup);
		return shippingGroup;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "shipping_group";
	}
	@Override
	protected String getBeanName() {
		
		return "shippingGroup";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ShippingGroupTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ShippingGroupTokens.USERORDER);
 	}

 	protected boolean isSaveUserOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ShippingGroupTokens.USERORDER);
 	}
 	

 	
 
		

	

	protected ShippingGroupMapper getShippingGroupMapper(){
		return new ShippingGroupMapper();
	}

	
	
	protected ShippingGroup extractShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ShippingGroup shippingGroup = loadSingleObject(accessKey, getShippingGroupMapper());
			return shippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingGroupNotFoundException("ShippingGroup("+accessKey+") is not found!");
		}

	}

	
	

	protected ShippingGroup loadInternalShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ShippingGroup shippingGroup = extractShippingGroup(accessKey, loadOptions);
 	
 		if(isExtractUserOrderEnabled(loadOptions)){
	 		extractUserOrder(shippingGroup, loadOptions);
 		}
 
		
		return shippingGroup;
		
	}

	 

 	protected ShippingGroup extractUserOrder(ShippingGroup shippingGroup, Map<String,Object> options) throws Exception{

		if(shippingGroup.getUserOrder() == null){
			return shippingGroup;
		}
		String userOrderId = shippingGroup.getUserOrder().getId();
		if( userOrderId == null){
			return shippingGroup;
		}
		UserOrder userOrder = getUserOrderDAO().load(userOrderId,options);
		if(userOrder != null){
			shippingGroup.setUserOrder(userOrder);
		}
		
 		
 		return shippingGroup;
 	}
 		
 
		
		
  	
 	public SmartList<ShippingGroup> findShippingGroupByUserOrder(String userOrderId,Map<String,Object> options){
 	
  		SmartList<ShippingGroup> resultList = queryWith(ShippingGroupTable.COLUMN_USER_ORDER, userOrderId, options, getShippingGroupMapper());
		// analyzeShippingGroupByUserOrder(resultList, userOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ShippingGroup> findShippingGroupByUserOrder(String userOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ShippingGroup> resultList =  queryWithRange(ShippingGroupTable.COLUMN_USER_ORDER, userOrderId, options, getShippingGroupMapper(), start, count);
 		//analyzeShippingGroupByUserOrder(resultList, userOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeShippingGroupByUserOrder(SmartList<ShippingGroup> resultList, String userOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countShippingGroupByUserOrder(String userOrderId,Map<String,Object> options){

 		return countWith(ShippingGroupTable.COLUMN_USER_ORDER, userOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countShippingGroupByUserOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ShippingGroupTable.COLUMN_USER_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected ShippingGroup saveShippingGroup(ShippingGroup  shippingGroup){
		
		if(!shippingGroup.isChanged()){
			return shippingGroup;
		}
		
		
		String SQL=this.getSaveShippingGroupSQL(shippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingGroupParameters(shippingGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		shippingGroup.incVersion();
		return shippingGroup;
	
	}
	public SmartList<ShippingGroup> saveShippingGroupList(SmartList<ShippingGroup> shippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingGroupList(shippingGroupList);
		
		batchShippingGroupCreate((List<ShippingGroup>)lists[CREATE_LIST_INDEX]);
		
		batchShippingGroupUpdate((List<ShippingGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ShippingGroup shippingGroup:shippingGroupList){
			if(shippingGroup.isChanged()){
				shippingGroup.incVersion();
			}
			
		
		}
		
		
		return shippingGroupList;
	}

	public SmartList<ShippingGroup> removeShippingGroupList(SmartList<ShippingGroup> shippingGroupList,Map<String,Object> options){
		
		
		super.removeList(shippingGroupList, options);
		
		return shippingGroupList;
		
		
	}
	
	protected List<Object[]> prepareShippingGroupBatchCreateArgs(List<ShippingGroup> shippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingGroup shippingGroup:shippingGroupList ){
			Object [] parameters = prepareShippingGroupCreateParameters(shippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareShippingGroupBatchUpdateArgs(List<ShippingGroup> shippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingGroup shippingGroup:shippingGroupList ){
			if(!shippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareShippingGroupUpdateParameters(shippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchShippingGroupCreate(List<ShippingGroup> shippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareShippingGroupBatchCreateArgs(shippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchShippingGroupUpdate(List<ShippingGroup> shippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareShippingGroupBatchUpdateArgs(shippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingGroupList(List<ShippingGroup> shippingGroupList){
		
		List<ShippingGroup> shippingGroupCreateList=new ArrayList<ShippingGroup>();
		List<ShippingGroup> shippingGroupUpdateList=new ArrayList<ShippingGroup>();
		
		for(ShippingGroup shippingGroup: shippingGroupList){
			if(isUpdateRequest(shippingGroup)){
				shippingGroupUpdateList.add( shippingGroup);
				continue;
			}
			shippingGroupCreateList.add(shippingGroup);
		}
		
		return new Object[]{shippingGroupCreateList,shippingGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingGroup shippingGroup){
 		return shippingGroup.getVersion() > 0;
 	}
 	protected String getSaveShippingGroupSQL(ShippingGroup shippingGroup){
 		if(isUpdateRequest(shippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingGroupParameters(ShippingGroup shippingGroup){
 		if(isUpdateRequest(shippingGroup) ){
 			return prepareShippingGroupUpdateParameters(shippingGroup);
 		}
 		return prepareShippingGroupCreateParameters(shippingGroup);
 	}
 	protected Object[] prepareShippingGroupUpdateParameters(ShippingGroup shippingGroup){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = shippingGroup.getName();
 		parameters[1] = shippingGroup.getLine1();
 		parameters[2] = shippingGroup.getLine2();
 		parameters[3] = shippingGroup.getCity();
 		parameters[4] = shippingGroup.getState();
 		parameters[5] = shippingGroup.getZipCode();
 		parameters[6] = shippingGroup.getCountry(); 	
 		if(shippingGroup.getUserOrder() != null){
 			parameters[7] = shippingGroup.getUserOrder().getId();
 		}
 		
 		parameters[8] = shippingGroup.nextVersion();
 		parameters[9] = shippingGroup.getId();
 		parameters[10] = shippingGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareShippingGroupCreateParameters(ShippingGroup shippingGroup){
		Object[] parameters = new Object[9];
		String newShippingGroupId=getNextId();
		shippingGroup.setId(newShippingGroupId);
		parameters[0] =  shippingGroup.getId();
 
 		parameters[1] = shippingGroup.getName();
 		parameters[2] = shippingGroup.getLine1();
 		parameters[3] = shippingGroup.getLine2();
 		parameters[4] = shippingGroup.getCity();
 		parameters[5] = shippingGroup.getState();
 		parameters[6] = shippingGroup.getZipCode();
 		parameters[7] = shippingGroup.getCountry(); 	
 		if(shippingGroup.getUserOrder() != null){
 			parameters[8] = shippingGroup.getUserOrder().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ShippingGroup saveInternalShippingGroup(ShippingGroup shippingGroup, Map<String,Object> options){
		
		saveShippingGroup(shippingGroup);
 	
 		if(isSaveUserOrderEnabled(options)){
	 		saveUserOrder(shippingGroup, options);
 		}
 
		
		return shippingGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ShippingGroup saveUserOrder(ShippingGroup shippingGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(shippingGroup.getUserOrder() == null){
 			return shippingGroup;//do nothing when it is null
 		}
 		
 		getUserOrderDAO().save(shippingGroup.getUserOrder(),options);
 		return shippingGroup;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ShippingGroup present(ShippingGroup shippingGroup,Map<String, Object> options){
	

		return shippingGroup;
	
	}
		

	

	protected String getTableName(){
		return ShippingGroupTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ShippingGroup> shippingGroupList) {		
		this.enhanceListInternal(shippingGroupList, this.getShippingGroupMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ShippingGroup> shippingGroupList = ownerEntity.collectRefsWithType(ShippingGroup.INTERNAL_TYPE);
		this.enhanceList(shippingGroupList);
		
	}
	
	@Override
	public SmartList<ShippingGroup> findShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getShippingGroupMapper());

	}
	@Override
	public int countShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ShippingGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getShippingGroupMapper());
	}
}


