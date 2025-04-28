import React from 'react';
import { NavLink } from 'react-router-dom';
import '../components/mystyle.css';

const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={"/"}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={"/one"}>OneApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/two"}>TwoApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/three"}>ThreeApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/four"}>FourApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/five"}>FiveApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/six"}>SixApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/seven"}>SevenApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/eight"}>EightApp</NavLink>
                </li>
            </ul>
        </div>
    );
};

export default Menu;