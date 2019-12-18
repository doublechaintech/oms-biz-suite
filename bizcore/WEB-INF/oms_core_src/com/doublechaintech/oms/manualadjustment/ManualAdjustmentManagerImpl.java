
package com.doublechaintech.oms.manualadjustment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.BaseEntity;


import com.doublechaintech.oms.Message;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;

import com.doublechaintech.oms.OmsUserContext;
//import com.doublechaintech.oms.BaseManagerImpl;
import com.doublechaintech.oms.OmsCheckerManager;
import com.doublechaintech.oms.CustomOmsCheckerManager;

import com.doublechaintech.oms.userorder.UserOrder;

import com.doublechaintech.oms.userorder.CandidateUserOrder;







public class ManualAdjustmentManagerImpl extends CustomOmsCheckerManager implements ManualAdjustmentManager {
	
	private static final String SERVICE_TYPE = "ManualAdjustment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ManualAdjustmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ManualAdjustmentManagerException(message);

	}
	
	

 	protected ManualAdjustment saveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment, String [] tokensExpr) throws Exception{	
 		//return getManualAdjustmentDAO().save(manualAdjustment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveManualAdjustment(userContext, manualAdjustment, tokens);
 	}
 	
 	protected ManualAdjustment saveManualAdjustmentDetail(OmsUserContext userContext, ManualAdjustment manualAdjustment) throws Exception{	

 		
 		return saveManualAdjustment(userContext, manualAdjustment, allTokens());
 	}
 	
 	public ManualAdjustment loadManualAdjustment(OmsUserContext userContext, String manualAdjustmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ManualAdjustmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ManualAdjustment manualAdjustment = loadManualAdjustment( userContext, manualAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,manualAdjustment, tokens);
 	}
 	
 	
 	 public ManualAdjustment searchManualAdjustment(OmsUserContext userContext, String manualAdjustmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ManualAdjustmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ManualAdjustment manualAdjustment = loadManualAdjustment( userContext, manualAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,manualAdjustment, tokens);
 	}
 	
 	

 	protected ManualAdjustment present(OmsUserContext userContext, ManualAdjustment manualAdjustment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,manualAdjustment,tokens);
		
		
		ManualAdjustment  manualAdjustmentToPresent = userContext.getDAOGroup().getManualAdjustmentDAO().present(manualAdjustment, tokens);
		
		List<BaseEntity> entityListToNaming = manualAdjustmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getManualAdjustmentDAO().alias(entityListToNaming);
		
		return  manualAdjustmentToPresent;
		
		
	}
 
 	
 	
 	public ManualAdjustment loadManualAdjustmentDetail(OmsUserContext userContext, String manualAdjustmentId) throws Exception{	
 		ManualAdjustment manualAdjustment = loadManualAdjustment( userContext, manualAdjustmentId, allTokens());
 		return present(userContext,manualAdjustment, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String manualAdjustmentId) throws Exception{	
 		ManualAdjustment manualAdjustment = loadManualAdjustment( userContext, manualAdjustmentId, viewTokens());
 		return present(userContext,manualAdjustment, allTokens());
		
 	}
 	protected ManualAdjustment saveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getManualAdjustmentDAO().save(manualAdjustment, tokens);
 	}
 	protected ManualAdjustment loadManualAdjustment(OmsUserContext userContext, String manualAdjustmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ManualAdjustmentManagerException.class);

 
 		return userContext.getDAOGroup().getManualAdjustmentDAO().load(manualAdjustmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, ManualAdjustment manualAdjustment, Map<String, Object> tokens){
		super.addActions(userContext, manualAdjustment, tokens);
		
		addAction(userContext, manualAdjustment, tokens,"@create","createManualAdjustment","createManualAdjustment/","main","primary");
		addAction(userContext, manualAdjustment, tokens,"@update","updateManualAdjustment","updateManualAdjustment/"+manualAdjustment.getId()+"/","main","primary");
		addAction(userContext, manualAdjustment, tokens,"@copy","cloneManualAdjustment","cloneManualAdjustment/"+manualAdjustment.getId()+"/","main","primary");
		
		addAction(userContext, manualAdjustment, tokens,"manual_adjustment.transfer_to_user_order","transferToAnotherUserOrder","transferToAnotherUserOrder/"+manualAdjustment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, ManualAdjustment manualAdjustment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ManualAdjustment createManualAdjustment(OmsUserContext userContext,String name, int amount, int threadHold, String type, String userOrderId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfManualAdjustment(name);
		userContext.getChecker().checkAmountOfManualAdjustment(amount);
		userContext.getChecker().checkThreadHoldOfManualAdjustment(threadHold);
		userContext.getChecker().checkTypeOfManualAdjustment(type);
	
		userContext.getChecker().throwExceptionIfHasErrors(ManualAdjustmentManagerException.class);


		ManualAdjustment manualAdjustment=createNewManualAdjustment();	

		manualAdjustment.setName(name);
		manualAdjustment.setAmount(amount);
		manualAdjustment.setThreadHold(threadHold);
		manualAdjustment.setType(type);
			
		UserOrder userOrder = loadUserOrder(userContext, userOrderId,emptyOptions());
		manualAdjustment.setUserOrder(userOrder);
		
		

		manualAdjustment = saveManualAdjustment(userContext, manualAdjustment, emptyOptions());
		
		onNewInstanceCreated(userContext, manualAdjustment);
		return manualAdjustment;

		
	}
	protected ManualAdjustment createNewManualAdjustment() 
	{
		
		return new ManualAdjustment();		
	}
	
	protected void checkParamsForUpdatingManualAdjustment(OmsUserContext userContext,String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().checkVersionOfManualAdjustment( manualAdjustmentVersion);
		

		if(ManualAdjustment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfManualAdjustment(parseString(newValueExpr));
		}
		if(ManualAdjustment.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfManualAdjustment(parseInt(newValueExpr));
		}
		if(ManualAdjustment.THREAD_HOLD_PROPERTY.equals(property)){
			userContext.getChecker().checkThreadHoldOfManualAdjustment(parseInt(newValueExpr));
		}
		if(ManualAdjustment.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfManualAdjustment(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ManualAdjustmentManagerException.class);
	
		
	}
	
	
	
	public ManualAdjustment clone(OmsUserContext userContext, String fromManualAdjustmentId) throws Exception{
		
		return userContext.getDAOGroup().getManualAdjustmentDAO().clone(fromManualAdjustmentId, this.allTokens());
	}
	
	public ManualAdjustment internalSaveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment) throws Exception 
	{
		return internalSaveManualAdjustment(userContext, manualAdjustment, allTokens());

	}
	public ManualAdjustment internalSaveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingManualAdjustment(userContext, manualAdjustmentId, manualAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(manualAdjustment){ 
			//will be good when the manualAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ManualAdjustment.
			
			
			manualAdjustment = saveManualAdjustment(userContext, manualAdjustment, options);
			return manualAdjustment;
			
		}

	}
	
	public ManualAdjustment updateManualAdjustment(OmsUserContext userContext,String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingManualAdjustment(userContext, manualAdjustmentId, manualAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		ManualAdjustment manualAdjustment = loadManualAdjustment(userContext, manualAdjustmentId, allTokens());
		if(manualAdjustment.getVersion() != manualAdjustmentVersion){
			String message = "The target version("+manualAdjustment.getVersion()+") is not equals to version("+manualAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(manualAdjustment){ 
			//will be good when the manualAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ManualAdjustment.
			
			manualAdjustment.changeProperty(property, newValueExpr);
			manualAdjustment = saveManualAdjustment(userContext, manualAdjustment, tokens().done());
			return present(userContext,manualAdjustment, mergedAllTokens(tokensExpr));
			//return saveManualAdjustment(userContext, manualAdjustment, tokens().done());
		}

	}
	
	public ManualAdjustment updateManualAdjustmentProperty(OmsUserContext userContext,String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingManualAdjustment(userContext, manualAdjustmentId, manualAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		ManualAdjustment manualAdjustment = loadManualAdjustment(userContext, manualAdjustmentId, allTokens());
		if(manualAdjustment.getVersion() != manualAdjustmentVersion){
			String message = "The target version("+manualAdjustment.getVersion()+") is not equals to version("+manualAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(manualAdjustment){ 
			//will be good when the manualAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ManualAdjustment.
			
			manualAdjustment.changeProperty(property, newValueExpr);
			
			manualAdjustment = saveManualAdjustment(userContext, manualAdjustment, tokens().done());
			return present(userContext,manualAdjustment, mergedAllTokens(tokensExpr));
			//return saveManualAdjustment(userContext, manualAdjustment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ManualAdjustmentTokens tokens(){
		return ManualAdjustmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ManualAdjustmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ManualAdjustmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUserOrder(OmsUserContext userContext, String manualAdjustmentId, String anotherUserOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
 		userContext.getChecker().checkIdOfUserOrder(anotherUserOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ManualAdjustmentManagerException.class);
 		
 	}
 	public ManualAdjustment transferToAnotherUserOrder(OmsUserContext userContext, String manualAdjustmentId, String anotherUserOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserOrder(userContext, manualAdjustmentId,anotherUserOrderId);
 
		ManualAdjustment manualAdjustment = loadManualAdjustment(userContext, manualAdjustmentId, allTokens());	
		synchronized(manualAdjustment){
			//will be good when the manualAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserOrder userOrder = loadUserOrder(userContext, anotherUserOrderId, emptyOptions());		
			manualAdjustment.updateUserOrder(userOrder);		
			manualAdjustment = saveManualAdjustment(userContext, manualAdjustment, emptyOptions());
			
			return present(userContext,manualAdjustment, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserOrder requestCandidateUserOrder(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserOrder result = new CandidateUserOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserOrder> candidateList = userContext.getDAOGroup().getUserOrderDAO().requestCandidateUserOrderForManualAdjustment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserOrder loadUserOrder(OmsUserContext userContext, String newUserOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserOrderDAO().load(newUserOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(OmsUserContext userContext, String manualAdjustmentId, int manualAdjustmentVersion) throws Exception {
		//deleteInternal(userContext, manualAdjustmentId, manualAdjustmentVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String manualAdjustmentId, int manualAdjustmentVersion) throws Exception{
			
		userContext.getDAOGroup().getManualAdjustmentDAO().delete(manualAdjustmentId, manualAdjustmentVersion);
	}
	
	public ManualAdjustment forgetByAll(OmsUserContext userContext, String manualAdjustmentId, int manualAdjustmentVersion) throws Exception {
		return forgetByAllInternal(userContext, manualAdjustmentId, manualAdjustmentVersion);		
	}
	protected ManualAdjustment forgetByAllInternal(OmsUserContext userContext,
			String manualAdjustmentId, int manualAdjustmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getManualAdjustmentDAO().disconnectFromAll(manualAdjustmentId, manualAdjustmentVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ManualAdjustmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getManualAdjustmentDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(OmsUserContext userContext, ManualAdjustment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


