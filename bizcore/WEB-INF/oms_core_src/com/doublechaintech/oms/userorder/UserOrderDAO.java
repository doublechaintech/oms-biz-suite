
package com.doublechaintech.oms.userorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.paymentgroup.PaymentGroupDAO;
import com.doublechaintech.oms.platform.PlatformDAO;
import com.doublechaintech.oms.orderpromotion.OrderPromotionDAO;
import com.doublechaintech.oms.manualadjustment.ManualAdjustmentDAO;
import com.doublechaintech.oms.shippinggroup.ShippingGroupDAO;
import com.doublechaintech.oms.profile.ProfileDAO;
import com.doublechaintech.oms.lineitem.LineItemDAO;


public interface UserOrderDAO{

	
	public UserOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserOrder> userOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserOrder present(UserOrder userOrder,Map<String,Object> options) throws Exception;
	public UserOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserOrder save(UserOrder userOrder,Map<String,Object> options);
	public SmartList<UserOrder> saveUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options);
	public SmartList<UserOrder> removeUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options);
	public SmartList<UserOrder> findUserOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userOrderId, int version) throws Exception;
	public UserOrder disconnectFromAll(String userOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LineItemDAO getLineItemDAO();
		
	public OrderPromotionDAO getOrderPromotionDAO();
		
	public ManualAdjustmentDAO getManualAdjustmentDAO();
		
	public ShippingGroupDAO getShippingGroupDAO();
		
	public PaymentGroupDAO getPaymentGroupDAO();
		
	
 	public SmartList<UserOrder> requestCandidateUserOrderForLineItem(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForOrderPromotion(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForManualAdjustment(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForShippingGroup(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForPaymentGroup(OmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserOrder planToRemoveLineItemList(UserOrder userOrder, String lineItemIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveOrderPromotionList(UserOrder userOrder, String orderPromotionIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveManualAdjustmentList(UserOrder userOrder, String manualAdjustmentIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveShippingGroupList(UserOrder userOrder, String shippingGroupIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemovePaymentGroupList(UserOrder userOrder, String paymentGroupIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserOrder> queryList(String sql, Object ... parmeters);
 
 	public SmartList<UserOrder> findUserOrderByUser(String profileId, Map<String,Object> options);
 	public int countUserOrderByUser(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countUserOrderByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserOrder> findUserOrderByUser(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeUserOrderByUser(SmartList<UserOrder> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId, Map<String,Object> options);
 	public int countUserOrderByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countUserOrderByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeUserOrderByPlatform(SmartList<UserOrder> resultList, String platformId, Map<String,Object> options);

 
 }


