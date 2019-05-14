import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import Object from './Object';
import { Container, Row, Col } from 'react-bootstrap';

export default class ObjectOverview extends Component {

    constructor() {
        super()
        this.state = {
            objects: [],
            returned: {},
            newObject: ""
        }
    }

    componentWillMount() {

        this.readObjects()

    }

    readObjects = async () => {

        fetch("http://localhost:80/api/object/me", {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
        })
            .then(response => response.json())
            .then(objects => this.setState({ objects }))

    }

    handleAddObject = (event) => {

        fetch('http://localhost:80/api/object/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            },
            body: JSON.stringify({
                title: this.state.newObject
            })
        }).then(response => response.json())
            .then(returned => this.setState({ returned }))

        if (this.state.returned.title !== undefined) {
            this.state.objects.push(this.state.returned)
        }

        var newObject = this.state.newObject
        newObject = ""
        this.setState({ newObject })

        this.readObjects()
        event.preventDefault()

    }

    handleChangeNewObject = (event) => {

        var newObject = this.state.newObject
        newObject = event.target.value
        this.setState({ newObject })

    }

    render() {


        if (this.state.objects !== undefined) {
            return (
                <div>

                    <Header />
                    <Container>
                        <Row>
                            <Col></Col>
                            <Col xs={6} className='Content'>

                                <form onSubmit={this.handleAddObject} className='AddObject'>
                                    <p className='Title'>NEW OBJECT</p>
                                    <input type='text' value={this.state.newObject} onChange={this.handleChangeNewObject} className='Input' />
                                    <input type='submit' value='ADD' className='Button' />
                                </form>

                                {this.state.objects.map((item) =>

                                    <Object item={item} history={this.props.history} reload={this.readObjects.bind(this)} />

                                )}

                            </Col>
                            <Col></Col>
                        </Row>
                    </Container>

                </div >
            )

        } else {

            return (
                <Header />
            )

        }
    }

}