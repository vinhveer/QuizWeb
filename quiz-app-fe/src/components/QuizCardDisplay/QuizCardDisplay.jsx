import React from 'react';
import QuizCard from '../QuizCard/QuizCard';

const QuizCardDisplay = ({ quizzes }) => {
    if (!quizzes || quizzes.length === 0) {
        return <p>No quizzes available</p>;
    }

    return (
        <div className="container-fluid">

            <div className="row">
                {quizzes.map(quiz => (
                    <div key={quiz.id} className="col-md-3 p-2">
                        <QuizCard 
                            id={quiz.id} 
                            image={quiz.image || 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuXL4AlfPJyTQKlspBiaNJk5hBpoOjMd19RQ&s'} 
                            title={quiz.title} 
                            // category={quiz.categoryId} 
                            // questionCount={quiz.questions.length} 
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default QuizCardDisplay;
