# RecipeManagement
java project using annotation validation mapping  Authantication mySql database

## Framework and language used
* Springboot
* java

## dependency used
 * dev
 * web
 * lombok
 * my sql  server driver
 * jpa
 * spring boot starter data jpa 
 * swagger

## Data Flow

### Model
* user
   *  Integer id
   *  String  Name
   *  string email
   *  String password
   *  String phoneno

* AuthenticationToken
   * Integer tokenId;
   * String TokenName;
   * LocalDate tokenCreationDate;
   * User user;
  

* RecipeComment
  * Integer commentId;
  *  String commentBody;
  *  Recipe recipe;
  *  User user;

* Recipe
    *   Integer recipeId;
    *  string recipeName; 
    *   String recipeIngredient;
    *  String recipeInstruction;

### Controller
  * UserController
     *  @PostMapping("/signup")
     *   @PostMapping("/signIn")
    
    
 * RecipeController
    *  @PostMapping("/addRecipe")
    *  @GetMapping("/getRecipe/{recipeId}")
    *  @DeleteMapping("/{recipeId}")
   
 *  CommentController
    * @RequestMapping("/comment")
    * @PostMapping("/addComment")
    




###  service
   * UserService
      * signUp
      * signIn
      * encryptedPassword
    
   * TokenService
       * saveToken
       * 
   * RecipeService
       * saveRecipe
       * getRecipeById
       * removeProductByProductId    
   * CommentService
       *  addComment
 ### repository
   * IUserRepo
   * IRecipeRepo
   * ICommentRepo
   * ITokenRepo

### Database used
* my sql  workbench

##  About Project
* this Project is the about information about recipe User Signup SignIn and Comment on recipe
