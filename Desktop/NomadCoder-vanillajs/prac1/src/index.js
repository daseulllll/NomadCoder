import "./styles.css";
const colors = ["#1abc9c", "#3498db", "#9b59b6", "#f39c12", "#e74c3c"];

const title = document.querySelector("h2");

const superEventHandler = {
  mouseHere: function () {
    title.innerText = "Mouse is here!";
  },

  mouseGone: function () {
    title.innerText = "Mouse is gone!";
  },

  windowResize: function () {
    title.innerText = "You just resized!";
    title.style.color = colors[Math.floor(Math.random() * colors.length)];
  },

  rightClick: function () {
    title.innerText = "That was a right click!";
    title.style.color = colors[Math.floor(Math.random() * colors.length)];
  },

  mouseOver: function () {
    title.style.color = colors[Math.floor(Math.random() * colors.length)];
  }
};
title.addEventListener("mouseenter", superEventHandler.mouseHere);
title.addEventListener("mouseleave", superEventHandler.mouseGone);
window.addEventListener("contextmenu", superEventHandler.rightClick);
window.addEventListener("resize", superEventHandler.windowResize);
window.addEventListener("mouseover", superEventHandler.mouseOver);
