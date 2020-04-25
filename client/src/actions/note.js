import axios from 'axios';
import { setAlert } from './alert';
import {
  NOTE_ERROR,
  UPDATE_LIKES,
  GET_POST,
  ADD_COMMENT,
  DELETE_COMMENT,
  GET_NOTES,
  ADD_NOTE,
  DELETE_NOTE
} from './types';

// Get all notes
export const getNotes = () => async dispatch => {
  try {
    const res = await axios.get('/api/v1/notes');

    dispatch({
      type: GET_NOTES,
      payload: res.data
    })
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Get post by ID
export const getNote = postId => async dispatch => {

  try {
    const res = await axios.get(`/api/posts/${postId}`);

    dispatch({
      type: GET_POST,
      payload: res.data
    })
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Add note
export const addNote = formData => async dispatch => {
  const config = {
    headers: {
      'Content-Type': 'application/json'
    }
  };

  try {
    const res = await axios.post(`/api/v1/notes`, formData, config);

    dispatch({
      type: ADD_NOTE,
      payload: res.data
    });

    dispatch(setAlert('Note added', 'success'))
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'));
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Update likes
export const updateLikes = (actionType, postId) => async dispatch => {
  try {
    const res = await axios.put(`/api/posts/${actionType}/${postId}`);

    dispatch({
      type: UPDATE_LIKES,
      payload: { id: postId, likes: res.data }
    })
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Delete post
export const deleteNote = noteId => async dispatch => {
  try {
    await axios.delete(`/api/v1/notes/${noteId}`);

    dispatch({
      type: DELETE_NOTE,
      payload: { id: noteId }
    });

    dispatch(setAlert('Note deleted', 'success'))
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Add comment to post
export const addComment = (postId, formData) => async dispatch => {
  const config = {
    headers: {
      'Content-Type': 'application/json'
    }
  };
  try {
    const res = await axios.post(`/api/posts/comment/${postId}`, formData, config)

    dispatch({
      type: ADD_COMMENT,
      payload: res.data
    });

    dispatch(setAlert('Comment Added', 'success'))
  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};

// Remove comment to post
export const removeComment = (postId, commentId) => async dispatch => {
  try {
    await axios.delete(`/api/posts/comment/${postId}/${commentId}`)

    dispatch({
      type: DELETE_COMMENT,
      payload: { commentId }
    });
    dispatch(setAlert('Comment Removed', 'success'));

  } catch (error) {
    dispatch(setAlert(error.response.data.msg, 'danger'))
    dispatch({
      type: NOTE_ERROR,
      payload: {
        msg: error.response.statusText,
        status: error.response.status
      }
    })
  }
};
