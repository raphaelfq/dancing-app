# Ballet Para Todos

A ballet encyclopedia Android application that serves as a comprehensive reference for ballet movements and positions. The app includes 43 pre-loaded ballet movements (grades 1 through 4) and 5 classical ballet positions, each with detailed descriptions, methodical instructions, related skills, and child-friendly explanations. Users can also contribute new movements through a community upload feature backed by Firebase.

## Screenshots

<!-- Add screenshots here -->
| Home | Movement Detail | Search | Upload |
|------|-----------------|--------|--------|
| _screenshot_ | _screenshot_ | _screenshot_ | _screenshot_ |

## Features

- **Movement Encyclopedia** -- 43 ballet movements organized by grade (1-4) and complexity, each with official name, synonyms, translations, detailed description, methodical instructions, related skills, and a simplified explanation for children.
- **Position Reference** -- All 5 classical ballet positions with the same depth of information as movements.
- **Search with Debounce** -- Generic, reusable search powered by a `SearchViewModel<T: Searchable>` with 500ms debounce. Matches against official names, synonyms, and common typos.
- **Movement Detail Screen** -- Expandable sections for detailed description, media (video via ExoPlayer, images), and child-friendly ("ludic") explanation. Includes audio pronunciation playback.
- **Community Upload** -- Users can contribute new movements with a name, description, and optional image. Uploads are stored in Firebase Firestore (document data) and Firebase Storage (images).
- **Navigation Drawer** -- Material Design 3 modal navigation drawer with sections for Positions, Movements, About Us, and Upload.
- **Video Playback** -- Embedded video player using Media3 ExoPlayer for movement demonstrations.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI Framework | Jetpack Compose with Material Design 3 |
| Navigation | Jetpack Navigation Compose |
| Architecture | ViewModel + StateFlow (reactive search) |
| Backend | Firebase (Firestore, Storage, Auth, Analytics) |
| Media | Media3 ExoPlayer (video), MediaPlayer (audio) |
| Image Loading | Coil Compose |
| Auth | Google Play Services Auth + Firebase Auth |
| Build System | Gradle (Kotlin DSL) with Version Catalogs |
| Min SDK | 24 (Android 7.0) |
| Target SDK | 34 (Android 14) |

## Project Structure

```
app/src/main/java/com/example/dancingwikiapp/
|-- MainActivity.kt                 # Entry point, custom theme, Firebase init
|-- NavDrawerScreen.kt              # Main screen with modal drawer and navigation graph
|-- NavDrawerItem.kt                # Navigation item data class
|-- Movement.kt                     # Movement data class + all 43 pre-loaded movements
|-- Positions.kt                    # Position data class + all 5 positions
|-- Searchable.kt                   # Generic Searchable interface
|-- SearchViewModel.kt              # Generic ViewModel with debounced search
|-- MovementsSearchScreen.kt        # Search screen for movements
|-- PositionsSearchScreen.kt        # Search screen for positions
|-- MovementScreenBeauty.kt         # Movement detail card (description, media, audio)
|-- PositionScreenBeauty.kt         # Position detail card
|-- UploadMovementScreen.kt         # Community upload form (Firestore + Storage)
|-- AboutUs.kt                      # About Us screen
|-- FirebaseInitialExperiment.kt    # Firebase experimentation utilities
|-- newuimovement/
|   |-- MovementDetail.kt           # Alternative movement detail screen
|-- ui/theme/
    |-- Color.kt, Theme.kt, Type.kt # Material 3 theming
```

## Prerequisites

- **Android Studio** Hedgehog (2023.1.1) or newer
- **JDK 8** or higher
- A **Firebase project** with Firestore, Storage, and Authentication enabled
- An Android device or emulator running **API 24+**

## Firebase Setup

1. Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project (or use an existing one).
2. Register an Android app with the package name `com.example.dancingwikiapp`.
3. Download the generated `google-services.json` file and place it in the `app/` directory.
4. In the Firebase Console, enable the following services:
   - **Firestore Database** -- create a database (start in test mode for development).
   - **Storage** -- enable Cloud Storage.
   - **Authentication** -- enable Google sign-in or anonymous auth as needed.
5. The app will initialize Firebase automatically on launch via `FirebaseApp.initializeApp()`.

## Build and Run

```bash
# Clone the repository
git clone https://github.com/raphaelfq/dancing-app.git
cd dancing-app

# Make sure google-services.json is in app/

# Build and run via Gradle
./gradlew assembleDebug

# Or open in Android Studio and run on a connected device/emulator
```

## Roadmap and Known Limitations

- Movement data is currently hardcoded in `Movement.kt`. A future iteration could load all content from Firestore for easier updates.
- Audio pronunciation is only available for a single movement (Plie). Expanding audio coverage to all movements is planned.
- Video playback currently uses a bundled resource rather than streaming from Firebase Storage.
- The upload feature does not yet include authentication or moderation for community contributions.
- Image assets for individual movements and positions are placeholder/generic.
- No offline caching or Room database -- the app requires an internet connection for upload and Firebase features.
- UI text is in Portuguese (Brazilian). Internationalization (i18n) support could be added.

## Author

**Raphael Quintanilha** -- [github.com/raphaelfq](https://github.com/raphaelfq)

## License

This project is not currently published under a specific open-source license. Contact the author for usage permissions.
