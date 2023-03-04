import dayjs from "dayjs";

const clockTitle = document.querySelector(".js-clock");

function dday() {
  const today = dayjs();
  const christDay = dayjs("2023-12-25");

  const diffDays = christDay.diff(today, "day", true);
  const diffHours = christDay.diff(today, "hour", true);
  const diffMins = christDay.diff(today, "minute", true);
  const diffSec = christDay.diff(today, "second", true);

  const days = Math.floor(diffDays);
  const hours = String(
    Math.floor((diffHours % (1000 * 60 * 60)) % 24)
  ).padStart(2, "0");
  const mins = String(Math.floor((diffMins % (1000 * 60)) % 60)).padStart(
    2,
    "0"
  );
  const sec = String(Math.floor((diffSec % 1000) % 60)).padStart(2, "0");

  clockTitle.innerText = `${days}d ${hours}h ${mins}m ${sec}s`;
}
dday();
setInterval(dday, 1000);
