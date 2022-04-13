class MainAdminPage extends Component{

    events(){
        $('body').on('submit', '#mainAdminPage', this.loadMain)
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createSite', this.createSite)
    }

  async loadMain(){
        /*let result = await fetch(apiHost + '/api/default/main')    
        let data = await result.json()
        console.log(result, data);
        for(let i = 0; i<data.length; i++){
            data[i] = new Sitesdata( data[i] ).render()
        }
        this.data = data  
        //$('footer').html(this.data.join('<hr>')) 
        */
       return "SSS"     
    } 

    async logout(event){
        event.preventDefault()
        let result = await fetch(apiHost + '/api/auth/signout', {
            method: 'delete',
        })
        let data = await result.json()
        console.log(result, data)
        location.hash = "login"
    }

    async createSite(e){
        location.hash = "createSite"
    }


    
    
    get template(){
        return `

    <div class="admin-box">
        <h1>My list of sites</h1>
        <form id="logout" method="delete">
        <input type="submit" class="Edit" value="Logout"/>
        </form>
        <form id="createSite">
        <input type="submit"class="Edit" value="Create Site"/>
        </form>

        <form id ="mainAdminPage">    
        

        <div class="dropdown">
            <span>Show list of sites</span>
             <div class="dropdown-content">
            <p><a href="#">Barcat master</a> </p>
            <p><a href="#">D.Book</a> </p>
           
            


        `
    }
    
    
}//${this.data.join('')}


