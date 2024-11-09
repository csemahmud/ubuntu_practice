import { useEffect, useState } from "react";
import "./Home.style.css"
import { IUser } from './IUser.type';
import UserList from "./UserList";
import SaveUser from "./SaveUser";
import { PageEnum } from "./PageEnum.type";
import { createUser, deleteUser, getUserByEmail, listUsers } from "../service/UserService";

const Home = () => {

    const [userList, setUserList] = useState([] as IUser[]);
    const [shownPage, setShownPage] = useState(PageEnum.list);
    const [message, setMessage] = useState('');
    const [userToSave, setUserToSave] = useState(
        {name: "", email: "", domain: "", age: 0, salary: 0, experience: 0} as IUser);
    const [email, setEmail] = useState('');

    const onAddUserClickHnd = () => {
        setUserToSave({name: "", email: "", domain: "", age: 0, salary: 0, experience: 0} as IUser);
        console.log("Add");
        console.log(userToSave);
        setShownPage(PageEnum.add);
        setMessage("");
    }

    const showListPage = () => {
        setShownPage(PageEnum.list);

        console.log(userList);

        setUserList([]);

        console.log(userList);

        getAllUsers();

        console.log(userList);

        setMessage("");

        setEmail("");
    }

    useEffect(() => {
        
        getAllUsers();

    }, []);

    function getAllUsers(){

        listUsers().then((response) => {
            setUserList(response.data);
        }).catch(error => {
            console.error(error);
        })

    }

    const addUser = (user: IUser) => {

        createUser(user).then((response) => {
            console.log(response.data);
            setMessage(response.data);
        }).catch(error => {
            console.error(error)
        });
    } 

    const removeUser = (user: IUser) => {
        if(user.id){
            console.log(user);

            if(window.confirm("Are you sure, you want to DELETE the following user ?\n"
                + JSON.stringify(user, undefined, 4)
            )){

                deleteUser(user.id).then((response) => {
                    getAllUsers();
                    setMessage(response.data);
                    setEmail("");
                }).catch(error =>{
                    console.error(error);
                })

            }
        }
    }

    const editUserData = (user: IUser) => {
        setUserToSave(user);
        setShownPage(PageEnum.edit);
        console.log("Edit");
        console.log(userToSave);
        setMessage("");
    }

    function findUserByEmailId(){
        console.log(email);

        getUserByEmail(email).then((response) => {
            let responseUsers = [];
            responseUsers.push(response.data)
            console.log(responseUsers);
            console.log(response.data);
            setUserList(responseUsers);
            console.log(userList);
        }).catch(error => {
            console.error(error);
        })
        
    }

    return (
        <section className="container section-content">            
            <br/>
                <h5>{message}</h5>
            <br/>
            {shownPage === PageEnum.list && (
                <>
                    <div id="custom-search-input">
                        <div className="input-group col-md-12" style={{textAlign: 'center'}}>
                            <input type="email" className="search-query form-control" placeholder="Search With Email Address"
                            name="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)}/>
                            <span className="input-group-btn">
                                <input type="button" className="btn btn-primary"  value="Search" onClick = {findUserByEmailId} />
                            </span>
                        </div>
                    </div>
                    <article className="list-header">
                        <h2 className='text-center'>List Of Users</h2>
                    </article>
                    <div className='button__container'>
                        <button type="button" className='btn btn-success mb-2 add-user-btn' onClick={onAddUserClickHnd}>
                            Add (+) User
                        </button>
                    </div>

                    <UserList users = {userList} onDeleteClickHnd={removeUser} onEditClickHnd={editUserData}/>
                </>
            )}

            { shownPage === PageEnum.add && 
            <SaveUser onBackBtnClickHnd={showListPage} onSubmitClickHnd={addUser} user={userToSave} /> }

            { shownPage === PageEnum.edit && 
            <SaveUser onBackBtnClickHnd={showListPage} onSubmitClickHnd={addUser} user={userToSave} /> }
        </section>
    )
}

export default Home;