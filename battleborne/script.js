var tipoProfissao = "";

const guerreiro = document.querySelector("#warrior");
const mago = document.querySelector("#mage");
const arqueiro = document.querySelector("#archer");

function alteraValorProfissao(valor) {
  tipoProfissao = valor;
}

guerreiro.addEventListener("click", function() {
  alteraValorProfissao("Guerreiro");
  activateButton(guerreiro);
});

mago.addEventListener("click", function() {
  alteraValorProfissao("Mago");
  activateButton(mago);
});

arqueiro.addEventListener("click", function() {
  alteraValorProfissao("Arqueiro");
  activateButton(arqueiro);
});

var characterButtons = document.getElementsByClassName('character-button');

for (var i = 0; i < characterButtons.length; i++) {
  characterButtons[i].addEventListener('click', function() {
    activateButton(this);
  });
}

function activateButton(clickedButton) {
  for (var i = 0; i < characterButtons.length; i++) {
    characterButtons[i].classList.remove('active');
  }
  clickedButton.classList.add('active');
}

var mainForm = document.querySelector(".mainForm");

async function submitForm(e) {
  e.preventDefault();
  var nomePersonagem = document.querySelector("#name").value;
  var ataque = document.querySelector("#ataque").value;
  var vida = document.querySelector("#vida").value;
  var defesa = document.querySelector("#defesa").value;

  var data = {
    nomeReq: nomePersonagem,
    profissao: tipoProfissao,
    ataque: Number.parseInt(ataque),
    vida: Number.parseInt(vida),
    defesa: Number.parseInt(defesa)
  };

  const options = {
    method: "POST",
    body: JSON.stringify(data),
    headers: { 'Content-Type': 'application/json' }
  };

  var response = await fetch("http://localhost:8080/session", options);

  console.log(response);
}

mainForm.addEventListener("submit", submitForm);
