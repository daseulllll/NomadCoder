const todoForm = document.getElementById("todoForm");
const todoInput = document.querySelector("#todoForm #todoInput");
const todoSubmit = document.querySelector("todoSubmit");
const todoList = document.getElementById("todoList");

const TODOS_KEY = "todos";

let toDos = [];

function paintTodo(strawberry) {
  const li = document.createElement("li");
  li.id = strawberry.id;
  const span = document.createElement("span");
  span.innerText = strawberry.text;
  const button = document.createElement("button");
  button.innerText = "❌";

  span.addEventListener("click", doneTodo);
  button.addEventListener("click", deleteTodo);
  li.appendChild(span);
  li.appendChild(button);
  todoList.appendChild(li);
}

function submitTodo(banana) {
  banana.preventDefault();
  const listTodo = todoInput.value;
  todoInput.value="";
  const newTodoList = {
    text: listTodo,
    id: Date.now()
  };
  toDos.push(newTodoList);
  paintTodo(newTodoList);
  saveTodos();
}

todoForm.addEventListener("submit", submitTodo);

function saveTodos(){
    localStorage.setItem(TODOS_KEY,JSON.stringify(toDos));
}

function doneTodo(potato) {
    const done = potato.target.parentElement;
    done.classList.toggle("strikeout");
}

function deleteTodo(tomato) {
    const endli = tomato.target.parentElement;
    endli.remove();
    toDos = toDos.filter((toDo)=>toDo.id !== parseInt(endli.id));
    saveTodos();
}


const savelist = localStorage.getItem(TODOS_KEY);

if(savelist !== null){
    const parsedToDos = JSON.parse(savelist);
    toDos = parsedToDos;
    parsedToDos.forEach(paintTodo);
}