import React from 'react';
import ProductDataService from './ProductDataService.js';
import './ProductListComponent.css';
import UserDataService from "./UserDataService";
import BasketDataService from "./BasketDataService";

class ProductListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {products: [], user: null, canAdd: false, categoryToFilter: '', categories: []};

        this.handleClick = this.handleClick.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
        this.handleAddToBasket = this.handleAddToBasket.bind(this);
        this.handleCategoryChange = this.handleCategoryChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
        ProductDataService.getCategories().then((response) => this.setState({categories: response.data}));
        UserDataService.getSessionUser().then((response) => this.setState({user: response.data}));
    }

    handleClick = (event) => {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
    }

    handleDelete = (event) => {
        ProductDataService.deleteProduct(event.target.value).then(() =>{});
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
        event.preventDefault();
        alert("Product successfully deleted");

    }

    handleCategoryChange(event){
        if (event.target.name === "category") {
            this.setState({categoryToFilter: event.target.value});
        }
    }

    handleSubmit = (event) => {
        ProductDataService.getProductsByCategory(this.state.categoryToFilter).then((response) =>
           this.setState({products: response.data}));
        event.preventDefault(); //to avoid reloading page;
    }

    printBasketStatus = (event, response) => {
        this.setState({canAdd: response.data});
        alert('Product successfully added to basket');
    }

    handleAddToBasket = (event) => {
        BasketDataService.addToBasket(this.state.user, event.target.value).then((response) =>
            this.printBasketStatus(event,response));
        event.preventDefault();
    }

    render() {
        return (
            <div className="ProductList">
                <h1>Products</h1>
                <select name='category' value={this.state.categoryToFilter} onChange={this.handleCategoryChange}>
                    <option value=''></option>
                    {this.state.categories.map(
                        category =>
                            <option value={category}>{category}</option>
                    )}
                </select><button onClick={this.handleSubmit}>Filter</button>
                <table id="table">
                    <thead>
                    <tr  className="ProductListName">
                        <td>Product name</td>
                    </tr>
                    </thead>
                    <tbody> {
                        this.state.products.map(
                            product =>
                                <tr key = {product.name}>
                                    <td className="prod-list">
                                        {product.name}
                                        <button id="delete-button" value={product.name} onClick={this.handleDelete}>Delete</button><button id="add-basket-button" value={product.name} onClick={this.handleAddToBasket}>Add to basket</button>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
                <button onClick={this.handleClick}>
                    Refresh
                </button>
            </div>
        )
    }
}

export default ProductListComponent;
