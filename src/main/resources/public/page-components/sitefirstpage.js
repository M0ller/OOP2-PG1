class Sitefirstpage extends Component{

    data = {}
   
     async load(){
        let result = await fetch('http://localhost:8080/site/${urlHeader}')

        this.data = await result.json()
        
    } 

    
     get template() {
        return `
        <h1>You got Stuff! ${this.data.title}</h1>
 
        `
     }
}