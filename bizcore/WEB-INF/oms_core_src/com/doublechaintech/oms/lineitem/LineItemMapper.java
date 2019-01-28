
package com.doublechaintech.oms.lineitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.userorder.UserOrder;

public class LineItemMapper extends BaseRowMapper<LineItem>{
	
	protected LineItem internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LineItem lineItem = getLineItem();		
		 		
 		setId(lineItem, rs, rowNumber); 		
 		setName(lineItem, rs, rowNumber); 		
 		setQuantity(lineItem, rs, rowNumber); 		
 		setPrice(lineItem, rs, rowNumber); 		
 		setDiscountPrice(lineItem, rs, rowNumber); 		
 		setUserOrder(lineItem, rs, rowNumber); 		
 		setVersion(lineItem, rs, rowNumber);

		return lineItem;
	}
	
	protected LineItem getLineItem(){
		return new LineItem();
	}		
		
	protected void setId(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(LineItemTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setId(id);
	}
		
	protected void setName(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(LineItemTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setName(name);
	}
		
	protected void setQuantity(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer quantity = rs.getInt(LineItemTable.COLUMN_QUANTITY);
		if(quantity == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setQuantity(quantity);
	}
		
	protected void setPrice(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal price = rs.getBigDecimal(LineItemTable.COLUMN_PRICE);
		if(price == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setPrice(price);
	}
		
	protected void setDiscountPrice(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal discountPrice = rs.getBigDecimal(LineItemTable.COLUMN_DISCOUNT_PRICE);
		if(discountPrice == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setDiscountPrice(discountPrice);
	}
		 		
 	protected void setUserOrder(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
 		String userOrderId = rs.getString(LineItemTable.COLUMN_USER_ORDER);
 		if( userOrderId == null){
 			return;
 		}
 		if( userOrderId.isEmpty()){
 			return;
 		}
 		UserOrder userOrder = lineItem.getUserOrder();
 		if( userOrder != null ){
 			//if the root object 'lineItem' already have the property, just set the id for it;
 			userOrder.setId(userOrderId);
 			
 			return;
 		}
 		lineItem.setUserOrder(createEmptyUserOrder(userOrderId));
 	}
 	
	protected void setVersion(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(LineItemTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		lineItem.setVersion(version);
	}
		
		

 	protected UserOrder  createEmptyUserOrder(String userOrderId){
 		UserOrder userOrder = new UserOrder();
 		userOrder.setId(userOrderId);
 		userOrder.setVersion(Integer.MAX_VALUE);
 		return userOrder;
 	}
 	
}


