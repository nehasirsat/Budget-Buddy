import logo from './logo.svg';
import './App.css';
import LoginUser from './Pages/Login';
import RegisterUser from './Pages/RegisterUser';
import ExpenseTracker from './Pages/Expenses';
import { Route,Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<LoginUser />} />
        <Route path="/Login" element={<LoginUser/>} />
        <Route path="/Register" element={<RegisterUser/>}/>
        <Route path="/Expenses" element={<ExpenseTracker/>}/>
      </Routes>
    </div>
  );
}

export default App;
