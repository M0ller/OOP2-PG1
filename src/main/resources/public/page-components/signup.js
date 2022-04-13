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
       
            <div class="signup-box">
                <h1>Sign Up</h1>
                <form id="signup">
                    <label>Username</label>
                    <input type="text" id="register-username" placeholder="">
                    <label>Email</label>
                    <input type="email" id="register-email" placeholder="">
                    <label>Password</label>
                    <input type="password" id="register-password" placeholder="">
                    <input type="submit" class="Submit" value="Submit">
                </form>
                <p class="para-2">Already have an account? <a href="#login">Login Here</a></p>
            </div>
            
        `
    }

}