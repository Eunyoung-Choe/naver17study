import { DeleteForeverOutlined } from '@mui/icons-material';
import { Button } from '@mui/material';
import React from 'react';

const OneRowItem = (props) => {
    let {row,idx,onDelete}=props;
    console.log("🔥row 확인:", row);

    return (
        <tr>
            <td>{idx+1}</td>
            <td>
                <img alt="" src={require(`../food/${row.photo}`)}
                style={{width:'30px',height:'30px',marginRight:'5px'}}/>
                {row.irum}
            </td>
            <td>{row.blood}형</td>
            <td>{row.today.toLocaleDateString('ko-KR')}</td>
            <td>
                <Button
                style={{fontSize:'1.5em',color:'red',cursor:'pointer'}}
                onClick={()=>{
                    let a=window.confirm("삭제할까요?");
                    if(!a) return;

                    onDelete(idx);
                }}/>
            </td>
        </tr>
    );
};

export default OneRowItem;