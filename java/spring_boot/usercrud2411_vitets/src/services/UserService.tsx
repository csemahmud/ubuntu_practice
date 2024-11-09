import axios from 'axios';
import { IUser } from '../models/IUser.type';

const REST_API_BASE_URL = 'http://localhost:9191/';

export const listUsers = () => axios.get(REST_API_BASE_URL + 'users');

export const createUser = (user: IUser) => axios.post(REST_API_BASE_URL + 'addUser', user);

export const getUserById = (id: number) => axios.get(REST_API_BASE_URL + 'user/' + id);

export const updateUser = (user: IUser) => axios.put(REST_API_BASE_URL + 'update', user);

export const deleteUser = (id: number) => axios.delete(REST_API_BASE_URL + 'delete/' + id);

export const getUserByEmail = (email: string) => axios.get(REST_API_BASE_URL + 'userByEmail/' + email);