import React, { useState } from 'react';

const ExpenseTracker = () => {
    // State for form fields
    const [category, setCategory] = useState('');
    const [description, setDescription] = useState('');
    const [amount, setAmount] = useState('');

    // State for the list of expenses
    const [expenses, setExpenses] = useState([]);

    // Handle form field changes
    const handleCategoryChange = (e) => {
        setCategory(e.target.value);
    };

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value);
    };

    const handleAmountChange = (e) => {
        setAmount(e.target.value);
    };

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();

        // Basic validation
        if (!category || !description || !amount) {
            alert('All fields are required');
            return;
        }

        // Create new expense object
        const newExpense = {
            category: category,
            description: description,
            amount: parseFloat(amount),
        };

        // Add the new expense to the list of expenses
        setExpenses([...expenses, newExpense]);

        // Clear the form fields
        setCategory('');
        setDescription('');
        setAmount('');
    };

    return (
        <div>
            <h2>Add New Expense</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="category">Category:</label>
                    <input
                        type="text"
                        id="category"
                        value={category}
                        onChange={handleCategoryChange}
                    />
                </div>
                <div>
                    <label htmlFor="description">Description:</label>
                    <input
                        type="text"
                        id="description"
                        value={description}
                        onChange={handleDescriptionChange}
                    />
                </div>
                <div>
                    <label htmlFor="amount">Amount:</label>
                    <input
                        type="number"
                        id="amount"
                        value={amount}
                        onChange={handleAmountChange}
                    />
                </div>
                <button type="submit">Add Expense</button>
            </form>

            <h3>Expenses List</h3>
            <ul>
                {expenses.map((expense, index) => (
                    <li key={index}>
                        <strong>{expense.category}:</strong> {expense.description} - ${expense.amount.toFixed(2)}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ExpenseTracker;
