
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
	



}


