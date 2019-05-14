import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import { Container, Row, Col } from 'react-bootstrap';

export default class Register extends Component {

    constructor() {
        super()
        this.state = {
            firstName: "",
            lastName: "",
            username: "",
            email: "",
            password: "",
            passwordRepeated: "",
            returned: ""
        }
    }

    handleRegister = (event) => {

        if (this.state.password === this.state.passwordRepeated) {
            var entry = {
                firstName: this.state.firstName,
                lastName: this.state.lastName,
                username: this.state.username,
                email: this.state.email,
                password: this.state.password
            }
            fetch('http://localhost:80/api/auth/register', {
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
        }
        event.preventDefault()

    }

    handleChangeFirstName = (event) => {

        var firstName = this.state.firstName
        firstName = event.target.value
        this.setState({ firstName })

    }

    handleChangeLastName = (event) => {

        var lastName = this.state.lastName
        lastName = event.target.value
        this.setState({ lastName })

    }

    handleChangeUsername = (event) => {

        var username = this.state.username
        username = event.target.value
        this.setState({ username })

    }

    handleChangeEmail = (event) => {

        var email = this.state.email
        email = event.target.value
        this.setState({ email })

    }

    handleChangePassword = (event) => {

        var password = this.state.password
        password = event.target.value
        this.setState({ password })

    }

    handleChangePasswordRepeated = (event) => {

        var passwordRepeated = this.state.passwordRepeated
        passwordRepeated = event.target.value
        this.setState({ passwordRepeated })

    }

    render() {
        return (
            <div>

                <Header />
                <Container>
                    <Row>
                        <Col className='Content' md={{ span: 4, offset: 4 }} xs={{ span: 8, offset: 2 }}>

                            <form onSubmit={this.handleRegister} className='Login'>
                                <h4 className='LoginTitle'>SCAN YOUR FUTURE.</h4>

                                <input type='text' placeholder='Firstname' value={this.state.firstName} onChange={this.handleChangeFirstName} className='LoginInput' />
                                <input type='text' placeholder='Lastname' value={this.state.lastName} onChange={this.handleChangeLastName} className='LoginInput' />
                                <input type='text' placeholder='Username' value={this.state.username} onChange={this.handleChangeUsername} className='LoginInput' />
                                <input type='email' placeholder='Email' value={this.state.email} onChange={this.handleChangeEmail} className='LoginInput' />
                                <input type='password' placeholder='Password' value={this.state.password} onChange={this.handleChangePassword} className='LoginInput' />
                                <input type='password' placeholder='Password repeated' value={this.state.passwordRepeated} onChange={this.handleChangePasswordRepeated} className='LoginInput' />
                                <input type='submit' value='REGISTER' className='LoginButton' />

                                <p className='LoginLink'>
                                    <a href='/'>You already have an account?<br />Login here</a>
                                </p>
                            </form>

                        </Col>
                    </Row>
                </Container>

            </div >
        )
    }
}