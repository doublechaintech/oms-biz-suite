package com.doublechaintech.oms.paymentgroup;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class PaymentGroupForm extends BaseForm {
	
	
	public PaymentGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PaymentGroupForm paymentGroupIdField(String parameterName, String initValue){
		FormField field = idFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentGroupForm paymentGroupIdField(String initValue){
		return paymentGroupIdField("paymentGroupId",initValue);
	}
	public PaymentGroupForm paymentGroupIdField(){
		return paymentGroupIdField("paymentGroupId","");
	}


	public PaymentGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PaymentGroupForm nameField(){
		return nameField("name","");
	}


	public PaymentGroupForm amountField(String parameterName, String initValue){
		FormField field = amountFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentGroupForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public PaymentGroupForm amountField(){
		return amountField("amount","");
	}


	public PaymentGroupForm userOrderIdField(String parameterName, String initValue){
		FormField field = userOrderIdFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentGroupForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public PaymentGroupForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}


	public PaymentGroupForm statusField(String parameterName, String initValue){
		FormField field = statusFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentGroupForm statusField(String initValue){
		return statusField("status",initValue);
	}
	public PaymentGroupForm statusField(){
		return statusField("status","");
	}

	
	


	public PaymentGroupForm userOrderIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm userOrderIdFieldOfUserOrder(String initValue){
		return userOrderIdFieldOfUserOrder("userOrderId",initValue);
	}
	public PaymentGroupForm userOrderIdFieldOfUserOrder(){
		return userOrderIdFieldOfUserOrder("userOrderId","");
	}


	public PaymentGroupForm titleFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm titleFieldOfUserOrder(String initValue){
		return titleFieldOfUserOrder("title",initValue);
	}
	public PaymentGroupForm titleFieldOfUserOrder(){
		return titleFieldOfUserOrder("title","");
	}


	public PaymentGroupForm totalAdjustmentFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm totalAdjustmentFieldOfUserOrder(String initValue){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment",initValue);
	}
	public PaymentGroupForm totalAdjustmentFieldOfUserOrder(){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment","");
	}


	public PaymentGroupForm totalAmountFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm totalAmountFieldOfUserOrder(String initValue){
		return totalAmountFieldOfUserOrder("totalAmount",initValue);
	}
	public PaymentGroupForm totalAmountFieldOfUserOrder(){
		return totalAmountFieldOfUserOrder("totalAmount","");
	}


	public PaymentGroupForm userIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm userIdFieldOfUserOrder(String initValue){
		return userIdFieldOfUserOrder("userId",initValue);
	}
	public PaymentGroupForm userIdFieldOfUserOrder(){
		return userIdFieldOfUserOrder("userId","");
	}


	public PaymentGroupForm platformIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm platformIdFieldOfUserOrder(String initValue){
		return platformIdFieldOfUserOrder("platformId",initValue);
	}
	public PaymentGroupForm platformIdFieldOfUserOrder(){
		return platformIdFieldOfUserOrder("platformId","");
	}


	public PaymentGroupForm lastUpdateTimeFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PaymentGroupForm lastUpdateTimeFieldOfUserOrder(String initValue){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime",initValue);
	}
	public PaymentGroupForm lastUpdateTimeFieldOfUserOrder(){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime","");
	}

	


	

	
 	public PaymentGroupForm transferToAnotherUserOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserOrder/paymentGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public PaymentGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


