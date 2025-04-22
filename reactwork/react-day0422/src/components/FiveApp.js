import { Switch } from '@mui/material';
import React, { useEffect, useState } from 'react';

const FiveApp = () => {
    // style을 이용해 이미지 보이기/숨기기
    const [visible, setVisible] = useState('visible');

    const [count, setCount] = useState(1);
    const [number, setNumber] = useState(100);

    // useEffect(()=>{
    //     console.log("처음에도 호출, state 변수가 변경될 때마다도 호출됨.")
    // });

    // useEffect(()=>{
    //     console.log("처음 로딩 시 딱 한 번만 호출됨.");
    // },[]);

    // useEffect(()=>{
    //     console.log("count가 변경될 때 처리할 코드를 넣어주세요.");
    // },[count]);

    // useEffect(()=>{
    //     console.log("number가 변경될 때 처리할 코드를 넣어주세요.");
    // },[number]);

    useEffect(()=>{
        console.log("count와 number가 변경될 때 처리할 코드")
    },[count, number]);
    
    return (
        <div>
            <h3 className='alert alert-success'> FiveApp - MUI Switch, require 이미지 가져오기 </h3>
            <br/>

            <Switch defaultChecked color='secondary'
                onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            <br/>

            <img src={require('../photo/K-043.png')} 
                style={{width:'200px', visibility:visible}}/>
            <hr/>


            <h1> count:{count} </h1>
            <h1> number:{number} </h1>

            <button onClick={()=>setCount(count+1)}> count 1증가 </button> <br/>
            <button onClick={()=>setNumber(number+10)}> number 10증가 </button> <br/>
            <button onClick={()=> {
                setCount(count+2);
                setNumber(number+5);
            }}> count, number 모두 증가 </button> <br/>
        </div>
    );
};

export default FiveApp;