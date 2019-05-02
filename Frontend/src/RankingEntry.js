import React, { Component } from 'react';
import './App.css';

export default class RankingEntry extends Component {

    //TODO: GREY YOUR RANK
    render() {

        if (this.props.type === "general") {
            return (
                <table className='RankingEntry'>
                    <tr>
                        <td className='columnRanking1'>
                            <img src={require('./assets/icon.png')} alt='Icon.' />
                        </td>
                        <td className='columnRanking2'>
                            <p>NAME</p>
                        </td>
                        <td className='columnRanking3'>
                            <p>SCORE</p>
                        </td>
                    </tr>
                </table>
            )
        } else {
            //TODO
            return (
                <table className='RankingEntryPersonal'>
                    <tr>
                        <td className='columnRanking1'>
                            <img src={require('./assets/icon.png')} alt='Icon.' />
                        </td>
                        <td className='columnRanking2'>
                            <p>MY NAME</p>
                        </td>
                        <td className='columnRanking3'>
                            <p>SCORE</p>
                        </td>
                    </tr>
                </table>
            )
        }

    }

}