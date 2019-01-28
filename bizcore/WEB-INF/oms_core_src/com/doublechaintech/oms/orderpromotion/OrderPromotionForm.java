package com.doublechaintech.oms.orderpromotion;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class OrderPromotionForm extends BaseForm {
	
	
	public OrderPromotionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OrderPromotionForm orderPromotionIdField(String parameterName, String initValue){
		FormField field = idFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm orderPromotionIdField(String initValue){
		return orderPromotionIdField("orderPromotionId",initValue);
	}
	public OrderPromotionForm orderPromotionIdField(){
		return orderPromotionIdField("orderPromotionId","");
	}


	public OrderPromotionForm nameField(String parameterName, String initValue){
		FormField field = nameFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public OrderPromotionForm nameField(){
		return nameField("name","");
	}


	public OrderPromotionForm amountField(String parameterName, String initValue){
		FormField field = amountFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public OrderPromotionForm amountField(){
		return amountField("amount","");
	}


	public OrderPromotionForm threadHoldField(String parameterName, String initValue){
		FormField field = threadHoldFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm threadHoldField(String initValue){
		return threadHoldField("threadHold",initValue);
	}
	public OrderPromotionForm threadHoldField(){
		return threadHoldField("threadHold","");
	}


	public OrderPromotionForm typeField(String parameterName, String initValue){
		FormField field = typeFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm typeField(String initValue){
		return typeField("type",initValue);
	}
	public OrderPromotionForm typeField(){
		return typeField("type","");
	}


	public OrderPromotionForm userOrderIdField(String parameterName, String initValue){
		FormField field = userOrderIdFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrderPromotionForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public OrderPromotionForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}

	
	


	public OrderPromotionForm userOrderIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm userOrderIdFieldOfUserOrder(String initValue){
		return userOrderIdFieldOfUserOrder("userOrderId",initValue);
	}
	public OrderPromotionForm userOrderIdFieldOfUserOrder(){
		return userOrderIdFieldOfUserOrder("userOrderId","");
	}


	public OrderPromotionForm titleFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm titleFieldOfUserOrder(String initValue){
		return titleFieldOfUserOrder("title",initValue);
	}
	public OrderPromotionForm titleFieldOfUserOrder(){
		return titleFieldOfUserOrder("title","");
	}


	public OrderPromotionForm totalAdjustmentFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm totalAdjustmentFieldOfUserOrder(String initValue){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment",initValue);
	}
	public OrderPromotionForm totalAdjustmentFieldOfUserOrder(){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment","");
	}


	public OrderPromotionForm totalAmountFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm totalAmountFieldOfUserOrder(String initValue){
		return totalAmountFieldOfUserOrder("totalAmount",initValue);
	}
	public OrderPromotionForm totalAmountFieldOfUserOrder(){
		return totalAmountFieldOfUserOrder("totalAmount","");
	}


	public OrderPromotionForm userIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm userIdFieldOfUserOrder(String initValue){
		return userIdFieldOfUserOrder("userId",initValue);
	}
	public OrderPromotionForm userIdFieldOfUserOrder(){
		return userIdFieldOfUserOrder("userId","");
	}


	public OrderPromotionForm platformIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm platformIdFieldOfUserOrder(String initValue){
		return platformIdFieldOfUserOrder("platformId",initValue);
	}
	public OrderPromotionForm platformIdFieldOfUserOrder(){
		return platformIdFieldOfUserOrder("platformId","");
	}


	public OrderPromotionForm lastUpdateTimeFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrderPromotionForm lastUpdateTimeFieldOfUserOrder(String initValue){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime",initValue);
	}
	public OrderPromotionForm lastUpdateTimeFieldOfUserOrder(){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime","");
	}

	


	

	
 	public OrderPromotionForm transferToAnotherUserOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserOrder/orderPromotionId/");
		this.addFormAction(action);
		return this;
	}

 

	public OrderPromotionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


