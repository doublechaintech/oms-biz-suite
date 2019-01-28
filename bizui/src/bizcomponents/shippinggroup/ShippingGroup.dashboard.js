

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
import styles from './ShippingGroup.dashboard.less'
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


const imageList =(shippingGroup)=>{return [
	 ]}

const internalImageListOf = (shippingGroup) =>defaultImageListOf(shippingGroup,imageList)

const optionList =(shippingGroup)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (shippingGroup) =>defaultSettingListOf(shippingGroup, optionList)
const internalLargeTextOf = (shippingGroup) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (shippingGroup,targetComponent) =>{
	
	
	const {ShippingGroupService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{shippingGroup.id}</Description> 
<Description term="Name">{shippingGroup.name}</Description> 
<Description term="Line1">{shippingGroup.line1}</Description> 
<Description term="Line2">{shippingGroup.line2}</Description> 
<Description term="City">{shippingGroup.city}</Description> 
<Description term="State">{shippingGroup.state}</Description> 
<Description term="Zip Code">{shippingGroup.zipCode}</Description> 
<Description term="Country">{shippingGroup.country}</Description> 
<Description term="User Order">{shippingGroup.userOrder==null?appLocaleName(userContext,"NotAssigned"):shippingGroup.userOrder.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"User Order","userOrder",ShippingGroupService.requestCandidateUserOrder,
	      ShippingGroupService.transferToAnotherUserOrder,"anotherUserOrderId",shippingGroup.userOrder?shippingGroup.userOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(shippingGroup,targetComponent)}
      </DescriptionList>
	)

}


class ShippingGroupDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'shippingGroup'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.shippingGroup
    if(!this.props.shippingGroup.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Shipping Group",cardsFor: "shippingGroup",
    	cardsSource: this.props.shippingGroup,returnURL,displayName,
  		subItems: [
    
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
  shippingGroup: state._shippingGroup,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ShippingGroupDashboard))

