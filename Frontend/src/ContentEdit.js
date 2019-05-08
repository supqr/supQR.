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
                <div>
                    <img src={"http://localhost:80/api/object/media/" + this.state.object.value} alt='pic.' className='add' />
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'VIDEO') {

            return (
                <div>
                    <input type='text' value={this.state.object.value} onChange={this.handleChangeValue} />
                    <hr />
                </div>
            )

        } else if (this.props.content.type === 'TEXT') {

            return (
                <div>
                    <input type='text' value={this.state.object.value} onChange={this.handleChangeValue} />
                    <hr />
                </div>
            )

        } else {

            return (
                <div>
                    <img src={require('./assets/image.png')} alt='pic.' />
                    <img src={require('./assets/video.png')} alt='video.' />
                    <img src={require('./assets/text.png')} alt='text.' />
                </div>
            )

        }

    }

}