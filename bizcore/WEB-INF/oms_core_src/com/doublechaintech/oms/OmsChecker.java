package com.doublechaintech.oms;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class OmsChecker extends BaseChecker{
	
	
	protected OmsUserContext userContext;
	public OmsUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(OmsUserContext userContext) {
		this.userContext = userContext;
	}
	
	public OmsChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public OmsChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public OmsChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	public OmsChecker checkIntroductionOfPlatform(String introduction)
	{
		
	 	checkStringLengthRange(introduction,19, 288,INTRODUCTION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	public OmsChecker checkCurrentVersionOfPlatform(String currentVersion)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public OmsChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROFILE ="profile.id";
	public OmsChecker checkIdOfProfile(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PROFILE ="profile.name";
	public OmsChecker checkNameOfProfile(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  AGE_OF_PROFILE ="profile.age";
	public OmsChecker checkAgeOfProfile(int age)
	{
		
	 	checkIntegerRange(age,0, 40,AGE_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  GENDER_OF_PROFILE ="profile.gender";
	public OmsChecker checkGenderOfProfile(String gender)
	{
		
	 	checkGender(gender,2, 24,GENDER_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	public OmsChecker checkPlatformIdOfProfile(String platformId)
	{
		
	 	checkIdOfProfile(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROFILE ="profile.version";
	public OmsChecker checkVersionOfProfile(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_ORDER ="user_order.id";
	public OmsChecker checkIdOfUserOrder(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_ORDER ="user_order.title";
	public OmsChecker checkTitleOfUserOrder(String title)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_ADJUSTMENT_OF_USER_ORDER ="user_order.total_adjustment";
	public OmsChecker checkTotalAdjustmentOfUserOrder(BigDecimal totalAdjustment)
	{
		
	 	checkMoneyAmount(totalAdjustment,0.00, 100.12,TOTAL_ADJUSTMENT_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AMOUNT_OF_USER_ORDER ="user_order.total_amount";
	public OmsChecker checkTotalAmountOfUserOrder(BigDecimal totalAmount)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 10020.12,TOTAL_AMOUNT_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  USER_OF_USER_ORDER ="user_order.user";
	public OmsChecker checkUserIdOfUserOrder(String userId)
	{
		
	 	checkIdOfUserOrder(userId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_USER_ORDER ="user_order.platform";
	public OmsChecker checkPlatformIdOfUserOrder(String platformId)
	{
		
	 	checkIdOfUserOrder(platformId ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_USER_ORDER ="user_order.last_update_time";
	public OmsChecker checkLastUpdateTimeOfUserOrder(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_ORDER ="user_order.version";
	public OmsChecker checkVersionOfUserOrder(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LINE_ITEM ="line_item.id";
	public OmsChecker checkIdOfLineItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LINE_ITEM ="line_item.name";
	public OmsChecker checkNameOfLineItem(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_LINE_ITEM ="line_item.quantity";
	public OmsChecker checkQuantityOfLineItem(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 12,QUANTITY_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  PRICE_OF_LINE_ITEM ="line_item.price";
	public OmsChecker checkPriceOfLineItem(BigDecimal price)
	{
		
	 	checkMoneyAmount(price,0.00, 102.99,PRICE_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  DISCOUNT_PRICE_OF_LINE_ITEM ="line_item.discount_price";
	public OmsChecker checkDiscountPriceOfLineItem(BigDecimal discountPrice)
	{
		
	 	checkMoneyAmount(discountPrice,0.00, 11.03,DISCOUNT_PRICE_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_LINE_ITEM ="line_item.user_order";
	public OmsChecker checkUserOrderIdOfLineItem(String userOrderId)
	{
		
	 	checkIdOfLineItem(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LINE_ITEM ="line_item.version";
	public OmsChecker checkVersionOfLineItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORDER_PROMOTION ="order_promotion.id";
	public OmsChecker checkIdOfOrderPromotion(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ORDER_PROMOTION ="order_promotion.name";
	public OmsChecker checkNameOfOrderPromotion(String name)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_ORDER_PROMOTION ="order_promotion.amount";
	public OmsChecker checkAmountOfOrderPromotion(int amount)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  THREAD_HOLD_OF_ORDER_PROMOTION ="order_promotion.thread_hold";
	public OmsChecker checkThreadHoldOfOrderPromotion(int threadHold)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_ORDER_PROMOTION ="order_promotion.type";
	public OmsChecker checkTypeOfOrderPromotion(String type)
	{
		
	 	checkStringLengthRange(type,4, 44,TYPE_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_ORDER_PROMOTION ="order_promotion.user_order";
	public OmsChecker checkUserOrderIdOfOrderPromotion(String userOrderId)
	{
		
	 	checkIdOfOrderPromotion(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORDER_PROMOTION ="order_promotion.version";
	public OmsChecker checkVersionOfOrderPromotion(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MANUAL_ADJUSTMENT ="manual_adjustment.id";
	public OmsChecker checkIdOfManualAdjustment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MANUAL_ADJUSTMENT ="manual_adjustment.name";
	public OmsChecker checkNameOfManualAdjustment(String name)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_MANUAL_ADJUSTMENT ="manual_adjustment.amount";
	public OmsChecker checkAmountOfManualAdjustment(int amount)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  THREAD_HOLD_OF_MANUAL_ADJUSTMENT ="manual_adjustment.thread_hold";
	public OmsChecker checkThreadHoldOfManualAdjustment(int threadHold)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_MANUAL_ADJUSTMENT ="manual_adjustment.type";
	public OmsChecker checkTypeOfManualAdjustment(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_MANUAL_ADJUSTMENT ="manual_adjustment.user_order";
	public OmsChecker checkUserOrderIdOfManualAdjustment(String userOrderId)
	{
		
	 	checkIdOfManualAdjustment(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MANUAL_ADJUSTMENT ="manual_adjustment.version";
	public OmsChecker checkVersionOfManualAdjustment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SHIPPING_GROUP ="shipping_group.id";
	public OmsChecker checkIdOfShippingGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SHIPPING_GROUP ="shipping_group.name";
	public OmsChecker checkNameOfShippingGroup(String name)
	{
		
	 	checkStringLengthRange(name,4, 48,NAME_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  LINE1_OF_SHIPPING_GROUP ="shipping_group.line1";
	public OmsChecker checkLine1OfShippingGroup(String line1)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  LINE2_OF_SHIPPING_GROUP ="shipping_group.line2";
	public OmsChecker checkLine2OfShippingGroup(String line2)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  CITY_OF_SHIPPING_GROUP ="shipping_group.city";
	public OmsChecker checkCityOfShippingGroup(String city)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  STATE_OF_SHIPPING_GROUP ="shipping_group.state";
	public OmsChecker checkStateOfShippingGroup(String state)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ZIP_CODE_OF_SHIPPING_GROUP ="shipping_group.zip_code";
	public OmsChecker checkZipCodeOfShippingGroup(int zipCode)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  COUNTRY_OF_SHIPPING_GROUP ="shipping_group.country";
	public OmsChecker checkCountryOfShippingGroup(String country)
	{
		
	 	checkCountryCode(country,1, 8,COUNTRY_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_SHIPPING_GROUP ="shipping_group.user_order";
	public OmsChecker checkUserOrderIdOfShippingGroup(String userOrderId)
	{
		
	 	checkIdOfShippingGroup(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SHIPPING_GROUP ="shipping_group.version";
	public OmsChecker checkVersionOfShippingGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PAYMENT_GROUP ="payment_group.id";
	public OmsChecker checkIdOfPaymentGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PAYMENT_GROUP ="payment_group.name";
	public OmsChecker checkNameOfPaymentGroup(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_PAYMENT_GROUP ="payment_group.amount";
	public OmsChecker checkAmountOfPaymentGroup(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 123.00,AMOUNT_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_PAYMENT_GROUP ="payment_group.user_order";
	public OmsChecker checkUserOrderIdOfPaymentGroup(String userOrderId)
	{
		
	 	checkIdOfPaymentGroup(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  STATUS_OF_PAYMENT_GROUP ="payment_group.status";
	public OmsChecker checkStatusOfPaymentGroup(String status)
	{
		
	 	checkStringLengthRange(status,2, 28,STATUS_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PAYMENT_GROUP ="payment_group.version";
	public OmsChecker checkVersionOfPaymentGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public OmsChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public OmsChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public OmsChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public OmsChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public OmsChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public OmsChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public OmsChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public OmsChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public OmsChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public OmsChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public OmsChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public OmsChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public OmsChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public OmsChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public OmsChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public OmsChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public OmsChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public OmsChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public OmsChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public OmsChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public OmsChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public OmsChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public OmsChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public OmsChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public OmsChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public OmsChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public OmsChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public OmsChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public OmsChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public OmsChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public OmsChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public OmsChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public OmsChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public OmsChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public OmsChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public OmsChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public OmsChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public OmsChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public OmsChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public OmsChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public OmsChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public OmsChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public OmsChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public OmsChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public OmsChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public OmsChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public OmsChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public OmsChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public OmsChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public OmsChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public OmsChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public OmsChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public OmsChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public OmsChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public OmsChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public OmsChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public OmsChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public OmsChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public OmsChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public OmsChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public OmsChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public OmsChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public OmsChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public OmsChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public OmsChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public OmsChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public OmsChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public OmsChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public OmsChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public OmsChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public OmsChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public OmsChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public OmsChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public OmsChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public OmsChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public OmsChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public OmsChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public OmsChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public OmsChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public OmsChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public OmsChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public OmsChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public OmsChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public OmsChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public OmsChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public OmsChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public OmsChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public OmsChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public OmsChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public OmsChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public OmsChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public OmsChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public OmsChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public OmsChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public OmsChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public OmsChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public OmsChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public OmsChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public OmsChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public OmsChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public OmsChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public OmsChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
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

    
}












