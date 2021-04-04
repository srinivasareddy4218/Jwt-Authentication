import React, { Component } from "react";
import AuthService from "../services/auth.service";

export default class Profile extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentUser: AuthService.getCurrentUser()
    };
  }

  render() {
    const { currentUser } = this.state;

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>Name: {currentUser.user}</strong>
          </h3>
        </header>
        <div class="col-xs-12 col-sm-6 col-md-8">
        <p>
          <strong>Token:</strong>{" "}
          {currentUser.jwttoken}
        </p>
        </div>
      </div>
    );
  }
}