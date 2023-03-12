const API_KEY="5401ba4735959e586cb95d20c089b9ca";

function nowlocation(position) {
  const lat = position.coords.latitude;
  const lon = position.coords.longitude;
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`;

  fetch(url)
    .then((response) => response.json())
    .then((data) => {
      const weather = document.querySelector(".whetherInfo");
      const city = document.querySelector(".place");
      const weatherIcon = document.querySelector(".weatherIcon");

      const icon = data.weather[0].icon;
      const iconAddr = `http://openweathermap.org/img/wn/${icon}@2x.png`;

      weatherIcon.setAttribute("src", iconAddr);
      city.innerText = `In ${data.name}`;
      weather.innerText = ` 
                        ${data.weather[0].main} 
                         ${Math.round(data.main.temp)}°C`;
    });
}

function locationError() {
  alert("where are youuuuu???");
}

navigator.geolocation.getCurrentPosition(nowlocation, locationError);
