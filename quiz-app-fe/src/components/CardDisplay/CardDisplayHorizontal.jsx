import React from 'react';
import { quizzesSet1, quizzesSet2 } from '../../assets/example';
import Card from '../Card/Card';
import './CardDisplayHorizontal.css';

const CardDisplayHorizontal = () => {
    const allQuizzes = [...quizzesSet1, ...quizzesSet2];

    return (
        <div className="d-flex flex-wrap">
            {allQuizzes.map((quiz) => (
                <Card key={quiz.quizId} quiz={quiz} className="card-item" />
            ))}
        </div>
    );
};

export default CardDisplayHorizontal;
