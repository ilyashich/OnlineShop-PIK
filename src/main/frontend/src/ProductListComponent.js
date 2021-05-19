import React from 'react';
import ProductDataService from './ProductDataService.js';
import './ProductListComponent.css';

//only for showing all users (not used right now)
class ProductListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {products: []};
    }

    componentDidMount() {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
    }

    handleClick = (event) => {
        ProductDataService.getProducts().then((response) => this.setState({products: response.data}));
    }

    render() {
        return (
            <div>
                <h1>Products</h1>
                <table id={"table"}>
                    <thead>
                    <tr>
                        <td>Product name</td>
                    </tr>
                    </thead>
                    <tbody> {
                        this.state.products.map(
                            product =>
                                <tr key = {product.name}>
                                    <td>{product.name}</td>
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