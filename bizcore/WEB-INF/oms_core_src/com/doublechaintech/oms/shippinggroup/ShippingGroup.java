
package com.doublechaintech.oms.shippinggroup;

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

@JsonSerialize(using = ShippingGroupSerializer.class)
public class ShippingGroup extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String LINE1_PROPERTY                 = "line1"             ;
	public static final String LINE2_PROPERTY                 = "line2"             ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String STATE_PROPERTY                 = "state"             ;
	public static final String ZIP_CODE_PROPERTY              = "zipCode"           ;
	public static final String COUNTRY_PROPERTY               = "country"           ;
	public static final String USER_ORDER_PROPERTY            = "userOrder"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ShippingGroup";
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
	protected		String              	mLine1              ;
	protected		String              	mLine2              ;
	protected		String              	mCity               ;
	protected		String              	mState              ;
	protected		int                 	mZipCode            ;
	protected		String              	mCountry            ;
	protected		UserOrder           	mUserOrder          ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ShippingGroup(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUserOrder( null );

		this.changed = true;
	}
	
	public 	ShippingGroup(String name, String line1, String line2, String city, String state, int zipCode, String country, UserOrder userOrder)
	{
		setName(name);
		setLine1(line1);
		setLine2(line2);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setCountry(country);
		setUserOrder(userOrder);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(LINE1_PROPERTY.equals(property)){
			changeLine1Property(newValueExpr);
		}
		if(LINE2_PROPERTY.equals(property)){
			changeLine2Property(newValueExpr);
		}
		if(CITY_PROPERTY.equals(property)){
			changeCityProperty(newValueExpr);
		}
		if(STATE_PROPERTY.equals(property)){
			changeStateProperty(newValueExpr);
		}
		if(ZIP_CODE_PROPERTY.equals(property)){
			changeZipCodeProperty(newValueExpr);
		}
		if(COUNTRY_PROPERTY.equals(property)){
			changeCountryProperty(newValueExpr);
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
			
			
			
	protected void changeLine1Property(String newValueExpr){
		String oldValue = getLine1();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLine1(newValue);
		this.onChangeProperty(LINE1_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLine2Property(String newValueExpr){
		String oldValue = getLine2();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLine2(newValue);
		this.onChangeProperty(LINE2_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCityProperty(String newValueExpr){
		String oldValue = getCity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCity(newValue);
		this.onChangeProperty(CITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeStateProperty(String newValueExpr){
		String oldValue = getState();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateState(newValue);
		this.onChangeProperty(STATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeZipCodeProperty(String newValueExpr){
		int oldValue = getZipCode();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateZipCode(newValue);
		this.onChangeProperty(ZIP_CODE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCountryProperty(String newValueExpr){
		String oldValue = getCountry();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCountry(newValue);
		this.onChangeProperty(COUNTRY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ShippingGroup updateId(String id){
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
	public ShippingGroup updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setLine1(String line1){
		this.mLine1 = trimString(line1);;
	}
	public String getLine1(){
		return this.mLine1;
	}
	public ShippingGroup updateLine1(String line1){
		this.mLine1 = trimString(line1);;
		this.changed = true;
		return this;
	}
	
	
	public void setLine2(String line2){
		this.mLine2 = trimString(line2);;
	}
	public String getLine2(){
		return this.mLine2;
	}
	public ShippingGroup updateLine2(String line2){
		this.mLine2 = trimString(line2);;
		this.changed = true;
		return this;
	}
	
	
	public void setCity(String city){
		this.mCity = trimString(city);;
	}
	public String getCity(){
		return this.mCity;
	}
	public ShippingGroup updateCity(String city){
		this.mCity = trimString(city);;
		this.changed = true;
		return this;
	}
	
	
	public void setState(String state){
		this.mState = trimString(state);;
	}
	public String getState(){
		return this.mState;
	}
	public ShippingGroup updateState(String state){
		this.mState = trimString(state);;
		this.changed = true;
		return this;
	}
	
	
	public void setZipCode(int zipCode){
		this.mZipCode = zipCode;;
	}
	public int getZipCode(){
		return this.mZipCode;
	}
	public ShippingGroup updateZipCode(int zipCode){
		this.mZipCode = zipCode;;
		this.changed = true;
		return this;
	}
	
	
	public void setCountry(String country){
		this.mCountry = trimString(country);;
	}
	public String getCountry(){
		return this.mCountry;
	}
	public ShippingGroup updateCountry(String country){
		this.mCountry = trimString(country);;
		this.changed = true;
		return this;
	}
	
	
	public void setUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
	}
	public UserOrder getUserOrder(){
		return this.mUserOrder;
	}
	public ShippingGroup updateUserOrder(UserOrder userOrder){
		this.mUserOrder = userOrder;;
		this.changed = true;
		return this;
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
	public ShippingGroup updateVersion(int version){
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
		appendKeyValuePair(result, LINE1_PROPERTY, getLine1());
		appendKeyValuePair(result, LINE2_PROPERTY, getLine2());
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, STATE_PROPERTY, getState());
		appendKeyValuePair(result, ZIP_CODE_PROPERTY, getZipCode());
		appendKeyValuePair(result, COUNTRY_PROPERTY, getCountry());
		appendKeyValuePair(result, USER_ORDER_PROPERTY, getUserOrder());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ShippingGroup){
		
		
			ShippingGroup dest =(ShippingGroup)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setLine1(getLine1());
			dest.setLine2(getLine2());
			dest.setCity(getCity());
			dest.setState(getState());
			dest.setZipCode(getZipCode());
			dest.setCountry(getCountry());
			dest.setUserOrder(getUserOrder());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ShippingGroup{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tline1='"+getLine1()+"';");
		stringBuilder.append("\tline2='"+getLine2()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\tstate='"+getState()+"';");
		stringBuilder.append("\tzipCode='"+getZipCode()+"';");
		stringBuilder.append("\tcountry='"+getCountry()+"';");
		if(getUserOrder() != null ){
 			stringBuilder.append("\tuserOrder='UserOrder("+getUserOrder().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseZipCode(int incZipCode){
		updateZipCode(this.mZipCode +  incZipCode);
	}
	public void decreaseZipCode(int decZipCode){
		updateZipCode(this.mZipCode - decZipCode);
	}
	

}

