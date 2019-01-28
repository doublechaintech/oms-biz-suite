import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userOrderManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userOrderManager/loadUserOrder/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userOrderManager/requestCandidateUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUser = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}userOrderManager/transferToAnotherUser/id/anotherUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userOrderManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}userOrderManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/addLineItem/userOrderId/name/quantity/price/discountPrice/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/updateLineItemProperties/userOrderId/id/name/quantity/price/discountPrice/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLineItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/removeLineItemList/userOrderId/lineItemIds/tokensExpr/`
  const requestParameters = { ...parameters, userOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addOrderPromotion = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/addOrderPromotion/userOrderId/name/amount/threadHold/type/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateOrderPromotion = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/updateOrderPromotionProperties/userOrderId/id/name/amount/threadHold/type/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeOrderPromotionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/removeOrderPromotionList/userOrderId/orderPromotionIds/tokensExpr/`
  const requestParameters = { ...parameters, userOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addManualAdjustment = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/addManualAdjustment/userOrderId/name/amount/threadHold/type/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateManualAdjustment = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/updateManualAdjustmentProperties/userOrderId/id/name/amount/threadHold/type/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeManualAdjustmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/removeManualAdjustmentList/userOrderId/manualAdjustmentIds/tokensExpr/`
  const requestParameters = { ...parameters, userOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/addShippingGroup/userOrderId/name/line1/line2/city/state/zipCode/country/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/updateShippingGroupProperties/userOrderId/id/name/line1/line2/city/state/zipCode/country/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeShippingGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/removeShippingGroupList/userOrderId/shippingGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, userOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/addPaymentGroup/userOrderId/name/amount/status/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/updatePaymentGroupProperties/userOrderId/id/name/amount/status/tokensExpr/`
  const userOrderId = targetObjectId
  const requestParameters = { ...parameters, userOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePaymentGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userOrderManager/removePaymentGroupList/userOrderId/paymentGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, userOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const UserOrderService = { view,
  load,
  addLineItem,
  addOrderPromotion,
  addManualAdjustment,
  addShippingGroup,
  addPaymentGroup,
  updateLineItem,
  updateOrderPromotion,
  updateManualAdjustment,
  updateShippingGroup,
  updatePaymentGroup,
  removeLineItemList,
  removeOrderPromotionList,
  removeManualAdjustmentList,
  removeShippingGroupList,
  removePaymentGroupList,
  requestCandidateUser,
  requestCandidatePlatform,
  transferToAnotherUser,
  transferToAnotherPlatform }
export default UserOrderService

