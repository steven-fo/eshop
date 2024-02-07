# Eshop
Name: Steven Faustin Orginata <br>
Class: Advprog B <br>
NPM: 2206030855
<hr>

<h3>Reflection 1</h3>
Clean Code and Secure Coding principles I have applied to my code are: <br>
- Meaningful names <br>
I use meaningful and descriptive variable names such as, productId, productName, newProduct, currentProduct.<br>
- Small, One task, descriptive functions<br>
I use functions that are small, they only do one task, and I give them descriptive names such as, findById, create, edit, delete.<br>

Mistakes I encountered in my source code are:<br>
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