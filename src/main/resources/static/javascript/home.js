const allCocktailsContainer = document.getElementById("all-cocktails-container")
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/cocktails/"

async function getAllCocktails() {
  try {
    const response = await fetch(`${baseUrl}allCocktails`, {
      method: "GET",
      headers: headers
    });

    const data = await response.json();
    localStorage.setItem('recipes', JSON.stringify(data)); // Store recipes in local storage

    createRecipeCards(data); // Display the recipes
  } catch (error) {
    console.error(error);
  }
}

const isLoggedIn = (userId) => {
  return userId !== null && userId !== undefined;
};

 const createRecipeCards = (array, isLoggedIn) => {
        allCocktailsContainer.innerHTML = ''
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
                    </div>
                </div>
            </div>
            `
            allCocktailsContainer.append(recipeCard);
        })
    }

    async function addToFavorites(cocktailId, userId) {
      await fetch(`${baseUrl}user/{userId}/cocktail/{cocktailId}`, {
         method: "POST",
                     body: JSON.stringify(obj),
                     headers: headers
                 })
                     .catch(err => console.error(err.message))
                 if (response.status == 200) {
                     return getFavorites(userId);
                 }
      console.log('Adding cocktail with ID ' + cocktailId + ' to favorites');
    }

    getAllCocktails();