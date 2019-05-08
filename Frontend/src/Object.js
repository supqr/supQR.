import React, { Component } from 'react';
import './App.css';

var QRCode = require('qrcode.react');

export default class Object extends Component {

    constructor() {
        super()
        this.state = {}
    }

    editObject = () => {
        //"TODO: DETAILANSICHT" + this.props.item.objectId
        this.props.history.push('/objectdetailedit')
    }

    deleteObject = () => {
        /*
        fetch('http://localhost:80/api/object/'+this.props.item.objectId, {
            method: 'DELETE'
        })
        */
    }

    render() {
        return (
            <div className='Object'>
                <QRCode value='todo' className='Icon' />
                {/*
                <img src={require('./assets/icon.png')} alt='objectIcon.' className='Icon' />
                */}
                <p className='objectName'>{this.props.item.title}</p>
                <button onClick={this.editObject} className='buttonEdit'>EDIT</button>
                <button onClick={this.deleteObject} className='buttonDelete'>DELETE</button>
            </div>
        );
    }

}