import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}shippingGroupManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}shippingGroupManager/loadShippingGroup/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUserOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}shippingGroupManager/requestCandidateUserOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUserOrder = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}shippingGroupManager/transferToAnotherUserOrder/id/anotherUserOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const ShippingGroupService = { view,
  load,
  requestCandidateUserOrder,
  transferToAnotherUserOrder }
export default ShippingGroupService

