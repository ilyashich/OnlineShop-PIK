import React from 'react';
import './AddProductComponent.css';
import ProductDataService from "./ProductDataService";

class AddProductComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: '', canAdd: false};
    }

    handleChange = (event) => {
        if (event.target.name === "name") {
            this.setState({name: event.target.value});
        }
    }

    printStatus = (event, response) => {
        this.setState({canAdd: response.data});
        alert('Product successfully added');
    }

    handleSubmit = (event) => {
        ProductDataService.addProduct(this.state.name).then((response) =>
            this.printStatus(event, response));
        event.preventDefault(); //to avoid reloading page;
    }

    render() {
        return (
            <div className={"AddProduct"}>
                <h1>Add product</h1>
                <form onSubmit = {this.handleSubmit}>
                    <label id = "name">
                        Name<br/>
                        <input type="text" name="name"
                               value = {this.state.name} onChange = {this.handleChange}/>
                    </label>
                    <br/>
                    <input type="submit" value="Confirm"/>
                </form>
            </div>
        )
    }
}

export default AddProductComponent;