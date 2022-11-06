<template>
  <div>
    父组件传递的
    <div>{{ modelValue }}</div>
    <div>{{ modelStr }}</div>
  </div>
  <div>
    子组件传递的
    <div>=============</div>
    <input :value="modelValue" /><br />
    组件内部值：{{ modelValue }}
    <br />
    <button @click="clickAddHandleDemo">+++</button>
    <button @click="clickAddHandle(11)">+++</button>
  </div>
</template>

<script lang="ts" setup>
import { defineEmits, defineProps } from "vue";
const parentProps = defineProps({
  modelValue: { type: Number, required: true },
  modelStr: String,
});

// 基于类型
const emit = defineEmits<{
  (e: "updateModelValue", id: number): void;
}>();

function clickAddHandleDemo(e: PointerEvent) {
  console.log("clickAddHandleDemo = ", e);
  emit("updateModelValue", 1);
}

function clickAddHandle(e: number) {
  console.log("clickAddHandle = ", e);
  emit("updateModelValue", e);
}
</script>
