package br.com.epdmcorp;

public class UserPoints {
    private int userPoints;

    public UserPoints(){
        this.userPoints = 0;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }
    public void adicionarPontosExercicioLeve() {
        this.userPoints += 5;
    }

    public void adicionarPontosExercicioPesado() {
        this.userPoints += 9;
    }
    public String calcularProporção() {
        if (userPoints >= 15) {
            return "Excelente proporção! Seu corpo agradece esse cuidado.";
        } else if (userPoints >= 7) {
            return "Boa proporção! Continue assim.";
        } else {
            return "Proporção baixa. Seu corpo precisa de mais movimento!";
        }
    }
    public String getImageFace() {
        if (userPoints >= 15) {
            return "/br/com/epdmcorp/images/bom.png";
        } else if (userPoints >= 7) {
            return "/br/com/epdmcorp/images/medio.png";
        } else {
            return "/br/com/epdmcorp/images/ruim.png";
        }
    }
}
