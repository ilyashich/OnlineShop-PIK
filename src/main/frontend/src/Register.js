import React from 'react';
import './Register.css';
import UserDataService from "./UserDataService";

class Register extends React.Component {
    constructor(props) {
        super(props);
        this.state = {login: '', password: '', canAdd: false, user: null};
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

    // checkIfExists = (event, response) => {
    //     this.setState({user: response.data});
    //     alert('Username is: ' + this.state.login +
    //         '\nPassword is: ' + this.state.password);
    //     if (this.state.user.login === this.state.login) {
    //         alert('User exists');
    //     }
    //     else {
    //         this.setState({canAdd: true});
    //         console.log('CanAdd: ' + this.state.canAdd);
    //         alert('User can be registered');
    //     }
    // }

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