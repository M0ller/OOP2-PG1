class Header extends Component{

    get template(){
        return `
            <nav>
                <a href="#signup">Sign up</a>
                <a href="#login">Login</a>
                <a href="#mainAdminPage">Main page</a>
                <a href="#createSite">Create site</a>
                <a href="#editSite">Edit site</a>
                <a href="#editPage">Edit page</a>
                <a href="#createPage">Create page</a>
                <a href="#createArticle">Create article</a>
                <a href="#image-upload">Upload image</a>
                
            </nav>            
        `
    } // <a href="site/"${site.title}>Go to book</a>

}