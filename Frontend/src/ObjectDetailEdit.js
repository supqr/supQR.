import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import ContentEdit from './ContentEdit';
import { Container, Row, Col } from 'react-bootstrap';

export default class ObjectDetailEdit extends Component {

    constructor() {
        super()
        this.state = {
            object: [],
            compare: []
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

        fetch("http://localhost:80/api/object/2")
            .then(response => response.json())
            .then(compare => this.setState({ compare }))

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
                    {JSON.stringify(this.state.object) !== JSON.stringify(this.state.compare) &&
                        <div style={{ backgroundColor: '#FFC6C8' }}>
                            <a href={this.handleSave}>You have unsaved changes. Klick here to save</a>
                        </div>
                    }

                    <Container>
                        <Row>
                            <Col></Col>
                            <Col className='Content'>

                                <form className='AddObject'>
                                    <p className='Title'>TITLE</p>
                                    <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} className='Input' />
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