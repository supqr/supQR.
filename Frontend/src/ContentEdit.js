import React, { Component } from 'react';
import './App.css';
import { Table } from 'react-bootstrap';

export default class ContentEdit extends Component {

    render() {

        if (this.props.content.type === 'IMAGE') {

            return (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value='IMAGE' />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img src={this.props.content.value} alt='pic.' className='add' />
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
                                <input type='text' value='VIDEO' />
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
                                <input type='text' value='TEXT' />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type='text' value={this.props.content.value} />
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
                                <input type='text' value='TODO' />
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