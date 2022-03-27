---
layout: page
title: User Guide
---
McKitchen (My-CLI-Kitchen) is a desktop application that can quickly store, edit, and search for recipes by running a single command, ideal for the fast typists, home cooks, and students who want a simple way to store or search for simple recipes to cook.

## Table of Content
- [Quick start](#quick-start)
- [Features](#features)
    * [Adding a new recipe: `add`](#adding-a-new-recipe---add-)
    * [Edit an existing recipe: `edit`](#edit-an-existing-recipe---edit-)
    * [Delete an existing recipe: `delete`](#delete-an-existing-recipe---delete-)
    * [List all stored recipes: `list`](#list-all-stored-recipes---list-)
    * [View recipe an existing recipe: `view`](#view-recipe-an-existing-recipe---view-)
    * [Clear (delete all) existing recipes: `clear`](#clear--delete-all--existing-recipes---clear-)
        + [Forced Clear:](#forced-clear-)
    * [Store recipe](#store-recipe)
    * [Load recipe](#load-recipe)
- [FAQ](#faq)
- [Command Summary](#command-summary)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer by clicking [here](https://www.java.com/en/download/help/version_manual.html).
   1. If you do not have Java version >= `11` installed, refer to [this installation guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

2. Download the latest `McKitchen.jar` from [here](https://github.com/AY2122S2-CS2103T-T17-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your McKitchen.

4. To run the application, if you're on:
   1. Windows: Double-click the file to start the app.
   2. MacOS/UNIX: Open the terminal in the _home folder_ (Step 3) and issue the following command: `java -jar McKitchen.jar`
      1. (Technically demanding) Alternatively, you can allow the application Full Disk Access and be able to run the McKitchen by double-clicking on it by following [this post](https://discussions.apple.com/thread/252709578).

The GUI similar to the below should appear in a few seconds <to update>. <br>
Note how the app contains some sample data.<br>
      ![Ui](images/Ui.png)

5. Type the command where prompted "Enter command here" and press Enter to execute it. <br> Example: typing **`help`** and pressing Enter will open the help window.

6. Refer to the [Features](#features) below for details of each command.

---

## Features

### Add a new recipe: `add`
Add a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>
Usage: `add -n <name of recipe> -d <completion time of recipe> -ss <serving size of recipe> -i <ingredients of recipes separated by commas> -s <steps separated by commas> -t <tags associated with recipe> (optional)` <br>
Example:
- `add -n Aglio Olio -d 5 -ss 1 -i spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml -s Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt and black pepper`
  - This creates a recipe for "Aglio Olio" with a completion time of 5 mins, serving size of 1 person/pax and ingredients consisting of 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and a non-fixed amount of salt, and pepper (to taste) with the steps of:
    1. Cook the spaghetti until al dante,
    2. Saute the chopped garlic,
    3. Toss the spaghetti in the sauce,
    4. Taste and season with salt and black pepper.

 [<sub>return to table of content<sub>](#table-of-content)

### Edit an existing recipe: `edit`
Edits a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>
Usage: `edit -n <name of recipe> -d <completion time of recipe> -ss <serving size of recipe> -i <ingredients of recipes separated by commas> -s <steps separated by commas> -t <tags associated with recipe> (optional)` <br>
Example:
- `edit -n Spicy Aglio Olio -i spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml, Chilli flakes 10 teaspoons -s Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt, black pepper and chilli flakes`
    - This edits the recipe named "Aglio Olio" and updates its attributes with a name of "Spicy Aglio Olio", completion time of 5 mins, serving size of 1 person/pax and ingredients consisting of 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and 10 teaspoons of chilli flakes with the steps of:
        1. Cook the spaghetti until al dante,
        2. Saute the chopped garlic,
        3. Toss the spaghetti in the sauce,
        4. Taste and season with salt, black pepper and chilli flakes.

[<sub>return to table of content<sub>](#table-of-content)

### Delete an existing recipe: `delete`
Removes a stored recipe based on the number it is associated with in the `list` <br>
Usage: `delete -x <recipe index>` or `delete <recipe name>` <br> 
Example:
- `delete -x 1`
    - This would delete the first entry in the list of recipes.
- `delete Aglio Olio` 
    - This would delete the recipe called 'Aglio Olio'.

> :information_source: Recipe names are case-sensitive! <br>
> To prevent accidental deletions, McKitchen requires deletion by name to be case-sensitive. 

[<sub>return to table of content<sub>](#table-of-content)

### Find recipe an existing recipe: `find`
Searches for a recipe based on the keywords (seperated by comma). <br>
Usage: `find <keyword> [other keywords, seperated by commas]` <br>

Example: 
- Let's say that you would like to cook a Western cuisine and have spaghetti and garlic on hand. <br>
        The command that you would execute should look something like this:
    - `find western, spaghetti, garlic`

> :information_source: Keywords are case-insensitive! <br>
> Don't worry, McKitchen would still be able to find "Secret Family Sauce" even if you search for "secret family sauce" :wink:

[<sub>return to table of content<sub>](#table-of-content)

### List all stored recipes: `list`
Displays all the available recipes that has been stored locally <br>
Usage: `list`

[<sub>return to table of content<sub>](#table-of-content)

### View recipe an existing recipe: `view`
View the contents of an existing stored recipe based on recipe name or index. <br>
Usage: `view <recipe name>` or `view -x <recipe number from list>` <br>
Example:
- `view Aglio Olio`
    - This would display the full contents of the recipe matching the name "Aglio Olio" including its ingredients and steps to prepare the dish.

- `view -x 1`
    - This would display the full contents of the first recipe in the list which includes its ingredients and steps to prepare the dish.

> :information_source: Recipe names are case-sensitive! <br>

[<sub>return to table of content<sub>](#table-of-content)

### Clear (delete all) existing recipes: `clear`
Clears the entire recipe book. A confirmation prompt would show up before the user could clear immediately. <br>

Usage: `clear`

The program would then prompt the user to confirm. Type in `yes` to clear and `no` to cancel the clear request.

Example: 
- clear
    - This would generate a clear request that requires a confirmation. To confirm to clear the recipe book, type in 'yes',
    - else, type in 'no'.

> ‼️ Advance user tip: To clear the recipe book without the confirmation, users simply have to include the prefix `-f` after the `clear` command.
  
#### Forced Clear:
Usage: `clear -f` <br>
Example:
- clear -f
    - This would clear the recipe book without having the need for any confirmation.

[<sub>return to table of content<sub>](#table-of-content)

### Save recipes
Save the recipes in a human-readable text file on the your computer and is modifiable through a text editor if the user is familiar with the format (JSON). <br>
Usage: (Automatically updates text file upon each modifying (writing) operation).

> :information_source: Recipes would be saved in a folder called "data" from where McKitchen is located. <br>
> Example: If McKitchen is saved in the "Downloads" folder, recipes would be saved in a folder called "data" in "Downloads" as "recipebook.json".

[<sub>return to table of content<sub>](#table-of-content)

### Load recipe
Load existing recipes from the text file on the user's computer. Modifications to this file would be displayed accordingly as long as the format is followed. <br>
Usage: (Automatically loads the recipes upon launching the application).

> :information_source: Recipes would be loaded from a file called "recipebook.json" in a folder called "data" from where McKitchen is located. <br>
> Example: If McKitchen is stored in the "Downloads" folder, recipes would be loaded in a folder called "data" which should "recipebook.json". <br>
> If the file or folder does not exist, McKitchen would automatically create them and provide a sample recipes to allow users to explore the application without needing to input their own recipes.

> ‼️ Advance user tip: If you are familiar with JSON, you modify the file to add new recipes or modify aspects of an existing recipe without needing to run McKitchen. You are advised to strictly follow the formatting of the application as failure to do so may result to certain aspects of the recipes to not load properly, if at all.

###### [return to table of content](#table-of-content)

---

## FAQ
(To be filled)

###### [return to table of content](#table-of-content)

---

## Command Summary

### How to read this table?
1. User actions (what you would want to do) is on the left while the command associated to it is on the right.
2. Almost all the details of the commands are needed to be given before the command can be executed properly.
   1. **Compulsory** details are denoted by angled-brackets such as \<mandatory details>.
   2. **Optional** details of the command that are enclosed in square brackets such as [optional details].
3. What does it mean when the input command says "... separated by commas"?


| Action               | Command format                                                                                                                                                                                                 |
|----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| add a new recipe     | `add -n <name of recipe> -d <prep time of recipe> -ss <serving size/portions of recipe> -i <ingredients separated by commas> -s <steps separated by commas> [-t <tags separated by commas>]`                   |
| edit a recipe        | `edit <name of recipe> -n <name of recipe> -d <prep time of recipe> -ss <serving size/portions of recipe> -i <ingredients separated by commas> -s <steps separated by commas> [-t <tags separated by commas>]` |
| delete a recipe      | `delete -x <recipe number from list>` <br> or <br> `delete <recipe name>`                                                                                                                                      |
| find a recipe        | `find <keyword> [other keywords separated by commas]`                                                                                                                                                          |
| list a recipe        | `list`                                                                                                                                                                                                         |
| view specific recipe | `view <recipe number from list>` <br/> or <br/> `view <recipe name>`                                                                                                                                           |

###### [return to table of content](#table-of-content)

