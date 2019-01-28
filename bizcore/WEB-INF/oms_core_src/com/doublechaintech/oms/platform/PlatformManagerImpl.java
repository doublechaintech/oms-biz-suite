
package com.doublechaintech.oms.platform;

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
import com.doublechaintech.oms.profile.Profile;


import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.platform.Platform;






public class PlatformManagerImpl extends CustomOmsCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(OmsUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(OmsUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(OmsUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(OmsUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(OmsUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(OmsUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(OmsUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(OmsUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(OmsUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(OmsUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addProfile","addProfile","addProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.removeProfile","removeProfile","removeProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.updateProfile","updateProfile","updateProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.copyProfileFrom","copyProfileFrom","copyProfileFrom/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.addUserOrder","addUserOrder","addUserOrder/"+platform.getId()+"/","userOrderList","primary");
		addAction(userContext, platform, tokens,"platform.removeUserOrder","removeUserOrder","removeUserOrder/"+platform.getId()+"/","userOrderList","primary");
		addAction(userContext, platform, tokens,"platform.updateUserOrder","updateUserOrder","updateUserOrder/"+platform.getId()+"/","userOrderList","primary");
		addAction(userContext, platform, tokens,"platform.copyUserOrderFrom","copyUserOrderFrom","copyUserOrderFrom/"+platform.getId()+"/","userOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(OmsUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(OmsUserContext userContext,String name, String introduction, String currentVersion) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
		userContext.getChecker().checkIntroductionOfPlatform(introduction);
		userContext.getChecker().checkCurrentVersionOfPlatform(currentVersion);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setIntroduction(introduction);
		platform.setCurrentVersion(currentVersion);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(OmsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfPlatform(parseString(newValueExpr));
		}
		if(Platform.CURRENT_VERSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCurrentVersionOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(OmsUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(OmsUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(OmsUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(OmsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(OmsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProfileListWith("id","desc")
		.sortUserOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(OmsUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(OmsUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(OmsUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(OmsUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(OmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(OmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	//disconnect Platform with user in UserOrder
	protected Platform breakWithUserOrderByUser(OmsUserContext userContext, String platformId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveUserOrderListWithUser(platform, userId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProfile(OmsUserContext userContext, String platformId, String name, int age, String gender,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProfile(name);
		
		userContext.getChecker().checkAgeOfProfile(age);
		
		userContext.getChecker().checkGenderOfProfile(gender);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProfile(OmsUserContext userContext, String platformId, String name, int age, String gender, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProfile(userContext,platformId,name, age, gender,tokensExpr);
		
		Profile profile = createProfile(userContext,name, age, gender);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProfileProperties(OmsUserContext userContext, String platformId,String id,String name,int age,String gender,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(id);
		
		userContext.getChecker().checkNameOfProfile( name);
		userContext.getChecker().checkAgeOfProfile( age);
		userContext.getChecker().checkGenderOfProfile( gender);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProfileProperties(OmsUserContext userContext, String platformId, String id,String name,int age,String gender, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProfileProperties(userContext,platformId,id,name,age,gender,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProfileListList()
				.searchProfileListWith(Profile.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getProfileList().isEmpty()){
			throw new PlatformManagerException("Profile is NOT FOUND with id: '"+id+"'");
		}
		
		Profile item = platformToUpdate.getProfileList().first();
		
		item.updateName( name );
		item.updateAge( age );
		item.updateGender( gender );

		
		//checkParamsForAddingProfile(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProfileList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Profile createProfile(OmsUserContext userContext, String name, int age, String gender) throws Exception{

		Profile profile = new Profile();
		
		
		profile.setName(name);		
		profile.setAge(age);		
		profile.setGender(gender);		
		profile.setLastUpdateTime(userContext.now());
	
		
		return profile;
	
		
	}
	
	protected Profile createIndexedProfile(String id, int version){

		Profile profile = new Profile();
		profile.setId(id);
		profile.setVersion(version);
		return profile;			
		
	}
	
	protected void checkParamsForRemovingProfileList(OmsUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String profileId: profileIds){
			userContext.getChecker().checkIdOfProfile(profileId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeProfileList(OmsUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProfileList(userContext, platformId,  profileIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProfileList(platform, profileIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProfileList().done());
				deleteRelationListInGraph(userContext, platform.getProfileList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProfile(OmsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeProfile(OmsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			deleteRelationInGraph(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProfile(OmsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyProfileFrom(OmsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			profile.updateLastUpdateTime(userContext.now());
			
			platform.copyProfileFrom( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, (Profile)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProfile(OmsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}
		
		if(Profile.AGE_PROPERTY.equals(property)){
			userContext.getChecker().checkAgeOfProfile(parseInt(newValueExpr));
		}
		
		if(Profile.GENDER_PROPERTY.equals(property)){
			userContext.getChecker().checkGenderOfProfile(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateProfile(OmsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProfile(userContext, platformId, profileId, profileVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProfileList().searchProfileListWith(Profile.ID_PROPERTY, "eq", profileId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProfile( profile );	
			//make changes to AcceleraterAccount.
			Profile profileIndex = createIndexedProfile(profileId, profileVersion);
		
			Profile profile = platform.findTheProfile(profileIndex);
			if(profile == null){
				throw new PlatformManagerException(profile+" is NOT FOUND" );
			}
			
			profile.changeProperty(property, newValueExpr);
			profile.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingUserOrder(OmsUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkTitleOfUserOrder(title);
		
		userContext.getChecker().checkTotalAdjustmentOfUserOrder(totalAdjustment);
		
		userContext.getChecker().checkTotalAmountOfUserOrder(totalAmount);
		
		userContext.getChecker().checkUserIdOfUserOrder(userId);
		
		userContext.getChecker().checkLastUpdateTimeOfUserOrder(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addUserOrder(OmsUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserOrder(userContext,platformId,title, totalAdjustment, totalAmount, userId, lastUpdateTime,tokensExpr);
		
		UserOrder userOrder = createUserOrder(userContext,title, totalAdjustment, totalAmount, userId, lastUpdateTime);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addUserOrder( userOrder );		
			platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
			
			userContext.getManagerGroup().getUserOrderManager().onNewInstanceCreated(userContext, userOrder);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserOrderProperties(OmsUserContext userContext, String platformId,String id,String title,BigDecimal totalAdjustment,BigDecimal totalAmount,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfUserOrder(id);
		
		userContext.getChecker().checkTitleOfUserOrder( title);
		userContext.getChecker().checkTotalAdjustmentOfUserOrder( totalAdjustment);
		userContext.getChecker().checkTotalAmountOfUserOrder( totalAmount);
		userContext.getChecker().checkLastUpdateTimeOfUserOrder( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateUserOrderProperties(OmsUserContext userContext, String platformId, String id,String title,BigDecimal totalAdjustment,BigDecimal totalAmount,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserOrderProperties(userContext,platformId,id,title,totalAdjustment,totalAmount,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserOrderListList()
				.searchUserOrderListWith(UserOrder.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getUserOrderList().isEmpty()){
			throw new PlatformManagerException("UserOrder is NOT FOUND with id: '"+id+"'");
		}
		
		UserOrder item = platformToUpdate.getUserOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAdjustment( totalAdjustment );
		item.updateTotalAmount( totalAmount );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingUserOrder(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withUserOrderList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserOrder createUserOrder(OmsUserContext userContext, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String lastUpdateTime) throws Exception{

		UserOrder userOrder = new UserOrder();
		
		
		userOrder.setTitle(title);		
		userOrder.setTotalAdjustment(totalAdjustment);		
		userOrder.setTotalAmount(totalAmount);		
		Profile  user = new Profile();
		user.setId(userId);		
		userOrder.setUser(user);		
		userOrder.setLastUpdateTime(lastUpdateTime);
	
		
		return userOrder;
	
		
	}
	
	protected UserOrder createIndexedUserOrder(String id, int version){

		UserOrder userOrder = new UserOrder();
		userOrder.setId(id);
		userOrder.setVersion(version);
		return userOrder;			
		
	}
	
	protected void checkParamsForRemovingUserOrderList(OmsUserContext userContext, String platformId, 
			String userOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String userOrderId: userOrderIds){
			userContext.getChecker().checkIdOfUserOrder(userOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeUserOrderList(OmsUserContext userContext, String platformId, 
			String userOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserOrderList(userContext, platformId,  userOrderIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveUserOrderList(platform, userOrderIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
				deleteRelationListInGraph(userContext, platform.getUserOrderList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserOrder(OmsUserContext userContext, String platformId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeUserOrder(OmsUserContext userContext, String platformId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserOrder(userContext,platformId, userOrderId, userOrderVersion,tokensExpr);
		
		UserOrder userOrder = createIndexedUserOrder(userOrderId, userOrderVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeUserOrder( userOrder );		
			platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
			deleteRelationInGraph(userContext, userOrder);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserOrder(OmsUserContext userContext, String platformId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyUserOrderFrom(OmsUserContext userContext, String platformId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserOrder(userContext,platformId, userOrderId, userOrderVersion,tokensExpr);
		
		UserOrder userOrder = createIndexedUserOrder(userOrderId, userOrderVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyUserOrderFrom( userOrder );		
			platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
			
			userContext.getManagerGroup().getUserOrderManager().onNewInstanceCreated(userContext, (UserOrder)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserOrder(OmsUserContext userContext, String platformId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		

		if(UserOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfUserOrder(parseString(newValueExpr));
		}
		
		if(UserOrder.TOTAL_ADJUSTMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAdjustmentOfUserOrder(parseBigDecimal(newValueExpr));
		}
		
		if(UserOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfUserOrder(parseBigDecimal(newValueExpr));
		}
		
		if(UserOrder.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfUserOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateUserOrder(OmsUserContext userContext, String platformId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserOrder(userContext, platformId, userOrderId, userOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserOrderList().searchUserOrderListWith(UserOrder.ID_PROPERTY, "eq", userOrderId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeUserOrder( userOrder );	
			//make changes to AcceleraterAccount.
			UserOrder userOrderIndex = createIndexedUserOrder(userOrderId, userOrderVersion);
		
			UserOrder userOrder = platform.findTheUserOrder(userOrderIndex);
			if(userOrder == null){
				throw new PlatformManagerException(userOrder+" is NOT FOUND" );
			}
			
			userOrder.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withUserOrderList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(OmsUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


