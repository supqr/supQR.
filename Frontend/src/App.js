import React from 'react';
import Login from './Login';
import Register from './Register';
import ObjectOverview from './ObjectOverview';
import ObjectDetailEdit from './ObjectDetailEdit';
import { BrowserRouter as Router, Route } from 'react-router-dom';

function App() {

  //OPEN STARTPAGE
  return (
    <Router>
      <Route exact path={'/'} component={Login} />
      <Route path={'/register'} component={Register} />
      <Route path={'/objectoverview'} component={ObjectOverview} />
      <Route path={'/objectdetailedit'} component={ObjectDetailEdit} />
    </Router>
  );

}

export default App;
