
package com.doublechaintech.oms;
import java.util.Map;

import com.doublechaintech.oms.platform.Platform;
import com.doublechaintech.oms.profile.Profile;
import com.doublechaintech.oms.userorder.UserOrder;
import com.doublechaintech.oms.lineitem.LineItem;
import com.doublechaintech.oms.orderpromotion.OrderPromotion;
import com.doublechaintech.oms.manualadjustment.ManualAdjustment;
import com.doublechaintech.oms.shippinggroup.ShippingGroup;
import com.doublechaintech.oms.paymentgroup.PaymentGroup;
import com.doublechaintech.oms.userdomain.UserDomain;
import com.doublechaintech.oms.userwhitelist.UserWhiteList;
import com.doublechaintech.oms.secuser.SecUser;
import com.doublechaintech.oms.secuserblocking.SecUserBlocking;
import com.doublechaintech.oms.userapp.UserApp;
import com.doublechaintech.oms.listaccess.ListAccess;
import com.doublechaintech.oms.objectaccess.ObjectAccess;
import com.doublechaintech.oms.loginhistory.LoginHistory;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public UserOrder createUserOrder(Map<String,Object> options){
		return new UserOrder();
	}


	public LineItem createLineItem(Map<String,Object> options){
		return new LineItem();
	}


	public OrderPromotion createOrderPromotion(Map<String,Object> options){
		return new OrderPromotion();
	}


	public ManualAdjustment createManualAdjustment(Map<String,Object> options){
		return new ManualAdjustment();
	}


	public ShippingGroup createShippingGroup(Map<String,Object> options){
		return new ShippingGroup();
	}


	public PaymentGroup createPaymentGroup(Map<String,Object> options){
		return new PaymentGroup();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










