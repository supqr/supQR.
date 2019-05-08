import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import { Container, Row, Col } from 'react-bootstrap';

export default class Login extends Component {

    constructor() {
        super()
        this.state = {
            identification: "",
            password: "",
            returned: ""
        }
    }

    handleLogin = (event) => {

        var entry = {
            identification: this.state.identification,
            password: this.state.password
        }
        fetch('http://localhost:80/api/auth', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(entry),
        }).then(response => response.json())
            .then(returned => this.setState({ returned }))

        if (this.state.returned.token !== undefined) {
            localStorage.setItem('token', this.state.returned.token)
            this.props.history.push('/objectoverview')
        }
        event.preventDefault()

    }

    handleChangeIdentification = (event) => {

        var identification = this.state.identification
        identification = event.target.value
        this.setState({ identification })

    }

    handleChangePassword = (event) => {

        var password = this.state.password
        password = event.target.value
        this.setState({ password })

    }

    render() {
        return (
            <div>

                <Header />
                <Container>
                    <Row>
                        <Col></Col>
                        <Col className='Content'>

                            <form onSubmit={this.handleLogin} className='Login'>
                                <h4 className='LoginTitle'>SCAN YOUR FUTURE.</h4>

                                <input type='text' placeholder='Username' value={this.state.identification} onChange={this.handleChangeIdentification} className='LoginInput' />
                                <input type='password' placeholder='Password' value={this.state.password} onChange={this.handleChangePassword} className='LoginInput' />
                                <input type='submit' value='LOGIN' className='LoginButton' />

                                <p className='LoginLink'>
                                    <a href='register'>Don't have an account yet?<br />Register here</a>
                                </p>
                            </form>

                        </Col>
                        <Col></Col>
                    </Row>
                </Container>

            </div >
        )
    }

}