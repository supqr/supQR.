import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import ContentEdit from './ContentEdit';
import { Container, Row, Col } from 'react-bootstrap';

export default class ObjectDetailEdit extends Component {

    constructor() {
        super()
        this.state = {
            object: []
        }
    }

    componentWillMount() {

        this.readObject()

    }

    readObject = async () => {

        //TODO: ID VON ROUTER
        fetch("http://localhost:80/api/object/2")
            .then(response => response.json())
            .then(object => this.setState({ object }))

    }

    handleSave = (event) => {

        //TODO
        event.preventDefault()

    }

    handleChangeTitle = (event) => {

        var object = this.state.object
        object.title = event.target.value
        this.setState({ object })

    }

    addContent = () => {
        var entry = {
            "type": "",
            "value": ""
        }
        var object = this.state.object
        object.content.push(entry)
        this.setState({ entry })
    }

    render() {

        if (this.state.object.content !== undefined) {

            return (
                <div>

                    <Header />

                    <Container>
                        <Row>
                            <Col></Col>
                            <Col className='Content'>

                                <form onSubmit={this.handleSave} className='AddObject'>
                                    <p className='Title'>TITLE</p>
                                    <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} className='Input' />
                                    <input type='submit' value='SAVE' className='Button' />
                                </form>

                                {this.state.object.content.map((item) =>

                                    <ContentEdit content={item} />

                                )}
                                <img src={require('./assets/add.png')} alt='add.' className='add' onClick={this.addContent} />

                            </Col>
                            <Col></Col>
                        </Row>
                    </Container>

                </div>
            )

        } else {

            return (
                <Header />
            )

        }

    }

}