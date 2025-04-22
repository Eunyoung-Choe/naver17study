import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';

const MainApp = () => {
    const [idx, setIdx] = useState(4);

    // radio 이벤트
    const selectApp=(e)=>{
        setIdx(Number(e.target.value));
        // alert(typeof(e.target.value));
    }

    return (
        <div>
            <h3 className='alert alert-danger'> 리액트 수업 2025-04-22 </h3>
            <label>
                <input type='radio' defaultValue={1} name='selectapp' onClick={selectApp}/> OneApp 
            </label>
            <label>
                <input type='radio' defaultValue={2} name='selectapp' onClick={selectApp}/> TwoApp 
            </label>
            <label>
                <input type='radio' defaultValue={3} name='selectapp' onClick={selectApp}/> ThreeApp 
            </label>
            <label>
                <input type='radio' defaultValue={4} name='selectapp' onClick={selectApp} defaultChecked/> FourApp 
            </label>
            <label>
                <input type='radio' defaultValue={5} name='selectapp' onClick={selectApp}/> FiveApp 
            </label>
            <label>
                <input type='radio' defaultValue={6} name='selectapp' onClick={selectApp}/> SixApp 
            </label>
            <label>
                <input type='radio' defaultValue={7} name='selectapp' onClick={selectApp}/> SevenApp 
            </label>

            <div style={{marginTop:'10px'}}>
                {idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:
                idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>:<SevenApp/>}
            </div>
        </div>
    );
};

export default MainApp;