# cdl-exercise
Interview exercise for Cat Digital Labs

## Architecture
This project is intended to follow the principles of Clean Architecture for the overall structure while using MVVM architecture for the presentation layer. It will consist of three separate modules:

- **App module**: UI presentation and logic (MVVM)
- **Domain module**: Business logic and models
- **Data module**: External data retrieval and persistence

## Libraries
A tentative list of libraries to be used. Some of these may be rather overkill given the scope of this project.

- **ViewModel**: Store and manage UI-related data
- **LiveData**: Observable data holder class used to connect Views to ViewModels
- **Retrofit**: HTTP client to ease retrieving data from the web
- **Moshi**: JSON parsing
- **Coil**: Image loading
- **Room**: Data persistence using SQLite
- **Navigation**: App navigation
- **Hilt/Dagger**: Dependency injection
- **Espresso**: Testing UI
- **Robolectric**: Testing Android environment without emulator overhead
- **MockWebServer**: Testing HTTP clients
- **Mockito**: Mocking framework to simplify testing

