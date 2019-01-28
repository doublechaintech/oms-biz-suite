
package com.doublechaintech.oms.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(OmsUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(OmsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(OmsUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(OmsUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(OmsUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(OmsUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProfileManager getProfileManager(OmsUserContext userContext, String platformId, String name, int age, String gender ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(OmsUserContext userContext, String platformId, String name, int age, String gender , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(OmsUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(OmsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UserOrderManager getUserOrderManager(OmsUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addUserOrder(OmsUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId , String [] tokensExpr)  throws Exception;
	public  Platform removeUserOrder(OmsUserContext userContext, String platformId, String userOrderId, int userOrderVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateUserOrder(OmsUserContext userContext, String platformId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


