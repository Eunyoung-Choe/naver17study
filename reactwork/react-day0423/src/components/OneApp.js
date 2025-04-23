import { Alert } from '@mui/material';
import React from 'react';
import "./mystyle.css"

const OneApp = () => {
    let colors = ["red", "green","pink","orange","yellow","white","orange","tomato","gold"];
    let chardata = [ // JS 객체 배열
        {"photo":"04.png", "title":"미니언4","addr":"화성"},
        {"photo":"05.png", "title":"미니언5","addr":"수성"},
        {"photo":"06.png", "title":"미니언6","addr":"금성"},
        {"photo":"07.png", "title":"미니언7","addr":"목성"}
    ]

    return (
        <div>
            <Alert severity='success'> OneApp-map 연습 </Alert>
            {
                colors.map((color,idx)=>
                    <div key={idx} 
                        style={{backgroundColor:color}}
                        className='box'></div>)
            }
            <br style={{clear:'both'}}/><br/>
            <table className='table table-bordered' style={{width:'400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th> 이름 </th> <th> 사진 </th> <th> 주소 </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        chardata.map((data,idx)=>
                            <tr key={idx}>
                                <td> {data.title} </td>
                                <td> 
                                    <img alt='' src={require(`../photo/${data.photo}`)} style={{width:'50px'}}/>
                                </td>
                                <td> {data.addr} </td>
                            </tr>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;