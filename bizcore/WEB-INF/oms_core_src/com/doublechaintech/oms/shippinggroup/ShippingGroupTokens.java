
package com.doublechaintech.oms.shippinggroup;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class ShippingGroupTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="shippingGroup";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ShippingGroupTokens(){
		//ensure not initialized outside the class
	}
	
	public ShippingGroupTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ShippingGroupTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ShippingGroupTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ShippingGroupTokens start(){
		return new ShippingGroupTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ShippingGroupTokens allTokens(){
		
		return start()
			.withUserOrder();
	
	}
	public static ShippingGroupTokens withoutListsTokens(){
		
		return start()
			.withUserOrder();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String USERORDER = "userOrder";
	public String getUserOrder(){
		return USERORDER;
	}
	public ShippingGroupTokens withUserOrder(){		
		addSimpleOptions(USERORDER);
		return this;
	}
	
	
	
	public  ShippingGroupTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

