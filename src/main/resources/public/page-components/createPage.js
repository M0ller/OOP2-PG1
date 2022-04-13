class CreatePage extends Component {

events(){
    $('body').on('submit', '#logout', this.logout)
    $('body').on('submit', '#createPage', this.createPage)
    $('body').on('submit', '#main', this.main)
}

async createPage(event){
     event.preventDefault()
    // url/site/create
     let result = await fetch(apiHost + '/site/createPage', {
         method: 'post',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify({
             "title": document.querySelector('#title').value,
         })
     })
     let data = await result.json()
     console.log(result, data)
     if(result.status === 200){ // goes to new site if login status is 200 (200 = successful login)
        location.hash = "editSite"
    }

 }

async preview(e){
    if(e.target.files.length > 0){
        this.file = e.target.files[0]
        let preview = document.getElementById("upload-preview")
        preview.src = URL.createObjectURL(this.file)
        preview.style.display = "block"       
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
    <span>Title</span>
            <input type="text" id="title" placeholder="">
            <input type="submit" class="Submit" value="Create page">
    </form>
                
                </script>


    `

}

}