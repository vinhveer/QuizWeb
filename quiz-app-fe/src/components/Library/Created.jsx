import React, { useState } from 'react';
import CardDisplayHorizontal from '../CardDisplay/CardDisplayHorizontal';
import Category from '../Category/Category';

const Created = () => {
    const [sortTitle, setSortTitle] = useState('All');
    const [view, setView] = useState('created'); // State to toggle between views

    const handleSortSelect = (title) => {
        setSortTitle(title);
    };

    const handleViewChange = (view) => {
        setView(view);
    };

    return (
        <div>
            {view === 'created' ? (
                <div>
                    <div className="options d-flex justify-content-left align-items-center mb-3">
                        <button type="button" className="btn btn-primary me-2">
                            <i className="fa-solid fa-plus pe-2"></i>
                            Tạo bài quiz mới
                        </button>
                        <button 
                            type="button" 
                            className="btn btn-secondary" 
                            onClick={() => handleViewChange('category')} // Change view to 'category'
                        >
                            <i className="fa-solid fa-list pe-2"></i>
                            Thêm thể loại mới
                        </button>
                        <div className="dropdown ms-auto">
                            <button className="btn btn-outline-secondary d-flex align-items-center" type="button" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                                {sortTitle} <i className="ms-2 fa-solid fa-sort"></i>
                            </button>
                            <ul className="dropdown-menu" aria-labelledby="sortDropdown">
                                <li>
                                    <button className="dropdown-item" onClick={() => handleSortSelect('All')}>All</button>
                                </li>
                                <li>
                                    <button className="dropdown-item" onClick={() => handleSortSelect('Public')}>Public</button>
                                </li>
                                <li>
                                    <button className="dropdown-item" onClick={() => handleSortSelect('Private')}>Private</button>
                                </li>
                            </ul>
                        </div>
                        <form action="" className="search mx-3 w-25">
                            <input type="text" className="form-control" placeholder='Type here to search ... ' />
                        </form>
                    </div>
                    <div className="d-flex justify-content-between align-items-center mb-3 flex-wrap">
                        <CardDisplayHorizontal />
                    </div>
                </div>
            ) : (
                <div>
                    <button 
                        type="button" 
                        className="btn btn-secondary mb-3" 
                        onClick={() => handleViewChange('created')} // Change view back to 'created'
                    >
                        <i className="fa-solid fa-arrow-left pe-2"></i>
                        Quay lại
                    </button>
                    <Category />
                </div>
            )}
        </div>
    );
};

export default Created;
