
package com.doublechaintech.oms.lineitem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface LineItemDAO{

	
	public LineItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LineItem> lineItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LineItem present(LineItem lineItem,Map<String,Object> options) throws Exception;
	public LineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LineItem save(LineItem lineItem,Map<String,Object> options);
	public SmartList<LineItem> saveLineItemList(SmartList<LineItem> lineItemList,Map<String,Object> options);
	public SmartList<LineItem> removeLineItemList(SmartList<LineItem> lineItemList,Map<String,Object> options);
	public SmartList<LineItem> findLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String lineItemId, int version) throws Exception;
	public LineItem disconnectFromAll(String lineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<LineItem> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LineItem> findLineItemByUserOrder(String userOrderId, Map<String,Object> options);
 	public int countLineItemByUserOrder(String userOrderId, Map<String,Object> options);
 	public Map<String, Integer> countLineItemByUserOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<LineItem> findLineItemByUserOrder(String userOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeLineItemByUserOrder(SmartList<LineItem> resultList, String userOrderId, Map<String,Object> options);

 
 }


