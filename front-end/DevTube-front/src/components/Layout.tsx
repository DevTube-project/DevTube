import Header from "./Header";
import Footer from "./Footer";
import styles from "./Layout.module.scss"

const Layout=(porps:{
	children : React.ReactNode
})=>{
	return(
		<div className={styles.layout}>
			<Header />
			<main className={styles.main}>
				{porps.children}
			</main>
			<Footer />
		</div>
	)
}

export default Layout;