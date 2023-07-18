const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const submitForm = document.getElementById("cocktail-form")
const cocktailContainer = document.getElementById("cocktail-container")

const cocktailName = document.getElementById("cocktail-name")
const ingredients = document.getElementById("ingredients")
const cocktailGlass = document.getElementById("cocktail-glass")
const directions = document.getElementById("directions")
const cocktailImg = document.getElementById("cocktail-imgURL")

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/cocktails/"

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        cocktailName: cocktailName.value,
        ingredients: ingredients.value,
        cocktailGlass: document.getElementById("cocktail-glass").value,
        directions: directions.value,
        cocktailImg: document.getElementById("cocktail-imgURL").value
    }

     await addCocktail(bodyObj);

        cocktailName.value = '',
        ingredients.value = '',
        cocktailGlass.value = '',
        directions.value = '',
        cocktailImg.value = ''
    }

    async function addCocktail(obj) {
        const response = await fetch(`${baseUrl}user/${userId}`, {
            method: "POST",
            body: JSON.stringify(obj),
            headers: headers
        })
            .catch(err => console.error(err.message))
        if (response.status == 200) {
            return getCocktails(userId);
        }
    }

    async function getCocktails(userId) {
        await fetch(`${baseUrl}user/${userId}`, {
            method: "GET",
            headers: headers
        })
            .then(response => response.json())
            .then(data => createRecipeCards(data))
            .catch(err => console.error(err))
    }

    async function handleDelete(cocktailId){
        await fetch(baseUrl + cocktailId, {
            method: "DELETE",
            headers: headers
        })
            .catch(err => console.error(err))

        return getCocktails(userId);
    }

    const createRecipeCards = (array) => {
        cocktailContainer.innerHTML = ''
        array.forEach(obj => {
            let recipeCard = document.createElement("div")
            recipeCard.classList.add("m-2")
            recipeCard.innerHTML = `
                <div class="card d-flex" style="width: 40rem; height: 40rem;">
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                        <p class="card-text">${obj.cocktailName}</p>
                        <p class="card-text">${obj.cocktailGlass}</p>
                        <p class="card-text">${obj.directions}</p>
                        <div class="d-flex justify-content-between">
                            <button class="btn btn-danger" onclick="handleDelete(${obj.cocktail_id})">Delete</button>
                            <button onclick="getCocktailById(${obj.id})" type="button" class="btn btn-primary"
                            data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                            Edit
                            </button>
                        </div>
                    </div>
                </div>
            `
            cocktailContainer.append(recipeCard);
        })
    }

    function handleLogout(){
        let c = document.cookie.split(";");
        for(let i in c){
            document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
        }
}

const populateModal = (obj) =>{
    noteBody.innerText = ''
    noteBody.innerText = obj.body
    updateNoteBtn.setAttribute('data-cocktail-id', obj.id)
}

getCocktails(userId);

submitForm.addEventListener("submit", handleSubmit)



