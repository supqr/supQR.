import React, { Component } from 'react';
import './App.css';
import { Collapse, Button } from 'react-bootstrap';

export default class ConentView extends Component {

    constructor() {
        super()
        this.state = {
            open: false
        };
    }

    render() {

        if (this.props.content.type === 'IMAGE') {

            return (
                <div className='Content'>
                    <Button
                        onClick={() => {
                            var open = this.state.open
                            open = !open
                            this.setState({ open })
                        }}
                        aria-controls="example-collapse-text"
                        aria-expanded={this.state.open}
                        className='contentButton'
                    >
                        <p className='contentHead'>INFONAME</p>
                    </Button>
                    <Collapse in={this.state.open}>
                        <div className='contentText'>
                            <img src={"http://localhost:80/api/object/media/" + this.props.content.value} alt='pic.' className='add' />
                        </div>
                    </Collapse>
                </div>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <div className='Content'>
                    <Button
                        onClick={() => {
                            var open = this.state.open
                            open = !open
                            this.setState({ open })
                        }}
                        aria-controls="example-collapse-text"
                        aria-expanded={this.state.open}
                        className='contentButton'
                    >
                        <p className='contentHead'>INFONAME</p>
                    </Button>
                    <Collapse in={this.state.open}>
                        <div className='contentText'>
                            {this.props.content.value}
                        </div>
                    </Collapse>
                </div>
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <div className='Content'>
                    <Button
                        onClick={() => {
                            var open = this.state.open
                            open = !open
                            this.setState({ open })
                        }}
                        aria-controls="example-collapse-text"
                        aria-expanded={this.state.open}
                        className='contentButton'
                    >
                        <p className='contentHead'>INFONAME</p>
                    </Button>
                    <Collapse in={this.state.open}>
                        <div className='contentText'>
                            {this.props.content.value}
                        </div>
                    </Collapse>
                </div>
            )

        }

    }

}