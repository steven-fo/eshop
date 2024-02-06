# Eshop
Name: Steven Faustin Orginata <br>
Class: Advprog B <br>
NPM: 2206030855
<hr>

<h3>Reflection 1</h3>
Clean Code and Secure Coding principles I have applied to my code are:
- Meaningful names <br>
I use meaningful and descriptive variable names such as, productId, productName, newProduct, currentProduct.
- Small, One task, descriptive functions<br>
I use functions that are small, they only do one task, and I give them descriptive names such as, findById, create, edit, delete.<br>

Mistakes I encountered in my source code are:
- Wrong path variable name <br>
In the controller, in the edit product function in precise, I use @PathVariable("id"), but in the EditProduct HTML, I hit product.productId instead of id. <Br>
Fix: change the product.productId to {id}(id=${product.productId}). This means that product.productId is considered id.
- Wrong page redirect <br>
In the postMapping after the delete product occurred, I redirect to list only. This caused the link to be /product/delete/list instead of /product/list. <br>
Fix: instead of "redirect:list", make it "redirect:../list". So it redirects to /product/list instead of /product/delete/list.

Reflection 2