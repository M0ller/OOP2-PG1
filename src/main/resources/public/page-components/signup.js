class Signup extends Component{

    events(){
        $('body').on('submit', '#signup', this.signup)
    }

    async signup(event){
        event.preventDefault()
        
        let result = await fetch(apiHost + '/api/auth/signup', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "username": document.querySelector  ('#register-username').value,
                "password": document.querySelector('#register-password').value,
                "email": document.querySelector('#register-email').value,
                "roles": ["user"]
            })
        })
        let data = await result.json()
        console.log(result, data)
    }

    get template(){
        return `
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            
            <title>Sign Up</title>
            <link rel="stylesheet" href="style.css">
        </head>
        <body>
            <div class="signup-box">
                <h1>Sign Up</h1>
                <form>
                    <label>Username</label>
                    <input type="text" placeholder="">
                    <label>Email</label>
                    <input type="email" placeholder="">
                    <label>Password</label>
                    <input type="password" placeholder="">
                    <label>Confirm Password</label>
                    <input type="password" placeholder="">
                    <button class="Submit">Submit</button>
                </form>
            </div>
            <p class="para-2">Already have an account? <a href="login.js">Login Here</a></p>
        </body>
        </html>
        `
    }

}