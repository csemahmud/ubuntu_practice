import { IUser } from './IUser.type';
import "./UserList.style.css"

type Props = {
    users: IUser[];
    onDeleteClickHnd: (data: IUser) => void;
    onEditClickHnd: (data: IUser) => void;
};

const UserList = (props: Props) => {
    const { users, onDeleteClickHnd, onEditClickHnd } = props;

    return (
        <table className="table table-striped table-bordered text-right">
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
                {users.map((user, index) => (
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
                            <input type='button' className='btn btn-info' value="Update" onClick={() => onEditClickHnd(user)} />
                            <span style={{ marginLeft: '5px', marginRight: '5px' }}>|</span>
                            <input type='button' className='btn btn-danger' value="Delete" onClick={() => onDeleteClickHnd(user)} />
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default UserList;