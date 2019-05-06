import React, { Component } from 'react';
import './App.css';

export default class Header extends Component {

    render() {
        return (
            <div className='Header'>
                <img src={require('./assets/logo.png')} alt='supQR.' className='Logo' />
            </div >
        )
    }

}