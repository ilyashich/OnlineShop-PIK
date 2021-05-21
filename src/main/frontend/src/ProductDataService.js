import axios from 'axios';

const PRODUCTS_URL = 'products'; //this for running on tomcat
// const PRODUCTS_URL = 'http://localhost:8080/products'; //this for running frontend and backend separately

class ProductDataService {
    getProducts = () => {
        return axios.get(PRODUCTS_URL);
    }

    addProduct = (name) => {
        console.log('Product name in dataservice: ' + name);
        return axios.post(PRODUCTS_URL, {name: name});
    }
}

export default new ProductDataService();