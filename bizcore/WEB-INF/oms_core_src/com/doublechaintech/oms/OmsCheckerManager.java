package com.doublechaintech.oms;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class OmsCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	protected void checkIntroductionOfPlatform(OmsUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,19, 288,INTRODUCTION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	protected void checkCurrentVersionOfPlatform(OmsUserContext userContext, String currentVersion, List<Message> messageList)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROFILE ="profile.id";
	protected void checkIdOfProfile(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROFILE ="profile.name";
	protected void checkNameOfProfile(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  AGE_OF_PROFILE ="profile.age";
	protected void checkAgeOfProfile(OmsUserContext userContext, int age, List<Message> messageList)
	{
		
	 	checkIntegerRange(age,0, 40,AGE_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  GENDER_OF_PROFILE ="profile.gender";
	protected void checkGenderOfProfile(OmsUserContext userContext, String gender, List<Message> messageList)
	{
		
	 	checkGender(gender,2, 24,GENDER_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	protected void checkPlatformIdOfProfile(OmsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProfile(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROFILE ="profile.version";
	protected void checkVersionOfProfile(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_ORDER ="user_order.id";
	protected void checkIdOfUserOrder(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_ORDER ="user_order.title";
	protected void checkTitleOfUserOrder(OmsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_ADJUSTMENT_OF_USER_ORDER ="user_order.total_adjustment";
	protected void checkTotalAdjustmentOfUserOrder(OmsUserContext userContext, BigDecimal totalAdjustment, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAdjustment,0.00, 100.12,TOTAL_ADJUSTMENT_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AMOUNT_OF_USER_ORDER ="user_order.total_amount";
	protected void checkTotalAmountOfUserOrder(OmsUserContext userContext, BigDecimal totalAmount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 10020.12,TOTAL_AMOUNT_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  USER_OF_USER_ORDER ="user_order.user";
	protected void checkUserIdOfUserOrder(OmsUserContext userContext, String userId, List<Message> messageList)
	{
		
	 	checkIdOfUserOrder(userContext,userId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_USER_ORDER ="user_order.platform";
	protected void checkPlatformIdOfUserOrder(OmsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfUserOrder(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_USER_ORDER ="user_order.last_update_time";
	protected void checkLastUpdateTimeOfUserOrder(OmsUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_ORDER ="user_order.version";
	protected void checkVersionOfUserOrder(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LINE_ITEM ="line_item.id";
	protected void checkIdOfLineItem(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LINE_ITEM ="line_item.name";
	protected void checkNameOfLineItem(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_LINE_ITEM ="line_item.quantity";
	protected void checkQuantityOfLineItem(OmsUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 12,QUANTITY_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_LINE_ITEM ="line_item.price";
	protected void checkPriceOfLineItem(OmsUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 102.99,PRICE_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  DISCOUNT_PRICE_OF_LINE_ITEM ="line_item.discount_price";
	protected void checkDiscountPriceOfLineItem(OmsUserContext userContext, BigDecimal discountPrice, List<Message> messageList)
	{
		
	 	checkMoneyAmount(discountPrice,0.00, 11.03,DISCOUNT_PRICE_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_LINE_ITEM ="line_item.user_order";
	protected void checkUserOrderIdOfLineItem(OmsUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfLineItem(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LINE_ITEM ="line_item.version";
	protected void checkVersionOfLineItem(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORDER_PROMOTION ="order_promotion.id";
	protected void checkIdOfOrderPromotion(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ORDER_PROMOTION ="order_promotion.name";
	protected void checkNameOfOrderPromotion(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_ORDER_PROMOTION ="order_promotion.amount";
	protected void checkAmountOfOrderPromotion(OmsUserContext userContext, int amount, List<Message> messageList)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  THREAD_HOLD_OF_ORDER_PROMOTION ="order_promotion.thread_hold";
	protected void checkThreadHoldOfOrderPromotion(OmsUserContext userContext, int threadHold, List<Message> messageList)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_ORDER_PROMOTION ="order_promotion.type";
	protected void checkTypeOfOrderPromotion(OmsUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,4, 44,TYPE_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_ORDER_PROMOTION ="order_promotion.user_order";
	protected void checkUserOrderIdOfOrderPromotion(OmsUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfOrderPromotion(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORDER_PROMOTION ="order_promotion.version";
	protected void checkVersionOfOrderPromotion(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MANUAL_ADJUSTMENT ="manual_adjustment.id";
	protected void checkIdOfManualAdjustment(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MANUAL_ADJUSTMENT ="manual_adjustment.name";
	protected void checkNameOfManualAdjustment(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_MANUAL_ADJUSTMENT ="manual_adjustment.amount";
	protected void checkAmountOfManualAdjustment(OmsUserContext userContext, int amount, List<Message> messageList)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  THREAD_HOLD_OF_MANUAL_ADJUSTMENT ="manual_adjustment.thread_hold";
	protected void checkThreadHoldOfManualAdjustment(OmsUserContext userContext, int threadHold, List<Message> messageList)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_MANUAL_ADJUSTMENT ="manual_adjustment.type";
	protected void checkTypeOfManualAdjustment(OmsUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_MANUAL_ADJUSTMENT ="manual_adjustment.user_order";
	protected void checkUserOrderIdOfManualAdjustment(OmsUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfManualAdjustment(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MANUAL_ADJUSTMENT ="manual_adjustment.version";
	protected void checkVersionOfManualAdjustment(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SHIPPING_GROUP ="shipping_group.id";
	protected void checkIdOfShippingGroup(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SHIPPING_GROUP ="shipping_group.name";
	protected void checkNameOfShippingGroup(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 48,NAME_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  LINE1_OF_SHIPPING_GROUP ="shipping_group.line1";
	protected void checkLine1OfShippingGroup(OmsUserContext userContext, String line1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  LINE2_OF_SHIPPING_GROUP ="shipping_group.line2";
	protected void checkLine2OfShippingGroup(OmsUserContext userContext, String line2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  CITY_OF_SHIPPING_GROUP ="shipping_group.city";
	protected void checkCityOfShippingGroup(OmsUserContext userContext, String city, List<Message> messageList)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  STATE_OF_SHIPPING_GROUP ="shipping_group.state";
	protected void checkStateOfShippingGroup(OmsUserContext userContext, String state, List<Message> messageList)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ZIP_CODE_OF_SHIPPING_GROUP ="shipping_group.zip_code";
	protected void checkZipCodeOfShippingGroup(OmsUserContext userContext, int zipCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  COUNTRY_OF_SHIPPING_GROUP ="shipping_group.country";
	protected void checkCountryOfShippingGroup(OmsUserContext userContext, String country, List<Message> messageList)
	{
		
	 	checkCountryCode(country,1, 8,COUNTRY_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_SHIPPING_GROUP ="shipping_group.user_order";
	protected void checkUserOrderIdOfShippingGroup(OmsUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfShippingGroup(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SHIPPING_GROUP ="shipping_group.version";
	protected void checkVersionOfShippingGroup(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PAYMENT_GROUP ="payment_group.id";
	protected void checkIdOfPaymentGroup(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PAYMENT_GROUP ="payment_group.name";
	protected void checkNameOfPaymentGroup(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_PAYMENT_GROUP ="payment_group.amount";
	protected void checkAmountOfPaymentGroup(OmsUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 123.00,AMOUNT_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_PAYMENT_GROUP ="payment_group.user_order";
	protected void checkUserOrderIdOfPaymentGroup(OmsUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfPaymentGroup(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  STATUS_OF_PAYMENT_GROUP ="payment_group.status";
	protected void checkStatusOfPaymentGroup(OmsUserContext userContext, String status, List<Message> messageList)
	{
		
	 	checkStringLengthRange(status,2, 28,STATUS_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PAYMENT_GROUP ="payment_group.version";
	protected void checkVersionOfPaymentGroup(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(OmsUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(OmsUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(OmsUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(OmsUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(OmsUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(OmsUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(OmsUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(OmsUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(OmsUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(OmsUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(OmsUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(OmsUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(OmsUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(OmsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(OmsUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(OmsUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(OmsUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(OmsUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(OmsUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(OmsUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(OmsUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(OmsUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(OmsUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(OmsUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(OmsUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(OmsUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(OmsUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(OmsUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(OmsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(OmsUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(OmsUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(OmsUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(OmsUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(OmsUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(OmsUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(OmsUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(OmsUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(OmsUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(OmsUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(OmsUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(OmsUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(OmsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(OmsUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(OmsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(OmsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(OmsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(OmsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(OmsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(OmsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(OmsUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(OmsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(OmsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(OmsUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(OmsUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(OmsUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(OmsUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(OmsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(OmsUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(OmsUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(OmsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(OmsUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(OmsUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(OmsUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(OmsUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(OmsUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(OmsUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(OmsUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(OmsUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(OmsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(OmsUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(OmsUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(OmsUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(OmsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(OmsUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(OmsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(OmsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof OmsUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		OmsUserContext userContext = (OmsUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(OmsUserContext userContext, List<Message> messageList, Class<? extends OmsException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, OmsException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











