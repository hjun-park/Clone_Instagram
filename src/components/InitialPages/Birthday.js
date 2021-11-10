import React, { useReducer } from 'react';
import axios from 'axios';

function reducer(state, action) {
  return {
    ...state,
    [action.name]: action.value
  }
}

const Birthday = () => {
  let today = new Date();

  const [state, dispatch] = useReducer(reducer, {
    month: today.getMonth(),
    day: today.getDate(),
    year: today.getFullYear(),
  })

  const { month, day, year } = state;

  const onChange = (e) => {
    dispatch(e.target);
  }

  const onSubmit = async (e) => {
    e.preventDeafult();
    let birthdayData = {
      month: month,
      day: day,
      year: year,
    };
    await axios.post(
      'http://hjun-nathan.shop:9000/login/birthday',
      JSON.stringify(birthdayData),
      { headers: { 'Content-Type': `application/json` } }
    ).then((res) => console.log(res));
  };

  return (
    <div>
      <img src="" alt="" />
      <h2>생일 추가</h2>
      <select onChange={onChange} value={month+1}>
        <option value="1" >1월</option>
        <option value="2" >2월</option>
        <option value="3" >3월</option>
        <option value="4" >4월</option>
        <option value="5" >5월</option>
        <option value="6" >6월</option>
        <option value="7" >7월</option>
        <option value="8" >8월</option>
        <option value="9" >9월</option>
        <option value="10">10월</option>
        <option value="11">11월</option>
        <option value="12">12월</option>
      </select>
      <select onChange={onChange} value={day}>
        <option></option>
      </select>
      <select>
        <option></option>
      </select>
    </div>
  );
};

export default Birthday;
