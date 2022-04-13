class MainAdminPage extends Component{

    events(){
        $('body').on('submit', '#mainAdminPage', this.loadMain)
        $('body').on('submit', '#logout', this.logout)
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
    
    
    get template(){
        return `

    <div class="admin-box">
    
        <h1>My list of sites</h1>
        <form id ="mainAdminPage">    
        
        <input type="edit" class="CreateSite" value="Create Site">
        <input type="edit" class="CreateSite" value="Logout">

        <div class="dropdown">
            <span>Show list of sites</span>
             <div class="dropdown-content">
            <p><a href="#">Barcat master</a> </p>
            <p><a href="#">D.Book</a> </p>
            <p><a href="#">Link 3</a> </p>
            
            


        `
    }
    
    
}//${this.data.join('')}


