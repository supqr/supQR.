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
        if (this.props.content.type === 'IMAGE') {
            console.log()
        }
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
        object.type = "TEXT"
        object.value = "DELETED"
        this.setState({ object })
        this.props.update(this.props.id, object)

    }

    render() {

        if (this.props.content.type === 'IMAGE') {

            return (
                <div className='Object' style={{ width: '100%', marginLeft: 0 }}>
                    <img src={"http://localhost:80/api/object/media/" + this.state.object.value} alt='pic.' className='add' /><br />
                    <input type='file' onChange={this.handleChangeValue} />
                    <button onClick={this.handleDelete} className='buttonDelete' style={{ width: '100%', color: '#FF7C9B' }}>DELETE</button>
                </div>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <div className='Object' style={{ width: '100%', marginLeft: 0 }}>
                    <p>{this.state.object.value}</p>
                    <input type='file' onChange={this.handleChangeValue} />
                    <button onClick={this.handleDelete} className='buttonDelete' style={{ width: '100%', color: '#FF7C9B' }}>DELETE</button>
                </div>
            )

        } else if (this.props.content.value === 'DELETED') {

            return (
                <div />
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <div className='Object' style={{ width: '100%', marginLeft: 0 }}>
                    <textarea value={this.state.object.value} onChange={this.handleChangeValue} style={{ width: '100%' }} />
                    <button onClick={this.handleDelete} className='buttonDelete' style={{ width: '100%', color: '#FF7C9B' }}>DELETE</button>
                </div>
            )

        } else if (this.props.content.type === 'TODO') {

            return (
                <div className='Object' style={{ border: '1px solid #FF7C9B', marginBottom: '7%', paddingLeft: 0, paddingTop: '3%', width: '100%', marginLeft: 0 }}>
                    <img onClick={this.handleAddImage} src={require('./assets/image.png')} alt='pic.' style={{ width: '15%' }} />
                    <img onClick={this.handleAddVideo} src={require('./assets/video.png')} alt='video.' style={{ width: '11%', marginLeft: '16.4%' }} />
                    <img onClick={this.handleAddText} src={require('./assets/text.png')} alt='text.' style={{ width: '8%', marginLeft: '16.4%' }} />
                    <button onClick={this.handleDelete} className='buttonDelete' style={{ width: '100%', color: '#FF7C9B' }}>DELETE</button>
                </div>
            )

        } else {

            return (
                <div />
            )

        }

    }

}