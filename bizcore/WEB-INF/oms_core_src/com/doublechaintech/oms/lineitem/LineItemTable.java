
package com.doublechaintech.oms.lineitem;
import com.doublechaintech.oms.AccessKey;


public class LineItemTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="line_item_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_QUANTITY = "quantity";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_DISCOUNT_PRICE = "discount_price";
	static final String COLUMN_USER_ORDER = "user_order";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DISCOUNT_PRICE, COLUMN_USER_ORDER, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DISCOUNT_PRICE, COLUMN_USER_ORDER
		};
	
	
}


