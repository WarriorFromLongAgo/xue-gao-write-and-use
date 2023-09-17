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
  name: "index",
  data() {
    return {
      title: '首页'
    }
  },
  methods: {},

  onInit() {
    console.log("index uniapp onInit")
  },
  onLoad() {
    console.log("index uniapp onLoad")
  },
  onShow() {
    console.log("index uniapp onShow")
  },
  onReady() {
    console.log("index uniapp onReady");
    let app = getApp();
    console.log("index ", app.globalData);
    app.doSomeThing();

    let globalMethodDoSomeThing = app.globalMethod_doSomeThing();
    console.log("index ", globalMethodDoSomeThing);

    let page = getCurrentPages();
    // console.log("index ", JSON.stringify(pageList));
    console.log("index pageList ", page);
    // pageList.navigateTo()

    // let getAppWebview = pageList.$getAppWebview();
    // console.log("index getAppWebview ", getAppWebview);

    // let getAppWebview2 = $getAppWebview();
    // console.log("index getAppWebview2 ", getAppWebview2);

    // const getAppWebview3 = this.$scope.$getAppWebview();
    // console.log("index getAppWebview3 ", getAppWebview3);
    // #ifdef APP-PLUS
    let currentWebview = page.$getAppWebview();
    console.log(currentWebview.id);//获得当前webview的id
    //查询当前webview是否可见
    console.log(currentWebview.isVisible());
    // #endif

  },
  onHide() {
    console.log("index uniapp onHide")
  },
  onUnload() {
    console.log("index uniapp onUnload")
  },
  onResize() {
    console.log("index uniapp onResize")
  },
  onPullDownRefresh() {
    console.log("index uniapp onPullDownRefresh")
  },
  onReachBottom() {
    console.log("index uniapp onReachBottom")
  },
  onTabItemTap() {
    console.log("index uniapp onTabItemTap")
  },
  onShareAppMessage() {
    console.log("index uniapp onShareAppMessage")
  },
  onPageScroll() {
    console.log("index uniapp onPageScroll")
  },
  onNavigationBarButtonTap() {
    console.log("index uniapp onNavigationBarButtonTap")
  },
  onBackPress() {
    console.log("index uniapp onBackPress")
  },
  onNavigationBarSearchInputChanged() {
    console.log("index uniapp onNavigationBarSearchInputChanged")
  },
  onNavigationBarSearchInputConfirmed() {
    console.log("index uniapp onNavigationBarSearchInputConfirmed")
  },
  onNavigationBarSearchInputClicked() {
    console.log("index uniapp onNavigationBarSearchInputClicked")
  },
  onShareTimeline() {
    console.log("index uniapp onShareTimeline")
  },
  onAddToFavorites() {
    console.log("index uniapp onAddToFavorites")
  },
  beforeCreate() {
    console.log("index vue2 beforeCreate")
  },
  created() {
    console.log("index vue2 created")
  },
  beforeMount() {
    console.log("index vue2 beforeMount")
  },
  mounted() {
    console.log("index vue2 mounted")
  },
  beforeUpdate() {
    console.log("index vue2 beforeUpdate")
  },
  updated() {
    console.log("index vue2 updated")
  },
  activated() {
    console.log("index vue2 activated")
  },
  deactivated() {
    console.log("index vue2 deactivated")
  },
  beforeDestroy() {
    console.log("index vue2 beforeDestroy")
  },
  destroyed() {
    console.log("index vue2 destroyed")
  },
  errorCaptured() {
    console.log("index vue2 errorCaptured")
  },
}
</script>

<style lang="css" scoped>
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
