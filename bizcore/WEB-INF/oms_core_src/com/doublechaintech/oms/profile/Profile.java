
package com.doublechaintech.oms.profile;

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
import com.doublechaintech.oms.platform.Platform;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String AGE_PROPERTY                   = "age"               ;
	public static final String GENDER_PROPERTY                = "gender"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_ORDER_LIST                          = "userOrderList"     ;

	public static final String INTERNAL_TYPE="Profile";
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
	protected		int                 	mAge                ;
	protected		String              	mGender             ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserOrder>	mUserOrderList      ;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, int age, String gender, DateTime lastUpdateTime, Platform platform)
	{
		setName(name);
		setAge(age);
		setGender(gender);
		setLastUpdateTime(lastUpdateTime);
		setPlatform(platform);

		this.mUserOrderList = new SmartList<UserOrder>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AGE_PROPERTY.equals(property)){
			changeAgeProperty(newValueExpr);
		}
		if(GENDER_PROPERTY.equals(property)){
			changeGenderProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeAgeProperty(String newValueExpr){
		int oldValue = getAge();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAge(newValue);
		this.onChangeProperty(AGE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeGenderProperty(String newValueExpr){
		String oldValue = getGender();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateGender(newValue);
		this.onChangeProperty(GENDER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
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
	public Profile updateId(String id){
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
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setAge(int age){
		this.mAge = age;;
	}
	public int getAge(){
		return this.mAge;
	}
	public Profile updateAge(int age){
		this.mAge = age;;
		this.changed = true;
		return this;
	}
	public void mergeAge(int age){
		setAge(age);
	}
	
	
	public void setGender(String gender){
		this.mGender = trimString(gender);;
	}
	public String getGender(){
		return this.mGender;
	}
	public Profile updateGender(String gender){
		this.mGender = trimString(gender);;
		this.changed = true;
		return this;
	}
	public void mergeGender(String gender){
		if(gender != null) { setGender(gender);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Profile updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<UserOrder> getUserOrderList(){
		if(this.mUserOrderList == null){
			this.mUserOrderList = new SmartList<UserOrder>();
			this.mUserOrderList.setListInternalName (USER_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserOrderList;	
	}
	public  void setUserOrderList(SmartList<UserOrder> userOrderList){
		for( UserOrder userOrder:userOrderList){
			userOrder.setUser(this);
		}

		this.mUserOrderList = userOrderList;
		this.mUserOrderList.setListInternalName (USER_ORDER_LIST );
		
	}
	
	public  void addUserOrder(UserOrder userOrder){
		userOrder.setUser(this);
		getUserOrderList().add(userOrder);
	}
	public  void addUserOrderList(SmartList<UserOrder> userOrderList){
		for( UserOrder userOrder:userOrderList){
			userOrder.setUser(this);
		}
		getUserOrderList().addAll(userOrderList);
	}
	public  void mergeUserOrderList(SmartList<UserOrder> userOrderList){
		if(userOrderList==null){
			return;
		}
		if(userOrderList.isEmpty()){
			return;
		}
		addUserOrderList( userOrderList );
		
	}
	public  UserOrder removeUserOrder(UserOrder userOrderIndex){
		
		int index = getUserOrderList().indexOf(userOrderIndex);
        if(index < 0){
        	String message = "UserOrder("+userOrderIndex.getId()+") with version='"+userOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserOrder userOrder = getUserOrderList().get(index);        
        // userOrder.clearUser(); //disconnect with User
        userOrder.clearFromAll(); //disconnect with User
		
		boolean result = getUserOrderList().planToRemove(userOrder);
        if(!result){
        	String message = "UserOrder("+userOrderIndex.getId()+") with version='"+userOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userOrder;
        
	
	}
	//断舍离
	public  void breakWithUserOrder(UserOrder userOrder){
		
		if(userOrder == null){
			return;
		}
		userOrder.setUser(null);
		//getUserOrderList().remove();
	
	}
	
	public  boolean hasUserOrder(UserOrder userOrder){
	
		return getUserOrderList().contains(userOrder);
  
	}
	
	public void copyUserOrderFrom(UserOrder userOrder) {

		UserOrder userOrderInList = findTheUserOrder(userOrder);
		UserOrder newUserOrder = new UserOrder();
		userOrderInList.copyTo(newUserOrder);
		newUserOrder.setVersion(0);//will trigger copy
		getUserOrderList().add(newUserOrder);
		addItemToFlexiableObject(COPIED_CHILD, newUserOrder);
	}
	
	public  UserOrder findTheUserOrder(UserOrder userOrder){
		
		int index =  getUserOrderList().indexOf(userOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserOrder("+userOrder.getId()+") with version='"+userOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserOrderList(){
		getUserOrderList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserOrderList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserOrderList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, AGE_PROPERTY, getAge());
		appendKeyValuePair(result, GENDER_PROPERTY, getGender());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_ORDER_LIST, getUserOrderList());
		if(!getUserOrderList().isEmpty()){
			appendKeyValuePair(result, "userOrderCount", getUserOrderList().getTotalCount());
			appendKeyValuePair(result, "userOrderCurrentPageNumber", getUserOrderList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAge(getAge());
			dest.setGender(getGender());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setUserOrderList(getUserOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
			
			Profile dest =(Profile)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAge(getAge());
			dest.mergeGender(getGender());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeUserOrderList(getUserOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tage='"+getAge()+"';");
		stringBuilder.append("\tgender='"+getGender()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAge(int incAge){
		updateAge(this.mAge +  incAge);
	}
	public void decreaseAge(int decAge){
		updateAge(this.mAge - decAge);
	}
	

}

