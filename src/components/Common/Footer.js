import React from 'react';

const Footer = () => {
  return (
    <div>
      <footer>
        <div className="footer__top">
          <span>소개</span>
          <span>블로그</span>
          <span>채용정보</span>
          <span>도움말</span>
          <span>API</span>
          <span>개인정보처리방침</span>
          <span>약관</span>
          <span>인기계정</span>
          <span>해시태그</span>
          <span>위치</span>
          <span>Instagram Lite</span>
        </div>
        <div className="footer__mid">
          <span>뷰티</span>
          <span>댄스</span>
          <span>피트니스</span>
          <span>식음료</span>
          <span>집 및 정원</span>
          <span>음악</span>
          <span>시각예술</span>
        </div>
        <div className="footer__btm">
          <select>
            <option>한국어</option>
            <option>English</option>
          </select>
          <span>&copy; Instagram from Facebook</span>
        </div>
      </footer>
    </div>
  );
};

export default Footer;
