// listen for a submit event on the form
// i am going to get the data typed  into the text field
// i am going to add it to the webpage dynamilcally
// i am going to make an alert message inform on when everything is complete
// Event listener

document.querySelector("#form").addEventListener('submit', addTask)


function addTask(e){
    e.preventDefault()

    const taskInput = document.querySelector("#form-input")
    const tableBody = document.querySelector("#todo-table-body")


    const tr = document.querySelector("#tr")
    const number = document.querySelector("#td")
    number.innerText ="#"
    const tasktd = document.createElement("td")
    tasktd.innnerText = taskInput.value
    const actiontd = document.createElement("td")


    const completeButton = document.createElement("buttton")
    completeButton.innerText = "delete task"

    actiontd.appendChild(completeButton)
    tr.appendChild(number)
    tr.appendChild(tasktd)
    tr.appendChild(actiontd)

    tableBody.appendChild(tr);
    alert("Task added");}