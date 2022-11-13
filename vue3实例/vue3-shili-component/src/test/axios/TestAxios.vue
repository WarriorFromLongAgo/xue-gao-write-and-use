<template>
  <div>
    <button type="button" @click="login">login</button>
    <button type="button" @click="register">register</button>
  </div>
</template>

<script lang="ts" setup>
import {LoginCall} from "@/call/login/call/LoginCall";
import {useLoginStore} from "@/store/login/LoginInfoStore";

function login() {
  LoginCall.login().then((res: any) => {
    console.log("login" + JSON.stringify(res));
  });
  console.log(" login ");
  let loginStore = useLoginStore();
  console.log("loginStore.action.getLoginInfo = ", JSON.stringify(loginStore.state.user));
}

function register() {
  LoginCall.register().then((res: any) => {
    console.log("register" + JSON.stringify(res));
  });
}
</script>

<style scoped></style>
