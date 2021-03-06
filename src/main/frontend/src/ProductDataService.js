import axios from 'axios';

const PRODUCTS_URL = 'products'; //this for running on tomcat
const CATEGORIES_URL = 'categories';
// const PRODUCTS_URL = 'http://localhost:8080/products'; //this for running frontend and backend separately

class ProductDataService {
    getProducts = () => {
        return axios.get(PRODUCTS_URL);
    }

    addProduct = (name, category) => {
        console.log('Product name in dataservice: ' + name);
        return axios.post(PRODUCTS_URL, {name: name, category: category});
    }

    deleteProduct = (name) =>{
        console.log('Product name in dataservice: ' + name);
        return axios.delete(PRODUCTS_URL, {data :{name: name}});
    }

    getProductsByCategory = (category) => {
        return axios.get(PRODUCTS_URL + '/' + category);
    }

    getCategories = () => {
        return axios.get(CATEGORIES_URL);
    }
}

export default new ProductDataService();
