import React from 'react';

const QuizInfomation = () => {
  // Dummy data for the quiz details
  const quizInfo = {
    title: "Capital Cities",
    category: "Geography",
    questions: [
      "What is the capital of France?",
      "What is the capital of Spain?",
      "What is the capital of Italy?",
      "What is the capital of Germany?"
    ],
    plays: 5,
    description: "This quiz tests your knowledge of capital cities around the world."
  };

  return (
    <div className="container mt-5">
      <div className="card">
        <div className="card-body">
          <h3 className="card-title">{quizInfo.title}</h3>
          <h6 className="card-subtitle mb-2 text-muted">{quizInfo.category}</h6>
          <p className="card-text">Plays: {quizInfo.plays}</p>
          <p className="card-text">{quizInfo.description}</p>
          <h5 className="mt-4">Questions:</h5>
          <ul className="list-group">
            {quizInfo.questions.map((question, index) => (
              <li key={index} className="list-group-item">
                {question}
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default QuizInfomation;
