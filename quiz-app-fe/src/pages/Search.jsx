import React from 'react'

const Search = () => {
  return (
    <div>
      <div className="container-fluid ps-5 pe-5">
        <h3 className='mb-2 mt-5'>Search for Quiz</h3>
        <div className="row">
          <div className="col-md-12">
            <div className="input-group mb-3">
              <input type="text" className="form-control" placeholder="Search" aria-label="Search" aria-describedby="button-addon2" />
              <button className="btn btn-outline-secondary" type="button" id="button-addon2">Search</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Search
