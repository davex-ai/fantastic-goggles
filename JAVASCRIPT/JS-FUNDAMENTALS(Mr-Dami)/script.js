var name = "" // old way of declaring variables
const age = 639 //this is from es6 and once declared the value does not change
let location3 = "Mars" //this is from es6 ans once declared the value can change

//data types
//String
var stringData = "Fdfefe"
//number
var numberDATA = 234567
//boolean
var boolData = false
// Object
var person = {
    name: "fghjkhgfdf",
    getAge: function(){
        return 65
    }
}

var arrayData = [1,2,3,4,5,6]

var undefinedData = null

//number operators
let variable1 = 78
let variable2 = 56

// const total = variable1 + variable2
// document.writeln(total, "<br>")

// const subtraction = variable1 - variable2
// document.writeln(subtraction, "<br>")

// const multiplication = variable1 * variable2
// document.writeln(multiplication, "<br>")

// const division = variable1 / variable2
// document.writeln(division, "<br>")

// const modulus = variable1 % variable2
// document.writeln(modulus, "<br>")

variable1 += variable2
document.writeln(variable1, "<br>");


variable2 *= variable1
document.writeln(variable2, "<br>");


variable1 -= variable2
document.writeln(variable1, "<br>");


variable2 /= variable1
document.writeln(variable2, "<br>");

variable1 %= 2
document.writeln(variable1, "<br>");


variable1++
variable1--
++variable1
--variable1

const num1 = 30
const num2 = 90
const num3 = 45
const avg = (num1 + num2 + num3) / 3
document.writeln(avg)

//loops

// for loops
let sum = 0 //summation from 1 to 10
for(let i = 0; i<11;i++) {
    sum += i
}
document.writeln(variable1, "<br>")

// foreach 
arrayData.forEach(function(data) {
    document.writeln(data, '<br>')
})

["arrayData", "David", "CHristopher", "Emmanuel"].forEach((data) => {
    document.writeln(data, '<br>')
})

// while
let i = 0
sum = 0
while (i < 11){
    sum += i
    i++
}

// do while
 i = 11
 sum = 0

do {
    sum += i
    i++
} while (i < 11);
document.writeln(sum)


// && and
// || or
// ! not
// == equal  to
// === similar type and equal to
// != not equal  to
// !== not similar and equal to
// > greater than
// < less than
// >= greater than or equal to
// <= less than or equal to

// // conditions

document.writeln(3 === '3')

const isMarried = false
if(age < 30){
    // do this
    document.writeln('Still a bit more to go')
}else if(isMarried){
    document.writeln('You don born?')

} else {
    // do this
     document.writeln('Go and marry')
}


document.querySelector("#form").addEventListener('submit', addTask)

function addTask(e){
    e.preventDefault()
}