import * as React from 'react';
import styles from './DevTubeHome.module.scss'
import DevTubeCard from '../components/Cards'; 
import DevTubeInnput from '../components/Input'
import { useState, useEffect } from 'react';

export default function DevTubeHome() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        const result = await response.json();
        setData(result);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <>
      <h1>데브튜브 시작~</h1>
      <DevTubeInnput />
			<div className={styles.pageContainer}>
      	<DevTubeCard data={data} />
			</div>
    </>
  );
}

