import * as React from 'react';
import UnstyledTabsIntroduction from '../components/Tabs';
import DevInput from '../components/Input';
import DevTubeCard from '../components/Cards';
import styles from './Home.module.scss'
import { useEffect, useState } from 'react';

export default function Home() {
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
    <div>
			<div className={styles.Banner} >배너란다^^</div>
			<div>
			<div style={{ marginBottom: '30px' , marginTop:'-20px'}}>
				<DevInput />
			</div>
			<UnstyledTabsIntroduction />
			<div>
				<h3>한시간만에 공부해보자!</h3>
				<DevTubeCard data={undefined} />
			</div>

			<div>
				<h3> 추천 강의</h3>
				<DevTubeCard data={undefined} />
			</div>
			</div>
    </div>
  );
}

