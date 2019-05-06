import React, { Component } from 'react';
import './App.css';

export default class Object extends Component {

    editObject = () => {
        console.log("TODO: DETAILANSICHT" + this.props.item.objectId)

    }

    deleteObject = () => {
        console.log("TODO: DELETE" + this.props.item.objectId)
    }

    render() {
        return (
            <div className='Object'>
                <img src={require('./assets/icon.png')} alt='objectIcon.' className='Icon' />
                <p className='objectName'>{this.props.item.title}</p>
                <button onClick={this.editObject} className='buttonEdit'>EDIT</button>
                <button onClick={this.deleteObject} className='buttonDelete'>DELETE</button>
            </div>
        );
    }

}