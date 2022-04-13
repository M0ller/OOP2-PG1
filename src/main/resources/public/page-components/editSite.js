class EditSite extends Component{

    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#main', this.main)
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
        <h1>Edit Site</h1>

        <form id="logout" method="delete">
            <input type="submit" class="Edit" value="Logout"/>
            </form>
            <form id="main">
            <input type="submit"class="Edit" value="Main page"/>
            </form>
                <form id ="mainAdminPage">    

                 <input type="logout" class="Logout2" value="">

                <div class="createsitediv">
                <span>Title</span>
            

        `
    }

}