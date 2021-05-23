import './App.css';
import Login from './Login.js';
import ProductListComponent from "./ProductListComponent";
import Register from "./Register.js";
import AddProductComponent from "./AddProductComponent";
import {BrowserRouter, Switch, Route, Link} from "react-router-dom";
import { createBrowserHistory } from 'history';

export const history = createBrowserHistory({
    basename: process.env.PUBLIC_URL
});

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Switch>
                <Route path="/login">
                    <Login id="login"/>
                    <Link to="/" className="back">Back</Link>
                </Route>
                <Route path="/register">
                    <Register />
                    <Link to="/login" className="back">Back</Link>
                </Route>
                <Route path="/">
                    <ProductListComponent id="product list"/>
                    <AddProductComponent />
                    <Link to="/login" className="loginlink">Login</Link>
                </Route>
            </Switch>
        </BrowserRouter>
    </div>
  );
}

// <Login id="login"/>
// <ProductListComponent id="product list"/>
// <Register />
// <AddProductComponent />

export default App;
