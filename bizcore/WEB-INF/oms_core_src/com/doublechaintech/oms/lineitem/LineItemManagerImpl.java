
package com.doublechaintech.oms.lineitem;

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







public class LineItemManagerImpl extends CustomOmsCheckerManager implements LineItemManager {
	
	private static final String SERVICE_TYPE = "LineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LineItemManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LineItemManagerException(message);

	}
	
	

 	protected LineItem saveLineItem(OmsUserContext userContext, LineItem lineItem, String [] tokensExpr) throws Exception{	
 		//return getLineItemDAO().save(lineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLineItem(userContext, lineItem, tokens);
 	}
 	
 	protected LineItem saveLineItemDetail(OmsUserContext userContext, LineItem lineItem) throws Exception{	

 		
 		return saveLineItem(userContext, lineItem, allTokens());
 	}
 	
 	public LineItem loadLineItem(OmsUserContext userContext, String lineItemId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( LineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LineItem lineItem = loadLineItem( userContext, lineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,lineItem, tokens);
 	}
 	
 	
 	 public LineItem searchLineItem(OmsUserContext userContext, String lineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( LineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LineItem lineItem = loadLineItem( userContext, lineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,lineItem, tokens);
 	}
 	
 	

 	protected LineItem present(OmsUserContext userContext, LineItem lineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,lineItem,tokens);
		
		
		LineItem  lineItemToPresent = userContext.getDAOGroup().getLineItemDAO().present(lineItem, tokens);
		
		List<BaseEntity> entityListToNaming = lineItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLineItemDAO().alias(entityListToNaming);
		
		return  lineItemToPresent;
		
		
	}
 
 	
 	
 	public LineItem loadLineItemDetail(OmsUserContext userContext, String lineItemId) throws Exception{	
 		LineItem lineItem = loadLineItem( userContext, lineItemId, allTokens());
 		return present(userContext,lineItem, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String lineItemId) throws Exception{	
 		LineItem lineItem = loadLineItem( userContext, lineItemId, viewTokens());
 		return present(userContext,lineItem, allTokens());
		
 	}
 	protected LineItem saveLineItem(OmsUserContext userContext, LineItem lineItem, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLineItemDAO().save(lineItem, tokens);
 	}
 	protected LineItem loadLineItem(OmsUserContext userContext, String lineItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( LineItemManagerException.class);

 
 		return userContext.getDAOGroup().getLineItemDAO().load(lineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, LineItem lineItem, Map<String, Object> tokens){
		super.addActions(userContext, lineItem, tokens);
		
		addAction(userContext, lineItem, tokens,"@create","createLineItem","createLineItem/","main","primary");
		addAction(userContext, lineItem, tokens,"@update","updateLineItem","updateLineItem/"+lineItem.getId()+"/","main","primary");
		addAction(userContext, lineItem, tokens,"@copy","cloneLineItem","cloneLineItem/"+lineItem.getId()+"/","main","primary");
		
		addAction(userContext, lineItem, tokens,"line_item.transfer_to_user_order","transferToAnotherUserOrder","transferToAnotherUserOrder/"+lineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, LineItem lineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LineItem createLineItem(OmsUserContext userContext,String name, int quantity, BigDecimal price, BigDecimal discountPrice, String userOrderId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLineItem(name);
		userContext.getChecker().checkQuantityOfLineItem(quantity);
		userContext.getChecker().checkPriceOfLineItem(price);
		userContext.getChecker().checkDiscountPriceOfLineItem(discountPrice);
	
		userContext.getChecker().throwExceptionIfHasErrors(LineItemManagerException.class);


		LineItem lineItem=createNewLineItem();	

		lineItem.setName(name);
		lineItem.setQuantity(quantity);
		lineItem.setPrice(price);
		lineItem.setDiscountPrice(discountPrice);
			
		UserOrder userOrder = loadUserOrder(userContext, userOrderId,emptyOptions());
		lineItem.setUserOrder(userOrder);
		
		

		lineItem = saveLineItem(userContext, lineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, lineItem);
		return lineItem;

		
	}
	protected LineItem createNewLineItem() 
	{
		
		return new LineItem();		
	}
	
	protected void checkParamsForUpdatingLineItem(OmsUserContext userContext,String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().checkVersionOfLineItem( lineItemVersion);
		

		if(LineItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLineItem(parseString(newValueExpr));
		}
		if(LineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfLineItem(parseInt(newValueExpr));
		}
		if(LineItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfLineItem(parseBigDecimal(newValueExpr));
		}
		if(LineItem.DISCOUNT_PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkDiscountPriceOfLineItem(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(LineItemManagerException.class);
	
		
	}
	
	
	
	public LineItem clone(OmsUserContext userContext, String fromLineItemId) throws Exception{
		
		return userContext.getDAOGroup().getLineItemDAO().clone(fromLineItemId, this.allTokens());
	}
	
	public LineItem internalSaveLineItem(OmsUserContext userContext, LineItem lineItem) throws Exception 
	{
		return internalSaveLineItem(userContext, lineItem, allTokens());

	}
	public LineItem internalSaveLineItem(OmsUserContext userContext, LineItem lineItem, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLineItem(userContext, lineItemId, lineItemVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(lineItem){ 
			//will be good when the lineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LineItem.
			
			
			lineItem = saveLineItem(userContext, lineItem, options);
			return lineItem;
			
		}

	}
	
	public LineItem updateLineItem(OmsUserContext userContext,String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLineItem(userContext, lineItemId, lineItemVersion, property, newValueExpr, tokensExpr);
		
		
		
		LineItem lineItem = loadLineItem(userContext, lineItemId, allTokens());
		if(lineItem.getVersion() != lineItemVersion){
			String message = "The target version("+lineItem.getVersion()+") is not equals to version("+lineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(lineItem){ 
			//will be good when the lineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LineItem.
			
			lineItem.changeProperty(property, newValueExpr);
			lineItem = saveLineItem(userContext, lineItem, tokens().done());
			return present(userContext,lineItem, mergedAllTokens(tokensExpr));
			//return saveLineItem(userContext, lineItem, tokens().done());
		}

	}
	
	public LineItem updateLineItemProperty(OmsUserContext userContext,String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLineItem(userContext, lineItemId, lineItemVersion, property, newValueExpr, tokensExpr);
		
		LineItem lineItem = loadLineItem(userContext, lineItemId, allTokens());
		if(lineItem.getVersion() != lineItemVersion){
			String message = "The target version("+lineItem.getVersion()+") is not equals to version("+lineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(lineItem){ 
			//will be good when the lineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LineItem.
			
			lineItem.changeProperty(property, newValueExpr);
			
			lineItem = saveLineItem(userContext, lineItem, tokens().done());
			return present(userContext,lineItem, mergedAllTokens(tokensExpr));
			//return saveLineItem(userContext, lineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LineItemTokens tokens(){
		return LineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUserOrder(OmsUserContext userContext, String lineItemId, String anotherUserOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLineItem(lineItemId);
 		userContext.getChecker().checkIdOfUserOrder(anotherUserOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LineItemManagerException.class);
 		
 	}
 	public LineItem transferToAnotherUserOrder(OmsUserContext userContext, String lineItemId, String anotherUserOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserOrder(userContext, lineItemId,anotherUserOrderId);
 
		LineItem lineItem = loadLineItem(userContext, lineItemId, allTokens());	
		synchronized(lineItem){
			//will be good when the lineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserOrder userOrder = loadUserOrder(userContext, anotherUserOrderId, emptyOptions());		
			lineItem.updateUserOrder(userOrder);		
			lineItem = saveLineItem(userContext, lineItem, emptyOptions());
			
			return present(userContext,lineItem, allTokens());
			
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
		SmartList<UserOrder> candidateList = userContext.getDAOGroup().getUserOrderDAO().requestCandidateUserOrderForLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(OmsUserContext userContext, String lineItemId, int lineItemVersion) throws Exception {
		//deleteInternal(userContext, lineItemId, lineItemVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String lineItemId, int lineItemVersion) throws Exception{
			
		userContext.getDAOGroup().getLineItemDAO().delete(lineItemId, lineItemVersion);
	}
	
	public LineItem forgetByAll(OmsUserContext userContext, String lineItemId, int lineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, lineItemId, lineItemVersion);		
	}
	protected LineItem forgetByAllInternal(OmsUserContext userContext,
			String lineItemId, int lineItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getLineItemDAO().disconnectFromAll(lineItemId, lineItemVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLineItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(OmsUserContext userContext, LineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


