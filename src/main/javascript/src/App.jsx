import './App.css'
import Header from './component/header/Header'
import Presentation from './component/pages/acceuil/presentation';
import Footer from './component/footer/Footer';

import {createBrowserRouter, Link, RouterProvider} from 'react-router-dom'

const route = createBrowserRouter([
  {
    path: "/accueil",
    element: <Presentation />
  },
  {
    path:"/register",
    element: <Link to="/accueil">Accueil</Link>
  }
])

function App() {
  return (
    <>
      <Header />
         <RouterProvider router={route} />
      <Footer />
    </>
  )
}

export default App
