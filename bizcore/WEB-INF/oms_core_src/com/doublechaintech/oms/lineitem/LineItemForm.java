package com.doublechaintech.oms.lineitem;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class LineItemForm extends BaseForm {
	
	
	public LineItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LineItemForm lineItemIdField(String parameterName, String initValue){
		FormField field = idFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm lineItemIdField(String initValue){
		return lineItemIdField("lineItemId",initValue);
	}
	public LineItemForm lineItemIdField(){
		return lineItemIdField("lineItemId","");
	}


	public LineItemForm nameField(String parameterName, String initValue){
		FormField field = nameFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LineItemForm nameField(){
		return nameField("name","");
	}


	public LineItemForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public LineItemForm quantityField(){
		return quantityField("quantity","");
	}


	public LineItemForm priceField(String parameterName, String initValue){
		FormField field = priceFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public LineItemForm priceField(){
		return priceField("price","");
	}


	public LineItemForm discountPriceField(String parameterName, String initValue){
		FormField field = discountPriceFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm discountPriceField(String initValue){
		return discountPriceField("discountPrice",initValue);
	}
	public LineItemForm discountPriceField(){
		return discountPriceField("discountPrice","");
	}


	public LineItemForm userOrderIdField(String parameterName, String initValue){
		FormField field = userOrderIdFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LineItemForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public LineItemForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}

	
	


	public LineItemForm userOrderIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm userOrderIdFieldOfUserOrder(String initValue){
		return userOrderIdFieldOfUserOrder("userOrderId",initValue);
	}
	public LineItemForm userOrderIdFieldOfUserOrder(){
		return userOrderIdFieldOfUserOrder("userOrderId","");
	}


	public LineItemForm titleFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm titleFieldOfUserOrder(String initValue){
		return titleFieldOfUserOrder("title",initValue);
	}
	public LineItemForm titleFieldOfUserOrder(){
		return titleFieldOfUserOrder("title","");
	}


	public LineItemForm totalAdjustmentFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm totalAdjustmentFieldOfUserOrder(String initValue){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment",initValue);
	}
	public LineItemForm totalAdjustmentFieldOfUserOrder(){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment","");
	}


	public LineItemForm totalAmountFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm totalAmountFieldOfUserOrder(String initValue){
		return totalAmountFieldOfUserOrder("totalAmount",initValue);
	}
	public LineItemForm totalAmountFieldOfUserOrder(){
		return totalAmountFieldOfUserOrder("totalAmount","");
	}


	public LineItemForm userIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm userIdFieldOfUserOrder(String initValue){
		return userIdFieldOfUserOrder("userId",initValue);
	}
	public LineItemForm userIdFieldOfUserOrder(){
		return userIdFieldOfUserOrder("userId","");
	}


	public LineItemForm platformIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm platformIdFieldOfUserOrder(String initValue){
		return platformIdFieldOfUserOrder("platformId",initValue);
	}
	public LineItemForm platformIdFieldOfUserOrder(){
		return platformIdFieldOfUserOrder("platformId","");
	}


	public LineItemForm lastUpdateTimeFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LineItemForm lastUpdateTimeFieldOfUserOrder(String initValue){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime",initValue);
	}
	public LineItemForm lastUpdateTimeFieldOfUserOrder(){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime","");
	}

	


	

	
 	public LineItemForm transferToAnotherUserOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserOrder/lineItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public LineItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


