<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="StatisticsDao" class="dao.StatisticsDao" scope="application"/>
<jsp:useBean id="lastMatch" class="entities.LastMatch" scope="application"/>
<jsp:useBean id="loggedPlayer" class="entities.Player" scope="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Satistics</title>
    </head>
    <body>
        <h1 style="text-align: center">Jo-Ken-Po</h1>
        <h2 style="text-align: center">Resultado:</h2>

        <section>
            <div class="container">
                <div style="display: flex; justify-content: center">
                    <div style="text-align: center; padding-right: 100px">
                        <h3>Player:</h3>
                        <img src="${lastMatch.playerMove}.png">
                    </div>
                    <div style="padding-top: 5%">
                        <h2>X</h2>
                    </div>
                    <div style="text-align: center; padding-left: 100px">
                        <h3>Computador:</h3>
                        <img src="${lastMatch.computerMove}.png">
                    </div>
                </div>

                <div style="text-align: center">
                    <h3>${lastMatch.resultMessage}</h3>
                </div>

                <div>
                    <h3 style="text-align: center">Estatísticas:</h3>
                    <div style="display: flex; justify-content: center">
                        <h4>Jogos: ${StatisticsDao.readStatistics(loggedPlayer).games}</h4>
                        <h4 style="padding-left: 14px">Vítórias do Jogador: ${StatisticsDao.readStatistics(loggedPlayer).wins}</h4>
                        <h4 style="padding-left: 14px">Vitórias do Computador: ${StatisticsDao.readStatistics(loggedPlayer).losses}</h4>
                        <h4 style="padding-left: 14px">Empates: ${StatisticsDao.readStatistics(loggedPlayer).ties}</h4>
                    </div>
                </div>

                <div style="text-align: center">
                    <a href="move.jsp">
                        <button>Jogar novamente</button>
                    </a>
                </div>
            </div>
        </section>
    </body>
</html>