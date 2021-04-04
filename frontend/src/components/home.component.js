import React, { Component } from "react";

export default class Home extends Component {

  render() {
    return (
      <div className="container">
        <h3>SSO APP</h3>
        <p><strong>MSS-User-Auth:</strong> is a Authorization Server. it will register and authenticate the User</p>
        <p><strong>App-2:</strong> is a Resource Server. it will Authorize the user based on the token validation and gives responce back</p>
      </div>
    );
  }
}