
package com.doublechaintech.oms.profile;
import com.doublechaintech.oms.AccessKey;


public class ProfileTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="profile_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_AGE = "age";
	static final String COLUMN_GENDER = "gender";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_AGE, COLUMN_GENDER, COLUMN_LAST_UPDATE_TIME, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_AGE, COLUMN_GENDER, COLUMN_LAST_UPDATE_TIME, COLUMN_PLATFORM
		};
	
	
}


