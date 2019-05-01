import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import Object from './Object';

export default class ObjectOverview extends Component {

    constructor() {
        super()
        this.state = {
            objects: [],
            newObject: ""
        }
    }

    componentDidMount() {

        this.readObjects()

    }

    readObjects = async () => {

        console.log("TODO: READ OBJECTS")

    }

    handleAddObject = (event) => {

        console.log("TODO: ADD " + this.state.newObject)
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

                <div className='Body'>

                    <p className='Title'>NEW OBJECT</p>

                    <form onSubmit={this.handleAddObject}>
                        <input type='text' value={this.state.newObject} onChange={this.handleChangeNewObject} className='Input' />
                        <input type='submit' value='ADD' className='Button' />
                    </form>

                    <p className='Title'>FILTER</p>

                    <div className='Objects'>
                        <div className='leftObjects'>

                            <Object />
                            <Object />
                            <Object />

                        </div>
                        <div className='rightObjects'>

                            <Object />
                            <Object />

                        </div>
                    </div>

                </div>

            </div >
        )
    }

}