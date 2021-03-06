import './App.css';
import Login from './Login.js';
import ProductListComponent from "./ProductListComponent";
import Register from "./Register.js";
import AddProductComponent from "./AddProductComponent";
import {BrowserRouter, Switch, Route, Link} from "react-router-dom";
import { createBrowserHistory } from 'history';
import ModifyProductComponent from "./ModifyProductComponent";
import Basket from "./Basket";

export const history = createBrowserHistory({
    basename: process.env.PUBLIC_URL
});

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Switch>
                <Route path="/online-shop/basket">
                    <Basket id="Basket"/>
                    <Link to="/online-shop" className="back">Back</Link>
                </Route>
                <Route path="/online-shop/login">
                    <Login id="login"/>
                    <Link to="/online-shop" className="back">Back</Link>
                </Route>
                <Route path="/online-shop/register">
                    <Register />
                    <Link to="/online-shop/login" className="back">Back</Link>
                </Route>
                <Route path="/online-shop">
                    <ProductListComponent id="product list"/>
                    <AddProductComponent />
                    <ModifyProductComponent/>
                    <Link to="/online-shop/login" className="loginlink">Login</Link>
                    <Link to="/online-shop/basket" className="basketlink">Basket</Link>
                </Route>
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
