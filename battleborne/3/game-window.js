var character = JSON.parse(sessionStorage.getItem("personagem"));
var enemy;

var ataqueDuplicado = 0;
var debuff = 0;

if (character["nivel"] !== 3) {
  window.location.href = "/2";
}

function enemyAttack(debuff){
  let attackButtons = Array.from(document.getElementsByClassName("attackButton"));

  attackButtons.forEach(function(button) {
      button.disabled = true;
  });

  setTimeout(function() {
      heroHealthBar = document.querySelector("#heroi > div > progress");
      heroHealthBar.value = (heroHealthBar.value - Math.abs(enemy["ataque"] - (debuff/10)));
      console.log(Math.abs(enemy["ataque"] - (debuff/10)));
  }, 800);

  attackButtons.forEach(function(button) {
      button.disabled = false;
  });
}

function ataque(forca, tipo) {
  enemyHealthBar = document.querySelector("#inimigo > div > progress");
  heroHealthBar = document.querySelector("#heroi > div > progress");

  if (tipo !== undefined) {
    switch (tipo) {
      case "Buff-ataque":
        ataqueDuplicado = forca * 2;
        break;
      case "Buff-cura":
        heroHealthBar.value += (heroHealthBar.max * (forca/100));
        break;
      case "Buff-defesa":
        debuff = forca;
        break;
      case "Ataque":
        if (ataqueDuplicado !== 0) {
          enemyHealthBar.value -= ataqueDuplicado;
        }
        enemyHealthBar.value -= forca;
        ataqueDuplicado = 0;
        break;
    }
  }

  if (enemyHealthBar.value <= 0){
    passarNivel();
  } else {
    enemyAttack(debuff);
    debuff = 0;
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
