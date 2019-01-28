
package com.doublechaintech.oms.userorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface UserOrderManager{

		

	public UserOrder createUserOrder(OmsUserContext userContext, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String platformId, String lastUpdateTime) throws Exception;	
	public UserOrder updateUserOrder(OmsUserContext userContext,String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserOrder loadUserOrder(OmsUserContext userContext, String userOrderId, String [] tokensExpr) throws Exception;
	public UserOrder internalSaveUserOrder(OmsUserContext userContext, UserOrder userOrder) throws Exception;
	public UserOrder internalSaveUserOrder(OmsUserContext userContext, UserOrder userOrder,Map<String,Object>option) throws Exception;
	
	public UserOrder transferToAnotherUser(OmsUserContext userContext, String userOrderId, String anotherUserId)  throws Exception;
 	public UserOrder transferToAnotherPlatform(OmsUserContext userContext, String userOrderId, String anotherPlatformId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String userOrderId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, UserOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LineItemManager getLineItemManager(OmsUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addLineItem(OmsUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice , String [] tokensExpr)  throws Exception;
	public  UserOrder removeLineItem(OmsUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateLineItem(OmsUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  OrderPromotionManager getOrderPromotionManager(OmsUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addOrderPromotion(OmsUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type , String [] tokensExpr)  throws Exception;
	public  UserOrder removeOrderPromotion(OmsUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateOrderPromotion(OmsUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ManualAdjustmentManager getManualAdjustmentManager(OmsUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addManualAdjustment(OmsUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type , String [] tokensExpr)  throws Exception;
	public  UserOrder removeManualAdjustment(OmsUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateManualAdjustment(OmsUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ShippingGroupManager getShippingGroupManager(OmsUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addShippingGroup(OmsUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country , String [] tokensExpr)  throws Exception;
	public  UserOrder removeShippingGroup(OmsUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateShippingGroup(OmsUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PaymentGroupManager getPaymentGroupManager(OmsUserContext userContext, String userOrderId, String name, BigDecimal amount, String status ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addPaymentGroup(OmsUserContext userContext, String userOrderId, String name, BigDecimal amount, String status , String [] tokensExpr)  throws Exception;
	public  UserOrder removePaymentGroup(OmsUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updatePaymentGroup(OmsUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


