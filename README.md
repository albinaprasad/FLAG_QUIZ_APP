🌍 Flag Quiz App
A fun and interactive Android application developed in Kotlin that challenges your knowledge of world flags. This app is built with a strong emphasis on modern Android architectural patterns and efficient local data management.

✨ Features
Interactive Quizzes: Engage in multiple-choice quizzes to identify flags from various countries.

Persistent Data Storage: All quiz questions, flag images, and user progress (e.g., scores) are securely stored and managed locally.

User-Friendly Interface: A clean and intuitive design for an enjoyable quizzing experience.

(Optional: Add more features if applicable, e.g., Difficulty Levels, Categories, High Score tracking, etc.)

🚀 Technical Stack & Architecture
This project is engineered to demonstrate best practices in modern Android development, leveraging the following technologies and architectural principles:

Kotlin: The primary programming language, chosen for its conciseness, null safety, and modern features, ensuring robust and maintainable code.

MVVM (Model-View-ViewModel) Architecture:

Model: Represents the data layer, including Flag entities, quiz questions, and a data repository responsible for abstracting data sources (e.g., Room Database).

View: Android UI components (Activities and Fragments) that display the user interface, observe LiveData from the ViewModel, and dispatch user actions.

ViewModel: Acts as a bridge between the Model and View. It exposes data streams to the UI via LiveData, handles UI-related logic, and manages asynchronous operations, ensuring the View is decoupled from business logic and lifecycle-aware.

Room Persistence Library: An abstraction layer over SQLite, part of Android Jetpack. It's used for:

Robust Local Data Storage: Efficiently stores structured data like flag details, quiz questions, and user scores.

Compile-time SQL Validation: Reduces runtime errors by validating SQL queries at compile time.

LiveData Integration: Seamlessly integrates with LiveData for reactive UI updates.

Android Jetpack Components: Utilizing various Jetpack libraries for modern development (e.g., Navigation Component for app flow, LiveData for observable data).

(Optional: Add other libraries you used, e.g., Coroutines for asynchronous operations, Glide/Coil for image loading, Hilt/Dagger for Dependency Injection)

📸 Screenshots
Here are some screenshots showcasing the app's interface:

<!-- Replace these with actual image links to your screenshots.
Upload your images to a folder like assets/screenshots/ in your repo
and use relative paths like: ![Home Screen](assets/screenshots/home_screen.png)
-->

🛠️ Setup and Installation
To get a local copy up and running, follow these simple steps:

Clone the repository:

git clone https://github.com/albinaprasad/FLAG_QUIZ_APP.git

Open in Android Studio:

Launch Android Studio.

Select Open an existing Android Studio project and navigate to the cloned FLAG_QUIZ_APP directory.

Sync Gradle:

Allow Android Studio to sync the Gradle files. If prompted, update Gradle or Kotlin plugins.

Run on a device or emulator:

Connect an Android device or start an emulator.

Click the Run button (green triangle) in Android Studio to build and install the app.

.
<img width="332" height="772" alt="Screenshot_20250707_144534" src="https://github.com/user-attachments/assets/1cacdc8b-c3fa-435e-a607-a5d5133a786a" />
<img width="332" height="772" alt="Screenshot_20250707_143637" src="https://github.com/user-attachments/assets/11b84a68-00cc-4fcc-a7e1-3f6d7344461d" />
<img width="332" height="772" alt="Screenshot_20250707_143625" src="https://github.com/user-attachments/assets/c4655ddb-4cb7-4dac-adff-710fb796cbc7" />
<img width="332" height="772" alt="Screenshot_20250707_143613" src="https://github.com/user-attachments/assets/f432140a-aef1-48a4-8f4b-5446e2ca8ab2" />
<img width="332" height="772" alt="Screenshot_20250707_143601" src="https://github.com/user-attachments/assets/954b1c07-f6e3-4c87-ae7c-f2bee88cd266" />
<img width="332" height="772" alt="Screenshot_20250707_143454" src="https://github.com/user-attachments/assets/76249598-a3d1-4549-b0f1-308018181550" />

