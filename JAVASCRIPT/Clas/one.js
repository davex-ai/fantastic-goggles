const greet = 
    (talk) => (name) => 
                console.log(`${talk} ${name}`);

    
    // return function(name){
    // }


const ins = greet("hi" )("hj")
// ins('dsa')

// this keywords

lufthansa = {
    airline: "Turkish Airline",
    iataCode: "TK",
    bookings: [],
    book(name, flightNum){
        console.log(`${name} booked a seat on flight ${this.iataCode}${flightNum} on Flight: ${this.airline}`);
        this.bookings.push({ flight: `${this.iataCode}${flightNum}`, name})
    }
    
}
console.log(lufthansa);
lufthansa.book("chaa", 678)
