class EditPage extends Component{

    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#main', this.main)
    }

    async load(){
        let result = await fetch(apiHost + '/page/get/' + user.username)    
        let data = await result.json()
        console.log(result,data);

        this.data = data


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

     siteLinks(sites) {
         let html = ""
         for (const site of sites) {
            html += `<a href="#editSite/${site.title}/edit">${site.title}</a>`
         }
         return html
     }

    get template(){
        return `

        <div class="dropdown-right">
            <span>List of articles</span>
             <div class="dropdown-right-content">
            <p>${this.siteLinks(this.data)}</p>
            </div>
        </div>

            <div class="admin-box">
                <h1>Edit page</h1>

                <form id="logout" method="delete">
                <input type="submit" class="Edit" value="Logout"/>
                </form>
                <form id="main">
                <input type="submit"class="Edit" value="Main page"/>
                </form>
                <form id="createPage" method="post">
                <input type="submit" class="Edit" value="Create page"/>
                </form>
                <form id="createArticle" method="post">
                <input type="submit" class="Edit" value="Create article"
                </form>
                <form id="image-upload">
                <input type="submit" class="Edit" value="Upload image"/>
                </form>
                   <form id= "pages">
                   <div class="page-dropdown">
                      <span>List of pages</span>
                      <div class="page-dropdown-content">
                      <p>${this.siteLinks(this.data)}</p>
                    </div>
                    </div>

                </form>  
                </div>


        

      `
    }
}