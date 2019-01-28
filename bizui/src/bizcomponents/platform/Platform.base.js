
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Platform", menuFor: "platform",
  		subItems: [
  {name: 'profileList', displayName:'Profile', icon:'file',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'userOrderList', displayName:'User Order', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'platform') },
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '27',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Introduction', debugtype: 'string', dataIndex: 'introduction', width: '76',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Current Version', debugtype: 'string', dataIndex: 'currentVersion', width: '8',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  introduction: 'Introduction',
  currentVersion: 'Current Version',

}


const PlatformBase={menuData,displayColumns,fieldLabels}
export default PlatformBase



