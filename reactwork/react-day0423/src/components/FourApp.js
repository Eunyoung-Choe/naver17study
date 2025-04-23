import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

const FourApp = () => {
    const [count, setCount] = useState(1); // 변경될 때마다 렌더링
    const numberRef = useRef(1); // 변경 되어도 렌더링이 발생 X
    /*
        textarea처럼 한 번에 많은 글자를 입력해야 하는 경우,
        한 글자처럼 입력 시마다 렌더링 될 경우 문제가 발생하기도 함.
        그럴 경우, ref 변수에 저장 후 나중에 한 번에 출력하면 됨.
    */

    const countIncreEvent=()=>{
        setCount(count+1);
        console.log("count 변수값 증가"+count);
    }

    const numberIncreEvent=()=>{
        numberRef.current = numberRef.current + 1;
        console.log("numberRef 증가"+numberRef.current);
    }

    return (
        <div>
            <Alert severity='success'> FourApp - state변수와 ref 변수의 차이점 </Alert>

            <Button variant='contained' color='secondary'
                onClick={countIncreEvent}> count 변수 증가 </Button>
            <b style={{fontSize:'3em', marginLeft:'20px'}}> {count} </b>
            <br/><br/>
            
            <Button variant='contained' color='info'
                onClick={numberIncreEvent}> numberRef 변수 증가 </Button>
            <b style={{fontSize:'3em', marginLeft:'20px'}}>{numberRef.current}</b> {/* numberRef는 이거만 쓰면 오류 */}
            <br/><br/>
        </div>
    );
};

export default FourApp;