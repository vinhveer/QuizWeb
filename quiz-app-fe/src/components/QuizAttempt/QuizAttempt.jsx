import React from 'react'

const QuizAttempt = () => {
  return (
    <div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-12">
            <h3>Which planet is known as the Red Planet?</h3>
          </div>
        </div>
        <div className="row mt-4">
            <div className="col-md-6">
                <div className="card">
                    <div className="card-body">
                        <h5>Earth</h5>
                    </div>
                </div>
            </div>
            <div className="col-md-6">
                <div className="card">
                    <div className="card-body">
                        <h5>Jupiter</h5>
                    </div>
                </div>
            </div>
            <div className="col-md-6">
                <div className="card">
                    <div className="card-body">
                        <h5>Mars</h5>
                    </div>
                </div>
            </div>
            <div className="col-md-6">
                <div className="card">
                    <div className="card-body">
                        <h5>Venus</h5>
                    </div>
                </div>
            </div>  
        </div>
      </div>
    </div>
  )
}

export default QuizAttempt
