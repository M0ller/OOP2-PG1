class mainAdminPage extends Component{

    events(){
        $('body').on('submit', '#default', this.loadMain)
    }

    async loadMain(){
        let result = await fetch(apiHost + '/api/default/main')    
        let data = await result.json()
        console.log(result, data);
        for(let i = 0; i<data.length; i++){
            data[i] = new Sitesdata( data[i] ).render()
        }
        this.data = data  
        //$('footer').html(this.data.join('<hr>'))      
    }
    

    get template(){
        return `
        <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of sites </title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="signup-box">
        <h1>My list of sites</h1>
        <form>
            <label>List of sites </label>
            <hr />
    Import site name
    <button type="button" style="font: bold 14px Arial;">Edit</button><br />
</body>
</html>
        `
    }
}


