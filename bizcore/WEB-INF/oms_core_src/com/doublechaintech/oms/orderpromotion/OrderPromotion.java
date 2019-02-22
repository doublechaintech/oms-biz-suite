
package com.doublechaintech.oms.orderpromotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;
import com.doublechaintech.oms.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.oms.userorder.UserOrder;

@JsonSerialize(using = OrderPromotionSerializer.class)
public class OrderPromotion extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String THREAD_HOLD_PROPERTY           = "threadHold"        ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String USER_ORDER_PROPERTY            = "userOrder"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="OrderPromotion";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		int                 	mAmount             ;
	protected		int                 	mThreadHold         ;
	protected		String              	mType               ;
	protected		UserOrder           	mUserOrder          ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	OrderPromotion(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUserOrder( null );

		this.changed = true;
	}
	
	public 	OrderPromotion(String name, int amount, int threadHold, String type, UserOrder userOrder)
	{
		setName(name);
		setAmount(amount);
		setThreadHold(threadHold);
		setType(type);
		setUserOrder(userOrder);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(THREAD_HOLD_PROPERTY.equals(property)){
			changeThreadHoldProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
		int oldValue = getAmount();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeThreadHoldProperty(String newValueExpr){
		int oldValue = getThreadHold();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateThreadHold(newValue);
		this.onChangeProperty(THREAD_HOLD_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTypeProperty(String newValueExpr){
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateType(newValue);
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public OrderPromotion updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public OrderPromotion updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setAmount(int amount){
		this.mAmount = amount;;
	}
	public int getAmount(){
		return this.mAmount;
	}
	public OrderPromotion updateAmount(int amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(int amount){
		setAmount(amount);
	}
	
	
	public void setThreadHold(int threadHold){
		this.mThreadHold = threadHold;;
	}
	public int getThreadHold(){
		return this.mThreadHold;
	}
	public OrderPromotion updateThreadHold(int threadHold){
		this.mThreadHold = threadHold;;
		this.changed = true;
		return this;
	}
	public void mergeThreadHold(int threadHold){
		setThreadHold(threadHold);
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	public OrderPromotion updateType(String type){
		this.mType = trimString(type);;
		this.changed = true;
		return this;
	}
	public void mergeType(String type){
		if(type != null) { setType(type);}
	}
	
	
	public void setUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
	}
	public UserOrder getUserOrder(){
		return this.mUserOrder;
	}
	public OrderPromotion updateUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
		this.changed = true;
		return this;
	}
	public void mergeUserOrder(UserOrder userOrder){
		if(userOrder != null) { setUserOrder(userOrder);}
	}
	
	
	public void clearUserOrder(){
		setUserOrder ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public OrderPromotion updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUserOrder(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, THREAD_HOLD_PROPERTY, getThreadHold());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, USER_ORDER_PROPERTY, getUserOrder());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OrderPromotion){
		
		
			OrderPromotion dest =(OrderPromotion)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAmount(getAmount());
			dest.setThreadHold(getThreadHold());
			dest.setType(getType());
			dest.setUserOrder(getUserOrder());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OrderPromotion){
		
			
			OrderPromotion dest =(OrderPromotion)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAmount(getAmount());
			dest.mergeThreadHold(getThreadHold());
			dest.mergeType(getType());
			dest.mergeUserOrder(getUserOrder());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("OrderPromotion{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tthreadHold='"+getThreadHold()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		if(getUserOrder() != null ){
 			stringBuilder.append("\tuserOrder='UserOrder("+getUserOrder().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAmount(int incAmount){
		updateAmount(this.mAmount +  incAmount);
	}
	public void decreaseAmount(int decAmount){
		updateAmount(this.mAmount - decAmount);
	}
	
	public void increaseThreadHold(int incThreadHold){
		updateThreadHold(this.mThreadHold +  incThreadHold);
	}
	public void decreaseThreadHold(int decThreadHold){
		updateThreadHold(this.mThreadHold - decThreadHold);
	}
	

}

