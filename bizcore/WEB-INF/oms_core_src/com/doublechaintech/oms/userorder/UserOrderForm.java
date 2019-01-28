package com.doublechaintech.oms.userorder;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class UserOrderForm extends BaseForm {
	
	
	public UserOrderForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserOrderForm userOrderIdField(String parameterName, String initValue){
		FormField field = idFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdField(String initValue){
		return userOrderIdField("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdField(){
		return userOrderIdField("userOrderId","");
	}


	public UserOrderForm titleField(String parameterName, String initValue){
		FormField field = titleFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public UserOrderForm titleField(){
		return titleField("title","");
	}


	public UserOrderForm totalAdjustmentField(String parameterName, String initValue){
		FormField field = totalAdjustmentFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm totalAdjustmentField(String initValue){
		return totalAdjustmentField("totalAdjustment",initValue);
	}
	public UserOrderForm totalAdjustmentField(){
		return totalAdjustmentField("totalAdjustment","");
	}


	public UserOrderForm totalAmountField(String parameterName, String initValue){
		FormField field = totalAmountFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm totalAmountField(String initValue){
		return totalAmountField("totalAmount",initValue);
	}
	public UserOrderForm totalAmountField(){
		return totalAmountField("totalAmount","");
	}


	public UserOrderForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public UserOrderForm userIdField(){
		return userIdField("userId","");
	}


	public UserOrderForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public UserOrderForm platformIdField(){
		return platformIdField("platformId","");
	}


	public UserOrderForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public UserOrderForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public UserOrderForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public UserOrderForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public UserOrderForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public UserOrderForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public UserOrderForm ageFieldOfProfile(String parameterName, String initValue){
		FormField field =  ageFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm ageFieldOfProfile(String initValue){
		return ageFieldOfProfile("age",initValue);
	}
	public UserOrderForm ageFieldOfProfile(){
		return ageFieldOfProfile("age","");
	}


	public UserOrderForm genderFieldOfProfile(String parameterName, String initValue){
		FormField field =  genderFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm genderFieldOfProfile(String initValue){
		return genderFieldOfProfile("gender",initValue);
	}
	public UserOrderForm genderFieldOfProfile(){
		return genderFieldOfProfile("gender","");
	}


	public UserOrderForm lastUpdateTimeFieldOfProfile(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm lastUpdateTimeFieldOfProfile(String initValue){
		return lastUpdateTimeFieldOfProfile("lastUpdateTime",initValue);
	}
	public UserOrderForm lastUpdateTimeFieldOfProfile(){
		return lastUpdateTimeFieldOfProfile("lastUpdateTime","");
	}


	public UserOrderForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public UserOrderForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public UserOrderForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public UserOrderForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public UserOrderForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public UserOrderForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public UserOrderForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public UserOrderForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public UserOrderForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserOrderForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public UserOrderForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public UserOrderForm lineItemIdFieldForLineItem(String parameterName, String initValue){
		FormField field =  idFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm lineItemIdFieldForLineItem(String initValue){
		return lineItemIdFieldForLineItem("lineItemId",initValue);
	}
	public UserOrderForm lineItemIdFieldForLineItem(){
		return lineItemIdFieldForLineItem("lineItemId","");
	}


	public UserOrderForm nameFieldForLineItem(String parameterName, String initValue){
		FormField field =  nameFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm nameFieldForLineItem(String initValue){
		return nameFieldForLineItem("name",initValue);
	}
	public UserOrderForm nameFieldForLineItem(){
		return nameFieldForLineItem("name","");
	}


	public UserOrderForm quantityFieldForLineItem(String parameterName, String initValue){
		FormField field =  quantityFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm quantityFieldForLineItem(String initValue){
		return quantityFieldForLineItem("quantity",initValue);
	}
	public UserOrderForm quantityFieldForLineItem(){
		return quantityFieldForLineItem("quantity","");
	}


	public UserOrderForm priceFieldForLineItem(String parameterName, String initValue){
		FormField field =  priceFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm priceFieldForLineItem(String initValue){
		return priceFieldForLineItem("price",initValue);
	}
	public UserOrderForm priceFieldForLineItem(){
		return priceFieldForLineItem("price","");
	}


	public UserOrderForm discountPriceFieldForLineItem(String parameterName, String initValue){
		FormField field =  discountPriceFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm discountPriceFieldForLineItem(String initValue){
		return discountPriceFieldForLineItem("discountPrice",initValue);
	}
	public UserOrderForm discountPriceFieldForLineItem(){
		return discountPriceFieldForLineItem("discountPrice","");
	}


	public UserOrderForm userOrderIdFieldForLineItem(String parameterName, String initValue){
		FormField field =  userOrderIdFromLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdFieldForLineItem(String initValue){
		return userOrderIdFieldForLineItem("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdFieldForLineItem(){
		return userOrderIdFieldForLineItem("userOrderId","");
	}


	public UserOrderForm orderPromotionIdFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  idFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm orderPromotionIdFieldForOrderPromotion(String initValue){
		return orderPromotionIdFieldForOrderPromotion("orderPromotionId",initValue);
	}
	public UserOrderForm orderPromotionIdFieldForOrderPromotion(){
		return orderPromotionIdFieldForOrderPromotion("orderPromotionId","");
	}


	public UserOrderForm nameFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  nameFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm nameFieldForOrderPromotion(String initValue){
		return nameFieldForOrderPromotion("name",initValue);
	}
	public UserOrderForm nameFieldForOrderPromotion(){
		return nameFieldForOrderPromotion("name","");
	}


	public UserOrderForm amountFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  amountFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm amountFieldForOrderPromotion(String initValue){
		return amountFieldForOrderPromotion("amount",initValue);
	}
	public UserOrderForm amountFieldForOrderPromotion(){
		return amountFieldForOrderPromotion("amount","");
	}


	public UserOrderForm threadHoldFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  threadHoldFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm threadHoldFieldForOrderPromotion(String initValue){
		return threadHoldFieldForOrderPromotion("threadHold",initValue);
	}
	public UserOrderForm threadHoldFieldForOrderPromotion(){
		return threadHoldFieldForOrderPromotion("threadHold","");
	}


	public UserOrderForm typeFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  typeFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm typeFieldForOrderPromotion(String initValue){
		return typeFieldForOrderPromotion("type",initValue);
	}
	public UserOrderForm typeFieldForOrderPromotion(){
		return typeFieldForOrderPromotion("type","");
	}


	public UserOrderForm userOrderIdFieldForOrderPromotion(String parameterName, String initValue){
		FormField field =  userOrderIdFromOrderPromotion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdFieldForOrderPromotion(String initValue){
		return userOrderIdFieldForOrderPromotion("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdFieldForOrderPromotion(){
		return userOrderIdFieldForOrderPromotion("userOrderId","");
	}


	public UserOrderForm manualAdjustmentIdFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  idFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm manualAdjustmentIdFieldForManualAdjustment(String initValue){
		return manualAdjustmentIdFieldForManualAdjustment("manualAdjustmentId",initValue);
	}
	public UserOrderForm manualAdjustmentIdFieldForManualAdjustment(){
		return manualAdjustmentIdFieldForManualAdjustment("manualAdjustmentId","");
	}


	public UserOrderForm nameFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  nameFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm nameFieldForManualAdjustment(String initValue){
		return nameFieldForManualAdjustment("name",initValue);
	}
	public UserOrderForm nameFieldForManualAdjustment(){
		return nameFieldForManualAdjustment("name","");
	}


	public UserOrderForm amountFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  amountFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm amountFieldForManualAdjustment(String initValue){
		return amountFieldForManualAdjustment("amount",initValue);
	}
	public UserOrderForm amountFieldForManualAdjustment(){
		return amountFieldForManualAdjustment("amount","");
	}


	public UserOrderForm threadHoldFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  threadHoldFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm threadHoldFieldForManualAdjustment(String initValue){
		return threadHoldFieldForManualAdjustment("threadHold",initValue);
	}
	public UserOrderForm threadHoldFieldForManualAdjustment(){
		return threadHoldFieldForManualAdjustment("threadHold","");
	}


	public UserOrderForm typeFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  typeFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm typeFieldForManualAdjustment(String initValue){
		return typeFieldForManualAdjustment("type",initValue);
	}
	public UserOrderForm typeFieldForManualAdjustment(){
		return typeFieldForManualAdjustment("type","");
	}


	public UserOrderForm userOrderIdFieldForManualAdjustment(String parameterName, String initValue){
		FormField field =  userOrderIdFromManualAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdFieldForManualAdjustment(String initValue){
		return userOrderIdFieldForManualAdjustment("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdFieldForManualAdjustment(){
		return userOrderIdFieldForManualAdjustment("userOrderId","");
	}


	public UserOrderForm shippingGroupIdFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  idFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm shippingGroupIdFieldForShippingGroup(String initValue){
		return shippingGroupIdFieldForShippingGroup("shippingGroupId",initValue);
	}
	public UserOrderForm shippingGroupIdFieldForShippingGroup(){
		return shippingGroupIdFieldForShippingGroup("shippingGroupId","");
	}


	public UserOrderForm nameFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  nameFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm nameFieldForShippingGroup(String initValue){
		return nameFieldForShippingGroup("name",initValue);
	}
	public UserOrderForm nameFieldForShippingGroup(){
		return nameFieldForShippingGroup("name","");
	}


	public UserOrderForm line1FieldForShippingGroup(String parameterName, String initValue){
		FormField field =  line1FromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm line1FieldForShippingGroup(String initValue){
		return line1FieldForShippingGroup("line1",initValue);
	}
	public UserOrderForm line1FieldForShippingGroup(){
		return line1FieldForShippingGroup("line1","");
	}


	public UserOrderForm line2FieldForShippingGroup(String parameterName, String initValue){
		FormField field =  line2FromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm line2FieldForShippingGroup(String initValue){
		return line2FieldForShippingGroup("line2",initValue);
	}
	public UserOrderForm line2FieldForShippingGroup(){
		return line2FieldForShippingGroup("line2","");
	}


	public UserOrderForm cityFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  cityFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm cityFieldForShippingGroup(String initValue){
		return cityFieldForShippingGroup("city",initValue);
	}
	public UserOrderForm cityFieldForShippingGroup(){
		return cityFieldForShippingGroup("city","");
	}


	public UserOrderForm stateFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  stateFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm stateFieldForShippingGroup(String initValue){
		return stateFieldForShippingGroup("state",initValue);
	}
	public UserOrderForm stateFieldForShippingGroup(){
		return stateFieldForShippingGroup("state","");
	}


	public UserOrderForm zipCodeFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  zipCodeFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm zipCodeFieldForShippingGroup(String initValue){
		return zipCodeFieldForShippingGroup("zipCode",initValue);
	}
	public UserOrderForm zipCodeFieldForShippingGroup(){
		return zipCodeFieldForShippingGroup("zipCode","");
	}


	public UserOrderForm countryFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  countryFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm countryFieldForShippingGroup(String initValue){
		return countryFieldForShippingGroup("country",initValue);
	}
	public UserOrderForm countryFieldForShippingGroup(){
		return countryFieldForShippingGroup("country","");
	}


	public UserOrderForm userOrderIdFieldForShippingGroup(String parameterName, String initValue){
		FormField field =  userOrderIdFromShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdFieldForShippingGroup(String initValue){
		return userOrderIdFieldForShippingGroup("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdFieldForShippingGroup(){
		return userOrderIdFieldForShippingGroup("userOrderId","");
	}


	public UserOrderForm paymentGroupIdFieldForPaymentGroup(String parameterName, String initValue){
		FormField field =  idFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm paymentGroupIdFieldForPaymentGroup(String initValue){
		return paymentGroupIdFieldForPaymentGroup("paymentGroupId",initValue);
	}
	public UserOrderForm paymentGroupIdFieldForPaymentGroup(){
		return paymentGroupIdFieldForPaymentGroup("paymentGroupId","");
	}


	public UserOrderForm nameFieldForPaymentGroup(String parameterName, String initValue){
		FormField field =  nameFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm nameFieldForPaymentGroup(String initValue){
		return nameFieldForPaymentGroup("name",initValue);
	}
	public UserOrderForm nameFieldForPaymentGroup(){
		return nameFieldForPaymentGroup("name","");
	}


	public UserOrderForm amountFieldForPaymentGroup(String parameterName, String initValue){
		FormField field =  amountFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm amountFieldForPaymentGroup(String initValue){
		return amountFieldForPaymentGroup("amount",initValue);
	}
	public UserOrderForm amountFieldForPaymentGroup(){
		return amountFieldForPaymentGroup("amount","");
	}


	public UserOrderForm userOrderIdFieldForPaymentGroup(String parameterName, String initValue){
		FormField field =  userOrderIdFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm userOrderIdFieldForPaymentGroup(String initValue){
		return userOrderIdFieldForPaymentGroup("userOrderId",initValue);
	}
	public UserOrderForm userOrderIdFieldForPaymentGroup(){
		return userOrderIdFieldForPaymentGroup("userOrderId","");
	}


	public UserOrderForm statusFieldForPaymentGroup(String parameterName, String initValue){
		FormField field =  statusFromPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserOrderForm statusFieldForPaymentGroup(String initValue){
		return statusFieldForPaymentGroup("status",initValue);
	}
	public UserOrderForm statusFieldForPaymentGroup(){
		return statusFieldForPaymentGroup("status","");
	}

	

	
 	public UserOrderForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/userOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public UserOrderForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/userOrderId/");
		this.addFormAction(action);
		return this;
	}

 

	public UserOrderForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


