import './App.css';
import Login from './Login.js';
import ProductListComponent from "./ProductListComponent";

function App() {
  return (
    <div className="App">
      {/*<header className="App-header">*/}
        <Login id="login"/>
        <ProductListComponent id="product list"/>
          {/*<UserComponent />*/}
      {/*</header>*/}
    </div>
  );
}

export default App;
