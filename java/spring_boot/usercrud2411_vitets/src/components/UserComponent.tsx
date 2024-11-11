import { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { updateUser, createUser, getUserById } from '../services/UserService'
import ExcelDropdown from './ExcelDropdown'

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

    const createOrUpdateUser = (e: { preventDefault: () => void }) => {
        e.preventDefault();

        if(validateForm()){

            console.log("id = " + id);

            if(id) {

                const user = {id: Number.parseInt(id), name, email, domain, age, experience, salary};
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

            const regexp = new RegExp(/^(([a-zA-Z0-9]+)|([a-zA-Z0-9]+((?:\\_[a-zA-Z0-9]+)|(?:\.[a-zA-Z0-9]+))*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-zA-Z]{2,6}(?:\.[a-zA-Z]{2})?)$)/);

            if(regexp.test(email)){

                errorsCopy.email = '';

            } else {

                errorsCopy.email = 'Invalid Email Format !!!';
                valid = false;

            }

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

        if(id){
            getUserById(Number.parseInt(id)).then((response) =>{
                setName(response.data.name);
                setEmail(response.data.email);
                setDomain(response.data.domain);
                setAge(response.data.age);
                setExperience(response.data.experience);
                setSalary(response.data.salary);
            })
        }
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
                                type='email'
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
                            <ExcelDropdown domain={domain}  setDomain={setDomain} />
                        </div>
                        <div className='form-group mb-2'>
                            <label>Age :  </label>
                            <input
                                type='number'
                                placeholder='Enter Age'
                                name='age'
                                value={age}
                                className='form-control'
                                onChange={(e) => setAge(Number.parseInt(e.target.value))}
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Experience :  </label>
                            <input
                                type='number'
                                placeholder='Enter Experience'
                                name='experience'
                                value={experience}
                                className='form-control'
                                onChange={(e) => setExperience(Number.parseInt(e.target.value))}
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Salary :  </label>
                            <input
                                type='number'
                                step="0.01"
                                placeholder='Enter Salary'
                                name='salary'
                                value={salary}
                                className='form-control'
                                onChange={(e) => setSalary(Number.parseFloat(e.target.value))}
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
