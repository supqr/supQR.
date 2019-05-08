import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import { Collapse, Button } from 'react-bootstrap'
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

        //TODO: ID VON ROUTER
        fetch("http://localhost:80/api/object/2")
            .then(response => response.json())
            .then(object => this.setState({ object }))

        //TODO: IF VIDEO, PIC, TEXT

    }

    render() {
        const { open } = this.state;
        console.log(this.state.object)
        console.log("slein")
        return (
            < div >

                <Header />

                <Container>
                    <Row>
                        <Col></Col>
                        <Col className='Content'>
                            <div className='AddObject'>
                                <img src={require('./assets/icon.png')} alt='objectIcon.' className='Icon' />
                                <p className='objectName'>Testname</p>
                            </div>
                            <p className='autor'>by: selinagahlinger</p>
                            <Button
                                onClick={() => this.setState({ open: !open })}
                                aria-controls="example-collapse-text"
                                aria-expanded={open}
                                className='contentButton'
                            >
                                <p className='contentHead'>INFONAME</p>
                            </Button>
                            <Collapse in={this.state.open}>
                                <div className='contentText'>
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus
                                    terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer
                                    labore wes anderson cred nesciunt sapiente ea proident.
          </div>
                            </Collapse>
                        </Col>
                        <Col></Col>
                    </Row>
                </Container>
            </div >

        );
    }

}