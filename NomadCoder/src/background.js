const images = ["kakao1.jpg","kakao2.jpg","kakao3.jpg"];
const randomImage = images[Math.floor(Math.random() * images.length)];
const bgImages = document.createElement("img");

bgImages.src = `./src/img/${randomImage}`;
document.body.appendChild(bgImages);

bgImages.id = "bgImages";

