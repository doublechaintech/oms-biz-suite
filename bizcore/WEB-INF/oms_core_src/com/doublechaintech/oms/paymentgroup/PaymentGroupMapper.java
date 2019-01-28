
package com.doublechaintech.oms.paymentgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.userorder.UserOrder;

public class PaymentGroupMapper extends BaseRowMapper<PaymentGroup>{
	
	protected PaymentGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PaymentGroup paymentGroup = getPaymentGroup();		
		 		
 		setId(paymentGroup, rs, rowNumber); 		
 		setName(paymentGroup, rs, rowNumber); 		
 		setAmount(paymentGroup, rs, rowNumber); 		
 		setUserOrder(paymentGroup, rs, rowNumber); 		
 		setStatus(paymentGroup, rs, rowNumber); 		
 		setVersion(paymentGroup, rs, rowNumber);

		return paymentGroup;
	}
	
	protected PaymentGroup getPaymentGroup(){
		return new PaymentGroup();
	}		
		
	protected void setId(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PaymentGroupTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentGroup.setId(id);
	}
		
	protected void setName(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PaymentGroupTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentGroup.setName(name);
	}
		
	protected void setAmount(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal amount = rs.getBigDecimal(PaymentGroupTable.COLUMN_AMOUNT);
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentGroup.setAmount(amount);
	}
		 		
 	protected void setUserOrder(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String userOrderId = rs.getString(PaymentGroupTable.COLUMN_USER_ORDER);
 		if( userOrderId == null){
 			return;
 		}
 		if( userOrderId.isEmpty()){
 			return;
 		}
 		UserOrder userOrder = paymentGroup.getUserOrder();
 		if( userOrder != null ){
 			//if the root object 'paymentGroup' already have the property, just set the id for it;
 			userOrder.setId(userOrderId);
 			
 			return;
 		}
 		paymentGroup.setUserOrder(createEmptyUserOrder(userOrderId));
 	}
 	
	protected void setStatus(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String status = rs.getString(PaymentGroupTable.COLUMN_STATUS);
		if(status == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentGroup.setStatus(status);
	}
		
	protected void setVersion(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PaymentGroupTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentGroup.setVersion(version);
	}
		
		

 	protected UserOrder  createEmptyUserOrder(String userOrderId){
 		UserOrder userOrder = new UserOrder();
 		userOrder.setId(userOrderId);
 		userOrder.setVersion(Integer.MAX_VALUE);
 		return userOrder;
 	}
 	
}


