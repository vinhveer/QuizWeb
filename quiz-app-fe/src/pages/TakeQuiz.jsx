import React from 'react'
import QuizAttempt from '../components/QuizAttempt/QuizAttempt'

const TakeQuiz = () => {
  return (
    <div>
        <div className="container-fluid">
            <div className="row">
                <div className="col-md-6">
                    Time: 10:00
                </div>
                <div className="col-md-6">
                <button className="btn btn-primary float-end">Next question</button>
                    <button className="btn btn-primary float-end">Submit</button>
                </div>
            </div>
        </div>
      <QuizAttempt />
    </div>
  )
}

export default TakeQuiz
