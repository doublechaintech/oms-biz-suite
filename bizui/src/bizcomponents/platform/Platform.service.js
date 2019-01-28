import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProfile/platformId/name/age/gender/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProfileProperties/platformId/id/name/age/gender/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProfileList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProfileList/platformId/profileIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUserOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addUserOrder/platformId/title/totalAdjustment/totalAmount/userId/lastUpdateTime/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateUserOrderProperties/platformId/id/title/totalAdjustment/totalAmount/lastUpdateTime/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeUserOrderList/platformId/userOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addProfile,
  addUserOrder,
  updateProfile,
  updateUserOrder,
  removeProfileList,
  removeUserOrderList }
export default PlatformService

