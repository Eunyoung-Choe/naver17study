import React from 'react';
import noimage from "../image/noimage.png"

const FourRowItem = ({row}) => {
    const shoppath = "https://kr.object.ncloudstorage.com/bitcamp-bucket-149/jpashop/";

    return (
        <tr>
            <td>
                <img alt='' src={row.photo?row.photo:noimage} style={{width:'140px', height:'180px', border:'3px solid gray'}}
                    onError={(e)=> e.target.src = noimage}/>
            </td>
                <h6> 
                    상품명: {row.sangpum}
                    <i class="bi bi-trash-fill" style={{float:'right',cursor:'pointer'}}/>
                </h6>
                <td style={{marginLeft:'10px'}} valign='middle'></td>
                <h6 style={{backgroundColor:'midnightblue'}}> 색상 : {row.color} </h6>
                <h6> 구입일 : {row.sangguip} </h6>
                <h6> 단가: {row.price} </h6>
                <h6> 등록일: {row.writeday} </h6>
        </tr>
    );
};

export default FourRowItem;