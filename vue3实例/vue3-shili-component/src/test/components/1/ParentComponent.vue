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
</template>

<script lang="ts" setup>
import SonComponent from "@/test/components/1/SonComponent.vue";
import { ref } from "vue";

let parentModelValue = ref(11);
let parentModelStr = "parentModelStr";

function addParentModelValue(data: { e: number }) {
  console.log("addParentModelValue data = ", data);
  console.log("addParentModelValue data.e = ", data.e);
  parentModelValue.value += data.e;
}
</script>

<style scoped></style>
