import React from 'react'
import MyQuiz from '../components/MyQuiz/MyQuiz'

const Libary = () => {
  return (
    <div>
      <div className="container-fluid ps-5 pe-5 pt-3 pb-3">
        <div className="row">
          <div className="col-md-6">
            <ul class="nav nav-pills">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Quiz của tôi</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Quiz tôi đã tham gia</a>
              </li>
            </ul>
          </div>
          <div className="col-md-6">
            <a type="button" class="btn btn-primary float-end" href="/create-quiz">Tạo bài Quiz mới</a>
          </div>
        </div>
      </div>
      <MyQuiz />
    </div>
  )
}

export default Libary
