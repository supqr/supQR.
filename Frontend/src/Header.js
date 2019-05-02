import React, { Component } from 'react';
import './App.css';

export default class Header extends Component {

    render() {

        if (this.props.active === 'object') {
            return (
                <div className='Header'>
                    <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
                    <nav>
                        <a href="Home">HOME</a>
                        |
                        <a href="ObjectOverview" className="navActive">OBJECT</a>
                        |
                        <a href="Ranking">RANKING</a>
                    </nav>
                </div>
            )
        } else if (this.props.active === 'ranking') {
            return (
                <div className='Header'>
                    <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
                    <nav>
                        <a href="Home">HOME</a>
                        |
                        <a href="ObjectOverview">OBJECT</a>
                        |
                        <a href="Ranking" className="navActive">RANKING</a>
                    </nav>
                </div>
            )
        } else if (this.props.active === 'login') {
            return (
                <div className='Header'>
                    <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
                    <nav>
                        <a href="Login" className="navActive">LOGIN</a>
                        |
                        <a href="Register">REGISTER</a>
                    </nav>
                </div>
            )
        } else if (this.props.active === 'register') {
            return (
                <div className='Header'>
                    <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
                    <nav>
                        <a href="Login">LOGIN</a>
                        |
                        <a href="Register" className="navActive">REGISTER</a>
                    </nav>
                </div>
            )
        } else {
            return (
                <div className='Header'>
                    <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
                    <nav>
                        <a href="Home">HOME</a>
                        |
                        <a href="ObjectOverview">OBJECT</a>
                        |
                        <a href="Ranking">RANKING</a>
                    </nav>
                </div>
            )
        }

    }

}