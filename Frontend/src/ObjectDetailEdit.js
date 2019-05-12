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

        var url = this.props.history.location.pathname.split("/")
        fetch("http://localhost:80/api/object/" + url[2])
            .then(response => response.json())
            .then(object => this.setState({ object }))

    }

    handleSave = (event) => {

        //TODO: RICHTIGE URL
        fetch('http://localhost:80/api/object', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            },
            body: JSON.stringify(this.state.object),
        })
        event.preventDefault()

    }

    handleChangeTitle = (event) => {

        var object = this.state.object
        object.title = event.target.value
        this.setState({ object })

    }

    addContent = () => {

        var entry = {
            "type": "TODO",
            "value": ""
        }
        var object = this.state.object
        object.content.push(entry)
        this.setState({ object })

    }

    update = (updatedId, updatedObject) => {

        var object = this.state.object
        object.content[updatedId] = updatedObject
        this.setState({ object })

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

                                <button onClick={this.handleSave}>Save changes</button>

                                <form className='AddObject'>
                                    <p className='Title'>TITLE</p>
                                    <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} className='Input' />
                                </form>

                                {this.state.object.content.map((item, index) =>

                                    <ContentEdit id={index} content={item} update={this.update.bind(this)} />

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