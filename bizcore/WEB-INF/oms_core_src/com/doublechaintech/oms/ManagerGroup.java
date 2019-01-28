package com.doublechaintech.oms;


import com.doublechaintech.oms.platform.PlatformManager;

import com.doublechaintech.oms.profile.ProfileManager;

import com.doublechaintech.oms.userorder.UserOrderManager;

import com.doublechaintech.oms.lineitem.LineItemManager;

import com.doublechaintech.oms.orderpromotion.OrderPromotionManager;

import com.doublechaintech.oms.manualadjustment.ManualAdjustmentManager;

import com.doublechaintech.oms.shippinggroup.ShippingGroupManager;

import com.doublechaintech.oms.paymentgroup.PaymentGroupManager;

import com.doublechaintech.oms.userdomain.UserDomainManager;

import com.doublechaintech.oms.userwhitelist.UserWhiteListManager;

import com.doublechaintech.oms.secuser.SecUserManager;

import com.doublechaintech.oms.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.oms.userapp.UserAppManager;

import com.doublechaintech.oms.listaccess.ListAccessManager;

import com.doublechaintech.oms.objectaccess.ObjectAccessManager;

import com.doublechaintech.oms.loginhistory.LoginHistoryManager;

import com.doublechaintech.oms.genericform.GenericFormManager;

import com.doublechaintech.oms.formmessage.FormMessageManager;

import com.doublechaintech.oms.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.oms.formfield.FormFieldManager;

import com.doublechaintech.oms.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected ProfileManager profileManager;

	protected UserOrderManager userOrderManager;

	protected LineItemManager lineItemManager;

	protected OrderPromotionManager orderPromotionManager;

	protected ManualAdjustmentManager manualAdjustmentManager;

	protected ShippingGroupManager shippingGroupManager;

	protected PaymentGroupManager paymentGroupManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public UserOrderManager getUserOrderManager(){
		return this.userOrderManager;
	}
	public void setUserOrderManager(UserOrderManager manager){
		this.userOrderManager = manager;
	}


	public LineItemManager getLineItemManager(){
		return this.lineItemManager;
	}
	public void setLineItemManager(LineItemManager manager){
		this.lineItemManager = manager;
	}


	public OrderPromotionManager getOrderPromotionManager(){
		return this.orderPromotionManager;
	}
	public void setOrderPromotionManager(OrderPromotionManager manager){
		this.orderPromotionManager = manager;
	}


	public ManualAdjustmentManager getManualAdjustmentManager(){
		return this.manualAdjustmentManager;
	}
	public void setManualAdjustmentManager(ManualAdjustmentManager manager){
		this.manualAdjustmentManager = manager;
	}


	public ShippingGroupManager getShippingGroupManager(){
		return this.shippingGroupManager;
	}
	public void setShippingGroupManager(ShippingGroupManager manager){
		this.shippingGroupManager = manager;
	}


	public PaymentGroupManager getPaymentGroupManager(){
		return this.paymentGroupManager;
	}
	public void setPaymentGroupManager(PaymentGroupManager manager){
		this.paymentGroupManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









