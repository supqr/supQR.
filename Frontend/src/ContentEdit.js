import React, { Component } from 'react';
import './App.css';
import { Table } from 'react-bootstrap';

export default class ContentEdit extends Component {

    constructor() {
        super()
        this.state = {
            object: {}
        }
    }

    componentWillMount() {

        var object = this.props.content
        object.title = this.props.content
        this.setState({ object })

    }

    handleChangeTitle = (event) => {

        var object = this.state.object
        object.title = event.target.value
        this.setState({ object })

    }

    handleChangeValue = (event) => {

        var object = this.state.object
        object.value = event.target.value
        this.setState({ object })

    }

    render() {

        if (this.props.content.type === 'IMAGE') {

            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img src={"http://localhost:80/api/object/media/" + this.state.object.value} alt='pic.' className='add' />
                            </td>
                        </tr>
                    </tbody>
                </Table>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <p>TODO</p>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type='text' value={this.state.object.value} onChange={this.handleChangeValue} />
                            </td>
                        </tr>
                    </tbody>
                </Table>
            )

        } else {

            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value={this.state.object.title} onChange={this.handleChangeTitle} />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img src={require('./assets/image.png')} alt='pic.' />
                                <img src={require('./assets/video.png')} alt='video.' />
                                <img src={require('./assets/text.png')} alt='text.' />
                            </td>
                        </tr>
                    </tbody>
                </Table>
            )

        }

    }

}