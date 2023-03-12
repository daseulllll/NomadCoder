const quote = document.querySelector("#quotes span:first-child");
const author = document.querySelector("#quotes span:last-child");

const quotes = [
    {quote:"The man who believes he can do it is probaby right,and so is the man who says he can't..",
    author:"-Charles de Gaulle"},
    {quote:"If you quit ONCE it becomes a habit. Never quit!!!",
    author:"-Michael Jordan"},
    {quote:"모든 일에 있어서 시간이 부족하지 않을까를 걱정하지 말고 다만 내가 마음을 바쳐 최선을 다 할 수 있을지 그것을 걱정하라.",
    author:"-정조"},
    {quote:"Great things are not done by impulse, but a series of small things brought together.",
    author:"-Vincent van Gogh"},
    {quote:"Slow down and enjoy life. It's not only the scenery you miss by going too fast - you also miss the sense of where you are going and why.",
    author:"-Eddie Cantor"}
]

const todayQuote = quotes[Math.floor(Math.random() * quotes.length)]; 
quote.innerText = todayQuote.quote;
author.innerText = todayQuote.author;