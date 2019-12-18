
package com.doublechaintech.oms.platform;

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
import com.doublechaintech.oms.profile.Profile;

import com.doublechaintech.oms.profile.ProfileDAO;
import com.doublechaintech.oms.userorder.UserOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends OmsNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO pProfileDAO){
 	
 		if(pProfileDAO == null){
 			throw new IllegalStateException("Do not try to set profileDAO to null.");
 		}
	 	this.profileDAO = pProfileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
 		if(this.profileDAO == null){
 			throw new IllegalStateException("The profileDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profileDAO;
 	}	
 	
			
		
	
  	private  UserOrderDAO  userOrderDAO;
 	public void setUserOrderDAO(UserOrderDAO pUserOrderDAO){
 	
 		if(pUserOrderDAO == null){
 			throw new IllegalStateException("Do not try to set userOrderDAO to null.");
 		}
	 	this.userOrderDAO = pUserOrderDAO;
 	}
 	public UserOrderDAO getUserOrderDAO(){
 		if(this.userOrderDAO == null){
 			throw new IllegalStateException("The userOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userOrderDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveProfileListEnabled(options)){
 			for(Profile item: newPlatform.getProfileList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveUserOrderListEnabled(options)){
 			for(UserOrder item: newPlatform.getUserOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractProfileListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROFILE_LIST);
 	}
 	protected boolean isAnalyzeProfileListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeProfileListEnabled();
 	}
	
	protected boolean isSaveProfileListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROFILE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractUserOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.USER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeUserOrderListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeUserOrderListEnabled();
 	}
	
	protected boolean isSaveUserOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.USER_ORDER_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractProfileListEnabled(loadOptions)){
	 		extractProfileList(platform, loadOptions);
 		}	
 		if(isAnalyzeProfileListEnabled(loadOptions)){
	 		analyzeProfileList(platform, loadOptions);
 		}
 		
		
		if(isExtractUserOrderListEnabled(loadOptions)){
	 		extractUserOrderList(platform, loadOptions);
 		}	
 		if(isAnalyzeUserOrderListEnabled(loadOptions)){
	 		analyzeUserOrderList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = getProfileDAO().findProfileByPlatform(platform.getId(),options);
		if(profileList != null){
			enhanceProfileList(profileList,options);
			platform.setProfileList(profileList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList != null){
			getProfileDAO().analyzeProfileByPlatform(profileList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractUserOrderList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserOrder> userOrderList = getUserOrderDAO().findUserOrderByPlatform(platform.getId(),options);
		if(userOrderList != null){
			enhanceUserOrderList(userOrderList,options);
			platform.setUserOrderList(userOrderList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeUserOrderList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserOrder> userOrderList = platform.getUserOrderList();
		if(userOrderList != null){
			getUserOrderDAO().analyzeUserOrderByPlatform(userOrderList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getIntroduction();
 		parameters[2] = platform.getCurrentVersion();		
 		parameters[3] = platform.nextVersion();
 		parameters[4] = platform.getId();
 		parameters[5] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[4];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getIntroduction();
 		parameters[3] = platform.getCurrentVersion();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveProfileListEnabled(options)){
	 		saveProfileList(platform, options);
	 		//removeProfileList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveUserOrderListEnabled(options)){
	 		saveUserOrderList(platform, options);
	 		//removeUserOrderList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Profile.PLATFORM_PROPERTY, platform.getId());
		key.put(Profile.ID_PROPERTY, profileIds);
		
		SmartList<Profile> externalProfileList = getProfileDAO().
				findProfileWithKey(key, options);
		if(externalProfileList == null){
			return platform;
		}
		if(externalProfileList.isEmpty()){
			return platform;
		}
		
		for(Profile profile: externalProfileList){

			profile.clearFromAll();
		}
		
		
		SmartList<Profile> profileList = platform.getProfileList();		
		profileList.addAllToRemoveList(externalProfileList);
		return platform;	
	
	}


	public Platform planToRemoveUserOrderList(Platform platform, String userOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserOrder.PLATFORM_PROPERTY, platform.getId());
		key.put(UserOrder.ID_PROPERTY, userOrderIds);
		
		SmartList<UserOrder> externalUserOrderList = getUserOrderDAO().
				findUserOrderWithKey(key, options);
		if(externalUserOrderList == null){
			return platform;
		}
		if(externalUserOrderList.isEmpty()){
			return platform;
		}
		
		for(UserOrder userOrder: externalUserOrderList){

			userOrder.clearFromAll();
		}
		
		
		SmartList<UserOrder> userOrderList = platform.getUserOrderList();		
		userOrderList.addAllToRemoveList(externalUserOrderList);
		return platform;	
	
	}


	//disconnect Platform with user in UserOrder
	public Platform planToRemoveUserOrderListWithUser(Platform platform, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserOrder.PLATFORM_PROPERTY, platform.getId());
		key.put(UserOrder.USER_PROPERTY, userId);
		
		SmartList<UserOrder> externalUserOrderList = getUserOrderDAO().
				findUserOrderWithKey(key, options);
		if(externalUserOrderList == null){
			return platform;
		}
		if(externalUserOrderList.isEmpty()){
			return platform;
		}
		
		for(UserOrder userOrder: externalUserOrderList){
			userOrder.clearUser();
			userOrder.clearPlatform();
			
		}
		
		
		SmartList<UserOrder> userOrderList = platform.getUserOrderList();		
		userOrderList.addAllToRemoveList(externalUserOrderList);
		return platform;
	}
	
	public int countUserOrderListWithUser(String platformId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserOrder.PLATFORM_PROPERTY, platformId);
		key.put(UserOrder.USER_PROPERTY, userId);
		
		int count = getUserOrderDAO().countUserOrderWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveProfileList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Profile> mergedUpdateProfileList = new SmartList<Profile>();
		
		
		mergedUpdateProfileList.addAll(profileList); 
		if(profileList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProfileList.addAll(profileList.getToRemoveList());
			profileList.removeAll(profileList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProfileDAO().saveProfileList(mergedUpdateProfileList,options);
		
		if(profileList.getToRemoveList() != null){
			profileList.removeAll(profileList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProfileList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			return platform;
		}	
	
		SmartList<Profile> toRemoveProfileList = profileList.getToRemoveList();
		
		if(toRemoveProfileList == null){
			return platform;
		}
		if(toRemoveProfileList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProfileDAO().removeProfileList(toRemoveProfileList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveUserOrderList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<UserOrder> userOrderList = platform.getUserOrderList();
		if(userOrderList == null){
			//null list means nothing
			return platform;
		}
		SmartList<UserOrder> mergedUpdateUserOrderList = new SmartList<UserOrder>();
		
		
		mergedUpdateUserOrderList.addAll(userOrderList); 
		if(userOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserOrderList.addAll(userOrderList.getToRemoveList());
			userOrderList.removeAll(userOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserOrderDAO().saveUserOrderList(mergedUpdateUserOrderList,options);
		
		if(userOrderList.getToRemoveList() != null){
			userOrderList.removeAll(userOrderList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeUserOrderList(Platform platform, Map<String,Object> options){
	
	
		SmartList<UserOrder> userOrderList = platform.getUserOrderList();
		if(userOrderList == null){
			return platform;
		}	
	
		SmartList<UserOrder> toRemoveUserOrderList = userOrderList.getToRemoveList();
		
		if(toRemoveUserOrderList == null){
			return platform;
		}
		if(toRemoveUserOrderList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserOrderDAO().removeUserOrderList(toRemoveUserOrderList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentProfileList(platform,options);
		presentUserOrderList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProfileList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Profile> profileList = platform.getProfileList();		
				SmartList<Profile> newList= presentSubList(platform.getId(),
				profileList,
				options,
				getProfileDAO()::countProfileByPlatform,
				getProfileDAO()::findProfileByPlatform
				);

		
		platform.setProfileList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentUserOrderList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<UserOrder> userOrderList = platform.getUserOrderList();		
				SmartList<UserOrder> newList= presentSubList(platform.getId(),
				userOrderList,
				options,
				getUserOrderDAO()::countUserOrderByPlatform,
				getUserOrderDAO()::findUserOrderByPlatform
				);

		
		platform.setUserOrderList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForProfile(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForUserOrder(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


