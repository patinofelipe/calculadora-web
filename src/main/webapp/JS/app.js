console.log("APP.JS FOI CARREGADO");

const botaoCalcular =
    document.getElementById("btnCalcular");

const resultado =
    document.getElementById("resultado");

botaoCalcular.addEventListener("click", async function () {

    const numero1 =
        document.getElementById("numero1").value;

    const numero2 =
        document.getElementById("numero2").value;

    const operacao =
        document.getElementById("operacao").value;

    const dados =
        new URLSearchParams();

    dados.append("numero1", numero1);
    dados.append("numero2", numero2);
    dados.append("operacao", operacao);

    try {

        const resposta =
            await fetch("calculadora", {

                method: "POST",

                headers: {
                    "Content-Type":
                        "application/x-www-form-urlencoded"
                },

                body: dados
            });

        const valor =
            await resposta.text();

        if (!resposta.ok) {

            resultado.textContent =
                "Erro: " + valor;

            return;
        }

        resultado.textContent =
            "Resultado: " + valor;

    } catch (erro) {

        resultado.textContent =
            "Erro de comunicação com o servidor.";

        console.error(erro);
    }

});