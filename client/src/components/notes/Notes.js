import React, {Fragment, useEffect} from 'react'
import Spinner from '../layout/Spinner'
import {useSelector, useDispatch} from 'react-redux'
import {getNotes} from '../../actions/note'
import NoteItem from './NoteItem'
import NoteForm from './NoteForm'

const Notes = () => {
  const note = useSelector(state => state.note);
  const dispatch = useDispatch();

  const {notes, loading} = note;
  useEffect(() => {
    dispatch(getNotes());
  }, [dispatch]);

  return loading ? <Spinner/> : <Fragment>
    <NoteForm/>
    <h1 className="large text-primary">Notes</h1>
    {/*<p className="lead"><i className="fas fa-user"/> Welcome to the community!</p>*/}
    <div className="posts">
      {notes.map(
          note => <NoteItem key={note.id} post={note} showActions={true}/>)}
    </div>
  </Fragment>
};

export default Notes;
