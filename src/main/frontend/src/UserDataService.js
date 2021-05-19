import React from 'react';
import axios from 'axios';

const USERS_URL = 'users';
// const USERS_URL = 'users';

class UserDataService {
    getUsers = () => {
        return axios.get(USERS_URL);
    }

    getUserByLoginAndPassword = (login, password) => {
        console.log("inUserDataService " + USERS_URL + "/" + login + "/" + password);
        return axios.get(USERS_URL + '/' + login + '/' + password);
    }
}

export default new UserDataService();