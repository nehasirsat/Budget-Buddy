import React, { useState } from 'react';
import axios from 'axios';

const LoginUser = () => {
    // State for form fields
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    
    // State for validation messages
    const [errors, setErrors] = useState({});

    // Handle form field changes
    const handleUsernameChange = (e) => {
        setUsername(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();

        let validationErrors = {};

        // Basic validation
        if (!username) {
            validationErrors.username = 'Username is required';
        }
        if (!password) {
            validationErrors.password = 'Password is required';
        }

        if (Object.keys(validationErrors).length > 0) {
            setErrors(validationErrors);
            return;
        }

        // Clear errors
        setErrors({});

        // Submit form data
        const loginData = {
            username: username,
            password: password,
        };

        axios.post('http://localhost:8080/login', loginData)
            .then((response) => {
                console.log('User logged in successfully:', response.data);
                // Handle successful login (e.g., redirect to dashboard)
            })
            .catch((error) => {
                console.error('There was an error logging in:', error);
                // Handle login error (e.g., display an error message)
            });
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="username">Username:</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={handleUsernameChange}
                    />
                    {errors.username && <p className="text-danger">{errors.username}</p>}
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                    {errors.password && <p className="text-danger">{errors.password}</p>}
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default LoginUser;
