class MainAdminPage extends Component{

    events(){
        $('body').on('submit', '#mainAdminPage', this.load)
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createSite', this.createSite)
    }

    siteTitle = []

    async load(){
        let result = await fetch(apiHost + '/site/get/' + user.username)    
        let data = await result.json()
        console.log(result,data);

        this.data = data


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
         html += `<a href="/#editSite">${site.title}</a>`
        }
        return html
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
            <p>${this.siteLinks(this.data)}</p>
            </div>
        </div>

        `
    }
    
    
}//${this.data.join('')}
