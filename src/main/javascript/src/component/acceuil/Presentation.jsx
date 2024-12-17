import "./Presentation.css";
import MiniLogo from '../../asset/PetitTTM.png'

const Presentation = () => {
    return (
        <div className="body-accueil">
            <p className="text-presentation">
                Trouve ton match est une appli qui vous permettra de trouver la
                bonne personne pour vous accompagner et vous soutenir dans votre
                projet, une épaule sur laquelle vous reposer.
                <br />
                <br />
                <br />
                Le but est de créer un climat de confiance avec cette personne
                afin que vous puissiez vous tourner vers elle lorsque vous avez
                des soucis ou des besoins.
                <br />
                <br />
                <br />
                Ce parrain / marraine peut être un chef d’entreprise, ou d’un
                cadre dirigeant ayant de l’expérience et un réseau important
                pour faire appel à des partenaires experts dans vos besoin.
            </p>
            <img className="mini-logo-ttm" src={MiniLogo} alt="Mini logo Trouve ton match" />
            <a className="register-button" href="/register">Je crée mon compte</a>
        </div>
    );
};

export default Presentation;
