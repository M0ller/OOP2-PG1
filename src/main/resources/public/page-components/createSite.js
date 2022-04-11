class CreateSite extends Component{
    
    get template(){
    return `

       <h1>Create Site</h1>
            <div class="createsite-block">
                <form id="createsite">
                    <label>Site name</label>
                    <input type="text" id="register-username" placeholder="">
                    <label>Title</label>
                    <input type="email" id="register-email" placeholder="">
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