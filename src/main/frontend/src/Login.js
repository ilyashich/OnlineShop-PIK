import React from 'react';
import './Login.css';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {username: '', password: ''};
        //this.handleChange = this.handleChange.bind(this);
        //this.handleSubmit = this.handleSubmit.bind(this);
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