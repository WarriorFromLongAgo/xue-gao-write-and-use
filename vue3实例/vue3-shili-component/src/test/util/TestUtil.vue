<template>
  <div></div>
</template>

<script lang="ts" setup>
import { isEmpty, isNotEmpty, isBlank } from "@/util/ObjectUtil";

console.log("isEmpty, ", isEmpty(new Map()));
console.log("isEmpty, ", isEmpty(new Set()));
console.log("isEmpty, ", isEmpty([]));
console.log("isEmpty, ", isEmpty([1]));

let map = new Map();
map.set("1111", "11111");
console.log("isNotEmpty, ", isNotEmpty(map));

console.log("isBlank, ", isBlank(""));
console.log("isBlank, ", isBlank(" "));
console.log("isBlank, ", isBlank(" 1"));
</script>

<style scoped></style>
