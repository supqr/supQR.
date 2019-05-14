import React, { Component } from 'react';
import './App.css';

export default class ConentView extends Component {

    constructor() {
        super()
        this.state = {
            open: false
        };
    }

    render() {

        if (this.props.content.value === 'DELETED') {

            return (
                <div />
            )

        } else if (this.props.content.type === 'IMAGE') {

            return (
                <div>
                    <img src={"http://localhost:80/api/object/media/" + this.props.content.value} alt='pic.' className='add' />
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <div>
                    <p>{this.props.content.value}</p>
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <div>
                    <p>{this.props.content.value}</p>
                    <hr />
                </div>
            )

        }

    }

}