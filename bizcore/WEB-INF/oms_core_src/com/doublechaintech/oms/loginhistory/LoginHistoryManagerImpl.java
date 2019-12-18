
package com.doublechaintech.oms.loginhistory;

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

import com.doublechaintech.oms.secuser.SecUser;

import com.doublechaintech.oms.secuser.CandidateSecUser;







public class LoginHistoryManagerImpl extends CustomOmsCheckerManager implements LoginHistoryManager {
	
	private static final String SERVICE_TYPE = "LoginHistory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LoginHistoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LoginHistoryManagerException(message);

	}
	
	

 	protected LoginHistory saveLoginHistory(OmsUserContext userContext, LoginHistory loginHistory, String [] tokensExpr) throws Exception{	
 		//return getLoginHistoryDAO().save(loginHistory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLoginHistory(userContext, loginHistory, tokens);
 	}
 	
 	protected LoginHistory saveLoginHistoryDetail(OmsUserContext userContext, LoginHistory loginHistory) throws Exception{	

 		
 		return saveLoginHistory(userContext, loginHistory, allTokens());
 	}
 	
 	public LoginHistory loadLoginHistory(OmsUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	
 	 public LoginHistory searchLoginHistory(OmsUserContext userContext, String loginHistoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	

 	protected LoginHistory present(OmsUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,loginHistory,tokens);
		
		
		LoginHistory  loginHistoryToPresent = userContext.getDAOGroup().getLoginHistoryDAO().present(loginHistory, tokens);
		
		List<BaseEntity> entityListToNaming = loginHistoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLoginHistoryDAO().alias(entityListToNaming);
		
		return  loginHistoryToPresent;
		
		
	}
 
 	
 	
 	public LoginHistory loadLoginHistoryDetail(OmsUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, allTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, viewTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	protected LoginHistory saveLoginHistory(OmsUserContext userContext, LoginHistory loginHistory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLoginHistoryDAO().save(loginHistory, tokens);
 	}
 	protected LoginHistory loadLoginHistory(OmsUserContext userContext, String loginHistoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 
 		return userContext.getDAOGroup().getLoginHistoryDAO().load(loginHistoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
		super.addActions(userContext, loginHistory, tokens);
		
		addAction(userContext, loginHistory, tokens,"@create","createLoginHistory","createLoginHistory/","main","primary");
		addAction(userContext, loginHistory, tokens,"@update","updateLoginHistory","updateLoginHistory/"+loginHistory.getId()+"/","main","primary");
		addAction(userContext, loginHistory, tokens,"@copy","cloneLoginHistory","cloneLoginHistory/"+loginHistory.getId()+"/","main","primary");
		
		addAction(userContext, loginHistory, tokens,"login_history.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+loginHistory.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LoginHistory createLoginHistory(OmsUserContext userContext,String fromIp, String description, String secUserId) throws Exception
	{
		
		

		

		userContext.getChecker().checkFromIpOfLoginHistory(fromIp);
		userContext.getChecker().checkDescriptionOfLoginHistory(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);


		LoginHistory loginHistory=createNewLoginHistory();	

		loginHistory.setLoginTime(userContext.now());
		loginHistory.setFromIp(fromIp);
		loginHistory.setDescription(description);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		loginHistory.setSecUser(secUser);
		
		

		loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
		
		onNewInstanceCreated(userContext, loginHistory);
		return loginHistory;

		
	}
	protected LoginHistory createNewLoginHistory() 
	{
		
		return new LoginHistory();		
	}
	
	protected void checkParamsForUpdatingLoginHistory(OmsUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
		userContext.getChecker().checkVersionOfLoginHistory( loginHistoryVersion);
		

		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
			userContext.getChecker().checkFromIpOfLoginHistory(parseString(newValueExpr));
		}
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLoginHistory(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);
	
		
	}
	
	
	
	public LoginHistory clone(OmsUserContext userContext, String fromLoginHistoryId) throws Exception{
		
		return userContext.getDAOGroup().getLoginHistoryDAO().clone(fromLoginHistoryId, this.allTokens());
	}
	
	public LoginHistory internalSaveLoginHistory(OmsUserContext userContext, LoginHistory loginHistory) throws Exception 
	{
		return internalSaveLoginHistory(userContext, loginHistory, allTokens());

	}
	public LoginHistory internalSaveLoginHistory(OmsUserContext userContext, LoginHistory loginHistory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			
			loginHistory = saveLoginHistory(userContext, loginHistory, options);
			return loginHistory;
			
		}

	}
	
	public LoginHistory updateLoginHistory(OmsUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	
	public LoginHistory updateLoginHistoryProperty(OmsUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LoginHistoryTokens tokens(){
		return LoginHistoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LoginHistoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LoginHistoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(OmsUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
 		userContext.getChecker().checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}
 	public LoginHistory transferToAnotherSecUser(OmsUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, loginHistoryId,anotherSecUserId);
 
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(OmsUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
 		userContext.getChecker().checkLoginOfSecUser( anotherLogin);
 		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithLogin(OmsUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, loginHistoryId,anotherLogin);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(OmsUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
 		userContext.getChecker().checkEmailOfSecUser( anotherEmail);
 		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithEmail(OmsUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, loginHistoryId,anotherEmail);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(OmsUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLoginHistory(loginHistoryId);
 		userContext.getChecker().checkMobileOfSecUser( anotherMobile);
 		userContext.getChecker().throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithMobile(OmsUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, loginHistoryId,anotherMobile);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateSecUser requestCandidateSecUser(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = userContext.getDAOGroup().getSecUserDAO().requestCandidateSecUserForLoginHistory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SecUser loadSecUser(OmsUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(OmsUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByLogin(newLogin, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithEmail(OmsUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByEmail(newEmail, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithMobile(OmsUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSecUserDAO().loadByMobile(newMobile, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(OmsUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		//deleteInternal(userContext, loginHistoryId, loginHistoryVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLoginHistoryDAO().delete(loginHistoryId, loginHistoryVersion);
	}
	
	public LoginHistory forgetByAll(OmsUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		return forgetByAllInternal(userContext, loginHistoryId, loginHistoryVersion);		
	}
	protected LoginHistory forgetByAllInternal(OmsUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLoginHistoryDAO().disconnectFromAll(loginHistoryId, loginHistoryVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LoginHistoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLoginHistoryDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(OmsUserContext userContext, LoginHistory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


