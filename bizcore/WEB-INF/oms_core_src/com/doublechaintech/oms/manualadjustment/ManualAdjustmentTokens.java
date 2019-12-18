
package com.doublechaintech.oms.manualadjustment;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class ManualAdjustmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="manualAdjustment";
	
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
	protected ManualAdjustmentTokens(){
		//ensure not initialized outside the class
	}
	public  static  ManualAdjustmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ManualAdjustmentTokens tokens = new ManualAdjustmentTokens(options);
		return tokens;
		
	}
	protected ManualAdjustmentTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ManualAdjustmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ManualAdjustmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ManualAdjustmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ManualAdjustmentTokens start(){
		return new ManualAdjustmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ManualAdjustmentTokens allTokens(){
		
		return start()
			.withUserOrder();
	
	}
	public static ManualAdjustmentTokens withoutListsTokens(){
		
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
	
	public ManualAdjustmentTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USERORDER = "userOrder";
	public String getUserOrder(){
		return USERORDER;
	}
	public ManualAdjustmentTokens withUserOrder(){		
		addSimpleOptions(USERORDER);
		return this;
	}
	
	
	
	public  ManualAdjustmentTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

