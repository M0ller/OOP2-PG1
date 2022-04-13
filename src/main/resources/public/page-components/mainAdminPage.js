class MainAdminPage extends Component{

    events(){
        $('body').on('submit', '#mainAdminPage', this.load)
        $('body').on('submit', '#logout', this.logout)
    }

    siteTitle = []

  async load(){
        console.log(user.username)
        let result = await fetch(apiHost + '/site/get/' + user.username)    
        let data = await result.json()

        for(let i = 0; i<data.length; i++){
            data[i] = new this.siteTitle ( data[i] ).render()
            //this.siteTitle.push(data[i].title)
        }
        this.data = data  
        //$('footer').html(this.data.join('<hr>')) 

    }

    async logout(event){
        event.preventDefault()
        let result = await fetch(apiHost + '/site/auth/signout', {
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
        <ul id="siteTitle"></ul>
        <section>
                ${this.data.join('')}
            </section>

        
        <div class="dropdown">
            <span>Show list of sites</span>
             <div class="dropdown-content">
            <p><a href="#">Barcat master</a> </p>
            <p><a href="#">D.Book</a> </p>
           
           
            


        `
    }
    
    
}//${this.data.join('')}


