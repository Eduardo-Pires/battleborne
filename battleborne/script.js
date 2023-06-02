var tipoProfissao = "";

const guerreiro = document.querySelector("#warrior")
const mago = document.querySelector("#mage")
const arqueiro = document.querySelector("#archer")

function alteraValorProfissao(valor) {
    tipoProfissao = valor;
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
