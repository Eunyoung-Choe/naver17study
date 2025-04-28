import React, { useMemo, useState } from 'react';

const getAverager=(numbers)=>{
    console.log("평균값 계산 중...");
    if(numbers.length==0) return 0;
    // 콜백 함수
    const sum = numbers.reduce((sum,n)=> sum+n) // 입력한 숫자가 n에 들어와 sum에 합산됨.
    const avg = sum/numbers.length;
    return avg;
}

const SixAverage = () => {
    const [list, setList] = useState([]);
    const [number, setNumber] = useState('');

    // 평균값 구하는 함수 최적화 시키기
    const avg = useMemo(()=>getAverager(list), [list]);

    return (
        <div>
            <h5> 숫자를 입력하면 입력한 숫자에 대한 평균 구하기 </h5>
            <input type='text' value={number} onChange={(e)=>setNumber(e.target.value)}/>

            <button onClick={()=>{
                setList(list.concat(Number(number)));
                setNumber('');
            }}> 등록 </button>
            <br/><br/>
            <ul>
            {
                list.map((num,idx)=>
                    <li key={idx}> {num} </li>)
            }
            </ul>
            <div style={{fontSize:'2em', margin:'10px'}}>
                평균: {getAverager(list)}
            </div>
        </div>
    );
};

export default SixAverage;