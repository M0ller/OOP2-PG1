class CreateSite extends Component{
    
    get template(){
    return `
       
            <div class="createsite-box">
                <h1>Create Site</h1>
                <form id="createsite">
                    <label>Site name</label>
                    <input type="text" id="register-username" placeholder="">
                    <label>Title</label>
                    <input type="email" id="register-email" placeholder="">
                    <label>Description</label>
                    <input type="password" id="register-password" placeholder="">
                    <input type="submit" class="Submit" value="Submit">
                </form>
            </div>
            
        `

    }

}