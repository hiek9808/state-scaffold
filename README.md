# ComposeStateScaffold

A lightweight Kotlin library for Jetpack Compose that automatically manages UI states(Loading, Error, Empty, Success) with smooth animations.

![Kotlin](https://img.shields.io/badge/kotlin-2.0-blue.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Ready-green.svg)
[![](https://jitpack.io/v/hiek9808/state-scaffold.svg)](https://jitpack.io/#hiek9808/state-scaffold)

## Demo
![ezgif-6bab901e92ab0198](https://github.com/user-attachments/assets/a1ed6679-8a10-4df0-8ac9-8f5e4cb02d08)

## Features

* **Type-Safe:** Uses `sealed interfaces` and generics `<T>`.
* **Automatic Animations:** Smooth transitions using `Crossfade`.
* **Plug & Play:** Built-in default loading and error composables.
* **Customizable:** Replace loading, error, or empty views with your own UI.

## Installation

Add JitPack to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Then add the dependency in `build.gradle.kts`:
```kotlin
dependencies {
    implementation("com.github.hiek9808:state-scaffold:1.0.0")
}
```

## Basic Use
1. Wrap your data in UiState:

```kotlin
val uiState: StateFlow<UiState<User>> = viewModel.state

```
2. Use StateLayout in your Composable:

```kotlin
val state by viewModel.uiState.collectAsState()

StateLayout(
    state = state
) { user ->
    // This block only executes when it's Success.
    UserProfile(user)
}
```
## Advanced Customization
You can inject your own views:

```kotlin

StateLayout(
    state = state,
    loadingContent = { MyCustomSpinner() },
    errorContent = { errorMsg -> MyErrorScreen(errorMsg) }
) { data ->
    Content(data)
}
```

## MIT License

```
Copyright (c) 2025 hiek9808

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
