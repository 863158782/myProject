import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    },
    partition_id:-1
  },
  mutations: {
    login (state, user) {
      this.state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    logout(state){
      this.state.user=''
    },
    setPartition_id(index){
      this.state.partition_id=index;
    }
  }
})
