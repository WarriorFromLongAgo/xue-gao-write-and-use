import { ILoginInfo, loginInfo } from "@/store/login/LoginInfo";

function getLoginInfo() {
  return loginInfo;
}

function getToken() {
  return getLoginInfo().token;
}

function updateNetworkState() {
  console.log(" updateNetworkState ");
  const loginInfo = getLoginInfo();
  return (loginInfo.networkState = !loginInfo.networkState);
}

function updateStatus(status: string) {
  return (getLoginInfo().status = status);
}

function updateToken(token: string) {
  return (getLoginInfo().token = token);
}

function updateUser(loginInfo: ILoginInfo) {
  return (getLoginInfo().user = loginInfo);
}

/**
 * 创建Action
 * @param loginInfo
 */
export function createAction(loginInfo: ILoginInfo) {
  return {
    updateToken: updateToken(loginInfo.token),
    updateNetworkState: updateNetworkState(),
    updateStatus: updateStatus(loginInfo.status),
    updateUser: updateUser(loginInfo),

    getLoginInfo: getLoginInfo(),
    getToken: getToken(),
  };
}
