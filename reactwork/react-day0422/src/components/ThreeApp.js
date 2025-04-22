import React, { use, useState } from 'react';
import photo1 from '../jquery_image/02.png'
import photo2 from '../jquery_image/03.png'
import photo3 from '../jquery_image/04.png'
import photo4 from '../jquery_image/05.png'

const ThreeApp = () => {
    // 기본 사진 정의
    const [photo, setPhoto] = useState(photo4);
    
    // 사진 확대/축소
    const [width, setWidth] = useState(150);
    
    // 사진 보이기/숨기기
    const [show, setShow] = useState(true);

    // 사진 테두리
    const [border, setBorder] = useState('solid');

    // 텍스트 입력 이벤트
    const [text, setText] = useState("텍스트 입력");

    return (
        <div>
            <h3> ThreeApp - 오늘의 복습 문제 </h3>
            <hr/>
            <div>
                <label>
                    <input type='checkbox' defaultChecked
                        onClick={(e)=>setShow(e.target.checked)}/> 사진 숨김
                    &nbsp;&nbsp;
                </label>

                {/* 사진 확대/축소 버튼 */}
                <button type='button' className='btnstyle' onClick={()=>{
                    if(width>50)
                        setWidth(width-20);
                }}> 점점 작게 </button>
                &nbsp;

                <button type='button' className='btnstyle'onClick={()=>{
                    if(width<300)
                        setWidth(width+20);
                }}> 점점 크게 </button>
            </div>
            <br/>

            {/* 텍스트 입력란 */}
            <input type='text' placeholder='텍스트 입력' value={text} 
                onChange={(e)=>setText(e.target.value)} style={{width:'400px', height:'40px'}}/> <br/><br/>
            
            
            <div style={{ display: 'flex', alignItems: 'center', gap: '30px' }}>
                <div class="dropbox">
                    {/* 사진 드롭다운 박스 */}
                    <select style={{width:'130px', height:'40px'}} onChange={(e) => setPhoto(e.target.value)}>
                    <option value={photo1}> 사진 1 </option>
                        <option value={photo2}> 사진 2 </option>
                        <option value={photo3}> 사진 3 </option>
                        <option value={photo4} selected> 사진 4 </option>
                    </select>
                    <br/>
                    {/* Border 드롭다운 박스 */}
                    <select style={{width:'130px', height:'40px', marginTop:'30px'}} onChange={(e) => setBorder(e.target.value)}>
                        <option value="solid"> Solid </option>
                        <option value="dashed"> Dashed </option>
                        <option value="groove"> Groove </option>
                    </select>
                </div>

                {/* 사진 출력 */}
                <div class="image">
                    {
                    !show&&
                    <img alt='' src={photo} style={{width:`${width}px`,border:`3px ${border} green`}}/>
                    }
                </div>
            </div>

            {/* 텍스트 출력란 */}
            <div style={{width:'400px', height:'50px', color:'royalblue',backgroundColor:'lightblue', textAlign:'center', lineHeight:'50px',fontSize:'20px'}}>
                {text}
            </div>

        </div>
    );
};

export default ThreeApp;