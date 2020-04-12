import {
  ADD_NOTE,
  GET_NOTE,
  GET_NOTES,
  DELETE_NOTE,
  DELETE_ERROR,
  ADD_POST,
  POST_ERROR,
  UPDATE_LIKES,
  DELETE_POST,
  GET_POST,
  ADD_COMMENT,
  DELETE_COMMENT,
  CLEAR_ALL_POSTS,
} from '../actions/types'

const initialState = {
  notes: [],
  note: null,
  loading: true,
  error: {}
};

export default function (state = initialState, action) {
  const {type, payload} = action;
  switch (type) {
    case GET_NOTES:
      return {
        ...state,
        notes: payload,
        loading: false
      };

    case GET_NOTE:
      return {
        ...state,
        note: payload,
        loading: false
      }

    case ADD_POST:
      return {
        ...state,
        notes: [payload, ...state.notes],
        loading: false
      };

    case DELETE_NOTE:
      return {
        ...state,
        notes: state.notes.filter(note => note.id !== payload.id),
        loading: false
      };

    case UPDATE_LIKES:
      return {
        ...state,
        notes: state.notes.map(note => note._id === payload.id ? {
          ...note, likes: payload.likes
        } : note),
        loading: false
      }

    case ADD_COMMENT:
      return {
        ...state,
        note: {...state.note, comments: payload},
        loading: false
      }

    case DELETE_COMMENT:
      return {
        ...state,
        note: {
          ...state.note,
          comments: state.note.comments.filter(
              comment => comment._id !== payload.commentId
          )
        },
        loading: false
      }
    case POST_ERROR:
      return {
        ...state,
        loading: false,
        error: payload
      }

    case CLEAR_ALL_POSTS:
      return initialState;

    default:
      return state
  }
}
