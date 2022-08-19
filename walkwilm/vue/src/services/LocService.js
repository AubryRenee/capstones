import axios from 'axios';

// const http = new axios.create({
//     baseURL: 'http://localhost:8080'
// });

export default {

    listLocations() {
        return axios.get('/locations');
    }

}