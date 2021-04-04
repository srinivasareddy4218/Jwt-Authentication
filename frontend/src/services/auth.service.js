import axios from "axios";

const API_URL = "http://localhost:8090";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "/done", {
        username,
        password
      })
      .then(response => {
        if (response.data.jwttoken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, password) {
    return axios.post(API_URL + "/register", {
      username,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AuthService();