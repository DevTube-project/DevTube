import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

export default function DevTubeCard({ data }) {
  // 데이터가 없을 경우 빈 배열로 초기화
  const videos = data || [];

  return (
    <>
      {videos.map((video) => (
        <Card key={video.id} sx={{ maxWidth: 345 }}>
          <CardMedia
            component="img"
            alt={video.title}
            height="200"
            image={video.thumbnailUrl || 'https://via.placeholder.com/200'} // 썸네일 이미지 URL
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {video.title}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {video.description}
            </Typography>
          </CardContent>
          <CardActions>
            <Button size="small">Share</Button>
            <Button size="small">Learn More</Button>
          </CardActions>
        </Card>
      ))}
    </>
  );
};
