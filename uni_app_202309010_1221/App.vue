<script>
export default {
  globalData: {
    abc: "我是 App页面 全局可以调用的内容"
  },
  methods: {
    doSomeThing() {
      console.log('App doSomeThing')
    },
  },
  onLaunch: function () {
    console.log('App Launch')
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  }
}
</script>

<style>
/*每个页面公共css */
</style>
