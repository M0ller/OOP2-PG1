class CreatePage extends Component {

events(){
    $('body').on('submit', '#logout', this.logout)
    $('body').on('submit', '#createPage', this.createPage)
    $('body').on('submit', '#main', this.main)
}

async createPage(event){
     event.preventDefault()
    // url/site/create
     let result = await fetch(apiHost + '/page/create', {
         method: 'post',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify({
             "title": document.querySelector('#title').value,
         })
     })
     let data = await result.json()
     console.log(result, data)
     if(result.status === 200){ // goes to new site if login status is 200 (200 = successful login)
        location.hash = "editPage"
    }

 }

async main(e){
    location.hash = "mainAdminPage"
}

async logout(event){
    event.preventDefault()
    let result = await fetch(apiHost + '/api/auth/signout', {
        method: 'delete',
    })
    let data = await result.json()
    console.log(result, data)
    if(result.status === 200){
       location.hash = "login"
    }
}

get template(){
return `
<div class="admin-box">
    <h1>Create new page</h1>

    <form id="logout" method="delete">
    <input type="submit" class="Edit" value="Logout"/>
    </form>
    <form id="main">
    <input type="submit"class="Edit" value="Main page"/>
    </form>
    <span>Title</span>
    <form id="createPage">
            <input type="text" id="title"/>
            <input type="submit" class="Submit" value="Create page"/>
    </form>


    `

}

}