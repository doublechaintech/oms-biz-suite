import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}manualAdjustmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}manualAdjustmentManager/loadManualAdjustment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUserOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}manualAdjustmentManager/requestCandidateUserOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUserOrder = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}manualAdjustmentManager/transferToAnotherUserOrder/id/anotherUserOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const ManualAdjustmentService = { view,
  load,
  requestCandidateUserOrder,
  transferToAnotherUserOrder }
export default ManualAdjustmentService

