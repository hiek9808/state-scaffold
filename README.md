# [Nombre de tu Librería: Ej. ComposeStateScaffold] 🚀

Una librería ligera de Kotlin para Jetpack Compose que gestiona automáticamente los estados de UI (Loading, Error, Empty, Success) con animaciones suaves.

![Kotlin](https://img.shields.io/badge/kotlin-2.0-blue.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Ready-green.svg)
[Aquí iría el badge de Jitpack más tarde]

## 📸 Demo

*(Añade aquí un GIF mostrando la transición de Loading -> Success)*

## ✨ Características

* **Type-Safe:** Usa `Sealed Interfaces` y Generics `<T>`.
* **Animaciones Automáticas:** Transiciones suaves usando `Crossfade`.
* **Plug & Play:** Componentes de carga y error por defecto incluidos.
* **Personalizable:** Puedes reemplazar cualquier vista (loading, error, empty) con tus propios Composables.

## 🛠 Instalación

Añade el repositorio JitPack en tu archivo `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven { url = uri("[https://jitpack.io](https://jitpack.io)") }
    }
}