
console.log("Export Shopping Cart As A Module");

const shippingCost = 10
export const cart = []
const totalPrice = 237
const totalQuantity = 23

// USING A  NAMED export
export const addToCart = function (product, quantity){
    cart.push({product, quantity})
    console.log(`${quantity} ${product} was added to cart`);
} 

//USING A DEFAULT EXPORT THIS WILL ONLY EXPORT THE VALUE IN THE KEY - VALUE PAIR

export default function gh(product, quantity){
    cart.push({ product, quantity})
    console.log(`${quantity}, ${product} added to cart a second time`);
    
}
export { shippingCost, totalQuantity as tq,totalPrice as tp }







