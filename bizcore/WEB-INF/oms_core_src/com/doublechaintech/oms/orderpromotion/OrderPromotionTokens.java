
package com.doublechaintech.oms.orderpromotion;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class OrderPromotionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="orderPromotion";
	
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
	protected OrderPromotionTokens(){
		//ensure not initialized outside the class
	}
	public  static  OrderPromotionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		OrderPromotionTokens tokens = new OrderPromotionTokens(options);
		return tokens;
		
	}
	protected OrderPromotionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public OrderPromotionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static OrderPromotionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected OrderPromotionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static OrderPromotionTokens start(){
		return new OrderPromotionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static OrderPromotionTokens allTokens(){
		
		return start()
			.withUserOrder();
	
	}
	public static OrderPromotionTokens withoutListsTokens(){
		
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
	
	public OrderPromotionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USERORDER = "userOrder";
	public String getUserOrder(){
		return USERORDER;
	}
	public OrderPromotionTokens withUserOrder(){		
		addSimpleOptions(USERORDER);
		return this;
	}
	
	
	
	public  OrderPromotionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

