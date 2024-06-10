import React, { useContext } from 'react';
import { QuizContext } from '../../context/QuizContext';
import QuizCardDisplay from '../QuizCardDisplay/QuizCardDisplay'; 

const MyQuiz = () => {
    const { quizzes } = useContext(QuizContext);

    return (
        <div className="container-fluid ps-5 pe-5">
            <QuizCardDisplay quizzes={quizzes} />
        </div>
    );
};

export default MyQuiz;
