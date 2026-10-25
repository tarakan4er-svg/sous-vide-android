# Sous-Vide — Android

Технический прототип приложения «Су-вид: рецепты» (версия 0.1).

**Стек:** Kotlin, Jetpack Compose, Android Gradle Plugin 8.7.3, Gradle 8.9, JDK 17, compileSdk 35.

- 📖 Каталог демонстрационных карточек продуктов.
- 🌡️ Экран ползунков времени и температуры (без готовых режимов приготовления).
- ⚠️ Демонстрационные значения нельзя использовать как инструкции по приготовлению.
- 🛠️ GitHub Actions запускает тесты и собирает debug APK при push в main.

Подробности: [план продукта](docs/PRODUCT_SPEC_RU.md) и [настройка сборки](docs/SETUP_RU.md).

```sh
gradle :app:testDebugUnitTest :app:assembleDebug
```

APK после сборки: `app/build/outputs/apk/debug/app-debug.apk`.
