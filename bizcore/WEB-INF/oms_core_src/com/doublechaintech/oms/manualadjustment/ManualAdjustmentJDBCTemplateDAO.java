
package com.doublechaintech.oms.manualadjustment;

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

public class ManualAdjustmentJDBCTemplateDAO extends OmsNamingServiceDAO implements ManualAdjustmentDAO{
 
 	
 	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO userOrderDAO){
	 	this.userOrderDAO = userOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
	 	return this.userOrderDAO;
 	}


			
		

	
	/*
	protected ManualAdjustment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalManualAdjustment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ManualAdjustment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalManualAdjustment(ManualAdjustmentTable.withId(id), options);
	}
	
	
	
	public ManualAdjustment save(ManualAdjustment manualAdjustment,Map<String,Object> options){
		
		String methodName="save(ManualAdjustment manualAdjustment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(manualAdjustment, methodName, "manualAdjustment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalManualAdjustment(manualAdjustment,options);
	}
	public ManualAdjustment clone(String manualAdjustmentId, Map<String,Object> options) throws Exception{
	
		return clone(ManualAdjustmentTable.withId(manualAdjustmentId),options);
	}
	
	protected ManualAdjustment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String manualAdjustmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ManualAdjustment newManualAdjustment = loadInternalManualAdjustment(accessKey, options);
		newManualAdjustment.setVersion(0);
		
		

		
		saveInternalManualAdjustment(newManualAdjustment,options);
		
		return newManualAdjustment;
	}
	
	
	
	

	protected void throwIfHasException(String manualAdjustmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ManualAdjustmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ManualAdjustmentNotFoundException(
					"The " + this.getTableName() + "(" + manualAdjustmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String manualAdjustmentId, int version) throws Exception{
	
		String methodName="delete(String manualAdjustmentId, int version)";
		assertMethodArgumentNotNull(manualAdjustmentId, methodName, "manualAdjustmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{manualAdjustmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(manualAdjustmentId,version);
		}
		
	
	}
	
	
	
	
	

	public ManualAdjustment disconnectFromAll(String manualAdjustmentId, int version) throws Exception{
	
		
		ManualAdjustment manualAdjustment = loadInternalManualAdjustment(ManualAdjustmentTable.withId(manualAdjustmentId), emptyOptions());
		manualAdjustment.clearFromAll();
		this.saveManualAdjustment(manualAdjustment);
		return manualAdjustment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ManualAdjustmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "manual_adjustment";
	}
	@Override
	protected String getBeanName() {
		
		return "manualAdjustment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ManualAdjustmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ManualAdjustmentTokens.USERORDER);
 	}

 	protected boolean isSaveUserOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ManualAdjustmentTokens.USERORDER);
 	}
 	

 	
 
		

	

	protected ManualAdjustmentMapper getManualAdjustmentMapper(){
		return new ManualAdjustmentMapper();
	}

	
	
	protected ManualAdjustment extractManualAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ManualAdjustment manualAdjustment = loadSingleObject(accessKey, getManualAdjustmentMapper());
			return manualAdjustment;
		}catch(EmptyResultDataAccessException e){
			throw new ManualAdjustmentNotFoundException("ManualAdjustment("+accessKey+") is not found!");
		}

	}

	
	

	protected ManualAdjustment loadInternalManualAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ManualAdjustment manualAdjustment = extractManualAdjustment(accessKey, loadOptions);
 	
 		if(isExtractUserOrderEnabled(loadOptions)){
	 		extractUserOrder(manualAdjustment, loadOptions);
 		}
 
		
		return manualAdjustment;
		
	}

	 

 	protected ManualAdjustment extractUserOrder(ManualAdjustment manualAdjustment, Map<String,Object> options) throws Exception{

		if(manualAdjustment.getUserOrder() == null){
			return manualAdjustment;
		}
		String userOrderId = manualAdjustment.getUserOrder().getId();
		if( userOrderId == null){
			return manualAdjustment;
		}
		UserOrder userOrder = getUserOrderDAO().load(userOrderId,options);
		if(userOrder != null){
			manualAdjustment.setUserOrder(userOrder);
		}
		
 		
 		return manualAdjustment;
 	}
 		
 
		
		
  	
 	public SmartList<ManualAdjustment> findManualAdjustmentByUserOrder(String userOrderId,Map<String,Object> options){
 	
  		SmartList<ManualAdjustment> resultList = queryWith(ManualAdjustmentTable.COLUMN_USER_ORDER, userOrderId, options, getManualAdjustmentMapper());
		// analyzeManualAdjustmentByUserOrder(resultList, userOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ManualAdjustment> findManualAdjustmentByUserOrder(String userOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ManualAdjustment> resultList =  queryWithRange(ManualAdjustmentTable.COLUMN_USER_ORDER, userOrderId, options, getManualAdjustmentMapper(), start, count);
 		//analyzeManualAdjustmentByUserOrder(resultList, userOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeManualAdjustmentByUserOrder(SmartList<ManualAdjustment> resultList, String userOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countManualAdjustmentByUserOrder(String userOrderId,Map<String,Object> options){

 		return countWith(ManualAdjustmentTable.COLUMN_USER_ORDER, userOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countManualAdjustmentByUserOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ManualAdjustmentTable.COLUMN_USER_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected ManualAdjustment saveManualAdjustment(ManualAdjustment  manualAdjustment){
		
		if(!manualAdjustment.isChanged()){
			return manualAdjustment;
		}
		
		
		String SQL=this.getSaveManualAdjustmentSQL(manualAdjustment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveManualAdjustmentParameters(manualAdjustment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		manualAdjustment.incVersion();
		return manualAdjustment;
	
	}
	public SmartList<ManualAdjustment> saveManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitManualAdjustmentList(manualAdjustmentList);
		
		batchManualAdjustmentCreate((List<ManualAdjustment>)lists[CREATE_LIST_INDEX]);
		
		batchManualAdjustmentUpdate((List<ManualAdjustment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ManualAdjustment manualAdjustment:manualAdjustmentList){
			if(manualAdjustment.isChanged()){
				manualAdjustment.incVersion();
			}
			
		
		}
		
		
		return manualAdjustmentList;
	}

	public SmartList<ManualAdjustment> removeManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList,Map<String,Object> options){
		
		
		super.removeList(manualAdjustmentList, options);
		
		return manualAdjustmentList;
		
		
	}
	
	protected List<Object[]> prepareManualAdjustmentBatchCreateArgs(List<ManualAdjustment> manualAdjustmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ManualAdjustment manualAdjustment:manualAdjustmentList ){
			Object [] parameters = prepareManualAdjustmentCreateParameters(manualAdjustment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareManualAdjustmentBatchUpdateArgs(List<ManualAdjustment> manualAdjustmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ManualAdjustment manualAdjustment:manualAdjustmentList ){
			if(!manualAdjustment.isChanged()){
				continue;
			}
			Object [] parameters = prepareManualAdjustmentUpdateParameters(manualAdjustment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchManualAdjustmentCreate(List<ManualAdjustment> manualAdjustmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareManualAdjustmentBatchCreateArgs(manualAdjustmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchManualAdjustmentUpdate(List<ManualAdjustment> manualAdjustmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareManualAdjustmentBatchUpdateArgs(manualAdjustmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitManualAdjustmentList(List<ManualAdjustment> manualAdjustmentList){
		
		List<ManualAdjustment> manualAdjustmentCreateList=new ArrayList<ManualAdjustment>();
		List<ManualAdjustment> manualAdjustmentUpdateList=new ArrayList<ManualAdjustment>();
		
		for(ManualAdjustment manualAdjustment: manualAdjustmentList){
			if(isUpdateRequest(manualAdjustment)){
				manualAdjustmentUpdateList.add( manualAdjustment);
				continue;
			}
			manualAdjustmentCreateList.add(manualAdjustment);
		}
		
		return new Object[]{manualAdjustmentCreateList,manualAdjustmentUpdateList};
	}
	
	protected boolean isUpdateRequest(ManualAdjustment manualAdjustment){
 		return manualAdjustment.getVersion() > 0;
 	}
 	protected String getSaveManualAdjustmentSQL(ManualAdjustment manualAdjustment){
 		if(isUpdateRequest(manualAdjustment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveManualAdjustmentParameters(ManualAdjustment manualAdjustment){
 		if(isUpdateRequest(manualAdjustment) ){
 			return prepareManualAdjustmentUpdateParameters(manualAdjustment);
 		}
 		return prepareManualAdjustmentCreateParameters(manualAdjustment);
 	}
 	protected Object[] prepareManualAdjustmentUpdateParameters(ManualAdjustment manualAdjustment){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = manualAdjustment.getName();
 		parameters[1] = manualAdjustment.getAmount();
 		parameters[2] = manualAdjustment.getThreadHold();
 		parameters[3] = manualAdjustment.getType(); 	
 		if(manualAdjustment.getUserOrder() != null){
 			parameters[4] = manualAdjustment.getUserOrder().getId();
 		}
 		
 		parameters[5] = manualAdjustment.nextVersion();
 		parameters[6] = manualAdjustment.getId();
 		parameters[7] = manualAdjustment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareManualAdjustmentCreateParameters(ManualAdjustment manualAdjustment){
		Object[] parameters = new Object[6];
		String newManualAdjustmentId=getNextId();
		manualAdjustment.setId(newManualAdjustmentId);
		parameters[0] =  manualAdjustment.getId();
 
 		parameters[1] = manualAdjustment.getName();
 		parameters[2] = manualAdjustment.getAmount();
 		parameters[3] = manualAdjustment.getThreadHold();
 		parameters[4] = manualAdjustment.getType(); 	
 		if(manualAdjustment.getUserOrder() != null){
 			parameters[5] = manualAdjustment.getUserOrder().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ManualAdjustment saveInternalManualAdjustment(ManualAdjustment manualAdjustment, Map<String,Object> options){
		
		saveManualAdjustment(manualAdjustment);
 	
 		if(isSaveUserOrderEnabled(options)){
	 		saveUserOrder(manualAdjustment, options);
 		}
 
		
		return manualAdjustment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ManualAdjustment saveUserOrder(ManualAdjustment manualAdjustment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(manualAdjustment.getUserOrder() == null){
 			return manualAdjustment;//do nothing when it is null
 		}
 		
 		getUserOrderDAO().save(manualAdjustment.getUserOrder(),options);
 		return manualAdjustment;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ManualAdjustment present(ManualAdjustment manualAdjustment,Map<String, Object> options){
	

		return manualAdjustment;
	
	}
		

	

	protected String getTableName(){
		return ManualAdjustmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ManualAdjustment> manualAdjustmentList) {		
		this.enhanceListInternal(manualAdjustmentList, this.getManualAdjustmentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ManualAdjustment> manualAdjustmentList = ownerEntity.collectRefsWithType(ManualAdjustment.INTERNAL_TYPE);
		this.enhanceList(manualAdjustmentList);
		
	}
	
	@Override
	public SmartList<ManualAdjustment> findManualAdjustmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getManualAdjustmentMapper());

	}
	@Override
	public int countManualAdjustmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countManualAdjustmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ManualAdjustment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getManualAdjustmentMapper());
	}
}


