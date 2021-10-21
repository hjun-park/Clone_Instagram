import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const onChange = (e) => {
    const {
      target: { name, value },
    } = e;

    if (name === 'email') {
      setEmail(value);
    } else if (name === 'password') {
      setPassword(value);
    }
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    let data = {
      email: email,
      password: password,
    };
    await axios
      .post('http://hjun-nathan.shop:9000/login', JSON.stringify(data), {
        headers: {
          'Content-Type': `application/json`,
        },
      })
      .then((res) => console.log(res));
  };

  return (
    <div>
      <div>
        <h1>Instagram</h1>
        <form onSubmit={onSubmit}>
          <input
            type="text"
            name="email"
            placeholder="전화번호, 사용자 이름 또는 이메일"
            value={email}
            onChange={onChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="비밀번호"
            value={password}
            onChange={onChange}
            required
          />
          <input type="submit" value="로그인" />
        </form>
        <span>----- 또는 -----</span>
        <span>Facebook으로 로그인</span>
        <span>비밀번호를 잊으셨나요?</span>
      </div>
      <div>
        <span>계정이 없으신가요?</span>
        <span>가입하기</span>
      </div>
    </div>
  );
};

export default Login;
