import React from 'react';
import ProductDataService from './ProductDataService.js';
import './ProductListComponent.css';

class ProductListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {products: []};

        this.handleClick = this.handleClick.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
    }

    componentDidMount() {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
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

    render() {
        return (
            <div className="ProductList">
                <h1>Products</h1>
                <table id="table">
                    <thead>
                    <tr>
                        <td>Product name</td>
                    </tr>
                    </thead>
                    <tbody> {
                        this.state.products.map(
                            product =>
                                <tr key = {product.name}>
                                    <td>
                                        {product.name}
                                        <button id="delete-button" value={product.name} onClick={this.handleDelete}>-</button>
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