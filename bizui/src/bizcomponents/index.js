



import PlatformBase from './platform/Platform.base';
import PlatformBizApp from './platform/Platform.app';
import PlatformModel from './platform/Platform.model';
import PlatformDashboard from './platform/Platform.dashboard';
import PlatformPreference from './platform/Platform.preference';
import PlatformModalTable from './platform/Platform.modaltable';
import PlatformSearch from './platform/Platform.search';
import PlatformSearchForm from './platform/Platform.searchform';
import PlatformCreateForm from './platform/Platform.createform';
import PlatformAssociateForm from './platform/Platform.associateform';
import PlatformTable from './platform/Platform.table';
import PlatformService from './platform/Platform.service';
import PlatformUpdateForm from './platform/Platform.updateform';
import ProfileBase from './profile/Profile.base';
import ProfileBizApp from './profile/Profile.app';
import ProfileModel from './profile/Profile.model';
import ProfileDashboard from './profile/Profile.dashboard';
import ProfilePreference from './profile/Profile.preference';
import ProfileModalTable from './profile/Profile.modaltable';
import ProfileSearch from './profile/Profile.search';
import ProfileSearchForm from './profile/Profile.searchform';
import ProfileCreateForm from './profile/Profile.createform';
import ProfileAssociateForm from './profile/Profile.associateform';
import ProfileTable from './profile/Profile.table';
import ProfileService from './profile/Profile.service';
import ProfileUpdateForm from './profile/Profile.updateform';
import UserOrderBase from './userorder/UserOrder.base';
import UserOrderBizApp from './userorder/UserOrder.app';
import UserOrderModel from './userorder/UserOrder.model';
import UserOrderDashboard from './userorder/UserOrder.dashboard';
import UserOrderPreference from './userorder/UserOrder.preference';
import UserOrderModalTable from './userorder/UserOrder.modaltable';
import UserOrderSearch from './userorder/UserOrder.search';
import UserOrderSearchForm from './userorder/UserOrder.searchform';
import UserOrderCreateForm from './userorder/UserOrder.createform';
import UserOrderAssociateForm from './userorder/UserOrder.associateform';
import UserOrderTable from './userorder/UserOrder.table';
import UserOrderService from './userorder/UserOrder.service';
import UserOrderUpdateForm from './userorder/UserOrder.updateform';
import LineItemBase from './lineitem/LineItem.base';
import LineItemBizApp from './lineitem/LineItem.app';
import LineItemModel from './lineitem/LineItem.model';
import LineItemDashboard from './lineitem/LineItem.dashboard';
import LineItemPreference from './lineitem/LineItem.preference';
import LineItemModalTable from './lineitem/LineItem.modaltable';
import LineItemSearch from './lineitem/LineItem.search';
import LineItemSearchForm from './lineitem/LineItem.searchform';
import LineItemCreateForm from './lineitem/LineItem.createform';
import LineItemAssociateForm from './lineitem/LineItem.associateform';
import LineItemTable from './lineitem/LineItem.table';
import LineItemService from './lineitem/LineItem.service';
import LineItemUpdateForm from './lineitem/LineItem.updateform';
import OrderPromotionBase from './orderpromotion/OrderPromotion.base';
import OrderPromotionBizApp from './orderpromotion/OrderPromotion.app';
import OrderPromotionModel from './orderpromotion/OrderPromotion.model';
import OrderPromotionDashboard from './orderpromotion/OrderPromotion.dashboard';
import OrderPromotionPreference from './orderpromotion/OrderPromotion.preference';
import OrderPromotionModalTable from './orderpromotion/OrderPromotion.modaltable';
import OrderPromotionSearch from './orderpromotion/OrderPromotion.search';
import OrderPromotionSearchForm from './orderpromotion/OrderPromotion.searchform';
import OrderPromotionCreateForm from './orderpromotion/OrderPromotion.createform';
import OrderPromotionAssociateForm from './orderpromotion/OrderPromotion.associateform';
import OrderPromotionTable from './orderpromotion/OrderPromotion.table';
import OrderPromotionService from './orderpromotion/OrderPromotion.service';
import OrderPromotionUpdateForm from './orderpromotion/OrderPromotion.updateform';
import ManualAdjustmentBase from './manualadjustment/ManualAdjustment.base';
import ManualAdjustmentBizApp from './manualadjustment/ManualAdjustment.app';
import ManualAdjustmentModel from './manualadjustment/ManualAdjustment.model';
import ManualAdjustmentDashboard from './manualadjustment/ManualAdjustment.dashboard';
import ManualAdjustmentPreference from './manualadjustment/ManualAdjustment.preference';
import ManualAdjustmentModalTable from './manualadjustment/ManualAdjustment.modaltable';
import ManualAdjustmentSearch from './manualadjustment/ManualAdjustment.search';
import ManualAdjustmentSearchForm from './manualadjustment/ManualAdjustment.searchform';
import ManualAdjustmentCreateForm from './manualadjustment/ManualAdjustment.createform';
import ManualAdjustmentAssociateForm from './manualadjustment/ManualAdjustment.associateform';
import ManualAdjustmentTable from './manualadjustment/ManualAdjustment.table';
import ManualAdjustmentService from './manualadjustment/ManualAdjustment.service';
import ManualAdjustmentUpdateForm from './manualadjustment/ManualAdjustment.updateform';
import ShippingGroupBase from './shippinggroup/ShippingGroup.base';
import ShippingGroupBizApp from './shippinggroup/ShippingGroup.app';
import ShippingGroupModel from './shippinggroup/ShippingGroup.model';
import ShippingGroupDashboard from './shippinggroup/ShippingGroup.dashboard';
import ShippingGroupPreference from './shippinggroup/ShippingGroup.preference';
import ShippingGroupModalTable from './shippinggroup/ShippingGroup.modaltable';
import ShippingGroupSearch from './shippinggroup/ShippingGroup.search';
import ShippingGroupSearchForm from './shippinggroup/ShippingGroup.searchform';
import ShippingGroupCreateForm from './shippinggroup/ShippingGroup.createform';
import ShippingGroupAssociateForm from './shippinggroup/ShippingGroup.associateform';
import ShippingGroupTable from './shippinggroup/ShippingGroup.table';
import ShippingGroupService from './shippinggroup/ShippingGroup.service';
import ShippingGroupUpdateForm from './shippinggroup/ShippingGroup.updateform';
import PaymentGroupBase from './paymentgroup/PaymentGroup.base';
import PaymentGroupBizApp from './paymentgroup/PaymentGroup.app';
import PaymentGroupModel from './paymentgroup/PaymentGroup.model';
import PaymentGroupDashboard from './paymentgroup/PaymentGroup.dashboard';
import PaymentGroupPreference from './paymentgroup/PaymentGroup.preference';
import PaymentGroupModalTable from './paymentgroup/PaymentGroup.modaltable';
import PaymentGroupSearch from './paymentgroup/PaymentGroup.search';
import PaymentGroupSearchForm from './paymentgroup/PaymentGroup.searchform';
import PaymentGroupCreateForm from './paymentgroup/PaymentGroup.createform';
import PaymentGroupAssociateForm from './paymentgroup/PaymentGroup.associateform';
import PaymentGroupTable from './paymentgroup/PaymentGroup.table';
import PaymentGroupService from './paymentgroup/PaymentGroup.service';
import PaymentGroupUpdateForm from './paymentgroup/PaymentGroup.updateform';
import UserDomainBase from './userdomain/UserDomain.base';
import UserDomainBizApp from './userdomain/UserDomain.app';
import UserDomainModel from './userdomain/UserDomain.model';
import UserDomainDashboard from './userdomain/UserDomain.dashboard';
import UserDomainPreference from './userdomain/UserDomain.preference';
import UserDomainModalTable from './userdomain/UserDomain.modaltable';
import UserDomainSearch from './userdomain/UserDomain.search';
import UserDomainSearchForm from './userdomain/UserDomain.searchform';
import UserDomainCreateForm from './userdomain/UserDomain.createform';
import UserDomainAssociateForm from './userdomain/UserDomain.associateform';
import UserDomainTable from './userdomain/UserDomain.table';
import UserDomainService from './userdomain/UserDomain.service';
import UserDomainUpdateForm from './userdomain/UserDomain.updateform';
import UserWhiteListBase from './userwhitelist/UserWhiteList.base';
import UserWhiteListBizApp from './userwhitelist/UserWhiteList.app';
import UserWhiteListModel from './userwhitelist/UserWhiteList.model';
import UserWhiteListDashboard from './userwhitelist/UserWhiteList.dashboard';
import UserWhiteListPreference from './userwhitelist/UserWhiteList.preference';
import UserWhiteListModalTable from './userwhitelist/UserWhiteList.modaltable';
import UserWhiteListSearch from './userwhitelist/UserWhiteList.search';
import UserWhiteListSearchForm from './userwhitelist/UserWhiteList.searchform';
import UserWhiteListCreateForm from './userwhitelist/UserWhiteList.createform';
import UserWhiteListAssociateForm from './userwhitelist/UserWhiteList.associateform';
import UserWhiteListTable from './userwhitelist/UserWhiteList.table';
import UserWhiteListService from './userwhitelist/UserWhiteList.service';
import UserWhiteListUpdateForm from './userwhitelist/UserWhiteList.updateform';
import SecUserBase from './secuser/SecUser.base';
import SecUserBizApp from './secuser/SecUser.app';
import SecUserModel from './secuser/SecUser.model';
import SecUserDashboard from './secuser/SecUser.dashboard';
import SecUserPreference from './secuser/SecUser.preference';
import SecUserModalTable from './secuser/SecUser.modaltable';
import SecUserSearch from './secuser/SecUser.search';
import SecUserSearchForm from './secuser/SecUser.searchform';
import SecUserCreateForm from './secuser/SecUser.createform';
import SecUserAssociateForm from './secuser/SecUser.associateform';
import SecUserTable from './secuser/SecUser.table';
import SecUserService from './secuser/SecUser.service';
import SecUserUpdateForm from './secuser/SecUser.updateform';
import SecUserBlockingBase from './secuserblocking/SecUserBlocking.base';
import SecUserBlockingBizApp from './secuserblocking/SecUserBlocking.app';
import SecUserBlockingModel from './secuserblocking/SecUserBlocking.model';
import SecUserBlockingDashboard from './secuserblocking/SecUserBlocking.dashboard';
import SecUserBlockingPreference from './secuserblocking/SecUserBlocking.preference';
import SecUserBlockingModalTable from './secuserblocking/SecUserBlocking.modaltable';
import SecUserBlockingSearch from './secuserblocking/SecUserBlocking.search';
import SecUserBlockingSearchForm from './secuserblocking/SecUserBlocking.searchform';
import SecUserBlockingCreateForm from './secuserblocking/SecUserBlocking.createform';
import SecUserBlockingAssociateForm from './secuserblocking/SecUserBlocking.associateform';
import SecUserBlockingTable from './secuserblocking/SecUserBlocking.table';
import SecUserBlockingService from './secuserblocking/SecUserBlocking.service';
import SecUserBlockingUpdateForm from './secuserblocking/SecUserBlocking.updateform';
import UserAppBase from './userapp/UserApp.base';
import UserAppBizApp from './userapp/UserApp.app';
import UserAppModel from './userapp/UserApp.model';
import UserAppDashboard from './userapp/UserApp.dashboard';
import UserAppPreference from './userapp/UserApp.preference';
import UserAppModalTable from './userapp/UserApp.modaltable';
import UserAppSearch from './userapp/UserApp.search';
import UserAppSearchForm from './userapp/UserApp.searchform';
import UserAppCreateForm from './userapp/UserApp.createform';
import UserAppAssociateForm from './userapp/UserApp.associateform';
import UserAppTable from './userapp/UserApp.table';
import UserAppService from './userapp/UserApp.service';
import UserAppUpdateForm from './userapp/UserApp.updateform';
import ListAccessBase from './listaccess/ListAccess.base';
import ListAccessBizApp from './listaccess/ListAccess.app';
import ListAccessModel from './listaccess/ListAccess.model';
import ListAccessDashboard from './listaccess/ListAccess.dashboard';
import ListAccessPreference from './listaccess/ListAccess.preference';
import ListAccessModalTable from './listaccess/ListAccess.modaltable';
import ListAccessSearch from './listaccess/ListAccess.search';
import ListAccessSearchForm from './listaccess/ListAccess.searchform';
import ListAccessCreateForm from './listaccess/ListAccess.createform';
import ListAccessAssociateForm from './listaccess/ListAccess.associateform';
import ListAccessTable from './listaccess/ListAccess.table';
import ListAccessService from './listaccess/ListAccess.service';
import ListAccessUpdateForm from './listaccess/ListAccess.updateform';
import ObjectAccessBase from './objectaccess/ObjectAccess.base';
import ObjectAccessBizApp from './objectaccess/ObjectAccess.app';
import ObjectAccessModel from './objectaccess/ObjectAccess.model';
import ObjectAccessDashboard from './objectaccess/ObjectAccess.dashboard';
import ObjectAccessPreference from './objectaccess/ObjectAccess.preference';
import ObjectAccessModalTable from './objectaccess/ObjectAccess.modaltable';
import ObjectAccessSearch from './objectaccess/ObjectAccess.search';
import ObjectAccessSearchForm from './objectaccess/ObjectAccess.searchform';
import ObjectAccessCreateForm from './objectaccess/ObjectAccess.createform';
import ObjectAccessAssociateForm from './objectaccess/ObjectAccess.associateform';
import ObjectAccessTable from './objectaccess/ObjectAccess.table';
import ObjectAccessService from './objectaccess/ObjectAccess.service';
import ObjectAccessUpdateForm from './objectaccess/ObjectAccess.updateform';
import LoginHistoryBase from './loginhistory/LoginHistory.base';
import LoginHistoryBizApp from './loginhistory/LoginHistory.app';
import LoginHistoryModel from './loginhistory/LoginHistory.model';
import LoginHistoryDashboard from './loginhistory/LoginHistory.dashboard';
import LoginHistoryPreference from './loginhistory/LoginHistory.preference';
import LoginHistoryModalTable from './loginhistory/LoginHistory.modaltable';
import LoginHistorySearch from './loginhistory/LoginHistory.search';
import LoginHistorySearchForm from './loginhistory/LoginHistory.searchform';
import LoginHistoryCreateForm from './loginhistory/LoginHistory.createform';
import LoginHistoryAssociateForm from './loginhistory/LoginHistory.associateform';
import LoginHistoryTable from './loginhistory/LoginHistory.table';
import LoginHistoryService from './loginhistory/LoginHistory.service';
import LoginHistoryUpdateForm from './loginhistory/LoginHistory.updateform';


const BizModels = [
	PlatformModel,
	ProfileModel,
	UserOrderModel,
	LineItemModel,
	OrderPromotionModel,
	ManualAdjustmentModel,
	ShippingGroupModel,
	PaymentGroupModel,
	UserDomainModel,
	UserWhiteListModel,
	SecUserModel,
	SecUserBlockingModel,
	UserAppModel,
	ListAccessModel,
	ObjectAccessModel,
	LoginHistoryModel,

]


const bindBizModels = (app) =>{

	BizModels.map((model)=>app.model(model))

}
const unbindBizModels = (app) =>{

	BizModels.map((model)=>app.unmodel(model))

}

const menuLibrary = []

menuLibrary['platform'] = PlatformBase.menuData
menuLibrary['profile'] = ProfileBase.menuData
menuLibrary['userOrder'] = UserOrderBase.menuData
menuLibrary['lineItem'] = LineItemBase.menuData
menuLibrary['orderPromotion'] = OrderPromotionBase.menuData
menuLibrary['manualAdjustment'] = ManualAdjustmentBase.menuData
menuLibrary['shippingGroup'] = ShippingGroupBase.menuData
menuLibrary['paymentGroup'] = PaymentGroupBase.menuData
menuLibrary['userDomain'] = UserDomainBase.menuData
menuLibrary['userWhiteList'] = UserWhiteListBase.menuData
menuLibrary['secUser'] = SecUserBase.menuData
menuLibrary['secUserBlocking'] = SecUserBlockingBase.menuData
menuLibrary['userApp'] = UserAppBase.menuData
menuLibrary['listAccess'] = ListAccessBase.menuData
menuLibrary['objectAccess'] = ObjectAccessBase.menuData
menuLibrary['loginHistory'] = LoginHistoryBase.menuData


const menuDataOf=(type)=>{
	
	const menu = menuLibrary[type]
	
	if(menu){
		return menu;
	}
	console.error(`Not able to find corresponding menu for ${type}`);

	return null;

}



const ViewMapping = {


  'com.doublechaintech.oms.platform.Platform': {name:'platform'},
  'com.doublechaintech.oms.profile.Profile': {name:'profile'},
  'com.doublechaintech.oms.userorder.UserOrder': {name:'userOrder'},
  'com.doublechaintech.oms.lineitem.LineItem': {name:'lineItem'},
  'com.doublechaintech.oms.orderpromotion.OrderPromotion': {name:'orderPromotion'},
  'com.doublechaintech.oms.manualadjustment.ManualAdjustment': {name:'manualAdjustment'},
  'com.doublechaintech.oms.shippinggroup.ShippingGroup': {name:'shippingGroup'},
  'com.doublechaintech.oms.paymentgroup.PaymentGroup': {name:'paymentGroup'},
  'com.doublechaintech.oms.userdomain.UserDomain': {name:'userDomain'},
  'com.doublechaintech.oms.userwhitelist.UserWhiteList': {name:'userWhiteList'},
  'com.doublechaintech.oms.secuser.SecUser': {name:'secUser'},
  'com.doublechaintech.oms.secuserblocking.SecUserBlocking': {name:'secUserBlocking'},
  'com.doublechaintech.oms.userapp.UserApp': {name:'userApp'},
  'com.doublechaintech.oms.listaccess.ListAccess': {name:'listAccess'},
  'com.doublechaintech.oms.objectaccess.ObjectAccess': {name:'objectAccess'},
  'com.doublechaintech.oms.loginhistory.LoginHistory': {name:'loginHistory'},

}



// eslint-disable-next-line no-unused-vars
const presentApp = (clazz, data) => {
  // console.log(data)
}


const calcLocationPath = (clazz,id,subLocation) => {

  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
  	return 'home'
  }
  const {name} = location;
  if(!name){
  	return '/home'
  }
  if (name) {
    return `${name}/${id}/${subLocation}`
  }
  return '/home'
}


const calcMenuData=(clazz) => {
  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
    return {};
  }
  const {name} = location;
  //const { menuDataOf } = GlobalComponents
  return menuDataOf(name)
}

// console.log("element", )



const OOTBComponents={
    PlatformBase,
    PlatformBizApp,
    PlatformModel,
    PlatformDashboard,
    PlatformPreference,
    PlatformModalTable,
    PlatformSearch,
    PlatformSearchForm,
    PlatformCreateForm,
    PlatformAssociateForm,
    PlatformTable,
    PlatformService,
    PlatformUpdateForm,
    ProfileBase,
    ProfileBizApp,
    ProfileModel,
    ProfileDashboard,
    ProfilePreference,
    ProfileModalTable,
    ProfileSearch,
    ProfileSearchForm,
    ProfileCreateForm,
    ProfileAssociateForm,
    ProfileTable,
    ProfileService,
    ProfileUpdateForm,
    UserOrderBase,
    UserOrderBizApp,
    UserOrderModel,
    UserOrderDashboard,
    UserOrderPreference,
    UserOrderModalTable,
    UserOrderSearch,
    UserOrderSearchForm,
    UserOrderCreateForm,
    UserOrderAssociateForm,
    UserOrderTable,
    UserOrderService,
    UserOrderUpdateForm,
    LineItemBase,
    LineItemBizApp,
    LineItemModel,
    LineItemDashboard,
    LineItemPreference,
    LineItemModalTable,
    LineItemSearch,
    LineItemSearchForm,
    LineItemCreateForm,
    LineItemAssociateForm,
    LineItemTable,
    LineItemService,
    LineItemUpdateForm,
    OrderPromotionBase,
    OrderPromotionBizApp,
    OrderPromotionModel,
    OrderPromotionDashboard,
    OrderPromotionPreference,
    OrderPromotionModalTable,
    OrderPromotionSearch,
    OrderPromotionSearchForm,
    OrderPromotionCreateForm,
    OrderPromotionAssociateForm,
    OrderPromotionTable,
    OrderPromotionService,
    OrderPromotionUpdateForm,
    ManualAdjustmentBase,
    ManualAdjustmentBizApp,
    ManualAdjustmentModel,
    ManualAdjustmentDashboard,
    ManualAdjustmentPreference,
    ManualAdjustmentModalTable,
    ManualAdjustmentSearch,
    ManualAdjustmentSearchForm,
    ManualAdjustmentCreateForm,
    ManualAdjustmentAssociateForm,
    ManualAdjustmentTable,
    ManualAdjustmentService,
    ManualAdjustmentUpdateForm,
    ShippingGroupBase,
    ShippingGroupBizApp,
    ShippingGroupModel,
    ShippingGroupDashboard,
    ShippingGroupPreference,
    ShippingGroupModalTable,
    ShippingGroupSearch,
    ShippingGroupSearchForm,
    ShippingGroupCreateForm,
    ShippingGroupAssociateForm,
    ShippingGroupTable,
    ShippingGroupService,
    ShippingGroupUpdateForm,
    PaymentGroupBase,
    PaymentGroupBizApp,
    PaymentGroupModel,
    PaymentGroupDashboard,
    PaymentGroupPreference,
    PaymentGroupModalTable,
    PaymentGroupSearch,
    PaymentGroupSearchForm,
    PaymentGroupCreateForm,
    PaymentGroupAssociateForm,
    PaymentGroupTable,
    PaymentGroupService,
    PaymentGroupUpdateForm,
    UserDomainBase,
    UserDomainBizApp,
    UserDomainModel,
    UserDomainDashboard,
    UserDomainPreference,
    UserDomainModalTable,
    UserDomainSearch,
    UserDomainSearchForm,
    UserDomainCreateForm,
    UserDomainAssociateForm,
    UserDomainTable,
    UserDomainService,
    UserDomainUpdateForm,
    UserWhiteListBase,
    UserWhiteListBizApp,
    UserWhiteListModel,
    UserWhiteListDashboard,
    UserWhiteListPreference,
    UserWhiteListModalTable,
    UserWhiteListSearch,
    UserWhiteListSearchForm,
    UserWhiteListCreateForm,
    UserWhiteListAssociateForm,
    UserWhiteListTable,
    UserWhiteListService,
    UserWhiteListUpdateForm,
    SecUserBase,
    SecUserBizApp,
    SecUserModel,
    SecUserDashboard,
    SecUserPreference,
    SecUserModalTable,
    SecUserSearch,
    SecUserSearchForm,
    SecUserCreateForm,
    SecUserAssociateForm,
    SecUserTable,
    SecUserService,
    SecUserUpdateForm,
    SecUserBlockingBase,
    SecUserBlockingBizApp,
    SecUserBlockingModel,
    SecUserBlockingDashboard,
    SecUserBlockingPreference,
    SecUserBlockingModalTable,
    SecUserBlockingSearch,
    SecUserBlockingSearchForm,
    SecUserBlockingCreateForm,
    SecUserBlockingAssociateForm,
    SecUserBlockingTable,
    SecUserBlockingService,
    SecUserBlockingUpdateForm,
    UserAppBase,
    UserAppBizApp,
    UserAppModel,
    UserAppDashboard,
    UserAppPreference,
    UserAppModalTable,
    UserAppSearch,
    UserAppSearchForm,
    UserAppCreateForm,
    UserAppAssociateForm,
    UserAppTable,
    UserAppService,
    UserAppUpdateForm,
    ListAccessBase,
    ListAccessBizApp,
    ListAccessModel,
    ListAccessDashboard,
    ListAccessPreference,
    ListAccessModalTable,
    ListAccessSearch,
    ListAccessSearchForm,
    ListAccessCreateForm,
    ListAccessAssociateForm,
    ListAccessTable,
    ListAccessService,
    ListAccessUpdateForm,
    ObjectAccessBase,
    ObjectAccessBizApp,
    ObjectAccessModel,
    ObjectAccessDashboard,
    ObjectAccessPreference,
    ObjectAccessModalTable,
    ObjectAccessSearch,
    ObjectAccessSearchForm,
    ObjectAccessCreateForm,
    ObjectAccessAssociateForm,
    ObjectAccessTable,
    ObjectAccessService,
    ObjectAccessUpdateForm,
    LoginHistoryBase,
    LoginHistoryBizApp,
    LoginHistoryModel,
    LoginHistoryDashboard,
    LoginHistoryPreference,
    LoginHistoryModalTable,
    LoginHistorySearch,
    LoginHistorySearchForm,
    LoginHistoryCreateForm,
    LoginHistoryAssociateForm,
    LoginHistoryTable,
    LoginHistoryService,
    LoginHistoryUpdateForm,
    menuDataOf,bindBizModels,unbindBizModels,calcLocationPath,calcMenuData
};
       


export default OOTBComponents;







