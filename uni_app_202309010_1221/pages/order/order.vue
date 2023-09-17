<template>
  <view class="content">
    <image class="logo" src="/static/logo.png"></image>
    <view class="text-area">
      <text class="title">{{ title }}</text>
    </view>
  </view>
</template>

<script>
export default {
  name: "order.vue",
  data() {
    return {
      title: '订单列表'
    }
  },
  methods: {},


  onInit() {
    console.log("order uniapp onInit")
  },
  onLoad() {
    console.log("order uniapp onLoad")
  },
  onShow() {
    console.log("order uniapp onShow")
  },
  onReady() {
    console.log("order uniapp onReady")
  },
  onHide() {
    console.log("order uniapp onHide")
  },
  onUnload() {
    console.log("order uniapp onUnload")
  },
  onResize() {
    console.log("order uniapp onResize")
  },
  onPullDownRefresh() {
    console.log("order uniapp onPullDownRefresh")
  },
  onReachBottom() {
    console.log("order uniapp onReachBottom")
  },
  onTabItemTap() {
    console.log("order uniapp onTabItemTap")
  },
  onShareAppMessage() {
    console.log("order uniapp onShareAppMessage")
  },
  onPageScroll() {
    console.log("order uniapp onPageScroll")
  },
  onNavigationBarButtonTap() {
    console.log("order uniapp onNavigationBarButtonTap")
  },
  onBackPress() {
    console.log("order uniapp onBackPress")
  },
  onNavigationBarSearchInputChanged() {
    console.log("order uniapp onNavigationBarSearchInputChanged")
  },
  onNavigationBarSearchInputConfirmed() {
    console.log("order uniapp onNavigationBarSearchInputConfirmed")
  },
  onNavigationBarSearchInputClicked() {
    console.log("order uniapp onNavigationBarSearchInputClicked")
  },
  onShareTimeline() {
    console.log("order uniapp onShareTimeline")
  },
  onAddToFavorites() {
    console.log("order uniapp onAddToFavorites")
  },
  beforeCreate() {
    console.log("order vue2 beforeCreate")
  },
  created() {
    console.log("order vue2 created")
  },
  beforeMount() {
    console.log("order vue2 beforeMount")
  },
  mounted() {
    console.log("order vue2 mounted")
  },
  beforeUpdate() {
    console.log("order vue2 beforeUpdate")
  },
  updated() {
    console.log("order vue2 updated")
  },
  activated() {
    console.log("order vue2 activated")
  },
  deactivated() {
    console.log("order vue2 deactivated")
  },
  beforeDestroy() {
    console.log("order vue2 beforeDestroy")
  },
  destroyed() {
    console.log("order vue2 destroyed")
  },
  errorCaptured() {
    console.log("order vue2 errorCaptured")
  },
}
</script>

<style scoped lang="css">
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.logo {
  height: 200 rpx;
  width: 200 rpx;
  margin: 200 rpx auto 50 rpx;
}

.text-area {
  display: flex;
  justify-content: center;
}

.title {
  font-size: 36 rpx;
  color: #8f8f94;
}
</style>