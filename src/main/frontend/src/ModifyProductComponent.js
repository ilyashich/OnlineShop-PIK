import "./ModifyProductComponent.css";
import React, {useState} from "react";
import ProductDataService from "./ProductDataService";


export default function ModifyProductComponent() {
    const [oldName, setOldName] = useState('');
    const [name, setName] = useState('');
    const [category, setCategory] = useState('');
    const [canAdd, setAdd] = useState(false);

    function handleOldNameChange(e) {
        setOldName(e.target.value);
    }

    function handleNameChange(e) {
        setName(e.target.value);
    }

    function handleCategoryChange(e) {
        setCategory(e.target.value)
    }

    function printStatus(event, response) {
        setAdd(response.data);
        alert('Product successfully modified');
    }

    function handleSubmit(e) {
        ProductDataService.deleteProduct(oldName).then(() => {
        });
        ProductDataService.addProduct(name, category).then((response) =>
            printStatus(e, response));
        e.preventDefault();
    }

    return (
        <div className="ModifyProductComponent">
            <div className="form-box solid">
                <form onSubmit={handleSubmit}>
                    <h1 className="modify-text">Modify Product</h1>
                    <label>Old Name</label>
                    <br/>
                    <input type="text" name="oldProductName" value={oldName} onChange={handleOldNameChange}/>
                    <br/>
                    <label>New Name</label>
                    <br/>
                    <input type="text" name="productName" value={name} onChange={handleNameChange}/>
                    <br/>
                    <label>Category</label>
                    <br/>
                    <input type="text" name="category" value={category} onChange={handleCategoryChange}/>
                    <br/>
                    <input type="submit" value="Confirm" className="modify-btn"/>
                </form>
            </div>
        </div>
    );
}
