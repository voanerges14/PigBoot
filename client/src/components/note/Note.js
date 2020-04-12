import React, { Fragment, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { useSelector, useDispatch } from 'react-redux'
import Spinner from '../layout/Spinner'
import { getNote } from '../../actions/note'
import NoteItem from '../notes/NoteItem';
import CommentForm from './CommentForm'
import CommentItem from './CommentItem'

const Note = ({ match }) => {
  const stateNote = useSelector(state => state.note);
  const dispatch = useDispatch()
  const { note, loading } = stateNote;

  useEffect(() => {
    dispatch(getNote(match.params.id))
  }, [dispatch, match.params.id]);

  return loading || !note ? <Spinner />
    : <Fragment>
      <Link to="/posts" className="btn">Back To Posts</Link>
      <NoteItem note={note} showActions={false} />
      <CommentForm postId={note.id} />
      {/*<div className="comments">*/}
      {/*  {post.comments.map(comment => <CommentItem key={comment._id} comment={comment} postId={post._id} />)}*/}
      {/*</div>*/}
    </Fragment>
}


export default Note;
