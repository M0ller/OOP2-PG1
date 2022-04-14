// api host
const apiHost = 'http://localhost:8080'

// user obj
let user = null
let site = null
let title = null

/* let testFont = site.urlHeader; */
// populate header
const header = new Header()
header.render('header')

// map pages (register page classes to urls)
let pages = {
    // url     classname
    firstpage: Firstpage,
    signup: Signup, 
    login: Login,
    mainAdminPage: MainAdminPage,
    createSite: CreateSite,
    sitefirstpage: Sitefirstpage,
    editSite: EditSite,
    editPage: EditPage,
    "image-upload": ImageUpload,
<<<<<<< HEAD

    createArticle: CreateArticle

=======
    createArticle: CreateArticle,
    createPage: CreatePage
>>>>>>> 1cc377014319a5f58336423e542e252b61ee2914
}

// router
// initialize
changeRoute()
// watch for changes
onhashchange = changeRoute

   
