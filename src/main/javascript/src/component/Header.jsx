import React, { useState } from 'react';
import './Header.css';

const Header = () => {
    const [isOpen, setIsOpen] = useState(false);

    const toggleMenu = () => {
        setIsOpen(!isOpen);
    }

    return (
        <div className="Header">
            <img className="TTM" src="/src/asset/1.png" alt="Logo Initiative Deux Sèvres page d'accueil" />
            <div className="menu-icon" onClick={toggleMenu}>
                ☰
            </div>
            <nav className={`topnav ${isOpen ? 'responsive' : ''}`} id="Topbar">
                <a href="#home" className="active">Home</a>
                <a href="#news">News</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>
            </nav>
        </div>
    );
}

export default Header;
