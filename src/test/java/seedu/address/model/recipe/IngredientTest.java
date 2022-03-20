// package seedu.address.model.recipe;
//
// import org.junit.jupiter.api.Test;
//
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.testutil.Assert.assertThrows;
//
// class IngredientTest {
//
//     @Test
//     public void constructor_null_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> new Ingredient(null, null, null));
//     }
//
//     @Test
//     public void constructor_invalidEmptyIngredientName_throwsIllegalArgumentException() {
//         String invalidIngredientName = "";
//         String validIngredientQty = "5.5";
//         String validIngredientQuantifier = "g";
//         assertThrows(IllegalArgumentException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidEmptyIngredientQty_throwsIllegalArgumentException() {
//         String invalidIngredientName = "Spaghetti";
//         String validIngredientQty = "";
//         String validIngredientQuantifier = "g";
//         assertThrows(IllegalArgumentException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidEmptyIngredientQuantifier_throwsIllegalArgumentException() {
//         String invalidIngredientName = "Spaghetti";
//         String validIngredientQty = "5.5";
//         String validIngredientQuantifier = "";
//         assertThrows(IllegalArgumentException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidNullIngredientName_throwsIllegalArgumentException() {
//         String invalidIngredientName = null;
//         String validIngredientQty = "5.5";
//         String validIngredientQuantifier = "g";
//         assertThrows(NullPointerException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidNullIngredientQty_throwsIllegalArgumentException() {
//         String invalidIngredientName = "Spaghetti";
//         String validIngredientQty = null;
//         String validIngredientQuantifier = "g";
//         assertThrows(NullPointerException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidNullIngredientQuantifier_throwsIllegalArgumentException() {
//         String invalidIngredientName = "Spaghetti";
//         String validIngredientQty = "5.5";
//         String validIngredientQuantifier = null;
//         assertThrows(NullPointerException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void constructor_invalidNegativeIngredientQty_throwsIllegalArgumentException() {
//         String invalidIngredientName = "Spaghetti";
//         String validIngredientQty = "-12.4";
//         String validIngredientQuantifier = "g";
//         assertThrows(IllegalArgumentException.class,
//                 () -> new Ingredient(invalidIngredientName, validIngredientQty, validIngredientQuantifier));
//     }
//
//     @Test
//     public void isValidIngredient() {
//         // null ingredient name, qty, quantifier
//         assertThrows(NullPointerException.class, () -> Ingredient.isValidIngredientName(null));
//         assertThrows(NullPointerException.class, () -> Ingredient.isValidQuantity(null));
//         assertThrows(NullPointerException.class, () -> Ingredient.isValidQuantifier(null));
//
//         // invalid ingredient name
//         assertFalse(Ingredient.isValidIngredientName("")); // empty string
//         assertFalse(Ingredient.isValidIngredientName(" ")); // spaces only
//         assertFalse(Ingredient.isValidIngredientName("       ")); // lots of spaces only
//
//         // invalid ingredient qty
//         assertFalse(Ingredient.isValidQuantity("")); // empty string
//         assertFalse(Ingredient.isValidIngredientName(" ")); // spaces only
//         assertFalse(Ingredient.isValidIngredientName("       ")); // lots of spaces only
//         assertFalse(Ingredient.isValidIngredientName("-1")); // negative value only
//         assertFalse(Ingredient.isValidIngredientName("-24.23")); // negative double only
//
//         // invalid ingredient quantifier
//         assertFalse(Ingredient.isValidQuantifier("")); // empty string
//         assertFalse(Ingredient.isValidQuantifier(" ")); // spaces only
//         assertFalse(Ingredient.isValidQuantifier("       ")); // lots of spaces only
//
//         // valid ingredient name
//         assertTrue(Ingredient.isValidIngredientName("Spaghetti")); // 1 word ingredient
//         assertTrue(Ingredient.isValidIngredientName("Raw tomatoes")); // 2 word ingredient
//         assertTrue(Ingredient.isValidIngredientName("Organic brown rice")); // 3 word ingredient
//
//         // valid ingredient qty
//         assertTrue(Ingredient.isValidQuantity("5")); // 1 digit int
//         assertTrue(Ingredient.isValidQuantity("100")); // 3 digit int
//         assertTrue(Ingredient.isValidQuantity("2.5")); // 1 decimal place double
//         assertTrue(Ingredient.isValidQuantity("2.75")); // 2 decimal place double
//
//         // valid ingredient quantifier
//         assertTrue(Ingredient.isValidQuantifier("kg")); // 2 letter quantifier
//         assertTrue(Ingredient.isValidQuantifier("clovers")); // 1 word quantifier
//         assertTrue(Ingredient.isValidQuantifier("metric tons")); // 2 word quantifier
//     }
// }
