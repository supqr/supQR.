import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import ContentView from './ContentView';
import { Container, Row, Col } from 'react-bootstrap';

export default class ObjectDetailView extends Component {

    constructor() {
        super()
        this.state = {
            object: [],
            open: false,
        };
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

    render() {

        if (this.state.object.content !== undefined) {

            return (
                < div >

                    <Header />

                    <Container>
                        <Row>
                            <Col></Col>
                            <Col className='Content'>

                                <div className='AddObject'>
                                    <img src={require('./assets/icon.png')} alt='objectIcon.' className='Icon' />
                                    <p className='objectName'>{this.state.object.title}</p>
                                </div>

                                {this.state.object.content.map((item) =>

                                    <ContentView content={item} />

                                )}

                            </Col>
                            <Col></Col>
                        </Row>
                    </Container>
                </div >

            );

        } else {
            return (
                <Header />
            )
        }
    }

}