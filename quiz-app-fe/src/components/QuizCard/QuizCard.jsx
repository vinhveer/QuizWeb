import React from 'react';
import PropTypes from 'prop-types';

const QuizCard = ({ id, image, title, category, questionCount }) => {
    return (
        <div className="card">
            <img src={image} className="card-img-top" alt={`${title} cover`} />
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                {/* <p className="card-text">Category: {category}</p>
                <p className="card-text">Questions: {questionCount}</p> */}
                <a href={`/quiz/${id}`} className="btn btn-primary">Take Quiz</a>
            </div>
        </div>
    );
}

QuizCard.propTypes = {
    id: PropTypes.string.isRequired,
    image: PropTypes.string,
    title: PropTypes.string.isRequired,
    category: PropTypes.string.isRequired,
    questionCount: PropTypes.number.isRequired
};

QuizCard.defaultProps = {
    image: 'default-image-path.jpg'
};

export default QuizCard;
