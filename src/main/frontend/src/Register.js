import React from 'react';
import './Register.css';
import UserDataService from "./UserDataService";

class Register extends React.Component {
    constructor(props) {
        super(props);
        this.state = {login: '', password: '', canAdd: false, user: null};
    }

    handleChange = (event) => {
        if (event.target.name === "login") {
            this.setState({login: event.target.value});
        }
        else if (event.target.name === "password") {
            this.setState({password: event.target.value});
        }
    }

    printStatus = (event, response) => {
        this.setState({canAdd: response.data});
        if (this.state.canAdd === true) {
            alert('User successfully registered');
        }
        else {
            alert('User already exists');
        }
    }

    handleSubmit = (event) => {
        UserDataService.addUser(this.state.login, this.state.password).then((response) =>
            this.printStatus(event, response));
        event.preventDefault(); //to avoid reloading page;
    }

    render() {
        return(
            <div className="Register">
                <h1>Register</h1>
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
            </div>

        )
    }
}

export default Register;