const clockTitle = document.querySelector(".js-clock");

function christDday() {
  //월은 0부터 시작, 고로 -1
  const dday = new Date(2023, 11, 25);
  const today = new Date();
  const term = dday - today;

  const days = Math.floor(term / (1000 * 60 * 60 * 24));
  const hours = String(Math.floor((term / (1000 * 60 * 60)) % 24)).padStart(
    2,
    "0"
  );
  const minutes = String(Math.floor((term / (1000 * 60)) % 60)).padStart(
    2,
    "0"
  );
  const seconds = String(Math.floor((term / 1000) % 60)).padStart(2, "0");

  clockTitle.innerText = `${days}d ${hours}h ${minutes}m ${seconds}s`;
}
christDday();
setInterval(christDday, 1000);
