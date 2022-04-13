class EditSite extends Component{
    
    get template(){
        return `

    <div class="admin-box">
    
        <h1>Edit Site</h1>
        <form id ="mainAdminPage">    
        
        <input type="edit" class="CreateSite" value="Create Site">
        <input type="edit" class="CreateSite" value="Logout">

        <input type="logout" class="Logout" value="Logout">
        <div class="createsitediv">
        <span>Title</span>
            

        `
    }

}