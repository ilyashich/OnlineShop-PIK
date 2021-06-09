import axios from 'axios';

const USERS_URL = 'users'; //this for running on tomcat
// const USERS_URL = 'http://localhost:8080/users'; //this for running frontend and backend separately

class UserDataService {
    getUsers = () => {
        return axios.get(USERS_URL);
    }

    getUserByLoginAndPassword = (login, password) => {
        return axios.get(USERS_URL + '/' + login + '/' + password);
    }

    setSessionUser = (login, password) => {
        return axios.get('sessiontest' + '/' + login + '/' + password);
    }

    addUser = (login, password) => {
        return axios.post(USERS_URL, {login: login, password: password});
    }
}

export default new UserDataService();