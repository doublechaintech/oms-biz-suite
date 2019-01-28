
package com.doublechaintech.oms.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(OmsUserContext userContext, String name, int age, String gender, String platformId) throws Exception;	
	public Profile updateProfile(OmsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(OmsUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(OmsUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(OmsUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(OmsUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserOrderManager getUserOrderManager(OmsUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addUserOrder(OmsUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeUserOrder(OmsUserContext userContext, String profileId, String userOrderId, int userOrderVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateUserOrder(OmsUserContext userContext, String profileId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


