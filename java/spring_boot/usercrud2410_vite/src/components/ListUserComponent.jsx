import React, { useEffect, useState } from 'react'
import { deleteUser, getUserByEmail, listUsers } from '../services/UserService';
import { useNavigate } from 'react-router-dom';

const ListUserComponent = () => {

    const [message, setMessage] = useState('')
    const [email, setEmail] = useState('')

    
    const [users, setUsers] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        
        getAllUsers();

    }, []);

    function getAllUsers(){

        listUsers().then((response) => {
            setUsers(response.data);
        }).catch(error => {
            console.error(error);
        })

    }

    function AddNewUser(){
        navigator('/add-user')
    }

    function editUser(id){
        navigator(`/edit-user/${id}`)
    }

    function removeUser(user){
        console.log(user);

        if(confirm("Are you sure, you want to DELETE the following user ?\n"
            + JSON.stringify(user, undefined, 4)
        ) == true){

            deleteUser(user.id).then((response) => {
                getAllUsers();
                setMessage(response.data);
            }).catch(error =>{
                console.error(error);
            })

        }
    }

    function findUserByEmailId(){
        console.log(email);

        getUserByEmail(email).then((response) => {
            let responseUsers = [];
            responseUsers.push(response.data)
            console.log(responseUsers);
            console.log(response.data);
            setUsers(responseUsers);
            console.log(users);
        }).catch(error => {
            console.error(error);
        })
        
    }

  return (
    <div className='container'>
        <h5>{message}</h5>
        <h2 className='text-center'>List Of Users</h2>
        <div className="row">
            <div id="custom-search-input">
                <div className="input-group col-md-12" style={{textAlign: 'center'}}>
                    <input type="text" className="search-query form-control" placeholder="Search With Email Address"
                    name="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)}/>
                    <span className="input-group-btn">
                        <button className="btn btn-danger" type="button" 
                        data-toggle="tooltip" data-placement="top" title="Search" 
                        onClick = {findUserByEmailId}>
                            <i className="bi bi-search"></i>
                        </button>
                    </span>
                </div>
            </div>
        </div>
        <div className='button__container'>
            <button type="button" className='btn btn-dark mb-2' onClick={AddNewUser}>
                Add (<i className="bi bi-plus"></i>) User
            </button>
        </div>
        <table className="table table-dark table-striped-columns table-bordered text-right">
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Domain</th>
                    <th>Age</th>
                    <th>Experience</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    users.map((user, index) => (
                        <tr key={user.id}>
                            <td>{index}</td>
                            <td>{user.id}</td>
                            <td className="text-uppercase">{user.name}</td>
                            <td>{user.email}</td>
                            <td>{user.domain}</td>
                            <td>{user.age}</td>
                            <td className="text-right">{user.experience}</td>
                            <td>{user.salary}</td>
                            <td>
                                <button className='btn btn-info'
                                data-toggle="tooltip" data-placement="top" title="Update" 
                                onClick={() => editUser(user.id)}>
                                    <i className="bi bi-pen"></i>
                                </button>
                                <span style={{marginLeft: '5px', marginRight: '5px'}}>|</span>
                                <button className='btn btn-danger'
                                data-toggle="tooltip" data-placement="top" title="Delete" 
                                onClick={() => removeUser(user)}>
                                    <i className="bi bi-trash"></i>
                                </button>
                            </td>
                        </tr>
                    )) 
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListUserComponent

