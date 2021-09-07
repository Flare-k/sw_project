import axios from 'axios';
import {router} from '../router';

const state = {
    token: null,
    username: null,
    role: null,
}

const getters = {
    'token' : state=>state.token,
    'username' : state=>state.username
}

const mutations = {
    loginUser(state, item) {
        state.token = item.headers['x-access-token']
        state.username = item.data['username']
        state.role = item.data['role']
    },

    logoutUser(state) {
        state.token = null,
        state.username = null,
        state.role = null
    }
}

const actions = {
    loginUser({commit}, {username, password}) {
        const params = {
            "username" : username,
            "password" : password
        }

        axios.post("http://localhost:8080/auth/login", JSON.stringify(params), {
            headers : {'content-type':'application/json'}
        }).then(res => {
            alert("정보가 확인되었습니다.\n환영합니다!")
            commit('login', res)
            router.push("/")
        }).catch(e=> {
            console.log(e)
            alert("로그인 요청에 문제가 발생했습니다.")
        })
    },
    logoutUser({commit}) {
        commit('logout')
    }
}

export default {
    state,
    getters,
    mutations,
    actions
  }