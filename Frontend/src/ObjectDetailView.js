import React, { Component } from 'react';
import './App.css';
import Header from './Header';

export default class ObjectDetailView extends Component {

    constructor() {
        super()
        this.state = {
            newObject: ""
        }
    }

    render() {
        return (
            <div>

                <Header />

                <div className='Body'>

                </div>

            </div >
        );
    }

}