package ru.sousvide.book
data class DemoRecipe(val id: String, val name: String, val symbol: String, val description: String, val validated: Boolean = false)
object RecipeRepository {
    val examples = listOf(
        DemoRecipe("beef", "Стейк из говядины", "🥩", "Вид разреза и степень готовности"),
        DemoRecipe("pork", "Свиная вырезка", "🍖", "Текстура и последующая обжарка"),
        DemoRecipe("chicken", "Куриная грудка", "🍗", "Нагрев и пастеризация"),
        DemoRecipe("salmon", "Филе лосося", "🐟", "Деликатный нагрев"),
        DemoRecipe("carrot", "Морковь", "🥕", "Мягкость и сохранение формы")
    )
    fun validatedRecipes() = examples.filter { it.validated }
}
