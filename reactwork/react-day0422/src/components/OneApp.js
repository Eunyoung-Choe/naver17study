import React, { useState } from 'react';
import './mystyle.css'
import photo1 from '../jquery_image/01.png'


const OneApp = () => {
    const [irum, setIrum] = useState('이해성');
    const [nai, setNai] = useState(20);

    const style1 = {
        color: "forestgreen",
        backgroundColor: '#fcfc00',
        width: '400px',
        border: '5px groove tomato',
        textAlign: 'center'
    }

    return (
        <div>
            <h3> OneApp - 복습, 간단한 데이터 입력 이벤트 </h3>
            <h5 style={style1}>
                스타일 적용 방법 [1.변수로 지정하는 방법] 
            </h5>
            <h5 style={{color:'red', fontFamily:'serif', border:'3px inset gold'}}>
                스타일 적용 방법 [2.직접 지정하는 방법] 
            </h5>
            <h5 className='myfont'>
                스타일 적용 방법 [3.css import]
            </h5>
            <img alt='' src={photo1} style={{width:'150px'}}/>


            <h6> 이름과 나이 입력하기 </h6>
            <h2 style={{backgroundColor:'thistle'}}>
                이름: {irum} <br/>
                나이: {nai}세 <br/>
            </h2>
            <input type='text' placeholder='irum 입력' value={irum} 
                onChange={(e)=>setIrum(e.target.value)}
            />
            <input type='text' placeholder='nai 입력'value={nai}
                onChange={(e)=>setNai(e.target.value)}
            />
        </div>
    );
};

export default OneApp;