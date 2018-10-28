<template>
  <div class="todo-container">
    <div class="todo-wrap">
      <todo-header />
      <todo-list />
      <todo-footer />
    </div>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader'
import TodoList from './components/TodoList'
import TodoFooter from './components/TodoFooter'

export default {
  name: 'App',
  mounted () {
    // 发送命令给action：异步获取保存的todos数据并显示
    this.$store.dispatch('reqTodos')
  },
  components: {
    TodoHeader,
    TodoList,
    TodoFooter
  }
}
</script>

<style>
.todo-container {
  width: 600px;
  margin: 0 auto;
}

.todo-container .todo-wrap {
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
}
</style>
