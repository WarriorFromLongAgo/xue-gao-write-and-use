import { readonly } from "vue";
import { createAction } from "@/store/login/LoginInfoCRUD";
import { createState } from "@/store/login/LoginInfo";

const state = createState();
const action = createAction(state);

export const useLoginStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
