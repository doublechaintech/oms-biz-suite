
package com.doublechaintech.oms.paymentgroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface PaymentGroupManager{

		

	public PaymentGroup createPaymentGroup(OmsUserContext userContext, String name, BigDecimal amount, String userOrderId, String status) throws Exception;	
	public PaymentGroup updatePaymentGroup(OmsUserContext userContext,String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PaymentGroup loadPaymentGroup(OmsUserContext userContext, String paymentGroupId, String [] tokensExpr) throws Exception;
	public PaymentGroup internalSavePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup) throws Exception;
	public PaymentGroup internalSavePaymentGroup(OmsUserContext userContext, PaymentGroup paymentGroup,Map<String,Object>option) throws Exception;
	
	public PaymentGroup transferToAnotherUserOrder(OmsUserContext userContext, String paymentGroupId, String anotherUserOrderId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String paymentGroupId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, PaymentGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


