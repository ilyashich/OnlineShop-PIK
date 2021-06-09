import axios from 'axios';

const BASKETS_URL = 'baskets'; //this for running on tomcat
const SESSION_BASKET_URL = 'showbasket';
const ADD_TO_BASKET_URL = 'addtobasket';
const DELETE_FROM_BASKET_URL = 'deletefrombasket';
const BUY_URL = 'buy';
// const USERS_URL = 'http://localhost:8080/users'; //this for running frontend and backend separately

class BasketDataService {
    getBaskets = () => {
        return axios.get(BASKETS_URL);
    }

    addToBasket = (user, name) => {
        console.log('Product name in basket: ' + name);
            return axios.post(ADD_TO_BASKET_URL + '/' + name, {user: user});
    }

    deleteFromBasket = (user, name) => {
        console.log('Product name in basket: ' + name);
        return axios.delete(DELETE_FROM_BASKET_URL + '/' + name, {data: {user: user}});
    }

    showSessionBasket = (user) => {
        return axios.get(SESSION_BASKET_URL, {data: {user: user}});
    }

    buyBasket  = (user) => {
        return axios.get(BUY_URL, {data: {user: user}});
    }
}

export default new BasketDataService();