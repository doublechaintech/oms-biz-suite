
package com.doublechaintech.oms.paymentgroup;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface PaymentGroupDAO{

	
	public PaymentGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PaymentGroup> paymentGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PaymentGroup present(PaymentGroup paymentGroup,Map<String,Object> options) throws Exception;
	public PaymentGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PaymentGroup save(PaymentGroup paymentGroup,Map<String,Object> options);
	public SmartList<PaymentGroup> savePaymentGroupList(SmartList<PaymentGroup> paymentGroupList,Map<String,Object> options);
	public SmartList<PaymentGroup> removePaymentGroupList(SmartList<PaymentGroup> paymentGroupList,Map<String,Object> options);
	public SmartList<PaymentGroup> findPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPaymentGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String paymentGroupId, int version) throws Exception;
	public PaymentGroup disconnectFromAll(String paymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<PaymentGroup> queryList(String sql, Object ... parmeters);
 
 	public SmartList<PaymentGroup> findPaymentGroupByUserOrder(String userOrderId, Map<String,Object> options);
 	public int countPaymentGroupByUserOrder(String userOrderId, Map<String,Object> options);
 	public Map<String, Integer> countPaymentGroupByUserOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<PaymentGroup> findPaymentGroupByUserOrder(String userOrderId, int start, int count, Map<String,Object> options);
 	public void analyzePaymentGroupByUserOrder(SmartList<PaymentGroup> resultList, String userOrderId, Map<String,Object> options);

 
 }


