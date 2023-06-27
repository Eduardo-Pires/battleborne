var character = JSON.parse(sessionStorage.getItem("personagem"));
var enemy;

if (character["nivel"] !== 3) {
  window.location.href = "/2";
}

function enemyAttack(){
    let attackButtons = Array.from(document.getElementsByClassName("attackButton"));

    attackButtons.forEach(function(button) {
        button.disabled = true;
    });

    setTimeout(function() {
        heroHealthBar = document.querySelector("#heroi > div > progress");
        heroHealthBar.value = (heroHealthBar.value - enemy["ataque"]);
    }, 800);

    attackButtons.forEach(function(button) {
        button.disabled = false;
    });
}

function ataque(forca, tipo) {
  enemyHealthBar = document.querySelector("#inimigo > div > progress");
  enemyHealthBar.value -= forca;
  if (enemyHealthBar.value <= 0){
    passarNivel();
  }else{
      enemyAttack();
  }
}

async function getAttackKit(type) {
  try {
      var response = await fetch(`http://localhost:8080/habilities?profissao=${type}`);
      var data = await response.json();

      return data;
  }
  catch(error) {
      console.log("Ainda não deu");
  }
}

async function getEnemyKit(id) {
  try {
    var response = await fetch(`http://localhost:8080/enemy/${id}`);
    var data = await response.json();

    return data;
}
catch(error) {
    console.log("Ainda não deu");
}
}

async function formatButtons(character) {
  var attackKit = await getAttackKit(character["profissao"]);
  let attackAddOn = character["ataque"]/100;
  let forcaAtaque = 0;

  let buttons = Array.from(document.getElementsByClassName("attackButton"));

  for (let i = 0; i < buttons.length; i++) {
      buttons[i].textContent = attackKit[i].nomeHab;
      forcaAtaque = attackKit[i].forca + attackKit[i].forca * attackAddOn;
      buttons[i].addEventListener("click", () => {
          ataque((attackKit[i].forca)+attackAddOn, attackKit[i].tipo);
      });
  }
}

function formatCharacter(character) {
    heroHealthBar = document.querySelector("#heroi > div > progress");
    heroHealthBar.max = (character['vida'] * 10);

    document.querySelector("#heroi > img").src = `../sprites/static_sprites/${character["profissao"]}.png`;
}

function passarNivel() {
  var eduardo = alert("Cabou o game, pode ir embora");
  eduardo.addEventListener("click", () => {
    window.close();
  });
}
window.onload = async function() {
    if (sessionStorage.length === 0) {
      window.location.href = "http://127.0.0.1:3000/";
    }

    formatCharacter(character);
    formatButtons(character);
    enemy = await getEnemyKit(3);
};
