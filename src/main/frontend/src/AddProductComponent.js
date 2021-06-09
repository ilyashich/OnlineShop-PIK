import React from 'react';
import './AddProductComponent.css';
import ProductDataService from "./ProductDataService";

class AddProductComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: '', category: '', canAdd: false};
    }

    handleNameChange = (event) => {
        if (event.target.name === "name") {
            this.setState({name: event.target.value});
        }
    }

    handleCategoryChange = (event) => {
        if (event.target.name === "category") {
            this.setState({category: event.target.value});
        }
    }

    printStatus = (event, response) => {
        this.setState({canAdd: response.data});
        alert('Product successfully added');
    }

    handleSubmit = (event) => {
        ProductDataService.addProduct(this.state.name, this.state.category).then((response) =>
            this.printStatus(event, response));
        event.preventDefault(); //to avoid reloading page;
    }

    render() {
        return (
            <div className="AddProductComponent">
                <h1>Add product</h1>
                <form onSubmit = {this.handleSubmit}>
                    <label id = "name">
                        Name<br/>
                        <input type="text" name="name"
                               value = {this.state.name} onChange = {this.handleNameChange}/>
                    </label>
                    <label id = "category">
                        Category<br/>
                        <input type="text" name="category"
                               value = {this.state.category} onChange = {this.handleCategoryChange}/>
                    </label>
                    <br/>
                    <input type="submit" value="Confirm"/>
                </form>
            </div>
        )
    }
}

export default AddProductComponent;