
package com.doublechaintech.oms.shippinggroup;

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







public class ShippingGroupManagerImpl extends CustomOmsCheckerManager implements ShippingGroupManager {
	
	private static final String SERVICE_TYPE = "ShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ShippingGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ShippingGroupManagerException(message);

	}
	
	

 	protected ShippingGroup saveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup, String [] tokensExpr) throws Exception{	
 		//return getShippingGroupDAO().save(shippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveShippingGroup(userContext, shippingGroup, tokens);
 	}
 	
 	protected ShippingGroup saveShippingGroupDetail(OmsUserContext userContext, ShippingGroup shippingGroup) throws Exception{	

 		
 		return saveShippingGroup(userContext, shippingGroup, allTokens());
 	}
 	
 	public ShippingGroup loadShippingGroup(OmsUserContext userContext, String shippingGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ShippingGroup shippingGroup = loadShippingGroup( userContext, shippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingGroup, tokens);
 	}
 	
 	
 	 public ShippingGroup searchShippingGroup(OmsUserContext userContext, String shippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ShippingGroup shippingGroup = loadShippingGroup( userContext, shippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingGroup, tokens);
 	}
 	
 	

 	protected ShippingGroup present(OmsUserContext userContext, ShippingGroup shippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,shippingGroup,tokens);
		
		
		ShippingGroup  shippingGroupToPresent = userContext.getDAOGroup().getShippingGroupDAO().present(shippingGroup, tokens);
		
		List<BaseEntity> entityListToNaming = shippingGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getShippingGroupDAO().alias(entityListToNaming);
		
		return  shippingGroupToPresent;
		
		
	}
 
 	
 	
 	public ShippingGroup loadShippingGroupDetail(OmsUserContext userContext, String shippingGroupId) throws Exception{	
 		ShippingGroup shippingGroup = loadShippingGroup( userContext, shippingGroupId, allTokens());
 		return present(userContext,shippingGroup, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String shippingGroupId) throws Exception{	
 		ShippingGroup shippingGroup = loadShippingGroup( userContext, shippingGroupId, viewTokens());
 		return present(userContext,shippingGroup, allTokens());
		
 	}
 	protected ShippingGroup saveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getShippingGroupDAO().save(shippingGroup, tokens);
 	}
 	protected ShippingGroup loadShippingGroup(OmsUserContext userContext, String shippingGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingGroupManagerException.class);

 
 		return userContext.getDAOGroup().getShippingGroupDAO().load(shippingGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, ShippingGroup shippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, shippingGroup, tokens);
		
		addAction(userContext, shippingGroup, tokens,"@create","createShippingGroup","createShippingGroup/","main","primary");
		addAction(userContext, shippingGroup, tokens,"@update","updateShippingGroup","updateShippingGroup/"+shippingGroup.getId()+"/","main","primary");
		addAction(userContext, shippingGroup, tokens,"@copy","cloneShippingGroup","cloneShippingGroup/"+shippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, shippingGroup, tokens,"shipping_group.transfer_to_user_order","transferToAnotherUserOrder","transferToAnotherUserOrder/"+shippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, ShippingGroup shippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ShippingGroup createShippingGroup(OmsUserContext userContext,String name, String line1, String line2, String city, String state, int zipCode, String country, String userOrderId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfShippingGroup(name);
		userContext.getChecker().checkLine1OfShippingGroup(line1);
		userContext.getChecker().checkLine2OfShippingGroup(line2);
		userContext.getChecker().checkCityOfShippingGroup(city);
		userContext.getChecker().checkStateOfShippingGroup(state);
		userContext.getChecker().checkZipCodeOfShippingGroup(zipCode);
		userContext.getChecker().checkCountryOfShippingGroup(country);
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingGroupManagerException.class);


		ShippingGroup shippingGroup=createNewShippingGroup();	

		shippingGroup.setName(name);
		shippingGroup.setLine1(line1);
		shippingGroup.setLine2(line2);
		shippingGroup.setCity(city);
		shippingGroup.setState(state);
		shippingGroup.setZipCode(zipCode);
		shippingGroup.setCountry(country);
			
		UserOrder userOrder = loadUserOrder(userContext, userOrderId,emptyOptions());
		shippingGroup.setUserOrder(userOrder);
		
		

		shippingGroup = saveShippingGroup(userContext, shippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, shippingGroup);
		return shippingGroup;

		
	}
	protected ShippingGroup createNewShippingGroup() 
	{
		
		return new ShippingGroup();		
	}
	
	protected void checkParamsForUpdatingShippingGroup(OmsUserContext userContext,String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().checkVersionOfShippingGroup( shippingGroupVersion);
		

		if(ShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfShippingGroup(parseString(newValueExpr));
		}
		if(ShippingGroup.LINE1_PROPERTY.equals(property)){
			userContext.getChecker().checkLine1OfShippingGroup(parseString(newValueExpr));
		}
		if(ShippingGroup.LINE2_PROPERTY.equals(property)){
			userContext.getChecker().checkLine2OfShippingGroup(parseString(newValueExpr));
		}
		if(ShippingGroup.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfShippingGroup(parseString(newValueExpr));
		}
		if(ShippingGroup.STATE_PROPERTY.equals(property)){
			userContext.getChecker().checkStateOfShippingGroup(parseString(newValueExpr));
		}
		if(ShippingGroup.ZIP_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkZipCodeOfShippingGroup(parseInt(newValueExpr));
		}
		if(ShippingGroup.COUNTRY_PROPERTY.equals(property)){
			userContext.getChecker().checkCountryOfShippingGroup(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingGroupManagerException.class);
	
		
	}
	
	
	
	public ShippingGroup clone(OmsUserContext userContext, String fromShippingGroupId) throws Exception{
		
		return userContext.getDAOGroup().getShippingGroupDAO().clone(fromShippingGroupId, this.allTokens());
	}
	
	public ShippingGroup internalSaveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup) throws Exception 
	{
		return internalSaveShippingGroup(userContext, shippingGroup, allTokens());

	}
	public ShippingGroup internalSaveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingShippingGroup(userContext, shippingGroupId, shippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(shippingGroup){ 
			//will be good when the shippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingGroup.
			
			
			shippingGroup = saveShippingGroup(userContext, shippingGroup, options);
			return shippingGroup;
			
		}

	}
	
	public ShippingGroup updateShippingGroup(OmsUserContext userContext,String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingGroup(userContext, shippingGroupId, shippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		ShippingGroup shippingGroup = loadShippingGroup(userContext, shippingGroupId, allTokens());
		if(shippingGroup.getVersion() != shippingGroupVersion){
			String message = "The target version("+shippingGroup.getVersion()+") is not equals to version("+shippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingGroup){ 
			//will be good when the shippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingGroup.
			
			shippingGroup.changeProperty(property, newValueExpr);
			shippingGroup = saveShippingGroup(userContext, shippingGroup, tokens().done());
			return present(userContext,shippingGroup, mergedAllTokens(tokensExpr));
			//return saveShippingGroup(userContext, shippingGroup, tokens().done());
		}

	}
	
	public ShippingGroup updateShippingGroupProperty(OmsUserContext userContext,String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingGroup(userContext, shippingGroupId, shippingGroupVersion, property, newValueExpr, tokensExpr);
		
		ShippingGroup shippingGroup = loadShippingGroup(userContext, shippingGroupId, allTokens());
		if(shippingGroup.getVersion() != shippingGroupVersion){
			String message = "The target version("+shippingGroup.getVersion()+") is not equals to version("+shippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingGroup){ 
			//will be good when the shippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingGroup.
			
			shippingGroup.changeProperty(property, newValueExpr);
			
			shippingGroup = saveShippingGroup(userContext, shippingGroup, tokens().done());
			return present(userContext,shippingGroup, mergedAllTokens(tokensExpr));
			//return saveShippingGroup(userContext, shippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ShippingGroupTokens tokens(){
		return ShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ShippingGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUserOrder(OmsUserContext userContext, String shippingGroupId, String anotherUserOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
 		userContext.getChecker().checkIdOfUserOrder(anotherUserOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ShippingGroupManagerException.class);
 		
 	}
 	public ShippingGroup transferToAnotherUserOrder(OmsUserContext userContext, String shippingGroupId, String anotherUserOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserOrder(userContext, shippingGroupId,anotherUserOrderId);
 
		ShippingGroup shippingGroup = loadShippingGroup(userContext, shippingGroupId, allTokens());	
		synchronized(shippingGroup){
			//will be good when the shippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserOrder userOrder = loadUserOrder(userContext, anotherUserOrderId, emptyOptions());		
			shippingGroup.updateUserOrder(userOrder);		
			shippingGroup = saveShippingGroup(userContext, shippingGroup, emptyOptions());
			
			return present(userContext,shippingGroup, allTokens());
			
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
		SmartList<UserOrder> candidateList = userContext.getDAOGroup().getUserOrderDAO().requestCandidateUserOrderForShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(OmsUserContext userContext, String shippingGroupId, int shippingGroupVersion) throws Exception {
		//deleteInternal(userContext, shippingGroupId, shippingGroupVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String shippingGroupId, int shippingGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getShippingGroupDAO().delete(shippingGroupId, shippingGroupVersion);
	}
	
	public ShippingGroup forgetByAll(OmsUserContext userContext, String shippingGroupId, int shippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, shippingGroupId, shippingGroupVersion);		
	}
	protected ShippingGroup forgetByAllInternal(OmsUserContext userContext,
			String shippingGroupId, int shippingGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getShippingGroupDAO().disconnectFromAll(shippingGroupId, shippingGroupVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getShippingGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(OmsUserContext userContext, ShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


