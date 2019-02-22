
package com.doublechaintech.oms.lineitem;

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

@JsonSerialize(using = LineItemSerializer.class)
public class LineItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String DISCOUNT_PRICE_PROPERTY        = "discountPrice"     ;
	public static final String USER_ORDER_PROPERTY            = "userOrder"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="LineItem";
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
	protected		int                 	mQuantity           ;
	protected		BigDecimal          	mPrice              ;
	protected		BigDecimal          	mDiscountPrice      ;
	protected		UserOrder           	mUserOrder          ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	LineItem(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUserOrder( null );

		this.changed = true;
	}
	
	public 	LineItem(String name, int quantity, BigDecimal price, BigDecimal discountPrice, UserOrder userOrder)
	{
		setName(name);
		setQuantity(quantity);
		setPrice(price);
		setDiscountPrice(discountPrice);
		setUserOrder(userOrder);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}
		if(DISCOUNT_PRICE_PROPERTY.equals(property)){
			changeDiscountPriceProperty(newValueExpr);
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
			
			
			
	protected void changeQuantityProperty(String newValueExpr){
		int oldValue = getQuantity();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateQuantity(newValue);
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePriceProperty(String newValueExpr){
		BigDecimal oldValue = getPrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePrice(newValue);
		this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDiscountPriceProperty(String newValueExpr){
		BigDecimal oldValue = getDiscountPrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDiscountPrice(newValue);
		this.onChangeProperty(DISCOUNT_PRICE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LineItem updateId(String id){
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
	public LineItem updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	public LineItem updateQuantity(int quantity){
		this.mQuantity = quantity;;
		this.changed = true;
		return this;
	}
	public void mergeQuantity(int quantity){
		setQuantity(quantity);
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public LineItem updatePrice(BigDecimal price){
		this.mPrice = price;;
		this.changed = true;
		return this;
	}
	public void mergePrice(BigDecimal price){
		setPrice(price);
	}
	
	
	public void setDiscountPrice(BigDecimal discountPrice){
		this.mDiscountPrice = discountPrice;;
	}
	public BigDecimal getDiscountPrice(){
		return this.mDiscountPrice;
	}
	public LineItem updateDiscountPrice(BigDecimal discountPrice){
		this.mDiscountPrice = discountPrice;;
		this.changed = true;
		return this;
	}
	public void mergeDiscountPrice(BigDecimal discountPrice){
		setDiscountPrice(discountPrice);
	}
	
	
	public void setUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
	}
	public UserOrder getUserOrder(){
		return this.mUserOrder;
	}
	public LineItem updateUserOrder(UserOrder userOrder){
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
	public LineItem updateVersion(int version){
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
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, DISCOUNT_PRICE_PROPERTY, getDiscountPrice());
		appendKeyValuePair(result, USER_ORDER_PROPERTY, getUserOrder());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LineItem){
		
		
			LineItem dest =(LineItem)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setQuantity(getQuantity());
			dest.setPrice(getPrice());
			dest.setDiscountPrice(getDiscountPrice());
			dest.setUserOrder(getUserOrder());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LineItem){
		
			
			LineItem dest =(LineItem)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeQuantity(getQuantity());
			dest.mergePrice(getPrice());
			dest.mergeDiscountPrice(getDiscountPrice());
			dest.mergeUserOrder(getUserOrder());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LineItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		stringBuilder.append("\tdiscountPrice='"+getDiscountPrice()+"';");
		if(getUserOrder() != null ){
 			stringBuilder.append("\tuserOrder='UserOrder("+getUserOrder().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseQuantity(int incQuantity){
		updateQuantity(this.mQuantity +  incQuantity);
	}
	public void decreaseQuantity(int decQuantity){
		updateQuantity(this.mQuantity - decQuantity);
	}
	

}

