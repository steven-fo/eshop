# Eshop
Name: Steven Faustin Orginata <br>
Class: Advprog B <br>
NPM: 2206030855
<hr>

<details>
<summary>Module 1</summary>
<h3>Reflection 1</h3>
Clean Code and Secure Coding principles I have applied to my code are: <br>

- Meaningful names <br>
  I use meaningful and descriptive variable names such as, productId, productName, newProduct, currentProduct.<br>
- Small, One task, descriptive functions<br>
  I use functions that are small, they only do one task, and I give them descriptive names such as, findById, create, edit, delete.<br>

Mistakes I encountered in my source code are:
- Wrong path variable name <br>
  In the controller, in the edit product function in precise, I use @PathVariable("id"), but in the EditProduct HTML, I hit product.productId instead of id. <Br>
  Fix: change the product.productId to {id}(id=${product.productId}). This means that product.productId is considered id.<br>
- Wrong page redirect <br>
  In the postMapping after the delete product occurred, I redirect to list only. This caused the link to be /product/delete/list instead of /product/list. <br>
  Fix: instead of "redirect:list", make it "redirect:../list". So it redirects to /product/list instead of /product/delete/list.<br>

<h3>Reflection 2</h3>
After writing the unit test, I felt my code is well-built, and I was also relieved to know that there are unseen errors that I could easily detect without manual testing. <br>
How many unit tests should be made in a class? As many as needed, like to test the functions, the methods, flow, etc. <br>
How to make sure that our unit tests are enough to verify our program? I think there is something called code coverage. It shows the coverage of the code based on our tests. <br>
If you have 100% code coverage, does that mean your code has no bugs or errors? I think yes, since we know that code coverage is an indication of how much of our code that has been executed. <br><br>
Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner
Since the functionality is similar, the test code will most likely be similar to the original test code. I don't think it will reduce the code quality since it's the same code. But, again maybe there will be a problem in the code duplication, which we need to improve. We could just compile it to 1 function that could be used together.

</details>
<details>
<summary>Module 2</summary>
<h3>Reflection 1</h3>
Code quality issues that I encountered are: <br>

- Intentionality <br>
  I need to remove the public modifier from every test because it is deprecated.<br>
- Adaptability<br>
  I need to add a test case inside the main app test class<br>
- Consistency<br>
  I need to change the @Autowired field injection to method injection<br>

I think that the current implementation has met the definition of Continuous Integration and Continuous Deployment because there are components that make a CI/CD. Those components are: <br>

- Workflows<br>
  there are 3 workflows currently in this project (ci, scorecard, and sonarcloud)<br>
- Jobs <br>
  each workflow have their own jobs and functions based on their jobs. <br>
- Actions <br>
  in each job, there is a custom command to run a certain task<br>

Moreover, the task executed in the jobs section is to run the testing. Additionally, every workflow is executed every time after either push or pull request happened. All of this command, testing, workflows are automated which means that CI/CD is implemented.
</details>

<details>
<summary>Module 3</summary>
<h3>Reflection 1</h3>

1. Explain what principles you apply to your project! <br>
In this project, I applied the Single Responsibility Principle. Before SOLID, I added Car Controller class inside the Product Controller class java file, which is incorrect. To improve the code, I moved the
Car Controller class to its own java file, CarController.java. One class has only one responsibility according to SRP definition. <br>
2. Explain the advantage of applying SOLID principles to your project with examples! <br>
We know that SOLID principles support the idea of maintainable and easy to comprehend code. Therefore, the advantage of applying SOLID principles are maintainable code, flexible code, easy to comprehend code, and increased stability. By using SOLID principles, we develop a cleaner code, easy to maintain, easy to test, flexible, minimal dependency, and obviously adaptable code. <Br>
3. Explain the disadvantage of not applying SOLID principles to your project with examples! <br>
The disadvantage will surely be the opposite of the advantage. So, by not applying the SOLID principles, we develop dirty code, difficult to maintain, difficult to test, unstable, many unused dependencies, and low adaptability code.<br>
</details>
