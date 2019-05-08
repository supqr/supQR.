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

        fetch("http://localhost:80/api/object/me")
            .then(response => response.json())
            .then(objects => this.setState({ objects }))

    }

    handleAddObject = (event) => {

        //TODO: UPLOAD
        fetch('http://localhost:80/api/object/add', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            },
            body: JSON.stringify(this.state.newObject),
        }).then(response => response.json())
            .then(returned => this.setState({ returned }))

        if (this.state.returned.title !== undefined) {
            this.state.objects.push(this.state.returned)
        }
        //TODO: UPLOAD
        event.preventDefault()

    }

    handleChangeNewObject = (event) => {

        var newObject = this.state.newObject
        newObject = event.target.value
        this.setState({ newObject })

    }

    render() {
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

                                <Object item={item} history={this.props.history} reload={this.readObjects} />

                            )}

                        </Col>
                        <Col></Col>
                    </Row>
                </Container>

            </div >
        )
    }

}