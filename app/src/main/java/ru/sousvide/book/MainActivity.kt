package ru.sousvide.book
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { SousVideApp() } }
    }
}
@Composable
fun SousVideApp() {
    var tab by remember { mutableIntStateOf(0) }
    var recipe by remember { mutableStateOf<DemoRecipe?>(null) }
    Scaffold(
        topBar = { Surface(shadowElevation = 2.dp) { Text("СУ-ВИД · Книга рецептов", modifier = Modifier.fillMaxWidth().padding(20.dp), style = MaterialTheme.typography.titleLarge) } },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = tab == 0, onClick = { tab = 0; recipe = null }, icon = { Text("📖") }, label = { Text("Каталог") })
                NavigationBarItem(selected = tab == 1, onClick = { tab = 1; recipe = null }, icon = { Text("🌡️") }, label = { Text("Калькулятор") })
                NavigationBarItem(selected = tab == 2, onClick = { tab = 2; recipe = null }, icon = { Text("ℹ️") }, label = { Text("О проекте") })
            }
        }
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            when {
                recipe != null -> {
                    Button(onClick = { recipe = null }) { Text("Назад") }
                    Text(recipe!!.symbol, style = MaterialTheme.typography.displayLarge)
                    Text(recipe!!.name, style = MaterialTheme.typography.headlineMedium)
                    Text(recipe!!.description)
                    SafetyNotice()
                }
                tab == 0 -> {
                    Text("Что приготовим?", style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.height(16.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(RecipeRepository.examples) { item ->
                            Card(onClick = { recipe = item }) {
                                Text("${item.symbol}   ${item.name}", modifier = Modifier.fillMaxWidth().padding(20.dp), style = MaterialTheme.typography.titleMedium)
                            }
                        }
                        item { SafetyNotice() }
                    }
                }
                tab == 1 -> CalculatorDemo()
                else -> {
                    Text("Версия 0.1 — демонстрационный прототип.", style = MaterialTheme.typography.titleMedium)
                    Text("Рецепты и иллюстрации добавим после проверки источников.")
                    SafetyNotice()
                }
            }
        }
    }
}
@Composable
fun CalculatorDemo() {
    var temperature by remember { mutableFloatStateOf(60f) }
    var minutes by remember { mutableFloatStateOf(120f) }
    Text("Калькулятор (макет)", style = MaterialTheme.typography.headlineMedium)
    Text("Температура: ${temperature.roundToInt()} °C")
    Slider(value = temperature, onValueChange = { temperature = it }, valueRange = 45f..90f)
    Text("Время: ${minutes.roundToInt()} минут")
    Slider(value = minutes, onValueChange = { minutes = it }, valueRange = 30f..360f)
    Text("Иллюстрации степени готовности появятся в следующих версиях.")
    SafetyNotice()
}
@Composable
fun SafetyNotice() {
    Spacer(Modifier.height(16.dp))
    Text("⚠️ Это демонстрация интерфейса. Температуры и время не проверены и не являются инструкцией по безопасному приготовлению пищи.")
}
