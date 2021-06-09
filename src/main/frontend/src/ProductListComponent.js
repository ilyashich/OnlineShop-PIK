import React from 'react';
import ProductDataService from './ProductDataService.js';
import './ProductListComponent.css';
import UserDataService from "./UserDataService";
import BasketDataService from "./BasketDataService";

class ProductListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {products: [], user: null, canAdd: false};

        this.handleClick = this.handleClick.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
        this.handleAddToBasket = this.handleAddToBasket.bind(this);
    }

    componentDidMount() {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
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