import React, { useReducer, useState } from 'react';
import Student from './Student';

// reducer 설정 시 초기값으로 미리 지정
const initialState = {
    count: 1,
    students: [
        {
            id: new Date(),
            name: '최은영',
            isHere: false
        }
    ]
}

const reducer = (state,action)=>{
    console.log(state,action);

    switch(action.type) {
        case 'add-student':
            const name = action.payload.name;
            // 추가할 학생 정보
            const addStudent = {
                id: new Date(),
                name, // name: name인데 같을 땐 이렇게 한 번만 써도 됨.
                isHere: false
            }

            const data = {
                count: state.count + 1,
                students: [
                    ...state.students,
                    addStudent
                ]
            }
            return data;

        case 'delete-student':
            return {
                count: state.count -1, // 인원 수는 1 줄이기
                students: state.students.filter(s=>s.id!==action.payload.id) // payload를 통해 전달된 id를 찾아서 filter로 제거
            };
        
        case 'mark-student':
            // mark-student 액션이 발생하면 해당 id와 같은 학생을 찾아서 isHere만 반대로 값을 수정함.
            return {
                count: state.count,
                students: state.students.map(s=>{
                    if(s.id===action.payload.id) {
                        return {...s, isHere:!s.isHere}
                    }
                    return s;
                })
            }

        default:
            return state;
    }
}

const ReducerComp2 = () => {
    const [name, setName] = useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <h5> useReducer 예제#2 </h5>
            <h2 className='alert alert-success'>
                학생관리 reducer
            </h2>
            <div className='input-group' style={{width:'200px'}}>
                <input type='text' className='form-control' value={name} onChange={(e)=>setName(e.target.value)}/>
                &nbsp;&nbsp;
                <button type='button' className='btn btn-sm btn-info'
                    onClick={()=>{
                        dispatch({'type':'add-student', payload:{name}}); // name:name
                        setName('');
                    }}> 추가 </button>
                <br/><br/>
                {
                    studentInfo.students.map((stu,idx)=>
                        <Student key={idx} stu={stu} dispatch={dispatch}/>
                    )
                }
            </div>
        </div>
    );
};

export default ReducerComp2;