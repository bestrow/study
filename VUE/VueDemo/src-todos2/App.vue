<template>
  <div class="todo-container">
    <div class="todo-wrap">
      <todo-header @addTodo="addTodo"/>
      <todo-list :todos="todos"/>
      <todo-footer :todos="todos" :deleteCompleteTodos="deleteCompleteTodos" :selectAllTodos="selectAllTodos"/>
    </div>
  </div>
</template>

<script>
  import PubSub from 'pubsub-js'
  import TodoHeader from './components/TodoHeader'
  import TodoList from './components/TodoList'
  import TodoFooter from './components/TodoFooter'
  import storageUtil from './util/storageUtil'

  export default {
    name: 'App',
    data () {
      return {
        // 从localStorage中读取todos
        todos: storageUtil.readTodos()
      }
    },
    mounted () {
      // 订阅消息
      PubSub.subscribe('deleteTodo', (msg, index) => {
        this.deleteTodo(index)
      })
    },
    methods: {
      addTodo (todo) {
        this.todos.unshift(todo)
      },
      deleteTodo (index) {
        this.todos.splice(index, 1)
      },
      deleteCompleteTodos () {
        this.todos = this.todos.filter(todo => !todo.complete)
      },
      selectAllTodos (check) {
        this.todos.forEach(todo => todo.complete = check)
      }
    },
    components: {
      TodoHeader,
      TodoList,
      TodoFooter,
    },
    watch: {  // 监视
      todos: {
        deep: true, // 深度监视
        /*handler: function (value) {
          //将todos最新的值的json数据，保存到lacalStorage
          storageUtil.saveTodos(value)
        }*/
        handler:storageUtil.saveTodos
      }
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
