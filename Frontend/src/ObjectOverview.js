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
            newObject: "",
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

        //TODO: UPLOAD WITH ID
        if (this.state.objectsRight < this.state.objectsLeft) {

            var objectsRight = this.state.objectsRight
            objectsRight.push({ id: '999', name: this.state.newObject })
            this.setState({ objectsRight })

        } else {

            var objectsLeft = this.state.objectsLeft
            objectsLeft.push({ id: '999', name: this.state.newObject })
            this.setState({ objectsLeft })

        }
        //TODO: UNLOAD STATE
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

                                <Object item={item} />

                            )}

                        </Col>
                        <Col></Col>
                    </Row>
                </Container>

            </div >
        )
    }

}