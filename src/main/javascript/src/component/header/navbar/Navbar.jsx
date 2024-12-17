import "./Navbar.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUsers, faComments, faBell, faWrench, faHandshake } from '@fortawesome/free-solid-svg-icons';
import { faUser } from '@fortawesome/free-regular-svg-icons'; // Ajout de l'icône de menu burger
import { faBars } from '@fortawesome/free-solid-svg-icons'; 
import { useState } from 'react';

const Navbar = () => {
    const [isOpen, setIsOpen] = useState(false);
    const [isOpenUser, setIsOpenUser] = useState(false)

    // menu deroulant des liens des pages
    const toggleMenu = () => {
        setIsOpen(!isOpen);
    };

    const toggleMenuUser = () => {
        setIsOpenUser(!isOpenUser)
    }

    // menu deroulant user



    return (
        <nav className="navbar">
            <div className={`links ${isOpen ? 'open' : ''}`}>
                <a href="/#"><FontAwesomeIcon icon={faUsers} /> Découvrir</a>
                <a href="/#"><FontAwesomeIcon icon={faComments} /> Messages</a>
                <a href="/#"><FontAwesomeIcon icon={faBell} /> Notification</a>
                <a href="/#"><FontAwesomeIcon icon={faWrench} /> Boîte à outils</a>
                <a href="/#"><FontAwesomeIcon icon={faHandshake} /> Mes matchs</a>
            </div>
            <button className="menu-icon" onClick={toggleMenu}>
                <FontAwesomeIcon icon={faBars} />
            </button>
            <button className="button-user" onClick={toggleMenuUser} ><FontAwesomeIcon icon={faUser} /></button>
        </nav>
    );
};

export default Navbar;
