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
    "image-upload": ImageUpload,
}

// router
// initialize
changeRoute()
// watch for changes
onhashchange = changeRoute

   
