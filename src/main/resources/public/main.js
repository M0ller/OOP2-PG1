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
    signup: Signup, 
    login: Login,
}

// router
// initialize
changeRoute()
// watch for changes
onhashchange = changeRoute
