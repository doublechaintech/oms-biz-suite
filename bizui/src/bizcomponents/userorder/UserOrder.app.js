import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './UserOrder.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class UserOrderBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/userOrder/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/userOrder/${this.props.userOrder.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/userOrder/${this.props.userOrder.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getLineItemSearch = () => {
    const {LineItemSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Line Item",
      role: "lineItem",
      data: state._userOrder.lineItemList,
      metaInfo: state._userOrder.lineItemListMetaInfo,
      count: state._userOrder.lineItemCount,
      currentPage: state._userOrder.lineItemCurrentPageNumber,
      searchFormParameters: state._userOrder.lineItemSearchFormParameters,
      searchParameters: {...state._userOrder.searchParameters},
      expandForm: state._userOrder.expandForm,
      loading: state._userOrder.loading,
      partialList: state._userOrder.partialList,
      owner: { type: '_userOrder', id: state._userOrder.id, 
      referenceName: 'userOrder', 
      listName: 'lineItemList', ref:state._userOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LineItemSearch)
  }
  getLineItemCreateForm = () => {
   	const {LineItemCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "lineItem",
      data: state._userOrder.lineItemList,
      metaInfo: state._userOrder.lineItemListMetaInfo,
      count: state._userOrder.lineItemCount,
      currentPage: state._userOrder.lineItemCurrentPageNumber,
      searchFormParameters: state._userOrder.lineItemSearchFormParameters,
      loading: state._userOrder.loading,
      owner: { type: '_userOrder', id: state._userOrder.id, referenceName: 'userOrder', listName: 'lineItemList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LineItemCreateForm)
  }
  
  getLineItemUpdateForm = () => {
    const userContext = null
  	const {LineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userOrder.selectedRows,
      role: "lineItem",
      currentUpdateIndex: state._userOrder.currentUpdateIndex,
      owner: { type: '_userOrder', id: state._userOrder.id, listName: 'lineItemList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LineItemUpdateForm)
  }

  getOrderPromotionSearch = () => {
    const {OrderPromotionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Order Promotion",
      role: "orderPromotion",
      data: state._userOrder.orderPromotionList,
      metaInfo: state._userOrder.orderPromotionListMetaInfo,
      count: state._userOrder.orderPromotionCount,
      currentPage: state._userOrder.orderPromotionCurrentPageNumber,
      searchFormParameters: state._userOrder.orderPromotionSearchFormParameters,
      searchParameters: {...state._userOrder.searchParameters},
      expandForm: state._userOrder.expandForm,
      loading: state._userOrder.loading,
      partialList: state._userOrder.partialList,
      owner: { type: '_userOrder', id: state._userOrder.id, 
      referenceName: 'userOrder', 
      listName: 'orderPromotionList', ref:state._userOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OrderPromotionSearch)
  }
  getOrderPromotionCreateForm = () => {
   	const {OrderPromotionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "orderPromotion",
      data: state._userOrder.orderPromotionList,
      metaInfo: state._userOrder.orderPromotionListMetaInfo,
      count: state._userOrder.orderPromotionCount,
      currentPage: state._userOrder.orderPromotionCurrentPageNumber,
      searchFormParameters: state._userOrder.orderPromotionSearchFormParameters,
      loading: state._userOrder.loading,
      owner: { type: '_userOrder', id: state._userOrder.id, referenceName: 'userOrder', listName: 'orderPromotionList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(OrderPromotionCreateForm)
  }
  
  getOrderPromotionUpdateForm = () => {
    const userContext = null
  	const {OrderPromotionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userOrder.selectedRows,
      role: "orderPromotion",
      currentUpdateIndex: state._userOrder.currentUpdateIndex,
      owner: { type: '_userOrder', id: state._userOrder.id, listName: 'orderPromotionList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OrderPromotionUpdateForm)
  }

  getManualAdjustmentSearch = () => {
    const {ManualAdjustmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Manual Adjustment",
      role: "manualAdjustment",
      data: state._userOrder.manualAdjustmentList,
      metaInfo: state._userOrder.manualAdjustmentListMetaInfo,
      count: state._userOrder.manualAdjustmentCount,
      currentPage: state._userOrder.manualAdjustmentCurrentPageNumber,
      searchFormParameters: state._userOrder.manualAdjustmentSearchFormParameters,
      searchParameters: {...state._userOrder.searchParameters},
      expandForm: state._userOrder.expandForm,
      loading: state._userOrder.loading,
      partialList: state._userOrder.partialList,
      owner: { type: '_userOrder', id: state._userOrder.id, 
      referenceName: 'userOrder', 
      listName: 'manualAdjustmentList', ref:state._userOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ManualAdjustmentSearch)
  }
  getManualAdjustmentCreateForm = () => {
   	const {ManualAdjustmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "manualAdjustment",
      data: state._userOrder.manualAdjustmentList,
      metaInfo: state._userOrder.manualAdjustmentListMetaInfo,
      count: state._userOrder.manualAdjustmentCount,
      currentPage: state._userOrder.manualAdjustmentCurrentPageNumber,
      searchFormParameters: state._userOrder.manualAdjustmentSearchFormParameters,
      loading: state._userOrder.loading,
      owner: { type: '_userOrder', id: state._userOrder.id, referenceName: 'userOrder', listName: 'manualAdjustmentList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ManualAdjustmentCreateForm)
  }
  
  getManualAdjustmentUpdateForm = () => {
    const userContext = null
  	const {ManualAdjustmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userOrder.selectedRows,
      role: "manualAdjustment",
      currentUpdateIndex: state._userOrder.currentUpdateIndex,
      owner: { type: '_userOrder', id: state._userOrder.id, listName: 'manualAdjustmentList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ManualAdjustmentUpdateForm)
  }

  getShippingGroupSearch = () => {
    const {ShippingGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Shipping Group",
      role: "shippingGroup",
      data: state._userOrder.shippingGroupList,
      metaInfo: state._userOrder.shippingGroupListMetaInfo,
      count: state._userOrder.shippingGroupCount,
      currentPage: state._userOrder.shippingGroupCurrentPageNumber,
      searchFormParameters: state._userOrder.shippingGroupSearchFormParameters,
      searchParameters: {...state._userOrder.searchParameters},
      expandForm: state._userOrder.expandForm,
      loading: state._userOrder.loading,
      partialList: state._userOrder.partialList,
      owner: { type: '_userOrder', id: state._userOrder.id, 
      referenceName: 'userOrder', 
      listName: 'shippingGroupList', ref:state._userOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ShippingGroupSearch)
  }
  getShippingGroupCreateForm = () => {
   	const {ShippingGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "shippingGroup",
      data: state._userOrder.shippingGroupList,
      metaInfo: state._userOrder.shippingGroupListMetaInfo,
      count: state._userOrder.shippingGroupCount,
      currentPage: state._userOrder.shippingGroupCurrentPageNumber,
      searchFormParameters: state._userOrder.shippingGroupSearchFormParameters,
      loading: state._userOrder.loading,
      owner: { type: '_userOrder', id: state._userOrder.id, referenceName: 'userOrder', listName: 'shippingGroupList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ShippingGroupCreateForm)
  }
  
  getShippingGroupUpdateForm = () => {
    const userContext = null
  	const {ShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userOrder.selectedRows,
      role: "shippingGroup",
      currentUpdateIndex: state._userOrder.currentUpdateIndex,
      owner: { type: '_userOrder', id: state._userOrder.id, listName: 'shippingGroupList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ShippingGroupUpdateForm)
  }

  getPaymentGroupSearch = () => {
    const {PaymentGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Payment Group",
      role: "paymentGroup",
      data: state._userOrder.paymentGroupList,
      metaInfo: state._userOrder.paymentGroupListMetaInfo,
      count: state._userOrder.paymentGroupCount,
      currentPage: state._userOrder.paymentGroupCurrentPageNumber,
      searchFormParameters: state._userOrder.paymentGroupSearchFormParameters,
      searchParameters: {...state._userOrder.searchParameters},
      expandForm: state._userOrder.expandForm,
      loading: state._userOrder.loading,
      partialList: state._userOrder.partialList,
      owner: { type: '_userOrder', id: state._userOrder.id, 
      referenceName: 'userOrder', 
      listName: 'paymentGroupList', ref:state._userOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PaymentGroupSearch)
  }
  getPaymentGroupCreateForm = () => {
   	const {PaymentGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "paymentGroup",
      data: state._userOrder.paymentGroupList,
      metaInfo: state._userOrder.paymentGroupListMetaInfo,
      count: state._userOrder.paymentGroupCount,
      currentPage: state._userOrder.paymentGroupCurrentPageNumber,
      searchFormParameters: state._userOrder.paymentGroupSearchFormParameters,
      loading: state._userOrder.loading,
      owner: { type: '_userOrder', id: state._userOrder.id, referenceName: 'userOrder', listName: 'paymentGroupList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PaymentGroupCreateForm)
  }
  
  getPaymentGroupUpdateForm = () => {
    const userContext = null
  	const {PaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userOrder.selectedRows,
      role: "paymentGroup",
      currentUpdateIndex: state._userOrder.currentUpdateIndex,
      owner: { type: '_userOrder', id: state._userOrder.id, listName: 'paymentGroupList', ref:state._userOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PaymentGroupUpdateForm)
  }


  
  buildRouters = () =>{
  	const {UserOrderDashboard} = GlobalComponents
  	const {UserOrderPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/userOrder/:id/dashboard", component: UserOrderDashboard},
  	{path:"/userOrder/:id/preference", component: UserOrderPreference},
  	
  	
  	
  	{path:"/userOrder/:id/list/lineItemList", component: this.getLineItemSearch()},
  	{path:"/userOrder/:id/list/lineItemCreateForm", component: this.getLineItemCreateForm()},
  	{path:"/userOrder/:id/list/lineItemUpdateForm", component: this.getLineItemUpdateForm()},
   	
  	{path:"/userOrder/:id/list/orderPromotionList", component: this.getOrderPromotionSearch()},
  	{path:"/userOrder/:id/list/orderPromotionCreateForm", component: this.getOrderPromotionCreateForm()},
  	{path:"/userOrder/:id/list/orderPromotionUpdateForm", component: this.getOrderPromotionUpdateForm()},
   	
  	{path:"/userOrder/:id/list/manualAdjustmentList", component: this.getManualAdjustmentSearch()},
  	{path:"/userOrder/:id/list/manualAdjustmentCreateForm", component: this.getManualAdjustmentCreateForm()},
  	{path:"/userOrder/:id/list/manualAdjustmentUpdateForm", component: this.getManualAdjustmentUpdateForm()},
   	
  	{path:"/userOrder/:id/list/shippingGroupList", component: this.getShippingGroupSearch()},
  	{path:"/userOrder/:id/list/shippingGroupCreateForm", component: this.getShippingGroupCreateForm()},
  	{path:"/userOrder/:id/list/shippingGroupUpdateForm", component: this.getShippingGroupUpdateForm()},
   	
  	{path:"/userOrder/:id/list/paymentGroupList", component: this.getPaymentGroupSearch()},
  	{path:"/userOrder/:id/list/paymentGroupCreateForm", component: this.getPaymentGroupCreateForm()},
  	{path:"/userOrder/:id/list/paymentGroupUpdateForm", component: this.getPaymentGroupUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Order Services'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.userOrder)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  userOrder: state._userOrder,
  ...state,
}))(UserOrderBizApp)



