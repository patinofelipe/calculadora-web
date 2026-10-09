package br.com.calculadora.controller;

import java.io.IOException;

import br.com.calculadora.service.CalculadoraService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final CalculadoraService calculadoraService =
            new CalculadoraService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");

        response.getWriter().println(
                "Calculadora API funcionando!"
        );
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");

        try {

            String numero1Parametro =
                    request.getParameter("numero1");

            String numero2Parametro =
                    request.getParameter("numero2");

            String operacao =
                    request.getParameter("operacao");


            double numero1 =
                    Double.parseDouble(numero1Parametro);

            double numero2 =
                    Double.parseDouble(numero2Parametro);


            double resultado;

            switch (operacao) {

                case "+":
                    resultado =
                            calculadoraService.somar(numero1, numero2);
                    break;

                case "-":
                    resultado =
                            calculadoraService.subtrair(numero1, numero2);
                    break;

                case "*":
                    resultado =
                            calculadoraService.multiplicar(numero1, numero2);
                    break;

                case "/":
                    resultado =
                            calculadoraService.dividir(numero1, numero2);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Operação inválida."
                    );
            }


            response.setStatus(
                    HttpServletResponse.SC_OK
            );

            response.getWriter().println(resultado);


        } catch (NumberFormatException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().println(
                    "Os números informados são inválidos."
            );


        } catch (IllegalArgumentException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().println(
                    e.getMessage()
            );
        }
    }
}