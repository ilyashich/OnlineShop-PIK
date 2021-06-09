import React from 'react';
import './Login.css';
import UserDataService from "./UserDataService";
import {Link} from "react-router-dom";

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {login: '', password: '', user: null};
    }

    // componentDidMount = () => {
    //     // this.fetchUsers();
    //     UserDataService.getUserByLoginAndPassword(this.state.login, this.state.password).then(
    //         (response) => this.setState({user: response.data}));
    // }

    handleChange = (event) => {
        if (event.target.name === "login") {
            this.setState({login: event.target.value});
        }
        else if (event.target.name === "password") {
            this.setState({password: event.target.value});
        }
    }

    check = (event, response) => {
        this.setState({user: response.data});
        alert('Username is: ' + this.state.login +
            '\nPassword is: ' + this.state.password);
        if (this.state.user.login === this.state.login &&
            this.state.user.password === this.state.password) {
            UserDataService.setSessionUser(this.state.login, this.state.password).then(()=>{});
            alert('Login successful');
        }
        else {
            alert('Login unsuccessful');
        }
    }

    handleSubmit = (event) => {
        UserDataService.getUserByLoginAndPassword(this.state.login, this.state.password).then((response) =>
            this.check(event, response));
        event.preventDefault(); //to avoid reloading page);
    }

    render() {
        return(
            <div className="Login">
                <h1>Login</h1>
                <form onSubmit = {this.handleSubmit}>
                    <label id = "username">
                        Username<br/>
                        <input type="text" name="login"
                               value = {this.state.login} onChange = {this.handleChange}/>
                    </label>
                    <br/>
                    <label id = "password">
                        Password<br/>
                        <input type="password" name="password"
                               value = {this.state.password} onChange = {this.handleChange}/>
                    </label>
                    <br/>
                    <input type="submit" value="Confirm"/>
                </form>
                <Link to="/register" className="registerlink">Register</Link>
            </div>

        )
    }
}

export default Login;