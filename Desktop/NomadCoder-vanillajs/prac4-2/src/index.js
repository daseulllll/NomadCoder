import moment from "moment";

const clockTitle = document.querySelector(".js-clock");

function dday() {
  const start = moment();
  const end = moment("2023-12-25");

  const diffdays = moment.duration(end.diff(start)).asDays();
  const diffhours = moment.duration(end.diff(start)).asHours();
  const diffmins = moment.duration(end.diff(start)).asMinutes();
  const diffsecs = moment.duration(end.diff(start)).asSeconds();

  const days = Math.floor(diffdays);
  const hours = String(
    Math.floor((diffhours % (1000 * 60 * 60)) % 24)
  ).padStart(2, "0");
  const mins = String(Math.floor((diffmins % (1000 * 60)) % 60)).padStart(
    2,
    "0"
  );
  const secs = String(Math.floor((diffsecs % 1000) % 60)).padStart(2, "0");

  clockTitle.innerText = `${days}d ${hours}h ${mins}m ${secs}s`;
}
dday();
setInterval(dday, 1000);
