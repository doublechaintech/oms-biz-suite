
package com.doublechaintech.oms.userorder;
import com.doublechaintech.oms.AccessKey;


public class UserOrderTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="user_order_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_TOTAL_ADJUSTMENT = "total_adjustment";
	static final String COLUMN_TOTAL_AMOUNT = "total_amount";
	static final String COLUMN_USER = "user";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_TOTAL_ADJUSTMENT, COLUMN_TOTAL_AMOUNT, COLUMN_USER, COLUMN_PLATFORM, COLUMN_LAST_UPDATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_TOTAL_ADJUSTMENT, COLUMN_TOTAL_AMOUNT, COLUMN_USER, COLUMN_PLATFORM, COLUMN_LAST_UPDATE_TIME
		};
	
	
}


