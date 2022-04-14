class CreateArticle extends Component {

    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createArticle', this.createArticle)
        $('body').on('submit', '#main', this.main)
    }
    
    async createArticle(event){
         event.preventDefault()
         console.log(startdate.value)
        // url/site/create
         let result = await fetch(apiHost + '/site/createArticle', {
             method: 'post',
             headers: { 'Content-Type': 'application/json' },
             body: JSON.stringify({
                 "title": document.querySelector('#title').value,
                 "textarea": document.querySelector("#textarea").value,
                 "startdate": document.querySelector('#startdate').value,
                 "enddate":document.querySelector('#enddate').value
                 
             })
         })
         
         let data = await result.json()
         console.log(result, data)
         if(result.status === 200){ // goes to new site if login status is 200 (200 = successful login)
           // alert("Article created");
        }
    
     }
    
    async preview(e){
        if(e.target.files.length > 0){
            this.file = e.target.files[0]
            let preview = document.getElementById("upload-preview")
            preview.src = URL.createObjectURL(this.file)
            preview.style.display = "block"       
        }
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
        <h1>Create new article</h1>
    
        <form id="logout" method="delete">
        <input type="submit" class="Edit" value="Logout"/>
        </form>
        
        <form id="main">
        <input type="submit"class="Edit" value="Main page"/>
        </form>
            <form id= "createArticle">
            

            <span>Title</span>
            <input type="text" id="title" placeholder="">

            <label for="textarea">Enter text here: </label>
            <textarea id="textarea" name="textarea" rows="4" cols="50">
        </textarea>
    

        <form id="startdate">
        <label for="startdate">Enter a start date and time:</label>
        <input type="datetime-local" id="startdate" name="startdate">
        <br><br>
        <form id="enddate">
        <label for="enddate">Enter a end date and time:</label>
        <input type="datetime-local" id="enddate" name="enddate">
        <input type="submit" class="Submit" value="Create Article">
        </form>
        </script>
        `
    }
    
}