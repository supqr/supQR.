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
        this.props.history.push('/objectdetailedit/' + this.props.item.objectId)
    }

    deleteObject = () => {
        /*
        fetch('http://localhost:80/api/object/'+this.props.item.objectId, {
            method: 'DELETE'
        })
        */
    }

    navigate = () => {
        this.props.history.push('/objectdetailview/' + this.props.item.objectId)
    }

    render() {
        return (
            <div className='Object'>
                <QRCode onClick={this.navigate} value={'http://localhost:3000/objectdetailview/' + this.props.item.objectId} className='Icon' />
                <p className='objectName'>{this.props.item.title}</p>
                <button onClick={this.editObject} className='buttonEdit'>EDIT</button>
                <button onClick={this.deleteObject} className='buttonDelete'>DELETE</button>
            </div>
        );
    }

}