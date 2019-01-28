
package com.doublechaintech.oms.userorder;
import com.doublechaintech.oms.CommonTokens;
import java.util.Map;
public class UserOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userOrder";
	
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
	protected UserOrderTokens(){
		//ensure not initialized outside the class
	}
	
	public UserOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserOrderTokens start(){
		return new UserOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserOrderTokens allTokens(){
		
		return start()
			.withUser()
			.withPlatform()
			.withLineItemList()
			.withOrderPromotionList()
			.withManualAdjustmentList()
			.withShippingGroupList()
			.withPaymentGroupList();
	
	}
	public static UserOrderTokens withoutListsTokens(){
		
		return start()
			.withUser()
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

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public UserOrderTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public UserOrderTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String LINE_ITEM_LIST = "lineItemList";
	public String getLineItemList(){
		return LINE_ITEM_LIST;
	}
	public UserOrderTokens withLineItemList(){		
		addSimpleOptions(LINE_ITEM_LIST);
		return this;
	}
	public UserOrderTokens analyzeLineItemList(){		
		addSimpleOptions(LINE_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLineItemListEnabled(){		
		
		return checkOptions(this.options(), LINE_ITEM_LIST+".anaylze");
	}
	public UserOrderTokens extractMoreFromLineItemList(String idsSeperatedWithComma){		
		addSimpleOptions(LINE_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int lineItemListSortCounter = 0;
	public UserOrderTokens sortLineItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(LINE_ITEM_LIST,lineItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int lineItemListSearchCounter = 0;
	public UserOrderTokens searchLineItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(LINE_ITEM_LIST,lineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserOrderTokens searchAllTextOfLineItemList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(LINE_ITEM_LIST,lineItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserOrderTokens rowsPerPageOfLineItemList(int rowsPerPage){		
		addSimpleOptions(LINE_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserOrderTokens currentPageNumberOfLineItemList(int currentPageNumber){		
		addSimpleOptions(LINE_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserOrderTokens retainColumnsOfLineItemList(String[] columns){		
		addSimpleOptions(LINE_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public UserOrderTokens excludeColumnsOfLineItemList(String[] columns){		
		addSimpleOptions(LINE_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String ORDER_PROMOTION_LIST = "orderPromotionList";
	public String getOrderPromotionList(){
		return ORDER_PROMOTION_LIST;
	}
	public UserOrderTokens withOrderPromotionList(){		
		addSimpleOptions(ORDER_PROMOTION_LIST);
		return this;
	}
	public UserOrderTokens analyzeOrderPromotionList(){		
		addSimpleOptions(ORDER_PROMOTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeOrderPromotionListEnabled(){		
		
		return checkOptions(this.options(), ORDER_PROMOTION_LIST+".anaylze");
	}
	public UserOrderTokens extractMoreFromOrderPromotionList(String idsSeperatedWithComma){		
		addSimpleOptions(ORDER_PROMOTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int orderPromotionListSortCounter = 0;
	public UserOrderTokens sortOrderPromotionListWith(String field, String descOrAsc){		
		addSortMoreOptions(ORDER_PROMOTION_LIST,orderPromotionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int orderPromotionListSearchCounter = 0;
	public UserOrderTokens searchOrderPromotionListWith(String field, String verb, String value){		
		addSearchMoreOptions(ORDER_PROMOTION_LIST,orderPromotionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserOrderTokens searchAllTextOfOrderPromotionList(String verb, String value){	
		String field = "id|name|type";
		addSearchMoreOptions(ORDER_PROMOTION_LIST,orderPromotionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserOrderTokens rowsPerPageOfOrderPromotionList(int rowsPerPage){		
		addSimpleOptions(ORDER_PROMOTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserOrderTokens currentPageNumberOfOrderPromotionList(int currentPageNumber){		
		addSimpleOptions(ORDER_PROMOTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserOrderTokens retainColumnsOfOrderPromotionList(String[] columns){		
		addSimpleOptions(ORDER_PROMOTION_LIST+"RetainColumns",columns);
		return this;
	}
	public UserOrderTokens excludeColumnsOfOrderPromotionList(String[] columns){		
		addSimpleOptions(ORDER_PROMOTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String MANUAL_ADJUSTMENT_LIST = "manualAdjustmentList";
	public String getManualAdjustmentList(){
		return MANUAL_ADJUSTMENT_LIST;
	}
	public UserOrderTokens withManualAdjustmentList(){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST);
		return this;
	}
	public UserOrderTokens analyzeManualAdjustmentList(){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeManualAdjustmentListEnabled(){		
		
		return checkOptions(this.options(), MANUAL_ADJUSTMENT_LIST+".anaylze");
	}
	public UserOrderTokens extractMoreFromManualAdjustmentList(String idsSeperatedWithComma){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int manualAdjustmentListSortCounter = 0;
	public UserOrderTokens sortManualAdjustmentListWith(String field, String descOrAsc){		
		addSortMoreOptions(MANUAL_ADJUSTMENT_LIST,manualAdjustmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int manualAdjustmentListSearchCounter = 0;
	public UserOrderTokens searchManualAdjustmentListWith(String field, String verb, String value){		
		addSearchMoreOptions(MANUAL_ADJUSTMENT_LIST,manualAdjustmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserOrderTokens searchAllTextOfManualAdjustmentList(String verb, String value){	
		String field = "id|name|type";
		addSearchMoreOptions(MANUAL_ADJUSTMENT_LIST,manualAdjustmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserOrderTokens rowsPerPageOfManualAdjustmentList(int rowsPerPage){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserOrderTokens currentPageNumberOfManualAdjustmentList(int currentPageNumber){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserOrderTokens retainColumnsOfManualAdjustmentList(String[] columns){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public UserOrderTokens excludeColumnsOfManualAdjustmentList(String[] columns){		
		addSimpleOptions(MANUAL_ADJUSTMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	public String getShippingGroupList(){
		return SHIPPING_GROUP_LIST;
	}
	public UserOrderTokens withShippingGroupList(){		
		addSimpleOptions(SHIPPING_GROUP_LIST);
		return this;
	}
	public UserOrderTokens analyzeShippingGroupList(){		
		addSimpleOptions(SHIPPING_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzeShippingGroupListEnabled(){		
		
		return checkOptions(this.options(), SHIPPING_GROUP_LIST+".anaylze");
	}
	public UserOrderTokens extractMoreFromShippingGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(SHIPPING_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int shippingGroupListSortCounter = 0;
	public UserOrderTokens sortShippingGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(SHIPPING_GROUP_LIST,shippingGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int shippingGroupListSearchCounter = 0;
	public UserOrderTokens searchShippingGroupListWith(String field, String verb, String value){		
		addSearchMoreOptions(SHIPPING_GROUP_LIST,shippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserOrderTokens searchAllTextOfShippingGroupList(String verb, String value){	
		String field = "id|name|line1|line2|city|state|country";
		addSearchMoreOptions(SHIPPING_GROUP_LIST,shippingGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserOrderTokens rowsPerPageOfShippingGroupList(int rowsPerPage){		
		addSimpleOptions(SHIPPING_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserOrderTokens currentPageNumberOfShippingGroupList(int currentPageNumber){		
		addSimpleOptions(SHIPPING_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserOrderTokens retainColumnsOfShippingGroupList(String[] columns){		
		addSimpleOptions(SHIPPING_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public UserOrderTokens excludeColumnsOfShippingGroupList(String[] columns){		
		addSimpleOptions(SHIPPING_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	public String getPaymentGroupList(){
		return PAYMENT_GROUP_LIST;
	}
	public UserOrderTokens withPaymentGroupList(){		
		addSimpleOptions(PAYMENT_GROUP_LIST);
		return this;
	}
	public UserOrderTokens analyzePaymentGroupList(){		
		addSimpleOptions(PAYMENT_GROUP_LIST+".anaylze");
		return this;
	}
	public boolean analyzePaymentGroupListEnabled(){		
		
		return checkOptions(this.options(), PAYMENT_GROUP_LIST+".anaylze");
	}
	public UserOrderTokens extractMoreFromPaymentGroupList(String idsSeperatedWithComma){		
		addSimpleOptions(PAYMENT_GROUP_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int paymentGroupListSortCounter = 0;
	public UserOrderTokens sortPaymentGroupListWith(String field, String descOrAsc){		
		addSortMoreOptions(PAYMENT_GROUP_LIST,paymentGroupListSortCounter++, field, descOrAsc);
		return this;
	}
	private int paymentGroupListSearchCounter = 0;
	public UserOrderTokens searchPaymentGroupListWith(String field, String verb, String value){		
		addSearchMoreOptions(PAYMENT_GROUP_LIST,paymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserOrderTokens searchAllTextOfPaymentGroupList(String verb, String value){	
		String field = "id|name|status";
		addSearchMoreOptions(PAYMENT_GROUP_LIST,paymentGroupListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserOrderTokens rowsPerPageOfPaymentGroupList(int rowsPerPage){		
		addSimpleOptions(PAYMENT_GROUP_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserOrderTokens currentPageNumberOfPaymentGroupList(int currentPageNumber){		
		addSimpleOptions(PAYMENT_GROUP_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserOrderTokens retainColumnsOfPaymentGroupList(String[] columns){		
		addSimpleOptions(PAYMENT_GROUP_LIST+"RetainColumns",columns);
		return this;
	}
	public UserOrderTokens excludeColumnsOfPaymentGroupList(String[] columns){		
		addSimpleOptions(PAYMENT_GROUP_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  UserOrderTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLineItemList(verb, value);	
		searchAllTextOfOrderPromotionList(verb, value);	
		searchAllTextOfManualAdjustmentList(verb, value);	
		searchAllTextOfShippingGroupList(verb, value);	
		searchAllTextOfPaymentGroupList(verb, value);	
		return this;
	}
}

