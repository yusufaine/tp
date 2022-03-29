---
layout: page
title: User Guide
---
McKitchen (My-CLI-Kitchen) is a desktop application that can quickly store, edit, and search for recipes by running a single command, ideal for the fast typists, amateur cooks, or busy students or executives who want a simple way to store or search for simple recipes to cook.

## About this guide
This guide is intended to be used by those who are interested in how to use McKitchen -- whether you're a user of McKitchen or simply doing research, welcome! A [table of content](#table-of-content) is located just below this section to improve navigation of this guide and bring you to the portion of the guide that you are interested in. Additionally, in each of those sections, we've linked a small text titled "return to Table of Content" for you to be able to quickly jump back to the top should you choose to. 

Throughout the document you may encounter some of these symbols, and they denote the following:
* :information_source: : General tips regarding the section or feature that you are currently on
* :computer: : Tips for advanced users
* :heavy_exclamation_mark: : Warning! Pay close attention to them to understand the potential drawbacks of related to the section or feature that you are currently on.

---

<div style="page-break-after: always;"></div>

## Table of Content
- [Quick start](#quick-start)
- [Features](#features)
    * [Understanding the command format](#understanding-the-command-format)
    * [Add a new recipe: `add`](#add-a-new-recipe---add-)
    * [Clear (delete all) existing recipes: `clear`](#clear--delete-all--existing-recipes---clear-)
        + [Forced Clear:](#forced-clear-)
    * [Reset to the default recipes: `reset`](#reset-to-the-default-recipes---reset-)
    * [Delete an existing recipe: `delete`](#delete-an-existing-recipe---delete-)
    * [Edit an existing recipe: `edit`](#edit-an-existing-recipe---edit-)
    * [Find an existing recipe: `find`](#find-an-existing-recipe---find-)
    * [Get help on how to use McKitchen: `help`](#get-help-on-how-to-use-mckitchen-help)
    * [List all stored recipes: `list`](#list-all-stored-recipes---list-)
    * [Load recipe](#load-recipe)
    * [Save recipes](#save-recipes)
    * [View an existing recipe: `view`](#view-an-existing-recipe---view-)
- [FAQ](#faq)
- [Command Summary](#command-summary)

---

## Quick start

In this section, we will get you started on the things you need to do prior to using McKitchen -- namely, installing Java 11.

1. Ensure you have Java `11` or above installed in your computer by clicking [here](https://www.java.com/en/download/help/version_manual.html).
   1. If you do not have Java version >= `11` installed, refer to [this installation guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

2. Download the latest `McKitchen.jar` from [our GitHub page](https://github.com/AY2122S2-CS2103T-T17-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your McKitchen.

4. To run the application, if you're on:
   1. Windows: Double-click the file to start the app.
   2. MacOS/UNIX: Open the terminal in the _home folder_ (Step 3) and issue the following command: `java -jar McKitchen.jar`

<div markdown="block" class="alert alert-info">

:information_source: :computer: **Alternatively**, you can allow the application Full Disk Access and be able to run the McKitchen by double-clicking on it by following [this post](https://discussions.apple.com/thread/252709578).

</div>

The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

![Ui](images/Ui.png)

5. Type the command where prompted "Enter command here" and press Enter to execute it. <br> Example: typing **`help`** and pressing Enter will open the help window which would bring provide you with a link and direct you to the [Command Summary](#command-summary).

6. Refer to the [Features](#features) below for details of each command.

---

## Features

In this section we would be going over what each feature does, how to go about doing so, and what it achieves. <br>

### Understanding the command format
For most commands, the format is as follows: 
* `command <mandatory data | alternate mandatory data> [optional data]` where **alternate** means either one of the data but not both.
  * Delete example: `delete <recipe name | -x recipe number from list>`
  * Edit example: `edit <old recipe name | -x recipe number from list> [-n newRecipeName]`

<div markdown="block" class="alert alert-info">

:information_source: For a summarised version, feel free to jump to the [Command Summary](#command-summary).

</div>

### Add a new recipe: `add`
Add a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>
Usage: `add <-n name of recipe> <-d completion time of recipe> <-ss serving size of recipe> <-i ingredients of recipes separated by commas> <-s steps separated by commas> [-t tags associated with recipe]`
> :information_source: Ingredients, steps, and tags can be separated by commas.

Example:
- `add -n Aglio Olio -d 5 -ss 1 -i spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml -s Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt and black pepper`
  - This creates a recipe for "Aglio Olio" with a completion time of 5 mins, serving size of 1 person/pax and ingredients consisting of 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and a non-fixed amount of salt, and pepper (to taste) with the steps of:
    1. Cook the spaghetti until al dante,
    2. Saute the chopped garlic,
    3. Toss the spaghetti in the sauce,
    4. Taste and season with salt and black pepper.

 [<sub>return to table of content</sub>](#table-of-content)

### Clear (delete all) existing recipes: `clear`
Removes all existing recipes in McKitchen. A confirmation prompt would show up before this operation is executed. <br>

Usage: `clear [-f]`

The program would then prompt you to confirm. Type in `yes` to clear and `no` to cancel the clear request.
> :heavy_exclamation_mark: By specifying `-f`, you are letting McKitchen know that you are very sure about what you're doing and would proceed to removing all recipes without a confirmation prompt. 

Example:
- `clear`
  - This would generate a clear request that requires a confirmation. 
    - To confirm to clear McKitchen, type in 'yes',
    - Otherwise, type in 'no'.
- `clear -f`
  - This would clear all entries **without** confirmation

<div markdown="block" class="alert alert-info">

️:heavy_exclamation_mark: :computer: McKitchen is only able to restore the default sample recipes by running `reset`. Currently, McKitchen isn't able to undo actions in the application so use this feature with caution!

</div>

### Reset to the default recipes: `reset`
Resets the existing recipes in McKitchen to the default ones that it initially came with.

Usage: `reset`

<div markdown="block" class="alert alert-info">

️:heavy_exclamation_mark: Running this command would also mean that you would [clear](#clear-delete-all-existing-recipes-clear) all existing recipes.

</div>


[<sub>return to table of content</sub>](#table-of-content)

### Delete an existing recipe: `delete`
Removes a stored recipe based on the number it is associated with in the `list` <br>
Usage: 
* `delete <recipe name>` <br> 
   or 
* `delete <-x recipe number from list>`

Example:
- `delete Aglio Olio`
  - This would delete the recipe called 'Aglio Olio'.
- `delete -x 1`
  - This would delete the first entry in the list of recipes.

<div markdown="block" class="alert alert-info">

:information_source: **Deletion of recipes by its name are case-insensitive!**<br>
To make it a little more convenient for you, McKitchen is able to delete a recipe by its name by making it case-insensitive. This means that `delete aglio olio` works too!

</div>

[<sub>return to table of content</sub>](#table-of-content)

### Edit an existing recipe: `edit`
Edits a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>

> :information_source: **Only specify the parts of the recipe that you want to edit!** <br> 
> The only necessary information needed is the name, or number of the recipe that you would like to edit<br>

Usage: 
* `edit <name of recipe to be edited> [-n <new name of recipe> -d <new completion time of recipe> -ss <new serving size of recipe> -i <new ingredients of recipes separated by commas> -s <new steps separated by commas> -t <new tags associated with recipe>]` <br>
or 
* `edit <-x recipe number to be edited> [-n <new name of recipe> -d <new completion time of recipe> -ss <new serving size of recipe> -i <new ingredients of recipes separated by commas> -s <new steps separated by commas> -t <new tags associated with recipe>]`

Example:
- `edit Aglio Olio -n Spicy Aglio Olio -i spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml, Chilli flakes 10 teaspoons -s Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt, black pepper and chilli flakes`
    - This edits the recipe named "Aglio Olio" and updates its attributes with a name of "Spicy Aglio Olio" and ingredients consisting of 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and 10 teaspoons of chilli flakes with the steps of:
        1. Cook the spaghetti until al dante,
        2. Saute the chopped garlic,
        3. Toss the spaghetti in the sauce,
        4. Taste and season with salt, black pepper and chilli flakes.

- `edit -x 1 -n Spicy Aglio Olio [and other information that you would like to edit]`

[<sub>return to table of content</sub>](#table-of-content)

### Find an existing recipe: `find`
Searches for a recipe based on the keywords (seperated by comma). <br>
Usage: 
* `find <keyword> [other keywords, seperated by commas]`

Example: 
- Let's say that you would like to cook a Western cuisine and have spaghetti and garlic on hand. <br>
        The command that you would execute should look something like this:
    - `find western, spaghetti, garlic`

<div markdown="block" class="alert alert-info">

:information_source: **Keywords used for the find feature are case-insensitive!**<br>
Don't worry, McKitchen would still be able to find "Secret Family Sauce" even if you search for "secret family sauce" (or searching for the secret ingredient) :wink:

</div>

### Get help on how to use McKitchen: `help`
Opens a pop-up that allows you to copy a link to our User Guide (this page) but directs you to the [Command Summary](#command-summary) immediately so that you can see what commands to type in order to achieve what you want to do with McKitchen. <br>
Usage: `help`

[<sub>return to table of content</sub>](#table-of-content)

### List all stored recipes: `list`
Displays all the available recipes that has been stored locally <br>
Usage: `list`

[<sub>return to table of content</sub>](#table-of-content)

### Load recipe
Load existing recipes from the text file on your computer. Modifications to this file would be displayed accordingly as long as the format is followed. <br>
Usage: Automatically loads the recipes upon launching the application.

<div markdown="block" class="alert alert-info">

️:information_source: Recipes would be loaded from a file called "recipebook.json" in a folder called "data" from where McKitchen is located. <br>
Example: If McKitchen is stored in the "Downloads" folder, recipes would be loaded in a folder called "data" which should contain "recipebook.json". <br><br>
If the file or folder does not exist, McKitchen would automatically create them and provide sample recipes to allow you to explore the application without needing to input their own recipes. <br>

:computer: McKitchen would try to locate and load "recipebook.json" relative to where it's being ran (./data/recipebook.json). <br>
️:computer: If you are familiar with JSON, you can modify the file to add new recipes or modify aspects of an existing recipe without needing to run McKitchen. You are advised to strictly follow the formatting of the application as failure to do so may result to certain aspects of the recipes to not load properly, if at all.

</div>

[<sub>return to table of content</sub>](#table-of-content)

### Save recipes
Save the recipes in a human-readable text file on your computer and is modifiable through a text editor as it is JSON-formatted. <br>
Usage: Automatically updates when the text file is modified.

<div markdown="block" class="alert alert-info">

️:information_source: Recipes would be saved in a folder called "data" from where McKitchen is located. <br>
Example: If McKitchen is saved in the "Downloads" folder, recipes would be saved in a folder called "data" in "Downloads" as "recipebook.json".

️:computer: If you are familiar with how file paths works in your operating system, the "recipebook.json" file would be created in a folder **relative** to McKitchen.jar (data/recipebook.json) 


</div>

[<sub>return to table of content</sub>](#table-of-content)

### View an existing recipe: `view`
View the contents of an existing stored recipe based on recipe name or number. <br>
Usage: 
* `view <recipe name>` <br>or
* `view <-x recipe number from list>`

Example:
- `view Aglio Olio`
    - This would display the full contents of the recipe matching the name "Aglio Olio" including its ingredients and steps to prepare the dish.

- `view -x 1`
    - This would display the full contents of the first recipe in the list which includes its ingredients and steps to prepare the dish.

<div markdown="block" class="alert alert-info">

️:information_source: Recipe names are case-insensitive to make it a little more convenient for you. This means that `view aglio olio` works too!

</div>

[<sub>return to table of content</sub>](#table-of-content)


---

## FAQ
**Q: If I am unsure of the exact amount of ingredients im adding into my recipe, can I save it first and come back to it later?** <br>
You cannot save the recipe with empty fields. Instead, you can add a dummy value into the field you are unsure of, then edit it after you are sure of the input values.

**Q: Is there a faster way to delete a recipe instead of copying the recipe name word for word?**<br>
The fastest way is to delete a recipe by its number in the list `delete -x <recipe number>`

**Q: How do I transfer my recipes to another computer?**<br>
Copy the recipebook.json file into your new computer.

**Q: What do I need to consider when adding a new recipe?**<br>
You need to consider the:
1. Recipe name (`-n`),
2. Completion time (`-d`),
3. Serving Size (`-ss`),
4. Ingredients (`-i`),
5. Steps (`-s`), and
6. (Optional) Tags (`-t`)

**Q: If I deleted one of the provided (default) recipe by accident, can I retrieve it back?**<br>
You can use the reset command to retrieve the recipe. For newly added recipes, you will not be able to undo your deletion. 

**Q: If I typed in 'clear' or 'reset' in the command bar, will it take effect immediately?**<br>
It will not take effect immediately. A confirmation prompt will allow you to confirm your decision. Alternatively, you can specify the prefix -f to clear or reset without any confirmation prompt. 


[<sub>return to table of content</sub>](#table-of-content)

---

## Command Summary

### How to read this table?
1. Actions (what you would want to do) is on the left while the command associated to it is on the right. 
   1. The command format and the details you provide are case-sensitive.
2. Almost all the details of the commands are needed to be given before the command can be executed properly.
   1. **Compulsory** details are denoted by angled-brackets such as \<mandatory details>.
   2. **Optional** details of the command that are enclosed in square brackets such as [optional details].
   3. For a better understanding of the command format, refer to [Understanding the command format](#understanding-the-command-format)
3. What does it mean when the input command says "... separated by commas"?
   1. This means that the data you enter would be separated by the commas and would be as though you had entered them separately.
      * Example: `... -t Western, Italian, Vegetarian` would be the same as `-t Western -t Italian -t Vegetarian`


| Action               | Command format                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
|----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| add a new recipe     | `add <-n name of recipe> <-d prep time of recipe> <-ss serving size/portions of recipe> <-i ingredients separated by commas> <-s steps separated by commas> [-t tags separated by commas]`                                                                                                                                                                                                                                                                                                                       |
| edit a recipe        | `edit <name of recipe> [<-n new name of recipe> <-d new prep time of recipe> <-ss new serving size/portions of recipe> <-i new ingredients separated by commas> <-s new steps separated by commas> <-t new tags separated by commas>]` <br></br> or <br><br/> `edit <-x recipe number from list> [-n <new name of recipe> -d <new prep time of recipe> -ss <new serving size/portions of recipe> -i <new ingredients separated by commas> -s <new steps separated by commas> -t <new tags separated by commas>]` |
| delete a recipe      | `delete <recipe name>` <br></br> or <br></br> `delete <-x recipe number from list>`                                                                                                                                                                                                                                                                                                                                                                                                                              |
| find a recipe        | `find <keyword> [other keywords separated by commas]`                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| list a recipe        | `list`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| view specific recipe | `view <recipe name>` <br></br> or <br></br> `view <recipe number from list>`                                                                                                                                                                                                                                                                                                                                                                                                                                     |

[<sub>return to table of content</sub>](#table-of-content)
