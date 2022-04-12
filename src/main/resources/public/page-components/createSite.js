class CreateSite extends Component{
// user.id/username/email/roles[]
    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createSite', this.createSite)
    }

    async createSite(event){
         event.preventDefault()
         let result = await fetch(apiHost + '/site/create', {
             method: 'post',
             headers: { 'Content-Type': 'application/json' },
             body: JSON.stringify({
                 "adminId": user.username,
                 "title": document.querySelector('#title').value,
                 "description": document.querySelector('#description').value
                 
             })
         })
         let data = await result.json()
         console.log(result, data)
         site = data;
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

       <h1>Create Site</h1>
       <form id="logout" method="delete">
       <input type="submit" class="Submit" value="Logout"/>
       <input type="submit" class="Submit" value="Main page"/>
       </form>
            <div class="createSite-block">

                <form id="createSite">
                    <label>Site name</label>
                    <input type="text" id="site-name" placeholder="">
                    <label>Title</label>
                    <input type="text" id="title" placeholder="">
                    <label>Description</label>
                    <input type="text" id="description" placeholder=""
                    <label>Upload logo</label>
                    <label>Upload wallpaper</label>
                    <input type="submit" class="Submit" value="Create">
                    </div>
                    </form>


        `

    }

}