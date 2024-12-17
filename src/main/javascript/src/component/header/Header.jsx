import "./Header.css";
import Navbar from "./navbar/Navbar";
import logoTTM from "./../../asset/ttmAccueil.png"
import logoInitiative from "./../../asset/logoInitiative.png"

const Header = () => {
    return (
        <div className="Header">
            <div className="logo">
                <img className="logoInitiative" src={logoInitiative} alt="logo Initiative deux sevres" />
                <img className="logoApplication" src={logoTTM} alt="Logo Trouve ton Match" />
            </div>
            <Navbar className="navbar" />
        </div>
    );
};

export default Header;
