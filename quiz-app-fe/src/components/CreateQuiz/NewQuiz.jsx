import React, { useState, useContext } from 'react';
import { QuizContext } from '../../context/QuizContext';
import CreateQuestion from './CreateQuestion';

const NewQuiz = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [category, setCategory] = useState('');
  const [difficulty, setDifficulty] = useState('');
  const [questions, setQuestions] = useState([]);
  const [image, setImage] = useState(null);  // State to store the selected image file
  const [isLoading, setIsLoading] = useState(false);  // State to handle loading spinner
  const [isSuccess, setIsSuccess] = useState(false);  // State to handle success message
  const [quizId, setQuizId] = useState(null);  // State to store the created quiz ID
  const [showCreateQuestion, setShowCreateQuestion] = useState(false);  // State to toggle between components

  const { createQuiz, uploadImage } = useContext(QuizContext);  // Destructure uploadImage from QuizContext

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);  // Start loading spinner

    try {
      // Upload the image and get the URL
      let imageUrl = '';
      if (image) {
        imageUrl = await uploadImage(image);
      }

      const newQuiz = {
        title,
        description,
        category,
        difficulty,
        createdBy: localStorage.getItem('id'),
        questions,
        imageUrl,  // Include the image URL in the quiz object
        createAt: new Date().toISOString(),
        updateAt: new Date().toISOString(),
      };

      const createdQuiz = await createQuiz(newQuiz);
      setQuizId(createdQuiz.id);  // Save the created quiz ID
      setIsSuccess(true);  // Show success message
    } catch (error) {
      console.error('Error creating quiz:', error);
      alert('Failed to create quiz.');
    } finally {
      setIsLoading(false);  // Stop loading spinner
    }
  };

  const handleCreateQuestion = () => {
    setShowCreateQuestion(true);
  };

  if (showCreateQuestion && quizId) {
    return <CreateQuestion quizId={quizId} />;
  }

  return (
    <div>
      <div className="container-fluid ps-5 pe-5 pt-5">
        <h2>Create a new quiz</h2>
        <p>Fill in the form below to create a new quiz.</p>
        {!isSuccess ? (
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="quizTitle" className="form-label">Quiz title</label>
              <input
                type="text"
                className="form-control"
                id="quizTitle"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="quizDescription" className="form-label">Quiz description</label>
              <textarea
                className="form-control"
                id="quizDescription"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                required
              />
            </div>
            {/* <div className="mb-3">
              <label htmlFor="quizCategory" className="form-label">Quiz category</label>
              <input
                type="text"
                className="form-control"
                id="quizCategory"
                value={category}
                onChange={(e) => setCategory(e.target.value)}
                required
              />
            </div> */}
            <div className="mb-3">
              <label className="form-label pe-3">Quiz difficulty</label>
              <div className="btn-group" role="group" aria-label="Difficulty levels">
                <input
                  type="radio"
                  className="btn-check"
                  name="difficulty"
                  id="easy"
                  value="easy"
                  checked={difficulty === 'easy'}
                  onChange={(e) => setDifficulty(e.target.value)}
                  required
                />
                <label className="btn btn-outline-primary" htmlFor="easy">Easy</label>

                <input
                  type="radio"
                  className="btn-check"
                  name="difficulty"
                  id="medium"
                  value="medium"
                  checked={difficulty === 'medium'}
                  onChange={(e) => setDifficulty(e.target.value)}
                  required
                />
                <label className="btn btn-outline-primary" htmlFor="medium">Medium</label>

                <input
                  type="radio"
                  className="btn-check"
                  name="difficulty"
                  id="hard"
                  value="hard"
                  checked={difficulty === 'hard'}
                  onChange={(e) => setDifficulty(e.target.value)}
                  required
                />
                <label className="btn btn-outline-primary" htmlFor="hard">Hard</label>
              </div>
            </div>
            <div className="mb-3">
              <label htmlFor="quizImage" className="form-label">Quiz Image</label>
              <input
                type="file"
                className="form-control"
                id="quizImage"
                onChange={(e) => setImage(e.target.files[0])}
              />
            </div>
            <button type="submit" className="btn btn-primary" disabled={isLoading}>
              {isLoading ? 'Creating...' : 'Create quiz'}
            </button>
          </form>
        ) : (
          <div>
            <h3>Quiz created successfully!</h3>
            <p>Quiz ID: {quizId}</p> {/* Display the created quiz ID */}
            <button className="btn btn-primary" onClick={handleCreateQuestion}>Create Questions</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default NewQuiz;
