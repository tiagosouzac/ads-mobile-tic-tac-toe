# ❌⭕ Tic-Tac-Toe Android App

A sleek and interactive Tic-Tac-Toe application developed for Android as a technical challenge. It features a modern dark mode user interface with precise game logic to handle states, turns, and real-time score tracking.

## 🚀 Features

* **3x3 Grid Layout:** Organized gameplay constructed with a `GridLayout` containing tappable buttons.
* **Turn Management:** Players alternate turns ("X" and "O"), with the system always enforcing that "X" plays first after a restart.
* **Match Status Display:** A central display clearly indicates whose turn it is, who won, or if the game ended in a draw.
* **Automated Rules Logic:** Instantly checks for horizontal, vertical, or diagonal victory conditions, as well as a draw when all cells are filled.
* **Input Blocking:** Robust logic to ensure that an already played cell cannot be clicked or overwritten.
* **Game Over Lock:** Disables interactions on the grid immediately after a win or draw is detected.
* **Restart Feature:** Quickly reset the entire grid and game status with a dedicated "Restart Game" button without resetting the scores.

## ⭐ Extra Challenges Implemented

* **Persistent Scoreboard:** Tracks and dynamically updates the total number of Wins for X, Wins for O, and Draws during the current play session.
* **Winning Cell Highlight:** Applies a stylish green background tint to the specific three winning cells on the board, offering clear and clear visual feedback for the victory.

## 🛠️ Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Layout:** `LinearLayout` + `GridLayout`
* **Components:** Android standard Views (`TextView`, `AppCompatButton`) customized with XML drawables.
* **Styling:** Custom XML shapes (`grid_bg.xml` and `btn_bg.xml`) to simulate rounded corners inside a cohesive "Dark Theme" color palette.

## 📥 How to Run

1. **Clone the repository:**
```bash
git clone git@github.com:tiagosouzac/ads-mobile-tic-tac-toe.git
```

2. **Open in Android Studio:**
   * Go to `File > Open` and select the project folder.

3. **Sync Gradle:**
   * Wait for the project to sync and configure dependencies automatically.

4. **Run the app:**
   * Select a Virtual Emulator or plug in a physical device and click the **Run** button (green play icon).

## 📝 Implementation Details

### Game State Verification Matrices
The logic checks the board state dynamically by reading every text applied to the grid buttons and organizing them in a 2D Array mapping rows and columns.
Victory conditions sequentially cover bounds:
1. Validating 3 straight rows.
2. Validating 3 straight columns.
3. Hand-verifying both diagonals.

### View Stylization Updates
We avoided simple base colors in favor of customized `ColorStateList` and `BackgroundResource` manipulations (`R.drawable.btn_bg`), preserving the aesthetics of the native buttons such as their corner radius across every change of state during the gameplay (like flipping a line to green across winning scenarios).
