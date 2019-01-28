

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UserOrder.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(userOrder)=>{return [
	 ]}

const internalImageListOf = (userOrder) =>defaultImageListOf(userOrder,imageList)

const optionList =(userOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (userOrder) =>defaultSettingListOf(userOrder, optionList)
const internalLargeTextOf = (userOrder) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (userOrder,targetComponent) =>{
	
	
	const {UserOrderService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{userOrder.id}</Description> 
<Description term="Title">{userOrder.title}</Description> 
<Description term="Total Adjustment">{userOrder.totalAdjustment}</Description> 
<Description term="Total Amount">{userOrder.totalAmount}</Description> 
<Description term="User">{userOrder.user==null?appLocaleName(userContext,"NotAssigned"):userOrder.user.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"User","profile",UserOrderService.requestCandidateUser,
	      UserOrderService.transferToAnotherUser,"anotherUserId",userOrder.user?userOrder.user.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{userOrder.lastUpdateTime}</Description> 
	
        {buildTransferModal(userOrder,targetComponent)}
      </DescriptionList>
	)

}


class UserOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'userOrder'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, lineItemListMetaInfo, orderPromotionListMetaInfo, manualAdjustmentListMetaInfo, shippingGroupListMetaInfo, paymentGroupListMetaInfo, lineItemCount, orderPromotionCount, manualAdjustmentCount, shippingGroupCount, paymentGroupCount } = this.props.userOrder
    if(!this.props.userOrder.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"User Order",cardsFor: "userOrder",
    	cardsSource: this.props.userOrder,returnURL,displayName,
  		subItems: [
{name: 'lineItemList', displayName:'Line Item',type:'lineItem',count:lineItemCount,addFunction: true, role: 'lineItem', metaInfo: lineItemListMetaInfo},
{name: 'orderPromotionList', displayName:'Order Promotion',type:'orderPromotion',count:orderPromotionCount,addFunction: true, role: 'orderPromotion', metaInfo: orderPromotionListMetaInfo},
{name: 'manualAdjustmentList', displayName:'Manual Adjustment',type:'manualAdjustment',count:manualAdjustmentCount,addFunction: true, role: 'manualAdjustment', metaInfo: manualAdjustmentListMetaInfo},
{name: 'shippingGroupList', displayName:'Shipping Group',type:'shippingGroup',count:shippingGroupCount,addFunction: true, role: 'shippingGroup', metaInfo: shippingGroupListMetaInfo},
{name: 'paymentGroupList', displayName:'Payment Group',type:'paymentGroup',count:paymentGroupCount,addFunction: true, role: 'paymentGroup', metaInfo: paymentGroupListMetaInfo},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  userOrder: state._userOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(UserOrderDashboard))

