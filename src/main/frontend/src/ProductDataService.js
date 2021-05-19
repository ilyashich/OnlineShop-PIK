import React from 'react';
import axios from 'axios';

const PRODUCTS_URL = 'products';

class ProductDataService {
    getProducts = () => {
        return axios.get(PRODUCTS_URL);
    }
}

export default new ProductDataService();