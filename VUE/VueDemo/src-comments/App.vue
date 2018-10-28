<template>
  <div>
    <header class="site-header jumbotron">
      <div class="container">
        <div class="row">
          <div class="col-xs-12">
            <h1>请发表对Vue的评论</h1>
          </div>
        </div>
      </div>
    </header>
    <div class="container">
      <Add :addComment="addComment"/>
      <List :comments="comments" :delComment="delComment"/>
    </div>
  </div>
</template>

<script>
  import Add from './components/Add'
  import List from './components/List'

  export default {
    name: 'App',
    data () {
      return {
        comments: [ // 数据在哪个组件，更新数据的行为(方法)就应该定义在哪个组件
          {
            name: '小方',
            content:'Vue不错!'
          },
          {
            name: '小红',
            content:'Vue so easy!'
          },
        ]
      }
    },
    methods:{
      addComment(comment){
        this.comments.unshift(comment)
      },
      //删除指定下标的评论
      delComment(index){
        this.comments.splice(index,1)
      }
    },
    components: {
      Add,
      List,
    }
  }
</script>

<style scoped>

</style>
