package com.doublechaintech.oms.profile;
import com.doublechaintech.oms.BaseForm;
import com.doublechaintech.oms.genericform.GenericForm;
import com.doublechaintech.oms.formfield.FormField;
import com.doublechaintech.oms.formaction.FormAction;
import com.doublechaintech.oms.formmessage.FormMessage;
import com.doublechaintech.oms.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm ageField(String parameterName, String initValue){
		FormField field = ageFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm ageField(String initValue){
		return ageField("age",initValue);
	}
	public ProfileForm ageField(){
		return ageField("age","");
	}


	public ProfileForm genderField(String parameterName, String initValue){
		FormField field = genderFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm genderField(String initValue){
		return genderField("gender",initValue);
	}
	public ProfileForm genderField(){
		return genderField("gender","");
	}


	public ProfileForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ProfileForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public ProfileForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public ProfileForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public ProfileForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public ProfileForm userOrderIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userOrderIdFieldForUserOrder(String initValue){
		return userOrderIdFieldForUserOrder("userOrderId",initValue);
	}
	public ProfileForm userOrderIdFieldForUserOrder(){
		return userOrderIdFieldForUserOrder("userOrderId","");
	}


	public ProfileForm titleFieldForUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm titleFieldForUserOrder(String initValue){
		return titleFieldForUserOrder("title",initValue);
	}
	public ProfileForm titleFieldForUserOrder(){
		return titleFieldForUserOrder("title","");
	}


	public ProfileForm totalAdjustmentFieldForUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm totalAdjustmentFieldForUserOrder(String initValue){
		return totalAdjustmentFieldForUserOrder("totalAdjustment",initValue);
	}
	public ProfileForm totalAdjustmentFieldForUserOrder(){
		return totalAdjustmentFieldForUserOrder("totalAdjustment","");
	}


	public ProfileForm totalAmountFieldForUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm totalAmountFieldForUserOrder(String initValue){
		return totalAmountFieldForUserOrder("totalAmount",initValue);
	}
	public ProfileForm totalAmountFieldForUserOrder(){
		return totalAmountFieldForUserOrder("totalAmount","");
	}


	public ProfileForm userIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userIdFieldForUserOrder(String initValue){
		return userIdFieldForUserOrder("userId",initValue);
	}
	public ProfileForm userIdFieldForUserOrder(){
		return userIdFieldForUserOrder("userId","");
	}


	public ProfileForm platformIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForUserOrder(String initValue){
		return platformIdFieldForUserOrder("platformId",initValue);
	}
	public ProfileForm platformIdFieldForUserOrder(){
		return platformIdFieldForUserOrder("platformId","");
	}


	public ProfileForm lastUpdateTimeFieldForUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeFieldForUserOrder(String initValue){
		return lastUpdateTimeFieldForUserOrder("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeFieldForUserOrder(){
		return lastUpdateTimeFieldForUserOrder("lastUpdateTime","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


