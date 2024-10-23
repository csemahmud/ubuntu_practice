import React, { useEffect, useState } from 'react'
import { createUser, getUserById, updateUser } from '../services/UserService'
import { useNavigate, useParams } from 'react-router-dom'

const UserComponent = () => {

    const [name, setName] = useState('')
    const [email, setEmail] = useState('')
    const [domain, setDomain] = useState('')
    const [age, setAge] = useState(0)
    const [experience, setExperience] = useState(0)
    const [salary, setSalary] = useState(0)
    const [message, setMessage] = useState('')

    const [errors, setErrors] = useState({
        name: '',
        email: ''
    })

    

    const navigator = useNavigate();

    function createOrUpdateUser(e){
        e.preventDefault();

        if(validateForm()){

            if(id) {

                const user = {id, name, email, domain, age, experience, salary};
                console.log(user);

                updateUser(user).then((response) => {
                    console.log(response.data);
                    setMessage(response.data);
                }).catch(error => {
                    console.error(error)
                });

            } else {

                const user = {name, email, domain, age, experience, salary};
                console.log(user);

                createUser(user).then((response) => {
                    console.log(response.data);
                    setMessage(response.data);
                }).catch(error => {
                    console.error(error)
                });

            }

        }

        
    }

    function validateForm(){
        let valid = true;

        const errorsCopy = {...errors}

        if(name.trim()){

            errorsCopy.name = '';

        } else {

            errorsCopy.name = 'Name is required .';
            valid = false;

        }

        if(email.trim()){

            errorsCopy.email = '';

        } else {

            errorsCopy.email = 'Email is required .';
            valid = false;

        }

        setErrors(errorsCopy);

        return valid;
    }

    function viewUserList(){
        navigator('/users');
    }

    const {id} = useParams();

    function getOperation(){

        if(id) {
            return 'Update';
        } else {
            return 'Register';
        }

    }

    useEffect(() => {
        getUserById(id).then((response) =>{
            setName(response.data.name);
            setEmail(response.data.email);
            setDomain(response.data.domain);
            setAge(response.data.age);
            setExperience(response.data.experience);
            setSalary(response.data.salary);
        })
    }, [id]);

  return (
    <div className='container'>
        <h5>{message}</h5>
        <br/>
        <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>{getOperation()} User</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label>Name :  </label>
                            <input
                                type='text'
                                placeholder='Enter User Name'
                                name='name'
                                value={name}
                                className={`form-control ${ errors.name ? 'is-invalid' : '' }`}
                                onChange={(e) => setName(e.target.value)}
                            > 
                            </input>
                            { errors.name && <div className='invalid-feedback' >{ errors.name }</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label>Email :  </label>
                            <input
                                type='text'
                                placeholder='Enter Email'
                                name='email'
                                value={email}
                                className={`form-control ${ errors.email ? 'is-invalid' : '' }`}
                                onChange={(e) => setEmail(e.target.value)}
                            > 
                            </input>
                            { errors.email && <div className='invalid-feedback' >{ errors.email }</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label>Domain :  </label>
                            <input
                                type='text'
                                placeholder='Enter Domain'
                                name='domain'
                                value={domain}
                                className='form-control'
                                onChange={(e) => setDomain(e.target.value)}
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Age :  </label>
                            <input
                                type='text'
                                placeholder='Enter Age'
                                name='age'
                                value={age}
                                className='form-control'
                                onChange={(e) => setAge(e.target.value)}
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Experience :  </label>
                            <input
                                type='text'
                                placeholder='Enter Experience'
                                name='experience'
                                value={experience}
                                className='form-control'
                                onChange={(e) => setExperience(e.target.value)}
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Salary :  </label>
                            <input
                                type='text'
                                placeholder='Enter Salary'
                                name='salary'
                                value={salary}
                                className='form-control'
                                onChange={(e) => setSalary(e.target.value)}
                            >
                            </input> 

                            <div className='button__container'>
                            <button className='btn btn-primary' onClick={viewUserList}>View User List</button>
                            <span style={{marginLeft: '5px', marginRight: '5px'}}>|</span>
                            <button className='btn btn-success' onClick={createOrUpdateUser}>{getOperation()}</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default UserComponent
