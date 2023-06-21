var tipoProfissao = "";

const guerreiro = document.querySelector("#warrior")
const mago = document.querySelector("#mage")
const arqueiro = document.querySelector("#archer")

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

guerreiro.addEventListener("click", () => alteraValorProfissao("Guerreiro"));
mago.addEventListener("click", () => alteraValorProfissao("Mago"));
arqueiro.addEventListener("click", () => alteraValorProfissao("Arqueiro"));

var mainForm = document.querySelector(".mainForm");

async function submitForm(e) {
    e.preventDefault();
    var nomePersonagem = document.querySelector("#name").value
    var ataque = document.querySelector("#ataque").value
    var vida = document.querySelector("#vida").value
    var defesa = document.querySelector("#defesa").value

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
    }

    var response = await fetch("http://localhost:8080/session", options);

    console.log(response);
}

mainForm.addEventListener("submit", submitForm);
