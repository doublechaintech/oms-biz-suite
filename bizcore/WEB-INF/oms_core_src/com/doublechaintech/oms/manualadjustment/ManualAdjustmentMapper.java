
package com.doublechaintech.oms.manualadjustment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.userorder.UserOrder;

public class ManualAdjustmentMapper extends BaseRowMapper<ManualAdjustment>{
	
	protected ManualAdjustment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ManualAdjustment manualAdjustment = getManualAdjustment();		
		 		
 		setId(manualAdjustment, rs, rowNumber); 		
 		setName(manualAdjustment, rs, rowNumber); 		
 		setAmount(manualAdjustment, rs, rowNumber); 		
 		setThreadHold(manualAdjustment, rs, rowNumber); 		
 		setType(manualAdjustment, rs, rowNumber); 		
 		setUserOrder(manualAdjustment, rs, rowNumber); 		
 		setVersion(manualAdjustment, rs, rowNumber);

		return manualAdjustment;
	}
	
	protected ManualAdjustment getManualAdjustment(){
		return new ManualAdjustment();
	}		
		
	protected void setId(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ManualAdjustmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setId(id);
	}
		
	protected void setName(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ManualAdjustmentTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setName(name);
	}
		
	protected void setAmount(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer amount = rs.getInt(ManualAdjustmentTable.COLUMN_AMOUNT);
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setAmount(amount);
	}
		
	protected void setThreadHold(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer threadHold = rs.getInt(ManualAdjustmentTable.COLUMN_THREAD_HOLD);
		if(threadHold == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setThreadHold(threadHold);
	}
		
	protected void setType(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String type = rs.getString(ManualAdjustmentTable.COLUMN_TYPE);
		if(type == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setType(type);
	}
		 		
 	protected void setUserOrder(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
 		String userOrderId = rs.getString(ManualAdjustmentTable.COLUMN_USER_ORDER);
 		if( userOrderId == null){
 			return;
 		}
 		if( userOrderId.isEmpty()){
 			return;
 		}
 		UserOrder userOrder = manualAdjustment.getUserOrder();
 		if( userOrder != null ){
 			//if the root object 'manualAdjustment' already have the property, just set the id for it;
 			userOrder.setId(userOrderId);
 			
 			return;
 		}
 		manualAdjustment.setUserOrder(createEmptyUserOrder(userOrderId));
 	}
 	
	protected void setVersion(ManualAdjustment manualAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ManualAdjustmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		manualAdjustment.setVersion(version);
	}
		
		

 	protected UserOrder  createEmptyUserOrder(String userOrderId){
 		UserOrder userOrder = new UserOrder();
 		userOrder.setId(userOrderId);
 		userOrder.setVersion(Integer.MAX_VALUE);
 		return userOrder;
 	}
 	
}


