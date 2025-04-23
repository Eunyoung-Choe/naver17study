import { Alert } from '@mui/material';
import React, { useState } from 'react';

const SevenApp = () => {
    const [starArray, setStarArray] = useState([
        {
            starName: '미니언즈8',
            starAge: '22세',
            starPhoto: '08.png',
            starAddress: '서울시 강남구',
            starPhone: '010-1111-2222'
        },
        {
            starName: '미니언즈9',
            starAge: '23세',
            starPhoto: '09.png',
            starAddress: '서울시 동대문구',
            starPhone: '010-1111-2222'
        },
        {
            starName: '오지상',
            starPhoto: '10.png',
            starAge: '43세',
            starAddress: '서울시 서대문구',
            starPhone: '010-1111-2222'
        },
        {
            starName: '초딩',
            starPhoto: '11.png',
            starAge: '10세',
            starAddress: '서울시 강북구',
            starPhone: '010-1111-2222'
        },
        {
            starName: '미니언즈12',
            starAge: '28세',
            starPhoto: '12.png',
            starAddress: '서울시 성동구',
            starPhone: '010-1111-2222'
        }
    ]);

    return (
        <div>
            <Alert severity='success'> SevenApp - 배열 데이터 출력 </Alert>

            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                {
                    starArray.map((row,idx)=>
                    <>
                        <tr>
                            <td rowSpan={4}>
                                <img alt=""
                                    src={require(`../photo/${row.starPhoto}`)}
                                    style={{width:'200px', height:'230px'}}/>
                            </td>
                            <td> 이름: {row.starName} </td>
                        </tr>
                        <tr>
                            <td> 나이: {row.starAge} </td>
                        </tr>
                        <tr>
                            <td> 핸드폰: {row.starPhone} </td>
                        </tr>
                        <tr>
                            <td> 주소: {row.starAddress} </td>
                        </tr>
                    </>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;