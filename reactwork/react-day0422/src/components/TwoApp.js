import React, { useState } from 'react';
import photo1 from '../jquery_image/02.png'
import photo2 from '../jquery_image/03.png'
import photo3 from '../jquery_image/04.png'
import photo4 from '../jquery_image/05.png'

const TwoApp = () => {
    const [photo, setPhoto] = useState(photo3);
    const [borderWidth, setBorderWidth] = useState(2);
    const [borderColor, setBorderColor] = useState('tomato');

    const [show, setShow] = useState(true);

    // 색상 라디오 버튼
    const changeColor = (e)=>setBorderColor(e.target.value);
    
    return (
        <div>
            <h3> TwoApp - 복습, 간단한 데이터 입력 이벤트 </h3>
            {/* show&& = 조건부 렌더링을 위한 논리 연산자 (JSX에선 if문을 직접 사용할 수 없음.) */}
            {/* show가 true일 때만 <img> 요소가 렌더링 됨. */}
            {
            show&&
            <img alt='' src={photo} style={{width:'200px', border:`${borderWidth}px solid ${borderColor}`}}/>
            }
            <br/><br/>
            <b> 보이기 / 숨기기 </b> &nbsp;
            <label>
                <input type='checkbox' defaultChecked
                    onClick={(e)=>setShow(e.target.checked)}/>
            </label>
            <br/>

            <b> 사진 변경 : </b>
            <select style={{width:'150px'}} onChange={(e) => setPhoto(e.target.value)}>
                {/* option에선 onClick이 작동하지 않음. */}
                <option value={photo1}> 사진 1 </option>
                <option value={photo2}> 사진 2 </option>
                <option value={photo3} selected> 사진 3 </option>
                <option value={photo4}> 사진 4 </option>
            </select>
            <br></br>

            <b> 테두리 선 굵기 변경 </b>
            <input type='number' min='1' max='20'value={borderWidth} 
                onChange={(e)=>setBorderWidth(Number(e.target.value))}/>
            <br/>

            <b> 테두리선 색상 변경 </b>
            <label>
                <input type='radio' name='bcolor' defaultValue={'#66cdaa'}
                onChange={changeColor}/> 
                아쿠아마린
            </label> &nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'#ffc0cb'}
                onChange={changeColor}/> 
                연분홍
            </label> &nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'tomato'}
                onChange={changeColor}/> 
                토마토 
            </label> &nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'#9acd32'}
                onChange={changeColor}/> 
                옐로 그린 
            </label> &nbsp;
        </div>
    );
};

export default TwoApp;