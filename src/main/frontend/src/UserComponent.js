import React from 'react';
import UserDataService from './UserDataService.js';

//only for showing all users (not used right now)
class UserComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        UserDataService.getUsers().then((response) => this.setState({users: response.data}))
    }

    render() {
        return (
            <div>
                <h1>Users</h1>
                <table classname = "users">
                    <thead>
                    <tr>
                        <td>User login</td>
                        <td>User password</td>
                    </tr>
                    </thead>
                    <tbody> {
                        this.state.users.map(
                            user =>
                                <tr key = {user.login}>
                                    <td>{user.login}</td>
                                    <td>{user.password}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserComponent;