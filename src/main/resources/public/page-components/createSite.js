class CreateSite extends Component{

    events(){
        $('body').on('submit', '#logout', this.logout)
        $('body').on('submit', '#createSite', this.createSite)
        $('body').on('change', '#upload-image', (e)=>{this.preview(e)})
        $('body').on('submit', '#upload', (e)=>{this.upload(e)}) 
    }

    async createSite(event){
         event.preventDefault()
        // url/site/create
         let result = await fetch(apiHost + '/site/create', {
             method: 'post',
             headers: { 'Content-Type': 'application/json' },
             body: JSON.stringify({
                 "adminId": "Linus",
                 "title": document.querySelector('#title').value,
                 "description": document.querySelector('#description').value,
                 "log": document.querySelector('#upload-image'),
                 "wallpaper": document.querySelector('#wallpaper'),
                 "colorTheme": document.querySelector('#colorInputText').value,
                 "font": document.querySelector('#fontInput').value
             })
         })
         let data = await result.json()
         console.log(result, data)
     }

    async preview(e){
        if(e.target.files.length > 0){
            this.file = e.target.files[0]
            let preview = document.getElementById("upload-preview")
            preview.src = URL.createObjectURL(this.file)
            preview.style.display = "block"       
        }
    }

    async upload(e){
        e.preventDefault()
        const formData = new FormData()
        formData.append('file', this.file)
        formData.append('info', document.querySelector('#upload-info').value)
        
        let result = await fetch(apiHost + "/api/file/upload", {
	 		// headers: { 
            //     'Authorization': 'Bearer ' + user.accessToken
            // },
				method: 'POST',
				body: formData
		})
		
         console.log(result)
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
       <form id="logout" method="delete">
       <input type="submit" class="Submit" value="Logout"/>
       <input type="submit" class="Submit" value="Main page"/>
       </form>

       <div class="createSite-block">
       <h1>Create Site</h1>
                <form id= "createsite">
                    <label>Title</label>
                    <input type="text" id="title" placeholder="">
                    <label>Description</label>
                    <input type="text id="description" placeholder="">
                    <label>Logo</label>
                    <input id="log" type="file" accept="image/*">
                    <input type="submit" class="Upload" value="Upload">
                    <label>Wallpaper</label>
                    <input id="wallpaper" type="file" accept="image/*">
                    <input type="submit" class="Upload" value="Upload">
                    <div style="text-align:center"> 
                    <label>Style color</label>
                    <input type="text" id="colorInputText">
                    <input type="color" id="colorInputColor">
                    <input type="submit" id="colorTheme" Class="Upload" value="Submit"
                    onclick="changeColor()">
                    <label>Font</label>
                    <font face="font" id="fontInput">
                    <input type="submit" id="font" Class="Upload" value="Submit"> 
                       <input type="submit" class="Submit" value="Create">  
                       </div>  
                    </form>
                    </div>
                    <script>
                    function changeColor(){
                        let color = document.getElementById('colorInputColor').value;
                        document.body.style.color = color;
                        document.getElementById('colorInputText').value = color;
                    }

                    function changeFont(){
                        let font = document.getElementById('fontInput').value;
                        document.body.style.font = font;
                    }
                    </script>


        `

    }

}