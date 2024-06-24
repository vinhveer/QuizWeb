import React, { useRef } from 'react';
import { quizzesSet1, quizzesSet2 } from '../../assets/example';
import Card from '../Card/Card';
import './CardDisplayVertical.css';

const CardDisplayVertical = () => {
  const allQuizzes = [...quizzesSet1, ...quizzesSet2];
  const wrapperRef = useRef(null);

  const scrollLeft = () => {
    if (wrapperRef.current) {
      wrapperRef.current.scrollBy({ left: -400, behavior: 'smooth' }); // Adjust the value as needed
    }
  };

  const scrollRight = () => {
    if (wrapperRef.current) {
      wrapperRef.current.scrollBy({ left: 400, behavior: 'smooth' }); // Adjust the value as needed
    }
  };

  return (
    <div className="container-fluid ps-4 pe-4">
      <div className="wrapper-container">
        <button type="button" className="btn scroll-button scroll-left" onClick={scrollLeft}><i class="fa-solid fa-chevron-left"></i></button>
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h4>Start</h4>
          <button type="button" className="btn btn-primary ms-auto">See more</button>
        </div>
        <div className="wrapper" ref={wrapperRef}>
          {allQuizzes.map((quiz) => (
            <Card key={quiz.quizId} quiz={quiz} className="item" />
          ))}
        </div>
        <button type="button" className="btn btn-scroll scroll-button scroll-right" onClick={scrollRight}><i class="fa-solid fa-chevron-right"></i></button>
      </div>
    </div>
    
  );
};

export default CardDisplayVertical;
