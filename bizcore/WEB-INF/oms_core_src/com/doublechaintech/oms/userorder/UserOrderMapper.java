
package com.doublechaintech.oms.userorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.oms.BaseRowMapper;
import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.platform.Platform;

public class UserOrderMapper extends BaseRowMapper<UserOrder>{
	
	protected UserOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserOrder userOrder = getUserOrder();		
		 		
 		setId(userOrder, rs, rowNumber); 		
 		setTitle(userOrder, rs, rowNumber); 		
 		setTotalAdjustment(userOrder, rs, rowNumber); 		
 		setTotalAmount(userOrder, rs, rowNumber); 		
 		setUser(userOrder, rs, rowNumber); 		
 		setPlatform(userOrder, rs, rowNumber); 		
 		setLastUpdateTime(userOrder, rs, rowNumber); 		
 		setVersion(userOrder, rs, rowNumber);

		return userOrder;
	}
	
	protected UserOrder getUserOrder(){
		return new UserOrder();
	}		
		
	protected void setId(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(UserOrderTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setId(id);
	}
		
	protected void setTitle(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(UserOrderTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setTitle(title);
	}
		
	protected void setTotalAdjustment(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal totalAdjustment = rs.getBigDecimal(UserOrderTable.COLUMN_TOTAL_ADJUSTMENT);
		if(totalAdjustment == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setTotalAdjustment(totalAdjustment);
	}
		
	protected void setTotalAmount(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal totalAmount = rs.getBigDecimal(UserOrderTable.COLUMN_TOTAL_AMOUNT);
		if(totalAmount == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setTotalAmount(totalAmount);
	}
		 		
 	protected void setUser(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(UserOrderTable.COLUMN_USER);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = userOrder.getUser();
 		if( profile != null ){
 			//if the root object 'userOrder' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		userOrder.setUser(createEmptyUser(profileId));
 	}
 	 		
 	protected void setPlatform(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(UserOrderTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = userOrder.getPlatform();
 		if( platform != null ){
 			//if the root object 'userOrder' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		userOrder.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setLastUpdateTime(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String lastUpdateTime = rs.getString(UserOrderTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setLastUpdateTime(lastUpdateTime);
	}
		
	protected void setVersion(UserOrder userOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(UserOrderTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userOrder.setVersion(version);
	}
		
		

 	protected Profile  createEmptyUser(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


