<h1 align="center">Movie Addicts</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
 </p>
 
 A simple project to demonstrate an approach based on MVI + Clean architecture and modularization based on features and layers
 
 
 [![Movie Addicts](https://img.youtube.com/vi/0wV9Mmp7_Ik/maxresdefault.jpg)](https://youtu.be/0wV9Mmp7_Ik)
 
 ## Tech stack & Open-source libraries
 - Minimum SDK level 23
 - 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
 - JetPack
   - LiveData - notify domain layer data to views.
   - Lifecycle - dispose observing data when lifecycle state changes.
   - ViewModel - UI related data holder, lifecycle aware.
 - Architecture
   - Modularization by features and Layers
   - MVI UI Architecture ( Event + State + Effect)
   - Clean architecture approach with repository pattern
   - Dagger 2 - dependency injection
 - UI
    - DataBinding - Android DataBinding kit for notifying data changes to UI layers.
    - Material Design Components
    - Design based on Constraint Layout
    - Ripple animation, Shared element transition
 - Persistence
    - [Retrofit2 & Moshi](https://github.com/square/retrofit) - constructing the REST API
    - [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging and mocking web server
    - [Glide](https://github.com/bumptech/glide) - loading images
    - [ObjectBox](https://github.com/objectbox) - The superfast NoSQL database for implementing a local cache layer.
    - Cloud Firestore - To persist users' favorite movies.
    - Firebase Auth - To authenticate users
    
 ## Screenshots
 
 ### Login
 
 <img width="250px" align="left" src="./screenshots/capture_1.png" />
 <img width="250px" src="./screenshots/capture_2.png" />
 
 ### Movies
 <img width="250px" align="left" src="./screenshots/capture_3.png" />
 <img width="250px" align="left" src="./screenshots/capture_4.png" />
 <img width="250px" align="left" src="./screenshots/capture_5.png" />
 <img width="250px" src="./screenshots/capture_6.png" />
 
### Tv Series
<img width="250px" align="left" src="./screenshots/capture_7.png" />
<img width="250px" align="left" src="./screenshots/capture_8.png" />
<img width="250px" align="left" src="./screenshots/capture_9.png" />
<img width="250px" align="left" src="./screenshots/capture_12.png" />
<img width="250px" src="./screenshots/capture_13.png" />

### Stars
<img width="250px" align="left" src="./screenshots/capture_10.png" />
<img width="250px" src="./screenshots/capture_11.png" />


 ## MAD Score
<img src="./mad_scorecard/summary.png" />
<img src="./mad_scorecard/kotlin.png" />
<img src="./mad_scorecard/studio.png" />
<img src="./mad_scorecard/jetpack.png" />
 
