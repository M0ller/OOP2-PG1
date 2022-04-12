class CreateSite extends Component{

    events(){
        $('body').on('submit', '#logout', this.logout)
    }

    // async createSite(event){
    //     event.preventDefault()
        
    //     let result = await fetch(apiHost + '/api/auth/createSite', {
    //         method: 'post',
    //         headers: { 'Content-Type': 'application/json' },
    //         body: JSON.stringify({
    //             "site": document.querySelector('#site-name').value,
    //             "title": document.querySelector('#title').value,
    //         })
    //     })
    //     let data = await result.json()
    //     console.log(result, data)
    //     site = data;
    // }

    async logout(event){
        event.preventDefault()
        let result = await fetch(apiHost + '/api/auth/signout', {
            method: 'delete',
        })
        // if(result.status != 200){
        //     location.hash = "login"
        // }
        let data = await result.json()
        console.log(result, data)
        if(result.status === 200){
           location.hash = "login"
        }
    }
    
    get template(){
    return `

       <h1>Create Site</h1>
            <div class="createsite-block">
            <form id="logout">
                <input type="submit" class="Submit" value="Logout"/>
                </form>

                <form id="createsite">
                    <label>Site name</label>
                    <input type="text" id="site-name" placeholder="">
                    <label>Title</label>
                    <input type="email" id="title" placeholder="">
                    <label>Description</label>
                    <input type="password" id="register-password" placeholder=""
                    </form>
            </div>
            <div class="createsite-block2">
                <form>
                    <label>Color Theme</label>
                    <input type="text" id="register-username" placeholder="">
                    <label>Title</label>
                    <input type="email" id="register-email" placeholder="">
                    <label>Description</label>
                    <input type="password" id="register-password" placeholder="">
                    <input type="submit" class="Create" value="Submit">
                    </form>
                
            
        `

    }

}