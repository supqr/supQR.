import React, { Component } from 'react';
import './App.css';

export default class ContentEdit extends Component {

    constructor() {
        super()
        this.state = {
            object: {}
        }
    }

    componentWillMount() {

        var object = this.props.content
        this.setState({ object })

    }

    handleChangeValue = (event) => {

        //TODO: ARRAY BEI BILD
        var object = this.state.object
        object.value = event.target.value
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    handleAddText = () => {

        var object = this.state.object
        object.type = "TEXT"
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    handleAddImage = () => {

        var object = this.state.object
        object.type = "IMAGE"
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    handleAddVideo = () => {

        var object = this.state.object
        object.type = "VIDEO"
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    handleDelete = () => {

        var object = this.state.object
        object.type = ""
        object.value = ""
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    render() {

        if (this.props.content.type === 'IMAGE') {

            return (
                <div>
                    <img src={"http://localhost:80/api/object/media/" + this.state.object.value} alt='pic.' className='add' />
                    <input type='file' value={this.state.object.value} onChange={this.handleChangeValue} />
                    <button onClick={this.handleDelete}>DELETE</button>
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <div>
                    <p>{this.state.object.value}</p>
                    <input type='file' value={this.state.object.value} onChange={this.handleChangeValue} />
                    <button onClick={this.handleDelete}>DELETE</button>
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <div>
                    <textarea value={this.state.object.value} onChange={this.handleChangeValue} style={{ width: '100%' }} />
                    <button onClick={this.handleDelete}>DELETE</button>
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'TODO') {

            return (
                <div>
                    <img onClick={this.handleAddImage} src={require('./assets/image.png')} alt='pic.' />
                    <img onClick={this.handleAddVideo} src={require('./assets/video.png')} alt='video.' />
                    <img onClick={this.handleAddText} src={require('./assets/text.png')} alt='text.' />
                    <button onClick={this.handleDelete}>DELETE</button>
                </div>
            )

        } else {

            return (
                <div />
            )

        }

    }

}