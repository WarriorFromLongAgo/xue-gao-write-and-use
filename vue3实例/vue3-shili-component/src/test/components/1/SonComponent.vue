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

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "SonComponent",
  // 父组件可以使用 props 把数据传给子组件。
  props: {
    // 父组件传递给子组件的值
    modelValue: Number,
    modelStr: String,
  },
  // 子组件可以使用 $emit,让父组件监听到自定义事件 。
  // 也就是父组件，调用子组件的方法
  emits: ["updateModelValue"],

  // 子组件，自定义一些方法
  setup(props, context) {
    // 向父组件提交修改属性
    const clickAddHandleDemo = (e: PointerEvent) => {
      console.log("clickAddHandleDemo = ", e);
      context.emit("updateModelValue", { e: 1 });
    };
    const clickAddHandle = (e: number) => {
      console.log("clickAddHandle = ", e);
      context.emit("updateModelValue", { e });
    };
    return {
      clickAddHandle,
      clickAddHandleDemo,
    };
  },
});
</script>
