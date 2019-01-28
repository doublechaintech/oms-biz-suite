
package com.doublechaintech.oms.profile;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class ProfileTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="profile";
	
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
	protected ProfileTokens(){
		//ensure not initialized outside the class
	}
	
	public ProfileTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProfileTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProfileTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProfileTokens start(){
		return new ProfileTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProfileTokens allTokens(){
		
		return start()
			.withPlatform()
			.withUserOrderList();
	
	}
	public static ProfileTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ProfileTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String USER_ORDER_LIST = "userOrderList";
	public String getUserOrderList(){
		return USER_ORDER_LIST;
	}
	public ProfileTokens withUserOrderList(){		
		addSimpleOptions(USER_ORDER_LIST);
		return this;
	}
	public ProfileTokens analyzeUserOrderList(){		
		addSimpleOptions(USER_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserOrderListEnabled(){		
		
		return checkOptions(this.options(), USER_ORDER_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromUserOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userOrderListSortCounter = 0;
	public ProfileTokens sortUserOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ORDER_LIST,userOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userOrderListSearchCounter = 0;
	public ProfileTokens searchUserOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ORDER_LIST,userOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfUserOrderList(String verb, String value){	
		String field = "id|title";
		addSearchMoreOptions(USER_ORDER_LIST,userOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfUserOrderList(int rowsPerPage){		
		addSimpleOptions(USER_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfUserOrderList(int currentPageNumber){		
		addSimpleOptions(USER_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfUserOrderList(String[] columns){		
		addSimpleOptions(USER_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfUserOrderList(String[] columns){		
		addSimpleOptions(USER_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserOrderList(verb, value);	
		return this;
	}
}

