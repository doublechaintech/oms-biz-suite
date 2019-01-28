
package com.doublechaintech.oms.orderpromotion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface OrderPromotionManager{

		

	public OrderPromotion createOrderPromotion(OmsUserContext userContext, String name, int amount, int threadHold, String type, String userOrderId) throws Exception;	
	public OrderPromotion updateOrderPromotion(OmsUserContext userContext,String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OrderPromotion loadOrderPromotion(OmsUserContext userContext, String orderPromotionId, String [] tokensExpr) throws Exception;
	public OrderPromotion internalSaveOrderPromotion(OmsUserContext userContext, OrderPromotion orderPromotion) throws Exception;
	public OrderPromotion internalSaveOrderPromotion(OmsUserContext userContext, OrderPromotion orderPromotion,Map<String,Object>option) throws Exception;
	
	public OrderPromotion transferToAnotherUserOrder(OmsUserContext userContext, String orderPromotionId, String anotherUserOrderId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String orderPromotionId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, OrderPromotion newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


