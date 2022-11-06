<template>
  <div>
    <div>这里是父组件的区域</div>

    <hr />
  </div>
  <hr />
  =========================================
  <hr />
  <div>
    <div>这里是子组件的区域-SonComponent</div>
    <hr />
    <son-component
      v-model:model-value="parentModelValue"
      v-model:model-str="parentModelStr"
      @updateModelValue="addParentModelValue"
    ></son-component>
  </div>
  <hr />
  ===========================================
  <hr />
  <!--  <son-component ref="parentModelValue"></son-component>-->
  <!--  <button @click="show">Show Child Message</button>-->
</template>

<script lang="ts" setup>
import SonComponent from "@/test/components/1/SonComponent.vue";
// import { getCurrentInstance } from "@vue/runtime-core";
import { ref } from "vue";

let parentModelValue = ref(11);
let parentModelStr = "parentModelStr";

function addParentModelValue(data: number) {
  console.log("addParentModelValue data = ", data);
  parentModelValue.value += data;
}

// const currentInstance = getCurrentInstance();
//
// function show() {
//   currentInstance.ctx.$refs.child.alertMessage();
// }
</script>

<style scoped></style>
