
package com.doublechaintech.oms.shippinggroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.userorder.UserOrder;

public class ShippingGroupMapper extends BaseRowMapper<ShippingGroup>{
	
	protected ShippingGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingGroup shippingGroup = getShippingGroup();		
		 		
 		setId(shippingGroup, rs, rowNumber); 		
 		setName(shippingGroup, rs, rowNumber); 		
 		setLine1(shippingGroup, rs, rowNumber); 		
 		setLine2(shippingGroup, rs, rowNumber); 		
 		setCity(shippingGroup, rs, rowNumber); 		
 		setState(shippingGroup, rs, rowNumber); 		
 		setZipCode(shippingGroup, rs, rowNumber); 		
 		setCountry(shippingGroup, rs, rowNumber); 		
 		setUserOrder(shippingGroup, rs, rowNumber); 		
 		setVersion(shippingGroup, rs, rowNumber);

		return shippingGroup;
	}
	
	protected ShippingGroup getShippingGroup(){
		return new ShippingGroup();
	}		
		
	protected void setId(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ShippingGroupTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setId(id);
	}
		
	protected void setName(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ShippingGroupTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setName(name);
	}
		
	protected void setLine1(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line1 = rs.getString(ShippingGroupTable.COLUMN_LINE1);
		if(line1 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setLine1(line1);
	}
		
	protected void setLine2(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line2 = rs.getString(ShippingGroupTable.COLUMN_LINE2);
		if(line2 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setLine2(line2);
	}
		
	protected void setCity(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String city = rs.getString(ShippingGroupTable.COLUMN_CITY);
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setCity(city);
	}
		
	protected void setState(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String state = rs.getString(ShippingGroupTable.COLUMN_STATE);
		if(state == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setState(state);
	}
		
	protected void setZipCode(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer zipCode = rs.getInt(ShippingGroupTable.COLUMN_ZIP_CODE);
		if(zipCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setZipCode(zipCode);
	}
		
	protected void setCountry(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String country = rs.getString(ShippingGroupTable.COLUMN_COUNTRY);
		if(country == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setCountry(country);
	}
		 		
 	protected void setUserOrder(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String userOrderId = rs.getString(ShippingGroupTable.COLUMN_USER_ORDER);
 		if( userOrderId == null){
 			return;
 		}
 		if( userOrderId.isEmpty()){
 			return;
 		}
 		UserOrder userOrder = shippingGroup.getUserOrder();
 		if( userOrder != null ){
 			//if the root object 'shippingGroup' already have the property, just set the id for it;
 			userOrder.setId(userOrderId);
 			
 			return;
 		}
 		shippingGroup.setUserOrder(createEmptyUserOrder(userOrderId));
 	}
 	
	protected void setVersion(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ShippingGroupTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingGroup.setVersion(version);
	}
		
		

 	protected UserOrder  createEmptyUserOrder(String userOrderId){
 		UserOrder userOrder = new UserOrder();
 		userOrder.setId(userOrderId);
 		userOrder.setVersion(Integer.MAX_VALUE);
 		return userOrder;
 	}
 	
}


