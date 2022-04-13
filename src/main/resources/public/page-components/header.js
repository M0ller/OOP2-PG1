class Header extends Component{

    get template(){
        return `
            <nav>
                <a href="#">Home</a>
                <a href="#signup">Sign up</a>
                <a href="#login">Login</a>
                <a href="#sitefirstpage">Go to book</a>
                <a href="#createSite">Create Site</a>
                <a href="#image-upload">Image upload</a>
                <a href="#mainAdminPage">Main Page</a>
                <a href="#editSite">Edit Site</a>
<<<<<<< HEAD
=======
                <a href="#createPage">Create Page</a>
                <a href="#createArticle">Create Article</a>
                
>>>>>>> createArticle
            </nav>            
        `
    } // <a href="site/"${site.title}>Go to book</a>

}