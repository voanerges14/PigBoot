import React, {Fragment} from 'react'
import PropTypes from 'prop-types'
import {Link} from 'react-router-dom'
import Moment from 'react-moment'
import {useSelector, useDispatch} from 'react-redux'
import {deleteNote} from '../../actions/note'

const NoteItem = ({
  post: {id, text, createDate, updateDate},
  showActions
}) => {
  // const auth = useSelector(state => state.auth);
  const dispatch = useDispatch();

  return (
      <div className="post bg-white p-1 my-1">
        <div>
          {/*<Link to={`/profile/${user}`}>*/}
          {/*  <img className="round-img" src={avatar} alt="avatar"/>*/}
          {/*  <h4>{name}</h4>*/}
          {/*</Link>*/}
        </div>
        <div>
          <p className="my-1">{text}</p>
          <p className="post-date">Added <Moment format='YYYY/MM/DD'>{createDate}</Moment></p>
          <p className="post-date">id : {id}</p>
          {showActions &&
          <Fragment>
            {/*<button onClick={() => dispatch(updateLikes('like', id))}*/}
            {/*        type="button" className="btn btn-light">*/}
            {/*  <i className="fas fa-thumbs-up"/>{' '}*/}
            {/*  /!*{likes.length > 0 && (<span>{likes.length}</span>)}*!/*/}
            {/*</button>*/}
            {/*<button onClick={() => dispatch(updateLikes('unlike', id))}*/}
            {/*        type="button" className="btn btn-light">*/}
            {/*  <i className="fas fa-thumbs-down"/>*/}
            {/*</button>*/}
            {/*<Link to={`/posts/${_id}`} className="btn btn-primary">*/}
            {/*  Discussion {comments.length > 0 && (*/}
            {/*    <span className='comment-count'>{comments.length}</span>)}*/}
            {/*</Link>*/}
            {(
                <button onClick={() => dispatch(deleteNote(id))} type="button" className="btn btn-danger">
                  <i className="fas fa-times"/>
                </button>

            )}
          </Fragment>
          }
        </div>
      </div>
  )
};

NoteItem.propTypes = {
  post: PropTypes.object.isRequired,
  showActions: PropTypes.bool.isRequired,
};

export default NoteItem;
