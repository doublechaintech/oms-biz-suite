
package com.doublechaintech.oms.secuserblocking;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.secuser.SecUserDAO;


public interface SecUserBlockingDAO{

	
	public SecUserBlocking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SecUserBlocking> secUserBlockingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SecUserBlocking present(SecUserBlocking secUserBlocking,Map<String,Object> options) throws Exception;
	public SecUserBlocking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SecUserBlocking save(SecUserBlocking secUserBlocking,Map<String,Object> options);
	public SmartList<SecUserBlocking> saveSecUserBlockingList(SmartList<SecUserBlocking> secUserBlockingList,Map<String,Object> options);
	public SmartList<SecUserBlocking> removeSecUserBlockingList(SmartList<SecUserBlocking> secUserBlockingList,Map<String,Object> options);
	public SmartList<SecUserBlocking> findSecUserBlockingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSecUserBlockingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSecUserBlockingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String secUserBlockingId, int version) throws Exception;
	public SecUserBlocking disconnectFromAll(String secUserBlockingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SecUserDAO getSecUserDAO();
		
	
 	public SmartList<SecUserBlocking> requestCandidateSecUserBlockingForSecUser(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SecUserBlocking planToRemoveSecUserList(SecUserBlocking secUserBlocking, String secUserIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUserBlocking with domain in SecUser
	public SecUserBlocking planToRemoveSecUserListWithDomain(SecUserBlocking secUserBlocking, String domainId, Map<String,Object> options)throws Exception;
	public int countSecUserListWithDomain(String secUserBlockingId, String domainId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SecUserBlocking> queryList(String sql, Object ... parmeters);
}


