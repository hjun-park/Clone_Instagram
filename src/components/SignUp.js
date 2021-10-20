import React, { useState } from 'react';
import axios from 'axios';
import Footer from '../Common_Elements/Footer';

const SignUp = () => {
  const [email, setEmail] = useState('');
  const [userName, setUserName] = useState('');
  const [nickname, setNickname] = useState('');
  const [password, setPassword] = useState('');

  const onChange = (e) => {
    const {
      target: { name, value },
    } = e;

    if (name === 'email') {
      setEmail(value);
    } else if (name === 'userName') {
      setUserName(value);
    } else if (name === 'nickname') {
      setNickname(value);
    } else if (name === 'password') {
      setPassword(value);
    }
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    let data = {
      email: email,
      userName: userName,
      nickname: nickname,
      password: password,
    };
    axios.post('http://hjun-nathan.shop:9000/signup', JSON.stringify(data), {
      headers: {
        'Content-Type': `application/json`,
      },
    });
  };

  return (
    <div>
      <div>
        <h2>Instagram</h2>
        <span>친구들의 사진과 동영상을 보려면 가입하세요.</span>
        <div>Facebook으로 로그인</div>
        <span>----- 또는 -----</span>
        <form onSubmit={onSubmit}>
          <input
            type="text"
            name="email"
            placeholder="휴대폰 번호 또는 이메일 주소"
            value={email}
            onChange={onChange}
            required
          />
          <input
            type="text"
            name="userName"
            placeholder="성명"
            value={userName}
            onChange={onChange}
            required
          />
          <input
            type="text"
            name="nickname"
            placeholder="사용자 이름"
            value={nickname}
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
          <input type="submit" value="가입" />
        </form>
      </div>
      <div>
        <span>계정이 있으신가요?</span>
        <span>로그인</span>
      </div>
      <div>
        <span>앱을 다운로드 하세요.</span>
        <span>AppStore</span>
        <span>GooglePlay</span>
      </div>
      <Footer />
    </div>
  );
};

export default SignUp;
