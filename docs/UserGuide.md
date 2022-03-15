---
layout: page
title: User Guide
---
# McKitchen User Guide
McKitchen (My-CLI-Kitchen) is a desktop application that can quickly store, edit, and search for recipes by running a single command, ideal for the fast typists, home cooks, and students who want a simple way to store or search for simple recipes to cook.

* Table of Contents
{:toc}

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer by clicking [here](https://www.java.com/en/download/help/version_manual.html).
   1. If you do not have Java version >= `11` installed, refer to [this installation guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

2. Download the latest `McKitchen.jar` from [here](https://github.com/AY2122S2-CS2103T-T17-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your McKitchen.

4. To run the application, if you're on:
   1. Windows: Double-click the file to start the app.
   2. MacOS/UNIX: Open the terminal in the _home folder_ (Step 3) and issue the following command: `java -jar McKitchen.jar`

The GUI similar to the below should appear in a few seconds <to update>. <br>
Note how the app contains some sample data.<br>
      ![Ui](images/Ui.png)

5. (TO UPDATE) Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

---

## Features

### Create recipe
Create a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>
Usage: `create recipe n/ <name of recipe> i/ <ingredients separated by commas> s/ <steps separated by commas>` <br>
Example:
- `create recipe n/ Aglio Olio i/ spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml, salt ?, pepper ? s/ Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt and black pepper`
  - This creates a recipe for "Aglio Olio" with 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and a non-fixed amount of salt, and pepper (to taste) with the steps of:
    1. Cook the spaghetti until al dante,
    2. Saute the chopped garlic,
    3. Toss the spaghetti in the sauce,
    4. Taste and season with salt and black pepper.

### List recipes
Displays a list of recipes that the user has stored locally. If this is the first time that the user runs the application, sample recipes will be shown instead. Recipes shown here would be a shortened version of the recipe and only display its name and tags (type of cuisine). For the full details of the recipe, refer to [`view`](###view-recipe) <br>
Note: The numbers associated with the recipes would be used for other commands.<br>
Usage: `list`

### View recipe
View the contents of an existing stored recipe based on the number it is associated with in the `list`. <br>
Usage: `view <recipe number>` <br>
Example:
- view 1
    - This would display the full contents of the first recipe in the list which includes its ingredients and steps to prepare the dish.

### Delete recipe
Removes a stored recipe based on the number it is associated with in the `list` <br>
Usage: `delete <recipe number>` <br>
Example:
- delete 1
    - This would delete the first entry in the list of recipes.

### Store recipe
Store the recipe in a human-readable text file on the user's computer and is modifiable through a text editor if the user is familiar with the format (JSON). <br>
Usage: (Automatically updates text file upon each modifying (writing) operation).

### Load recipe
Load existing recipes from the text file on the user's computer. Modifications to this file would be displayed accordingly as long as the format is followed. <br>
Usage: (Automatically loads the recipes upon launching the application).

---

## FAQ
(To be filled)

---

## Command Summary
(To be filled)

| Action                     | Command format                                                                                          |
|----------------------------|---------------------------------------------------------------------------------------------------------|
| add a new recipe           | `create recipe n/ <name of recipe> i/ <ingredients separated by commas> s/ <steps separated by commas>` |
| list all available recipes | `list`                                                                                                  |
| view specific recipe       | `view <recipe number from list>`                                                                        |
| delete recipe              | `delete <recipe number from list>`                                                                      |


