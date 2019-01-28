
package com.doublechaintech.oms.manualadjustment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.MultipleAccessKey;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.userorder.UserOrderDAO;


public interface ManualAdjustmentDAO{

	
	public ManualAdjustment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ManualAdjustment> manualAdjustmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ManualAdjustment present(ManualAdjustment manualAdjustment,Map<String,Object> options) throws Exception;
	public ManualAdjustment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ManualAdjustment save(ManualAdjustment manualAdjustment,Map<String,Object> options);
	public SmartList<ManualAdjustment> saveManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList,Map<String,Object> options);
	public SmartList<ManualAdjustment> removeManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList,Map<String,Object> options);
	public SmartList<ManualAdjustment> findManualAdjustmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countManualAdjustmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countManualAdjustmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String manualAdjustmentId, int version) throws Exception;
	public ManualAdjustment disconnectFromAll(String manualAdjustmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ManualAdjustment> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ManualAdjustment> findManualAdjustmentByUserOrder(String userOrderId, Map<String,Object> options);
 	public int countManualAdjustmentByUserOrder(String userOrderId, Map<String,Object> options);
 	public Map<String, Integer> countManualAdjustmentByUserOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ManualAdjustment> findManualAdjustmentByUserOrder(String userOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeManualAdjustmentByUserOrder(SmartList<ManualAdjustment> resultList, String userOrderId, Map<String,Object> options);

 
 }


