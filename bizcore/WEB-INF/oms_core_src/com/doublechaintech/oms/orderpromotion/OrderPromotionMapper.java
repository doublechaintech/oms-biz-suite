
package com.doublechaintech.oms.orderpromotion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.userorder.UserOrder;

public class OrderPromotionMapper extends BaseRowMapper<OrderPromotion>{
	
	protected OrderPromotion internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OrderPromotion orderPromotion = getOrderPromotion();		
		 		
 		setId(orderPromotion, rs, rowNumber); 		
 		setName(orderPromotion, rs, rowNumber); 		
 		setAmount(orderPromotion, rs, rowNumber); 		
 		setThreadHold(orderPromotion, rs, rowNumber); 		
 		setType(orderPromotion, rs, rowNumber); 		
 		setUserOrder(orderPromotion, rs, rowNumber); 		
 		setVersion(orderPromotion, rs, rowNumber);

		return orderPromotion;
	}
	
	protected OrderPromotion getOrderPromotion(){
		return new OrderPromotion();
	}		
		
	protected void setId(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OrderPromotionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setId(id);
	}
		
	protected void setName(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(OrderPromotionTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setName(name);
	}
		
	protected void setAmount(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer amount = rs.getInt(OrderPromotionTable.COLUMN_AMOUNT);
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setAmount(amount);
	}
		
	protected void setThreadHold(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer threadHold = rs.getInt(OrderPromotionTable.COLUMN_THREAD_HOLD);
		if(threadHold == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setThreadHold(threadHold);
	}
		
	protected void setType(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String type = rs.getString(OrderPromotionTable.COLUMN_TYPE);
		if(type == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setType(type);
	}
		 		
 	protected void setUserOrder(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
 		String userOrderId = rs.getString(OrderPromotionTable.COLUMN_USER_ORDER);
 		if( userOrderId == null){
 			return;
 		}
 		if( userOrderId.isEmpty()){
 			return;
 		}
 		UserOrder userOrder = orderPromotion.getUserOrder();
 		if( userOrder != null ){
 			//if the root object 'orderPromotion' already have the property, just set the id for it;
 			userOrder.setId(userOrderId);
 			
 			return;
 		}
 		orderPromotion.setUserOrder(createEmptyUserOrder(userOrderId));
 	}
 	
	protected void setVersion(OrderPromotion orderPromotion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OrderPromotionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		orderPromotion.setVersion(version);
	}
		
		

 	protected UserOrder  createEmptyUserOrder(String userOrderId){
 		UserOrder userOrder = new UserOrder();
 		userOrder.setId(userOrderId);
 		userOrder.setVersion(Integer.MAX_VALUE);
 		return userOrder;
 	}
 	
}


