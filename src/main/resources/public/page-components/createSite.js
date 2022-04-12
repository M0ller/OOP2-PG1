class CreateSite extends Component{

    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createSite', this.createSite)
    }

    async createSite(event){
         event.preventDefault()
        // url/site/create
         let result = await fetch(apiHost + '/site/create', {
             method: 'post',
             headers: { 'Content-Type': 'application/json' },
             body: JSON.stringify({
                 "adminId": "Linus",
                 "title": document.querySelector('#title').value,
                 "description": document.querySelector('#description').value
                 
             })
         })
         let data = await result.json()
         console.log(result, data)
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
       <form id="logout" method="delete">
       <input type="submit" class="Submit" value="Logout"/>
       <input type="submit" class="Submit" value="Main page"/>
       </form>

       <div class="createSite-block">
       <h1>Create Site</h1>
                <form action= "">
                    <Label>Title</Label>
                    <input type="text" id="title" placeholder="">
                    <label>Description</label>
                    <textarea id="description" rows="3" cols="50" placeholder="">
                    </textarea>
                    <div style="text-align:center">  
                       <input type="submit" class="Submit" value="Create">  
                       </div>  
                    </form>
                    
                    </div>


        `

    }

}