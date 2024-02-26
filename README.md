# My City

My City is the test project of the fourth unit of the *Android Basics with Compose* learning path, provided by Android Developers. It is focused on building the view model layer of the application for retaining the business logic, navigating between different screens, and implementing adaptive layouts depending on the app's device size is running onto, everything with Jetpack Compose. The application focuses on the city of Rimini, which is the place where I generally spend my holidays, and provides a guide for the city exploration, including where to find restaurants, entertainment spots, and so on.

The project demonstrates the ability to separate the view model layer from the UI one and to implement navigation between different screens. Moreover, it demonstrates the ability to differentiate the layout based on the device size of the user. The main topics covered in this project are listed below:

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) layer of the app, retaining business logic and responding to events
* [Navigation](https://developer.android.com/jetpack/compose/navigation) for going back and forth between different screens of the app
* [Composables Lifecycle](https://developer.android.com/jetpack/compose/lifecycle), to understand how the recomposition of the UI part works
* [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle) to understand all the lifecycle steps that an activity performs
* [Adaptive Layouts](https://developer.android.com/jetpack/compose/layouts/adaptive) to build different layout configurations according to the device size

The project comprises four screens whose layout is developed through Jetpack Compose. The theme has been selected and created with the help of [Material Design 3 Theme Builder](https://m3.material.io/theme-builder#/custom).

Visit the [Wiki](https://github.com/PaoloCaldera-jetpackCompose/myCity/wiki) to see the application screens.


## Getting Started

To clone the repository, use the command
```
$ git clone https://github.com/PaoloCaldera-jetpackCompose/myCity.git
```
or the `Get from VCS` option inside Android Studio by copying the link above.

Then, run the application on an Android device or emulator. The application is compiled with API 34, thus use a device or emulator supporting such API version.

## License

My City is a public project that can be downloaded and modified under the terms and conditions of the [MIT License](LICENSE).
