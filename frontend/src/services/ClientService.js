import axios from 'axios'

const CLIENT_REST_API_URL = 'http://localhost:8080/clients'

class ClientService{
    getClients(){
        return axios.get(CLIENT_REST_API_URL);
    }

    createClient(client){
        return axios.post(CLIENT_REST_API_URL, client);
    }

    deleteClient(clientId){
        return axios.delete(CLIENT_REST_API_URL + '/' + clientId);
    }

    updateClient(client, clientId){
        return axios.put(CLIENT_REST_API_URL + '/' + clientId , client);
    }

    getClientById(clientId){
        return axios.get(CLIENT_REST_API_URL + '/' + clientId);
    }
}

export default new ClientService();