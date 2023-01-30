import { useEffect, useState } from 'react';


const UserTable = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const getUsers = async () => {
      const response = await fetch(
        'http://localhost:9191/users'
        //'http://localhost:3100/users'
      );
      const users = await response.json();
      setUsers(users);
    };
    getUsers();
  }, []);

  return (
    <div style={{ margin: '2em' }}>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Domain</th>
            <th>Age</th>
            <th>Experience</th>
            <th>Salary</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, index) => (
            <tr key={user.lastName}>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.domain}</td>
              <td>{user.age}</td>
              <td>{user.experience}</td>
              <td>{user.salary}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserTable;