import React from 'react';
import './Login.css';
import UserDataService from "./UserDataService";

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {username: '', password: '', user: null};
    }

    // fetchUsers = () => {
    //     UserDataService.getUsers().then((response) => this.setState({users: response.data}))
    //     console.log('InGetUsers' + this.state.users);
    // }

    //fetch user of specific login and password from backend, right now fetches Mark and his password only
    fetchUser = () => {
        UserDataService.getUserByLoginAndPassword().then((response) => this.setState({user: response.data}))
    }


    componentDidMount = () => {
        // this.fetchUsers();
        this.fetchUser();
    }

    handleChange = (event) => {
        if (event.target.name === "username") {
            this.setState({username: event.target.value});
        }
        else if (event.target.name === "password") {
            this.setState({password: event.target.value});
        }
    }

    handleSubmit = (event) => {
        alert('Username is: ' + this.state.username +
            '\nPassword is: ' + this.state.password);
        console.log(this.state.user.login);
        if (this.state.user.login === this.state.username &&
            this.state.user.password === this.state.password) {
            alert('Login successful');
        }
        else {
            alert('Login unsuccessful');
        }
        event.preventDefault(); //to avoid reloading page
    }

    render() {
        return(
            <div className="Login">
                <h1>Login</h1>
                <form onSubmit = {this.handleSubmit}>
                    <label id = "username">
                        Username<br/>
                        <input type="text" name="username"
                               value = {this.state.username} onChange = {this.handleChange}/>
                    </label>
                    <br/>
                    <label id = "password">
                        Password<br/>
                        <input type="password" name="password"
                               value = {this.state.password} onChange = {this.handleChange}/>
                    </label>
                    <br/>
                    <input type="submit" value="Confirm" />
                </form>
            </div>

        )
    }
}

export default Login;