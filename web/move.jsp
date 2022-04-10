<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Move</title>
    </head>
    <body>
        <h1 style="text-align: center">Jo-Ken-Po</h1>
        <h2 style="text-align: center">Faça sua jogada:</h2>
        <form method="post" action="move">
            <section>  
                <div class="container">
                    <div style="display: flex; align-items: center; justify-content: center">
                        <div>
                            <img src="images\1.png">
                            <input type="radio" value="1" name="player-move"/>
                        </div>

                        <div>  
                            <img src="images\2.png">
                            <input type="radio" value="2" name="player-move"/>
                        </div>

                        <div>
                            <img src="images\3.png">
                            <input type="radio" value="3" name="player-move"/>
                        </div>
                    </div>

                    <div style="text-align: center; padding-top: 40px">
                        <input type="submit" value="Jogar"> 
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>