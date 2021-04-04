import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8091/';

class AppTwoService {
  getAppTwoGreetings() {
    return axios.get(API_URL + 'hello', { headers: authHeader() });
  }
}

export default new AppTwoService();