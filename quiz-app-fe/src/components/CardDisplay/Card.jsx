import React from 'react';
import image from '../../assets/pexels-keira-burton-6146978.jpg';

const Card = ({ quiz }) => {
  return (
    <div className="card me-3 mb-3" style={{ width: '18rem' }}>
      <img src={image} className="card-img-top" alt={quiz.quizTitle} />
      <div className="card-body">
        <h5 className="card-title">{quiz.quizTitle}</h5>
        <p className="card-text">{quiz.quizDescription}</p>
        <p className="card-text"><small className="text-muted">Difficulty: {quiz.difficulty}</small></p>
        <button type="button" className='btn btn-primary'>
          Start Quiz
        </button>
      </div>
    </div>
  );
};

export default Card;
