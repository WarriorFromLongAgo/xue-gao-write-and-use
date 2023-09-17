<template>
  <view class="content">
    <image class="logo" src="/static/logo.png"></image>
    <view class="text-area">
      <text class="title">{{title}}</text>
    </view>
  </view>
</template>


<script>
export default {
  name: "my.vue",
  data() {
    return {
      title: '我的'
    }
  },
  methods: {},


  onInit() {
    console.log("my uniapp onInit")
  },
  onLoad() {
    console.log("my uniapp onLoad")
  },
  onShow() {
    console.log("my uniapp onShow")
  },
  onReady() {
    console.log("my uniapp onReady")
  },
  onHide() {
    console.log("my uniapp onHide")
  },
  onUnload() {
    console.log("my uniapp onUnload")
  },
  onResize() {
    console.log("my uniapp onResize")
  },
  onPullDownRefresh() {
    console.log("my uniapp onPullDownRefresh")
  },
  onReachBottom() {
    console.log("my uniapp onReachBottom")
  },
  onTabItemTap() {
    console.log("my uniapp onTabItemTap")
  },
  onShareAppMessage() {
    console.log("my uniapp onShareAppMessage")
  },
  onPageScroll() {
    console.log("my uniapp onPageScroll")
  },
  onNavigationBarButtonTap() {
    console.log("my uniapp onNavigationBarButtonTap")
  },
  onBackPress() {
    console.log("my uniapp onBackPress")
  },
  onNavigationBarSearchInputChanged() {
    console.log("my uniapp onNavigationBarSearchInputChanged")
  },
  onNavigationBarSearchInputConfirmed() {
    console.log("my uniapp onNavigationBarSearchInputConfirmed")
  },
  onNavigationBarSearchInputClicked() {
    console.log("my uniapp onNavigationBarSearchInputClicked")
  },
  onShareTimeline() {
    console.log("my uniapp onShareTimeline")
  },
  onAddToFavorites() {
    console.log("my uniapp onAddToFavorites")
  },
  beforeCreate() {
    console.log("my vue2 beforeCreate")
  },
  created() {
    console.log("my vue2 created")
  },
  beforeMount() {
    console.log("my vue2 beforeMount")
  },
  mounted() {
    console.log("my vue2 mounted")
  },
  beforeUpdate() {
    console.log("my vue2 beforeUpdate")
  },
  updated() {
    console.log("my vue2 updated")
  },
  activated() {
    console.log("my vue2 activated")
  },
  deactivated() {
    console.log("my vue2 deactivated")
  },
  beforeDestroy() {
    console.log("my vue2 beforeDestroy")
  },
  destroyed() {
    console.log("my vue2 destroyed")
  },
  errorCaptured() {
    console.log("my vue2 errorCaptured")
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