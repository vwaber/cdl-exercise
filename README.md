# cdl-exercise
This project is the result of an interview coding exercise for Cat Digital Labs. It's far from perfect, and a bit incomplete, but I think it's a fair representation of my potential.

## Architecture
This project is intended to follow the principles of clean architecture for the overall structure while using MVVM architecture for the presentation layer. It consists of three separate modules:

- **App module**: UI presentation and logic (MVVM)
- **Core module**: Business logic and models
- **Data module**: External data retrieval and persistence

## Third-Party Libraries

- **Retrofit**: HTTP API consumption
- **Moshi**: JSON parsing used in conjunction with Retrofit
