import React, {useState} from 'react'
import {useDispatch} from 'react-redux'
import {addNote} from '../../actions/note'

const NoteForm = () => {
  const [text, setText] = useState('');
  const dispatch = useDispatch();

  const sendNote = e => {
    e.preventDefault();
    dispatch(addNote(text));
    setText('');
  };

  return (
      <div className="post-form">
        <div className="bg-primary p">
          <h3>Add note...</h3>
        </div>
        <form className="form my-1" onSubmit={(e => sendNote(e))}>
        <textarea
            name="text"
            cols="30"
            rows="5"
            placeholder="Add note"
            value={text}
            onChange={e => setText(e.target.value)}
            required
        />
          <input type="submit" className="btn btn-dark my-1" value="Submit"/>
        </form>
      </div>
  )
};

export default NoteForm;
