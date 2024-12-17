import './Footer.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebookF, faInstagram, faLinkedinIn, faTiktok } from '@fortawesome/free-brands-svg-icons';
import MiniLogoTTM from '../../asset/smallLogoTTM.png'

const Footer = () => {
    return(
        <div className="footer">
            <img className="mini-logo-TTM" src={MiniLogoTTM} alt="Petit logo TTM" />
            <div className="info-footer">
                <p>
                    Votre plateforme :<br />
                    Initiative Deux-Sèvres
                </p>
                <p>
                    <a href="tel:0679875609">06.79.87.56.09</a>
                    <br />
                    <a href="mailto:accompagnement@initiativedeuxsevres.fr">accompagnement@initiativedeuxsevres.fr</a>
                </p>
            </div>
            <div className="reseaux-sociaux-footer">
                <a href="https://www.instagram.com/initiative_deux_sevres" target="_blank"><FontAwesomeIcon icon={faInstagram} /></a>
                <a href="https://www.tiktok.com/@initiative.deux.s" target="_blank"><FontAwesomeIcon icon={faTiktok} /></a>
                <a href="https://www.facebook.com/profile.php?id=61556616180678" target="_blank"><FontAwesomeIcon icon={faFacebookF} /></a>
                <a href="https://www.linkedin.com/company/initiative-deux-sevres/?originalSubdomain=fr" target="_blank"><FontAwesomeIcon icon={faLinkedinIn} /> </a>
            </div>
        </div>
    )
}

export default Footer