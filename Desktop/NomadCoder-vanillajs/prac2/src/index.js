const body = document.querySelector("body");
const colors = ["#1abc9c", "#3498db", "#9b59b6", "#f39c12", "#e74c3c"];

function handleResize() {
  const width = window.innerWidth;
  if (width > 0 && width < 200) {
    body.style.backgroundColor = colors[0];
  } else if (width >= 200 && width < 400) {
    body.style.backgroundColor = colors[1];
  } else if (width >= 400 && width < 600) {
    body.style.backgroundColor = colors[2];
  } else if (width >= 600 && width < 800) {
    body.style.backgroundColor = colors[3];
  } else if (width >= 800 && width < 1000) {
    body.style.backgroundColor = colors[4];
  }
}

handleResize();
window.addEventListener("resize", handleResize);
