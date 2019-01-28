
package com.doublechaintech.oms.userorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.oms.paymentgroup.PaymentGroup;
import com.doublechaintech.oms.lineitem.LineItem;
import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.orderpromotion.OrderPromotion;
import com.doublechaintech.oms.manualadjustment.ManualAdjustment;
import com.doublechaintech.oms.shippinggroup.ShippingGroup;
import com.doublechaintech.oms.platform.Platform;

@JsonSerialize(using = UserOrderSerializer.class)
public class UserOrder extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String TOTAL_ADJUSTMENT_PROPERTY      = "totalAdjustment"   ;
	public static final String TOTAL_AMOUNT_PROPERTY          = "totalAmount"       ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LINE_ITEM_LIST                           = "lineItemList"      ;
	public static final String ORDER_PROMOTION_LIST                     = "orderPromotionList";
	public static final String MANUAL_ADJUSTMENT_LIST                   = "manualAdjustmentList";
	public static final String SHIPPING_GROUP_LIST                      = "shippingGroupList" ;
	public static final String PAYMENT_GROUP_LIST                       = "paymentGroupList"  ;

	public static final String INTERNAL_TYPE="UserOrder";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		BigDecimal          	mTotalAdjustment    ;
	protected		BigDecimal          	mTotalAmount        ;
	protected		Profile             	mUser               ;
	protected		Platform            	mPlatform           ;
	protected		String              	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LineItem> 	mLineItemList       ;
	protected		SmartList<OrderPromotion>	mOrderPromotionList ;
	protected		SmartList<ManualAdjustment>	mManualAdjustmentList;
	protected		SmartList<ShippingGroup>	mShippingGroupList  ;
	protected		SmartList<PaymentGroup>	mPaymentGroupList   ;
	
		
	public 	UserOrder(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	UserOrder(String title, BigDecimal totalAdjustment, BigDecimal totalAmount, Profile user, Platform platform, String lastUpdateTime)
	{
		setTitle(title);
		setTotalAdjustment(totalAdjustment);
		setTotalAmount(totalAmount);
		setUser(user);
		setPlatform(platform);
		setLastUpdateTime(lastUpdateTime);

		this.mLineItemList = new SmartList<LineItem>();
		this.mOrderPromotionList = new SmartList<OrderPromotion>();
		this.mManualAdjustmentList = new SmartList<ManualAdjustment>();
		this.mShippingGroupList = new SmartList<ShippingGroup>();
		this.mPaymentGroupList = new SmartList<PaymentGroup>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(TOTAL_ADJUSTMENT_PROPERTY.equals(property)){
			changeTotalAdjustmentProperty(newValueExpr);
		}
		if(TOTAL_AMOUNT_PROPERTY.equals(property)){
			changeTotalAmountProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTotalAdjustmentProperty(String newValueExpr){
		BigDecimal oldValue = getTotalAdjustment();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTotalAdjustment(newValue);
		this.onChangeProperty(TOTAL_ADJUSTMENT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTotalAmountProperty(String newValueExpr){
		BigDecimal oldValue = getTotalAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTotalAmount(newValue);
		this.onChangeProperty(TOTAL_AMOUNT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		String oldValue = getLastUpdateTime();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public UserOrder updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public UserOrder updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setTotalAdjustment(BigDecimal totalAdjustment){
		this.mTotalAdjustment = totalAdjustment;;
	}
	public BigDecimal getTotalAdjustment(){
		return this.mTotalAdjustment;
	}
	public UserOrder updateTotalAdjustment(BigDecimal totalAdjustment){
		this.mTotalAdjustment = totalAdjustment;;
		this.changed = true;
		return this;
	}
	
	
	public void setTotalAmount(BigDecimal totalAmount){
		this.mTotalAmount = totalAmount;;
	}
	public BigDecimal getTotalAmount(){
		return this.mTotalAmount;
	}
	public UserOrder updateTotalAmount(BigDecimal totalAmount){
		this.mTotalAmount = totalAmount;;
		this.changed = true;
		return this;
	}
	
	
	public void setUser(Profile user){
		this.mUser = user;;
	}
	public Profile getUser(){
		return this.mUser;
	}
	public UserOrder updateUser(Profile user){
		this.mUser = user;;
		this.changed = true;
		return this;
	}
	
	
	public void clearUser(){
		setUser ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public UserOrder updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(String lastUpdateTime){
		this.mLastUpdateTime = trimString(lastUpdateTime);;
	}
	public String getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public UserOrder updateLastUpdateTime(String lastUpdateTime){
		this.mLastUpdateTime = trimString(lastUpdateTime);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public UserOrder updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LineItem> getLineItemList(){
		if(this.mLineItemList == null){
			this.mLineItemList = new SmartList<LineItem>();
			this.mLineItemList.setListInternalName (LINE_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLineItemList;	
	}
	public  void setLineItemList(SmartList<LineItem> lineItemList){
		for( LineItem lineItem:lineItemList){
			lineItem.setUserOrder(this);
		}

		this.mLineItemList = lineItemList;
		this.mLineItemList.setListInternalName (LINE_ITEM_LIST );
		
	}
	
	public  void addLineItem(LineItem lineItem){
		lineItem.setUserOrder(this);
		getLineItemList().add(lineItem);
	}
	public  void addLineItemList(SmartList<LineItem> lineItemList){
		for( LineItem lineItem:lineItemList){
			lineItem.setUserOrder(this);
		}
		getLineItemList().addAll(lineItemList);
	}
	
	public  LineItem removeLineItem(LineItem lineItemIndex){
		
		int index = getLineItemList().indexOf(lineItemIndex);
        if(index < 0){
        	String message = "LineItem("+lineItemIndex.getId()+") with version='"+lineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LineItem lineItem = getLineItemList().get(index);        
        // lineItem.clearUserOrder(); //disconnect with UserOrder
        lineItem.clearFromAll(); //disconnect with UserOrder
		
		boolean result = getLineItemList().planToRemove(lineItem);
        if(!result){
        	String message = "LineItem("+lineItemIndex.getId()+") with version='"+lineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return lineItem;
        
	
	}
	//断舍离
	public  void breakWithLineItem(LineItem lineItem){
		
		if(lineItem == null){
			return;
		}
		lineItem.setUserOrder(null);
		//getLineItemList().remove();
	
	}
	
	public  boolean hasLineItem(LineItem lineItem){
	
		return getLineItemList().contains(lineItem);
  
	}
	
	public void copyLineItemFrom(LineItem lineItem) {

		LineItem lineItemInList = findTheLineItem(lineItem);
		LineItem newLineItem = new LineItem();
		lineItemInList.copyTo(newLineItem);
		newLineItem.setVersion(0);//will trigger copy
		getLineItemList().add(newLineItem);
		addItemToFlexiableObject(COPIED_CHILD, newLineItem);
	}
	
	public  LineItem findTheLineItem(LineItem lineItem){
		
		int index =  getLineItemList().indexOf(lineItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LineItem("+lineItem.getId()+") with version='"+lineItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLineItemList(){
		getLineItemList().clear();
	}
	
	
	


	public  SmartList<OrderPromotion> getOrderPromotionList(){
		if(this.mOrderPromotionList == null){
			this.mOrderPromotionList = new SmartList<OrderPromotion>();
			this.mOrderPromotionList.setListInternalName (ORDER_PROMOTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOrderPromotionList;	
	}
	public  void setOrderPromotionList(SmartList<OrderPromotion> orderPromotionList){
		for( OrderPromotion orderPromotion:orderPromotionList){
			orderPromotion.setUserOrder(this);
		}

		this.mOrderPromotionList = orderPromotionList;
		this.mOrderPromotionList.setListInternalName (ORDER_PROMOTION_LIST );
		
	}
	
	public  void addOrderPromotion(OrderPromotion orderPromotion){
		orderPromotion.setUserOrder(this);
		getOrderPromotionList().add(orderPromotion);
	}
	public  void addOrderPromotionList(SmartList<OrderPromotion> orderPromotionList){
		for( OrderPromotion orderPromotion:orderPromotionList){
			orderPromotion.setUserOrder(this);
		}
		getOrderPromotionList().addAll(orderPromotionList);
	}
	
	public  OrderPromotion removeOrderPromotion(OrderPromotion orderPromotionIndex){
		
		int index = getOrderPromotionList().indexOf(orderPromotionIndex);
        if(index < 0){
        	String message = "OrderPromotion("+orderPromotionIndex.getId()+") with version='"+orderPromotionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        OrderPromotion orderPromotion = getOrderPromotionList().get(index);        
        // orderPromotion.clearUserOrder(); //disconnect with UserOrder
        orderPromotion.clearFromAll(); //disconnect with UserOrder
		
		boolean result = getOrderPromotionList().planToRemove(orderPromotion);
        if(!result){
        	String message = "OrderPromotion("+orderPromotionIndex.getId()+") with version='"+orderPromotionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return orderPromotion;
        
	
	}
	//断舍离
	public  void breakWithOrderPromotion(OrderPromotion orderPromotion){
		
		if(orderPromotion == null){
			return;
		}
		orderPromotion.setUserOrder(null);
		//getOrderPromotionList().remove();
	
	}
	
	public  boolean hasOrderPromotion(OrderPromotion orderPromotion){
	
		return getOrderPromotionList().contains(orderPromotion);
  
	}
	
	public void copyOrderPromotionFrom(OrderPromotion orderPromotion) {

		OrderPromotion orderPromotionInList = findTheOrderPromotion(orderPromotion);
		OrderPromotion newOrderPromotion = new OrderPromotion();
		orderPromotionInList.copyTo(newOrderPromotion);
		newOrderPromotion.setVersion(0);//will trigger copy
		getOrderPromotionList().add(newOrderPromotion);
		addItemToFlexiableObject(COPIED_CHILD, newOrderPromotion);
	}
	
	public  OrderPromotion findTheOrderPromotion(OrderPromotion orderPromotion){
		
		int index =  getOrderPromotionList().indexOf(orderPromotion);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "OrderPromotion("+orderPromotion.getId()+") with version='"+orderPromotion.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOrderPromotionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOrderPromotionList(){
		getOrderPromotionList().clear();
	}
	
	
	


	public  SmartList<ManualAdjustment> getManualAdjustmentList(){
		if(this.mManualAdjustmentList == null){
			this.mManualAdjustmentList = new SmartList<ManualAdjustment>();
			this.mManualAdjustmentList.setListInternalName (MANUAL_ADJUSTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mManualAdjustmentList;	
	}
	public  void setManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList){
		for( ManualAdjustment manualAdjustment:manualAdjustmentList){
			manualAdjustment.setUserOrder(this);
		}

		this.mManualAdjustmentList = manualAdjustmentList;
		this.mManualAdjustmentList.setListInternalName (MANUAL_ADJUSTMENT_LIST );
		
	}
	
	public  void addManualAdjustment(ManualAdjustment manualAdjustment){
		manualAdjustment.setUserOrder(this);
		getManualAdjustmentList().add(manualAdjustment);
	}
	public  void addManualAdjustmentList(SmartList<ManualAdjustment> manualAdjustmentList){
		for( ManualAdjustment manualAdjustment:manualAdjustmentList){
			manualAdjustment.setUserOrder(this);
		}
		getManualAdjustmentList().addAll(manualAdjustmentList);
	}
	
	public  ManualAdjustment removeManualAdjustment(ManualAdjustment manualAdjustmentIndex){
		
		int index = getManualAdjustmentList().indexOf(manualAdjustmentIndex);
        if(index < 0){
        	String message = "ManualAdjustment("+manualAdjustmentIndex.getId()+") with version='"+manualAdjustmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ManualAdjustment manualAdjustment = getManualAdjustmentList().get(index);        
        // manualAdjustment.clearUserOrder(); //disconnect with UserOrder
        manualAdjustment.clearFromAll(); //disconnect with UserOrder
		
		boolean result = getManualAdjustmentList().planToRemove(manualAdjustment);
        if(!result){
        	String message = "ManualAdjustment("+manualAdjustmentIndex.getId()+") with version='"+manualAdjustmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return manualAdjustment;
        
	
	}
	//断舍离
	public  void breakWithManualAdjustment(ManualAdjustment manualAdjustment){
		
		if(manualAdjustment == null){
			return;
		}
		manualAdjustment.setUserOrder(null);
		//getManualAdjustmentList().remove();
	
	}
	
	public  boolean hasManualAdjustment(ManualAdjustment manualAdjustment){
	
		return getManualAdjustmentList().contains(manualAdjustment);
  
	}
	
	public void copyManualAdjustmentFrom(ManualAdjustment manualAdjustment) {

		ManualAdjustment manualAdjustmentInList = findTheManualAdjustment(manualAdjustment);
		ManualAdjustment newManualAdjustment = new ManualAdjustment();
		manualAdjustmentInList.copyTo(newManualAdjustment);
		newManualAdjustment.setVersion(0);//will trigger copy
		getManualAdjustmentList().add(newManualAdjustment);
		addItemToFlexiableObject(COPIED_CHILD, newManualAdjustment);
	}
	
	public  ManualAdjustment findTheManualAdjustment(ManualAdjustment manualAdjustment){
		
		int index =  getManualAdjustmentList().indexOf(manualAdjustment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ManualAdjustment("+manualAdjustment.getId()+") with version='"+manualAdjustment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getManualAdjustmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpManualAdjustmentList(){
		getManualAdjustmentList().clear();
	}
	
	
	


	public  SmartList<ShippingGroup> getShippingGroupList(){
		if(this.mShippingGroupList == null){
			this.mShippingGroupList = new SmartList<ShippingGroup>();
			this.mShippingGroupList.setListInternalName (SHIPPING_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mShippingGroupList;	
	}
	public  void setShippingGroupList(SmartList<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setUserOrder(this);
		}

		this.mShippingGroupList = shippingGroupList;
		this.mShippingGroupList.setListInternalName (SHIPPING_GROUP_LIST );
		
	}
	
	public  void addShippingGroup(ShippingGroup shippingGroup){
		shippingGroup.setUserOrder(this);
		getShippingGroupList().add(shippingGroup);
	}
	public  void addShippingGroupList(SmartList<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setUserOrder(this);
		}
		getShippingGroupList().addAll(shippingGroupList);
	}
	
	public  ShippingGroup removeShippingGroup(ShippingGroup shippingGroupIndex){
		
		int index = getShippingGroupList().indexOf(shippingGroupIndex);
        if(index < 0){
        	String message = "ShippingGroup("+shippingGroupIndex.getId()+") with version='"+shippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ShippingGroup shippingGroup = getShippingGroupList().get(index);        
        // shippingGroup.clearUserOrder(); //disconnect with UserOrder
        shippingGroup.clearFromAll(); //disconnect with UserOrder
		
		boolean result = getShippingGroupList().planToRemove(shippingGroup);
        if(!result){
        	String message = "ShippingGroup("+shippingGroupIndex.getId()+") with version='"+shippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return shippingGroup;
        
	
	}
	//断舍离
	public  void breakWithShippingGroup(ShippingGroup shippingGroup){
		
		if(shippingGroup == null){
			return;
		}
		shippingGroup.setUserOrder(null);
		//getShippingGroupList().remove();
	
	}
	
	public  boolean hasShippingGroup(ShippingGroup shippingGroup){
	
		return getShippingGroupList().contains(shippingGroup);
  
	}
	
	public void copyShippingGroupFrom(ShippingGroup shippingGroup) {

		ShippingGroup shippingGroupInList = findTheShippingGroup(shippingGroup);
		ShippingGroup newShippingGroup = new ShippingGroup();
		shippingGroupInList.copyTo(newShippingGroup);
		newShippingGroup.setVersion(0);//will trigger copy
		getShippingGroupList().add(newShippingGroup);
		addItemToFlexiableObject(COPIED_CHILD, newShippingGroup);
	}
	
	public  ShippingGroup findTheShippingGroup(ShippingGroup shippingGroup){
		
		int index =  getShippingGroupList().indexOf(shippingGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ShippingGroup("+shippingGroup.getId()+") with version='"+shippingGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpShippingGroupList(){
		getShippingGroupList().clear();
	}
	
	
	


	public  SmartList<PaymentGroup> getPaymentGroupList(){
		if(this.mPaymentGroupList == null){
			this.mPaymentGroupList = new SmartList<PaymentGroup>();
			this.mPaymentGroupList.setListInternalName (PAYMENT_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPaymentGroupList;	
	}
	public  void setPaymentGroupList(SmartList<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setUserOrder(this);
		}

		this.mPaymentGroupList = paymentGroupList;
		this.mPaymentGroupList.setListInternalName (PAYMENT_GROUP_LIST );
		
	}
	
	public  void addPaymentGroup(PaymentGroup paymentGroup){
		paymentGroup.setUserOrder(this);
		getPaymentGroupList().add(paymentGroup);
	}
	public  void addPaymentGroupList(SmartList<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setUserOrder(this);
		}
		getPaymentGroupList().addAll(paymentGroupList);
	}
	
	public  PaymentGroup removePaymentGroup(PaymentGroup paymentGroupIndex){
		
		int index = getPaymentGroupList().indexOf(paymentGroupIndex);
        if(index < 0){
        	String message = "PaymentGroup("+paymentGroupIndex.getId()+") with version='"+paymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PaymentGroup paymentGroup = getPaymentGroupList().get(index);        
        // paymentGroup.clearUserOrder(); //disconnect with UserOrder
        paymentGroup.clearFromAll(); //disconnect with UserOrder
		
		boolean result = getPaymentGroupList().planToRemove(paymentGroup);
        if(!result){
        	String message = "PaymentGroup("+paymentGroupIndex.getId()+") with version='"+paymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return paymentGroup;
        
	
	}
	//断舍离
	public  void breakWithPaymentGroup(PaymentGroup paymentGroup){
		
		if(paymentGroup == null){
			return;
		}
		paymentGroup.setUserOrder(null);
		//getPaymentGroupList().remove();
	
	}
	
	public  boolean hasPaymentGroup(PaymentGroup paymentGroup){
	
		return getPaymentGroupList().contains(paymentGroup);
  
	}
	
	public void copyPaymentGroupFrom(PaymentGroup paymentGroup) {

		PaymentGroup paymentGroupInList = findThePaymentGroup(paymentGroup);
		PaymentGroup newPaymentGroup = new PaymentGroup();
		paymentGroupInList.copyTo(newPaymentGroup);
		newPaymentGroup.setVersion(0);//will trigger copy
		getPaymentGroupList().add(newPaymentGroup);
		addItemToFlexiableObject(COPIED_CHILD, newPaymentGroup);
	}
	
	public  PaymentGroup findThePaymentGroup(PaymentGroup paymentGroup){
		
		int index =  getPaymentGroupList().indexOf(paymentGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PaymentGroup("+paymentGroup.getId()+") with version='"+paymentGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPaymentGroupList(){
		getPaymentGroupList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUser(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLineItemList(), internalType);
		collectFromList(this, entityList, getOrderPromotionList(), internalType);
		collectFromList(this, entityList, getManualAdjustmentList(), internalType);
		collectFromList(this, entityList, getShippingGroupList(), internalType);
		collectFromList(this, entityList, getPaymentGroupList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLineItemList());
		listOfList.add( getOrderPromotionList());
		listOfList.add( getManualAdjustmentList());
		listOfList.add( getShippingGroupList());
		listOfList.add( getPaymentGroupList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, TOTAL_ADJUSTMENT_PROPERTY, getTotalAdjustment());
		appendKeyValuePair(result, TOTAL_AMOUNT_PROPERTY, getTotalAmount());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LINE_ITEM_LIST, getLineItemList());
		if(!getLineItemList().isEmpty()){
			appendKeyValuePair(result, "lineItemCount", getLineItemList().getTotalCount());
			appendKeyValuePair(result, "lineItemCurrentPageNumber", getLineItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ORDER_PROMOTION_LIST, getOrderPromotionList());
		if(!getOrderPromotionList().isEmpty()){
			appendKeyValuePair(result, "orderPromotionCount", getOrderPromotionList().getTotalCount());
			appendKeyValuePair(result, "orderPromotionCurrentPageNumber", getOrderPromotionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MANUAL_ADJUSTMENT_LIST, getManualAdjustmentList());
		if(!getManualAdjustmentList().isEmpty()){
			appendKeyValuePair(result, "manualAdjustmentCount", getManualAdjustmentList().getTotalCount());
			appendKeyValuePair(result, "manualAdjustmentCurrentPageNumber", getManualAdjustmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SHIPPING_GROUP_LIST, getShippingGroupList());
		if(!getShippingGroupList().isEmpty()){
			appendKeyValuePair(result, "shippingGroupCount", getShippingGroupList().getTotalCount());
			appendKeyValuePair(result, "shippingGroupCurrentPageNumber", getShippingGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PAYMENT_GROUP_LIST, getPaymentGroupList());
		if(!getPaymentGroupList().isEmpty()){
			appendKeyValuePair(result, "paymentGroupCount", getPaymentGroupList().getTotalCount());
			appendKeyValuePair(result, "paymentGroupCurrentPageNumber", getPaymentGroupList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserOrder){
		
		
			UserOrder dest =(UserOrder)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setTotalAdjustment(getTotalAdjustment());
			dest.setTotalAmount(getTotalAmount());
			dest.setUser(getUser());
			dest.setPlatform(getPlatform());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setLineItemList(getLineItemList());
			dest.setOrderPromotionList(getOrderPromotionList());
			dest.setManualAdjustmentList(getManualAdjustmentList());
			dest.setShippingGroupList(getShippingGroupList());
			dest.setPaymentGroupList(getPaymentGroupList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserOrder{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\ttotalAdjustment='"+getTotalAdjustment()+"';");
		stringBuilder.append("\ttotalAmount='"+getTotalAmount()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='Profile("+getUser().getId()+")';");
 		}
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

