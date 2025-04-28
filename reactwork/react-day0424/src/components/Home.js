import React from 'react';
import mainImg1 from "../food/12.jpg";

const Home = () => {
    return (
        <div>
            <h1 className='alert alert-danger'>
                Router Axios Study!!!!
            </h1>
            <img alt="" src={mainImg1}
            style={{width:'300px',border:'10px solid gold',
                margin:'30px'
            }}/>
        </div>
    );
};

export default Home;