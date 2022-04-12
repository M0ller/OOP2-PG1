class Login extends Component{

    events(){
        $('body').on('submit', '#login', this.login)
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
        location.hash = "mainAdminPage"
    }

    get template(){
        return `
        
    <div class="login-box">
        <h1>Login</h1>
        <form id="login">
            <label>Username</label>
            <input type="username" id="login-username" placeholder="">
            <label>Password</label>
            <input type="password" id="login-password" placeholder="">
            <input type="submit" class="Submit" value="Submit">
        </form>
        <p class="para-2">Don't have an account? <a href="signup.js">Sign up</p>
    </div>
    

        `
    }

}