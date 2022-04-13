class MainAdminPage extends Component{

    events(){
        $('body').on('submit', '#mainAdminPage', this.load)
        $('body').on('submit', '#logout', this.logout)
    }

    siteTitle = []

  
  
    async load(){
        let result = await fetch(apiHost + '/site/get/' + user.username)    
        let data = await result.json()
        console.log(result,data);
        for(let i = 0; i<data.length; i++){
            //data[i] = this.siteTitle( data[i] ).render()
            this.siteTitle.push(data[i].title)
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

    siteLinks(sites) {
        let html = ""
        for (const site of sites) {
         html += `<a href="#mainAdminPage/${site.title}/edit">${site.title}</a>`
        }
        return html


    }


    
    
    get template(){
        return `

    <div class="admin-box">
    
        <h1>My list of sites</h1>
        <form id ="mainAdminPage">    
        
        <input type="edit" class="CreateSite" value="Create Site">
        <input type="edit" class="CreateSite" value="Logout">
        <ul id="siteTitle"></ul>
     

        
        <div class="dropdown">
            <span>Show list of sites</span>
             <div class="dropdown-content">
            <p>${this.siteLinks(this.data)}</p>
            </div>
        </div>
            
           
            


        `
    }
    
    
}//${this.data.join('')}


