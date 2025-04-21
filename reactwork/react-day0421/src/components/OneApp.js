// 초창기 컴포넌트는 모두 클래스 형태였음.
// Hooks 문법이 리액트 v16.8에서 새로 도입되면서 일반 함수 형태로 변경
// 초기 함수 형태는 상태 저장을 하는 state 기능이 없었는데, Hooks 문법이 추가된 이후부터 일반 함수에서도 state 기능이 추가됨.
// 클래스에서는 라이프 사이클이 엄청 복잡했었는데, Hooks 문법 이후 엄청 단순해짐.

import { Component } from "react"; // default를 안 했을 땐 {}로 이름을 그대로 가져와야 함.
import car11 from "../mycar11.png";

// 첫 예제는 클래스로 만들어 보자. 
class OneApp extends Component
{
    // 생성자는 클래스명과 상관없이 무조건 constructor
    constructor(props){
        super(props);
    }

    render(){
        return (
            // ※ return 안 구문은 html 태그가 아니라 JSX 태그임.
            // < HTML과 JSX 차이점 >
            // 1. 모든 요소는 짝이 맞아야 함. <br>도, <img>도.
            // 2. 특성 이름이 HTML 언어 사양이 아닌, dom api에 기반을 둠.

            // 부모 태그는 무조건 한 개만 가능함.
            // < 태그 안에서 직접 스타일을 추가하는 방법 >
            <div style={{backgroundColor:'royalblue', width:'200px', height:'200px'}}>
                <h2 style={{color:'ghostwhite'}}> OneApp 컴포넌트 </h2> 
                <br/>
                {/* <br/> 단독 태그인 경우 />로 닫는다. */}
                {/* public의 이미지 나타내는 방법: 경로로 가능 
                (권장은 X. 라우터에서 문제가 생길 수도 있음.) */}
                <img alt="" src="mycar13.png" style={{width:'100px'}}/>

                {/* src의 이미지를 import 후 가져오거나 require 명령어를 이용한다. */}
                <img alt="" src={car11} style={{width:'100px'}}/>
            </div>
        )
    }
}

export {OneApp} // 여러 번 사용 가능, import 할 때 {OneApp}으로만 import 가능 
// export default OneApp; // default는 단 한 번만 사용 가능, 이 경우는 import 시 내 마음대로 이름 정해도 됨.