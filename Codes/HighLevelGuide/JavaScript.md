JAVASCRIPT adds interactivity to websites

VARIABLES store data:
let name = "John" // can be changed
const age = 30 // cannot be changed
var oldWay = "avoid" // outdated

DATA TYPES:
string "hello world"
number 42 3.14
boolean true false
null empty value
undefined not assigned
object { key: "value" }
array [1, 2, 3]

FUNCTIONS:
function greet(name) {
return "Hello " + name
}
// or arrow function
const greet = (name) => "Hello " + name

ARRAYS:
let cars = ["Toyota", "Honda", "Ford"]
cars[0] // "Toyota"
cars.push("BMW") // add to end
cars.length // 4

OBJECTS:
let car = {
make: "Toyota",
model: "Corolla", 
year: 2020,
price: 15000
}
car.make // "Toyota"
car["model"] // "Corolla"

DOM MANIPULATION:
document.getElementById("myElement")
document.querySelector(".myClass")
element.innerHTML = "new content"
element.style.color = "blue"
element.addEventListener("click", myFunction)

EVENTS:
click mouse clicks
keydown key presses  
submit form submission
load page loaded
change input changed

VEHICLE PLATFORM JAVASCRIPT:

Handle form submission:
document.getElementById("search-form").addEventListener("submit", function(event) {
event.preventDefault() // stop page reload
let make = document.getElementById("make").value
let maxPrice = document.getElementById("max-price").value
searchVehicles(make, maxPrice)
})

Filter vehicles:
function searchVehicles(make, maxPrice) {
let allVehicles = getVehiclesFromDatabase()
let filtered = allVehicles.filter(car => {
return car.make === make && car.price <= maxPrice
})
displayVehicles(filtered)
}

Local storage for user preferences:
localStorage.setItem("preferredMake", "Toyota")
let preferred = localStorage.getItem("preferredMake")

API calls to backend:
fetch("/api/vehicles")
.then(response => response.json())
.then(vehicles => displayVehicles(vehicles))
.catch(error => console.error("Error:", error))

Conditional logic:
if (price < 10000) {
category = "budget"
} else if (price < 30000) {
category = "mid-range"  
} else {
category = "luxury"
}

Loops:
for (let i = 0; i < vehicles.length; i++) {
console.log(vehicles[i].make)
}
// or
vehicles.forEach(vehicle => {
console.log(vehicle.model)
})