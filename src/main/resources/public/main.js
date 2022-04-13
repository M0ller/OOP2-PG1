// api host
const apiHost = 'http://localhost:8080'

// user obj
let user = null;

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
    editSite: EditSite,
    "image-upload": ImageUpload,
    createPage: CreatePage
}

// router
// initialize
changeRoute()
// watch for changes
onhashchange = changeRoute
