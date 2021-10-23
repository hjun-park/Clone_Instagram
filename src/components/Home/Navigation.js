import React from "react";

const Navigation = () => {
  return (
    <div>
      <h2>Instagram</h2>
      <div>
        <input type="text" placeholder="검색" value={search} />
      </div>
      <div>
        <span>Home</span>
        <span>DM</span>
        <span>Upload</span>
        <span>Like!</span>
        <span>Profile</span>
      </div>
    </div>
  );
};

export default Navigation;