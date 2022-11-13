import { reactive } from "vue";

interface ILoginInfo {
  networkState: boolean;
  status: string;
  token: string;
  user: any;
}

const loginInfo: ILoginInfo = {
  networkState: true,
  status: "",
  token: "",
  user: {},
};

function createState() {
  return reactive(loginInfo);
}

export { loginInfo, ILoginInfo, createState };
