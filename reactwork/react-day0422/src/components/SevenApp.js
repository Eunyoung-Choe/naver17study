import { Alert } from '@mui/material';
import React from 'react';

const SevenApp = () => {
    const names = ['카리나', '윈터', '닝닝', '지젤', '장원영'];
    // 방법 1
    const nameList = names.map((irum, idx)=> <h5 key={idx}> {idx}:{irum} </h5>);

    return (
        <div>
            <h3 className='alert alert-success'> SevenApp - 반복문 </h3>
            {nameList}

            {/* 배열 반복문을 직접 넣는 방법2 */}
            {
                names.map((irum, idx)=><Alert key={idx}
                severity='secondary'> 
                    {idx}:{irum}
                    <img alt='' src={require(`../photo/K-038.png`)} style={{width:'100px'}}/>
                </Alert>)
            }

            {/* 배열 변수 없이 1부터 10까지 반복하기 */}
            {
                [...new Array(10)].map((_, idx) => <b key={idx}>{idx + 1}&nbsp;</b>)

            }

            <h5> mycar 폴더에 mycar 이미지 넣고 1부터 15번까지 이미지 출력하기 </h5>
            {
                [...new Array(15)].map((_,idx)=> 
                    <img key={idx} 
                        src={require(`../mycar/mycar${idx+1}.png`)}
                        alt={`mycar${idx+1}`}
                        style={{width:'100px', margin:'5px'}}
                    />)
            }
        </div>
    );
};

export default SevenApp;