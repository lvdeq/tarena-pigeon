import {
  get, post
} from '@/utils/request.js'

export const queryPage = (data) => get('/provider/queryPage', data)
export const changeProviderEnable = (data) => post('/provider/change/enable/status?id=' + data, null, null)
export const save = (data) => post('/provider/save', data, null)
export const audit = (data) => post('/provider/audit', data, null)
