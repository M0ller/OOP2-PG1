class Sitefirstpage extends Component{
   
     async getSite(){
        console.log("Before")
        let result = await fetch('http://localhost:8080/site/book').then(response =>response.json()) //.then(data => console.log(data))
        let data = await result
        site = data
        title = data.title
        console.log("After")
        /* let result = await fetch(apiHost + '/site/book', {
            method: 'get'
        })
        //console.log(result, data) */      
        console.log("result")

        console.log(data)
        console.log(title)
        return title
    } 
    
     template =`${this.getSite()} 
     <h1>You got Stuff! ${title}</h1>`
    

/*     async getSite(){
     await fetch( apiHost + `/site/book`, {
        method: "GET", 
        headers: {'Content-Type': 'application/json'},
        //body: undefined // string, FormData, Blob, BufferSource, or URLSearchParams
        //referrer: "about:client", // or "" to send no Referer header,
        // or an url from the current origin

        //redirect: "follow", // manual, error
        })
    }
    getSite() */

/*     async returnSite(){
        return await fetch(apiHost + `/site/book`); 
    }

    returnSite() */
    
}