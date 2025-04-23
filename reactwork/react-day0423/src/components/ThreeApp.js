import React, { useState } from 'react';
import "./mystyle.css"
import { Alert } from '@mui/material';
/*
[문제]
1. mycarArray를 해당 자동차 이미지가 나오도록 출력 (class는 mycar 적용)
2. input에 숫자 1~15 입력 후 엔터 누르면 해당 자동차 번호가 배열에 추가되고 이미지 형태로 출력되도록 함.
    (단, 1~15가 아닐 경우, "해당 자동차는 존재하지 않습니다." 출력)
3. 해당 자동차를 더블 클릭하면 "해당 자동차를 삭제할까요?" 물어본 후 확인 클릭하면 배열에서 삭제하기. (filter 이용)
*/

const ThreeApp = () => {
    const [mycarArray, setMycarArray] = useState([1,5,10]);

    // input 엔터 시 사진 추가
    const addCarEvent=(e)=>{
        if(e.key==='Enter'){
            const val = parseInt(e.target.value);
            if (isNaN(val) || val < 1 || val > 15) 
                alert("해당 음식은 존재하지 않습니다.");
            else {
                setMycarArray(mycarArray.concat(e.target.value));
                e.target.value="";
            }

        }
    }

    return (
        <div>
            <Alert severity='success'> ThreeApp 연습 문제 </Alert>
            <br/>
            <h6> 음식 1~15 입력 </h6>
            <input type='text' className='form-control' placeholder='input-message' autoFocus onKeyUp={addCarEvent}/>
            <br/>
            {
                mycarArray.map((c,i)=>
                    <img
                        key={i}
                        src={require(`../food/${c}.jpg`)}
                        alt={`food${c}`}
                        className='mycar'
                        onClick={() => {
                            if (window.confirm("해당 음식을 삭제할까요?")) { // 확인창
                              setMycarArray(mycarArray.filter((food) => food !== c));
                            }
                        }}
                    />
                )
            }
        </div>
    );
};

export default ThreeApp;