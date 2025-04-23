import { DeleteForeverSharp } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';

const SixApp = () => {
    // inputs가 inputArray로 들어가는 구조
    const [inputArray, setinputArray] = useState([]);
    const [inputs, setInputs] = useState({ 
        // inputs 안에 아래 4가지 내용이 들어가는 것
        name:'',
        nickname:'',
        hp:'',
        addr:''
    });

    // 각 데이터 입력 시 inputs의 각 멤버값에 넣어주기
    const changeData=(e)=>{
        // e.target.name, e.target.value 얻기
        let {name,value} = e.target;

        setInputs(
            {
                ...inputs, // 기존의 inputs 객체를 펼쳐서 넣음.
                [name]:value // 입력하는 태그의 name과 value를 넣어준다.
            }
        )
    }

    return (
        <div>
            <Alert severity='success'> SixApp - 입력값들을 하나의 객체에 넣기 </Alert>

            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                    <tr>
                        <th className='table-success' width="100"> 이름 </th>
                        <td>
                            <input type='text' className='form-control' 
                                name='name' value={inputs.name} onChange={changeData}/>
                        </td>
                    </tr>

                    <tr>
                        <th className='table-success' width="100"> 닉네임 </th>
                        <td>
                            <input type='text' className='form-control' 
                                name='nickname' onChange={changeData}/>
                        </td>
                    </tr>

                    <tr>
                        <th className='table-success' width="100"> 핸드폰 </th>
                        <td>
                            <input type='text' className='form-control' 
                                name='hp' onChange={changeData}/>
                        </td>
                    </tr>

                    <tr>
                        <th className='table-success' width="100"> 주소 </th>
                        <td>
                            <input type='text' className='form-control' 
                                name='addr' onChange={changeData}/>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='outlined' color='warning' 
                                onClick={()=>setinputArray(inputArray.concat(inputs))}> 배열에 추가 </Button>
                            <Button variant='outlined' color='warning' 
                                onClick={() => setInputs({
                                    name: '',
                                    nickname: '',
                                    hp: '',
                                    addr: ''
                                })}
                                > 입력값 초기화 </Button>
                        </td>
                    </tr>
                    <tr style={{height:'100px'}} className='table-info'>
                        <td colSpan={2}>
                            <h6>
                                이름: {inputs.name} <br/>
                                닉네임: {inputs.nickname} <br/>
                                핸드폰: {inputs.hp} <br/>
                                주소: {inputs.addr} <br/>
                            </h6>
                            
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            <table className='table table-bordered' style={{width:'500px'}}>
                <caption align="top"> 총 {inputArray.length}명 </caption>
                <thead>
                    <tr className='table-success'>
                        <th width="50"> 번호 </th>
                        <th width="80"> 이름 </th>
                        <th width="80"> 닉네임 </th>
                        <th width="100"> 핸드폰 </th>
                        <th width="120"> 주소 </th>
                        <th> 삭제 </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inputArray.map((row,idx)=>
                        <tr key={idx}>
                            <td> {idx + 1} </td>
                            <td> {row.name} </td>
                            <td> {row.nickname} </td>
                            <td> {row.hp} </td>
                            <td> {row.addr} </td>
                            <td>
                                <i class="bi bi-trash-fill" style={{color:'mediumaquamarine', cursor:'pointer'}}
                                    onClick={()=>{
                                        setinputArray(inputArray.filter((d,i)=> i!==idx));
                                    }}
                                ></i>
                            </td>
                        </tr>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default SixApp;