var character = JSON.parse(sessionStorage.getItem("personagem"));
var enemy;

var ataqueDuplicado = 0;
var debuff = 0;

try {
  if (character["nivel"] !== 2) {
    window.location.href = "/1";
  }
} catch (error) {
  window.location.href = "/";
}

//controla o ataque do inimigo e aplica o debuff de defesa que é utilizado pela classe Guerreiro
function enemyAttack(debuff){
  let attackButtons = Array.from(document.getElementsByClassName("attackButton"));

  attackButtons.forEach(function(button) {
      button.disabled = true;
  });

  setTimeout(function() {
      heroHealthBar = document.querySelector("#heroi > div > progress");
      heroHealthBar.value = (heroHealthBar.value - Math.abs(enemy["ataque"] - (debuff/10)));
      if (heroHealthBar.value < 0) gameOver();
  }, 800);
  setTimeout(() => {
    attackButtons.forEach(function(button) {
      button.disabled = false;
  });
  }, 810);
}

function gameOver() {
  alert("Você foi de Americanas! :)")
  window.location.reload();
}

//utiliza os valores de força e tipo para manipular os ataques do usuário
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

//recebe os ataques da classe do usuário da API
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

//recebe os dados do inimigo na API
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

//muda os nomes dos ataques com base nos ataques da profissão do usuario criado
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

//com base no usuario atual, muda o tamanho da vida e muda a imagem
function formatCharacter(character) {
    heroHealthBar = document.querySelector("#heroi > div > progress");
    heroHealthBar.max = (character['vida'] * 10);

    document.querySelector("#heroi > img").src = `../sprites/static_sprites/${character["profissao"]}.png`;
}

async function passarNivel() {
    var nome = character['nome'];
    var novoNivel = character["nivel"] + 1;

    var data = {
      nivel: novoNivel
    };

    const options = {
      method: "PUT",
      headers: { 'Content-Type': 'application/json' }
    };

    try {
      var response = await fetch(`http://localhost:8080/session/update-level?nome=${nome}&nivel=${novoNivel}`, options);

      if (!response.ok) {
        throw new Error(response.statusText);
      }

      var data = await response.json();
      sessionStorage.setItem("personagem", JSON.stringify(data));

      window.location.href = "/3";
    } catch (error) {
      alert("Erro na atualização do nível do personagem. Tente novamente.");
      console.log(error);
    }
  }

window.onload = async function() {
    if (sessionStorage.length === 0) {
      window.location.href = "http://127.0.0.1:3000/";
    }

    formatCharacter(character);
    formatButtons(character);
    enemy = await getEnemyKit(2);
};
