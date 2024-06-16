import React from 'react';
import './Home.css';

const Home = () => {
  return (
    <div className="hero-section">
      <div className="container-fluid">
        <div className="row justify-content-center">
          <div className="col-md-8 col-lg-6">
            <h2 className="hero-heading">Create. Take. Share.</h2>
            <p className="hero-paragraph">
              Join our platform to create quizzes, take quizzes, and share them with your friends. Whether you're a student, teacher, or quiz enthusiast, there's something for everyone!
            </p>
            <button className="btn btn-get-started">Get Started</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
