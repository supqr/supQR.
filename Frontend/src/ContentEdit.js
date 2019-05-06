import React, { Component } from 'react';
import './App.css';
import { Table } from 'react-bootstrap';

export default class ContentEdit extends Component {

    editObject = () => {
        console.log("TODO: DETAILANSICHT" + this.props.id)

    }

    deleteObject = () => {
        console.log("TODO: DELETE" + this.props.id)
    }

    render() {
        if (this.props.content.type === '') {

            return (
                <div>
                    <img src={require('./assets/add.png')} alt='add.' className='add' />
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>
                                    <input type='text' value={this.props.content.title} />
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
                </div>
            )

        } else if (this.props.content.type === 'image') {

            return (
                <div>
                    <img src={require('./assets/add.png')} alt='add.' className='add' />
                    <p>IMAGE</p>
                </div>
            )

        } else if (this.props.content.type === 'video') {

            return (
                <div>
                    <img src={require('./assets/add.png')} alt='add.' className='add' />
                    <p>VIDEO</p>
                </div>
            )

        } else {

            return (
                <div>
                    <img src={require('./assets/add.png')} alt='add.' className='add' />
                    <p>TEXT</p>
                </div>
            )

        }

        /*
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>
                                <input type='text' value={this.props.content.title} />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                Content
                                <img src={require('./assets/image.png')} alt='pic.' />
                                <img src={require('./assets/video.png')} alt='video.' />
                                <img src={require('./assets/text.png')} alt='text.' />
                            </td>
                        </tr>
                    </tbody>
                </Table>
        */
    }

}