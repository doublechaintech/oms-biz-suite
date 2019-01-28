
package com.doublechaintech.oms.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.profile.ProfileDAO;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProfileDAO getProfileDAO();
		
	public UserOrderDAO getUserOrderDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForProfile(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForUserOrder(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveUserOrderList(Platform platform, String userOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with user in UserOrder
	public Platform planToRemoveUserOrderListWithUser(Platform platform, String userId, Map<String,Object> options)throws Exception;
	public int countUserOrderListWithUser(String platformId, String userId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


