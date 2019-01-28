import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addUserOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addUserOrder/profileId/title/totalAdjustment/totalAmount/platformId/lastUpdateTime/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateUserOrderProperties/profileId/id/title/totalAdjustment/totalAmount/lastUpdateTime/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeUserOrderList/profileId/userOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addUserOrder,
  updateUserOrder,
  removeUserOrderList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

