package entities;

public class LastMatch {

    public int playerMove, computerMove, result;
    public String resultMessage;

    public LastMatch(int playerMove, int computerMove, int result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
        setResultMessage(result);
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(int result) {
        String message = "";

        switch (result) {
            case 0:
                message = "Vitória do Computador!";
                break;
            case 1:
                message = "Vitória do Jogador!";
                break;
            default:
                message = "Empate!";
                break;
        }

        resultMessage = message;
    }

    public int getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(int playerMove) {
        this.playerMove = playerMove;
    }

    public int getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(int computerMove) {
        this.computerMove = computerMove;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}