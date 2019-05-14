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

        var url = this.props.history.location.pathname.split("/")
        fetch("http://localhost:80/api/object/" + url[2])
            .then(response => response.json())
            .then(object => this.setState({ object }))

        fetch("http://localhost:80/api/object/" + url[2])
            .then(response => response.json())
            .then(compare => this.setState({ compare }))

    }

    handleSave = (event) => {

        //TODO: AM JOEL SIM WIXSERVICE S GANZE OBJECT UESCHICKE
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

        if (this.state.object.content !== undefined && this.state.compare.content !== undefined) {

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

                                    <ContentEdit content={item} key={index} />

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