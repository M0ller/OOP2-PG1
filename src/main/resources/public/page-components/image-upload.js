class ImageUpload extends Component{

    file;

    events(){
        $('body').on('change', '#upload-image', (e)=>{this.preview(e)})
        //$('body').on('submit', '#upload', (e)=>{this.upload(e)}) 
        $('body').on('submit', '#upload', this.upload) 
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
    
    
    get template(){
        return `
            <h1>Upload file</h1>
            <form id="upload">
                <legend>Choose file</legend>
                <input id="upload-image" type="file" accept="image/*">
                <input type="submit" value="Upload">
            </form>
            <img id="upload-preview">
        `
    }
    
}