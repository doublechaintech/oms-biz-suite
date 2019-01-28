
package com.doublechaintech.oms.platform;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
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
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withProfileList()
			.withUserOrderList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String PROFILE_LIST = "profileList";
	public String getProfileList(){
		return PROFILE_LIST;
	}
	public PlatformTokens withProfileList(){		
		addSimpleOptions(PROFILE_LIST);
		return this;
	}
	public PlatformTokens analyzeProfileList(){		
		addSimpleOptions(PROFILE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProfileListEnabled(){		
		
		return checkOptions(this.options(), PROFILE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromProfileList(String idsSeperatedWithComma){		
		addSimpleOptions(PROFILE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int profileListSortCounter = 0;
	public PlatformTokens sortProfileListWith(String field, String descOrAsc){		
		addSortMoreOptions(PROFILE_LIST,profileListSortCounter++, field, descOrAsc);
		return this;
	}
	private int profileListSearchCounter = 0;
	public PlatformTokens searchProfileListWith(String field, String verb, String value){		
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfProfileList(String verb, String value){	
		String field = "id|name|gender";
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProfileList(int rowsPerPage){		
		addSimpleOptions(PROFILE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProfileList(int currentPageNumber){		
		addSimpleOptions(PROFILE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String USER_ORDER_LIST = "userOrderList";
	public String getUserOrderList(){
		return USER_ORDER_LIST;
	}
	public PlatformTokens withUserOrderList(){		
		addSimpleOptions(USER_ORDER_LIST);
		return this;
	}
	public PlatformTokens analyzeUserOrderList(){		
		addSimpleOptions(USER_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserOrderListEnabled(){		
		
		return checkOptions(this.options(), USER_ORDER_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromUserOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userOrderListSortCounter = 0;
	public PlatformTokens sortUserOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ORDER_LIST,userOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userOrderListSearchCounter = 0;
	public PlatformTokens searchUserOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ORDER_LIST,userOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfUserOrderList(String verb, String value){	
		String field = "id|title|lastUpdateTime";
		addSearchMoreOptions(USER_ORDER_LIST,userOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfUserOrderList(int rowsPerPage){		
		addSimpleOptions(USER_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfUserOrderList(int currentPageNumber){		
		addSimpleOptions(USER_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfUserOrderList(String[] columns){		
		addSimpleOptions(USER_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfUserOrderList(String[] columns){		
		addSimpleOptions(USER_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfProfileList(verb, value);	
		searchAllTextOfUserOrderList(verb, value);	
		return this;
	}
}

