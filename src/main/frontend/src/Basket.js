import React from 'react';
import BasketDataService from "./BasketDataService";
import UserDataService from "./UserDataService";
import './Basket.css';
class Basket extends React.Component {
    constructor(props) {
        super(props);
        this.state = {products: [], user: null};


        this.handleDelete = this.handleDelete.bind(this);
    }

    componentDidMount() {
        UserDataService.getSessionUser().then((response) => this.setState({user: response.data}));
        BasketDataService.showSessionBasket().then((response) => this.setState({products: response.data}));
    }

    handleClick = (event) => {
        BasketDataService.showSessionBasket().then((response) =>this.setState({products: response.data}));
    }

    handleDelete = (event) => {
        BasketDataService.deleteFromBasket(this.state.user, event.target.value).then(() =>{})
        BasketDataService.showSessionBasket().then((response) => this.setState({products: response.data}))
        event.preventDefault();
        alert("Product successfully deleted from basket");

    }

    render() {
        return (
            <div className="Basket">
                <h1>Basket</h1>
                <table id="table">
                    <thead>
                    <tr className="BasketListName">
                        <td>Product name</td>
                    </tr>
                    </thead>
                    <tbody> {
                        this.state.products.map(
                            basket =>
                                basket.products.map(
                                    product =>
                                        <tr key = {product.name}>
                                            <td className="basket-list">
                                                {product.name}
                                                <button id="delete-button" value={product.name} onClick={this.handleDelete}>Delete</button>
                                            </td>
                                        </tr>
                                )
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

export default Basket;