
package com.doublechaintech.oms.manualadjustment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface ManualAdjustmentManager{

		

	public ManualAdjustment createManualAdjustment(OmsUserContext userContext, String name, int amount, int threadHold, String type, String userOrderId) throws Exception;	
	public ManualAdjustment updateManualAdjustment(OmsUserContext userContext,String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ManualAdjustment loadManualAdjustment(OmsUserContext userContext, String manualAdjustmentId, String [] tokensExpr) throws Exception;
	public ManualAdjustment internalSaveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment) throws Exception;
	public ManualAdjustment internalSaveManualAdjustment(OmsUserContext userContext, ManualAdjustment manualAdjustment,Map<String,Object>option) throws Exception;
	
	public ManualAdjustment transferToAnotherUserOrder(OmsUserContext userContext, String manualAdjustmentId, String anotherUserOrderId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String manualAdjustmentId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, ManualAdjustment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


