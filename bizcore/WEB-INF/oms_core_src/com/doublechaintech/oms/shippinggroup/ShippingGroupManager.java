
package com.doublechaintech.oms.shippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface ShippingGroupManager{

		

	public ShippingGroup createShippingGroup(OmsUserContext userContext, String name, String line1, String line2, String city, String state, int zipCode, String country, String userOrderId) throws Exception;	
	public ShippingGroup updateShippingGroup(OmsUserContext userContext,String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ShippingGroup loadShippingGroup(OmsUserContext userContext, String shippingGroupId, String [] tokensExpr) throws Exception;
	public ShippingGroup internalSaveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup) throws Exception;
	public ShippingGroup internalSaveShippingGroup(OmsUserContext userContext, ShippingGroup shippingGroup,Map<String,Object>option) throws Exception;
	
	public ShippingGroup transferToAnotherUserOrder(OmsUserContext userContext, String shippingGroupId, String anotherUserOrderId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String shippingGroupId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, ShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


