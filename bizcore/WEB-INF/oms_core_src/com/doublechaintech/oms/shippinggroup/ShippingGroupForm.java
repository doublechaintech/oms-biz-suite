package com.doublechaintech.oms.shippinggroup;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class ShippingGroupForm extends BaseForm {
	
	
	public ShippingGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ShippingGroupForm shippingGroupIdField(String parameterName, String initValue){
		FormField field = idFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm shippingGroupIdField(String initValue){
		return shippingGroupIdField("shippingGroupId",initValue);
	}
	public ShippingGroupForm shippingGroupIdField(){
		return shippingGroupIdField("shippingGroupId","");
	}


	public ShippingGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ShippingGroupForm nameField(){
		return nameField("name","");
	}


	public ShippingGroupForm line1Field(String parameterName, String initValue){
		FormField field = line1FromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm line1Field(String initValue){
		return line1Field("line1",initValue);
	}
	public ShippingGroupForm line1Field(){
		return line1Field("line1","");
	}


	public ShippingGroupForm line2Field(String parameterName, String initValue){
		FormField field = line2FromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm line2Field(String initValue){
		return line2Field("line2",initValue);
	}
	public ShippingGroupForm line2Field(){
		return line2Field("line2","");
	}


	public ShippingGroupForm cityField(String parameterName, String initValue){
		FormField field = cityFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm cityField(String initValue){
		return cityField("city",initValue);
	}
	public ShippingGroupForm cityField(){
		return cityField("city","");
	}


	public ShippingGroupForm stateField(String parameterName, String initValue){
		FormField field = stateFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm stateField(String initValue){
		return stateField("state",initValue);
	}
	public ShippingGroupForm stateField(){
		return stateField("state","");
	}


	public ShippingGroupForm zipCodeField(String parameterName, String initValue){
		FormField field = zipCodeFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm zipCodeField(String initValue){
		return zipCodeField("zipCode",initValue);
	}
	public ShippingGroupForm zipCodeField(){
		return zipCodeField("zipCode","");
	}


	public ShippingGroupForm countryField(String parameterName, String initValue){
		FormField field = countryFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm countryField(String initValue){
		return countryField("country",initValue);
	}
	public ShippingGroupForm countryField(){
		return countryField("country","");
	}


	public ShippingGroupForm userOrderIdField(String parameterName, String initValue){
		FormField field = userOrderIdFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingGroupForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public ShippingGroupForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}

	
	


	public ShippingGroupForm userOrderIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm userOrderIdFieldOfUserOrder(String initValue){
		return userOrderIdFieldOfUserOrder("userOrderId",initValue);
	}
	public ShippingGroupForm userOrderIdFieldOfUserOrder(){
		return userOrderIdFieldOfUserOrder("userOrderId","");
	}


	public ShippingGroupForm titleFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm titleFieldOfUserOrder(String initValue){
		return titleFieldOfUserOrder("title",initValue);
	}
	public ShippingGroupForm titleFieldOfUserOrder(){
		return titleFieldOfUserOrder("title","");
	}


	public ShippingGroupForm totalAdjustmentFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm totalAdjustmentFieldOfUserOrder(String initValue){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment",initValue);
	}
	public ShippingGroupForm totalAdjustmentFieldOfUserOrder(){
		return totalAdjustmentFieldOfUserOrder("totalAdjustment","");
	}


	public ShippingGroupForm totalAmountFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm totalAmountFieldOfUserOrder(String initValue){
		return totalAmountFieldOfUserOrder("totalAmount",initValue);
	}
	public ShippingGroupForm totalAmountFieldOfUserOrder(){
		return totalAmountFieldOfUserOrder("totalAmount","");
	}


	public ShippingGroupForm userIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm userIdFieldOfUserOrder(String initValue){
		return userIdFieldOfUserOrder("userId",initValue);
	}
	public ShippingGroupForm userIdFieldOfUserOrder(){
		return userIdFieldOfUserOrder("userId","");
	}


	public ShippingGroupForm platformIdFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm platformIdFieldOfUserOrder(String initValue){
		return platformIdFieldOfUserOrder("platformId",initValue);
	}
	public ShippingGroupForm platformIdFieldOfUserOrder(){
		return platformIdFieldOfUserOrder("platformId","");
	}


	public ShippingGroupForm lastUpdateTimeFieldOfUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingGroupForm lastUpdateTimeFieldOfUserOrder(String initValue){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime",initValue);
	}
	public ShippingGroupForm lastUpdateTimeFieldOfUserOrder(){
		return lastUpdateTimeFieldOfUserOrder("lastUpdateTime","");
	}

	


	

	
 	public ShippingGroupForm transferToAnotherUserOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserOrder/shippingGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public ShippingGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


