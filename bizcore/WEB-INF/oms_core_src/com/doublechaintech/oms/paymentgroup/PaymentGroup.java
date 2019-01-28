
package com.doublechaintech.oms.paymentgroup;

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

@JsonSerialize(using = PaymentGroupSerializer.class)
public class PaymentGroup extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String USER_ORDER_PROPERTY            = "userOrder"         ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="PaymentGroup";
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
	protected		BigDecimal          	mAmount             ;
	protected		UserOrder           	mUserOrder          ;
	protected		String              	mStatus             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	PaymentGroup(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUserOrder( null );

		this.changed = true;
	}
	
	public 	PaymentGroup(String name, BigDecimal amount, UserOrder userOrder, String status)
	{
		setName(name);
		setAmount(amount);
		setUserOrder(userOrder);
		setStatus(status);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(STATUS_PROPERTY.equals(property)){
			changeStatusProperty(newValueExpr);
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
		BigDecimal oldValue = getAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeStatusProperty(String newValueExpr){
		String oldValue = getStatus();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStatus(newValue);
		this.onChangeProperty(STATUS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public PaymentGroup updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public PaymentGroup updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public PaymentGroup updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	
	
	public void setUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
	}
	public UserOrder getUserOrder(){
		return this.mUserOrder;
	}
	public PaymentGroup updateUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
		this.changed = true;
		return this;
	}
	
	
	public void clearUserOrder(){
		setUserOrder ( null );
		this.changed = true;
	}
	
	public void setStatus(String status){
		this.mStatus = trimString(status);;
	}
	public String getStatus(){
		return this.mStatus;
	}
	public PaymentGroup updateStatus(String status){
		this.mStatus = trimString(status);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PaymentGroup updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
		appendKeyValuePair(result, USER_ORDER_PROPERTY, getUserOrder());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PaymentGroup){
		
		
			PaymentGroup dest =(PaymentGroup)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAmount(getAmount());
			dest.setUserOrder(getUserOrder());
			dest.setStatus(getStatus());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PaymentGroup{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		if(getUserOrder() != null ){
 			stringBuilder.append("\tuserOrder='UserOrder("+getUserOrder().getId()+")';");
 		}
		stringBuilder.append("\tstatus='"+getStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

