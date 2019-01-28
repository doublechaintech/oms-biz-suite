
package com.doublechaintech.oms.paymentgroup;

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

public class PaymentGroupJDBCTemplateDAO extends OmsNamingServiceDAO implements PaymentGroupDAO{
 
 	
 	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO userOrderDAO){
	 	this.userOrderDAO = userOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
	 	return this.userOrderDAO;
 	}


			
		

	
	/*
	protected PaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPaymentGroup(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public PaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPaymentGroup(PaymentGroupTable.withId(id), options);
	}
	
	
	
	public PaymentGroup save(PaymentGroup paymentGroup,Map<String,Object> options){
		
		String methodName="save(PaymentGroup paymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(paymentGroup, methodName, "paymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPaymentGroup(paymentGroup,options);
	}
	public PaymentGroup clone(String paymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(PaymentGroupTable.withId(paymentGroupId),options);
	}
	
	protected PaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String paymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PaymentGroup newPaymentGroup = loadInternalPaymentGroup(accessKey, options);
		newPaymentGroup.setVersion(0);
		
		

		
		saveInternalPaymentGroup(newPaymentGroup,options);
		
		return newPaymentGroup;
	}
	
	
	
	

	protected void throwIfHasException(String paymentGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + paymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String paymentGroupId, int version) throws Exception{
	
		String methodName="delete(String paymentGroupId, int version)";
		assertMethodArgumentNotNull(paymentGroupId, methodName, "paymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{paymentGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(paymentGroupId,version);
		}
		
	
	}
	
	
	
	
	

	public PaymentGroup disconnectFromAll(String paymentGroupId, int version) throws Exception{
	
		
		PaymentGroup paymentGroup = loadInternalPaymentGroup(PaymentGroupTable.withId(paymentGroupId), emptyOptions());
		paymentGroup.clearFromAll();
		this.savePaymentGroup(paymentGroup);
		return paymentGroup;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "payment_group";
	}
	@Override
	protected String getBeanName() {
		
		return "paymentGroup";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PaymentGroupTokens.USERORDER);
 	}

 	protected boolean isSaveUserOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PaymentGroupTokens.USERORDER);
 	}
 	

 	
 
		

	

	protected PaymentGroupMapper getPaymentGroupMapper(){
		return new PaymentGroupMapper();
	}

	
	
	protected PaymentGroup extractPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PaymentGroup paymentGroup = loadSingleObject(accessKey, getPaymentGroupMapper());
			return paymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new PaymentGroupNotFoundException("PaymentGroup("+accessKey+") is not found!");
		}

	}

	
	

	protected PaymentGroup loadInternalPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PaymentGroup paymentGroup = extractPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractUserOrderEnabled(loadOptions)){
	 		extractUserOrder(paymentGroup, loadOptions);
 		}
 
		
		return paymentGroup;
		
	}

	 

 	protected PaymentGroup extractUserOrder(PaymentGroup paymentGroup, Map<String,Object> options) throws Exception{

		if(paymentGroup.getUserOrder() == null){
			return paymentGroup;
		}
		String userOrderId = paymentGroup.getUserOrder().getId();
		if( userOrderId == null){
			return paymentGroup;
		}
		UserOrder userOrder = getUserOrderDAO().load(userOrderId,options);
		if(userOrder != null){
			paymentGroup.setUserOrder(userOrder);
		}
		
 		
 		return paymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<PaymentGroup> findPaymentGroupByUserOrder(String userOrderId,Map<String,Object> options){
 	
  		SmartList<PaymentGroup> resultList = queryWith(PaymentGroupTable.COLUMN_USER_ORDER, userOrderId, options, getPaymentGroupMapper());
		// analyzePaymentGroupByUserOrder(resultList, userOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PaymentGroup> findPaymentGroupByUserOrder(String userOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PaymentGroup> resultList =  queryWithRange(PaymentGroupTable.COLUMN_USER_ORDER, userOrderId, options, getPaymentGroupMapper(), start, count);
 		//analyzePaymentGroupByUserOrder(resultList, userOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzePaymentGroupByUserOrder(SmartList<PaymentGroup> resultList, String userOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPaymentGroupByUserOrder(String userOrderId,Map<String,Object> options){

 		return countWith(PaymentGroupTable.COLUMN_USER_ORDER, userOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countPaymentGroupByUserOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PaymentGroupTable.COLUMN_USER_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected PaymentGroup savePaymentGroup(PaymentGroup  paymentGroup){
		
		if(!paymentGroup.isChanged()){
			return paymentGroup;
		}
		
		
		String SQL=this.getSavePaymentGroupSQL(paymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePaymentGroupParameters(paymentGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		paymentGroup.incVersion();
		return paymentGroup;
	
	}
	public SmartList<PaymentGroup> savePaymentGroupList(SmartList<PaymentGroup> paymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPaymentGroupList(paymentGroupList);
		
		batchPaymentGroupCreate((List<PaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchPaymentGroupUpdate((List<PaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PaymentGroup paymentGroup:paymentGroupList){
			if(paymentGroup.isChanged()){
				paymentGroup.incVersion();
			}
			
		
		}
		
		
		return paymentGroupList;
	}

	public SmartList<PaymentGroup> removePaymentGroupList(SmartList<PaymentGroup> paymentGroupList,Map<String,Object> options){
		
		
		super.removeList(paymentGroupList, options);
		
		return paymentGroupList;
		
		
	}
	
	protected List<Object[]> preparePaymentGroupBatchCreateArgs(List<PaymentGroup> paymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentGroup paymentGroup:paymentGroupList ){
			Object [] parameters = preparePaymentGroupCreateParameters(paymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePaymentGroupBatchUpdateArgs(List<PaymentGroup> paymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentGroup paymentGroup:paymentGroupList ){
			if(!paymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = preparePaymentGroupUpdateParameters(paymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPaymentGroupCreate(List<PaymentGroup> paymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePaymentGroupBatchCreateArgs(paymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPaymentGroupUpdate(List<PaymentGroup> paymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePaymentGroupBatchUpdateArgs(paymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPaymentGroupList(List<PaymentGroup> paymentGroupList){
		
		List<PaymentGroup> paymentGroupCreateList=new ArrayList<PaymentGroup>();
		List<PaymentGroup> paymentGroupUpdateList=new ArrayList<PaymentGroup>();
		
		for(PaymentGroup paymentGroup: paymentGroupList){
			if(isUpdateRequest(paymentGroup)){
				paymentGroupUpdateList.add( paymentGroup);
				continue;
			}
			paymentGroupCreateList.add(paymentGroup);
		}
		
		return new Object[]{paymentGroupCreateList,paymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(PaymentGroup paymentGroup){
 		return paymentGroup.getVersion() > 0;
 	}
 	protected String getSavePaymentGroupSQL(PaymentGroup paymentGroup){
 		if(isUpdateRequest(paymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePaymentGroupParameters(PaymentGroup paymentGroup){
 		if(isUpdateRequest(paymentGroup) ){
 			return preparePaymentGroupUpdateParameters(paymentGroup);
 		}
 		return preparePaymentGroupCreateParameters(paymentGroup);
 	}
 	protected Object[] preparePaymentGroupUpdateParameters(PaymentGroup paymentGroup){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = paymentGroup.getName();
 		parameters[1] = paymentGroup.getAmount(); 	
 		if(paymentGroup.getUserOrder() != null){
 			parameters[2] = paymentGroup.getUserOrder().getId();
 		}
 
 		parameters[3] = paymentGroup.getStatus();		
 		parameters[4] = paymentGroup.nextVersion();
 		parameters[5] = paymentGroup.getId();
 		parameters[6] = paymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePaymentGroupCreateParameters(PaymentGroup paymentGroup){
		Object[] parameters = new Object[5];
		String newPaymentGroupId=getNextId();
		paymentGroup.setId(newPaymentGroupId);
		parameters[0] =  paymentGroup.getId();
 
 		parameters[1] = paymentGroup.getName();
 		parameters[2] = paymentGroup.getAmount(); 	
 		if(paymentGroup.getUserOrder() != null){
 			parameters[3] = paymentGroup.getUserOrder().getId();
 		
 		}
 		
 		parameters[4] = paymentGroup.getStatus();		
 				
 		return parameters;
 	}
 	
	protected PaymentGroup saveInternalPaymentGroup(PaymentGroup paymentGroup, Map<String,Object> options){
		
		savePaymentGroup(paymentGroup);
 	
 		if(isSaveUserOrderEnabled(options)){
	 		saveUserOrder(paymentGroup, options);
 		}
 
		
		return paymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PaymentGroup saveUserOrder(PaymentGroup paymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(paymentGroup.getUserOrder() == null){
 			return paymentGroup;//do nothing when it is null
 		}
 		
 		getUserOrderDAO().save(paymentGroup.getUserOrder(),options);
 		return paymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public PaymentGroup present(PaymentGroup paymentGroup,Map<String, Object> options){
	

		return paymentGroup;
	
	}
		

	

	protected String getTableName(){
		return PaymentGroupTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<PaymentGroup> paymentGroupList) {		
		this.enhanceListInternal(paymentGroupList, this.getPaymentGroupMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PaymentGroup> paymentGroupList = ownerEntity.collectRefsWithType(PaymentGroup.INTERNAL_TYPE);
		this.enhanceList(paymentGroupList);
		
	}
	
	@Override
	public SmartList<PaymentGroup> findPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPaymentGroupMapper());

	}
	@Override
	public int countPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<PaymentGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPaymentGroupMapper());
	}
}


