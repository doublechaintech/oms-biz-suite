
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"User Order", menuFor: "userOrder",
  		subItems: [
  {name: 'lineItemList', displayName:'Line Item', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'orderPromotionList', displayName:'Order Promotion', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'manualAdjustmentList', displayName:'Manual Adjustment', icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'shippingGroupList', displayName:'Shipping Group', icon:'layer-group',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'paymentGroupList', displayName:'Payment Group', icon:'layer-group',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? value.displayName : appLocaleName(userContext,"NotAssigned")) 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userOrder') },
  { title: 'Title', debugtype: 'string', dataIndex: 'title', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Total Adjustment', dataIndex: 'totalAdjustment', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: 'Total Amount', dataIndex: 'totalAmount', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: 'User', dataIndex: 'user', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Last Update Time', debugtype: 'string', dataIndex: 'lastUpdateTime', width: '20',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  totalAdjustment: 'Total Adjustment',
  totalAmount: 'Total Amount',
  user: 'User',
  platform: 'Platform',
  lastUpdateTime: 'Last Update Time',

}


const UserOrderBase={menuData,displayColumns,fieldLabels}
export default UserOrderBase



