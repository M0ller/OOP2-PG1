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
                <a href="#createArticle">Create Article</a>
                <a href="#editPage">Edit Page</a>
                <a href="#createPage">Create Page</a>
            </nav>            
        `
    } // <a href="site/"${site.title}>Go to book</a>

}