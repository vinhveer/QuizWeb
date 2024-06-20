import React from 'react';
import { quizzesSet1, quizzesSet2 } from '../../assets/example';
import Card from './Card';

const CardDisplay = () => {
  const allQuizzes = [...quizzesSet1, ...quizzesSet2];

  return (
    <div className="container ms-4 me-4">
      <h5>Các Quizz vừa tạo gần đây</h5>
      <div className="scrolling-wrapper mt-4 pb-4">
        <div className="row">
          {allQuizzes.map((quiz) => (
            <Card key={quiz.quizId} quiz={quiz} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default CardDisplay;
