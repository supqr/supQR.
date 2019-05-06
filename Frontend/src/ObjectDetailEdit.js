import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import ContentEdit from './ContentEdit';

export default class ObjectDetailEdit extends Component {

    constructor() {
        super()
        this.state = {
            content: [
                { id: '1', title: 'Mix', type: 'image', text: '', source: 'todo' },
                { id: '2', title: 'Bake', type: 'video', text: '', source: 'todo' },
                { id: '3', title: 'Wait', type: 'text', text: 'Dies ist ein Text', source: '' },
                { id: '4', title: '', type: '', text: '', source: '' },
            ],
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

                    {this.state.content.map((item) =>

                        <ContentEdit content={item} />

                    )}

                    <img src={require('./assets/add.png')} alt='add.' className='add' />

                </div>

            </div >
        );
    }

}