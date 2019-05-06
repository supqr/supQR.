import React, { Component } from 'react';
import './App.css';
import Header from './Header';
import RankingEntry from './RankingEntry';

export default class Ranking extends Component {

    constructor() {
        super()
        this.state = {}
    }

    componentWillMount() {
        //TODO: READ 
    }

    render() {
        return (
            <div>

                <Header active='ranking' />

                <div className='Body'>

                    <p className='Title'>PEOPLE</p>
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="personal" />
                    <button className='buttonMore'>MORE</button>

                    <p className='Title'>OBJECTS</p>
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <RankingEntry type="general" />
                    <button className='buttonMore'>MORE</button>

                </div>

            </div >
        )
    }

}