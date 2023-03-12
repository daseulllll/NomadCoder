const loginForm = document.getElementById("loginForm");
const loginInput = document.querySelector("#loginForm input");
const loginName = document.querySelector("#loginName");

const hidden = "hidden";
const userKey = "username";
let saveUsername = localStorage.getItem(userKey);

loginForm.addEventListener("submit", loginSubmit);

function loginSubmit(event) {
  event.preventDefault();
  const userName = loginInput.value;
  loginForm.classList.add(hidden);
  localStorage.setItem(userKey, userName);
  login(userName);
}

function login(userName) {
  loginName.innerText = `안녕하세요 ${userName}님!`;
  loginForm.classList.remove(hidden);
  document.querySelector("#loginInput").style.display = "none";
  document.querySelector("#loginSubmit").style.display = "none";

}

if (saveUsername === null) {
  //show form
  loginForm.classList.remove(hidden);
  loginForm.addEventListener("submit", loginSubmit);
     
} else {
  //show login
  login(saveUsername);

}
