var tipoProfissao = "";

const guerreiro = document.querySelector("#warrior");
const mago = document.querySelector("#mage");
const arqueiro = document.querySelector("#archer");

function alteraValorProfissao(valor) {
  tipoProfissao = valor;
}

function alteraValorProfissao(valor) {
    tipoProfissao = valor;
}

function calculaSoma() {
    const range1 =  document.getElementById("ataque");
    const range2 =  document.getElementById("vida");
    const range3 =  document.getElementById("defesa");

    var range1Value = parseInt(range1.value);
    var range2Value = parseInt(range2.value);
    var range3Value = parseInt(range3.value);
    
    var sum = range1Value + range2Value + range3Value;
    
    if (sum > 10) {
        window.alert("Soma maior que 10");
        range1.value = 0;
        range2.value = 0;
        range3.value = 0;
        document.getElementById("sum").textContent = "Soma: " + 0;
    }
    else
    {
        document.getElementById("sum").textContent = "Soma: " + sum;
    }  
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

  try {
    var response = await fetch("http://localhost:8080/session", options);
    if (!response.ok)
    {
        throw new Error(response.statusText);
    }
    else
    {
        response = await fetch(`http://localhost:8080/session/search?nome=${nomePersonagem}`);
        var data = await response.json();
        sessionStorage.setItem("personagem", JSON.stringify(data));
    
        window.location.href = "game_window.html";

    }
    
  }
  catch(error) {
    alert("Erro na criação de personagem, tente mudar o nome do seu herói");
    console.log(error);
  }
}

mainForm.addEventListener("submit", submitForm);
