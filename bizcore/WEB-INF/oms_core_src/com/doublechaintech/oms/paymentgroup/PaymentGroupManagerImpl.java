
package com.doublechaintech.oms.paymentgroup;

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







public class PaymentGroupManagerImpl extends CustomOmsCheckerManager implements PaymentGroupManager {
	
	private static final String SERVICE_TYPE = "PaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PaymentGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PaymentGroupManagerException(message);

	}
	
	

 	protected PaymentGroup savePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup, String [] tokensExpr) throws Exception{	
 		//return getPaymentGroupDAO().save(paymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePaymentGroup(userContext, paymentGroup, tokens);
 	}
 	
 	protected PaymentGroup savePaymentGroupDetail(OmsUserContext userContext, PaymentGroup paymentGroup) throws Exception{	

 		
 		return savePaymentGroup(userContext, paymentGroup, allTokens());
 	}
 	
 	public PaymentGroup loadPaymentGroup(OmsUserContext userContext, String paymentGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PaymentGroup paymentGroup = loadPaymentGroup( userContext, paymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,paymentGroup, tokens);
 	}
 	
 	
 	 public PaymentGroup searchPaymentGroup(OmsUserContext userContext, String paymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PaymentGroup paymentGroup = loadPaymentGroup( userContext, paymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,paymentGroup, tokens);
 	}
 	
 	

 	protected PaymentGroup present(OmsUserContext userContext, PaymentGroup paymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,paymentGroup,tokens);
		
		
		PaymentGroup  paymentGroupToPresent = userContext.getDAOGroup().getPaymentGroupDAO().present(paymentGroup, tokens);
		
		List<BaseEntity> entityListToNaming = paymentGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPaymentGroupDAO().alias(entityListToNaming);
		
		return  paymentGroupToPresent;
		
		
	}
 
 	
 	
 	public PaymentGroup loadPaymentGroupDetail(OmsUserContext userContext, String paymentGroupId) throws Exception{	
 		PaymentGroup paymentGroup = loadPaymentGroup( userContext, paymentGroupId, allTokens());
 		return present(userContext,paymentGroup, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String paymentGroupId) throws Exception{	
 		PaymentGroup paymentGroup = loadPaymentGroup( userContext, paymentGroupId, viewTokens());
 		return present(userContext,paymentGroup, allTokens());
		
 	}
 	protected PaymentGroup savePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPaymentGroupDAO().save(paymentGroup, tokens);
 	}
 	protected PaymentGroup loadPaymentGroup(OmsUserContext userContext, String paymentGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentGroupManagerException.class);

 
 		return userContext.getDAOGroup().getPaymentGroupDAO().load(paymentGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, PaymentGroup paymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, paymentGroup, tokens);
		
		addAction(userContext, paymentGroup, tokens,"@create","createPaymentGroup","createPaymentGroup/","main","primary");
		addAction(userContext, paymentGroup, tokens,"@update","updatePaymentGroup","updatePaymentGroup/"+paymentGroup.getId()+"/","main","primary");
		addAction(userContext, paymentGroup, tokens,"@copy","clonePaymentGroup","clonePaymentGroup/"+paymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, paymentGroup, tokens,"payment_group.transfer_to_user_order","transferToAnotherUserOrder","transferToAnotherUserOrder/"+paymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, PaymentGroup paymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PaymentGroup createPaymentGroup(OmsUserContext userContext,String name, BigDecimal amount, String userOrderId, String status) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPaymentGroup(name);
		userContext.getChecker().checkAmountOfPaymentGroup(amount);
		userContext.getChecker().checkStatusOfPaymentGroup(status);
	
		userContext.getChecker().throwExceptionIfHasErrors(PaymentGroupManagerException.class);


		PaymentGroup paymentGroup=createNewPaymentGroup();	

		paymentGroup.setName(name);
		paymentGroup.setAmount(amount);
			
		UserOrder userOrder = loadUserOrder(userContext, userOrderId,emptyOptions());
		paymentGroup.setUserOrder(userOrder);
		
		
		paymentGroup.setStatus(status);

		paymentGroup = savePaymentGroup(userContext, paymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, paymentGroup);
		return paymentGroup;

		
	}
	protected PaymentGroup createNewPaymentGroup() 
	{
		
		return new PaymentGroup();		
	}
	
	protected void checkParamsForUpdatingPaymentGroup(OmsUserContext userContext,String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().checkVersionOfPaymentGroup( paymentGroupVersion);
		

		if(PaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPaymentGroup(parseString(newValueExpr));
		}
		if(PaymentGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfPaymentGroup(parseBigDecimal(newValueExpr));
		}		

		
		if(PaymentGroup.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfPaymentGroup(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PaymentGroupManagerException.class);
	
		
	}
	
	
	
	public PaymentGroup clone(OmsUserContext userContext, String fromPaymentGroupId) throws Exception{
		
		return userContext.getDAOGroup().getPaymentGroupDAO().clone(fromPaymentGroupId, this.allTokens());
	}
	
	public PaymentGroup internalSavePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup) throws Exception 
	{
		return internalSavePaymentGroup(userContext, paymentGroup, allTokens());

	}
	public PaymentGroup internalSavePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPaymentGroup(userContext, paymentGroupId, paymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(paymentGroup){ 
			//will be good when the paymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentGroup.
			
			
			paymentGroup = savePaymentGroup(userContext, paymentGroup, options);
			return paymentGroup;
			
		}

	}
	
	public PaymentGroup updatePaymentGroup(OmsUserContext userContext,String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPaymentGroup(userContext, paymentGroupId, paymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		PaymentGroup paymentGroup = loadPaymentGroup(userContext, paymentGroupId, allTokens());
		if(paymentGroup.getVersion() != paymentGroupVersion){
			String message = "The target version("+paymentGroup.getVersion()+") is not equals to version("+paymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(paymentGroup){ 
			//will be good when the paymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentGroup.
			
			paymentGroup.changeProperty(property, newValueExpr);
			paymentGroup = savePaymentGroup(userContext, paymentGroup, tokens().done());
			return present(userContext,paymentGroup, mergedAllTokens(tokensExpr));
			//return savePaymentGroup(userContext, paymentGroup, tokens().done());
		}

	}
	
	public PaymentGroup updatePaymentGroupProperty(OmsUserContext userContext,String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPaymentGroup(userContext, paymentGroupId, paymentGroupVersion, property, newValueExpr, tokensExpr);
		
		PaymentGroup paymentGroup = loadPaymentGroup(userContext, paymentGroupId, allTokens());
		if(paymentGroup.getVersion() != paymentGroupVersion){
			String message = "The target version("+paymentGroup.getVersion()+") is not equals to version("+paymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(paymentGroup){ 
			//will be good when the paymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentGroup.
			
			paymentGroup.changeProperty(property, newValueExpr);
			
			paymentGroup = savePaymentGroup(userContext, paymentGroup, tokens().done());
			return present(userContext,paymentGroup, mergedAllTokens(tokensExpr));
			//return savePaymentGroup(userContext, paymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PaymentGroupTokens tokens(){
		return PaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PaymentGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUserOrder(OmsUserContext userContext, String paymentGroupId, String anotherUserOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
 		userContext.getChecker().checkIdOfUserOrder(anotherUserOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PaymentGroupManagerException.class);
 		
 	}
 	public PaymentGroup transferToAnotherUserOrder(OmsUserContext userContext, String paymentGroupId, String anotherUserOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserOrder(userContext, paymentGroupId,anotherUserOrderId);
 
		PaymentGroup paymentGroup = loadPaymentGroup(userContext, paymentGroupId, allTokens());	
		synchronized(paymentGroup){
			//will be good when the paymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserOrder userOrder = loadUserOrder(userContext, anotherUserOrderId, emptyOptions());		
			paymentGroup.updateUserOrder(userOrder);		
			paymentGroup = savePaymentGroup(userContext, paymentGroup, emptyOptions());
			
			return present(userContext,paymentGroup, allTokens());
			
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
		SmartList<UserOrder> candidateList = userContext.getDAOGroup().getUserOrderDAO().requestCandidateUserOrderForPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(OmsUserContext userContext, String paymentGroupId, int paymentGroupVersion) throws Exception {
		//deleteInternal(userContext, paymentGroupId, paymentGroupVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String paymentGroupId, int paymentGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getPaymentGroupDAO().delete(paymentGroupId, paymentGroupVersion);
	}
	
	public PaymentGroup forgetByAll(OmsUserContext userContext, String paymentGroupId, int paymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, paymentGroupId, paymentGroupVersion);		
	}
	protected PaymentGroup forgetByAllInternal(OmsUserContext userContext,
			String paymentGroupId, int paymentGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getPaymentGroupDAO().disconnectFromAll(paymentGroupId, paymentGroupVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPaymentGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(OmsUserContext userContext, PaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


