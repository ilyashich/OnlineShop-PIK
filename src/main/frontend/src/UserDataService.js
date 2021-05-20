import axios from 'axios';

const USERS_URL = 'users'; //this for running on tomcat
// const USERS_URL = 'http://localhost:8080/users'; //this for running frontend and backend separately

class UserDataService {
    getUsers = () => {
        return axios.get(USERS_URL);
    }

    getUserByLogin = (login) => {
        return axios.get(USERS_URL + '/' + login);
    }

    getUserByLoginAndPassword = (login, password) => {
        return axios.get(USERS_URL + '/' + login + '/' + password);
    }

    addUser = (login, password) => {
        return axios.post(USERS_URL, {login: login, password: password});
    }
}

export default new UserDataService();