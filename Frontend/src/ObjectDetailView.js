import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import ContentView from './ContentView';
import { Container, Row, Col } from 'react-bootstrap';

var IP = '10.1.0.6:80';

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
        fetch("http://" + IP + "/api/object/" + url[2])
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
                            <Col className='Content' md={{ span: 4, offset: 4 }} xs={{ span: 8, offset: 2 }}>

                                <div className='AddObject'>
                                    <img src={require('./assets/icon.png')} alt='objectIcon.' className='Icon' />
                                    <p className='objectName'>{this.state.object.title}</p>
                                </div>

                                {this.state.object.content.map((item, index) =>

                                    <ContentView content={item} key={index} />

                                )}

                            </Col>
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