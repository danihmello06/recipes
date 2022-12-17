package danihmello.tcc.recipes.api

class RecipeResponse(
    val author: String,
    val image_url: String,
    val prepare_time: String,
    val serves: String,
    val slug: String,
    val steps: List<StepsResponse>,
    val title: String
)

class StepsResponse(
    val ingredients: List<String>,
    val preparation: String,
    val title: String
)
