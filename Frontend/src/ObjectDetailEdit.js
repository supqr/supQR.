import React, { Component } from 'react';
import './App.css';
import Header from './Header';

export default class ObjectDetailEdit extends Component {

    constructor() {
        super()
        this.state = {
            newObject: ""
        }
    }

    render() {
        return (
            <div>

                <Header active='object' />

                <div className='Body'>

                    <form onSubmit={this.handleAddObject} className='EditField'>
                        <p className='Title'>TITLE</p>
                        <input type='text' value={this.state.newObject} onChange={this.handleChangeNewObject} className='Input' />
                        <p className='Title'>ICON</p>
                        <input type="file" className='Input' />
                        <input type='submit' value='SAVE' className='ButtonSave' />
                    </form>

                </div>

            </div >
        );
    }

}