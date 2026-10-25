package ru.sousvide.book
import org.junit.Assert.*
import org.junit.Test
class RecipeRepositoryTest {
    @Test fun uniqueIds() {
        val ids = RecipeRepository.examples.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
    }
    @Test fun demonstrationOnly() {
        assertFalse(RecipeRepository.examples.isEmpty())
        assertTrue(RecipeRepository.validatedRecipes().isEmpty())
    }
}
