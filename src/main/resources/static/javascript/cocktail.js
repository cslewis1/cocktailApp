const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const submitForm = document.getElementById("cocktail-form")
const cocktailContainer = document.getElementById("cocktail-container")

const cocktailName = document.getElementById("cocktail-name")
const ingredients = document.getElementById("ingredients")
const glassType = document.getElementById("glassType")
const directions = document.getElementById("directions")
const imgURL = document.getElementById("imgURL")

let editCocktailName = document.getElementById("edit-cocktailName")
let editGlassType = document.getElementById("edit-glassType")
let editIngredients = document.getElementById("edit-ingredients")
let editDirections = document.getElementById("edit-directions")
let editImgURL = document.getElementById("edit-imgURL")
let updateCocktailBtn = document.getElementById('update-cocktail-button')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/cocktails/"

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        cocktailName: cocktailName.value,
        ingredients: ingredients.value,
        glassType: glassType.value,
        directions: directions.value,
        imgURL: imgURL.value
    }

     await addCocktail(bodyObj);

        cocktailName.value = '',
        ingredients.value = '',
        glassType.value = '',
        directions.value = '',
        imgURL.value = ''
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

    async function getCocktailById(cocktailId){
        await fetch(baseUrl + cocktailId, {
            method: "GET",
            headers: headers
        })
            .then(res => res.json())
            .then(data => populateModal(data))
            .catch(err => console.error(err.message))
    }

    async function handleCocktailEdit(cocktailId){
        let bodyObj = {
            cocktail_id: cocktailId,
            cocktailName: editCocktailName.value,
            ingredients: editIngredients.value,
            glassType: editGlassType.value,
            directions: editDirections.value,
            imgURL: editImgURL.value
        }

        await fetch(baseUrl, {
            method: "PUT",
            body: JSON.stringify(bodyObj),
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
                <div class="card d-flex flex-row" style="width: 100%; height: available;">
                    <div class="card d-flex" style="width: 30%; height: 100%;">
                        <img src=${obj.imgURL}, class="img-fluid" alt="cocktail shaker">
                    </div>
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                         <h2 class="card-title" id="cocktailName">${obj.cocktailName}</h2><br>
                         <h4 class="card-title" id="glassType">Cocktail Glass</h4>
                         <p class="card-text">${obj.glassType}</p>
                         <h4 class="text-title" id="ingredients">Ingredients</h4>
                         <p class="card-text">${obj.ingredients}</p>
                         <h4 class="text-title" id="directions">Directions</h4>
                         <p class="card-text">${obj.directions}</p>
                        <div class="d-flex justify-content-between">
                            <button class="btn btn-danger" onclick="handleDelete(${obj.cocktail_id})">Delete</button>
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

    editCocktailName.textContent = ''
    editCocktailName.textContent = obj.cocktail_Name,

    editIngredients.textContent = ''
    editIngredients.textContent = obj.ingredients,

    editGlassType.textContent = ''
    editGlassType.textContent = obj.glass_Type,

    editDirections.textContent = ''
    editDirections.textContent = obj.directions,

    editImgURL.textContent = ''
    editImgURL.textContent = obj.img_URL

    updateCocktailBtn.setAttribute('data-cocktail-id', obj.cocktailId)
}

getCocktails(userId);

submitForm.addEventListener("submit", handleSubmit)

updateCocktailBtn.addEventListener("click", (e)=>{
    let cocktailId = e.target.getAttribute('data-cocktail-id')
    handleCocktailEdit(cocktailId);
})


