import React from 'react';

const SmallFooter = () => {
  return (
    <div>
      <footer>
        <div className="s_footer__top">
          <span>소개</span>
          <span>도움말</span>
          <span>홍보 센터</span>
          <span>API</span>
          <span>채용정보</span>
          <span>개인정보처리방침</span>
        </div>
        <div className="s_footer__mid">
          <span>약관</span>
          <span>위치</span>
          <span>인기 계정</span>
          <span>해시태그</span>
          <span>언어</span>
        </div>
        <div className="s_footer__btm">
          <span>&copy; INSTAGRAM FROM FACEBOOK</span>
        </div>
      </footer>
    </div>
  );
};

export default SmallFooter;
