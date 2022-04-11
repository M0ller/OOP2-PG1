class Login extends Component{

    events(){
        $('body').on('submit', '#login', this.signin)
    }

    async login(event){
        event.preventDefault()
        
        let result = await fetch(apiHost + '/api/auth/signin', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "username": document.querySelector('#login-username').value,
                "password": document.querySelector('#login-password').value,
            })
        })
        let data = await result.json()
        console.log(result, data)
        user = data;
    }

    get template(){
        return `
        <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-box">
        <h1>Login</h1>
        <form>
            <label>Email</label>
            <input type="email" placeholder="">
            <label>Password</label>
            <input type="password" placeholder="">
            <button class="Submit">Submit</button>
        </form>
    </div>
    <p class="para-2">Don't have an account? <a href="register.js">Sign up</p>
</body>
</html>
        `
    }

}