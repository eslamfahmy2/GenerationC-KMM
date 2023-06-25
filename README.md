# GenerationC-KMM
The purpose of the Kotlin Multiplatform technology is unifying the development of applications 
with common logic for Android and iOS platforms. 
To make this possible, it uses a mobile-specific structure of Kotlin Multiplatform projects.


# Overview
demo base app adaptes KMM -Kotlin Multile platform- with a shared bussiess -in Koltin-,
that can be shared with IOS , and only adapte the native UI elements -Compose-android- -SwiftUI-IOS, 
align with android best practices in clean articulate,
MVVM, Compose , Testing , Navigator, Hilt, Navigation, Single Activity, Material Theme .

# Use Case

 use case :  search int list -cars- thats load data from local file data source that

# Technologies

The project attempt to adapt best practices in android development flowing SOILD principles wih,
lates modern Android tools and frameworks such as Kotlin, Jetpack Compose, Coroutines, Flow, Hilt,
Clean code, Navigation ,KMM
employs automatic state and error handling and wrappers to handle calls


# Project Structure
The root project is a Gradle project that holds the shared module 
and the Android application as its subprojects.
They are linked together via the Gradle multi-project mechanism.

androidApp:- It contains native android project files. It has it’s own manifest 
, gradle files and other native files just like we have in our native application.
We can write our complete native code for Android in this folder.
For eg :- add your dependencies in gradle file of this folder, 
declare your activities, permissions in manifest file,
our complete UI for Android application etc.

iosApp :- This folder is similar to our androidApp folder it contains native code for our iOS Application.
We can have our pod file, permissions in info.plist and complete UI for iOS Application etc in this folder.

shared :- This is where KMM comes into picture. It contains our actual business logic which will be shared between our iOS and Android applications.

#Android App 

in android app part  uses a MVVM architecture, data is obtained form local data source, 
as the needed data is retrieved fresh from the file system,that contained in separate Data layer,
Business logic and use cases are placed in a separate Domain,
View Models are used to communicate with the UI layer,
which is primarily written with the Compose framework.

#Structure

adapting a Clean architecture. All UI related code can be found in the ".presentation"
package and is subdivided into packages according to view
".domain" package contains systems models , repositories, mappers..
".data" pancake contains implementation of data source "Retorfit" and date transfer objects. 

adapting MVVM as main beavioual design pattern , align with singlton object for as creations desin 


![seach](https://github.com/eslamfahmy2/GenerationC/assets/74387512/b8dca797-622e-40f3-9df2-ed9f11f94cad)


![details](https://github.com/eslamfahmy2/GenerationC/assets/74387512/fd9a7cc0-74c9-4c03-9f88-8278cdbbe9bd)


