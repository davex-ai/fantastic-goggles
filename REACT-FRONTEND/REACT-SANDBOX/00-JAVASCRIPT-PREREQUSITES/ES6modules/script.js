import {secondcart, tp, tq, cart, shippingCost, addToCart } from "./shopping-cart.js";
console.log("Importing a module");
console.log(`The Shipping cost is ${'$' + shippingCost}`);

addToCart('bread', 5)
secondcart('apple', 10)

console.log(cart);
console.log(tq);
console.log(tp);