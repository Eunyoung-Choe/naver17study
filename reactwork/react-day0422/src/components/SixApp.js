import React, { useEffect, useState } from 'react';
import img1 from '../photo/K-053.png'
import { Button } from '@mui/material';

const SixApp = () => {
    const [count, setCount] = useState(1);
    const [show, setShow] = useState(true);

    useEffect(()=>{
        count%3==0?setShow(false):setShow(true);
    },[count]); // count가 변경될 때만 호출

    return (
        <div>
            <h3> SixApp - useEffect </h3>
            <h5> count가 3의 배수일 때마다 사진 숨기기 </h5>

            <Button variant='outlined' color='success' onClick={()=>{
                setCount(count+1);
                // count%3==0?setShow(false):setShow(true); // 비동기 특성 상 순서대로 진행 X
            }}> count 증가 </Button>
            
            <br/>

            <b style={{fontSize:'4em', color:'violet'}}> {count} </b>
            <br/><br/>
            {
                show&&
                <img alt='' src={img1} style={{width:'300px'}}/>
            }
        </div>
    );
};

export default SixApp;