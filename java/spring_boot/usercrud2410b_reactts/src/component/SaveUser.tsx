import "./SaveUser.style.css"
import { IUser } from "./IUser.type";
import { useEffect, useState } from "react";

type Props = {
    onBackBtnClickHnd: () => void;
    onSubmitClickHnd: (user: IUser) => void;
    user: IUser;
}

const SaveUser = (props: Props) => {

    const { onBackBtnClickHnd, onSubmitClickHnd, user } = props;

    const onSubmitBtnClickHnd = (e: any) => {

        e.preventDefault();
        if(user.id){
            onSubmitClickHnd(
                {id: user.id, name: name, email: email, domain: domain, age: age, salary: salary, experience: experience} as IUser);
        } else {
            onSubmitClickHnd(
                {name: name, email: email, domain: domain, age: age, salary: salary, experience: experience} as IUser);
        }
    }

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [domain, setDomain] = useState('');
    const [age, setAge] = useState(0);
    const [experience, setExperience] = useState(0);
    const [salary, setSalary] = useState(0);

    useEffect(() => {
        setName(user.name);
        setEmail(user.email);
        setDomain(user.domain);
        setAge(user.age);
        setExperience(user.experience);
        setSalary(user.salary);
    }, [user.age, user.domain, user.email, user.experience, user.id, user.name, user.salary]);

    function getOperation(){

        if(user.id) {
            return 'Update';
        } else {
            return 'Register';
        }

    }

    return (<div className='container form-container'>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <div>
                    <h2 className='text-center'>{getOperation()} User Form</h2>
                </div>
                <div className='card-body'>
                    <form onSubmit={onSubmitBtnClickHnd}>
                        <div className='form-group mb-2'>
                            <label>Name <span className="required">*</span> :  </label>
                            <input
                                type='text'
                                placeholder='Enter User Name'
                                name='name'
                                className={`form-control`}
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                required
                            > 
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label>Email <span className="required">*</span> :  </label>
                            <input
                                type='email'
                                placeholder='Enter Email'
                                name='email'
                                value={email}
                                className={`form-control`}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            > 
                            </input>
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
                            <input type="button"  className='btn btn-primary' 
                            value="View User List" onClick={onBackBtnClickHnd} />
                            <span style={{marginLeft: '5px', marginRight: '5px'}}>|</span>
                            <input type="submit"  className='btn btn-success' 
                            value={getOperation()}  />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  );
}

export default SaveUser;