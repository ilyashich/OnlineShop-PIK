import './App.css';
import Login from './Login.js';
import ProductListComponent from "./ProductListComponent";
import Register from "./Register.js";
import AddProductComponent from "./AddProductComponent";

function App() {
  return (
    <div className="App">
      {/*<header className="App-header">*/}
        <Login id="login"/>
        <ProductListComponent id="product list"/>
        <Register />
        <AddProductComponent />
      {/*</header>*/}
    </div>
  );
}

export default App;
