
package com.doublechaintech.oms.shippinggroup;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface ShippingGroupDAO{

	
	public ShippingGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ShippingGroup> shippingGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ShippingGroup present(ShippingGroup shippingGroup,Map<String,Object> options) throws Exception;
	public ShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ShippingGroup save(ShippingGroup shippingGroup,Map<String,Object> options);
	public SmartList<ShippingGroup> saveShippingGroupList(SmartList<ShippingGroup> shippingGroupList,Map<String,Object> options);
	public SmartList<ShippingGroup> removeShippingGroupList(SmartList<ShippingGroup> shippingGroupList,Map<String,Object> options);
	public SmartList<ShippingGroup> findShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String shippingGroupId, int version) throws Exception;
	public ShippingGroup disconnectFromAll(String shippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ShippingGroup> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ShippingGroup> findShippingGroupByUserOrder(String userOrderId, Map<String,Object> options);
 	public int countShippingGroupByUserOrder(String userOrderId, Map<String,Object> options);
 	public Map<String, Integer> countShippingGroupByUserOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ShippingGroup> findShippingGroupByUserOrder(String userOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeShippingGroupByUserOrder(SmartList<ShippingGroup> resultList, String userOrderId, Map<String,Object> options);

 
 }


