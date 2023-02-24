import axios from "axios";

const USER_API_BASE_URL = 
'http://localhost:9191/users';
//'http://localhost:3100/users';


class UserService{

    getUsers(){
        return axios.get(USER_API_BASE_URL);
    }

}

export default new UserService()