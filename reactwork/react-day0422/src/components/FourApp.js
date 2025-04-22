/*
https://styled-components.com/docs/basics#getting-started

# with npm
npm install styled-components

# with yarn
yarn add styled-components

설명
styled-components태그가 지정된 템플릿 리터럴(백틱)을 활용하여 구성 요소의 스타일을 지정합니다.
*/

// FourApp.jsx
import React, { useState } from 'react';
import styled from 'styled-components'; // styled-components용
import { AddIcCall, DeleteForever, DeleteForeverOutlined, DeleteForeverRounded, PhotoAlbum, PhoneAndroidOutlined } from '@mui/icons-material';

import { styled as muiStyled } from '@mui/material/styles'; // MUI용 styled (충돌 방지 위해 이름 바꿈)
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';


// MUI 스타일 버튼
const ExpandMore = muiStyled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  transform: 'rotate(0deg)',
  ...(props => props.expand && { transform: 'rotate(180deg)' })
}));


// MUI 카드 컴포넌트
const RecipeReviewCard = () => {
  const [expanded, setExpanded] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <Card sx={{ maxWidth: 345, marginTop: '30px' }}>
      <CardHeader
        avatar={<Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">J</Avatar>}
        action={<IconButton aria-label="settings"><MoreVertIcon /></IconButton>}
        title="Joke_bear"
        subheader="April 22, 2025"
      />
      <CardMedia
        component="img"
        height="194"
        image="https://i.pinimg.com/736x/a4/24/e7/a424e7cacdb663a99c6091f7bde8406e.jpg"
        alt="Paella dish"
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          드렁슨 드렁슨
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites"><FavoriteIcon /></IconButton>
        <IconButton aria-label="share"><ShareIcon /></IconButton>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>졸려</Typography>
          <Typography paragraph>눈이 감긴다.</Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
};


// FourApp 본체
const FourApp = () => {
  const Title = styled.h2`
    color: orange;
    font-size: 1.5em;
    background-color: yellow;
    width: 300px;
    text-align: center;
  `;

  const MyButton = styled.button`
    color: darkgreen;
    background-color: pink;
    border: 3px inset darkgreen;
    width: 130px;
  `;

  const TomatoButton = styled(MyButton)`
    color: tomato;
    border-color: tomato;
  `;

  return (
    <div>
      <h3>FourApp</h3>
      <Title>Hello React</Title>
      <Title>오늘 날씨 구림</Title>

      <button type='button'>기본 버튼</button><br />
      <MyButton>MyButton</MyButton><br />
      <TomatoButton>TomatoButton</TomatoButton><br />

      <h5>Material Icons</h5>
      <DeleteForever />
      <DeleteForeverOutlined />
      <DeleteForeverRounded />
      <PhotoAlbum />
      <PhoneAndroidOutlined />
      <AddIcCall style={{ color: 'pink', fontSize: '30px' }} />

      {/* MUI 카드 렌더링 */}
      <RecipeReviewCard />
    </div>
  );
};

export default FourApp;
