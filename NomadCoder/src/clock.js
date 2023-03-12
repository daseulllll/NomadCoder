const date = document.querySelector("h1#date");
const clock = document.querySelector("h1#clock");

function currentClock() {
  const now = new Date();

  const years = now.getFullYear();
  const months = now.getMonth() + 1;
  const day = now.getDate();

  const hours = String(now.getHours()).padStart(2, "0");
  const mins = String(now.getMinutes()).padStart(2, "0");
  const secs = String(now.getSeconds()).padStart(2, "0");

  date.innerText = `${years}년 ${months}월 ${day}일`;
  clock.innerText = `${hours}시 ${mins}분 ${secs}초`;
}
currentClock();
setInterval(currentClock, 1000);
