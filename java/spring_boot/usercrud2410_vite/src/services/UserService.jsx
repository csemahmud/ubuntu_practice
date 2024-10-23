import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:9191/';

export const listUsers = () => axios.get(REST_API_BASE_URL + 'users');

export const createUser = (user) => axios.post(REST_API_BASE_URL + 'addUser', user);

export const getUserById = (id) => axios.get(REST_API_BASE_URL + 'user/' + id);

export const updateUser = (user) => axios.put(REST_API_BASE_URL + 'update', user);

export const deleteUser = (id) => axios.delete(REST_API_BASE_URL + 'delete/' + id);

export const getUserByEmail = (email) => axios.get(REST_API_BASE_URL + 'userByEmail/' + email);