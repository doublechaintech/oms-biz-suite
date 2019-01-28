
package com.doublechaintech.oms.lineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface LineItemManager{

		

	public LineItem createLineItem(OmsUserContext userContext, String name, int quantity, BigDecimal price, BigDecimal discountPrice, String userOrderId) throws Exception;	
	public LineItem updateLineItem(OmsUserContext userContext,String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LineItem loadLineItem(OmsUserContext userContext, String lineItemId, String [] tokensExpr) throws Exception;
	public LineItem internalSaveLineItem(OmsUserContext userContext, LineItem lineItem) throws Exception;
	public LineItem internalSaveLineItem(OmsUserContext userContext, LineItem lineItem,Map<String,Object>option) throws Exception;
	
	public LineItem transferToAnotherUserOrder(OmsUserContext userContext, String lineItemId, String anotherUserOrderId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String lineItemId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, LineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


