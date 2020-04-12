
import { combineReducers } from 'redux';
import alert from './alert';
import auth from './auth';
import profile from './profile';
import post from './post';
import note from './note';

export default combineReducers({
  alert,
  auth,
  profile,
  note,
  post
});
