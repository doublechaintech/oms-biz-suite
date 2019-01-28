package com.doublechaintech.oms;

import java.util.HashMap;
import java.util.Map;

import com.doublechaintech.oms.platform.Platform;
import com.doublechaintech.oms.platform.PlatformDAO;
import com.doublechaintech.oms.platform.PlatformTokens;
import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.profile.ProfileDAO;
import com.doublechaintech.oms.profile.ProfileTokens;
import com.doublechaintech.oms.userorder.UserOrder;
import com.doublechaintech.oms.userorder.UserOrderDAO;
import com.doublechaintech.oms.userorder.UserOrderTokens;
import com.doublechaintech.oms.lineitem.LineItem;
import com.doublechaintech.oms.lineitem.LineItemDAO;
import com.doublechaintech.oms.lineitem.LineItemTokens;
import com.doublechaintech.oms.orderpromotion.OrderPromotion;
import com.doublechaintech.oms.orderpromotion.OrderPromotionDAO;
import com.doublechaintech.oms.orderpromotion.OrderPromotionTokens;
import com.doublechaintech.oms.manualadjustment.ManualAdjustment;
import com.doublechaintech.oms.manualadjustment.ManualAdjustmentDAO;
import com.doublechaintech.oms.manualadjustment.ManualAdjustmentTokens;
import com.doublechaintech.oms.shippinggroup.ShippingGroup;
import com.doublechaintech.oms.shippinggroup.ShippingGroupDAO;
import com.doublechaintech.oms.shippinggroup.ShippingGroupTokens;
import com.doublechaintech.oms.paymentgroup.PaymentGroup;
import com.doublechaintech.oms.paymentgroup.PaymentGroupDAO;
import com.doublechaintech.oms.paymentgroup.PaymentGroupTokens;
import com.doublechaintech.oms.userdomain.UserDomain;
import com.doublechaintech.oms.userdomain.UserDomainDAO;
import com.doublechaintech.oms.userdomain.UserDomainTokens;
import com.doublechaintech.oms.userwhitelist.UserWhiteList;
import com.doublechaintech.oms.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.oms.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.oms.secuser.SecUser;
import com.doublechaintech.oms.secuser.SecUserDAO;
import com.doublechaintech.oms.secuser.SecUserTokens;
import com.doublechaintech.oms.secuserblocking.SecUserBlocking;
import com.doublechaintech.oms.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.oms.secuserblocking.SecUserBlockingTokens;
import com.doublechaintech.oms.userapp.UserApp;
import com.doublechaintech.oms.userapp.UserAppDAO;
import com.doublechaintech.oms.userapp.UserAppTokens;
import com.doublechaintech.oms.listaccess.ListAccess;
import com.doublechaintech.oms.listaccess.ListAccessDAO;
import com.doublechaintech.oms.listaccess.ListAccessTokens;
import com.doublechaintech.oms.objectaccess.ObjectAccess;
import com.doublechaintech.oms.objectaccess.ObjectAccessDAO;
import com.doublechaintech.oms.objectaccess.ObjectAccessTokens;
import com.doublechaintech.oms.loginhistory.LoginHistory;
import com.doublechaintech.oms.loginhistory.LoginHistoryDAO;
import com.doublechaintech.oms.loginhistory.LoginHistoryTokens;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.genericform.GenericFormDAO;
import com.doublechaintech.oms.genericform.GenericFormTokens;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formmessage.FormMessageDAO;
import com.doublechaintech.oms.formmessage.FormMessageTokens;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formfield.FormFieldDAO;
import com.doublechaintech.oms.formfield.FormFieldTokens;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formaction.FormActionDAO;
import com.doublechaintech.oms.formaction.FormActionTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected ProfileDAO profileDAO;

	protected UserOrderDAO userOrderDAO;

	protected LineItemDAO lineItemDAO;

	protected OrderPromotionDAO orderPromotionDAO;

	protected ManualAdjustmentDAO manualAdjustmentDAO;

	protected ShippingGroupDAO shippingGroupDAO;

	protected PaymentGroupDAO paymentGroupDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public ProfileDAO getProfileDAO(){
		return this.profileDAO;
	}
	public void setProfileDAO(ProfileDAO dao){
		this.profileDAO = dao;
	}


	public UserOrderDAO getUserOrderDAO(){
		return this.userOrderDAO;
	}
	public void setUserOrderDAO(UserOrderDAO dao){
		this.userOrderDAO = dao;
	}


	public LineItemDAO getLineItemDAO(){
		return this.lineItemDAO;
	}
	public void setLineItemDAO(LineItemDAO dao){
		this.lineItemDAO = dao;
	}


	public OrderPromotionDAO getOrderPromotionDAO(){
		return this.orderPromotionDAO;
	}
	public void setOrderPromotionDAO(OrderPromotionDAO dao){
		this.orderPromotionDAO = dao;
	}


	public ManualAdjustmentDAO getManualAdjustmentDAO(){
		return this.manualAdjustmentDAO;
	}
	public void setManualAdjustmentDAO(ManualAdjustmentDAO dao){
		this.manualAdjustmentDAO = dao;
	}


	public ShippingGroupDAO getShippingGroupDAO(){
		return this.shippingGroupDAO;
	}
	public void setShippingGroupDAO(ShippingGroupDAO dao){
		this.shippingGroupDAO = dao;
	}


	public PaymentGroupDAO getPaymentGroupDAO(){
		return this.paymentGroupDAO;
	}
	public void setPaymentGroupDAO(PaymentGroupDAO dao){
		this.paymentGroupDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("Profile", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProfileDAO().load(id, ProfileTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().present((Profile)data, tokens);
			}
		});

		internalLoaderMap.put("UserOrder", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserOrderDAO().load(id, UserOrderTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserOrderDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserOrderDAO().present((UserOrder)data, tokens);
			}
		});

		internalLoaderMap.put("LineItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLineItemDAO().load(id, LineItemTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLineItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLineItemDAO().present((LineItem)data, tokens);
			}
		});

		internalLoaderMap.put("OrderPromotion", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getOrderPromotionDAO().load(id, OrderPromotionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrderPromotionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrderPromotionDAO().present((OrderPromotion)data, tokens);
			}
		});

		internalLoaderMap.put("ManualAdjustment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getManualAdjustmentDAO().load(id, ManualAdjustmentTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getManualAdjustmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getManualAdjustmentDAO().present((ManualAdjustment)data, tokens);
			}
		});

		internalLoaderMap.put("ShippingGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getShippingGroupDAO().load(id, ShippingGroupTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingGroupDAO().present((ShippingGroup)data, tokens);
			}
		});

		internalLoaderMap.put("PaymentGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPaymentGroupDAO().load(id, PaymentGroupTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentGroupDAO().present((PaymentGroup)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}

