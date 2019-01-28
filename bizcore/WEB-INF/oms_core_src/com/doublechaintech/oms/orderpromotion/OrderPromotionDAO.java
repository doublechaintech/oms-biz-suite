
package com.doublechaintech.oms.orderpromotion;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface OrderPromotionDAO{

	
	public OrderPromotion load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OrderPromotion> orderPromotionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OrderPromotion present(OrderPromotion orderPromotion,Map<String,Object> options) throws Exception;
	public OrderPromotion clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OrderPromotion save(OrderPromotion orderPromotion,Map<String,Object> options);
	public SmartList<OrderPromotion> saveOrderPromotionList(SmartList<OrderPromotion> orderPromotionList,Map<String,Object> options);
	public SmartList<OrderPromotion> removeOrderPromotionList(SmartList<OrderPromotion> orderPromotionList,Map<String,Object> options);
	public SmartList<OrderPromotion> findOrderPromotionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOrderPromotionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOrderPromotionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String orderPromotionId, int version) throws Exception;
	public OrderPromotion disconnectFromAll(String orderPromotionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<OrderPromotion> queryList(String sql, Object ... parmeters);
 
 	public SmartList<OrderPromotion> findOrderPromotionByUserOrder(String userOrderId, Map<String,Object> options);
 	public int countOrderPromotionByUserOrder(String userOrderId, Map<String,Object> options);
 	public Map<String, Integer> countOrderPromotionByUserOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<OrderPromotion> findOrderPromotionByUserOrder(String userOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeOrderPromotionByUserOrder(SmartList<OrderPromotion> resultList, String userOrderId, Map<String,Object> options);

 
 }


