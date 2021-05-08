import React from 'react';
import axios from 'axios';

const USERS_URL = 'http://localhost:8080/users';

class UserDataService {
    getUsers = () => {
        return axios.get(USERS_URL);
    }

    getUserByLoginAndPassword = () => {
        return axios.get(USERS_URL + "/Mark/admin123");
    }
}

export default new UserDataService();