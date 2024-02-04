import styles from './Header.module.scss'
import logo from '../assets/DevTubeLogo.png'
const Header=()=>{
	return(
		<header id="header" role="banner" className={styles.header}>
            <div className={styles.contents}>
                <div className={styles.logo}>
                    <a href="/"><img src={logo} /></a>
                </div>
                <nav className={styles.navigation} role="navigation" aria-label="메인 메뉴">
                    <ul>
                        <li><a href="/">홈</a></li>
                        <li><a href="/devTube">강의</a></li>
                        <li><a href="#site">스터디</a></li>
                        <li><a href="#port">마이페이지</a></li>
                        <li><button>로그아웃</button></li>
                    </ul>
                </nav>
            </div>
        </header>
)}

export default Header;