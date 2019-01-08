
package com.doublechaintech.oms.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.oms.OmsUserContext;
import com.doublechaintech.oms.BaseEntity;
import com.doublechaintech.oms.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(OmsUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(OmsUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(OmsUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(OmsUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(OmsUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(OmsUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(OmsUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(OmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(OmsUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


