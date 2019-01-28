import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}lineItemManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}lineItemManager/loadLineItem/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUserOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}lineItemManager/requestCandidateUserOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUserOrder = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}lineItemManager/transferToAnotherUserOrder/id/anotherUserOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const LineItemService = { view,
  load,
  requestCandidateUserOrder,
  transferToAnotherUserOrder }
export default LineItemService

