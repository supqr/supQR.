import React from 'react';
import Object from './ObjectOverview';
import Ranking from './Ranking';
import { BrowserRouter as Router, Route } from 'react-router-dom';

function App() {

  //OPEN STARTPAGE
  return (
    <Router>
      <Route path={'/object'} component={Object} />
      <Route path={'/ranking'} component={Ranking} />
    </Router>
  );

}

export default App;
