import { useState } from "react";
import { useNavigate } from "react-router-dom";
import logoLogin from "../../asset/login.png";
import "./Login.css";

const LoginPage = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleLogin = async () => {
        const response = await fetch("/api/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ username, password }),
        });

        const data = await response.text();
        if (data === "Login successful") {
            navigate("/accueil");
        } else {
            alert(data);
        }
    };

    return (
        <div className="body-login">
            <div className="login">
                <img className="logoLogin" src={logoLogin} alt="logo login" />
                <input
                    className="usernameInput"
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input
                    className="passwordInput"
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button className="submitLogin" onClick={handleLogin}>
                    Se connecter
                </button>
                <div className="links">
                    <a href="">Mot de passe oublié</a>
                    <a href="">S'enregistrer</a>
                </div>
            </div>
        </div>
    );
};

export default LoginPage;
