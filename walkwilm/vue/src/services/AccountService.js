import axios from 'axios';

// const http = new axios.create({
//     baseURL: 'http://localhost:8080'
// });

export default {

    getCheckIns(id) {
        return axios.get(`/checkins/${id}`);
    },

    createCheckIn(id, checkIn){
        return axios.post(`/locations/${id}/checkIn`, checkIn);
    },

    getLocationsWithCheckins(id){
        return axios.get(`/locations/${id}`);
    },

    getBadges(id){
        return axios.get(`/badges/${id}`);
    }



    // getBadges(user_id) {
    //     return http.get('/badges');
    // }

}