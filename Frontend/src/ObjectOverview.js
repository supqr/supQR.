import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import Object from './Object';

export default class ObjectOverview extends Component {

    constructor() {
        super()
        this.state = {
            objectsLeft: [
                { id: '1', name: 'Coffee' },
                { id: '3', name: 'Table' },
                { id: '5', name: 'Tea' },
                { id: '7', name: 'Fridge' },
            ],
            objectsRight: [
                { id: '2', name: 'Fish' },
                { id: '4', name: 'Cake' },
                { id: '6', name: 'Mixer' },
            ],
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

        //TODO: UPLOAD WITH ID
        if (this.state.objectsRight < this.state.objectsLeft) {

            var objectsRight = this.state.objectsRight
            objectsRight.push({ id: '999', name: this.state.newObject })
            this.setState({ objectsRight })

        } else {

            var objectsLeft = this.state.objectsLeft
            objectsLeft.push({ id: '999', name: this.state.newObject })
            this.setState({ objectsLeft })

        }
        //TODO: UNLOAD STATE
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

                <Header active='object' />

                <div className='Body'>

                    <p className='Title'>NEW OBJECT</p>

                    <form onSubmit={this.handleAddObject}>
                        <input type='text' value={this.state.newObject} onChange={this.handleChangeNewObject} className='Input' />
                        <input type='submit' value='ADD' className='Button' />
                    </form>

                    <p className='Title'>FILTER</p>

                    <div className='Objects'>
                        <div className='leftObjects'>

                            {this.state.objectsLeft.map((item) =>

                                <Object name={item.name} id={item.id} />
                            )}

                        </div>
                        <div className='rightObjects'>

                            {this.state.objectsRight.map((item) =>

                                <Object name={item.name} id={item.id} />
                            )}

                        </div>
                    </div>

                </div>

            </div >
        )
    }

}