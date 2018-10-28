/** 接收组件通知触发mutation调用间接更新状态的方法的对象 */
import {
  ADD_TODO,
  DELETE_TODO,
  SELECT_ALL_TODOS,
  CLEAR_ALL_COMPLETED,
  RECEIVE_TODOS
} from './mutation-types'
import storageUtil from '../util/storageUtil'

export default {
  addTodo ({ commit }, todo) {
    // 提交对mutation的请求
    commit(ADD_TODO, todo)
  },
  deleteTodo ({ commit }, index) {
    commit(DELETE_TODO, index)
  },
  selectAllTodos ({ commit }, check) {
    commit(SELECT_ALL_TODOS, check)
  },
  clearAllCompleted ({ commit }) {
    commit(CLEAR_ALL_COMPLETED)
  },
  // 异步获取todos并更新状态
  reqTodos ({ commit }) {
    setTimeout(() => {
      // 读取数据
      const todos = storageUtil.readTodos()
      // 提交mutation
      commit(RECEIVE_TODOS, todos)
    }, 1000)
  }
}
