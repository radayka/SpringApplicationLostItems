import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserList = () => {
    const [users, setUsers] = useState([]);
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [editingUser, setEditingUser] = useState(null);

    useEffect(() => {
        // Загружаем пользователей с API при монтировании компонента
        axios.get('http://localhost:8080/users')
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the users!", error);
            });
    }, []);

    const createUser = () => {
        const newUser = { name, email };

        // Отправляем запрос на создание нового пользователя
        axios.post('http://localhost:8080/user', newUser)
            .then(response => {
                setUsers([...users, newUser]);
                setName('');
                setEmail('');
            })
            .catch(error => {
                console.error("There was an error creating the user!", error);
            });
    };

    const updateUser = () => {
        const updatedUser = { ...editingUser, name, email };

        // Отправляем запрос на обновление пользователя
        axios.put(`http://localhost:8080/user/${editingUser.id}`, updatedUser)
            .then(response => {
                setUsers(users.map(user => user.id === editingUser.id ? updatedUser : user));
                setEditingUser(null);
                setName('');
                setEmail('');
            })
            .catch(error => {
                console.error("There was an error updating the user!", error);
            });
    };

    const handleEdit = (user) => {
        setEditingUser(user);
        setName(user.name);
        setEmail(user.email);
    };

    const handleDelete = (id) => {
        // Отправляем запрос на удаление пользователя
        axios.delete(`http://localhost:8080/user/${id}`)
            .then(response => {
                setUsers(users.filter(user => user.id !== id));
            })
            .catch(error => {
                console.error("There was an error deleting the user!", error);
            });
    };

    return (
        <div>
            <h2>User List</h2>

            <div>
                <input
                    type="text"
                    placeholder="Name"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
                <button onClick={editingUser ? updateUser : createUser}>
                    {editingUser ? "Update User" : "Create User"}
                </button>
            </div>

            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        {user.name} - {user.email}
                        <button onClick={() => handleEdit(user)}>Edit</button>
                        <button onClick={() => handleDelete(user.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;
