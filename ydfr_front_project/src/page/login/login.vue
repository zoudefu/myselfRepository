<template>
  <div class="loginContainer">
    <!-- <head-top :head-title="loginWay? '登录':'密码登录'" goBack="true">

    </head-top> -->
  </div>
</template>
<script>
export default {
  name: "login",
  data() {
    return {
      msg: "我的登录页"
    };
  }
};
</script>
<style lang="scss" scoped>
.loginContainer{
        padding-top: 1.95rem;
        p, span, input{
            font-family: Helvetica Neue,Tahoma,Arial;
        }
    }
</style>
