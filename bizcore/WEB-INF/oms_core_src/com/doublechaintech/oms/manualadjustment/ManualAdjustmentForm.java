package com.doublechaintech.oms.manualadjustment;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class ManualAdjustmentForm extends BaseForm {
	
	
	public ManualAdjustmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ManualAdjustmentForm manualAdjustmentIdField(String parameterName, String initValue){
		FormField field = idFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm manualAdjustmentIdField(String initValue){
		return manualAdjustmentIdField("manualAdjustmentId",initValue);
	}
	public ManualAdjustmentForm manualAdjustmentIdField(){
		return manualAdjustmentIdField("manualAdjustmentId","");
	}


	public ManualAdjustmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ManualAdjustmentForm nameField(){
		return nameField("name","");
	}


	public ManualAdjustmentForm amountField(String parameterName, String initValue){
		FormField field = amountFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public ManualAdjustmentForm amountField(){
		return amountField("amount","");
	}


	public ManualAdjustmentForm threadHoldField(String parameterName, String initValue){
		FormField field = threadHoldFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm threadHoldField(String initValue){
		return threadHoldField("threadHold",initValue);
	}
	public ManualAdjustmentForm threadHoldField(){
		return threadHoldField("threadHold","");
	}


	public ManualAdjustmentForm typeField(String parameterName, String initValue){
		FormField field = typeFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm typeField(String initValue){
		return typeField("type",initValue);
	}
	public ManualAdjustmentForm typeField(){
		return typeField("type","");
	}


	public ManualAdjustmentForm userOrderIdField(String parameterName, String initValue){
		FormField field = userOrderIdFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ManualAdjustmentForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public ManualAdjustmentForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}

	
	


	public ManualAdjustmentForm userOrderIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm userOrderIdFieldOfUserOrder(String initValue){
		return userOrderIdFieldOfUserOrder("userOrderId",initValue);
	}
	public ManualAdjustmentForm userOrderIdFieldOfUserOrder(){
		return userOrderIdFieldOfUserOrder("userOrderId","");
	}


	public ManualAdjustmentForm titleFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm titleFieldOfUserOrder(String initValue){
		return titleFieldOfUserOrder("title",initValue);
	}
	public ManualAdjustmentForm titleFieldOfUserOrder(){
		return titleFieldOfUserOrder("title","");
	}


	public ManualAdjustmentForm totalAdjustmentFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm totalAdjustmentFieldOfUserOrder(String initValue){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment",initValue);
	}
	public ManualAdjustmentForm totalAdjustmentFieldOfUserOrder(){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment","");
	}


	public ManualAdjustmentForm totalAmountFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm totalAmountFieldOfUserOrder(String initValue){
		return totalAmountFieldOfUserOrder("totalAmount",initValue);
	}
	public ManualAdjustmentForm totalAmountFieldOfUserOrder(){
		return totalAmountFieldOfUserOrder("totalAmount","");
	}


	public ManualAdjustmentForm userIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm userIdFieldOfUserOrder(String initValue){
		return userIdFieldOfUserOrder("userId",initValue);
	}
	public ManualAdjustmentForm userIdFieldOfUserOrder(){
		return userIdFieldOfUserOrder("userId","");
	}


	public ManualAdjustmentForm platformIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm platformIdFieldOfUserOrder(String initValue){
		return platformIdFieldOfUserOrder("platformId",initValue);
	}
	public ManualAdjustmentForm platformIdFieldOfUserOrder(){
		return platformIdFieldOfUserOrder("platformId","");
	}


	public ManualAdjustmentForm lastUpdateTimeFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ManualAdjustmentForm lastUpdateTimeFieldOfUserOrder(String initValue){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime",initValue);
	}
	public ManualAdjustmentForm lastUpdateTimeFieldOfUserOrder(){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime","");
	}

	


	

	
 	public ManualAdjustmentForm transferToAnotherUserOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserOrder/manualAdjustmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public ManualAdjustmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


