# 📱 Gemography Coding Challenge

<div align="center">

# 📱 GitHub Trending Repos Fetcher

<p>
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=flat&logo=android&logoColor=white" alt="Platform">
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white" alt="Language">
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=flat&logo=jetpackcompose&logoColor=white" alt="UI">
  <img src="https://img.shields.io/badge/Architecture-MVVM-6DB33F?style=flat" alt="Architecture">
  <img src="https://img.shields.io/badge/Pagination-Paging%203-FF8800?style=flat" alt="Pagination">
</p>

A modern native Android application built as part of the Gemography mobile coding challenge.<br>
It showcases trending GitHub repositories created over the last 30 days.

</div>

---

## 🚀 About the Project

This project fetches and displays the most starred GitHub repositories created in the last month.<br>
It is built from the ground up using modern Android development stack and best practices.

---

## 🛠️ Tech Stack & Libraries

* **Language:** [Kotlin](https://kotlinlang.org/) — 100% concise and safe codebase.
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) — Declarative UI framework for building native interfaces.
* **Architecture:** **MVVM (Model-View-ViewModel)** pattern with unidirectional data flow.
* **Concurrency:** [Kotlin Coroutines & Flow](https://kotlinlang.org/docs/coroutines-guide.html) — For asynchronous operations and reactive stream handling.
* **Pagination:** [Paging 3 Library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) — Efficient, incremental data loading from the API.
* **Networking:** [Retrofit](https://square.github.io/retrofit/) — Type-safe HTTP client for REST API integration.

---

## 🏛️ Architecture & Design Pattern

The application follows the **MVVM (Model-View-ViewModel)** architectural pattern.<br>
This ensures a clear separation of concerns, testability, and scalability:

* **View (Compose UI):** 
  * Observes state from the ViewModel and renders the UI declaratively.
  * It remains completely stateless regarding business logic.
* **ViewModel:** 
  * Manages UI-related state, handles configuration changes.
  * Communicates with data sources via Kotlin Coroutines.
  * Exposes immutable `StateFlow` / `LazyPagingItems`.
* **Repository:**
  * Acts as a single source of truth.
  * Abstracts data sources (Network API via Retrofit) from the rest of the application.

---

## ✨ Key Features

* **Trending Repositories Feed:**
  * Displays repositories created over the last 30 days sorted by stars.
    
* **Seamless Pagination:**
  * Implements infinite scrolling using Paging 3.
  * Loads data smoothly page by page without overloading memory or network.
    
* **Rich Repository Details:** Each item shows key repository insights including:
  * Repository Name & Description.
  * Star Count & Fork Count.
  * Owner Avatar and Username.
  * Primary Programming Language.
    
* **Error Handling & Loading States:**
  * Graceful handling of loading indicators, empty states, and network failures with retry options.
    
* **Material 3 Design:** 
  * Styled with modern Material Design principles for a sleek user experience.

---

## How to get the data from Github

To get the most starred Github repos created in the last 30 days (relative to 2017-11-22).<br>
You'll need to call the following endpoint:<br>

https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc

The JSON data from Github will be paginated (you'll receive around 100 repos per JSON page).<br>
To get the 2nd page, you add &page=2 to the end of your API request:<br>

https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page=2

To get the 3rd page, you add &page=3 ... etc.

Check out the [GitHub API Documentation](https://docs.github.com/en/rest) for details on trending endpoint parameters.

---

## 📸 Screenshots

<div align="center">

| Mock-up | Live Demo |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/2dcc56b7-fba4-467b-9108-90ee559f11ca" width="280" alt="Mock-up" /> | <img src="https://github.com/user-attachments/assets/bf960dfe-4cff-46f5-a764-5abb262b6033" width="280" alt="Demo" /> |
| <sub><i>Figure 1: UI Mock-up</i></sub> | <sub><i>Figure 2: Live App Demo</i></sub> |

</div>

---

## ⚙️ Getting Started

To get a local copy up and running, follow these simple steps:

### Prerequisites
* **Android Studio** (Panda or newer recommended)
* **JDK 17** or higher
* Android SDK (API level 24 or higher)

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/mhq93/Github-Repos-Fetcher.git
