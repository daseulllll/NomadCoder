const rangeForm = document.querySelector("#rangeForm");
const rangeInput = rangeForm.querySelector("input");

const guessForm = document.querySelector("#guessForm");
const guessInput = guessForm.querySelector("#guessInput");

const submitButton = document.querySelector("#submitButton");
const guessResult = document.querySelector(".guessResult");
const lastResult = document.querySelector(".lastResult");

function inputRangeNumber(event) {
  //범위 정하기

  const rangeNumber = rangeInput.value;

  if (rangeNumber < 0) {
    setGame();
    alert("범위에는 음수가 포함될 수 없습니다. 새로고침 해주세요!");
  }
}
rangeForm.addEventListener("change", inputRangeNumber);

function checkGuess(event) {
  //내가 숫자 input
  event.preventDefault();
  const rangeNumber = rangeInput.value;
  const rangeN = Math.floor(Math.random() * rangeNumber + 1);

  const userGuess = Number(guessInput.value);

  if (userGuess === rangeN) {
    guessResult.textContent = `You chose: ${userGuess}, the machine chose: ${rangeN}.`;
    lastResult.textContent = "You won!";
    setGame();
  } else {
    guessResult.textContent = `You chose: ${userGuess}, the machine chose: ${rangeN}.`;
    lastResult.textContent = "You lost!";
  }
}
guessForm.addEventListener("submit", checkGuess);

function setGame() {
  rangeInput.disabled = true;
  guessInput.disabled = true;
  submitButton.disabled = true;
}
