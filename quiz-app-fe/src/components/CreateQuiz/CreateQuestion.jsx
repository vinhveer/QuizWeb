import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CreateQuestion = ({ quizId }) => {
  const [quizTitle, setQuizTitle] = useState('');
  const [questionText, setQuestionText] = useState('');
  const [options, setOptions] = useState([
    { option: '', correct: false },
    { option: '', correct: false },
    { option: '', correct: false },
    { option: '', correct: false }
  ]);
  const [isLoading, setIsLoading] = useState(false);
  const [isSuccess, setIsSuccess] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchQuizInfo = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/quizzes/${quizId}`);
        setQuizTitle(response.data.title);
      } catch (error) {
        console.error('Error fetching quiz info:', error);
      }
    };

    fetchQuizInfo();
  }, [quizId]);

  const handleOptionChange = (index, value) => {
    const newOptions = [...options];
    newOptions[index].option = value;
    setOptions(newOptions);
  };

  const handleCorrectChange = (index, value) => {
    const newOptions = [...options];
    newOptions[index].correct = value;
    setOptions(newOptions);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);

    const newQuestion = {
      quizId,
      questionText,
      options,
      createAt: new Date().toISOString(),
      updateAt: new Date().toISOString(),
    };

    try {
      await axios.post('http://localhost:8080/api/questions', newQuestion);
      setIsSuccess(true);
    } catch (error) {
      setError('Failed to create question.');
      console.error('Error creating question:', error);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div>
      <div className="container-fluid ps-5 pe-5">
        <h3>Create a new Question for {quizTitle}</h3>
        <form onSubmit={handleSubmit}>
          <div className="row">
            <div className="col-md-12">
              <div className="form-group">
                <label>Question</label>
                <input
                  type="text"
                  className="form-control"
                  value={questionText}
                  onChange={(e) => setQuestionText(e.target.value)}
                  required
                />
              </div>
            </div>
            {options.map((option, index) => (
              <div className="col-md-6" key={index}>
                <div className="form-group">
                  <label>Option {index + 1}</label>
                  <input
                    type="text"
                    className="form-control"
                    value={option.option}
                    onChange={(e) => handleOptionChange(index, e.target.value)}
                    required
                  />
                  <div className="form-check">
                    <input
                      type="checkbox"
                      className="form-check-input"
                      checked={option.correct}
                      onChange={(e) => handleCorrectChange(index, e.target.checked)}
                    />
                    <label className="form-check-label">Correct</label>
                  </div>
                </div>
              </div>
            ))}
          </div>
          <button type="submit" className="btn btn-primary" disabled={isLoading}>
            {isLoading ? 'Creating...' : 'Create Question'}
          </button>
        </form>
        {isSuccess && <p className="text-success">Question created successfully!</p>}
        {error && <p className="text-danger">{error}</p>}
      </div>
    </div>
  );
};

export default CreateQuestion;
