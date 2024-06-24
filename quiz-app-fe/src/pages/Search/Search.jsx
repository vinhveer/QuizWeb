import React from 'react'
import './Search.css'
import CardDisplayHorizontal from '../../components/CardDisplay/CardDisplayHorizontal'

const Search = () => {
  return (
    <div>
      <div className="container-fluid ps-4 pe-4">
        <div className="search-container">
          <i className="fas fa-search search-icon"></i>
          <input type="text" className="search-quiz-input" placeholder="Search" />
        </div>
      </div>
      <div className="container-fluid ps-4 pe-4">
        <CardDisplayHorizontal />
      </div>
    </div>
  )
}

export default Search
