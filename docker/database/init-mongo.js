db.auth('root', 'password')

db.createUser(
    {
        user: "sessionsdev",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "lightning_recipes"
            }
        ]
    }
)

db.lightning_recipes.insert({
    name: "test recipe",
    ingredientNumber: 4
})