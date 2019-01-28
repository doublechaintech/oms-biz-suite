import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}paymentGroupManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}paymentGroupManager/loadPaymentGroup/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUserOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}paymentGroupManager/requestCandidateUserOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUserOrder = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}paymentGroupManager/transferToAnotherUserOrder/id/anotherUserOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const PaymentGroupService = { view,
  load,
  requestCandidateUserOrder,
  transferToAnotherUserOrder }
export default PaymentGroupService

