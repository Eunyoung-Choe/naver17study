import React from 'react';
import "./mystyle.css";
import food1 from "../food/11.jpg"
import food2 from "../food/8.jpg"

// rsc로 생성성
const TwoApp = () => {
    let msg = "집 보내줘라"; // 출력은 가능하나 태그 내에서 수정은 불가능 

    return (
        <div>
            <h2> TwoApp 컴포넌트 </h2>
            <img alt="" src={food1} className='photo1'/>
            <img alt="" src={food2} className='photo2'/>

            {/* h5의 배경색, 글자색, 너비, 글꼴 모드 변경해보기 */}
            <h5 style={{backgroundColor:"lavenderblush", color:"thistle", width:"150px", fontFamily:"Playwrite AU SA"}}> {msg} </h5>
        </div>
    );
};

// rsf 생성
// import React from 'react';

// function TwoApp(props) {
//     return (
//         <div>
            
//         </div>
//     );
// }

export default TwoApp;