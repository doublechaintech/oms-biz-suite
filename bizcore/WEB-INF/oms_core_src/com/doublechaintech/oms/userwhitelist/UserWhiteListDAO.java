
package com.doublechaintech.oms.userwhitelist;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userdomain.UserDomainDAO;


public interface UserWhiteListDAO{

	
	public UserWhiteList load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserWhiteList> userWhiteListList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserWhiteList present(UserWhiteList userWhiteList,Map<String,Object> options) throws Exception;
	public UserWhiteList clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserWhiteList save(UserWhiteList userWhiteList,Map<String,Object> options);
	public SmartList<UserWhiteList> saveUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options);
	public SmartList<UserWhiteList> removeUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options);
	public SmartList<UserWhiteList> findUserWhiteListWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserWhiteListWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserWhiteListWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userWhiteListId, int version) throws Exception;
	public UserWhiteList disconnectFromAll(String userWhiteListId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<UserWhiteList> queryList(String sql, Object ... parmeters);
 
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId, Map<String,Object> options);
 	public int countUserWhiteListByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countUserWhiteListByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzeUserWhiteListByDomain(SmartList<UserWhiteList> resultList, String userDomainId, Map<String,Object> options);

 
 }


