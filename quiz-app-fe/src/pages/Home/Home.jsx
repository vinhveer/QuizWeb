import React, { useContext } from 'react';
import './Home.css';
import { UserContext } from '../../contexts/UserContext';
import CardDisplay from '../../components/CardDisplay/CardDisplay';

const Home = () => {
  const { user } = useContext(UserContext);

  return (
    <div>
      {!user ? (
        <div>
          <div className="hero-section ms-4 me-4 mt-4 mb-4">
            <div className="container shadow-lg rounded">
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
        </div>
      ) : (
        <div>
          <div className="container mt-4 ms-4 me-4">
            <div className="scrolling-wrapper row flex-row flex-nowrap mt-4 pb-4">
              <div className="card me-3 mb-3 card-started new-quiz">
                <div className="card-body">
                  <h3 className="card-title">Create a new Quiz</h3>
                  <button type="button" className='btn float-end'>
                    <i class="fa-solid fa-arrow-right"></i>
                  </button>
                </div>
              </div>
              <div className="card me-3 mb-3 card-started live-quiz">
                <div className="card-body">
                  <h3 className="card-title">Join to Live Quiz</h3>
                  <button type="button" className='btn float-end'>
                    <i class="fa-solid fa-arrow-right"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
      <CardDisplay />
    </div>
  );
}

export default Home;
