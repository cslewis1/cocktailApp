const regForm = document.getElementById('register-form')
const regUsername = document.getElementById('register-username')
const regPassword = document.getElementById('register-password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: regUsername.value,
        password: regPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

regForm.addEventListener("submit", handleSubmit)